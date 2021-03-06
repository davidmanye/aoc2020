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

  def get(position: Position): Char = {
    get(position.x, position.y)
  }

  def validX(x: Int, y: Int): Int = {
    val width = pattern(y).length
    if (x >= width) {
      return x % width
    }
    x
  }

  def isOut(x: Int, y: Int): Boolean = {
    x < 0 || y < 0 || y >= height
  }

  def isOut(position: Position): Boolean = {
    isOut(position.x, position.y)
  }
}
