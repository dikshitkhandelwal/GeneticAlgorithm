package tests

import genetics.GeneticAlgorithm
import music.Song
import org.scalatest.FunSuite

class ApplicationObjective1 extends FunSuite{

  test("Test for Application Objective 1"){
    val ListOfSong = Song.readSongsFromFile("data/song_ratings_2017.csv")
//    val mp = Map("ST86JM1RPl0"->4, "fTdlF0qP8lE"->3, "dQw4w9WgXcQ"->3, "tk7Cp6iVlZQ"->3, "djV11Xbc914"->3)
    val mp: Map[String, Int] = Map()

assert(GeneticAlgorithm.geneticAlgorithm(Song.makeIncubator(ListOfSong), Song.costFunction(mp), 2).youtubeId == "_Yhyp-_hX2s" )

  }

}
