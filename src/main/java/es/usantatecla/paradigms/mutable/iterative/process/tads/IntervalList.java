package es.usantatecla.paradigms.mutable.iterative.process.tads;

public class IntervalList {

  private List<Interval> list;

  public static <T> IntervalList create(){
    IntervalList intervalList = new IntervalList();
    intervalList.list = List.create(); 
    return intervalList;
  }

  public static void add(IntervalList intervalList, Interval interval){
    List.add(intervalList.list, interval);
  }

  public static void filter(IntervalList intervalList, Interval interval) {
    Node<Interval> current = List.getHead(intervalList.list);
    Node<Interval> previous = null;
    while (current != null){
      Interval currentInterval = Node.getElement(current);
      Node<Interval> next = Node.getNext(current);
      if (Interval.isOnLeft(currentInterval, interval) 
          || Interval.isOnRight(currentInterval, interval) ){
        if (previous == null) {
          List.setHead(intervalList.list, next);
        } else {
          Node.setNext(previous, next);
        }
      }
      previous = current;
      current = next;
    }
  }

  public static void map(IntervalList intervalList, Interval interval) {
    Node<Interval> current = List.getHead(intervalList.list);
    while (current != null){
      Interval currentInterval = Node.getElement(current);
      Node.setElement(current, Interval.intersection(currentInterval, interval));
      current = Node.getNext(current);
    }    
  }

  public static double reduce(IntervalList intervalList, double identity, Interval interval) {
    Node<Interval> current = List.getHead(intervalList.list);
    double lengths = identity;
    while (current != null){
      lengths += Interval.getLength(Node.getElement(current));
      current = Node.getNext(current);
    } 
    return lengths;    
  }

  public static String toString(IntervalList intervalList) {
    String result = "[";
    Node<Interval> current = List.getHead(intervalList.list);
    while (current != null) {
      result += Interval.toString(Node.getElement(current)) + (Node.isLast(current)? "" : ", ");
      current = Node.getNext(current);
    }
    return result + "]";
  }

}
