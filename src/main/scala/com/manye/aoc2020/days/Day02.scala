package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils

object Day02 {

  case class PasswordRow(minMax: Array[Int], mandatory: Char, password: Array[Char])

  def countValidByCharacter(passwordList: Iterator[PasswordRow]): Int = {
    passwordList.count(isValidByCharacter)
  }

  def countValidByPosition(passwordList: Iterator[PasswordRow]): Int = {
    passwordList.count(isValidByPositions)
  }

  def main(args: Array[String]): Unit = {
    val input = "/inputs/day_02.txt"
    val valid = solvePart1(input)
    println(s"Part 1: $valid valid passwords")
    val valid2 = solvePart2(input)
    println(s"Part 2: $valid2 valid passwords")
  }

  def solvePart1(input: String): Int = {
    val lines = InputUtils.inputToLines(input)
    val passwordList = parsePasswordList(lines)
    countValidByCharacter(passwordList)
  }

  def solvePart2(input: String): Int = {
    val lines = InputUtils.inputToLines(input)
    val passwordList = parsePasswordList(lines)
    countValidByPosition(passwordList)
  }

  def parsePasswordList(lines: Iterator[String]): Iterator[PasswordRow] = {
    lines.map(parsePasswordLine)
  }

  def parsePasswordLine(line: String): PasswordRow = {
    val sections = line.split(" ")
    val minMax = sections(0).split("-")
    PasswordRow(minMax.map(_.toInt), sections(1).replace(":", "").charAt(0), sections(2).toCharArray)
  }

  def isValidByCharacter(row: PasswordRow): Boolean = {
    val times = row.password.count(c => c == row.mandatory)
    row.minMax(0) <= times && times <= row.minMax(1)
  }

  def isValidByPositions(row: PasswordRow): Boolean = {
    row.minMax.count(position => row.password(position - 1) == row.mandatory) == 1
  }
}
