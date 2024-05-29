package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public class IntervalMapper implements Mapper<Interval> {

  private Interval range;

  public IntervalMapper(Interval range){
    this.range = range;
  }

  @Override
  public Interval map(Interval element) {
    if (element.isIntersected(this.range)) {
      return element.intersection(this.range);
    }
    return null;
  }

  
  
}
