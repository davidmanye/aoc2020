package com.manye.aoc2020.model

import com.manye.aoc2020.model.NavigationInstruction.{EAST, FORWARD, NORTH, RIGHT, SOUTH}
import org.scalatest.flatspec.AnyFlatSpec

class ShipSpec extends AnyFlatSpec {

  private val part1Waypoint = Position(1, 1)
  private val part2Waypoint = Position(10, 1)

  //  "move" should "do correctly F10" in {
  //    assert(Ship(EAST, 0, 0, part1Waypoint).move(NavigationInstruction(FORWARD, 10)) == Ship(EAST, 10, 0, part1Waypoint))
  //  }
  //
  //  it should "do correctly N3" in {
  //    assert(Ship(EAST, 10, 0, part1Waypoint).move(NavigationInstruction(NORTH, 3)) == Ship(EAST, 10, 3, part1Waypoint))
  //  }
  //
  //  it should "do correctly F7" in {
  //    assert(Ship(EAST, 10, 3, part1Waypoint).move(NavigationInstruction(FORWARD, 7)) == Ship(EAST, 17, 3, part1Waypoint))
  //  }
  //
  //  it should "do correctly R90" in {
  //    assert(Ship(EAST, 17, 3, part1Waypoint).move(NavigationInstruction(RIGHT, 90)) == Ship(SOUTH, 17, 3, part1Waypoint))
  //  }
  //
  //  it should "do correctly F11" in {
  //    assert(Ship(SOUTH, 17, 3, part1Waypoint).move(NavigationInstruction(FORWARD, 11)) == Ship(SOUTH, 17, -8, part1Waypoint))
  //  }

  "move part 2" should "do correctly F10" in {
    assert(Ship(EAST, 0, 0, Position(10, 1)).move(NavigationInstruction(FORWARD, 10)) == Ship(EAST, 100, 10, Position(10, 1)))
  }

  it should "do correctly N3" in {
    assert(Ship(EAST, 100, 10, Position(10, 1)).move(NavigationInstruction(NORTH, 3)) == Ship(EAST, 100, 10, Position(10, 4)))
  }

  it should "do correctly F7" in {
    assert(Ship(EAST, 100, 10, Position(10, 4)).move(NavigationInstruction(FORWARD, 7)) == Ship(EAST, 170, 38, Position(10, 4)))
  }

  it should "do correctly R90" in {
    assert(Ship(EAST, 170, 38, Position(10, 4)).move(NavigationInstruction(RIGHT, 90)) == Ship(EAST, 170, 38, Position(4, -10)))
  }

  it should "do correctly F11" in {
    assert(Ship(SOUTH, 170, 38, Position(4, -10)).move(NavigationInstruction(FORWARD, 11)) == Ship(SOUTH, 214, -72, Position(4, -10)))
  }

}
