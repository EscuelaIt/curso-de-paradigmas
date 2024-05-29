package es.usantatecla.paradigms.mutable.iterative.object.inherits;

public class IntervalList extends List<Interval> {

  public void filter(Interval interval) {
    Node<Interval> current = this.getHead();
    Node<Interval> previous = null;
    while (current != null){
      Interval currentInterval = current.getElement();
      Node<Interval> next = current.getNext();
      if (currentInterval.isOnLeft(interval) 
          || currentInterval.isOnRight(interval) ){
        if (previous == null) {
          this.setHead(next);
        } else {
          previous.setNext(next);
        }
      }
      previous = current;
      current = next;
    }
  }

  public void map(Interval interval) {
    Node<Interval> current = this.getHead();
    while (current != null){
      Interval currentInterval = current.getElement();
      if (currentInterval.isIntersected(interval)){
        current.setElement(currentInterval.intersection(interval));
      }
      current = current.getNext();
    }    
  }

  public double doubleReduce(Interval interval) {
    Node<Interval> current = this.getHead();
    double lengths = 0;
    while (current != null){
      lengths += current.getElement().getLength();
      current = current.getNext();
    } 
    return lengths / interval.getLength();
  }

}
