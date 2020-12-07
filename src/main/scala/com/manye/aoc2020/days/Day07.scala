package com.manye.aoc2020.days

import com.manye.aoc2020.model.{Bag, Rules}
import com.manye.aoc2020.utils.InputUtils

object Day07 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_07.txt")
    println("Part 1: How many bag colors can eventually contain at least one shiny gold bag?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_07.txt")
    println("Part 2: How many individual bags are required inside your single shiny gold bag?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(file: String): Int = {
    val bags = InputUtils.inputToBagRuleList(file)
    val rules = new Rules(bags)
    val shinyGold = Bag("shiny", "gold")
    bags.count(bagRule => {
      rules.canContain(bagRule.bag, shinyGold)
    })
  }

  def solvePart2(file: String): Long = {
    val bags = InputUtils.inputToBagRuleList(file)
    val rules = new Rules(bags)
    val shinyGold = Bag("shiny", "gold")
    rules.countBagsInside(shinyGold)
  }
}
