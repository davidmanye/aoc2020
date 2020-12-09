package com.manye.aoc2020.days

import com.manye.aoc2020.model.Searcher.{findEntries, findEntriesOptimized}
import com.manye.aoc2020.utils.InputUtils

object Day01 {



  def solvePart1(expenseReport: List[Long]): Long = {
    val entries = findEntries(expenseReport, 2, 2020)
    val result = entries.product
    println(s"Part 1: $result")
    result
  }

  def solvePart2(expenseReport: List[Long]): Long = {
    val entries = findEntries(expenseReport, 3, 2020)
    val result = entries.product
    println(s"Part 2: $result")
    result
  }

  def solvePart1Optimized(expenseReport: List[Long]): Long = {
    val entries = findEntriesOptimized(expenseReport, 2, 2020)
    val result = entries.product
    println(s"Part 1: $result")
    result
  }

  def solvePart2Optimized(expenseReport: List[Long]): Long = {
    val entries = findEntriesOptimized(expenseReport, 3, 2020)
    val result = entries.product
    println(s"Part 2: $result")
    result
  }

  def main(args: Array[String]): Unit = {
    val expenseReport = InputUtils.inputToListLong("/inputs/day_01.txt")
    solvePart1(expenseReport)
    solvePart2(expenseReport)
  }
}
