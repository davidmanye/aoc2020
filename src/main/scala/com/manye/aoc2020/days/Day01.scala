package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils

import scala.annotation.tailrec

object Day01 {

  def findEntries(expenseReport: List[Long], entries: Int, target: Int): List[Long] = {
    expenseReport.combinations(entries).find(_.sum == target).getOrElse(List[Long]())
  }

  def findEntriesOptimized(expenseReport: List[Long], entries: Int, target: Long): List[Long] = {
    if (expenseReport.isEmpty) {
      List()
    } else {
      val head = expenseReport.head
      if (head == target) List(head)
      else {
        val newTarget = target - head
        if (newTarget < 0) findEntriesOptimized(expenseReport.tail, entries, target)
        else {
          val newEntries = entries - 1
          val result = findEntriesOptimized(expenseReport.tail, newEntries, newTarget)
          if (result.length == newEntries && result.sum + expenseReport.head == target) List(head) ++ result
          else findEntriesOptimized(expenseReport.tail, entries, target)
        }
      }
    }
  }

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
