package main

import exchange.{Db, Processor, RomanNumeral}
import exchange.Parser._

import scala.collection.mutable
import scala.io.StdIn
import scala.util.matching.Regex

object Main extends App {

  val processor = Processor()
  val buffer = mutable.ListBuffer[String]()
  Iterator.continually(Console.readLine).takeWhile(_.nonEmpty).foreach(line => buffer += line)

  buffer.foreach(s => process(s))

//  val inputTest = List(
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

  def process(sentence: String): Unit = {

    sentence match {
      case reXxxIsSymbol(_*) => {
        val tuple = processor.doXxxIsSymbol(sentence)
        Db.upsert(tuple._1, tuple._2)
      }
      case reItemsIsCredits(_*) => {
        val tuple = processor.doItemsIsCredits(sentence)
        Db.upsert(tuple._1, tuple._2)
      }
      case reHowMuchIs(_*) => {
        val tuple = processor.doHowMuchIs(sentence)
        println(s"${tuple._1} is ${tuple._2}")
      }
      case reHowManyCreditsIs(_*) => {
        val tuple = processor.doHowManyCreditsIs(sentence)
        println(s"${tuple._1} is ${tuple._2} Credits")
      }
      case _ => {
        println(processor.unMatch())
      }
    }
  }

}
