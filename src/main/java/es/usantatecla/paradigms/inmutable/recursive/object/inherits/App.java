package es.usantatecla.paradigms.inmutable.recursive.object.inherits;

public class App {
  
  public static void main(String[] args) {
    System.out.println(App.exec(
      new EmptyList<Interval>()
        .add(new Interval(-10.0,-1.0))
        .add(new Interval(-5,5))
        .add(new Interval(0,10))
        .add(new Interval(5,15))
        .add(new Interval(11,21)), 
      new Interval(0,10)));
  }

  public static String exec(List<Interval> intervalList, Interval range){
    final List<Interval> filtered = 
      intervalList
        .filter(interval -> interval.isOnLeft(range) || interval.isOnRight(range));
    final List<Interval> mapped =
      filtered
        .map(interval -> interval.intersection(range));
    final double reduced = 
      mapped
        .mapAsDouble(interval -> interval.getLength())
        .reduce(0.0, (accumulator, value) -> accumulator + value);
    return
      "Inicial: " + intervalList + "\n" +
      "Filtrada: " + filtered + "\n" + 
      "Aplicada: " + mapped + "\n" + 
      "Reducida: " + reduced / range.getLength();
  }

}
