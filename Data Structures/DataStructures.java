import java.util.*;

public class DataStructures {

  static class List {

    private ListNode head;

    public List(int headValue) {
      head = new ListNode(headValue, null, null);
    }

    public void insert(int index, int value) {
      ListNode curr = head;
      ListNode newCurr;

      for (int i = 0; i < index; i++) {
        if (curr.getNext() != null)
          curr = curr.getNext();
        else
          return;   //cannot insert at given index
      }

      newCurr = new ListNode(value, curr.getPrev(), curr);
      curr.getPrev().setNext(newCurr);
      curr.setPrev(newCurr);
    }

    public void insertLast(int value) {
      ListNode curr = head;
      ListNode newNode;

      while(curr.getNext() != null) {
        curr = curr.getNext();
      }

      newNode = new ListNode(value, curr, null);
      curr.setNext(newNode);
    }

    @Override
    public String toString() {
      ListNode curr = head;
      String listString = "";

      listString += curr.getValue();
      while(curr.getNext() != null) {
        curr = curr.getNext();
        listString += " --> ";
        listString += curr.getValue();
      }

      return listString;
    }

    private class ListNode {

      int value;
      ListNode prev;
      ListNode next;

      public ListNode() {
        this.value = 0;
        this.prev = null;
        this.next = null;
      }

      public ListNode(int value, ListNode prev, ListNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
      }

      public int getValue() {
        return value;
      }

      public void setValue(int value) {
        this.value = value;
      }

      public ListNode getNext() {
        return next;
      }

      public ListNode getPrev() {
        return prev;
      }

      public void setNext(ListNode next) {
        this.next = next;
      }

      public void setPrev(ListNode prev) {
        this.prev = prev;
      }
    }

  }

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
