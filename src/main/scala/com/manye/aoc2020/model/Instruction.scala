package com.manye.aoc2020.model

object Instruction {

  private val patterInstruction = "(?<instruction>[\\w]+) (?<symbol>[+-])(?<firstValue>[\\d]+)".r

  def parse(line: String): Instruction = {
    patterInstruction.findFirstMatchIn(line).map {
      case patterInstruction(instruction, symbol, firstValue) => {
        val first = symbol match {
          case "-" => firstValue.toInt * -1
          case _ => firstValue.toInt
        }
        Instruction(instruction, first)
      }
    }.get
  }
}

case class Instruction(op: String, value: Int) {

  def changeOp(newOp: String): Instruction = {
    Instruction(newOp, value)
  }
}
