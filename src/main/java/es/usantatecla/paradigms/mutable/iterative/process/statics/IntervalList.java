package es.usantatecla.paradigms.mutable.iterative.process.statics;

public class IntervalList extends List<Interval> {

  public static void filter(IntervalList list, Interval interval) {
    Node<Interval> current = List.getHead(list);
    Node<Interval> previous = null;
    while (current != null){
      Interval currentInterval = Node.getElement(current);
      Node<Interval> next = Node.getNext(current);
      if (Interval.isOnLeft(currentInterval, interval) 
          || Interval.isOnRight(currentInterval, interval) ){
        if (previous == null) {
          List.setHead(list, next);
        } else {
          Node.setNext(previous, next);
        }
      }
      previous = current;
      current = next;
    }
  }

  public static void map(IntervalList list, Interval interval) {
    Node<Interval> current = List.getHead(list);
    while (current != null){
      Interval currentInterval = Node.getElement(current);
      if (Interval.isIntersected(currentInterval, interval)){
        Node.setElement(current, Interval.intersection(currentInterval, interval));
      }
      current = Node.getNext(current);
    }    
  }

  public static double doubleReduce(IntervalList list, Interval interval) {
    Node<Interval> current = IntervalList.getHead(list);
    double lengths = 0;
    while (current != null){
      lengths += Interval.getLength(Node.getElement(current));
      current = Node.getNext(current);
    } 
    return lengths / Interval.getLength(interval);    
  }

  public static String toString(IntervalList list) {
    String result = "";
    Node<Interval> current = List.getHead(list);
    while (current != null) {
      result += Interval.toString(Node.getElement(current)) + "\n";
      current = Node.getNext(current);
    }
    return result;
  }
}
