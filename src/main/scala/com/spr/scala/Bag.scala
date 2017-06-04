package com.spr.scala

import com.spr.scala.impl.ImplicitArrayBag

/**
  * Scala version of a Bag. Note that by inheriting from `Iterable`, many of our equivalent methods from the Java
  * version of `Bag` are defined already.
  */
// a trait is similar to an interface (especially with Java 8's default methods) that can also contain fields
// in fact, a trait is almost the same as an abstract class except for two things:
// 1. a trait cannot have any constructors
// 2. a class or trait can extend multiple traits, but only a single class
// also note the square brackets syntax for generics, and the use of A instead of T as the usual generic type
// we can ignore the + in the type for now, but essentially it allows Bag[B] to be a subclass of Bag[A] if B is a
// subclass of A
trait Bag[+A] extends Iterable[A] {
  // generics are sometimes hard to get right. in order to support subtypes of Bag[A], we need to accept a supertype of A
  def add[A1 >: A](item: A1): Bag[A1]

  // lambda function syntax
  def remove(p: A => Boolean): Bag[A]

  def map[B](f: A => B): Bag[B]

  def flatMap[B](f: A => Bag[B]): Bag[B]

  def filter(p: A => Boolean): Bag[A]

  // Scala's optional type is Option instead of Optional
  def reduce[A1 >: A](acc: (A1, A1) => A1): Option[A1]

  def toArray[A1 >: A]: Array[A1]

  // Scala has its own Stream API which serves a similar purpose to Java 8's Stream API
  def toStream: Stream[A]

  def contains(p: A => Boolean): Boolean

  // 0-arg methods can leave off parenthesis, though this is normally only done for side-effect-free methods
  // also, when declaring a method with no parenthesis, callers must also not use parenthesis.
  // if empty parenthesis were declared here, then callers would have the option of not using them (confusing!)
  def size: Int

  def isEmpty: Boolean
}

// since Scala does not provide static methods, in order to provide a convenience factory method for constructing
// bags, we include one in its "companion object".
object Bag {
  /**
    * Constructs a `Bag` using a varargs array of items.
    */
  // by naming this method "apply", we can call it as one of two ways:
  // 1. Bag.apply(1, 2, 3)
  // 2. Bag(1, 2, 3)
  // the second syntax is preferred as all "apply" methods are used as such
  def apply[A](items: A*): Bag[A] =
    // using varargs can be confusing sometimes. in order to expand out a collection of some sort into another varargs
    // method, we must attach the "_*" type to it to indicate to the compiler to expand it
    new ImplicitArrayBag(Array(items: _*))
}
