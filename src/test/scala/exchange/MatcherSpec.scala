package exchange

import org.scalatest.{Matchers, FlatSpec}

class MatcherSpec extends FlatSpec with Matchers {

  "a" should "b" in {
    val xisr = """^(.+)\s+is\s+[IVXLCDM]?""".r

    "glob is I" match {
      case xisr(_*) => println("Correct")
      case _ => println("Error")
    }

    "glob prok Gold is 57800 Credits" match {
      case xisr(_*) => println("Correct")
      case _ => println("Error")
    }
  }

}
