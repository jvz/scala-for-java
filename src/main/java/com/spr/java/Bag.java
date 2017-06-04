package com.spr.java;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.spr.java.impl.StreamArrayBag;

/**
 * Java version of a Bag. A Bag is similar to a Collection in that it contains elements which can be added or removed.
 */
public interface Bag<T> extends Iterable<T> {
    /**
     * Constructs a {@code Bag} using a varargs array of items.
     */
    static <T> Bag<T> of(T... items) {
        return new StreamArrayBag<>(items);
    }

    Bag<T> add(T item);

    Bag<T> remove(Predicate<? super T> predicate);

    <U> Bag<U> map(Function<? super T, ? extends U> mapper);

    <U> Bag<U> flatMap(Function<? super T, ? extends Bag<? extends U>> mapper);

    Bag<T> filter(Predicate<? super T> predicate);

    Optional<T> reduce(BinaryOperator<T> accumulator);

    T[] toArray();

    Stream<T> toStream();

    boolean contains(Predicate<? super T> predicate);

    int size();

    boolean isEmpty();
}
