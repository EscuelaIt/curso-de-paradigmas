package es.usantatecla.paradigms.inmutable.iterative.object.anonymusX;

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

  public void setElement(T element) {
    this.element = element;
  }
  
  public boolean isLast() {
    return this.next == null;
  }

  public Node<T> getNext(){
    return this.next;
  }

  public void setNext(Node<T> next){
    this.next = next;
  }

}
