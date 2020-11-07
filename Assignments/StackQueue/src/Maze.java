import java.util.Scanner;

public class Maze
{
  private int m_x;
  private int m_y;
  private IStack<String> m_undoStack;
  private IStack<String> m_redoStack;

  private char m_maze[][] = new char[][]
  {
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'},
    {'-','-','-', '-', '-','-', '-', '-', '-', '-'}
  };

  public Maze()
  {
    m_x = 0;
    m_y = 0;
    m_undoStack = new StackAry<String>();
    m_redoStack = new StackAry<String>();
  }

  public static void main(String[] args)
  {
    Maze maze = new Maze();
    maze.go();
  }

  public void go()
  {
    while (true)
	  {
      printMaze();
      menu();
    }
  }

  public void printMaze()
  {
    for (int r = 0; r < 10; r++)
    {
      for (int c = 0; c < 10; c++)
      {
        if (r == m_y && c == m_x)
          System.out.print("* ");
        else
          System.out.print(m_maze[r][c] + " ");
      }
      System.out.println();
    }
  }

  public void menu()
  {
    System.out.println("");
    System.out.println("What have you mage?");
    System.out.println("N: North");
    System.out.println("S: South");
    System.out.println("E: East");
    System.out.println("W: West");
    System.out.println("G: Grog");
    System.out.println("U: Undo");
    System.out.println("R: Redo");
    System.out.println("Q: Quit");

    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String response = in.nextLine();

    if (!response.equals("U") && !response.equals("R"))
      m_redoStack = new StackAry<String>();

    handleMove(response, m_undoStack);

    System.out.println();
    System.out.println("Undo Stack: " + m_undoStack);
    System.out.println("Redo Stack: " + m_redoStack);
    System.out.println();
  }

  private void moveNorth(IStack<String> stack)
  {
    if (m_y > 0)
    {
      m_y--;
      stack.push("S");
    }
    else
    {
      System.out.println("Ouch!");
    }
  }

  private void moveSouth(IStack<String> stack)
  {
    if (m_y < 9)
    {
      m_y++;
      stack.push("N");
    }
    else
    {
      System.out.println("Ouch!");
    }
  }

  private void moveEast(IStack<String> stack)
  {
    if (m_x < 9)
    {
      m_x++;
      stack.push("W");
    }
    else
    {
      System.out.println("Ouch!");
    }
  }

  private void moveWest(IStack<String> stack)
  {
    if (m_x > 0)
    {
      m_x--;
      stack.push("E");
    }
    else
    {
      System.out.println("Ouch!");
    }
  }

  private void drink(IStack<String> stack)
  {
    System.out.println("Gulp!");
    stack.push("P");
  }

  private void undrink(IStack<String> stack)
  {
    System.out.println("Blah!");
    stack.push("G");
  }

  private void handleMove(String s, IStack<String> stack)
  {
    if (s.equals("N"))
      moveNorth(stack);
    else if (s.equals("S"))
      moveSouth(stack);
    else if (s.equals("E"))
      moveEast(stack);
    else if (s.equals("W"))
      moveWest(stack);
    else if (s.equals("P"))
      undrink(stack);
    else if (s.equals("G"))
      drink(stack);
    else if (s.equals("U"))
    {
      if (m_undoStack.isEmpty())
      {
        System.out.println("Nothing to undo!");
      }
      else
      {
        String u = m_undoStack.pop();
        handleMove(u, m_redoStack);
      }
    }
    else if (s.equals("R"))
    {
      if (m_redoStack.isEmpty())
      {
        System.out.println("Nothing to redo!");
      }
      else
      {
        String u = m_redoStack.pop();
        handleMove(u, m_undoStack);
      }
    }
    else if (s.equals("Q"))
    {
      System.out.println("Safe journy mage!");
      System.exit(0);
    }
    else
    {
      System.out.println("Huh?");
    }
  }
}