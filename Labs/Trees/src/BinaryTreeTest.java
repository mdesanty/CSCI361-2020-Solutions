public class BinaryTreeTest
{
  public static void main(String[] args)
  {
    BinaryTreeTest test = new BinaryTreeTest();
    test.testBinaryTree();
  }

  private void testBinaryTree()
  {
    BinaryTree<String> leftStringTree = new BinaryTree<String>("Level 1 Left");
    BinaryTree<String> rightStringTree = new BinaryTree<String>("Level 1 Right");
    BinaryTree<String> stringTree = new BinaryTree<String>("Root Value", leftStringTree, rightStringTree);
    System.out.println(stringTree.toString());

    BinaryTree<Integer> leftIntegerTree = new BinaryTree<Integer>(1);
    BinaryTree<Integer> rightIntegerTree = new BinaryTree<Integer>(2);
    BinaryTree<Integer> integerTree = new BinaryTree<Integer>(0, leftIntegerTree, rightIntegerTree);
    System.out.println(integerTree.toString());

    // More complex tree
    // Level 3 trees (leaves with null left and right)
    BinaryTree<String> stringTree3_1 = new BinaryTree<String>("3_1");
    BinaryTree<String> stringTree3_2 = new BinaryTree<String>("3_2");
    BinaryTree<String> stringTree3_3 = new BinaryTree<String>("3_3");
    BinaryTree<String> stringTree3_4 = new BinaryTree<String>("3_4");
    BinaryTree<String> stringTree3_5 = new BinaryTree<String>("3_5");
    BinaryTree<String> stringTree3_6 = new BinaryTree<String>("3_6");
    BinaryTree<String> stringTree3_7 = new BinaryTree<String>("3_7");
    BinaryTree<String> stringTree3_8 = new BinaryTree<String>("3_8");

    // Level 2 trees
    BinaryTree<String> stringTree2_1 = new BinaryTree<String>("2_1", stringTree3_1, stringTree3_2);
    BinaryTree<String> stringTree2_2 = new BinaryTree<String>("2_2", stringTree3_3, stringTree3_4);
    BinaryTree<String> stringTree2_3 = new BinaryTree<String>("2_3", stringTree3_5, stringTree3_6);
    BinaryTree<String> stringTree2_4 = new BinaryTree<String>("2_4", stringTree3_7, stringTree3_8);

    // Level 1 trees
    BinaryTree<String> stringTree1_1 = new BinaryTree<String>("1_1", stringTree2_1, stringTree2_2);
    BinaryTree<String> stringTree1_2 = new BinaryTree<String>("1_2", stringTree2_3, stringTree2_4);

    // Root tree
    BinaryTree<String> rootStringTree = new BinaryTree<String>("Root", stringTree1_1, stringTree1_2);

    System.out.println();
    System.out.println("Complex tree");
    System.out.println(rootStringTree);

    /** Output should be
    Complex tree

    3_1
    2_1
    3_2
    1_1
    3_3
    2_2
    3_4
    Root
    3_5
    2_3
    3_6
    1_2
    3_7
    2_4
    3_8
    */
  }
}