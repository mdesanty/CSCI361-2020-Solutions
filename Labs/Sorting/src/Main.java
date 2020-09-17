import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
  public static void main(String[] args)
  {
    Main main = new Main();
    main.testSorting();
  }

  private void testSorting()
  {
    Person alice = new Person("Alice", 53);
    Person joe = new Person("Joe", 8);
    Person mike = new Person("Mike", 38);
    Person jon = new Person("Jon", 37);

    List<Person> people = new ArrayList<Person>();

    people.add(alice);
    people.add(joe);
    people.add(mike);
    people.add(jon);

    System.out.println("Unsorted: ");
    System.out.println(people);

    Collections.sort(people);

    System.out.println("Sorted: ");
    System.out.println(people);

    Collections.sort(people, new AgeAscendingPersonComparator());
    System.out.println("Sorted - Age Desc: ");
    System.out.println(people);
  }
}