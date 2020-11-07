public class Main
{
  public static void main(String[] args)
  {
    Main main = new Main();
    main.testMiniStack();
  }

  private void testMiniStack()
  {
    MinStack<String> numbers = new MinStack<String>();

    numbers.push("4");
    numbers.push("2");
    numbers.push("3");
    System.out.println(numbers.toString());
    System.out.println(numbers.getMinItem()); // Should be 2

    numbers.push("1");
    System.out.println(numbers.toString());
    System.out.println(numbers.getMinItem()); // Should be 1

    numbers.pop();
    System.out.println(numbers.toString());
    System.out.println(numbers.getMinItem()); // Should be 2

    numbers.pop();
    System.out.println(numbers.toString());
    System.out.println(numbers.getMinItem()); // Should be 2

    numbers.pop();
    System.out.println(numbers.toString());
    System.out.println(numbers.getMinItem()); // Should be 4

    numbers.pop();
    try
    {
      System.out.println(numbers.getMinItem()); // Should raise IllegalStateException
    }
    catch(IllegalStateException ex)
    {
      System.out.println("IllegalStateException caught");
    }

    MinStack<Integer> integers = new MinStack<Integer>();

    integers.push(2);
    integers.push(4);
    integers.push(3);
    System.out.println(integers.toString());
    System.out.println(integers.getMinItem()); // Should be 2
  }
}
