package es.usantatecla.paradigms.inmutable.iterative.process.highOrder;

public class IntervalList extends List<Interval> {

  public IntervalList() {
    super();
  }

  public IntervalList(Interval[] intervals) {
    super(intervals);
  }

  public IntervalList add(Interval interval) {
    Object[] elements = super.add(interval).elements;
    Interval[] intervals = new Interval[elements.length];
    for(int i=0; i<elements.length; i++){
      intervals[i] = (Interval) elements[i];
    }
    return new IntervalList(intervals);
  }

  public IntervalList filter(Interval interval) {
    Interval[] intervals = this.getIntervals();
    Interval[] filtered = new Interval[intervals.length];
    int size = 0;
    for(int i=0; i<intervals.length; i++){
      if (!intervals[i].isOnLeft(interval) && !intervals[i].isOnRight(interval)){
        filtered[size] = intervals[i];
        size++;
      }
    }
    Interval[] result = new Interval[size];
    int position = 0;
    for(int i=0; i < filtered.length; i++){
      if (filtered[i] != null){
        result[position] = filtered[i];
        position++;
      }
    }
    return new IntervalList(result);
  }

  private Interval[] getIntervals() {
    Object[] objects = this.getElements();
    Interval[] intervals = new Interval[objects.length];
    for(int i=0; i<objects.length; i++){
      intervals[i] = (Interval) objects[i];
    }
    return intervals;
  }

  public IntervalList map(Interval interval) {
    Interval[] intervals = this.getIntervals();
    Interval[] mapped = new Interval[intervals.length];
    for(int i=0; i<intervals.length; i++){
      mapped[i] = intervals[i].intersection(interval);
    }
    return new IntervalList(mapped); 
  }

  public double reduce(double identity, Interval interval) {
    double lengths = identity;
    Interval[] intervals = this.getIntervals();
    for(int i=0; i<intervals.length; i++){
      lengths += intervals[i].getLength();
    }
    return lengths;
  }

  public String toString() {
    return super.toString();
  }

}
