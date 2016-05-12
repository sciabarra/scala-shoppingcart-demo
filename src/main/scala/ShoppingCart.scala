/**
  * Created by msciab on 12/05/16.
  */

object ShoppingCart {

  sealed trait Item
  case object Apple extends Item
  case object Orange extends Item

  def price(item:Item): Int = 0

  def parse(input: Array[String]):List[Item] = Nil

  def checkout(cart: List[Item]) = 0
}
