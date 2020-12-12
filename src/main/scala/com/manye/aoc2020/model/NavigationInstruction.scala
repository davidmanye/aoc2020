package com.manye.aoc2020.model

import scala.annotation.tailrec

case class Direction(name: Char, left: Char, right: Char)

object NavigationInstruction {

  val NORTH: Char = 'N'
  val SOUTH: Char = 'S'
  val EAST: Char = 'E'
  val WEST: Char = 'W'
  val LEFT = 'L'
  val RIGHT = 'R'
  val FORWARD = 'F'

  def parse(instruction: String): NavigationInstruction = {
    NavigationInstruction(instruction.head, instruction.tail.toInt)
  }

  @tailrec
  def turn(instr: NavigationInstruction, position: Position): Position = {
    if (instr.number == 0) position
    else {
      val newInstruction = NavigationInstruction(instr.action, instr.number - 90)
      instr.action match {
        case LEFT => turn(newInstruction, Position(-position.y, position.x))
        case RIGHT => turn(newInstruction, Position(position.y, -position.x))
      }
    }
  }
}

case class NavigationInstruction(action: Char, number: Int)
