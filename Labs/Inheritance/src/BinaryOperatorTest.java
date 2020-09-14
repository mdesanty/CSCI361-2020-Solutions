public class BinaryOperatorTest {
  public static void main(String[] args) {
    BinaryOperatorTest test = new BinaryOperatorTest();
    test.execute();
  }

  private void execute() {
    testSum();
    System.out.println();

    testDiff();
    System.out.println();
  }

  private void testSum() {
    IBinaryOperator sum = new Sum(0, 0);

    System.out.println("Operand 1: " + sum.getOperand1());
    System.out.println("Operand 2: " + sum.getOperand2());
    System.out.println("Sum: " + sum.operate());
    System.out.println();

    sum.setOperand1(4);
    sum.setOperand2(6);

    System.out.println("Operand 1: " + sum.getOperand1());
    System.out.println("Operand 2: " + sum.getOperand2());
    System.out.println("Sum: " + sum.operate());
  }

  private void testDiff() {
    IBinaryOperator diff = new Diff(0, 0);

    System.out.println("Operand 1: " + diff.getOperand1());
    System.out.println("Operand 2: " + diff.getOperand2());
    System.out.println("Difference: " + diff.operate());
    System.out.println();

    diff.setOperand1(8);
    diff.setOperand2(7);

    System.out.println("Operand 1: " + diff.getOperand1());
    System.out.println("Operand 2: " + diff.getOperand2());
    System.out.println("Difference: " + diff.operate());
  }
}