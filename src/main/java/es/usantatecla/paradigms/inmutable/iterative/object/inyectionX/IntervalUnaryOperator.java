package es.usantatecla.paradigms.inmutable.iterative.object.inyectionX;

public class IntervalUnaryOperator implements UnaryOperator<Interval> {

  private Interval range;

  public IntervalUnaryOperator(Interval range){
    this.range = range;
  }

  public Interval apply(Interval element) {
    return element.intersection(this.range);
  }
  
}
