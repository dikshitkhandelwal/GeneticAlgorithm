package tests

import org.scalatest.FunSuite
import statistics.Statistics


class LectureTask3 extends FunSuite{


  def compareDoubles(d1 : Double, d2 : Double): Boolean ={
    Math.abs(d1-d2) < 0.001
  }


  test("Testing 3"){


    assert(compareDoubles(Statistics.bayesianAverage(List(1, 2, 3, 4, 5), (x: Int) => x.toDouble, 2, 3), 3.0), "test1")
    assert(compareDoubles(Statistics.bayesianAverage(List(1, 2, 3, 4, 5, -1, -2, -4), (x: Int) => x.toDouble, 5, 10), 4.4615384615),"test2")
    assert(compareDoubles(Statistics.bayesianAverage(List(1, 2, 3, 4, 5), (x: Int) => x.toDouble, 0, 0), 3.0), "test3")
    assert(compareDoubles(Statistics.bayesianAverage(List(1, 2, 3, 4, 5), (x: Int) => x.toDouble, 2, 0), 2.1428571429), "test4")
    assert(compareDoubles(Statistics.bayesianAverage(List(1, 2, 3, 4, 5), (x: Int) => x.toDouble, 0, 2), 3.0), "test3")


  }

}
