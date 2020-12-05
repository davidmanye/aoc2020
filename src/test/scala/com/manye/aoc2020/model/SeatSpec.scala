package com.manye.aoc2020.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class SeatSpec extends AnyFlatSpec {

  "getRowLocation" should "return substring of location" in {
      assert(Seat.getRowLocation("BFFFBBFRRR") === "BFFFBBF")
      assert(Seat.getRowLocation("FFFBBBFRRR") === "FFFBBBF")
      assert(Seat.getRowLocation("BBFFBBFRLL") === "BBFFBBF")
  }

  "getColumnLocation" should "return substring of location" in {
    assert(Seat.getColumnLocation("BFFFBBFRRR") === "RRR")
    assert(Seat.getColumnLocation("FFFBBBFRRR") === "RRR")
    assert(Seat.getColumnLocation("BBFFBBFRLL") === "RLL")
  }

  "divideRange" should "return sub ranges" in {
    Seat.divideRange((0, 127)) should contain allOf ((0, 63), (64, 127))
    Seat.divideRange((32, 63)) should contain allOf ((32, 47), (48, 63))
    Seat.divideRange((44, 47)) should contain allOf ((44, 45), (46, 47))
    Seat.divideRange((44, 45)) should contain allOf ((44, 44), (45, 45))
  }

  "searchRow" should "return the correct row" in {
    assert(Seat.searchRow("BFFFBBFRRR") === 70)
    assert(Seat.searchRow("FFFBBBFRRR") === 14)
    assert(Seat.searchRow("BBFFBBFRLL") === 102)
  }

  "searchColumn" should "return the correct row" in {
    assert(Seat.searchColumn("BFFFBBFRRR") === 7)
    assert(Seat.searchColumn("FFFBBBFRRR") === 7)
    assert(Seat.searchColumn("BBFFBBFRLL") === 4)
  }

  "Seat" should "set row and column" in {
    assert(Seat("BFFFBBFRRR").row === 70)
    assert(Seat("BFFFBBFRRR").column === 7)
    assert(Seat("BFFFBBFRRR").seatId === 567)

    assert(Seat("FFFBBBFRRR").row === 14)
    assert(Seat("FFFBBBFRRR").column === 7)
    assert(Seat("FFFBBBFRRR").seatId === 119)

    assert(Seat("BBFFBBFRLL").row === 102)
    assert(Seat("BBFFBBFRLL").column === 4)
    assert(Seat("BBFFBBFRLL").seatId === 820)
  }

}
