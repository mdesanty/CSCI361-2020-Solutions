public class Fibonacci {
  public static int valueAtPosition(int n) {
    if(n == 0 || n == 1) return n;
    return valueAtPosition(n - 1) + valueAtPosition(n - 2);
  }
}