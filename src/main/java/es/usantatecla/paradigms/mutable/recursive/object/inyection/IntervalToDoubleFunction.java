package es.usantatecla.paradigms.mutable.recursive.object.inyection;

public class IntervalToDoubleFunction implements ToDoubleFunction<Interval> {

  public double applyAsDouble(Interval interval){
    return interval.getLength();
  }
  
}
