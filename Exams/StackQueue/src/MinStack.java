public class MinStack<T extends Comparable<T>> implements IStack<T>
{
  private StackLL<T> items;
  private StackLL<T> minItems;

  public MinStack()
  {
    items = new StackLL<T>();
    minItems = new StackLL<T>();
  }

  @Override
  public void push(T item)
  {
    items.push(item);

    if(minItems.isEmpty() || item.compareTo(minItems.top()) < 0)
      minItems.push(item);
  }

  @Override
  public T pop()
  {
    T poppedItem = items.pop();

    if(poppedItem.compareTo(minItems.top()) == 0)
      minItems.pop();

    return poppedItem;
  }

  @Override
  public T top()
  {
    return items.top();
  }

  @Override
  public boolean isEmpty()
  {
    return items.isEmpty();
  }

  @Override
  public int getSize()
  {
    return items.getSize();
  }

  public T getMinItem()
  {
    return minItems.top();
  }

  @Override
  public String toString()
  {
    return items.toString();
  }
}
