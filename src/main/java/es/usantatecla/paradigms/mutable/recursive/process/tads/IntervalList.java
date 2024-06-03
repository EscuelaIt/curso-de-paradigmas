package es.usantatecla.paradigms.mutable.recursive.process.tads;

public class IntervalList {

  private List<Interval> list;

  public static <T> IntervalList create() {
    IntervalList intervalList = new IntervalList();
    intervalList.list = List.create();
    return intervalList;
  }

  public static <T> IntervalList create(Node<Interval> head) {
    IntervalList intervalList = new IntervalList();
    intervalList.list = List.create(head);
    return intervalList;
  }

  public static void add(IntervalList intervalList, Interval interval) {
    List.add(intervalList.list, interval);
  }

  public static void filter(IntervalList intervalList, Interval interval) {
    List<Interval> list = List.create(List.getHead(intervalList.list));
    IntervalList.filter(list, interval);
    intervalList.list = list;
  }

  private static void filter(List<Interval> list, Interval interval) {
    if (!List.isEmpty(list)) {
      List<Interval> tail = List.create(Node.getNext(List.getHead(list)));
      IntervalList.filter(tail, interval);
      Interval headInterval = Node.getElement(List.getHead(list));
      if (Interval.isOnLeft(headInterval, interval)
          || Interval.isOnRight(headInterval, interval)) {
        List.setHead(list, List.getHead(tail));
      } else {
        Node<Interval> node = Node.create(headInterval);
        Node.setNext(node, List.getHead(tail));
        List.setHead(list, node);
      }
    }
  }

  public static void map(IntervalList intervalList, Interval interval) {
    Node<Interval> head = List.getHead(intervalList.list);
    if (head != null) {
      Interval headInterval = Node.getElement(head);
      if (Interval.isIntersected(headInterval, interval)) {
        Node.setElement(head, Interval.intersection(headInterval, interval));
      }
      IntervalList.map(IntervalList.create(Node.getNext(head)), interval);
    }
  }

  public static double reduce(IntervalList intervalList, double identity, Interval interval) {
    Node<Interval> head = List.getHead(intervalList.list);
    if (head == null) {
      return 0.0;
    } else {
      return Interval.getLength(Node.getElement(head))
          + IntervalList.reduce(IntervalList.create(Node.getNext(head)), identity, interval);
    }
  }

  public static String toString(IntervalList intervalList) {
    return "[" + IntervalList.toString(List.getHead(intervalList.list)) + "]";
  }

  private static String toString(Node<Interval> head) {
    if (head == null) {
      return "";
    } else {
      String string = Interval.toString(Node.getElement(head));
      if (Node.isLast(head)) {
        return string;
      } else {
        return string + ", " + IntervalList.toString(Node.getNext(head));
      }
    }
  }

}
