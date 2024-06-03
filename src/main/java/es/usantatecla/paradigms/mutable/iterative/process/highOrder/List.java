package es.usantatecla.paradigms.mutable.iterative.process.highOrder;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.UnaryOperator;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class List<T extends Stringable<T>> {

  private Node<T> head;

  public Supplier<List<T>> create =
   () -> {
    List<T> list = new List<T>();
    list.head = null;
    return list;
   };

  public BiConsumer<List<T>, T> add = 
    (list, element) -> {
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

  public BiConsumer<List<T>, Predicate<T>> filter = 
    (list, predicate) -> {
      Node<T> current = list.getHead.apply(list);
      Node<T> previous = null;
      while (current != null){
        T currentElement = current.getElement.apply(current);
        Node<T> next = current.getNext.apply(current);
        if (predicate.test(currentElement)) {
          if (previous == null) {
            list.setHead.accept(list, next);
          } else {
            previous.setNext.accept(previous, next);
          }
        }
        previous = current;
        current = next;
      }
  };

  public BiConsumer<List<T>, UnaryOperator<T>> map = 
    (list, unaryOperator) -> {
      Node<T> current = list.getHead.apply(list);
      while (current != null){
        T currentElement = current.getElement.apply(current);
        current.setElement.accept(current, unaryOperator.apply(currentElement));
        current = current.getNext.apply(current);
      }
  };  

  public ToDoubleBiFunction<List<T>, ToDoubleFunction<T>> reduce =
    (list, toDoubleFunction) -> {
      double lengths = 0.0;
      Node<T> current = list.getHead.apply(list);
      while (current != null){
        T currentElement = current.getElement.apply(current);
        lengths += toDoubleFunction.applyAsDouble(currentElement);
        current = current.getNext.apply(current);
      }
      return lengths;
    };

  public Function<List<T>, Node<T>> getHead = 
    list -> 
      list.head;

  public BiConsumer<List<T>, Node<T>> setHead = 
    (list, head) -> {
      list.head = head;
  };

  public Function<List<T>, String> toString =
    (list) -> {
      String result = "[";
      Node<T> current = list.getHead.apply(list);
      while (current != null) {
        T element = current.getElement.apply(current);
        result += element.toString.apply(element) + (current.isLast.test(current)? "" : ", ");
        current = current.getNext.apply(current);
      }
      return result + "]";
    };

}
  
