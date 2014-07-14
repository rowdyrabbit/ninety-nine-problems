import sun.font.TrueTypeFont

object Problems {

  // Problem 1
  def last(list: List[Int]): Int = {
    list.foldLeft(List[Int]()){(accList, elem) => elem :: accList}.head
  }

  // Problem 2
  def penultimate(list: List[Int]): Int = {
    //could also write this in terms of fold, but this achieves the same thing I wanted with foldLeft
    list.reverse.tail.head
  }

  // Problem 3
  def nth(index: Int, list: List[Int]): Int = {
    list match {
      case x::xs if (index == 0) => list.head
      case x::xs if (index > 0) => nth(index -1, list.tail)
      case _ => throw new NoSuchElementException
    }
  }

  // Problem 4
  def length(list: List[Int]): Int = {
    list.foldLeft(0) {(length, curr) => length + 1}
  }

  // Problem 5
  def reverse(list: List[Int]): List[Int] = {
    list.foldLeft(List[Int]()) {(revList, curr) => curr :: revList}
  }

  // Problem 6
  def isPalindrome(list: List[Int]): Boolean = {
    //split the list in 2, discarding the middle element if the list contains an odd number of elems
    //reverse the second half of the list
    //compare the two lists
    val half = list.length / 2
    list.length match {
      case 0 => true
      case _ => {
        val left = list.take(half)
        val right = list.takeRight(half).reverse
        left.sameElements(right)
      }
    }
  }


}
