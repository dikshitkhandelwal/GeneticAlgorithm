package music

import java.awt.Desktop
import java.net.URI
import statistics.Statistics
import music.SongRating
import music.Playlist
import music.Song

class Playlist(val songs: List[Song]) {

  // Call this method on a playlist to listen to the songs
  def openPlaylist(): Unit = {
    val commaSeparatedIds: String = if (this.songs.nonEmpty) this.songs.map(_.youtubeId).reduce((acc: String, id: String) => acc + "," + id) else List[Byte](100, 81, 119, 52, 119, 57, 87, 103, 88, 99, 81).foldLeft("")(_ + _.toChar)
    val url: String = "https://www.youtube.com/watch_videos?video_ids=" + commaSeparatedIds
    if (Desktop.isDesktopSupported && Desktop.getDesktop.isSupported(Desktop.Action.BROWSE)) {
      Desktop.getDesktop.browse(new URI(url))
    } else {
      println("Opening the browser not supported. Click the link manually: " + url)
    }
  }

}

object Playlist {

  def makeIncubator(songs: List[Song]): List[Double] => Playlist = {
    genes: List[Double] => {
      // Apply the Song incubator for each gene
      val songIncubator = Song.makeIncubator(songs)
      new Playlist(genes.map((gene: Double) => songIncubator(List(gene))))
    }
  }



  def costFunction(userRating: Map[String, Int] ): Playlist => Double =  {

    (playList: Playlist) => {
      val ListOfSongs: List[Song] = playList.songs

      val raw_cost: List[Double] = for (song <- ListOfSongs) yield {
        Song.costFunction(userRating)(song)
      }
      val sum_raw_cost = raw_cost.sum

      def costMultiplier(listOfSongs: List[Song]): Double={
        val youtubeIds : List[String] = for (song <- listOfSongs) yield {
          song.youtubeId
        }

        if (youtubeIds.sorted.distinct != youtubeIds.sorted){
          1000.0
        }

        else{

          val ListOfAverageRating: List[Double] = for (song <- listOfSongs) yield {
            song.averageEnergyRating()
          }

          val StandardDeviation: Double = statistics.Statistics.standardDeviation(ListOfAverageRating, (x: Double) => x)

          if (StandardDeviation < 0.5){
            10.0
          }
          else{
            1.0/StandardDeviation
          }

        }

      }

      sum_raw_cost*costMultiplier(ListOfSongs)

    }

  }

}