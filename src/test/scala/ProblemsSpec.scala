import org.scalatest.{Matchers, FlatSpec}

class ProblemsSpec extends FlatSpec with Matchers {

  "The 'last' function" should "return the last element of a list" in {
    val list = List(1,2,3,4,5)
    Problems.last(list) should be (5)
  }

}
