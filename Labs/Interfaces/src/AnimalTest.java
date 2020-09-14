public class AnimalTest {
  public static void main(String[] args) {
    AnimalTest test = new AnimalTest();
    test.execute();
  }

  private void execute() {
    testPig();
    testDuck();
  }

  private void testPig() {
    Pig piggy = new Pig("Mr Piggy");
    System.out.println(piggy.makeSound());
  }

  private void testDuck() {
    Duck ducky = new Duck("Ms Ducky");
    System.out.println(ducky.makeSound());
  }
}