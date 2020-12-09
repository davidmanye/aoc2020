package com.manye.aoc2020.days

import com.manye.aoc2020.model.{XmasData, XmasDataCrack}
import com.manye.aoc2020.utils.InputUtils

object Day09 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_09.txt")
    println("Part 1: The first step of attacking the weakness in the XMAS data is to find the first number in the list (after the preamble) which is not the sum of two of the 25 numbers before it. What is the first number that does not have this property?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_09.txt")
    println("Part 2: What is the encryption weakness in your XMAS-encrypted list of numbers?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Long = {
    val numbers = InputUtils.inputToListLong(input)
    val xmasData = XmasData(numbers, 25)
    XmasDataCrack.findFirstWeakness(xmasData)
  }

  def solvePart2(input: String): Long = {
    val numbers = InputUtils.inputToListLong(input)
    val xmasData = XmasData(numbers, 25)
    XmasDataCrack.findWeakness(xmasData)
  }

}
