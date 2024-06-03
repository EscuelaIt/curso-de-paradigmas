package es.usantatecla.paradigms.inmutable.iterative.object.inherits;

public class List<T> {

  final protected T[] elements;

  public List(T[] elements) {
    this.elements = elements;
  }

  public List() {
    this((T[]) new Object[0]);
  }

  public List<T> add(T element) {
    T[] elements = (T[]) new Object[this.elements.length + 1];
    for (int i = 0; i < this.elements.length; i++) {
      elements[i] = this.elements[i];
    }
    elements[this.elements.length] = element;
    return new List<T>(elements);
  }

  public T[] getElements() {
    return this.elements;
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < this.elements.length; i++) {
      result += this.elements[i].toString() + (i == this.elements.length - 1 ? "" : ", ");
    }
    return result + "]";
  }

}
