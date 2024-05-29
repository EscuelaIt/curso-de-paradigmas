package es.usantatecla.paradigms.mutable.iterative.object.anonymus;

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
    intervalList.filter(new Filter<Interval>() {
      @Override
      public boolean check(Interval element) {
        return element.isOnLeft(range) 
        || element.isOnRight(range);
      }
    });
    System.out.println("Filtrada:\n" + intervalList.toString());
    intervalList.map(new Mapper<Interval>() {
      @Override
      public Interval map(Interval element) {
        if (element.isIntersected(range)) {
          return element.intersection(range);
        }
        return null;
      }
    });
    System.out.println("Aplicada:\n" + intervalList.toString());
    System.out.println("Reducida: " + intervalList.doubleReduce(new DoubleReductor<Interval>() {

      private double lengths;
    
      public void reduce(Interval interval){
        this.lengths += interval.getLength();
      }
    
      public double getResult(){
        return this.lengths / range.getLength();
      }
    } ));
  }

}
