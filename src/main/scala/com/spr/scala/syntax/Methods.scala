package com.spr.scala.syntax

/**
  * Demonstrates simple method syntax. By adding a class parameter, this gives us a field in the class, and by adding
  * `val` to it, we auto-generate a getter method named `name`. If we had made it a `var` instead, we'd also get a
  * setter method named `name_=` which can be used like `m.name = "new name"` for an instance `m`.
  */
class Methods(val name: String) {
  /**
    * A default constructor. Constructor methods are all named `this` and must be based on the most general constructor
    * which is inferred from the list of class parameters from the top.
    */
  def this() = this("world")

  /**
    * An instance method.
    */
  def instanceMethod(): Unit = {
    println(s"Hello, $name!")
  }
}

/**
  * In order to add static (class) methods, we put them in an object of the same name of the class.
  */
object Methods {
  /**
    * A method on a companion object. Can be called statically in Java terminology, though technically there will be
    * a singleton instance of this class called `Methods$.MODULE$`.
    */
  def staticMethod(): Unit = {
    println("Hello, world!")
  }
}
