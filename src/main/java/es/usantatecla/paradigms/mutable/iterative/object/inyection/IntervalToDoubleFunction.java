package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class IntervalToDoubleFunction implements ToDoubleFunction<Interval> {

  public double applyAsDouble(Interval interval){
    return interval.getLength();
  }
  
}
