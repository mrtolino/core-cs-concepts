public class DataStructures {

  static class HashMap<K, V> {

    private final int initialCapacity;
    private final double loadFactor;
    private List<Data<K, V>> [] table;

    public HashMap() {
      this.initialCapacity = 16;
      this.loadFactor = 0.75;
      table = new List<Data<K, V>>[initialCapacity];
    }

    public HashMap(int initialCapacity) {
      this.initialCapacity = initialCapacity;
      this.loadFactor = 0.75;
      table = new List<Data<K, V>>[initialCapacity];
    }

    public HashMap(int initialCapacity, double loadFactor) {
      this.initialCapacity = initialCapacity;
      this.loadFactor = loadFactor;
      table = new List<Data<K, V>>[initialCapacity];
    }

    public void put(K key, V value) {
      Data<K, V> node = new Data<K, V>(key, value);

      table[hash(key)].insertLast(node);
    }

    public V get(K key) {
      return table[hash(key)].find(new Data<K, V>(key, null)).getValue();
    }

    private int hash(K key) {
      int code = key.toString().hashCode();

      return code % table.length;
    }

    static class Data<K, V> {
      private final K key;
      private final V value;
      public Data(K key, V value) {
        this.key = key;
        this.value = value;
      }
      public K getKey() {
        return key;
      }
      public V getValue() {
        return value;
      }
      @Override
      public boolean equals(Object obj) {
        if (obj == null)
          return false;
        if (!Data.class.isAssignableFrom(obj.getClass()))
          return false;

        final Data<K, V> b = (Data<K, V>) obj;
        return this.key.equals(b.getKey());
      }
    }

  }

  static class List<T> {

    private ListNode<T> head;

    public List() {
      head = null;
    }
    public List(T headValue) {
      head = new ListNode<T>(headValue, null, null);
    }

    public T find(T value) {
      ListNode<T> curr = head;

      if (value.equals(curr.getValue()))
        return curr.getValue();

      while(curr.hasNext()) {
        curr = curr.getNext();
        if (value.equals(curr.getValue()))
          return curr.getValue();
      }

      return null;  //value not found in list
    }

    public void insert(int index, T value) {
      ListNode<T> curr = head;
      ListNode<T> newCurr;

      for (int i = 0; i < index; i++) {
        if (curr.hasNext())
          curr = curr.getNext();
        else
          return;   //cannot insert at given index
      }

      newCurr = new ListNode<T>(value, curr.getPrev(), curr);
      curr.getPrev().setNext(newCurr);
      curr.setPrev(newCurr);
    }

    public void insertLast(T value) {
      ListNode<T> curr = head;
      ListNode<T> newNode;

      //insert at head
      if (curr == null || (curr.getPrev() == null && curr.getNext() == null)) {
        head = new ListNode<T>(value, null, null);
        return;
      }

      while(curr.hasNext()) {
        curr = curr.getNext();
      }

      newNode = new ListNode<T>(value, curr, null);
      curr.setNext(newNode);
    }

    public void remove() {
      ListNode<T> curr = head;
      head = head.getNext();
      curr.setNext(null);
      curr.setPrev(null);
      head.setPrev(null);
      curr = null;
    }

    public void remove(int index) {
      ListNode<T> curr = head;

      for(int i = 0; i < index; i++) {
        if (curr.hasNext())
          curr = curr.getNext();
        else
          return; //index does not exist in the list
      }

      curr.getPrev().setNext(curr.getNext());
      curr.getNext().setPrev(curr.getPrev());
      curr.setPrev(null);
      curr.setNext(null);
      curr = null;
    }

    @Override
    public String toString() {
      ListNode<T> curr = head;
      String listString = "";

      listString += curr.getValue();
      while(curr.hasNext()) {
        curr = curr.getNext();
        listString += " --> ";
        listString += curr.getValue().toString();
      }

      return listString;
    }

    private class ListNode<T> {

      T value;
      ListNode<T> prev;
      ListNode<T> next;

      public ListNode() {
        this.value = null;
        this.prev = null;
        this.next = null;
      }

      public ListNode(T value, ListNode<T> prev, ListNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
      }

      public T getValue() {
        return value;
      }

      public void setValue(T value) {
        this.value = value;
      }

      public boolean hasNext() {
        if (next != null)
          return true;
        else
          return false;
      }

      public ListNode<T> getNext() {
        return next;
      }

      public ListNode<T> getPrev() {
        return prev;
      }

      public void setNext(ListNode<T> next) {
        this.next = next;
      }

      public void setPrev(ListNode<T> prev) {
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
