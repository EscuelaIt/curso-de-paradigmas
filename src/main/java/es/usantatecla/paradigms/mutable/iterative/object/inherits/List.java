package es.usantatecla.paradigms.mutable.iterative.object.inherits;

public class List<T> {

  private Node<T> head;

  public void add(T element) {
    Node<T> node = new Node<T>(element);
    if (this.head == null) {
      this.head = node;
    } else {
      Node<T> current = this.head;
      while (!current.isLast()) {
        current = current.getNext();
      }
      current.setNext(node);
    }
  }

  public String toString() {
    String result = "";
    Node<T> current = this.head;
    while (current != null) {
      result += current.getElement().toString() + "\n";
      current = current.getNext();
    }
    return result;
  }

  protected Node<T> getHead() {
    return this.head;
  }

  protected void setHead(Node<T> head) {
    this.head = head;
  }

}
