import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(86, 13, 42, 11, 6, 9, 8, 27));
    System.out.println(numbers); // Expected output: [86, 13, 42, 11, 6, 9, 8, 27]

    List<Integer> sorted = HeapSort.sort(numbers);
    System.out.println(sorted); // Expected output: [6, 8, 9, 11, 13, 27, 42, 86]
  }
}