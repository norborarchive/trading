package exchange

object Symbol extends Enumeration {
  type Symbol = Value

  val I = Value(1)
  val V = Value(5)
  val X = Value(10)
  val L = Value(50)
  val C = Value(100)
  val D = Value(500)
  val M = Value(1000)

}
