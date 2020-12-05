package com.manye.aoc2020.days

import com.manye.aoc2020.model.Seat
import com.manye.aoc2020.utils.InputUtils

object Day05 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_05.txt")
    println("Part1: What is the highest seat ID on a boarding pass?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_05.txt")
    println("Part2: What is the ID of your seat?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Int = {
    InputUtils
      .inputToLines(input)
      .map(Seat(_))
      .maxBy(_.seatId)
      .seatId
  }

  def solvePart2(input: String): Int = {
    val boardingPassList = InputUtils.inputToLines(input).map(Seat(_).seatId)
    val fullIds = (0 to ((Seat.lengthRow - 1) * 8 + (Seat.lengthColumn - 1))).toSet
    val remainingSeats = (fullIds diff boardingPassList.toSet).toList.sorted
    remainingSeats.toStream.zipWithIndex find {
      case (current, index) => remainingSeats(index + 1) - current > 1
    } map {
      case (_, index) => remainingSeats(index + 1)
    } getOrElse 0
  }
}
