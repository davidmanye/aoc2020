package com.manye.aoc2020.model

import com.manye.aoc2020.model.Seat.{searchColumn, searchRow}

import scala.annotation.tailrec

object Seat {

  val lengthRow = 128
  val lengthColumn = 8

  def searchRow(location: String): Int = {
    val rowLocation = getRowLocation(location)
    searchPosition(rowLocation, (0, lengthRow - 1), ('F', 'B'))
  }

  def searchColumn(location: String): Int = {
    val rowLocation = getColumnLocation(location)
    searchPosition(rowLocation, (0, lengthColumn - 1), ('L', 'R'))
  }

  def divideRange(range: (Int, Int)): Array[(Int, Int)] = {
    val length = range._2 - range._1 + 1
    val firstLower = range._1
    val firstUpper = firstLower + (length/2)
    Array((firstLower, firstUpper - 1), (firstUpper, range._2))
  }

  @tailrec
  private def searchPosition(location: String, range: (Int, Int), lowerUpper: (Char, Char)): Int = {
    if ((range._2 - range._1) == 1) {
      location.head match {
        case lowerUpper._1 => range._1
        case lowerUpper._2 => range._2
      }
    } else {
      val rangeDivided: Array[(Int, Int)] = divideRange(range)
      location.head match {
        case lowerUpper._1 => searchPosition(location.tail, rangeDivided(0), lowerUpper)
        case lowerUpper._2 => searchPosition(location.tail, rangeDivided(1), lowerUpper)
      }
    }
  }

  def getRowLocation(location: String): String = {
    location.substring(0, 7)
  }

  def getColumnLocation(location: String): String = {
    location.substring(7, 10)
  }
}

case class Seat(location: String) {

  val row: Int = searchRow(location)
  val column: Int = searchColumn(location)
  val seatId: Int = row * 8 + column


//  def searchColumn(location: String): Int = {
//
//  }
}
