package exchange

import org.scalatest.{FlatSpec, Matchers}

class ProcessorSpec() extends FlatSpec with Matchers {

  val processor = Processor()

  Db.upsert("glob", Symbol.I)
  Db.upsert("prok", Symbol.V)
  Db.upsert("pish", Symbol.X)
  Db.upsert("tegj", Symbol.L)

  Db.upsert("Silver", 17)

  "glob is I" should "return (glob, Symbol.I)" in {
    processor.doXxxIsSymbol("glob is I") should be(("glob", Symbol.I))
  }

  "glob glob Silver is 34 Credits" should "return (Silver, 17)" in {
    processor.doItemIsCredits("glob glob Silver is 34 Credits") should be(("Silver", 17))
  }

  "how much is pish tegj glob glob ?" should "return (pish tegj glob glob, 42)" in {
    processor.doHowMuchIs("how much is pish tegj glob glob ?") should be(("pish tegj glob glob", 42))
  }

  "how many Credits is glob prok Silver ?" should "return (Silver, 68)" in {
    processor.doHowManyCreditsIs("how many Credits is glob prok Silver ?") should be(("glob prok Silver", 68.0))
  }

}
