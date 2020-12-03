package com.manye.aoc2020.days

import com.manye.aoc2020.model.Forest
import com.manye.aoc2020.utils.InputUtils
import org.scalatest.funsuite.AnyFunSuite

class Day03Spec extends AnyFunSuite {

  lazy val forest = new Forest(InputUtils.inputToArrayChar("/test_input/day_03.txt"))

  test("Day03 part01 example") {
    assert(Day03.solvePart1("/test_input/day_03.txt") === 7)
  }

  test("Day03 part01 exercise") {
    assert(Day03.solvePart1("/inputs/day_03.txt") === 292)
  }
  test("Day03 part02 exercise") {
    assert(Day03.solvePart2("/inputs/day_03.txt") === 9354744432L)
  }

  test("Day03 part02 calculateTreesInSlope") {
    assert(Day03.calculateTreesInSlope(forest, (1, 1)) === 2)
    assert(Day03.calculateTreesInSlope(forest, (3, 1)) === 7)
    assert(Day03.calculateTreesInSlope(forest, (5, 1)) === 3)
    assert(Day03.calculateTreesInSlope(forest, (7, 1)) === 4)
    assert(Day03.calculateTreesInSlope(forest, (1, 2)) === 2)
  }

  test("Day03 part02 example") {
    assert(Day03.solvePart2("/test_input/day_03.txt") === 336)
  }

}
