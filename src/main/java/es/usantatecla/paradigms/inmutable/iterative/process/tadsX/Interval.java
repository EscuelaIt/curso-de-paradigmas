package es.usantatecla.paradigms.inmutable.iterative.process.tadsX;

public class Interval {

  private double min;
  private double max;

  public static Interval create(double min, double max) {
    Interval interval = new Interval();
    interval.min = min;
    interval.max = max;
    return interval;
  }

  public static boolean isOnLeft(Interval left, Interval right) {
    return left.max < right.min;
  }

  public static boolean isOnRight(Interval left, Interval right) {
    return left.min > right.max;
  }

  public static boolean isIntersected(Interval left, Interval right) {
    return Interval.include(right, left.min) 
      || Interval.include(right, left.max) 
      || Interval.include(left, right);
  }

  private static boolean include(Interval left, double value) {
    return left.min <= value && value <= left.max;
  }

  private static boolean include(Interval left, Interval right) {
    return Interval.include(left, right.min) && Interval.include(left, right.max);
  }

  public static Interval intersection(Interval left, Interval right) {
    assert Interval.isIntersected(left, right);

    if (Interval.include(left, right)){
      return right;
    }
    if (Interval.include(right, left)){
      return left;
    }
    Interval intersection = new Interval();
    if (Interval.include(right, left.min)){
      intersection.min = left.min;
      intersection.max = right.max;
    } else {
      intersection.min = right.min;
      intersection.max = left.max;
    }
    return intersection;
  }

  public static double getLength(Interval interval) {
    return interval.max - interval.min;
  }

  public static double getMin(Interval interval) {
    return interval.min;
  }

  public static double getMax(Interval interval) {
    return interval.max;   
  }

  public static String toString(Interval interval) {
    return "[" + interval.min + ", " + interval.max + "]";
  }

}
