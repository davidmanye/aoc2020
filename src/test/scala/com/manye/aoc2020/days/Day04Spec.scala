package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite

class Day04Spec extends AnyFunSuite {

  test("Day04 part01 example") {
    assert(Day04.solvePart1("/test_input/day_04.txt") === 2)
  }

  test("Day04 part01 exercise") {
    assert(Day04.solvePart1("/inputs/day_04.txt") === 226)
  }

  test("Day04 part02 example") {
    assert(Day04.solvePart2("/test_input/day_04.txt") === 2)
  }

  test("Day04 part02 exercise") {
    assert(Day04.solvePart2("/inputs/day_04.txt") === 160)
  }
}
