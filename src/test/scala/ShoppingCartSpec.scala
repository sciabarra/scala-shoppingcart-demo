import org.scalatest.{Matchers, FunSpec}

/**
  * Created by msciab on 24/06/17.
  */
class ShoppingCartSpec extends FunSpec with Matchers {
  describe("shopping cart") {

    import ShoppingCart._

    it("contains only apple and oranges") {
      parse(Array("apple", "orange", "pear", "apple")) should contain only(Apple, Orange)
      parse(Array("apple", "orange", "pear", "apple")) should contain only(Apple, Orange)
      parse(Array("orange", "pear")) should contain only(Orange)
    }

    it("apple costs 60p") {
      price(Apple) shouldBe 60
    }
    it("orange costs 25p") {
      price(Orange) shouldBe 25
    }

    it("input from array of string") {
      parse(Array("apple", "orange", "apple")) should be (Apple :: Orange :: Apple :: Nil)
    }

    it("checkout") {
      checkout(List()) shouldBe 0
      checkout(List(Apple)) shouldBe 60
      checkout(List(Apple, Orange)) shouldBe 85
      checkout(List(Apple, Orange, Apple)) shouldBe 145
    }

  }

}
