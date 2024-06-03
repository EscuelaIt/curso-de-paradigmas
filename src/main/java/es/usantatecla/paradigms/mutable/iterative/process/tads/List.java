package es.usantatecla.paradigms.mutable.iterative.process.tads;

public class List<T> {

  private Node<T> head;

  public static <T> List<T> create() {
    List<T> list = new List<T>();
    list.head = null;
    return list;
  }

  public static <T> void add(List<T> list, T element) {
    Node<T> node = Node.create(element);
    if (list.head == null){
      list.head = node;
    } else {
      Node<T> current = List.getHead(list);
      while (!Node.isLast(current)){
        current = Node.getNext(current);
      }
      Node.setNext(current, node);
    }
  }

  protected static <T> Node<T> getHead(List<T> list) {
    return list.head;
  }

  protected static <T> void setHead(List<T> list, Node<T> head) {
    list.head = head;
  }

}
