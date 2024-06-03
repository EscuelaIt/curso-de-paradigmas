package es.usantatecla.paradigms.inmutable.iterative.object.inyectionX;

public class IntervalToDoubleFunction implements ToDoubleFunction<Interval> {

  public double applyAsDouble(Interval interval){
    return interval.getLength();
  }
  
}
