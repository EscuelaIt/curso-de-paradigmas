package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class Interval {

  private int min;
  private int max;

  public Interval(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public void print(){
    System.out.println("[" + this.min + ", " + this.max + "]");
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

  private boolean include(int min) {
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

  public int getMin() {
    return this.min;
  }

  public int getMax() {
    return this.max;   
  }

}
