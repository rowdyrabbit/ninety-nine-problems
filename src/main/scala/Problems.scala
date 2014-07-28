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
  def nth(index: Int, list: List[Int]): Option[Int] = {
    list match {
      case x::xs if (index == 0) => Some(list.head)
      case x::xs if (index > 0) => nth(index -1, list.tail)
      case _ => None
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

  // Duh, reverse the whole list and compare!
  def isPalindrome2(list: List[Int]): Boolean = {
    list.sameElements(list.reverse)
  }


  // Problem 7
  def append(list: List[Any], list2: List[Any]): List[Any] = {
    // replace nil with cons in the first list and cons with cons
    list.foldRight(list2){(list1Elem, appList) => {println("list 1 element is: "+ list1Elem); list1Elem :: appList}}
  }

  def flatten(list: List[List[Any]]): List[Any] = {
    // fold right over the list, replacing cons with append and nil with nil
    list.foldRight(List[Any]()){(list1Elem, resultList) => {
        append(list1Elem, resultList)
      }
    }
  }

  // An implementation which works!
  def flatten2(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten2(ms)
    case e => List(e)
  }

  // Problem 8
  def compress(list: List[Char]): List[Char] = {
    list.foldRight(List[Char]()){(rightElem, newList) =>
      if (newList.isEmpty || rightElem != newList.head ) rightElem :: newList
      else newList
    }
  }

  // Problem 9
  def pack(list: List[Char]): List[List[Char]] = {
    //like compress but instead of ignoring duplicates, make a new list
    list.foldRight(List[List[Char]]()){(rightElem, packed) =>
      packed match {
        case Nil => List(rightElem) :: packed
        case x::xs if (rightElem != packed.head.head) => List(rightElem) :: packed
        case _ => (rightElem :: packed.head) :: packed.tail
      }
    }
  }

  // Problem 10
  def encode(list: List[Char]): List[(Int, Char)] = {
    val packed = pack(list)
    packed.foldRight(List[(Int, Char)]()){(firstGroup: List[Char],  encodedList: List[(Int, Char)]) =>
      (firstGroup.length, firstGroup.head) :: encodedList
    }
  }

  //A simpler implementation with map
  def encode2(list: List[Char]): List[(Int, Char)] = {
    val packed = pack(list)
    packed.map((g: List[Char]) => (g.length, g.head))
  }




}
