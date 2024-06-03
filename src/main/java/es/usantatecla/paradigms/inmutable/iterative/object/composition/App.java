package es.usantatecla.paradigms.inmutable.iterative.object.composition;

public class App {
  
  public static void main(String[] args) {
    IntervalList intervalList = new IntervalList()
    .add(new Interval(-10,-1))
    .add(new Interval(-5,5))
    .add(new Interval(0,10))
    .add(new Interval(5,15))
    .add(new Interval(11,21));

    Interval range = new Interval(0,10);

    System.out.println("Inicial: " + 
      intervalList);
    System.out.println("Filtrada: " + 
      intervalList
        .filter(range));
    System.out.println("Aplicada: " + 
      intervalList
        .filter(range)
        .map(range));
    System.out.println("Reducida: " +  
      intervalList
        .filter(range)
        .map(range)
        .reduce(0.0, range) / range.getLength());
  }

}
