package exchange

case class Processor() {

  val roman = RomanNumeral()

  /**
   *
   * @param sentence
   * @return (string, Symbol)
   */
  def doXxxIsSymbol(sentence: String): (String, Symbol.Value) = {
    val lists = sentence.split(" is ")
    return (lists(0), Symbol.withName(lists(1)))
  }

  /**
   *
   * @param sentence
   * @return (Item, Credits)
   */
  def doItemIsCredits(sentence: String): (String, Double) = {
    val lists = sentence.split(" is ")

    val buffer = lists(0).split(" ")

    val quantity = parserQuantity(buffer.slice(0, buffer.size-1))

    val item = buffer(buffer.size-1)

    val amount = (lists(1).replace("Credits", "").trim.toDouble / quantity)

    return (item, amount)
  }

  def doHowMuchIs(sentence: String): (String, Int) = {
    val b = sentence.replace("how much is", "").replace("?", "").trim

    return (b, parserQuantity(b.split(" ")))
  }

  def doHowManyCreditsIs(sentence: String): (String, Double) = {
    val b = sentence.replace("how many Credits is", "").replace("?", "").trim.split(" ")
    val q = parserQuantity(b.slice(0, b.size-1))
    val item = b(b.size-1)

    return (b.mkString(" "), (q * Db.findItemPrice(item)))
  }

  def unMatch(): String = "I have no idea what you are talking about"

  private def parserQuantity(buffer: Array[String]): Int = {
    val romanText = buffer
      .map( t => Db.findSymbol(t) )
      .mkString

    return roman.valueOf(romanText)
  }

}
