package com.manye.aoc2020.model

import com.manye.aoc2020.model.Passport.{PassportField, requiredFields}

object Passport {

  object PassportField {
    def create(name: String, value: String): PassportField = {
      name match {
        case "byr" => BirthYear(value)
        case "iyr" => IssueYear(value)
        case "eyr" => ExpirationYear(value)
        case "hgt" => Height(value)
        case "hcl" => HairColor(value)
        case "ecl" => EyeColor(value)
        case "pid" => PassportID(value)
        case "cid" => CountryID(value)
      }
    }
  }

  sealed abstract class PassportField(val name: String, val value: String) {
    def isValid: Boolean

    def valueBetween(min: Int, max: Int): Boolean = {
      val number = value.toInt
      valueBetween(number, min, max)
    }

    def valueBetween(value: Int, min: Int, max: Int): Boolean = {
      val number = value.toInt
      min <= number && number <= max
    }
  }

  case class BirthYear(override val value: String) extends PassportField("byr", value) {
    override def isValid: Boolean = valueBetween(1920, 2002)
  }

  case class IssueYear(override val value: String) extends PassportField("iyr", value) {
    override def isValid: Boolean = valueBetween(2010, 2020)
  }

  case class ExpirationYear(override val value: String) extends PassportField("eyr", value) {
    override def isValid: Boolean = valueBetween(2020, 2030)
  }

  case class Height(override val value: String) extends PassportField("hgt", value) {

    private val CmPattern = "^([\\d]+)cm$".r
    private val InPattern = "^([\\d]+)in$".r

    override def isValid: Boolean = value match {
      case CmPattern(measure) => valueBetween(measure.toInt, 150, 193)
      case InPattern(measure) => valueBetween(measure.toInt, 59, 76)
      case _ => false
    }
  }
  case class HairColor(override val value: String) extends PassportField("hcl", value) {
    private val ColorPattern = "^#([0-9a-f]{6})$".r
    override def isValid: Boolean = ColorPattern.findFirstMatchIn(value).isDefined
  }
  case class EyeColor(override val value: String) extends PassportField("ecl", value) {
    private val ValidColors = Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    override def isValid: Boolean = ValidColors.contains(value)
  }
  case class PassportID(override val value: String) extends PassportField("pid", value) {
    private val PassportIDPattern = "^([0-9]{9})$".r
    override def isValid: Boolean = PassportIDPattern.findFirstMatchIn(value).isDefined
  }
  case class CountryID(override val value: String) extends PassportField("cid", value) {
    override def isValid: Boolean = true
  }

  val requiredFields = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  def parse(line: String): Passport = {
    val fields = line.split("\\s").map(field => {
      val passportField = field.split(":")
      val value = passportField(1)
      val name = passportField(0)
      PassportField.create(name, value)
    }).toList
    Passport(fields)
  }
}

case class Passport(fields: List[PassportField]) {

  def isValid: Boolean = {
    if (hasRequiredFields) {
      fields.forall(_.isValid)
    } else {
      false
    }
  }

  def hasRequiredFields: Boolean = {
    val diff = requiredFields diff fields.map(_.name).toSet
    diff.isEmpty
  }
}


