package exchange

import scala.collection.mutable

object Db {
  val langs = mutable.HashMap[String, Symbol.Value]()
  val items = mutable.HashMap[String, Double]()

  def upsert(s: String, v: Symbol.Value): Unit = {
    langs += s -> v
  }

  def upsert(s: String, v: Double): Unit = {
    items += s -> v
  }

  def findSymbol(s: String): Symbol.Value = langs.get(s).get

  def findItemPrice(s: String): Double = items.get(s).get

}
