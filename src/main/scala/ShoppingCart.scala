/**
  * Created by msciab on 24/10/17.
  */

object ShoppingCart {

  sealed trait Item

  case object Apple extends Item

  case object Orange extends Item

  def price(item: Item): Int = item match {
    case Apple => 60
    case Orange => 25
  }

  def parse(input: Array[String]): List[Item] = {
    val seq = for {
      item <- input
      if item == "apple" || item == "orange"
    } yield item match {
      case "apple" => Apple
      case "orange" => Orange
    }
    seq.toList
  }

  def checkout(cart: List[Item]): Int = cart match {
    case Nil => 0
    case item :: rest => price(item) + checkout(rest)
  }

  def offer(cart: List[Item]): List[Item] = offer1(cart, 0, 0)

  def offer1(cart: List[Item],
             orangeCount: Int,
             appleCount: Int): List[Item] = cart match {
    case Nil => Nil
    case Apple :: rest =>
      val appleCount1 = appleCount + 1
      if (appleCount1 % 2 == 0)
        offer1(rest, orangeCount, appleCount1)
      else
        Apple :: offer1(rest, orangeCount, appleCount1)
    case Orange :: rest =>
      val orangeCount1 = orangeCount + 1
      if(orangeCount1 % 3 == 0)
        offer1(rest, orangeCount1, appleCount)
      else
        Orange :: offer1(rest, orangeCount1, appleCount)
  }
}
