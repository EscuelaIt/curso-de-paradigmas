package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

public interface List<T> {

  abstract List<T> add(T element);
  String toString();

}
