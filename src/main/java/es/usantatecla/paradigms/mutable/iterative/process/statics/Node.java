package es.usantatecla.paradigms.mutable.iterative.process.statics;

public class Node<T> {

  private T element;
  private Node<T> next;

  public static <T> Node<T> create(T element, Node<T> next){
    Node<T> node = new Node<T>();
    node.element = element;
    node.next = next;
    return node;
  }

  public static <T> T getElement(Node<T> node){
    return node.element;
  }
  
  public static <T> void setElement(Node<T> node, T element) {
    node.element = element;
  }

  public static <T> Node<T> getNext(Node<T> node){
    return node.next;
  }

  public static <T> boolean isLast(Node<T> node){
    return node.next == null;
  }

  public static <T> void setNext(Node<T> node, Node<T> next){
    node.next = next;
  }

}
