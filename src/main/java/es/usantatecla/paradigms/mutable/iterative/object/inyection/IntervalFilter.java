package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class IntervalFilter implements Filter<Interval> {

  private Interval range;

  public IntervalFilter(Interval range){
    this.range = range;
  }

  @Override
  public boolean check(Interval element) {
    return element.isOnLeft(this.range) 
    || element.isOnRight(this.range);
  }
  
}
