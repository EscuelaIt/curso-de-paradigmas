package es.usantatecla.paradigms.mutable.iterative.process.highOrder;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

class Node<T> {

  public T element;
  public Node<T> next = null;

  public BiFunction<T, Node<T>, Node<T>> create = 
    (element, next) -> {
      Node<T> node = new Node<T>();
      node.element = element;
      node.next = next;
      return node;
    };

  public Function<Node<T>, T> getElement = 
    node -> node.element;

  public BiConsumer<Node<T>, T> setElement = 
    (node, element) -> node.element = element;

  public Function<Node<T>, Node<T>> getNext = 
    node -> node.next;

  public Predicate<Node<T>> isLast = 
    node -> node.next == null;

  public BiConsumer<Node<T>, Node<T>> setNext = 
    (node, next) -> node.next = next;

}
