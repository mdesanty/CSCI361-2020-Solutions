import java.util.List;
import java.util.ArrayList;

public class Schedule {
  private List<Course> m_courses;

  public Schedule() {
    m_courses = new ArrayList<Course>();
  }

  public void addCourse(Course c) {
    m_courses.add(c);
  }

  @Override
  public String toString() {
    String schedule = "Your schedule";
    for(Course course : m_courses) {schedule = schedule + "\n" + course.toString();}

    return schedule;
  }
}