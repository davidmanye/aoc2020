package com.manye.aoc2020.model

case class Position(x: Int, y: Int) {

  def add(addition: (Int, Int)): Position = {
    Position(x + addition._1, y + addition._2)
  }
}
