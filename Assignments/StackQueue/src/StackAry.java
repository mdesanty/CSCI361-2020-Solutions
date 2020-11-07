/**
 * <p>Concreted class for a Stack that is backed by an array.</p>
 * <p>Created for CSCI361 at MCLA</p>
 *
 * @author Mark.Cohen@mcla.edu
 *
 * @param <T> the data type of the elements contained in the stack.
 */
public class StackAry<T> implements IStack<T>
{
  private static final int CHUNK_SIZE = 1;

  private T[] m_elements;
  private int m_count;

  @SuppressWarnings("unchecked")
  public StackAry()
  {
    m_elements = (T[])new Object[0];
  }

  public void push(T item)
  {
    // if the array needs to grow, it runs in linear time
    /// other wise it runs in constant time...

    grow();
    m_elements[getSize()] = item;
    m_count++;
  }

  public T pop()
  {
    // runs in constant time...

    if (isEmpty())
      throw new IllegalStateException("pop error: stack is empty!");

    m_count--;
    T ret = m_elements[getSize()];
    m_elements[getSize()] = null;

    return ret;
  }

  public T top()
  {
    // runs in constant time...

    if (isEmpty())
      throw new IllegalStateException("top error: stack is empty!");

    T ret = m_elements[getSize()-1];

    return ret;
  }

  public boolean isEmpty()
  {
    // runs in constant time...

    return getSize() == 0;
  }

  public int getSize()
  {
    // runs in constant time...

    return m_count;
  }

  public String toString()
  {
    // runs in linear time...

    StringBuffer sb = new StringBuffer("top->");
    if (!isEmpty())
    {
      sb.append(m_elements[getSize()-1].toString());
      for (int i = getSize()-1; i > 0; i--)
      {
        sb.append("->");
        sb.append(m_elements[i-1]);
      }
    }
    return sb.toString();
  }

  private void grow()
  {
    // runs in linear time if the stack needs to grow...
    if (getSize() == m_elements.length)
    {
      @SuppressWarnings("unchecked")
      T[] temp = (T[])new Object[m_elements.length + CHUNK_SIZE];
      for (int i = 0; i < m_elements.length; i++)
      {
        temp[i] = m_elements[i];
      }
      m_elements = temp;
    }
  }

}