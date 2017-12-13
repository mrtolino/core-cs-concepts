import java.util.*;

public class Controller {
  public Controller() {}

  public static void main(String[] args) {
    DataStructures.Stack<Character> stack = new DataStructures.Stack<Character>(10);
    stack.push('A');
    stack.push('B');
    stack.push('C');
    stack.push('D');
    stack.push('E');
    stack.push('F');
    stack.push('G');
    stack.push('H');
    stack.push('I');
    stack.push('J');

    stack.pop();
    stack.pop();
    stack.pop();

    System.out.println(stack.toString());

    //EXPECTING 70
    System.out.println("PEEK STACK ---> " + stack.peek());

    //EXPECTING FALSE
    System.out.println("STACK FULL? ---> " + stack.isFull());

    for (int count = 0; count < 7; count++) {
      stack.pop();
    }

    //EXPECTING TRUE
    System.out.println("STACK EMPTY? ---> " + stack.isEmpty());
  }
}
