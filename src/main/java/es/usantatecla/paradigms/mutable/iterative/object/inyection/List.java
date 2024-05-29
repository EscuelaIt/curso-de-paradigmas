package es.usantatecla.paradigms.mutable.iterative.object.inyection;

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

  public void filter(Filter<T> filter) {
    Node<T> current = this.getHead();
    Node<T> previous = null;
    while (current != null) {
      T currentElement = current.getElement();
      Node<T> next = current.getNext();
      if (filter.check(currentElement)) {
        if (previous == null) {
          this.setHead(next);
        } else {
          previous.setNext(next);
        }
      }
      previous = current;
      current = next;
    }
  }

  public void map(Mapper<T> mapper) {
    Node<T> current = this.getHead();
    while (current != null) {
      T currentElement = current.getElement();
      current.setElement(mapper.map(currentElement));
      current = current.getNext();
    }
  }

  public double doubleReduce(DoubleReductor<T> reductor){
    Node<T> current = this.getHead();
    while (current != null) {
      T currentElement = current.getElement();
      reductor.reduce(currentElement);
      current = current.getNext();
    }
    return reductor.getResult();
  }

}
