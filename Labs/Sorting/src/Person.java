public class Person implements Comparable<Person>
{
  private String name;
  private int age;

  public Person()
  {
    setName("");
    setAge(0);
  }

  public Person(String name, int age)
  {
    setName(name);
    setAge(age);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public int getAge()
  {
    return age;
  }

  @Override
  public int compareTo(Person other)
  {
    return other.getAge() - getAge();
  }

  @Override
  public String toString()
  {
    return String.format("%s (%s)", getName(), getAge());
  }
}