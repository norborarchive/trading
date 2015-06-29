package exchange


object Parser {

  val reXxxIsSymbol = """^(.+)\s+is\s+[IVXLCDM]$""".r

  val reItemsIsCredits = """^(.+)\s+is\s+(.+)\s+Credits$""".r

  val reHowMuchIs = """^how\s+much\s+is\s+(.+)$""".r

  val reHowManyCreditsIs = """^how\s+many\s+Credits\s+is\s+(.+)$""".r

}
