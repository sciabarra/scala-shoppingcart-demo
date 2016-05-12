/**
  * Created by msciab on 12/05/16.
  */

object ShoppingCart {

  sealed trait Item

  case object Apple extends Item

  case object Orange extends Item

  def price(item: Item): Int = item match {
    case Apple => 60
    case Orange => 25
  }

  def parse(input: Array[String]): List[Item] = Nil

  def checkout(cart: List[Item]): Int = cart match {
    case Nil => 0
    case item :: rest => price(item) + checkout(rest)
  }
}
