import java.lang.Math;

public class Controller {

  private static final int SIZE = 10;

  public static void main(String[] args) {
    int [] values = new int[SIZE];

    for (int index = 0; index < values.length; index++) {
      values[index] = (int)(Math.random()*1000);
    }

    printArray(values);
    values = Sort.quicksort(values, 0, SIZE-1);
    printArray(values);
  }

  private static void printArray(int [] values) {
    System.out.print("[");
    if (values.length > 0) {
      for (int index = 0; index < values.length-1; index++) {
        System.out.print(values[index] + ", ");
      }
      System.out.print(values[values.length-1]);
    }
    System.out.println("]");
  }
}
