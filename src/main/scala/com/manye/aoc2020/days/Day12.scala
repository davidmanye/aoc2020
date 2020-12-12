package com.manye.aoc2020.days

import com.manye.aoc2020.model.NavigationInstruction.EAST
import com.manye.aoc2020.model.{Position, Ship}
import com.manye.aoc2020.utils.InputUtils

object Day12 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_12.txt")
    println("Part 1: Figure out where the navigation instructions lead. What is the Manhattan distance between that location and the ship's starting position?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_12.txt")
    println("Part 2: Figure out where the navigation instructions actually lead. What is the Manhattan distance between that location and the ship's starting position?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Long = {
    val instructions  = InputUtils.inputToNavigationInstructions(input)
    val initialShip = Ship(EAST, 0, 0, Position(0, 0))
    val endShip = instructions.foldLeft(initialShip)(_.move(_))
    initialShip.distance(endShip.x, endShip.y)
  }

  def solvePart2(input: String): Long = {
    val instructions  = InputUtils.inputToNavigationInstructions(input)
    val initialShip = Ship(EAST, 0, 0, Position(10, 1))
    val endShip = instructions.foldLeft(initialShip)(_.move(_))
    initialShip.distance(endShip.x, endShip.y)
  }
}
