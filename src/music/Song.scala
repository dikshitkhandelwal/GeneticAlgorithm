package music

import statistics.Statistics
import  music.SongRating

import scala.io.Source

class Song(val title: String, val artist: String, val youtubeId: String, val ratings: List[SongRating]) {

  def averageRating(): Double = {
    // This is an example of calling your average function to get the average rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.rating)
  }

  def averageEnergyRating(): Double = {
    // This is an example of calling your average function to get the average energy rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.energy)
  }

  def addRating(songRating: SongRating) : Song = {
    new Song(title, artist, youtubeId, ratings :+ songRating)
  }

  def bayesianRating(extraRatings: Int, valueOfExtraRatings: Int): Double = {
    Statistics.bayesianAverage(this.ratings, (rating: SongRating) => rating.rating, extraRatings, valueOfExtraRatings)
  }

}


object Song {

  def recursiveMethod(initial : List[String]): Map[String, Song] ={
    if (initial == List()){
      Map()
    }
    else{
      val FirstList: List[String] = initial.head.split(",").toList
      val UpdatedList: List[String] = initial.drop(1)
      val youtubeId: String = FirstList.head
      val songRating = new SongRating(FirstList(3).toInt, FirstList(4).toInt)
      val songs: Song = new Song(FirstList.apply(2), FirstList.apply(1), FirstList.head,List(songRating) )
      val recursion = recursiveMethod(UpdatedList)
      if (recursion.contains(youtubeId)){
        val before = recursion(youtubeId)
         recursion.updated(youtubeId, before.addRating(songRating) )
      }
      else{
        Map(youtubeId -> songs)  ++ recursion
      }
    }
  }


  def readSongsFromFile(filename: String): List[Song] = {
    // Read all lines of the file into a List
    val file = Source.fromFile(filename)
    val lines: List[String] = file.getLines().toList
    println(lines.length)
    file.close()
    recursiveMethod(lines).values.toList
  }


  def makeIncubator(songs: List[Song]): List[Double] => Song = {
    genes: List[Double] => {
      // assumes there is only 1 gene and converts that Double to an Int and retrieves the song at
      // that position in the list
      val geneSong: Int = (genes.head.abs * songs.length).toInt % songs.length
      songs(geneSong)
    }
  }

  def costFunction(map: Map[String, Int]): Song => Double ={

    (song : Song) => {
      val id = song.youtubeId
      val userRating = map.getOrElse(id, 3)

      if (userRating ==  1 || userRating == 2){
        1000.0
      }
      else {
        val baysianAverage: Double = song.bayesianRating(2, 3)
        1.0/(baysianAverage*(userRating.toDouble))
      }
    }
  }























  def main(args: Array[String]): Unit = {

    val x = PointByX(16,12,8,2)
    println(x)


    val y = PointByY(16, 10, 2,6)
    println(y)

  }

}