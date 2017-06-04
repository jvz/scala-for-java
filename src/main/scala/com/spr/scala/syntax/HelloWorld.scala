package com.spr.scala.syntax

/**
  * This class demonstrates the canonical hello world example in Scala.
  */
// note that we use "object" instead of "class" here essentially meaning that all methods and fields defined here are
// static. while not strictly true to how Scala compiles this, an object is similar to an enum with only a single
// instance
object HelloWorld {
  // arrays use the same syntax in Scala as other collections, so the syntax is more consistent
  // Unit is essentially a void return type as all expressions in Scala must return something
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
  }
}
