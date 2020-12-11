package com.manye.aoc2020.model

import com.manye.aoc2020.model.WaitingArea.{EMPTY, OCCUPIED, adjacents}

object WaitingArea {

  val OCCUPIED = '#'
  val EMPTY = 'L'

  val adjacents: Iterable[(Int, Int)] = { val adjacent = -1 * 1 to 1
  adjacent
    .flatMap(sumX => adjacent.map(sumY => (sumX, sumY)))
    .filter { case (adjX, adjY) => !(adjX == 0 && adjY == 0) }
  }
}

case class WaitingArea(area: Array[Array[Char]]) {

  def occupy(): WaitingArea = {
    occupy(countAdjacentOccupied, 4)
  }

  def occupySee(): WaitingArea = {
    occupy(countSeeOccupied, 5)
  }

  def occupy(count: (Int, Int) => Int, tolerance: Int): WaitingArea = {
    val newArea = Array.ofDim[Char](area.length, area(0).length)
    for (y <- area.indices) {
      for (x <- area(y).indices) {
        get(x, y) match {
          case EMPTY => if (count(x, y) == 0) newArea(y)(x) = OCCUPIED else newArea(y)(x) = EMPTY
          case OCCUPIED => if (count(x, y) >= tolerance) newArea(y)(x) = EMPTY else newArea(y)(x) = OCCUPIED
          case _ => newArea(y)(x) = get(x, y)
        }
      }
    }
    WaitingArea(newArea)
  }

  def countAdjacentOccupied(x: Int, y: Int): Int = {
    getAdjacent(x, y, 1)
      .count { case (adjX, adjY) => isOccupied(adjX, adjY) }
  }

  def countSeeOccupied(x: Int, y: Int): Int = {
    adjacents
      .count { case (adjX, adjY) => seeOccupied(x + adjX, y + adjY, adjX, adjY) }
  }

  def getAdjacent(x: Int, y: Int, numAdjacent: Int): Iterable[(Int, Int)] = {
    val adjacent = -1 * numAdjacent to numAdjacent
    adjacent
      .flatMap(sumX => adjacent.map(sumY => (sumX + x, sumY + y)))
      .filter { case (adjX, adjY) => !(adjX == x && adjY == y) }
  }

  def seeOccupied(x: Int, y: Int, sumX: Int, sumY: Int): Boolean = {
    if (isOut(x, y)) {
      return false
    } else if (isSeat(x, y)) {
      if (isOccupied(x, y)) {
        return true
      }
      return false
    }
    seeOccupied(x + sumX, y + sumY, sumX, sumY)
  }

  def isOut(x: Int, y: Int): Boolean = {
    if (0 <= y && y < area.length) {
      if (0 <= x && x < area(y).length) {
        return false
      }
    }
    true
  }

  def isSeat(x: Int, y: Int): Boolean = {
    if (0 <= y && y < area.length) {
      if (0 <= x && x < area(y).length) {
        val square = get(x, y)
        return square == OCCUPIED || square == EMPTY
      }
    }
    false
  }

  def isOccupied(x: Int, y: Int): Boolean = {
    if (0 <= y && y < area.length) {
      if (0 <= x && x < area(y).length) {
        return get(x, y) == OCCUPIED
      }
    }
    false
  }

  def get(x: Int, y: Int): Char = {
    area(y)(x)
  }

  def printMatrix(): Unit = {
    for (y <- area) {
      for (x <- y) {
        print(x)
      }
      println()
    }
  }

  def countOccupiedSeats(): Long = {
    area.flatMap(row => row.toSeq).count(_==OCCUPIED)
  }

  def isSameAs(area: WaitingArea): Boolean = {
    for (y <- this.area.indices) {
      for (x <- this.area(y).indices) {
        if (this.get(x, y) != area.get(x, y)) return false
      }
    }
    true
  }
}
