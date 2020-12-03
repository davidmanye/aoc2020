package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec

class ForestSpec extends AnyFlatSpec with BeforeAndAfterAll {

  lazy val forest = new Forest(InputUtils.inputToArrayChar("/test_input/day_03.txt"))

  "validX" should "return same X if it's in pattern square" in {
    assert(forest.validX(0, 0) === 0)
    assert(forest.validX(6, 0) === 6)
    assert(forest.validX(8, 0) === 8)
    assert(forest.validX(10, 0) === 10)
  }

  it should "return same valid X if it's in out pattern square" in {
    assert(forest.validX(11, 0) === 0)
    assert(forest.validX(17, 0) === 6)
    assert(forest.validX(19, 0) === 8)
    assert(forest.validX(20, 0) === 9)
  }

  "get" should "return char if it's in pattern square" in {
    assert(forest.get(0,0) === '.')
    assert(forest.get(0,2) === '.')
    assert(forest.get(6,2) === '#')
    assert(forest.get(0,10) === '.')
    assert(forest.get(10,10) === '#')
  }

  it should "return char if it's in out square pattern" in {
    assert(forest.get(11,0) === '.')
    assert(forest.get(11,2) === '.')
    assert(forest.get(17,2) === '#')
    assert(forest.get(11,10) === '.')
    assert(forest.get(21,10) === '#')
  }

  "isOut" should "return true if x or y is negative" in {
    assert(forest.isOut(-1, 0))
    assert(forest.isOut(0, -5))
  }

  it should "return true if y is greater or equal than height" in {
    assert(forest.isOut(0, 11))
    assert(forest.isOut(21, 11))
  }

  it should "return false if x is greater or equal than width" in {
    assert(forest.isOut(0, 5) === false)
    assert(forest.isOut(21, 5) === false)
    assert(forest.isOut(45, 5) === false)
  }

}
