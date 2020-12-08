package com.manye.aoc2020.model

case class BootCode(instructions: Array[Instruction]) {

  var accumulator: Long = 0
  var cursor: Int = 0
  var terminated: Boolean = false

  def runUntilRepeat(): Unit = {
    val visited: Array[Boolean] = Array.ofDim(instructions.length)
    var repeated = false
    while (!terminated && !repeated) {
      if (!visited(cursor)) {
        visited(cursor) = true
        executeInstruction()
      } else {
        repeated = true
      }
    }
  }

  private def executeInstruction(): Unit = {
    val instruction = instructions(cursor)
    instruction match {
      case Instruction("acc", value) =>
        addAccumulator(value)
        moveCursor(1)
      case Instruction("jmp", value) => moveCursor(value)
      case Instruction("nop", _) => moveCursor(1)
    }
  }

  def moveCursor(move: Int): Unit = {
    cursor += move
    if (cursor >= instructions.length) {
      terminated = true
    }
  }

  def addAccumulator(amount: Long): Unit = {
    accumulator += amount
  }

  def changeInstruction(index: Int, newInstruction: Instruction): Unit = {
    instructions(index) = newInstruction
  }

  def reset(): Unit = {
    accumulator = 0
    cursor = 0
    terminated = false
  }
}
