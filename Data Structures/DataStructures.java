import java.util.*;

public class DataStructures {

  static class Stack {

    private int[] stackArray;
    private int top;

    public Stack(int size) {
      stackArray = new int[size];
      top = 0;
    }

    public int pop() {
      int poppedValue = 0;

      if(top > 0) {
        poppedValue = stackArray[top-1];
        stackArray[top-1] = 0;
        top--;
      }

      return poppedValue;
    }

    public void push(int value) {
      if (top < stackArray.length) {
        stackArray[top] = value;
        top++;
      }
    }

    public int peek() {
      if (top > 0) {
        return stackArray[top-1];
      } else {
        return 0;
      }
    }

    public boolean isEmpty() {
      if (top == 0) {
        return true;
      } else {
        return false;
      }
    }

    public boolean isFull() {
      if (top == stackArray.length) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public String toString() {
      String stack = "[";

      for (int index = 0; index < top-1; index++) {
        stack += stackArray[index];
        stack += ", ";
      }
      if (top > 0) {
        stack += stackArray[top-1];
      }
      stack += "]";

      return stack;
    }
  }

}
