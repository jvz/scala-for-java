package com.spr.scala.syntax

/**
  * This class demonstrates primitive types and assignment along with strings.
  */
class PrimitiveTypes {
  // using "var" makes the variable or field mutable, while using "val" makes the variable final and immutable
  // note that types come after the variable instead of before
  // also note that Scala does not make a distinction between boxed and unboxed primitive values and will attempt to
  // compile away any boxing when possible
  var flag: Boolean = true
  var b: Byte = 42
  var c: Char = '4'
  var s: Short = 42
  var i: Int = 42
  var l: Long = 42
  // due to implicit conversions instead of primitive widening and narrowing, we don't need to mark the constant as a
  // float as well
  var f: Float = 42
  var d: Double = 42
  // Scala uses the same java.lang.String type, though it does provide a type alias for it
  var str: String = "Hello, world!"
}
