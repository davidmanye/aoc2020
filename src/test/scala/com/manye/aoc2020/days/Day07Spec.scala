package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite

class Day07Spec extends AnyFunSuite {

  test("Day07 part1 example") {
    assert(Day07.solvePart1("/test_input/day_07.txt") === 4)
  }

  test("Day07 part1 exercise") {
    assert(Day07.solvePart1("/inputs/day_07.txt") === 261)
  }

  test("Day07 part2 example") {
    assert(Day07.solvePart2("/test_input/day_07.txt") === 32)
  }

  test("Day07 part2 example deeper") {
    assert(Day07.solvePart2("/test_input/day_07_deeper.txt") === 126)
  }

  test("Day07 part2 exercise") {
    assert(Day07.solvePart2("/inputs/day_07.txt") === 3765)
  }

}
