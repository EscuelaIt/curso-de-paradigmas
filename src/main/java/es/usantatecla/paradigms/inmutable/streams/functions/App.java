package es.usantatecla.paradigms.inmutable.streams.functions;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.ToDoubleFunction;

public class App {
  
  public static void main(String[] args) {
    List<Interval> intervalList = new ArrayList<Interval>();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial: " + 
      intervalList);
    Predicate<Interval> predicate =
      interval -> !interval.isOnLeft(range) && !interval.isOnRight(range);
    System.out.println("Filtrada: " + 
      intervalList.stream()
        .filter(predicate)
        .collect(Collectors.toList()));
    UnaryOperator<Interval> unaryOperator =
      interval -> interval.intersection(range);
    System.out.println("Aplicada: " + 
      intervalList.stream()
        .filter(predicate)
        .map(unaryOperator)
        .collect(Collectors.toList()));
    ToDoubleFunction<Interval> toDouble =
      interval -> interval.getLength();
    DoubleBinaryOperator doubleBinaryOperator =
      (left, right) -> left + right;
    System.out.println("Reducida: " +  
      intervalList.stream()
        .filter(predicate)
        .map(unaryOperator)
        .mapToDouble(toDouble)
        .reduce(0.0, doubleBinaryOperator) / range.getLength());
  }
  
}
