public class CombinationCounter {
  public static int getCombinationsCount(int n, int k) {
    if(k == 0 || n == 0 || k == n)
      return 1;
    else
      return getCombinationsCount(n - 1, k) + getCombinationsCount(n - 1, k - 1);
  }
}