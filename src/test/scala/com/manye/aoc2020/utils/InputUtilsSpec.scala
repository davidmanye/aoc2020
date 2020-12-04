package com.manye.aoc2020.utils

import com.manye.aoc2020.model.Passport.PassportField
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.{contain, have}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class InputUtilsSpec extends AnyFlatSpec {

  "inputToPassportList" should "return 4 Passports" in {
    val passports = InputUtils.inputToPassportList("/test_input/day_04.txt")

    passports should have size 4
  }

  it should "return correct parsed password" in {
    val passports = InputUtils.inputToPassportList("/test_input/day_04.txt")

    passports.head.fields should contain allOf (
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
}
