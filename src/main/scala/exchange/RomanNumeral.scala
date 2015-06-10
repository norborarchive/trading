package exchange

case class RomanNumeral() {

  def valueOf(romanText: String): Integer = {
    validateCannotRepeatedException(romanText)
    validateRepeatedMorethanThreeException(romanText)

    val symbols = toSymbols(romanText).toList

    var i = 0
    var total = 0
    for (i <- 0 until symbols.size) {
      val left = symbols(i)
      val right = if (i < symbols.size-1) symbols(i+1) else null

      (right == null || left.id >= right.id) match {
        case true => total += left.id
        case false => {
          validateSubtractException(left, right)
          total -= left.id
        }
      }
    }

    return total
  }

  private def toSymbols(romanText: String): TraversableOnce[Symbol.Value] = {
    return romanText.toUpperCase.toList.map(c => Symbol.withName(c.toString))
  }

  private def validateCannotRepeatedException(romanText: String): Unit = {
    if (romanText.contains("VV") ||
        romanText.contains("LL") ||
        romanText.contains("DD")) {
      throw new IllegalArgumentException("V, L and D can never be repeated.");
    }
  }

  private def validateRepeatedMorethanThreeException(romanText: String): Unit = {
    if (romanText.contains("IIII") ||
        romanText.contains("XXXX") ||
        romanText.contains("CCCC") ||
        romanText.contains("MMMM")) {
      throw new IllegalArgumentException("I, X, C and M can not repeated more than three.");
    }
  }

  private def validateSubtractException(left: Symbol.Value, right: Symbol.Value): Unit = {
    val isAccept = left match {
      case Symbol.I => (right == Symbol.V) || (right == Symbol.X);
      case Symbol.X => (right == Symbol.L) || (right == Symbol.C);
      case Symbol.C => (right == Symbol.D) || (right == Symbol.M);
      case _ => false
    }

    if (!isAccept) {
      throw new IllegalArgumentException("Cannot Subtracted");
    }
  }
}
