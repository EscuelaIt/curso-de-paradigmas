package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;

public interface List<T> {

  List<T> add(T element);
  List<T> filter (Predicate<T> predicate);
  List<T> map (UnaryOperator<T> unaryOperator);
  List<Double> mapAsDouble (ToDoubleFunction<T> toDoubleFunction);
  T reduce (T identity, BinaryOperator<T> binaryOperator);
  String toString();

}
