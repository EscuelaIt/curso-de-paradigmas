package es.usantatecla.paradigms.mutable.collections.functions;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
// import java.util.function.Consumer;

public class App {
  
  public static void main(String[] args) {
    List<Interval> intervalList = new ArrayList<Interval>();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial: " + intervalList);
    Predicate<Interval> predicate =
      interval -> interval.isOnLeft(range) || interval.isOnRight(range);
    intervalList.removeIf(predicate);
    System.out.println("Filtrada: " + intervalList);
    UnaryOperator<Interval> unaryOperator =
      interval -> interval.intersection(range);
    intervalList.replaceAll(unaryOperator);
    System.out.println("Aplicada: " + intervalList);
    double lengths = 0.0;
    // Consumer<Interval> consumer =
    //   interval -> lengths += interval.getLength();
    // intervalList.forEach(consumer);
    // intervalList.iterator().forEachRemaining(consumer);
    for (Interval interval : intervalList) {
      lengths += interval.getLength();
    }
    System.out.println("Reducida: " + lengths / range.getLength());
  }

}
