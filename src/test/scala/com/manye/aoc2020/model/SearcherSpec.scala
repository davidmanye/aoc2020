package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec

class SearcherSpec extends AnyFlatSpec {

  "findEntries" should "found 2 numbers sum target" in {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Searcher.findEntries(example, 2, 2020) === List(1721, 299))
  }

  it should "found 3 numbers sum target" in {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Searcher.findEntries(example, 3, 2020) === List(979, 366, 675))
  }

  "findEntriesOptimized" should "found 2 numbers sum target" in {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Searcher.findEntriesOptimized(example, 2, 2020) === List(1721, 299))
  }

  it should "found 3 numbers sum target" in {
    val example = InputUtils.inputToListLong("/test_input/day_01_p01.txt")
    assert(Searcher.findEntriesOptimized(example, 3, 2020) === List(979, 366, 675))
  }

  "findContinuousSum" should "found 4 numbers continuous sum 127" in {
    val example = InputUtils.inputToListLong("/test_input/day_09.txt")
    assert(Searcher.findContinuousSum(example, 127) === List(15, 25, 47, 40))
  }

  it should "found 2 numbers continuous sum 219" in {
    val example = InputUtils.inputToListLong("/test_input/day_09.txt")
    assert(Searcher.findContinuousSum(example, 219) === List(102, 117))
  }

}
