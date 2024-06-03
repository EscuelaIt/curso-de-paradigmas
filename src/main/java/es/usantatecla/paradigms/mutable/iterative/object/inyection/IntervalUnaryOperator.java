package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class IntervalUnaryOperator implements UnaryOperator<Interval> {

  private Interval range;

  public IntervalUnaryOperator(Interval range){
    this.range = range;
  }

  public Interval apply(Interval element) {
    if (element.isIntersected(this.range)) {
      return element.intersection(this.range);
    }
    return null;
  }

  
  
}
