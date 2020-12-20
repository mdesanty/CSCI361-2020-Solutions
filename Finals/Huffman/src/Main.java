import java.util.List;
import java.util.ArrayList;

public class Main
{
  /*
  * tree.txt should produce this tree:
  *      16
  *     / \
  *    6   Z
  *   / \
  *  A   D
  *
  * A (1), D (5), Z (10)
  *
  * Codes:
  * A: 00
  * D: 01
  * Z: 1
  *
  * Preorder Traversal:
  * 16, 6, 1 (A), 5 (D), 10 (Z)
  */
  public static void main(String[] args) throws Exception
  {
    Huffman huff = new Huffman();    
    huff.buildTreeFromFile("tree.txt");

    // Print the tree:
    System.out.println("printTree tests:");
    huff.printTree(); // Expected output: [16: , 6: , 1:A, 5:D, 10:Z]

    // Get some codes:
    System.out.println("getCode tests:");
    System.out.println(huff.getCode('A')); // Expected output: 00
    System.out.println(huff.getCode('D')); // Expected output: 01
    System.out.println(huff.getCode('Z')); // Expected output: 1

    // Do some decoding:
    System.out.println("decode tests:");
    System.out.println("1 decoded as: " + huff.decode("1")); // Expected output: Z
    System.out.println("00 decoded as: " + huff.decode("00")); // Expected output: A
    System.out.println("01 decoded as: " + huff.decode("01")); // Expected output: D
    System.out.println("1111100 decoded as: " + huff.decode("1111100")); // Expected output: ZZZZZA
    System.out.println("10001 decoded as: " + huff.decode("10001")); // Expected output: ZAD

    // Do some encoding:
    System.out.println("encode tests:");
    System.out.println("ZAD encoded as: " + huff.encode("ZAD")); // Expected output: 10001
    System.out.println("ZZZZZA encoded as: " + huff.encode("ZZZZZA")); // Expected output: 1111100
  }
}
