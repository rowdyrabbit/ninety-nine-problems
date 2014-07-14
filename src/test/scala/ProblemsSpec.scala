import org.scalatest.{Matchers, FlatSpec}

class ProblemsSpec extends FlatSpec with Matchers {

  "The 'last' function" should "return the last element of a list" in {
    val list = List(1,2,3,4,5)
    Problems.last(list) should be (5)
  }
  "The 'penultimate' function" should "return the second last element of a list" in {
    val list = List(1,2,3,4,5)
    Problems.penultimate(list) should be (4)
  }

  "The 'nth' function" should "return the nth element of a list" in {
    val list = List(1,2,3,4,5)
    Problems.nth(2, list) should be (3)
  }

}
