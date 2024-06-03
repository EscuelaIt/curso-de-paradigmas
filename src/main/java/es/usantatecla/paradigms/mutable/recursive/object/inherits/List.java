package es.usantatecla.paradigms.mutable.recursive.object.inherits;

public class List<T> {

  protected Node<T> head;

  public List() {
    this.head = null;
  }

  public List(Node<T> head) {
    this.head = head;
  }

  public void add(T element) {
    Node<T> node = new Node<T>(element);
    if (this.isEmpty()) {
      this.setHead(node);
    } else {
      Node<T> head = this.head;
      if (head.isLast()){
        head.setNext(node);
      } else {
        this.getTail().add(element);
      }
    }
  }

  public List<T> getTail() {
    return new List<T>(head.getNext());
  }

  public boolean isEmpty() {
    return this.getHead() == null;
  }

  protected Node<T> getHead() {
    return this.head;
  }

  protected void setHead(Node<T> head) {
    this.head = head;
  }

  public String toString() {
    return "[" + this.toString(this.getHead()) + "]";
  }

  private String toString(Node<T> head) {
    if (head == null) {
      return "";
    } else {
      String string = head.getElement().toString();
      if (head.isLast()) {
        return string;
      } else {
        return string + ", " + this.toString(head.getNext());
      }
    }
  }

}
