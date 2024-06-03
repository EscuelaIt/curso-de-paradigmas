package es.usantatecla.paradigms.inmutable.iterative.object.composition;

public class IntervalList {

  final private List<Interval> list; 

  public IntervalList() {
    this.list = new List<Interval>();
  }

  public IntervalList(List<Interval> list) {
    this.list = list;
  }

  public IntervalList add(Interval interval) {
    return new IntervalList(this.list.add(interval));
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
    return new IntervalList(new List<Interval>(result));
  }

  private Interval[] getIntervals() {
    Object[] objects = this.list.getElements();
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
    return new IntervalList(new List<Interval>(mapped)); 
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
    return this.list.toString();
  }

}
