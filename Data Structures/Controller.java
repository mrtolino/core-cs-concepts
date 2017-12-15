public class Controller {
  public Controller() {}

  public static void main(String[] args) {
    hashMapTest();
  }

  private static void hashMapTest() {
    DataStructures.HashMap<Character, Integer> table = new DataStructures.HashMap<Character, Integer>();

    table.put('A', 10);
    table.put('B', 20);
    table.put('C', 30);

    System.out.println("Value stored at key A --> " + table.get('A').toString());

  }

  private static void listTest() {
    DataStructures.List<Character> list = new DataStructures.List<Character>('A');
    list.insertLast('B');
    list.insertLast('C');


    System.out.println(list.toString());

    list.insert(1, 'D');

    System.out.println(list.toString());

    list.insert(2, 'E');

    System.out.println(list.toString());

    list.remove(3);

    System.out.println(list.toString());
  }

  private static void stackTest() {
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
