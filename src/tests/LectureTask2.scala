package tests

import org.scalatest.FunSuite
import statistics.Statistics

class LectureTask2 extends FunSuite {


  def compareDoubles(d1 : Double, d2 : Double): Boolean ={
    Math.abs(d1-d2) < 0.001
  }



  test("Test1"){

    val list_of_strings: List[String] = List("one", "two", "three", "four")
    assert(compareDoubles(Statistics.standardDeviation(List(1, 2, 3, 4, 5), (x: Int) => x.toDouble), 1.4142135623731), "test1")
    assert(compareDoubles(Statistics.standardDeviation(List(1, 2, 3, 4, 5, -1, -2, -4), (x: Int) => x.toDouble), 2.9154759474227),"test2")
    assert(compareDoubles(Statistics.standardDeviation(List(1.0, 2.0, 3.0, 4.0), (x: Double) => x), 1.1180339887499), "test3")
    assert(compareDoubles(Statistics.standardDeviation(list_of_strings, (x: String) => x.length.toDouble), 0.82915619758885),"test4")
    assert(compareDoubles(Statistics.standardDeviation(List(1.0, 29.0, 33.0, 40.0), (x: Double) => x), 14.821858857782), "test3")
    assert(compareDoubles(Statistics.standardDeviation(List(10, 12, 23, 23, 16, 23, 21), (x: Int) => x.toDouble), 5.1745057932214 ), "test3")
    assert(compareDoubles(Statistics.standardDeviation(List(10, 10, 10, 10, 10, 10), (x: Int) => x.toDouble), 0.0 ), "test3")

  }

}
