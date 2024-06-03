package es.usantatecla.paradigms.mutable.iterative.process.highOrder;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;

public class Interval extends Stringable<Interval> {

  private double min;
  private double max;

  public BiFunction<Double, Double, Interval> create = 
    (min, max) -> {
      Interval interval = new Interval();
      interval.min = min;
      interval.max = max;
      return interval;
    };

  public BiPredicate<Interval, Interval> isOnLeft = 
    (left, right) -> left.max < right.min;

  public BiPredicate<Interval, Interval> isOnRight = 
    (left, right) -> left.min > right.max;

  public BiPredicate<Interval, Interval> isIntersected = 
    (left, right) -> left.includeValue.test(right, left.min)
      || left.includeValue.test(right, left.max)
      || left.includeInterval.test(left, right);

  public BiPredicate<Interval, Double> includeValue = 
    (interval, value) -> interval.min <= value && value <= interval.max;

  public BiPredicate<Interval, Interval> includeInterval = 
    (left, right) -> left.includeValue.test(left, right.min)
      && left.includeValue.test(left, right.max);

  public BinaryOperator<Interval> intersection = 
    (left, right) -> {
      assert left.isIntersected.test(left, right);

      if (left.includeInterval.test(left, right)) {
        return right;
      }
      if (right.includeInterval.test(right, left)) {
        return left;
      }
      Interval intersection = new Interval();
      if (right.includeValue.test(right, left.min)) {
        intersection.min = left.min;
        intersection.max = right.max;
      } else {
        intersection.min = right.min;
        intersection.max = left.max;
      }
      return intersection;
    };

  public ToDoubleFunction<Interval> getLength = 
    interval -> Math.abs(interval.max - interval.min);

  public ToDoubleFunction<Interval> getMin = 
    interval -> interval.min;

  public ToDoubleFunction<Interval> getMax = 
    interval -> interval.max;

  Interval() {
    this.toString = interval -> "[" + interval.min + ", " + interval.max + "]";
  }
  
}
