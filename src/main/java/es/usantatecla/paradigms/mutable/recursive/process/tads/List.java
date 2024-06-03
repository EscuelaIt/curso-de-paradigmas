package es.usantatecla.paradigms.mutable.recursive.process.tads;

public class List<T> {

  private Node<T> head;

  public static <T> List<T> create() {
    List<T> list = new List<T>();
    list.head = null;
    return list;
  }

  public static <T> List<T> create(Node<T> head) {
    List<T> list = new List<T>();
    list.head = head;
    return list;
  }

  public static <T> void add(List<T> list, T element) {
    Node<T> node = Node.create(element);
    if (List.isEmpty(list)){
      List.setHead(list, node);
    } else {
      Node<T> head = List.getHead(list);
      if (Node.isLast(head)) {
        Node.setNext(head, node);
      } else {
        List.add(List.create(Node.getNext(head)), element);
      }
    }
  }

  public static <T> boolean isEmpty(List<T> list){
    return List.getHead(list) == null;
  }

  public static <T> Node<T> getHead(List<T> list) {
    return list.head;
  }

  public static <T> void setHead(List<T> list, Node<T> head) {
    list.head = head;
  }

}
