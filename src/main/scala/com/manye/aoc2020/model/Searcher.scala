package com.manye.aoc2020.model

import scala.::
import scala.annotation.tailrec

object Searcher {

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

  def findContinuousSum(numbers: List[Long], target: Long): List[Long] = {
    findContinuousSum(numbers.tail, target, List(numbers.head))
  }

  @tailrec
  private def findContinuousSum(numbers: List[Long], target:Long, accumulation: List[Long]): List[Long] = {
    val accumulated = accumulation.sum
    if (numbers.isEmpty || accumulation.isEmpty) {
      List()
    } else if (accumulated == target) {
      accumulation
    } else if (accumulated > target) {
      findContinuousSum(numbers, target, accumulation.tail)
    } else {
      findContinuousSum(numbers.tail, target, accumulation :+ numbers.head)
    }
  }

}
