package tests

import org.scalatest.FunSuite
import statistics.Statistics
import music.Song
import music.SongRating
import music.Playlist

class LectureTask6 extends FunSuite{

  def compareDoubles(d1: Double, d2 : Double): Boolean = {
    Math.abs(d1 - d2) < 0.001
  }

  test("LectureTask6"){

    val user1 : Map[String, Int]= Map("af15ARAP3H4" -> 1, "eE9tV1WGTgE" -> 5, "tLKb_fJZS9I" -> 3)


    val songRating1 = new SongRating(1,1)
    val songRating2 = new SongRating(2,2)
    val songRating3 = new SongRating(3,3)
    val songRating4 = new SongRating(4,4)
    val songRating5 = new SongRating(5,5)


    val songRating6 = new SongRating(5,1)
    val songRating7 = new SongRating(5,2)
    val songRating8 = new SongRating(5,1)

    val Song11 = new Song("Everything at Once", "Lenka", "eE91WGTgE", List(songRating1))
    val Song12 = new Song("Everything at Once", "Lenka", "eE9WGTgE", List(songRating2))
    val Song13 = new Song("Everything at Once", "Lenka", "eE9tWGTgE", List(songRating3))
    val Song14 = new Song("Everything at Once", "Lenka", "eE9tV1WGTgE", List(songRating4))
    val Song15 = new Song("Everything at Once", "Lenka", "e1WGTgE", List(songRating5))

    val Song16 = new Song("Everything at Once", "Lenka", "eE9tV1WGTgE", List(songRating6))
    val Song17 = new Song("Everything at Once", "Lenka", "eE9tV1GTgE", List(songRating7))
    val Song18 = new Song("Everything at Once", "Lenka", "eE9tWGTgE", List(songRating8))
    val Song19 = new Song("Everything at Once", "Lka", "eE9tV1WGTgE", List(songRating7))



    val ls3: Playlist =new Playlist(List(Song11, Song15, Song13))
    val ls4: Playlist =new Playlist(List(Song12, Song14))
    val ls5: Playlist =new Playlist(List(Song11, Song12, Song13, Song14, Song15))
    val ls6: Playlist =new Playlist(List(Song16, Song17, Song18))

    val ls7: Playlist =new Playlist(List(Song19, Song18))
    val ls8: Playlist =new Playlist(List(Song19, Song19))





    assert(compareDoubles(Playlist.costFunction(user1)(ls3), 0.21119337969883822), "Test3")
    assert(compareDoubles(Playlist.costFunction(user1)(ls4), 0.185), "Test4")
    assert(compareDoubles(Playlist.costFunction(user1)(ls5), 0.37467986375989343), "Test5")
    assert(compareDoubles(Playlist.costFunction(user1)(ls6),  2.3636363636363638), "Test6")
    assert(compareDoubles(Playlist.costFunction(user1)(ls7), 0.2909090909090909), "Test7")
    assert(compareDoubles(Playlist.costFunction(user1)(ls8), 109.0909090909091), "Test7")



  }

}
