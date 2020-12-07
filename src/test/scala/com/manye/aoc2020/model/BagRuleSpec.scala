package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{be, contain, have}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class BagRuleSpec extends AnyFlatSpec {

  lazy val rules: Rules = new Rules(InputUtils.inputToBagRuleList("/test_input/day_07.txt"))

  "parse" should "return bag with its bag counts when greater 1" in {
    val bagRule = BagRule.parse("light red bags contain 1 bright white bag, 2 muted yellow bags.")
    bagRule.bag should be (Bag("light", "red"))
    bagRule.contains should contain allOf (BagCount(1, Bag("bright", "white")), BagCount(2, Bag("muted", "yellow")))
  }

  it should "return bag with its bag counts when equal 1" in {
    val bagRule = BagRule.parse("bright white bags contain 1 shiny gold bag.")
    bagRule.bag should be (Bag("bright", "white"))
    bagRule.contains should contain allElementsOf Array(BagCount(1, Bag("shiny", "gold")))
  }

  it should "return bag with its bag counts when empty" in {
    val bagRule = BagRule.parse("bright white bags contain no other bags.")
    bagRule.bag should be (Bag("bright", "white"))
    bagRule.contains should have size 0
  }

  "canContain" should "return true if any sub bag can contain the inBag" in {
    val shinyGold = Bag("shiny", "gold")
    assert(rules.canContain(Bag("bright", "white"), shinyGold))
    assert(rules.canContain(Bag("muted", "yellow"), shinyGold))
    assert(rules.canContain(Bag("dark", "orange"), shinyGold))
    assert(rules.canContain(Bag("light", "red"), shinyGold))
    assert(!rules.canContain(Bag("faded", "blue"), shinyGold))
    assert(!rules.canContain(Bag("shiny", "gold"), shinyGold))
    assert(!rules.canContain(Bag("dark", "olive"), shinyGold))
  }

  "countBagsInside" should "return 0 when bag cannot contain other bag" in {
    assert(rules.countBagsInside(Bag("dotted", "black")) == 0)
  }

}
