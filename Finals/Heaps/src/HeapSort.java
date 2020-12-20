import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {
  public static List<Integer> sort(List<Integer> unsorted) {
    Heap<Integer> heap = new Heap<Integer>();
    heap.insertAll(unsorted);

    List<Integer> sorted = new ArrayList<Integer>();

    while(heap.size() > 0) {
      Integer item = heap.removeTop();
      if (item != null)
        sorted.add(item);
    }

    // You could also use a Stack to reverse this. 
    Collections.reverse(sorted);
    return sorted;
  }
}