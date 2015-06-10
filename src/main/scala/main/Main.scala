package main

import exchange.{Db, Processor, Parser, RomanNumeral}

import scala.collection.mutable
import scala.io.StdIn

object Main extends App {

  val parser = Parser()
  val processor = Processor()
  val buffer = mutable.ListBuffer[String]()
  Iterator.continually(Console.readLine).takeWhile(_.nonEmpty).foreach(line => buffer += line)

  buffer.foreach(s => process(s))

  /**
   * Note, Cannot change order condition.
   */
  def process(sentence: String): Unit = {
    if (parser.isItemIsCredits(sentence)) {
      val tuple = processor.doItemIsCredits(sentence)
      Db.upsert(tuple._1, tuple._2)

    } else if (parser.isHowMuchIs(sentence)) {
      val tuple = processor.doHowMuchIs(sentence)
      println(s"${tuple._1} is ${tuple._2}")

    } else if (parser.isHowManyCreditsIs(sentence)) {
      val tuple = processor.doHowManyCreditsIs(sentence)
      println(s"${tuple._1} is ${tuple._2} Credits")

    } else if (parser.isXxxIsSymbol(sentence)) {
      val tuple = processor.doXxxIsSymbol(sentence)
      Db.upsert(tuple._1, tuple._2)

    } else {
      println(processor.unMatch())
    }
  }

  //  val input = List(
  //    "glob is I",
  //    "prok is V",
  //    "pish is X",
  //    "tegj is L",
  //    "glob glob Silver is 34 Credits",
  //    "glob prok Gold is 57800 Credits",
  //    "pish pish Iron is 3910 Credits",
  //    "how much is pish tegj glob glob ?",
  //    "how many Credits is glob prok Silver ?",
  //    "how many Credits is glob prok Gold ?",
  //    "how many Credits is glob prok Iron ?",
  //    "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
  //  ).foreach(s => process(s))
}
