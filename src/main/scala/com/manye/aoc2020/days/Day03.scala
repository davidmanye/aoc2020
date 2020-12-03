package com.manye.aoc2020.days

import com.manye.aoc2020.model.{Forest, Position}
import com.manye.aoc2020.utils.InputUtils

object Day03 {

  def main(args: Array[String]): Unit = {
    val input = "/inputs/day_03.txt"
    val count: Int = solvePart1(input)
    println(s"Part 1: how many trees would you encounter?")
    println(s"Result 1 = $count")
    val result = solvePart2(input)
    println(s"Part 2: What do you get if you multiply together the number of trees encountered on each of the listed slopes?")
    println(s"Result 2 = $result")
  }

  def solvePart1(input: String): Int = {
    val forest = new Forest(InputUtils.inputToArrayChar(input))
    calculateTreesInSlope(forest, (3, 1))
  }

  def solvePart2(input: String): Long = {
    val forest = new Forest(InputUtils.inputToArrayChar(input))
    val slopesList = Seq((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
    slopesList.map(calculateTreesInSlope(forest, _).toLong).product
  }

  def calculateTreesInSlope(forest: Forest, slope: (Int, Int)): Int = {
    Stream
      .iterate(Position(0, 0))(_.add(slope))
      .takeWhile(!forest.isOut(_))
      .count(forest.get(_) == Forest.TREE)
  }
}
