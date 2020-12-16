import java.io.FileNotFoundException;
import java.util.List;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    FacebookLikeManager manager = new FacebookLikeManager();
    manager.loadFile("users.txt");

    System.out.println("All users: " + manager.getAllUsers()); // Expected output: All users: [Nate, Mike, Anthony, Steve, Kristen, Randy, Bill, John, Sara]

    System.out.println("Users that like Mike: " + manager.getLikes("Mike")); // Expected output: Users that like Mike: [Kristen, Sara, Nate, Anthony, Randy]
    System.out.println("Users that like Kristen: " + manager.getLikes("Kristen")); // Expected output: Users that like Kristen: [Mike, John, Steve, Bill]
    System.out.println("Users that like Bill: " + manager.getLikes("Bill")); // Expected output: Users that like Bill: [Sara, Nate]
    System.out.println("Users that like Sara: " + manager.getLikes("Sara")); // Expected output: Users that like Sara: [Nate, Anthony]

    System.out.println("Users that are liked by Kristen: " + manager.getLikedBy("Kristen")); // Expected output: Users that are liked by Kristen: [Mike]
    System.out.println("Users that are liked by Sara: " + manager.getLikedBy("Sara")); // Expected output: Users that are liked by Sara: [Mike, Bill]
    System.out.println("Users that are liked by Nate: " + manager.getLikedBy("Nate")); // Expected output: Users that are liked by Nate: [Mike, Bill, Sara]
    System.out.println("Users that are liked by Anthony: " + manager.getLikedBy("Anthony")); // Expected output: Users that are liked by Anthony: [Mike, Sara]
    System.out.println("Users that are liked by Randy: " + manager.getLikedBy("Randy")); // Expected output: Users that are liked by Randy: [Mike]
    System.out.println("Users that are liked by Mike: " + manager.getLikedBy("Mike")); // Expected output: Users that are liked by Mike: [Kristen]
    System.out.println("Users that are liked by John: " + manager.getLikedBy("John")); // Expected output: Users that are liked by John: [Kristen]
    System.out.println("Users that are liked by Steve: " + manager.getLikedBy("Steve")); // Expected output: Users that are liked by Steve: [Kristen]
    System.out.println("Users that are liked by Bill: " + manager.getLikedBy("Bill")); // Expected output: Users that are liked by Bill: [Kristen]    
  }
}