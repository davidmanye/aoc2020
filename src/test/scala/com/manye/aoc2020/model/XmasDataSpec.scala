package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{be, contain}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class XmasDataSpec extends AnyFlatSpec {

  lazy val numbers: List[Long] = InputUtils.inputToListLong("/test_input/day_09.txt")

  "create" should "split preamble from data" in {
    val data = XmasData(numbers, 5)
    data.preamble should contain allOf (35, 20, 15, 25, 47)
    data.data should contain allOf (40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
    data.next() should be (40)
    data.next() should be (62)
    data.next() should be (55)
  }


}
