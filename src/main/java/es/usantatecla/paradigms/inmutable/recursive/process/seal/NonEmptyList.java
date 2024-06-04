package es.usantatecla.paradigms.inmutable.recursive.process.seal;

public record NonEmptyList (Interval element, List tail) implements List {}
