package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class App {
  
  public static void main(String[] args) {
    List<Interval> intervalList = new List<Interval>();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial:\n" + intervalList.toString());
    intervalList.filter(new IntervalFilter(range));
    System.out.println("Filtrada:\n" + intervalList.toString());
    intervalList.map(new IntervalMapper(range));
    System.out.println("Aplicada:\n" + intervalList.toString());
    System.out.println("Reducida: " + intervalList.doubleReduce(new IntervalDoubleReductor(range)));
  }

}

