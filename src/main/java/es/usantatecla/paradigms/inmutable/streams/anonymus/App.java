package es.usantatecla.paradigms.inmutable.streams.anonymus;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    System.out.println("Filtrada: " + 
      intervalList.stream()
        .filter(interval -> !interval.isOnLeft(range) && !interval.isOnRight(range))
        .collect(Collectors.toList())
        .toString());
    System.out.println("Aplicada: " + 
    intervalList.stream()
      .filter(interval -> !interval.isOnLeft(range) && !interval.isOnRight(range))
      .map(interval -> interval.intersection(range))
      .collect(Collectors.toList())
      .toString());
    System.out.println("Reducida: " +  
    intervalList.stream()
      .filter(interval -> !interval.isOnLeft(range) && !interval.isOnRight(range))
      .map(interval -> interval.intersection(range))
      .mapToDouble(interval -> interval.getLength())
      .reduce(0.0, (acumulator, length) -> acumulator + length) / range.getLength());
  }

}
