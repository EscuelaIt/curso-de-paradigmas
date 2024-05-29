package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class List<T> {

  private Node<T> head;

  public List() {
    this.head = null;
  }

  protected List(Node<T> head){
    this.head = head;
  }

  protected Node<T> getHead() {
    return this.head;
  }

  protected void setHead(Node<T> head) {
    this.head = head;
  }

  public void add(T element) {
    if (this.head == null){
      this.head = new Node<T>(element);
    } else {
      if (this.head.isLast()) {
        this.head.setNext(new Node<T>(element));
      } else {
        new List(this.head.getNext()).add(element);
      }
    }
  }

}
