package com.manye.aoc2020.model

case class XmasData(numbers: List[Long], preambleSize: Int) {

  var preambleCursor: Int = 0

  def preamble: List[Long] = {
    numbers.slice(preambleCursor, currentCursor)
  }

  def data: List[Long] = {
    numbers.slice(currentCursor, numbers.length)
  }

  def current: Long = numbers(currentCursor)

  def currentCursor: Int = preambleCursor + preambleSize

  def hasNext: Boolean = currentCursor < numbers.size

  def next(): Unit = preambleCursor += 1
}
