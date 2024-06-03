package es.usantatecla.paradigms.mutable.collections.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class App {

  public static void main(String[] args) {
    List<Interval> intervalList = new ArrayList<Interval>();
    intervalList.add(new Interval(-10, -1));
    intervalList.add(new Interval(-5, 5));
    intervalList.add(new Interval(0, 10));
    intervalList.add(new Interval(5, 15));
    intervalList.add(new Interval(11, 21));

    Interval range = new Interval(0, 10);

    System.out.println("Inicial: " + intervalList);
    for (Iterator<Interval> iterator = intervalList.iterator(); iterator.hasNext();) {
      Interval current = iterator.next();
      if (current.isOnLeft(range) || current.isOnRight(range)) {
        iterator.remove();
      }
    }
    System.out.println("Filtrada: " + intervalList);
    for (ListIterator<Interval> iterator = intervalList.listIterator(); iterator.hasNext();) {
      Interval current = iterator.next();
      iterator.set(current.intersection(range));
    }
    System.out.println("Aplicada: " + intervalList);
    double lengths = 0.0;
    for (ListIterator<Interval> iterator = intervalList.listIterator(); iterator.hasNext();) {
      lengths += iterator.next().getLength();
    }
    System.out.println("Reducida: " + lengths / range.getLength());
  }

}
