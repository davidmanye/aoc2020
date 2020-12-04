package com.manye.aoc2020.model

import com.manye.aoc2020.model.Passport.{BirthYear, EyeColor, HairColor, Height, IssueYear, PassportField, PassportID}
import com.manye.aoc2020.utils.InputUtils
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class PassportSpec extends AnyFlatSpec {

  private lazy val passports = InputUtils.inputToPassportList("/test_input/day_04.txt")

  "parse" should "work with spaces" in {
    val passport = Passport.parse("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd")

    passport.fields should contain allOf (
      PassportField.create("ecl", "gry"),
      PassportField.create("pid", "860033327"),
      PassportField.create("eyr", "2020"),
      PassportField.create("hcl", "#fffffd")
    )
  }

  it should "work with return characters" in {
    val passport = Passport.parse(
      """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
        |byr:1937 iyr:2017 cid:147 hgt:183cm
        |""".stripMargin)

    passport.fields should contain allOf (
      PassportField.create("ecl", "gry"),
      PassportField.create("pid", "860033327"),
      PassportField.create("eyr", "2020"),
      PassportField.create("hcl", "#fffffd"),
      PassportField.create("byr", "1937"),
      PassportField.create("iyr", "2017"),
      PassportField.create("cid", "147"),
      PassportField.create("hgt", "183cm")
    )
  }

  "isValid" should "validate required fields" in {
    assert(passports.head.isValid === true)
    assert(passports(1).isValid === false)
    assert(passports(2).isValid === true)
    assert(passports(3).isValid === false)
  }

  it should "count as invalid file day_04_invalid_passports.txt" in {
    val passports = InputUtils.inputToPassportList("/test_input/day_04_invalid_passports.txt")

    assert(passports.count(_.isValid) === 0)
  }

  it should "count as valid file day_04_valid_passports.txt" in {
    val passports = InputUtils.inputToPassportList("/test_input/day_04_valid_passports.txt")

    assert(passports.count(_.isValid) === passports.length)
  }

  "BirthYear" should "four digits; at least 1920 and at most 2002" in {
    assert(BirthYear("2002").isValid)
    assert(!BirthYear("2003").isValid)
  }

  "IssueYear" should "four digits; at least 2010 and at most 2020" in {
    assert(IssueYear("2011").isValid)
    assert(!IssueYear("2003").isValid)
  }

  "Height" should "If cm, the number must be at least 150 and at most 193" in {
    assert(Height("190cm").isValid)
    assert(!Height("60cm").isValid)
    assert(!Height("190").isValid)
  }

  it should "If in, the number must be at least 59 and at most 76." in {
    assert(Height("60in").isValid)
    assert(!Height("190in").isValid)
    assert(!Height("190").isValid)
  }

  "HairColor" should "a # followed by exactly six characters 0-9 or a-f." in {
    assert(HairColor("#123abc").isValid)
    assert(!HairColor("#123abz").isValid)
    assert(!HairColor("123abc").isValid)
  }

  "EyeColor" should "exactly one of: amb blu brn gry grn hzl oth." in {
    assert(EyeColor("brn").isValid)
    assert(!EyeColor("wat").isValid)
  }

  "PassportID" should "a nine-digit number, including leading zeroes." in {
    assert(PassportID("000000001").isValid)
    assert(!PassportID("0123456789").isValid)
  }

}
