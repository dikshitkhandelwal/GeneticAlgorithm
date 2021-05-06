package tests

import org.scalatest.FunSuite

class LectureTask4 extends FunSuite {

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 -d2)< 0.001
  }

}
