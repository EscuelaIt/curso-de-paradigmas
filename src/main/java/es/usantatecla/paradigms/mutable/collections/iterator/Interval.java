package es.usantatecla.paradigms.mutable.collections.iterator;

public class Interval {

  private double min;
  private double max;

  public Interval(double min, double max) {
    this.min = min;
    this.max = max;
  }

  public boolean isOnLeft(Interval interval) {
    return this.max < interval.min;
  }

  public boolean isOnRight(Interval interval) {
    return this.min > interval.max;
  }

  public boolean isIntersected(Interval interval) {
    return interval.include(this.min) 
      || interval.include(this.max) 
      || this.include(interval);
  }

  private boolean include(double min) {
    return this.min <= min && min <= this.max;
  }

  private boolean include(Interval interval) {
    return this.include(interval.min) && this.include(interval.max);
  }

  public Interval intersection(Interval interval) {
    assert this.isIntersected(interval);

    if (this.include(interval)){
      return interval;
    }
    if (interval.include(this)){
      return this;
    }
    if (interval.include(this.min)){
      return new Interval(this.min, interval.max);
    }
    return new Interval(interval.min, this.max);
  }

  public double getLength() {
    return this.max - this.min;
  }

  public double getMin() {
    return this.min;
  }

  public double getMax() {
    return this.max;   
  }

  public String toString(){
    return "[" + this.min + ", " + this.max + "]";
 }

}
