import java.util.Arrays;

public class Sort {

  public static int [] mergeSort(int [] values) {
    int [] left, right;
    int temp;

    //no need to sort in this case
    if (values.length < 2)
      return values;

    left = Arrays.copyOfRange(values, 0, values.length/2);
    right = Arrays.copyOfRange(values, values.length/2, values.length);

    if (left.length > 2) {
      left = mergeSort(left);
    } else if (left.length == 2) {
      if (left[0] > left[1]) {
        temp = left[0];
        left[0] = left[1];
        left[1] = temp;
      }
    }

    if (right.length > 2) {
      right = mergeSort(right);
    } else if (right.length == 2) {
      if (right[0] > right[1]) {
        temp = right[0];
        right[0] = right[1];
        right[1] = temp;
      }
    }

    return merge(left, right);
  }

  private static int [] merge(int [] left, int [] right)
  {
    int [] merged = new int[left.length + right.length];
    int indexLeft = 0, indexRight = 0, index = 0;

    //merge left and right arrays into merged array
    while(indexLeft < left.length && indexRight < right.length) {
      if (left[indexLeft] < right[indexRight]) {
        merged[index] = left[indexLeft];
        indexLeft++;
      } else {
        merged[index] = right[indexRight];
        indexRight++;
      }
      index++;
    }

    //add leftover left or right array elements to the merged array
    if (indexLeft < left.length) {
      while(indexLeft < left.length) {
        merged[index] = left[indexLeft];
        indexLeft++;
        index++;
      }
    } else if (indexRight < right.length) {
      while(indexRight < right.length) {
        merged[index] = right[indexRight];
        indexRight++;
        index++;
      }
    }

    return merged;
  }
}
