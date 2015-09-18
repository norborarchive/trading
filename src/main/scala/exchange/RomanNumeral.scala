package exchange

case class RomanNumeral() {

  def valueOf(romanText: String): Integer = {
    validateCannotRepeatedException(romanText)
    validateRepeatedMorethanThreeException(romanText)

    val symbols = toSymbols(romanText).toList
    val indexs = List.range(0, symbols.size)
    val total = indexs.foldLeft(0)((total, i) => {
      val left = symbols(i)
      val right: Option[Symbol.Value] = if (i < symbols.size - 1) Some(symbols(i + 1)) else None

      (right.isEmpty || left.id >= right.get.id) match {
        case true => total + left.id
        case false => {
          validateSubtractException(left, right.get)
          total - left.id
        }
      }
    })

    return total
  }

  private def toSymbols(romanText: String): TraversableOnce[Symbol.Value] = {
    return romanText.toUpperCase.toList.map(c => Symbol.withName(c.toString))
  }

  private def validateCannotRepeatedException(romanText: String): Unit = {
    assert(!(romanText.contains("VV") || romanText.contains("LL") || romanText.contains("DD"))
      , "V, L and D can never be repeated.")
  }

  private def validateRepeatedMorethanThreeException(romanText: String): Unit = {
    assert(!(romanText.contains("IIII") || romanText.contains("XXXX") || romanText.contains("CCCC") || romanText.contains("MMMM"))
      , "I, X, C and M can not repeated more than three.")
  }

  private def validateSubtractException(left: Symbol.Value, right: Symbol.Value): Unit = {
    val isAccept = left match {
      case Symbol.I => (right == Symbol.V) || (right == Symbol.X)
      case Symbol.X => (right == Symbol.L) || (right == Symbol.C)
      case Symbol.C => (right == Symbol.D) || (right == Symbol.M)
      case _ => false
    }

    assert(isAccept, "Cannot Subtracted")
  }
}
