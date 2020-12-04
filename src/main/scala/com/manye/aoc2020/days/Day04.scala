package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils

object Day04 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_04.txt")
    println("Part 1: Count the number of valid passports - those that have all required fields. Treat cid as optional. In your batch file, how many passports are valid?")
    println(s"Result 1: $result1")
    val result2 = solvePart2("/inputs/day_04.txt")
    println("Part 2: Count the number of valid passports - those that have all required fields and valid values. Continue to treat cid as optional. In your batch file, how many passports are valid?")
    println(s"Result 2: $result2")
  }

  def solvePart1(input: String): Int = {
    val passports = InputUtils.inputToPassportList(input)
    passports.count(_.hasRequiredFields)
  }

  def solvePart2(input: String): Int = {
    val passports = InputUtils.inputToPassportList(input)
    passports.count(_.isValid)
  }

}
