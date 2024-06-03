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
      intervalList.toString());
    Predicate<Interval> filter =
      interval -> !interval.isOnLeft(range) && !interval.isOnRight(range);
    System.out.println("Filtrada: " + 
      intervalList.stream()
        .filter(filter)
        .collect(Collectors.toList())
        .toString());
    UnaryOperator<Interval> unaryOperator =
      interval -> interval.intersection(range);
    System.out.println("Aplicada: " + 
      intervalList.stream()
        .filter(filter)
        .map(unaryOperator)
        .collect(Collectors.toList())
        .toString());
    ToDoubleFunction<Interval> toDouble =
      interval -> interval.getLength();
    DoubleBinaryOperator doubleBinaryOperator =
      (left, right) -> left + right;
    System.out.println("Reducida: " +  
      intervalList.stream()
        .filter(filter)
        .map(unaryOperator)
        .mapToDouble(toDouble)
        .reduce(0.0, doubleBinaryOperator) / range.getLength());
  }
  
}
