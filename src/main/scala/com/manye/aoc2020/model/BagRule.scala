package com.manye.aoc2020.model

object BagRule {

  private val PatternBag = "([\\w]+) ([\\w]+) bag(?s)".r
  private val PatternBagCount = "([\\d]+) ([\\w]+) ([\\w]+) bag(?s)".r

  def parse(line: String): BagRule = {
    val parts = line.split("contain")
    val bag = PatternBag.findFirstMatchIn(parts(0)).map {
      case PatternBag(adj, color) => Bag(adj, color)
    }.get
    val bagCounts = PatternBagCount.findAllMatchIn(parts(1)).map {
      case PatternBagCount(count, adjective, color) => BagCount(count.toInt, Bag(adjective, color))
    }.toArray
    BagRule(bag, bagCounts)
  }
}

class Rules(rules: Iterable[BagRule]) {

  val bags: Map[String, BagRule] = rules.map(rule => rule.bag.name -> rule).toMap

  def canContain(outBag: Bag, inBag: Bag): Boolean = {
    bags(outBag.name).contains.exists(capacity => capacity.bag.name == inBag.name || canContain(capacity.bag, inBag))
  }

  def countBagsInside(bag: Bag): Long = {
    bags(bag.name).contains.map(countBag => countBag.count + countBag.count * countBagsInside(countBag.bag)).sum
  }
}

case class BagRule(bag: Bag, contains: Array[BagCount])

case class BagCount(count: Int, bag: Bag)

case class Bag(adjective: String, color: String) {

  val name = s"$adjective $color"

}
