package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class NonEmptyList<T> implements List<T> {

  private final T element;
  private final List<T> tail;

  public NonEmptyList(T element, List<T> tail){
    this.element = element;
    this.tail = tail;
  }

  public List<T> add(T element) {
    return new NonEmptyList<>(element, this);
  }

  public List<T> filter(Predicate<T> predicate) {
    return (predicate.test(this.element)) ?
      this.tail.filter(predicate)
    :
      new NonEmptyList<T>(element, tail.filter(predicate));
  }

  public List<T> map(UnaryOperator<T> unaryOperator) {
    return new NonEmptyList<T>(unaryOperator.apply(this.element), 
      tail.map(unaryOperator));
  }

  public List<Double> mapAsDouble(ToDoubleFunction<T> toDoubleFunction) {
    return new NonEmptyList<Double>(toDoubleFunction.applyAsDouble(this.element), 
      this.tail.mapAsDouble(toDoubleFunction));
  }

  public T reduce(T identity, BinaryOperator<T> binaryOperator) {
    return binaryOperator.apply(this.element, 
      this.tail.reduce(identity, binaryOperator));
  }

  public String toString(){
    final String tailString = this.tail.toString();
    return "[" + this.element + (tailString.equals("[]")? "": ", ") 
      + tailString.subSequence(1, tailString.length());
  }  
  
}
