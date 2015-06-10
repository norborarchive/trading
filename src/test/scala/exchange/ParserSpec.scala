package exchange

import org.scalatest.{FlatSpec, Matchers}


class ParserSpec extends FlatSpec with Matchers {

  val parser = Parser()

  "On isXxxIsSymbol, glob is I" should "be true" in {
    parser.isXxxIsSymbol("glob is I") should be(true)
  }
  "On isXxxIsSymbol, glob are I" should "be false" in {
    parser.isXxxIsSymbol("glob are I") should be(false)
  }
  "On isXxxIsSymbol, glob prok Gold is 57800 Credits" should "be false" in {
    parser.isXxxIsSymbol("glob prok Gold is 57800 Credits") should be(false)
  }
  "On isXxxIsSymbol, how many Credits is XXX?" should "be false" in {
    parser.isXxxIsSymbol("how many Credits is XXX?") should be(false)
  }
  "On isXxxIsSymbol, how much is XXX?" should "be false" in {
    parser.isXxxIsSymbol("how much is XXX?") should be(false)
  }


  "On isItemIsCredits, glob prok Gold is 57800 Credits" should "be true" in {
    parser.isItemIsCredits("glob prok Gold is 57800 Credits") should be(true)
  }
  "On isItemIsCredits, glob is I" should "be false" in {
    parser.isItemIsCredits("glob is I") should be(false)
  }

  "On isHowMuchIs, Sentence: how much is XXX?" should "be true" in {
    parser.isHowMuchIs("how much is XXX?") should be(true)
  }
  "On isHowMuchIs, Sentence: how much XXX?" should "be false" in {
    parser.isHowMuchIs("how much XXX?") should be(false)
  }

  "On isHowManyCreditsIs, how many Credits is XXX?" should "be true" in {
    parser.isHowManyCreditsIs("how many Credits is XXX?") should be(true)
  }

  "On isHowManyCreditsIs, how many Credits are XXX?" should "be false" in {
    parser.isHowManyCreditsIs("how many Credits are XXX?") should be(false)
  }


}
