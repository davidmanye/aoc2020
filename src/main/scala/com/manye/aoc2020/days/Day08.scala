package com.manye.aoc2020.days

import com.manye.aoc2020.model.{BootCode, Instruction}
import com.manye.aoc2020.utils.InputUtils


object Day08 {

  def main(args: Array[String]): Unit = {
    val result1 = solvePart1("/inputs/day_08.txt")
    println("Part 1: Run your copy of the boot code. Immediately before any instruction is executed a second time, what value is in the accumulator?")
    println(s"Result 1 = $result1")
    val result2 = solvePart2("/inputs/day_08.txt")
    println("Part 2: Fix the program so that it terminates normally by changing exactly one jmp (to nop) or nop (to jmp). What is the value of the accumulator after the program terminates?")
    println(s"Result 2 = $result2")
  }

  def solvePart1(input: String): Long = {
    val code = BootCode(InputUtils.inputToCode(input))
    code.runUntilRepeat()
    code.accumulator
  }

  def solvePart2(input: String): Long = {
    val code = BootCode(InputUtils.inputToCode(input))
    for (index <- 0 to code.instructions.length) {
      val current = code.instructions(index)
      current match {
        case Instruction("jmp", _) => code.changeInstruction(index, current.changeOp("nop"))
        case Instruction("nop", _) => code.changeInstruction(index, current.changeOp("jmp"))
        case _ =>
      }
      code.runUntilRepeat()
      code.changeInstruction(index, current)
      if (code.terminated) {
        return code.accumulator
      }
      code.reset()
    }
    0
  }

}
