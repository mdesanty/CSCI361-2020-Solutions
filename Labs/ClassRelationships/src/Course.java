public class Course {
  private String m_title;
  private String m_start;
  private String m_end;

  public Course(String title, String start, String end) {
    m_title = title;
    m_start = start;
    m_end = end;
  }

  public String getTitle() {
    return m_title;
  }

  public String getStart() {
    return m_start;
  }

  public String getEnd() {
    return m_end;
  }

  @Override
  public String toString() {
    return String.format("%s: %s - %s", getTitle(), getStart(), getEnd());
  }
}