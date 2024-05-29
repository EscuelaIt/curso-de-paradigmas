package es.usantatecla.paradigms.mutable.iterative.object.inyection;

public interface DoubleReductor<T> {
  
  public void reduce(T element);
  public double getResult();

}
