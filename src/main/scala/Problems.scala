
object Problems {

  //Problem 1
  def last(list: List[Int]): Int = {
    list.foldLeft(List[Int]()){(accList, elem) => elem :: accList}.head
  }

  


}
