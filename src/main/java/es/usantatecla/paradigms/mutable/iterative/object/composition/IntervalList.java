package es.usantatecla.paradigms.mutable.iterative.object.composition;

public class IntervalList {

  private List<Interval> list; 

  public IntervalList() {
    this.list = new List<Interval>();
  }

  public void add(Interval interval) {
    this.list.add(interval);
  }

  public void filter(Interval interval) {
    Node<Interval> current = this.list.getHead();
    Node<Interval> previous = null;
    while (current != null){
      Interval currentInterval = current.getElement();
      Node<Interval> next = current.getNext();
      if (currentInterval.isOnLeft(interval) 
          || currentInterval.isOnRight(interval)){
        if (previous == null) {
          this.list.setHead(next);
        } else {
          previous.setNext(next);
        }
      }
      previous = current;
      current = next;
    }
  }

  public void map(Interval interval) {
    Node<Interval> current = this.list.getHead();
    while (current != null){
      Interval currentInterval = current.getElement();
      if (currentInterval.isIntersected(interval)){
        current.setElement(currentInterval.intersection(interval));
      }
      current = current.getNext();
    }    
  }

  public double reduce(double identity, Interval interval) {
    Node<Interval> current = this.list.getHead();
    double lengths = identity;
    while (current != null){
      lengths += current.getElement().getLength();
      current = current.getNext();
    } 
    return lengths;
  }

  public String toString() {
    return this.list.toString();
  }

}
