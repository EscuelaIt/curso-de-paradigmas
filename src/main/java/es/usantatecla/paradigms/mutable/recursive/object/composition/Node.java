package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class Node<T> {

  private T element;
  private Node<T> next;

  public Node(T element) {
    this.element = element;
    this.next = null;
  }

  public T getElement(){
    return this.element;
  }

  public Node<T> getNext(){
    return this.next;
  }

  public boolean isLast() {
    return this.next == null;
  }

  public void setNext(Node<T> next){
    this.next = next;
  }

  public void setElement(T element) {
    this.element = element;
  }

}
