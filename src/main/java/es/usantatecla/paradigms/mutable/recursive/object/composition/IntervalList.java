package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class IntervalList {

  private List<Interval> list; 

  public IntervalList() {
    this.list = new List<Interval>();
  }

  public IntervalList(Node<Interval> head) {
    this.list = new List<Interval>(head);
  }

  public void add(Interval interval) {
    this.list.add(interval);
  }

  public void filter(Interval interval) {
    Node<Interval> head = this.list.getHead();
    if (head != null) {
      IntervalList tail = this.getTail();
      tail.filter(interval);
      Interval headInterval = head.getElement();
      if (headInterval.isOnLeft(interval) 
          || headInterval.isOnRight(interval)){
        this.list = tail.list;    
      } else {
        head.setNext(tail.list.getHead());
      }
    }
  }

  public IntervalList getTail() {
    return new IntervalList(this.list.getHead().getNext());
  }

  public void map(Interval interval) {
    Node<Interval> head = this.list.getHead();
    if (head != null){
      Interval headInterval = head.getElement();
      head.setElement(headInterval.intersection(interval));
      this.getTail().map(interval);
    }    
  }

  public double reduce(double identity, Interval interval) {
    Node<Interval> head = this.list.getHead();
    if (head == null) {
      return identity;
    } else {
      return head.getElement().getLength() + this.getTail().reduce(identity, interval);
    }
  }

  public String toString() {
    return this.list.toString();
  }

}
