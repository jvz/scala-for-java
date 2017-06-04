package com.spr.scala.syntax

/**
  * Demonstrates various ways to create anonymous functions.
  */
object AnonymousFunctions {

  def anonymousClassSyntax: String => Int = new Function[String, Int] {
    override def apply(v1: String): Int = Integer.parseInt(v1)
  }

  def lambdaSyntax: String => Int = s => Integer.parseInt(s)

  def altLambdaSyntax: String => Int = { s =>
    Integer.parseInt(s)
  }

  def lambdaAnonymousParameterSyntax: String => Int = Integer.parseInt(_)

  def functionReferenceSyntax: String => Int = Integer.parseInt

  def multiParamLambdaSyntax: (String, Int) => Boolean = (s, i) => Integer.parseInt(s) == i
}
