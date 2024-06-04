package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class EmptyList<T> implements List<T> {

  public List<T> add(T element) {
    return new NonEmptyList(element, this);
  }

  public List<T> filter(Predicate<T> predicate) {
    return new EmptyList<T>();
  }

  public List<T> map(UnaryOperator<T> unaryOperator) {
    return new EmptyList<T>();
  }

  public List<Double> mapAsDouble(ToDoubleFunction<T> toDoubleFunction) {
    return new EmptyList<Double>();
  }

  public T reduce (T identity, BinaryOperator<T> binaryOperator) {
    return identity;
  }

  public String toString(){
    return "[]";
  }
  
}