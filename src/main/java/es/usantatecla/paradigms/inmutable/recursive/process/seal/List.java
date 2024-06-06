package es.usantatecla.paradigms.inmutable.recursive.process.seal;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;

sealed interface List permits EmptyList, NonEmptyList {

    static List add(List list, Interval element) {
        return new NonEmptyList(element, list);
    }

    static List filter(List list, Predicate<Interval> predicate) {
        return switch (list) {
            case EmptyList emptyList -> new EmptyList();
            case NonEmptyList nonEmptyList -> (predicate.test(nonEmptyList.element())) ?
                    filter(nonEmptyList.tail(), predicate)
                    :
                    new NonEmptyList(nonEmptyList.element(), filter(nonEmptyList.tail(), predicate));
        };
    }

    static List map(List list, UnaryOperator<Interval> unaryOperator) {
        return switch (list) {
            case EmptyList emptyList -> new EmptyList();
            case NonEmptyList nonEmptyList -> new NonEmptyList(
                    unaryOperator.apply(nonEmptyList.element()),
                    map(nonEmptyList.tail(), unaryOperator));
        };
    }

    static ArrayList<Double> mapAsDouble(List list, ToDoubleFunction<Interval> toDoubleFunction) {
        switch (list) {
            case EmptyList emptyList -> {
                return new ArrayList<Double>();
            }
            case NonEmptyList nonEmptyList -> {
                ArrayList<Double> doubles = new ArrayList<Double>();
                doubles.add(toDoubleFunction.applyAsDouble(nonEmptyList.element()));
                for (Double value : mapAsDouble(nonEmptyList.tail(), toDoubleFunction)) {
                    doubles.add(value);
                }
                return doubles;
            }
        }
    }

    static String toString(List list) {
        switch (list) {
            case EmptyList emptyList -> {
                return "[]";
            }
            case NonEmptyList nonEmptyList -> {
                final String tailString = nonEmptyList.tail().toString();
                return "[" +
                        nonEmptyList.element() +
                        (tailString.equals("[]") ? "" : ", ") +
                        tailString.subSequence(1, tailString.length());
            }
        }

    }
}




