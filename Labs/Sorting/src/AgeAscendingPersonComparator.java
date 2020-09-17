import java.util.Comparator;

public class AgeAscendingPersonComparator implements Comparator<Person>
{
  @Override
  public int compare(Person person, Person otherPerson)
  {
    if(person.getAge() < otherPerson.getAge())
    {
      return -1;
    }
    else if(person.getAge() > otherPerson.getAge())
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
}