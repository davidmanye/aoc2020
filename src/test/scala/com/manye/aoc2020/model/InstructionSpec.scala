package com.manye.aoc2020.model

import org.scalatest.flatspec.AnyFlatSpec

class InstructionSpec extends AnyFlatSpec {

  "parse" should "return nop" in {
    assert(Instruction.parse("nop +0") === Instruction("nop", 0))
  }

  it should "return acc" in {
    assert(Instruction.parse("acc +22") === Instruction("acc", 22))
    assert(Instruction.parse("acc -5") === Instruction("acc", -5))
  }

  it should "return jmp" in {
    assert(Instruction.parse("jmp +27") === Instruction("jmp", 27))
    assert(Instruction.parse("jmp -156") === Instruction("jmp", -156))
  }

}
