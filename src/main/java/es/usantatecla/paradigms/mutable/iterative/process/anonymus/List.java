package es.usantatecla.paradigms.mutable.iterative.process.anonymus;

import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class List<T extends Stringable<T>> extends Stringable<List<T>> {

  private Node<T> head = null;

  public void size() {
    int size = 0;
    Node<T> current = this.getHead.apply(this);
    while (current != null) {
      size++;
      current = current.getNext.apply(current);
    }
    System.out.println(size);
  }

  public BiConsumer<List<T>, T> add = (list, element) -> {
    Node<T> node = new Node<T>().create.apply(element, null);
    if (list.head == null) {
      list.head = node;
    } else {
      Node<T> current = list.getHead.apply(list);
      while (!current.isLast.test(current)) {
        current = current.getNext.apply(current);
      }
      current.setNext.accept(current, node);
    }
  };

  public Function<List<T>, Node<T>> getHead = list -> list.head;

  public BiConsumer<List<T>, Node<T>> setHead = (list, head) -> {
    list.head = head;
  };

  public BiConsumer<List<T>, Predicate<T>> filter = (list, predicate) -> {

  };

  List(){
    this.toString = list -> {
      String result = "";
      Node<T> current = list.head;
      while (current != null) {
        T element = current.getElement.apply(current);
        result += element.toString.apply(element);
        current = current.getNext.apply(current);
      }
      return result;
    };
  }
}
