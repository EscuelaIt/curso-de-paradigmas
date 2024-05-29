package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = new IntervalList();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));
    Interval range = new Interval(0,10);
    intervalList.print("Inicial");
    intervalList.filter(range);
    intervalList.print("Filtrada");
    intervalList.map(range);
    intervalList.print("Aplicada");
    intervalList.reduce();
  }

}
