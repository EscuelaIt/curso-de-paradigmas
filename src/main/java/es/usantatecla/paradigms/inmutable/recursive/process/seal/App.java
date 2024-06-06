package es.usantatecla.paradigms.inmutable.recursive.process.seal;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    System.out.println(
      App.exec(
        List.add(
          List.add(
            List.add(
              List.add(
                List.add(
                  new EmptyList(),
                new Interval(-10, -1)),
              new Interval(-5, 5)),
            new Interval(0, 10)),
          new Interval(5, 15)),
        new Interval(11, 21)), 
      new Interval(0, 10)));   
  }

  private static String exec(List list, Interval range){
    final List filtered = List.filter(list, interval ->
    interval.isOnLeft(range) || interval.isOnRight(range));
    final List mapped = List.map(filtered, interval ->
    interval.intersection(range));
    final ArrayList<Double> reduced = List.mapAsDouble(mapped, Interval::getLength);
    final double value = reduced.stream().reduce(0.0, Double::sum);
    return
      "Inicial: " + list + "\n" +
      "Filtrada: " + filtered + "\n" +
      "Aplicada: " + mapped + "\n" +
      "Reducida: " + value / range.getLength();
  }

}
