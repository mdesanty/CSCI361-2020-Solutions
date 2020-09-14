public class ScheduleTest {
  public static void main(String[] args) {
    ScheduleTest test = new ScheduleTest();
    test.execute();
  }

  private void execute() {
    Course networking = new Course("Networking", "8am", "8:50am");
    Course database = new Course("Database", "9am", "9:50am");
    Course webDevelopment = new Course("Web Development", "10am", "10:50am");
    Course java = new Course("Java", "12pm", "12:50pm");
    Course yoga = new Course("Yoga", "1pm", "1:50pm");

    Schedule mySchedule = new Schedule();
    mySchedule.addCourse(networking);
    mySchedule.addCourse(database);
    mySchedule.addCourse(webDevelopment);
    mySchedule.addCourse(java);
    mySchedule.addCourse(yoga);

    System.out.println(mySchedule.toString());
  }
}