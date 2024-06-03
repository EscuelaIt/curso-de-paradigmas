package es.usantatecla.paradigms.inmutable.iterative.process.tadsX;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = IntervalList.create();
    IntervalList.add(intervalList, Interval.create(-10,-1));
    IntervalList.add(intervalList, Interval.create(-5,5));
    IntervalList.add(intervalList, Interval.create(0,10));
    IntervalList.add(intervalList, Interval.create(5,15));
    IntervalList.add(intervalList, Interval.create(11,21));

    Interval range = Interval.create(0,10);

    System.out.println("Inicial: " + IntervalList.toString(intervalList));
    IntervalList.filter(intervalList, range);
    System.out.println("Filtrada: " + IntervalList.toString(intervalList));
    IntervalList.map(intervalList, range);
    System.out.println("Aplicada: " + IntervalList.toString(intervalList));
    System.out.println("Reducida: " + IntervalList.reduce(intervalList, 0.0, range)  / Interval.getLength(range));
  }

}
