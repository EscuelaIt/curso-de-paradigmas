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

    System.out.println("Inicial: " + intervalList.toString());
    Predicate<Interval> filter =
      interval -> interval.isOnLeft(range) || interval.isOnRight(range);
    intervalList.removeIf(filter);
    System.out.println("Filtrada: " + intervalList.toString());
    UnaryOperator<Interval> mapper =
      interval -> interval.intersection(range);
    intervalList.replaceAll(mapper);
    System.out.println("Aplicada: " + intervalList.toString());
    double lengths = 0;
    // Consumer<Interval> reducer =
    //   interval -> lengths += interval.getLength();
    // intervalList.forEach(reducer);
    // intervalList.iterator().forEachRemaining(reducer);
    for (Interval interval : intervalList) {
      lengths += interval.getLength();
    }
    System.out.println("Reducida: " + lengths / range.getLength());
  }

}
