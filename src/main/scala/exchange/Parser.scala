package exchange

case class Parser() {

  def isXxxIsSymbol(sentence: String): Boolean = sentence.matches("""^(.+)\s+is\s+[IVXLCDM]?""")

  def isItemIsCredits(sentence: String): Boolean = sentence.matches("""^(.+)\s+is\s+(.+)\s+Credits?""")

  def isHowMuchIs(sentence: String): Boolean = sentence.matches("""^how\s+much\s+is\s+(.+)?""")

  def isHowManyCreditsIs(sentence: String): Boolean = sentence.matches("""^how\s+many\s+Credits\s+is\s+(.+)?""")

}
