package com.spr.scala.syntax

/**
  * Demonstrates the various syntax sugar associated with particular method names.
  */
class SyntaxSugar(var s: String) {

  /**
    * An apply method can be called with parentheses without the word "apply". In this case, we'll make it a sort of
    * indexing operation. So, if `ss` is an instance of this, then `ss(2)` would return the third code point of the
    * underlying string.
    */
  def apply(index: Int): Int = s.codePointAt(index)

  /**
    * An update method is similar to apply in how it adds syntax, but this is when you set something equal to the
    * application. If `ss` is an instance of this, then `ss(2) = 'a'` would set the third character of the underyling
    * string to 'a'.
    */
  def update(index: Int, c: Char): Unit = {
    s = s.updated(index, c)
  }

  /**
    * A map method is used in simple for expressions. If `ss` is an instance of this, then the syntax
    * `for (s <- ss) yield f(s)` is equivalent to `ss.map(s => f(s))` or more simply, `ss.map(f)`.
    */
  def map(f: String => String): SyntaxSugar = new SyntaxSugar(f(s))

  /**
    * A flatMap method is similar to map and is used in more complex for expressions. For example, if `ss` and `tt` are
    * instances of this class, then `for (s <- ss; t <- tt) yield s.s + t.s` is equivalent to
    * `ss.flatMap(s => tt.map(t => s.s + t.s))`.
    */
  def flatMap(f: String => SyntaxSugar): SyntaxSugar = new SyntaxSugar(f(s).s)

  /**
    * A foreach method is similar to a map method but is used in for expressions that don't use yield. For example, if
    * `ss` is an instance of this, then `for (s <- ss) println(s)` is equivalent to `ss.foreach(s => println(s))` or
    * more simply `ss.foreach(println)`.
    */
  def foreach(f: String => Unit): Unit = f(s)

  // Note that there are also the filter and withFilter methods for filtering in for expressions.

  /**
    * A toString method works just as it does in Java, though in Scala syntax, we don't need the empty parentheses.
    */
  override def toString: String = s

}

/**
  * Here we explore some actual syntactic usage of the above syntax sugar methods.
  */
object SyntaxSugar {
  val ss = new SyntaxSugar("foo")
  // update
  ss(0) = 'g'
  // apply
  assert(ss(0) == 'g')
  // foreach
  for (s <- ss) {
    println(s)
  }
  // map
  val st: SyntaxSugar = for (s <- ss) yield s.replace('o', 'u')
  // flatMap (ss) and map (st)
  val su: SyntaxSugar = for {
    s <- ss
    t <- st
  } yield s + t
  println(su)
}
