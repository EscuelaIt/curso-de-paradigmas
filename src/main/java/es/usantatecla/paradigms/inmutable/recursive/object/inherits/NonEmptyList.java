package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

public class NonEmptyList<T> implements List<T> {

  private final T element;
  private final List<T> tail;

  public NonEmptyList(T element, List<T> tail){
    this.element = element;
    this.tail = tail;
  }

  public List<T> add(T element) {
    return new NonEmptyList<>(element, this);
  }

  public String toString(){
    final String tailString = this.tail.toString();
    return "[" + this.element + (tailString.equals("[]")? "": ", ") + tailString.subSequence(1, tailString.length());
  }
  
}
