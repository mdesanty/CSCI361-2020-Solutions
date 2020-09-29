public class Power {
  public static int power(int num, int pow) {
    if(pow == 0) return 1;
    return num * power(num, pow - 1);
  }
}