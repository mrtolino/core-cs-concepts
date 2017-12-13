import java.util.*;

public class Controller {
  public Controller() {}

  public static void main(String[] args) {
    DataStructures.Stack stack = new DataStructures.Stack(10);
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    stack.push(60);
    stack.push(70);
    stack.push(80);
    stack.push(90);
    stack.push(100);

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
