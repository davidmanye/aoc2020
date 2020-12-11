package com.manye.aoc2020.days

import com.manye.aoc2020.model.WaitingArea
import com.manye.aoc2020.utils.InputUtils

object Day11 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_11.txt")
    println("Part 1: Simulate your seating area by applying the seating rules repeatedly until no seats change state. How many seats end up occupied?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_11.txt")
    println("Part 2: Given the new visibility method and the rule change for occupied seats becoming empty, once equilibrium is reached, how many seats end up occupied?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Long = {
    var area = WaitingArea(InputUtils.inputToArrayChar(input))
    while (true) {
      val newArea = area.occupy()
      if (newArea.isSameAs(area)) {
        return newArea.countOccupiedSeats()
      }
      area = newArea
    }
    0
  }

  def solvePart2(input: String): Long = {
    var area = WaitingArea(InputUtils.inputToArrayChar(input))
    while (true) {
      val newArea = area.occupySee()
      if (newArea.isSameAs(area)) {
        return newArea.countOccupiedSeats()
      }
      area = newArea
    }
    0
  }

}
