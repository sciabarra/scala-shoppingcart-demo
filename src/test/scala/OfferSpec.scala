import org.scalatest.{FunSpec, Matchers}

/**
  * Created by msciab on 24/10/17.
  */
class OfferSpec extends FunSpec with Matchers {
  import ShoppingCart._

  describe("offers") {
    it("buy one get one free on Apples") {
      offer(List()) shouldBe Nil
      offer(List(Apple)) shouldBe List(Apple)
      offer(List(Apple,Apple)) shouldBe List(Apple)
      offer(List(Apple,Apple,Apple)) shouldBe List(Apple, Apple)
    }

    it("three for two on oranges") {
      offer(List()) shouldBe List()
      offer(List(Orange)) shouldBe List(Orange)
      offer(List(Orange,Orange)) shouldBe List(Orange,Orange)
      offer(List(Orange,Orange,Orange)) shouldBe List(Orange,Orange)
      offer(List(Orange,Orange,Orange, Orange)) shouldBe List(Orange,Orange, Orange)
    }

    it("combined") {
      offer(List(Orange, Apple, Orange, Apple, Orange )) shouldBe List(Orange, Apple, Orange)
    }
   }

}
