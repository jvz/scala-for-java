package com.spr.scala.syntax

import java.io.{InputStream, OutputStream}


/**
  * Overview of control structures and basic methods.
  */
object ControlStructures {

  // in Scala, the if/else syntax is an expression, so it works similarly to the ternary operator in Java
  def parseInt(s: String): Int =
    if (s == null) 0 else s.toInt

  def copy(in: InputStream, out: OutputStream): Long = {
    val buf = Array.ofDim[Byte](8192)
    var count: Long = 0
    var read: Int = 0
    // unlike Java, the result of assignment is (), not the assigned value
    // in Scala, this pattern doesn't work well as can be seen here:
    read = in.read(buf)
    while (read != -1) {
      count += read
      out.write(buf, 0, read)
      read = in.read(buf)
    }
    // we don't need to specify "return" when we return the last line of a function
    count
  }

  // Unit is essentially a void return value
  def printNLines(line: String, n: Int): Unit = {
    // instead of typical for loops, Scala provides us with very powerful foreach loops
    // in this example, <- is the "in" operator, a 0.to(n) (or "0 to n" in infix notation) creates an iterable range
    // also note we do not need to declare a "val" before "i"
    for (i <- 0 to n) {
      // template strings are super handy and are created by prefixing a string with s
      println(s"$i: $line")
    }
  }

  // switch statements are called "match" in Scala and can do the same as switch statements, but instead are
  // expressions that return a value. they can also do a lot more, but we'll start with simple equality checks
  // also note that the equivalent type for Class<?> is Class[_]
  def parsePrimitiveName(c: Char): Class[_] = c match {
    // instead of using Foo.class, Scala uses classOf[Foo] which is more consistent with the type parameter syntax
    case 'Z' => classOf[Boolean]
    case 'B' => classOf[Byte]
    case 'C' => classOf[Char]
    case 'S' => classOf[Short]
    case 'I' => classOf[Int]
    case 'L' => classOf[Long]
    case 'F' => classOf[Float]
    case 'D' => classOf[Double]
    // as a default case, we can match on anything and discard its value with _
    case _ => throw new IllegalArgumentException(s"Invalid type: $c")
  }

  // in Scala, Iterable (which is slightly different from java.lang.Iterable) is not the most generic type we can use
  // for a foreach loop (TraversableOnce is the most generic one), but this is more similar to our Java code
  def joinLines(lines: Iterable[String]): String = {
    // Scala provides its own StringBuilder class on type of the Java one partially due to historical reasons
    val sb = StringBuilder.newBuilder
    for (line <- lines) {
      sb.append(line).append('\n')
    }
    sb.toString()
  }
}
