public class Controller {

  public static void main(String[] args) {
    int [] values = {};

    values = Sort.mergeSort(values);

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
