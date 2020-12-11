package com.manye.aoc2020.model

import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class WaitingAreaSpec extends AnyFlatSpec {

  "occupy" should "create new WaitingArea Step1" in {
    val initial = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11.txt"))
    val step1 = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_1.txt"))
    initial.occupy().area should contain theSameElementsAs step1.area
  }

  it should "create new WaitingArea Step2" in {
    val initial = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_1.txt"))
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_2.txt"))
    initial.occupy().area should contain theSameElementsAs next.area
  }

  it should "create new WaitingArea Step3" in {
    val initial = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_2.txt"))
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_3.txt"))
    initial.occupy().area should contain theSameElementsAs next.area
  }

  it should "create new WaitingArea Step4" in {
    val initial = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_3.txt"))
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_4.txt"))
    initial.occupy().area should contain theSameElementsAs next.area
  }

  it should "create new WaitingArea Step5" in {
    val initial = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_4.txt"))
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_5.txt"))
    initial.occupy().area should contain theSameElementsAs next.area
  }

  "countAdjacentOccupied" should "count occupied" in {
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_1.txt"))
    assert(next.countAdjacentOccupied(0, 0) === 2)
    assert(next.countAdjacentOccupied(2, 1) === 5)
  }

  "getAdjacent" should "count occupied" in {
    val next = WaitingArea(InputUtils.inputToArrayChar("/test_input/day_11_step_2.txt"))
    next.getAdjacent(0, 0, 1) should contain allOf((-1, -1), (0, -1), (1, -1), (-1, 0), (1, 0), (-1, 1), (0, 1), (1, 1))
  }

}
