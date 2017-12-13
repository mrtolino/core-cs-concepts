import java.util.*;

public class DataStructures {

  static class Stack<T> {

    private T[] stackArray;   //array container for stack elements
    private int top;          //current top index of the stack

    public Stack(int size) {
      stackArray = (T[])new Object[size];
      top = 0;
    }

    /*
     * Time complexity: O(1) -- instant access to top element
     */
    public T pop() {
      T poppedValue = null;

      if(top > 0) {
        poppedValue = stackArray[top-1];
        stackArray[top-1] = null;
        top--;
      }

      return poppedValue;
    }

    /*
     * Time complexity: O(1) -- instant access to insertion index
     */
    public void push(T value) {
      if (top < stackArray.length) {
        stackArray[top] = value;
        top++;
      }
    }

    /*
     * Time complexity: O(1) -- instant access to top index
     */
    public T peek() {
      if (top > 0) {
        return stackArray[top-1];
      } else {
        return null;
      }
    }

    /*
     * Time complexity: O(1) -- just check value of top
     */
    public boolean isEmpty() {
      if (top == 0) {
        return true;
      } else {
        return false;
      }
    }

    /*
     * Time complexity: O(1) -- just check value of top
     */
    public boolean isFull() {
      if (top == stackArray.length) {
        return true;
      } else {
        return false;
      }
    }


    /*
     * Time complexity: O(n) -- run through entire array to build string
     */
    @Override
    public String toString() {
      String stack = "[";

      for (int index = 0; index < top-1; index++) {
        stack += stackArray[index].toString();
        stack += ", ";
      }
      if (top > 0) {
        stack += stackArray[top-1].toString();
      }
      stack += "]";

      return stack;
    }
  }

}
