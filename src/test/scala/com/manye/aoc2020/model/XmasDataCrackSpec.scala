package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec

class XmasDataCrackSpec extends AnyFlatSpec {

  lazy val xmasDataExample: XmasData = XmasData(InputUtils.inputToListLong("/test_input/day_09.txt"), 5)

  "findFirstWeakness" should "return first number which is not the sum of two in preamble" in {
    assert(XmasDataCrack.findFirstWeakness(xmasDataExample) === 127)
  }

  "findWeakness" should "return sum of min and max from continuous sum" in {
    assert(XmasDataCrack.findWeakness(xmasDataExample) === 62)
  }

}
