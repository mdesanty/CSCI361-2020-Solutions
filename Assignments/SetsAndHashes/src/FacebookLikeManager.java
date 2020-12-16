import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FacebookLikeManager {
  private Map<String, Set<String>> likesFor;
  private Map<String, Set<String>> likesBy;

  public FacebookLikeManager() {
    likesFor = new HashMap<String, Set<String>>();
    likesBy = new HashMap<String, Set<String>>();
  }

  public List<String> getAllUsers() {
    Set<String> users = new HashSet<String>();
    users.addAll(likesFor.keySet());
    users.addAll(likesBy.keySet());

    List<String> allUsers = new ArrayList<String>(users);
    return allUsers;
  }

  public List<String> getLikes(String user) {
    List<String> users = new ArrayList<String>(likesFor.get(user));
    return users;
  }

  public List<String> getLikedBy(String user) {
    List<String> users = new ArrayList<String>(likesBy.get(user));
    return users;
  }

  public void loadFile(String filePath) throws FileNotFoundException {
    File file = new File(filePath);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      processLine(line);
    }

    scanner.close();
  }

  private void processLine(String line) {
    String[] lineData = line.split(":|,");
    String user = lineData[0].trim();

    List<String> likers = new ArrayList<String>();
    for(String liker : Arrays.copyOfRange(lineData, 1, lineData.length))
      likers.add(liker.trim());

    processLikesFor(user, likers);
    processLikesBy(user, likers);
  }

  private void processLikesFor(String user, List<String> likers) {
    if(!likesFor.containsKey(user))
      likesFor.put(user, new HashSet<String>());

    likesFor.get(user).addAll(likers);
  }

  private void processLikesBy(String user, List<String> likers) {
    for(String liker : likers) {
      if(!likesBy.containsKey(liker))
        likesBy.put(liker, new HashSet<String>());

      likesBy.get(liker).add(user);
    }
  }
}