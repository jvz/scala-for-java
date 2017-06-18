package com.spr.scala.syntax

import java.util.UUID

/**
  * Demonstrates a typical DTO using a case class.
  */
case class DataTransferObject(id: UUID, name: String, version: Long)
