package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils

import scala.annotation.tailrec
import scala.collection.mutable

object Day10 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_10.txt")
    println("Part 1: What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_10.txt")
    println("Part 2: What is the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Long = {
    val numbers = InputUtils.inputToListLong(input)
    val adapters: List[Long] = concatAdapters(numbers)
    val differences = countDifferences(adapters)
    differences.getOrElse(1, 0) * differences.getOrElse(3, 0)
  }

  def solvePart2(input: String): Long = {
    val numbers = InputUtils.inputToListLong(input)
    countDistinctWays(numbers)
  }

  def concatAdapters(numbers: List[Long]): List[Long] = {
    val adapters = numbers.sorted
    (0L :: adapters) :+ (adapters.max + 3L)
  }

  def countDifferences(adapters: List[Long]): Map[Int, Int] = {
    (0 until adapters.size - 1).map(index => adapters(index + 1) - adapters(index)).groupBy(diff => diff.toInt).mapValues(_.size)
  }

  def countDistinctWays(jolts: List[Long]): Long = {
    val builtinJolt = jolts.max + 3L
    val allJolts = builtinJolt +: jolts

    @tailrec
    def helper(jolts: List[Long], prevs: Map[Long, Long]): Long = jolts match {
      case Nil => prevs(builtinJolt)
      case jolt :: newJolts =>
        val joltValue = (1 to 3).map(i => prevs(jolt - i)).sum
        val newPrevs = prevs + (jolt -> joltValue)
        helper(newJolts, newPrevs)
    }

    helper(allJolts.sorted, Map(0L -> 1L).withDefaultValue(0))
  }

  def isValid(adapters: List[Long]): Boolean = {
    !(0 until adapters.size - 1).toStream.map(index => adapters(index + 1) - adapters(index)).exists(_ > 3)
  }

}
