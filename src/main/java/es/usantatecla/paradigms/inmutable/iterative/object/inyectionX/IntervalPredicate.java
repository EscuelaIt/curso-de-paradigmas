package es.usantatecla.paradigms.inmutable.iterative.object.inyectionX;

public class IntervalPredicate implements Predicate<Interval> {

  private Interval range;

  public IntervalPredicate(Interval range){
    this.range = range;
  }

  public boolean test(Interval element) {
    return element.isOnLeft(this.range) 
    || element.isOnRight(this.range);
  }
  
}
