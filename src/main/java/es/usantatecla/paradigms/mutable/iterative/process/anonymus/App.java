package es.usantatecla.paradigms.mutable.iterative.process.anonymus;

public class App {
  
  public static void main(String[] args) {
    List<Interval> intervalList = new List<Interval>();
    intervalList.add.accept(intervalList, new Interval().create.apply(Double.valueOf(-10),Double.valueOf(-1)));
    intervalList.add.accept(intervalList, new Interval().create.apply(Double.valueOf(-5),Double.valueOf(5)));
    intervalList.add.accept(intervalList, new Interval().create.apply(Double.valueOf(0),Double.valueOf(10)));
    intervalList.add.accept(intervalList, new Interval().create.apply(Double.valueOf(5),Double.valueOf(15)));
    intervalList.add.accept(intervalList, new Interval().create.apply(Double.valueOf(11),Double.valueOf(21)));

    Interval range = new Interval().create.apply(Double.valueOf(0),Double.valueOf(10));
    
    System.out.println("Inicial:\n" + intervalList.toString.apply(intervalList));
    intervalList.filter.accept(intervalList, interval -> !interval.isOnLeft.test(interval, range) && !interval.isOnRight.test(interval, range));
    // TODO
  }

}
