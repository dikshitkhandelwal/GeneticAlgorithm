package statistics


object Statistics {


  def average[T](data: List[T], f: T => Double): Double = {
    data.map(f).sum/data.map(f).length.toDouble
  }

  def topK[T](data : List[T], f: T => Double, k:Int): List[T] = {
    val length_of_new_data = data.length
    if (length_of_new_data <=  k){
      val output = data.sortBy(f).reverse
      output
    }
    else{
        data.sortBy(f).reverse.slice(0, k)
    }
  }

  def standardDeviation[T](data: List[T], f: T => Double): Double = {
    val new_data: List[Double] = data.map(f)
    val average: Double = new_data.sum/new_data.length.toDouble
    val differences: List[Double] = new_data.map(_ - average)
    val squares_of_differences: List[Double] = differences.map(Math.pow(_, 2.0))
    val semi: Double = squares_of_differences.sum/squares_of_differences.length
    val output: Double = Math.sqrt(semi)
    output
  }

  def bayesianAverage[T](data: List[T], f: T => Double, number_of_fake_ratings: Int, value_of_fake_ratings: Int): Double ={
    val new_data: List[Double] = data.map(f)
    val sum : Double = new_data.sum
    val length_of_list: Double = new_data.length.toDouble
    val bayesian_average: Double = (sum + number_of_fake_ratings*value_of_fake_ratings)/(number_of_fake_ratings + length_of_list)
    bayesian_average
  }

  def main(args: Array[String]): Unit = {


  }


}
