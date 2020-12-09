package com.manye.aoc2020.days

import com.manye.aoc2020.model.Searcher
import com.manye.aoc2020.utils.InputUtils
import org.scalatest.funsuite.AnyFunSuite

class Day01Spec extends AnyFunSuite {

  test("Day01 part01 exercise") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart1(example) === 876459)
  }

  test("Day01 part02 exercise") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart2(example) === 116168640)
  }

  test("Day01 part01 exercise optimized") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart1Optimized(example) === 876459)
  }

  test("Day01 part02 exercise optimized") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart2Optimized(example) === 116168640)
  }
}
