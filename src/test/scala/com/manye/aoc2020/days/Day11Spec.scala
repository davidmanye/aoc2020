package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.matchers.should.Matchers.be

class Day11Spec extends AnyFunSuite {

  test("Day11 solvePart2") {
    Day11.solvePart2("/test_input/day_11.txt") should be (26)
  }
}
