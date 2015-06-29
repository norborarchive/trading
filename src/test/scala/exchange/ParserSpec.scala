package exchange

import org.scalatest.{FlatSpec, Matchers}
import exchange.Parser._


class ParserSpec extends FlatSpec with Matchers {

  def matcher(sentence: String): Int = {
    return sentence match {
      case reXxxIsSymbol(_*) => 1
      case reItemsIsCredits(_*) => 2
      case reHowMuchIs(_*) => 3
      case reHowManyCreditsIs(_*) => 4
      case _ => 5
    }
  }

  "On 'glob is I' matcher" should "return 1" in {
    matcher("glob is I") should be(1)
  }

  "On 'glob prok Gold is 57800 Credits' matcher" should "return 2" in {
    matcher("glob prok Gold is 57800 Credits") should be(2)
  }

  "On 'how much is XXX?' matcher" should "return 3" in {
    matcher("how much is XXX?") should be(3)
  }

  "On 'how many Credits is XXX?' matcher" should "return 4" in {
    matcher("how many Credits is XXX?") should be(4)
  }

  "On 'how much wood could a woodchuck chuck if a woodchuck could chuck wood ?' matcher" should "return 5" in {
    matcher("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?") should be(5)
  }

}
