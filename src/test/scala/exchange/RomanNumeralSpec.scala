import exchange.RomanNumeral
import org.scalatest.{FlatSpec, Matchers}


class RomanNumeralSpec extends FlatSpec with Matchers {

  val roman = RomanNumeral()

  "I" should "equal to 1" in {
    roman.valueOf("I") should be(1)
  }

  "V" should "equal to 5" in {
    roman.valueOf("V") should be(5)
  }

  "X" should "equal to 10" in {
    roman.valueOf("X") should be(10)
  }

  "L" should "equal to 50" in {
    roman.valueOf("L") should be(50)
  }

  "C" should "equal to 100" in {
    roman.valueOf("C") should be(100)
  }

  "D" should "equal to 500" in {
    roman.valueOf("D") should be(500)
  }

  "M" should "equal to 1000" in {
    roman.valueOf("M") should be(1000)
  }

  "IV" should "equal to 4" in {
    roman.valueOf("IV") should be(4)
  }

  "IX" should "equal to 9" in {
    roman.valueOf("IX") should be(9)
  }

  "MMI" should "equal to 2001" in {
    roman.valueOf("MMI") should be(2001)
  }

  "MCMIII" should "equal to 1903" in {
    roman.valueOf("MCMIII") should be(1903)
  }

  "MCMXLIV" should "equal to 1944" in {
    roman.valueOf("MCMXLIV") should be(1944)
  }

  "XLII" should "equal to 42" in {
    roman.valueOf("XLII") should be(42)
  }

  "VV" should "throw IllegalArgumentException" in {
    evaluating {
      roman.valueOf("VV")
    } should produce[IllegalArgumentException]
  }

  "CCCC" should "throw IllegalArgumentException" in {
    evaluating {
      roman.valueOf("CCCC")
    } should produce[IllegalArgumentException]
  }

  "MMIM" should "throw IllegalArgumentException" in {
    evaluating {
      roman.valueOf("MMIM")
    } should produce [IllegalArgumentException]
  }

}