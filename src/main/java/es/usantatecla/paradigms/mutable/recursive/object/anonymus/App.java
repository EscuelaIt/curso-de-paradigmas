package es.usantatecla.paradigms.mutable.recursive.object.anonymus;

public class App {
  
  public static void main(String[] args) {
    List<Interval> intervalList = new List<Interval>();
    intervalList.add(new Interval(-10,-1));
    intervalList.add(new Interval(-5,5));
    intervalList.add(new Interval(0,10));
    intervalList.add(new Interval(5,15));
    intervalList.add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial: " + intervalList);
    intervalList.filter(new Predicate<Interval>() {
      public boolean test(Interval element) {
        return element.isOnLeft(range) 
        || element.isOnRight(range);
      }
    });
    System.out.println("Filtrada: " + intervalList);
    intervalList.map(new UnaryOperator<Interval>() {
      public Interval apply(Interval element) {
        if (element.isIntersected(range)) {
          return element.intersection(range);
        }
        return null;
      }
    });
    System.out.println("Aplicada: " + intervalList);
    System.out.println("Reducida: " + intervalList.doubleReduce(new ToDoubleFunction<Interval>() {
    
      public double applyAsDouble(Interval interval){
        return interval.getLength();
      }

    }) / range.getLength());
  }

}
