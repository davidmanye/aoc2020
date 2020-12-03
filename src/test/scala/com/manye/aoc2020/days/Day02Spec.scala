package com.manye.aoc2020.days

import com.manye.aoc2020.days.Day02.parsePasswordLine
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class Day02Spec extends AnyFunSuite {

  test("Day02 part01 parsePasswordList") {
    val example = Iterator("1-3 a: abcde", "1-3 b: cdefg")
    val passwordList = Day02.parsePasswordList(example).toList
    passwordList should have size 2
    val first = passwordList.head
    first.minMax should contain allOf (1, 3)
    first.mandatory should be ('a')
    first.password should contain allOf ('a', 'b', 'c', 'd', 'e')
  }

  test("Day02 part01 isValidByCharacter") {
    assert(Day02.isValidByCharacter(parsePasswordLine("1-3 a: abcde")) === true)
    assert(Day02.isValidByCharacter(parsePasswordLine("1-3 b: cdefg")) === false)
    assert(Day02.isValidByCharacter(parsePasswordLine("2-9 c: ccccccccc")) === true)
  }

  test("Day02 part01 example") {
    assert(Day02.solvePart1("/test_input/day_02.txt") === 2)
  }

  test("Day02 part01 answer") {
    assert(Day02.solvePart1("/inputs/day_02.txt") === 638)
  }

  test("Day02 part02 isValidByPosition") {
    assert(Day02.isValidByPositions(parsePasswordLine("1-3 a: abcde")) === true)
    assert(Day02.isValidByPositions(parsePasswordLine("1-3 b: cdefg")) === false)
    assert(Day02.isValidByPositions(parsePasswordLine("2-9 c: ccccccccc")) === false)
  }

  test("Day02 part02 example") {
    assert(Day02.solvePart2("/test_input/day_02.txt") === 1)
  }
}
