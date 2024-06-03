package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

public class EmptyList<T> implements List<T> {

  public List<T> add(Object element) {
    return new NonEmptyList(element, this);
  }

  public String toString(){
    return "[]";
  }
}