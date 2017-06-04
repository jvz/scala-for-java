package com.spr.java.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.spr.java.Bag;

/**
 * Demonstrates a Bag implementation using arrays and streams.
 */
public class StreamArrayBag<T> implements Bag<T> {

    private final T[] bag;

    public StreamArrayBag(final T[] bag) {
        this.bag = bag;
    }

    @Override
    public Bag<T> add(final T item) {
        int length = bag.length;
        T[] copy = Arrays.copyOf(bag, length + 1);
        copy[length] = item;
        return new StreamArrayBag<>(copy);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Bag<T> remove(final Predicate<? super T> predicate) {
        return new StreamArrayBag<>((T[]) toStream().filter(predicate.negate()).toArray());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> Bag<U> map(final Function<? super T, ? extends U> mapper) {
        return new StreamArrayBag<>((U[]) toStream().map(mapper).toArray());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U> Bag<U> flatMap(final Function<? super T, ? extends Bag<? extends U>> mapper) {
        return new StreamArrayBag<>((U[]) toStream().flatMap(mapper.andThen(Bag::toStream)).toArray());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Bag<T> filter(final Predicate<? super T> predicate) {
        return new StreamArrayBag<>((T[]) toStream().filter(predicate).toArray());
    }

    @Override
    public Optional<T> reduce(final BinaryOperator<T> accumulator) {
        return toStream().reduce(accumulator);
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(bag, bag.length);
    }

    @Override
    public Stream<T> toStream() {
        return Arrays.stream(bag);
    }

    @Override
    public boolean contains(Predicate<? super T> predicate) {
        return toStream().anyMatch(predicate);
    }

    @Override
    public int size() {
        return bag.length;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(bag).iterator();
    }

    @Override
    public boolean isEmpty() {
        return bag.length == 0;
    }
}
