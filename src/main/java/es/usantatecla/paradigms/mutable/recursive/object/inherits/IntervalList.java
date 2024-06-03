package es.usantatecla.paradigms.mutable.recursive.object.inherits;

public class IntervalList extends List<Interval> {

  public IntervalList(){
    super();
  }

  public IntervalList(Node<Interval> head) {
    super(head);
  }

  public void filter(Interval interval) {
    Node<Interval> head = this.getHead();
    if (head != null) {
      IntervalList tail = this.getTail();
      tail.filter(interval);
      Interval headInterval = head.getElement();
      if (headInterval.isOnLeft(interval) 
          || headInterval.isOnRight(interval)){
        this.head = tail.head;    
      } else {
        head.setNext(tail.getHead());
      }
    }
  }

  public IntervalList getTail() {
    return new IntervalList(this.getHead().getNext());
  }

  public void map(Interval interval) {
    Node<Interval> head = this.getHead();
    if (head != null){
      Interval headInterval = head.getElement();
      head.setElement(headInterval.intersection(interval));
      this.getTail().map(interval);
    }    
  }

  public double reduce(double identity, Interval interval) {
    Node<Interval> head = this.getHead();
    if (head == null) {
      return identity;
    } else {
      return head.getElement().getLength() + this.getTail().reduce(identity, interval);
    }
  }

}
