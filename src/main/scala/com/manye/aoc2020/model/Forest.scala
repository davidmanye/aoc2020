package com.manye.aoc2020.model

object Forest {
  val TREE = '#'
  val OPEN = '.'
}

class Forest(val pattern: Array[Array[Char]]) {

  private val height = pattern.length

  def get(x: Int, y: Int): Char = {
    pattern(y)(validX(x, y))
  }

  def validX(x: Int, y: Int): Int = {
    if (x >= pattern(y).length) {
      return x % pattern(y).length
    }
    x
  }

  def isOut(x: Int, y: Int): Boolean = {
    x < 0 || y < 0 || y >= height
  }
}
