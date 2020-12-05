package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite

class Day05Spec extends AnyFunSuite {

  test("Day05 part01 exercise") {
    assert(Day05.solvePart1("/inputs/day_05.txt") === 989)
  }

  test("Day05 part02 exercise") {
    assert(Day05.solvePart2("/inputs/day_05.txt") === 548)
  }

}
