package com.manye.aoc2020.model

object XmasDataCrack {

  def findFirstWeakness(xmasData: XmasData): Long = {
    val size = 2
    while (xmasData.hasNext) {
      val entry = xmasData.current
      val weakness = Searcher.findEntriesOptimized(xmasData.preamble, size, entry)
      if (weakness.isEmpty) {
        return entry
      }
      xmasData.next()
    }
    0
  }

  def findWeakness(xmasData: XmasData): Long = {
    val firstStep = findFirstWeakness(xmasData)
    val continuous = Searcher.findContinuousSum(xmasData.numbers, firstStep)
    continuous.min + continuous.max
  }

}
