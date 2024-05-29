package es.usantatecla.paradigms.mutable.recursive.object.composition;

public class IntervalList {

  private List<Interval> list;

  public IntervalList() {
    this.list = new List<Interval>();
  }

  protected IntervalList(Node<Interval> head) {
    this.list = new List(head);
  }

  public void print(String title) {
    System.out.println(title);
    Node<Interval> current = this.getHead();
    while (current != null) {
      current.getElement().print();
      current = current.getNext();
    }
  }

  private Node<Interval> getHead() {
    return list.getHead();
  }

  public void filter(Interval interval) {
    if (this.list.getHead() != null) {
      if (this.list.getHead().getElement().isOnLeft(interval)
          || this.list.getHead().getElement().isOnRight(interval)) {
        this.list = new List(this.getHead().getNext());
        this.filter(interval);
      } else {
        new IntervalList(this.getHead().getNext()).filter(interval);
      }
    }
  }

  private void setHead(Node<Interval> node) {
    this.list.setHead(node);
  }

  public void map(Interval interval) {
    Node<Interval> current = this.getHead();
    while (current != null) {
      Interval currentInterval = current.getElement();
      if (currentInterval.isIntersected(interval)) {
        current.setElement(currentInterval.intersection(interval));
      }
      current = current.getNext();
    }
  }

  public void reduce() {

  }

  public void add(Interval interval) {
    this.list.add(interval);
  }

}
