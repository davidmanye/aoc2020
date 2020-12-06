package com.manye.aoc2020.days

import com.manye.aoc2020.utils.InputUtils

object Day06 {

  type Answers = Set[Char]
  type Persons = Array[Answers]
  type Groups = Array[Persons]

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_06.txt")
    println("Part 1: For each group, count the number of questions to which anyone answered \"yes\". What is the sum of those counts?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_06.txt")
    println("Part 2: For each group, count the number of questions to which everyone answered \"yes\". What is the sum of those counts?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(file: String): Int = {
    // Group[Person[Answer]]
    val groups: Groups = parseGroups(file)
    sumCounts(groups, countAllDistinctYes)
  }

  def solvePart2(file: String): Int = {
    // Group[Person[Answer]]
    val groups: Groups = parseGroups(file)
    sumCounts(groups, countCommonYes)
  }

  def parseGroups(file: String): Groups = {
    InputUtils
      .inputToListByBlankLines(file)
      .map(_.split("\\n").map(_.toCharArray.toSet))
  }

  def countAllDistinctYes(persons: Persons): Int = {
    persons.flatMap(_.toSet).toSet.size
  }

  def sumCounts(groups: Groups, countAs: Persons => Int): Int = {
    groups.map(countAs).sum
  }

  def countCommonYes(persons: Persons): Int = {
    persons.reduce(_.intersect(_)).size
  }

}
