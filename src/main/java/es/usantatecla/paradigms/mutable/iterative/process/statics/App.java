package es.usantatecla.paradigms.mutable.iterative.process.statics;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = new IntervalList();
    List.add(intervalList, Interval.create(-10,-1));
    List.add(intervalList, Interval.create(-5,5));
    List.add(intervalList, Interval.create(0,10));
    List.add(intervalList, Interval.create(5,15));
    List.add(intervalList, Interval.create(11,21));

    Interval range = Interval.create(0,10);

    System.out.println("Inicial:\n" + IntervalList.toString(intervalList));
    IntervalList.filter(intervalList, range);
    System.out.println("Filtrada:\n" + IntervalList.toString(intervalList));
    IntervalList.map(intervalList, range);
    System.out.println("Aplicada:\n" + IntervalList.toString(intervalList));
    System.out.println("Reducida: " + IntervalList.doubleReduce(intervalList, range));
  }

}
