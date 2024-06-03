package es.usantatecla.paradigms.mutable.iterative.object.anonymus;

public class List<T> {

  private Node<T> head;

  public List(){
    this.head = null;
  }

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

  public void filter(Predicate<T> predicate) {
    Node<T> current = this.getHead();
    Node<T> previous = null;
    while (current != null) {
      T currentElement = current.getElement();
      Node<T> next = current.getNext();
      if (predicate.test(currentElement)) {
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

  public void map(UnaryOperator<T> unaryOperator) {
    Node<T> current = this.getHead();
    while (current != null) {
      T currentElement = current.getElement();
      current.setElement(unaryOperator.apply(currentElement));
      current = current.getNext();
    }
  }

  public double reduce(double identity, ToDoubleFunction<T> toDoubleFunction){
    Node<T> current = this.getHead();
    double lengths = 0.0;
    while (current != null) {
      T currentElement = current.getElement();
      lengths += toDoubleFunction.applyAsDouble(currentElement);
      current = current.getNext();
    }
    return lengths;
  }

  protected Node<T> getHead() {
    return this.head;
  }

  protected void setHead(Node<T> head) {
    this.head = head;
  }

  public String toString() {
    String result = "[";
    Node<T> current = this.head;
    while (current != null) {
      result += current.getElement().toString() + (current.isLast()? "" : ", ");
      current = current.getNext();
    }
    return result + "]";
  }

}
