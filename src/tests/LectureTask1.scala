package tests

import org.scalatest._
import statistics.Statistics

class LectureTask1 extends FunSuite {


  def compareDoubles(d1 : Double, d2 : Double): Boolean ={
    Math.abs(d1-d2) < 0.001
  }


  test("your test") {


    val list_of_positive_integers: List[Int] = List(3,5,2,6,8)
    val list_of_negative_integers: List[Int] = List(-3, -9, -7, -4)
    val list_of_mix_integers: List[Int] = List(-2, -7, 8, 9, -6)
    val list_of_strings: List[String] = List("one", "two", "three", "four")


    assert(compareDoubles(Statistics.average(list_of_positive_integers, (x : Int) => x.toDouble), 4.8), "Test1" )
    assert(compareDoubles(Statistics.average(list_of_negative_integers, (x : Int) => x.toDouble), -5.75), "Test2" )
    assert(compareDoubles(Statistics.average(list_of_mix_integers, (x : Int) => x.toDouble), 0.4), "Test3" )
    assert(compareDoubles(Statistics.average(list_of_strings, (x : String) => x.length.toDouble), 3.75), "Test4" )
    assert(Statistics.topK(list_of_positive_integers, (x: Int) => x.toDouble, 5) == List(8, 6, 5, 3, 2),"Test5" )
    assert(Statistics.topK(list_of_strings, (x : String) => x.length.toDouble, 3) == List("three", "four", "two"),"Test6" )
    assert(Statistics.topK(list_of_strings, (x : String) => x.length.toDouble, 6) == List("three", "four", "two", "one"),"Test7" )



  }


}
