package com.manye.aoc2020.model

import com.manye.aoc2020.model.NavigationInstruction.{EAST, FORWARD, LEFT, NORTH, RIGHT, SOUTH, WEST}

case class Ship(direction: Char, x: Int, y: Int, waypoint: Position) {

  def move(instruction: NavigationInstruction): Ship = {
    instruction match {
      case NavigationInstruction(NORTH, number) => Ship(direction, x, y, Position(waypoint.x, waypoint.y + number))
      case NavigationInstruction(SOUTH, number) => Ship(direction, x, y, Position(waypoint.x, waypoint.y - number))
      case NavigationInstruction(EAST, number) => Ship(direction, x, y, Position(waypoint.x + number, waypoint.y))
      case NavigationInstruction(WEST, number) => Ship(direction, x, y, Position(waypoint.x - number, waypoint.y))
      case NavigationInstruction(LEFT, _) | NavigationInstruction(RIGHT, _) => Ship(direction, x, y, NavigationInstruction.turn(instruction, waypoint))
      case NavigationInstruction(FORWARD, number) => Ship(direction, x + number * waypoint.x, y + number * waypoint.y, waypoint)
    }
  }

  def distance(x1: Int, y1: Int): Int = {
    Math.abs(x1 - x) + Math.abs(y1 - y)
  }

}
