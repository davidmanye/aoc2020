package com.manye.aoc2020.days

import com.manye.aoc2020.days.Day06.Groups
import org.scalatest.funsuite.AnyFunSuite

class Day06Spec extends AnyFunSuite {

  val groups: Groups = Day06.parseGroups("/test_input/day_06.txt")

  test("countAllDistinctYes by groups") {
    assert(Day06.countAllDistinctYes(groups.head) === 3)
    assert(Day06.countAllDistinctYes(groups(1)) === 3)
    assert(Day06.countAllDistinctYes(groups(2)) === 3)
    assert(Day06.countAllDistinctYes(groups(3)) === 1)
    assert(Day06.countAllDistinctYes(groups(4)) === 1)
  }

  test("Day06 part1 exercise") {
    assert(Day06.solvePart1("/inputs/day_06.txt") === 6506)
  }

  test("countCommonYes by groups") {
    assert(Day06.countCommonYes(groups.head) === 3)
    assert(Day06.countCommonYes(groups(1)) === 0)
    assert(Day06.countCommonYes(groups(2)) === 1)
    assert(Day06.countCommonYes(groups(3)) === 1)
    assert(Day06.countCommonYes(groups(4)) === 1)
  }

  test("Day06 part2 exercise") {
    assert(Day06.solvePart2("/inputs/day_06.txt") === 3243)
  }
}
