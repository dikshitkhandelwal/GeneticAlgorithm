package tests

import music.Song
import org.scalatest.FunSuite
import music.Song
import music.SongRating

class LectureTask5 extends FunSuite{

  def compareDoubles(d1: Double, d2 : Double): Boolean = {
    Math.abs(d1 - d2) < 0.001
  }

  test("TestCase1"){


    val user1 : Map[String, Int]= Map("af15ARAP3H4" -> 1)
    val user2 : Map[String, Int]= Map("af15ARAP3H4" -> 2)
    val user3 : Map[String, Int]= Map("af15ARAP3H4" -> 3)
    val user4 : Map[String, Int]= Map("af15ARAP3H4" -> 4)
    val user5 : Map[String, Int]= Map("af15ARAP3H4" -> 5)
    val user6 : Map[String, Int]= Map("af4" -> 5)


    val songRtaing1 = new SongRating(2,4)


    val Song1 = new Song("Up", "Nav", "af15ARAP3H4", List(songRtaing1))

    assert(compareDoubles(Song.costFunction(user1)(Song1), 1000.0))
    assert(compareDoubles(Song.costFunction(user2)(Song1), 1000.0))


    assert(compareDoubles(Song.costFunction(user3)(Song1), 0.125), "Test3")
    assert(compareDoubles(Song.costFunction(user4)(Song1), 0.09375), "Test4")
    assert(compareDoubles(Song.costFunction(user5)(Song1), 0.075), "Test5")
    assert(compareDoubles(Song.costFunction(user6)(Song1), 0.125), "Test6")




  }

}
