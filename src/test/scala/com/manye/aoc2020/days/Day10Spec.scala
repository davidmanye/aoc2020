package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers.{be, contain}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class Day10Spec extends AnyFunSuite {

  private lazy val list1 = InputUtils.inputToListLong("/test_input/day_10_ex1.txt")

  test("Day10 concatAdapters example 1") {
    Day10.concatAdapters(list1) should contain allOf (1,4,5,6,7,10,11,12,15,16,19)
  }

  test("Day10 countDifferences example 1") {
    Day10.countDifferences(List(0,1,4,5,6,7,10,11,12,15,16,19,22)) should contain allOf (1 -> 7, 3 -> 5)
  }

  test("Day10 solvePart1 example 1") {
    assert(Day10.solvePart1("/test_input/day_10_ex1.txt") === 7 * 5)
  }

  test("Day10 solvePart1 example 2") {
    assert(Day10.solvePart1("/test_input/day_10_ex2.txt") === 22 * 10)
  }

  test("Day10 countDistinctWays example 1") {
    Day10.countDistinctWays(List(1,4,5,6,7,10,11,12,15,16,19)) should be (8)
  }

  test("Day10 countDistinctWays example 2") {
    Day10.solvePart2("/test_input/day_10_ex2.txt") should be (19208)
  }
}
