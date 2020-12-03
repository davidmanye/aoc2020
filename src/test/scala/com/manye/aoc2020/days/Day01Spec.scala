package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.funsuite.AnyFunSuite

class Day01Spec extends AnyFunSuite {

  test("Day01 part01 example") {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Day01.findEntries(example, 2, 2020) === List(1721, 299))
  }

  test("Day01 part02 example") {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Day01.findEntries(example, 3, 2020) === List(979, 366, 675))
  }

  test("Day01 part01 exercise") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart1(example) === 876459)
  }

  test("Day01 part02 exercise") {
    val example = InputUtils.inputToListLong("/inputs/day_01.txt")
    assert(Day01.solvePart2(example) === 116168640)
  }

  test("Day01 part01 example optimized") {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Day01.findEntriesOptimized(example, 2, 2020) === List(1721, 299))
  }

  test("Day01 part02 example optimized") {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Day01.findEntriesOptimized(example, 3, 2020) === List(979, 366, 675))
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
