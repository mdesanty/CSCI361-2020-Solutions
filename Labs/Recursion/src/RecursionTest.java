public class RecursionTest {
  public static void main(String[] args) {
    RecursionTest test = new RecursionTest();

    test.testPower();
    System.out.println();

    test.testFibonacci();
  }

  private static void testPower() {
    System.out.println("Power 4 ^ 1: " + Power.power(4, 1));
    System.out.println("Power 4 ^ 2: " + Power.power(4, 2));
    System.out.println("Power 4 ^ 3: " + Power.power(4, 3));
    System.out.println("Power 4 ^ 4: " + Power.power(4, 4));
  }

  private static void testFibonacci() {
    for(int i = 0; i < 10; i++) {
      System.out.println("Fibonacci value at position " + i + ": " + Fibonacci.valueAtPosition(i));
    }
  }
}