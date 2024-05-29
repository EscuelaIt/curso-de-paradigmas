package es.usantatecla.paradigms.mutable.iterative.object.anonymus;

public interface DoubleReductor<T> {
  
  public void reduce(T element);
  public double getResult();

}
