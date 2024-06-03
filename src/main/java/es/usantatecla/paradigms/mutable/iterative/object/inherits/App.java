package es.usantatecla.paradigms.mutable.iterative.object.inherits;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = new IntervalList();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial: " + intervalList);
    intervalList.filter(range);
    System.out.println("Filtrada: " + intervalList);
    intervalList.map(range);
    System.out.println("Aplicada: " + intervalList);
    System.out.println("Reducida: " + intervalList.reduce(0.0, range) / range.getLength());
  }

}
