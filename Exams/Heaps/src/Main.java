import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
  public static void main(String[] args) {
    Main main = new Main();
    main.go();
  }

  public void go() {
    // Valid max heap
    int ary[] = {82, 79, 46, 16, 12, 39, 41, 6, 4, 11};
    /*
    *             82
    *         /         \
    *       79          46
    *     /     \     /   \
    *   16      12   39   41
    *  /  \    /
    * 6    4  11
    */
    System.out.printf("Root: %s%n", getRoot(ary)); // Expected output: Root: 82
    System.out.printf("Leaves: %s%n", getAllLeaves(ary)); // Expected output: Leaves: [39, 41, 6, 4, 11]
    System.out.printf("Parents: %s%n", getAllParents(ary)); // Expected output: Parents: [82, 79, 46, 16, 12]
    System.out.printf("Is MaxHeap: %s%n", isMaxHeap(0, ary)); // Expected output: Is MaxHeap: true
  }

  // ---------------------------------------------------------------
  // return the value of the root of the tree represented by ary
  // ---------------------------------------------------------------
  public int getRoot(int ary[]) {
    // Since we are dealing with a primitive int type here, I will just opt to let the error happen if the arry is empty.
    // If we were using Integer instead, I would return null when the array is empty.
    return ary[0];
  }

  // ---------------------------------------------------------------
  // return a list containing the values for all of the nodes in the
  // tree that are leaves
  // ---------------------------------------------------------------
  public List getAllLeaves(int ary[]) {
    List<Integer> leaves = new ArrayList<Integer>();

    if(ary.length == 0)
      return leaves;

    int maxIndex = getMaxIndex(ary);
    for(int i = 0; i <= maxIndex; i++) {
      if(getLeftChildIndex(i) > maxIndex)
        leaves.add(ary[i]);
    }

    return leaves;
  }

  // ---------------------------------------------------------------
  // return a list containing the values for all of the nodes in the
  // tree that are parents
  // ---------------------------------------------------------------
  public List getAllParents(int ary[]) {
     List<Integer> parents = new ArrayList<Integer>();

     if(ary.length == 0)
       return parents;

     int currentIndex = 0;

     while(currentIndex < ary.length && getLeftChildIndex(currentIndex) < ary.length) {
       parents.add(ary[currentIndex]);
       currentIndex++;
     }

     return parents;
  }

  // ---------------------------------------------------------------
  // return true if the tree represented by ary is a valid max heap
  // ---------------------------------------------------------------
  public boolean isMaxHeap(int rootIndex, int ary[]) {
    for (int i = 1; i < ary.length; i++) {
      if (ary[getParentIndex(i)] < ary[i])
        return false;
    }

    return true;
  }

  private int getMaxIndex(int ary[]) {
    return ary.length - 1;
  }

  private int getLeftChildIndex(int currentIndex) {
    return currentIndex * 2 + 1;
  }

  private int getRightChildIndex(int currentIndex) {
    return currentIndex * 2 + 2;
  }

  private int getParentIndex(int currentIndex) {
    return (currentIndex - 1) / 2;
  }
}