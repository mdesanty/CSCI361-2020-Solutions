import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();

    main.testRemoveCharacter();
    System.out.println();
    main.testCombinationCounter();
  }

  private void testRemoveCharacter() {
    Scanner in = new Scanner(System.in);

  	System.out.print("Enter string: ");
  	String str = in.next();

    System.out.print("Enter character: ");
  	char character = in.next().charAt(0);

    System.out.println(str + " without " + character + ": " + StringChanger.removeCharacter(str, character));
  }

  private void testCombinationCounter() {
    Scanner in = new Scanner(System.in);

  	System.out.print("Enter n: ");
  	int n = in.nextInt();

    System.out.print("Enter k: ");
  	int k = in.nextInt();

    System.out.println("Possible combinations: " + CombinationCounter.getCombinationsCount(n, k));
  }
}