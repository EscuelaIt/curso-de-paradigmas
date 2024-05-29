package es.usantatecla.paradigms.mutable.iterative.object.composition;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = new IntervalList();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial:\n" + intervalList.toString());
    intervalList.filter(range);
    System.out.println("Filtrada:\n" + intervalList.toString());
    intervalList.map(range);
    System.out.println("Aplicada:\n" + intervalList.toString());
    System.out.println("Reducida: " + intervalList.doubleReduce(range));
  }

}
