import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Plates
{
  private Map<String, Integer> plateMap;

  public Plates()
  {
     plateMap = new HashMap<String, Integer>();
  }

  public void buildMap() throws FileNotFoundException
  {
    // (Empty for students) enter your code here...
    File file = new File("plates.txt");
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      String[] data = line.split("\\s+");

      for(String word : data)
      {
        String plateState = sanitizeWord(word);

        if(!plateMap.containsKey(plateState))
          plateMap.put(plateState, 0);

        plateMap.put(plateState, plateMap.get(plateState) + 1);
      }
    }
    scanner.close();
  }

  public void printCounts()
  {
    System.out.println("Number of Plates: " + plateMap.keySet().size());
    for (String key : plateMap.keySet())
      System.out.printf("%s -> %s%n", key, plateMap.get(key));
  }
  
  private String sanitizeWord(String word)
  {
    String sanitizedWord = word.toUpperCase();
    return sanitizedWord.replaceAll("[^A-Z]", "");
  }
}