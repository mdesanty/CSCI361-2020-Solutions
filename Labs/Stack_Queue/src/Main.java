public class Main
{
  public static void main(String[] args)
  {
    Main main = new Main();
    main.testQueue();
  }

  private void testQueue()
  {
    QueueLL<String> strings = new QueueLL<String>();

    strings.enqueue("C");
    strings.enqueue("A");
    strings.enqueue("B");
    System.out.println(strings);

    // Test sort()
    strings.sort();
    System.out.println(strings);

    // Test reverse()
    strings.reverse();
    System.out.println(strings);

    // Print them in dequeue order (reversed).
    while(!strings.isEmpty())
    {
      System.out.println(strings.dequeue());
    }
  }
}