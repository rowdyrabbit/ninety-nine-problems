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

  "The 'length' function" should "return the number of elements in the list" in {
    val list = List(1,2,3,4,5)
    Problems.length(list) should be (5)
  }

  "The 'reverse' function" should "reverse the order of elements in the list" in {
    val list = List(1,2,3,4,5)
    Problems.reverse(list) should be(List(5, 4, 3, 2, 1))
  }

  "The 'palindrome' function" should "return true if the list is a palindrome" in {
    val list = List(1, 2, 3, 0, 3, 2, 1)
    Problems.isPalindrome(list) should be (true)
  }

  "The 'palindrome' function" should "return false if the list is not a palindrome" in {
    val list = List(1, 2, 3, 0, 4, 2, 1)
    Problems.isPalindrome(list) should be (false)
  }

  "The 'append' function" should "append two lists" in {
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    Problems.append(list1, list2) should be (List(1,2,3,4,5,6))
  }

  "The 'flatten' function" should "flatten a list of lists into a list" in {
    val listOfLists = List(List(1,2,3), List(4,5,6))
    Problems.flatten(listOfLists) should be (List(1, 2, 3, 4, 5, 6))
  }

}
