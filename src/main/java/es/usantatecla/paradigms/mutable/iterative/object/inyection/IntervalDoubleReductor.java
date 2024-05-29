package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class IntervalDoubleReductor implements DoubleReductor<Interval> {

  private Interval range;
  private double lengths;

  public IntervalDoubleReductor(Interval range) {
    this.range = range;
    this.lengths = 0;
  }

  public void reduce(Interval interval){
    this.lengths += interval.getLength();
  }

  public double getResult(){
    return this.lengths / this.range.getLength();
  }
  
}
