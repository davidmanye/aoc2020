package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite

class Day08Spec extends AnyFunSuite {

  test("Day08 part1 example") {
    assert(Day08.solvePart1("/test_input/day_08.txt") === 5)
  }

  test("Day08 part2 example") {
    assert(Day08.solvePart2("/test_input/day_08.txt") === 8)
  }

}
