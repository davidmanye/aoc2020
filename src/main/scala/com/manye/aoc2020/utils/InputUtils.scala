package com.manye.aoc2020.utils

import com.manye.aoc2020.model.Passport

import java.io.InputStream
import scala.io.Source

object InputUtils {

  def inputToListLong(file: String): List[Long] = {
    Source.fromInputStream(inputStream(file)).getLines().map(_.toLong).toList
  }

  def inputStream(file: String): InputStream = {
    InputUtils.getClass.getResourceAsStream(file)
  }

  def inputToLines(file: String): Iterator[String] = {
    Source.fromInputStream(inputStream(file)).getLines()
  }

  def inputToArrayChar(file: String): Array[Array[Char]] = {
    inputToLines(file)
      .toArray
      .map(_.toCharArray)
  }

  def inputToPassportList(file: String): List[Passport] = {
    val string = Source
      .fromInputStream(inputStream(file))
      .mkString
    string.split("\n\n")
      .map(Passport.parse)
      .toList
  }

}
