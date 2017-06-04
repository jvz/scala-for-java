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
class ImplicitArrayBag[+A](bag: Array[A]) extends Bag[A] {
  override def add[A1 >: A](item: A1): Bag[A1] =
    // the :+ and +: methods are used to add an item to a collection.
    // ordering works like this:
    // collection :+ item
    // item +: collection
    // the COLon goes on the COLlection side (as noted in the scaladocs)
    new ImplicitArrayBag(bag :+ item)

  override def remove(p: A => Boolean): Bag[A] =
    new ImplicitArrayBag(bag.filterNot(p))

  override def map[B](f: A => B): Bag[B] =
    Bag(bag.map(f): _*)

  override def flatMap[B](f: A => Bag[B]): Bag[B] =
    Bag(bag.flatMap(f.andThen(_.toArray)): _*)

  override def filter(p: A => Boolean): Bag[A] =
    Bag(bag.filter(p): _*)

  override def reduce[A1 >: A](acc: (A1, A1) => A1): Option[A1] =
    bag.reduceOption(acc)

  override def toArray[A1 >: A]: Array[A1] =
    Array(bag: _*)

  override def toStream: Stream[A] =
    Stream(bag: _*)

  override def contains(p: A => Boolean): Boolean =
    bag.exists(p)

  override def size: Int =
    bag.length

  override def isEmpty: Boolean =
    bag.isEmpty

  override def iterator: Iterator[A] =
    bag.iterator
}
