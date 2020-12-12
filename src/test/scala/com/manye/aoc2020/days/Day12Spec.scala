package com.manye.aoc2020.days

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.{be, convertToAnyShouldWrapper}

class Day12Spec extends AnyFunSuite {

  test("Day12 solvePart1") {
    Day12.solvePart1("/test_input/day_12.txt") should be (25)
  }
}
