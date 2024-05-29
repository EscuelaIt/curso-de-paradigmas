package es.usantatecla.paradigms.mutable.collections.anonymus;

import java.util.List;
import java.util.ArrayList;

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
    intervalList.removeIf(interval -> interval.isOnLeft(range) || interval.isOnRight(range));
    System.out.println("Filtrada: " + intervalList.toString());
    intervalList.replaceAll(interval -> interval.intersection(range));
    System.out.println("Aplicada: " + intervalList.toString());
    double lengths = 0;
    // intervalList.forEach(interval -> lengths += interval.getLength());
    // intervalList.iterator().forEachRemaining(interval -> lengths += interval.getLength());
    for (Interval interval : intervalList) {
      lengths += interval.getLength();
    }
    System.out.println("Reducida: " + lengths / range.getLength());
  }

}
