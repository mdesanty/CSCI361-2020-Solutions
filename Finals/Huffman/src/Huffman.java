import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Map;
import java.util.HashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman
{
  // This is the Huffman tree.
  private Tree nodes;
  private Map<Character, String> codes;

  public Huffman()
  {
    codes = new HashMap<Character, String>();
  }

  // This populates the nodes attribute from a file.
  public void buildTreeFromFile(String fileName) throws FileNotFoundException
  {
    List<Tree> items = new ArrayList<Tree>();
    populateNodesFromFile(fileName, items);
    nodes = buildTreeFromNodes(items);

    buildCodes(nodes, "");
  }

  private void populateNodesFromFile(String fileName, List<Tree> nodes) throws FileNotFoundException
  {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      String[] data = line.split(",");

      char character = data[0].charAt(0);
      int frequency = Integer.parseInt(data[1]);

      Tree node = new Tree(null, null, character, frequency);
      nodes.add(node);
    }

    scanner.close();
  }

  private Tree buildTreeFromNodes(List<Tree> nodes)
  {
    if(nodes.size() == 1)
    {
      return nodes.get(0);
    }
    else
    {
      Collections.sort(nodes);

      Tree left = nodes.get(0);
      Tree right = nodes.get(1);
      int total = left.getTotal() + right.getTotal();

      Tree newNode = new Tree(left, right, Character.MIN_VALUE, total);

      if(nodes.size() == 2)
        return newNode;

      nodes.remove(left);
      nodes.remove(right);
      nodes.add(newNode);

      return buildTreeFromNodes(nodes);
    }
  }

  private void buildCodes(Tree tree, String code)
  {
    if (tree.isLeaf())
    {
      codes.put(tree.getChar(), code);
      return;
    }

    buildCodes(tree.getLeft(), code + "0");
    buildCodes(tree.getRight(), code + "1");
  }

  public void printTree()
  {
    System.out.println(nodes.toString());
  }

  public String getCode(char ch)
  {
    return codes.get(ch);
  }

  public String encode(String characters)
  {
    String result = "";
    for(char ch : characters.toCharArray())
    {
      result += getCode(ch);
    }

    return result;
  }

  public String decode(String code)
  {
    String result = "";
    Tree node = nodes;

    for (String ch : code.split(""))
    {
      if (ch.equals("0"))
        node = node.getLeft();
      else
        node = node.getRight();

      if (node.isLeaf())
      {
        result += node.getChar();
        node = nodes;
      }
    }

    return result;
  }
}