package com.manye.aoc2020.utils

import com.manye.aoc2020.model.{BagRule, Instruction, Passport}

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

  def inputToListByBlankLines(file: String): Array[String] = {
    Source
      .fromInputStream(inputStream(file))
      .mkString
      .split("\n\n")
  }

  def inputToPassportList(file: String): List[Passport] = {
    inputToListByBlankLines(file)
      .map(Passport.parse)
      .toList
  }

  def inputToBagRuleList(file: String): List[BagRule] = {
    inputToLines(file)
      .map(BagRule.parse)
      .toList
  }

  def inputToCode(file: String): Array[Instruction] = {
    inputToLines(file)
      .map(Instruction.parse)
      .toArray
  }
}
