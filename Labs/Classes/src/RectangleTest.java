public class RectangleTest {
  public static void main(String[] args) {
    RectangleTest test = new RectangleTest();
    test.execute();
  }

  private void execute() {
    Rectangle rectangle1 = new Rectangle(2, 4);
    System.out.println("Renctangle1:");
    printRectangle(rectangle1);
    System.out.println();

    Rectangle rectangle2 = new Rectangle();
    System.out.println("Renctangle2:");
    printRectangle(rectangle2);
    System.out.println();
  }

  private void printRectangle(Rectangle rectangle) {
    System.out.println("Width: " + rectangle.getWidth());
    System.out.println("Height: " + rectangle.getHeight());
    System.out.println("Erea: " + rectangle.getArea());
    System.out.println("Perimeter: " + rectangle.getPerimeter());
  }
}
