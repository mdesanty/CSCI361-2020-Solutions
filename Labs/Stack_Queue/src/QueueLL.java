import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class QueueLL<T extends Comparable<T>> implements IQueue<T>
{
  private Node m_tail;
  private int m_count;

  public QueueLL()
  {
    m_tail = new Node(null);
    m_count = 0;
  }

  public void reverse()
  {
    StackLL<T> stack = new StackLL<T>();
    while(!isEmpty())
    {
      stack.push(dequeue());
    }

    while(!stack.isEmpty())
    {
      enqueue(stack.pop());
    }
  }

  public void sort()
  {
    List<T> items = new ArrayList<T>();

    while(!isEmpty())
    {
      items.add(dequeue());
    }

    Collections.sort(items);

    for(T item : items)
    {
      enqueue(item);
    }
  }

  @Override
  public void enqueue(T item)
  {
    Node n = new Node(item);
    n.m_next = m_tail.m_next;
    m_tail.m_next = n;
    m_count++;
  }

  @Override
  public T dequeue()
  {
    if (isEmpty())
      throw new IllegalStateException("dequeue error: queue is empty!");

    T ret = null;
    Node cur = m_tail;

    // while not at the tail...
    while (cur.m_next != null)
    {
      // if I am at the second from the tail of the queue...
      if (cur.m_next.m_next == null)
      {
        // grab the data from the last item in the queue...
        ret = cur.m_next.m_data;
        // detatch the last item in the queue...
        cur.m_next = null;

        break;
      }
      else
      {
        // otherwise, continue moving towards the tail of the queue...
        cur = cur.m_next;
      }
    }

    m_count--;
    return ret;
  }

  @Override
  public boolean isEmpty()
  {
    return getSize() == 0;
  }

  @Override
  public int getSize()
  {
    return m_count;
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer("rear->");
    if (!isEmpty())
    {
      Node node = m_tail.m_next;
      sb.append(node.m_data.toString());
      while (node.m_next != null)
      {
        node = node.m_next;
        sb.append("->");
        sb.append(node.m_data.toString());
      }
    }

    return sb.toString();
  }

  private class Node
  {
    private T m_data;
    private Node m_next;

    public Node(T data)
    {
      m_data = data;
      m_next = null;
    }
  }
}