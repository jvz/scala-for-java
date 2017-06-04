package com.spr.scala.impl

import com.spr.scala.Bag

/**
  * Demonstrates using `ArrayOps` implicit conversions with collection functions. Essentially, this shows off how to
  * both implement our `Bag` trait using an array as well as how we can automatically convert arrays into a collection
  * type that provides a much richer API than arrays normally do.
  */
// note two bits of syntax here:
// 1. fields that double as constructor params can be placed in parenthesis after the class name
// 2. implementing a trait uses "extends" just as it would when extending a class. there is no implements keyword
class ImplicitArrayBag[+T](bag: Array[T]) extends Bag[T] {
  override def add[S >: T](item: S): Bag[S] =
    // the :+ and +: methods are used to add an item to a collection.
    // ordering works like this:
    // collection :+ item
    // item +: collection
    // the COLon goes on the COLlection side (as noted in the scaladocs)
    new ImplicitArrayBag(bag :+ item)

  override def remove(p: T => Boolean): Bag[T] =
    new ImplicitArrayBag(bag.filterNot(p))

  override def map[U](f: (T) => U): Bag[U] =
    Bag(bag.map(f): _*)

  override def flatMap[U](f: (T) => Bag[U]): Bag[U] =
    Bag(bag.flatMap(f.andThen(_.toArray)): _*)

  override def filter(p: (T) => Boolean): Bag[T] =
    Bag(bag.filter(p): _*)

  override def reduce[S >: T](acc: (S, S) => S): Option[S] =
    bag.reduceOption(acc)

  override def toArray[S >: T]: Array[S] =
    Array(bag: _*)

  override def toStream: Stream[T] =
    Stream(bag: _*)

  override def contains(p: (T) => Boolean): Boolean =
    bag.exists(p)

  override def size: Int =
    bag.length

  override def isEmpty: Boolean =
    bag.isEmpty

  override def iterator: Iterator[T] =
    bag.iterator
}
