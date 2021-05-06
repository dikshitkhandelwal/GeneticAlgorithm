package genetics
import music.Song
import scala.math.Ordering.comparatorToOrdering
import statistics.Statistics
import music.Song
import music.SongRating
import music.Playlist

object GeneticAlgorithm {

  def randomGenerator(number: Int): List[Double] = {
    val ListOfDoubles: List[Double] = for (i <- (1 to number).toList) yield {
      val r = scala.util.Random.between(-100, 100)
      r.toDouble
    }
    ListOfDoubles
  }

  def Crossover(ListOfAnimals: List[List[Double]]): List[List[Double]] = {
    if (ListOfAnimals.isEmpty) {
      List()
    }
    else {
      val Dad = ListOfAnimals.apply(0)
      val Mom = ListOfAnimals.apply(1)
      val UpdatedPopulation1 = ListOfAnimals.drop(1)
      val UpdatedPopulation2 = UpdatedPopulation1.drop(1)
      val length = (0 to Dad.length - 1).toList
      val Child: List[Double] = for (i <- length) yield {
        (Dad.apply(i) + Mom.apply(i)) / 2
      }
      val a = Crossover(UpdatedPopulation2)
      List(Child) ++ a
    }
  }

  def Mutation(ListOfAnimal: List[List[Double]]): List[List[Double]] = {
    if (ListOfAnimal == List()) {
      List()
    }
    else {
      val FirstElement = ListOfAnimal.apply(0)
      val UpdatedList = ListOfAnimal.drop(1)
      val r = scala.util.Random
      val UpdatedElement = for (i <- FirstElement) yield {
        i + r.nextFloat()
      }
      List(UpdatedElement) ++ Mutation(UpdatedList)
    }
  }

  def BestFitAnimal(Ls: List[List[Double]]): List[List[Double]] = {
    val output = Ls.slice(0, 40)
    output
  }



  def MainRecursion[T](incubator: List[Double] => T, costFunction: T => Double, numberOfGenes: Int, InitialPopulation: List[List[Double]], Generation: Int = 1): List[List[Double]] = {
    if (Generation == 500 ) {
      InitialPopulation
    }
    else {
      val generation = Generation + 1
      val functionForFittest: List[Double] => Double = (x: List[Double]) => costFunction(incubator(x))
      val SortedAnimalList: List[List[Double]] = InitialPopulation.sortBy(functionForFittest)
      val FittestAnimals = BestFitAnimal(SortedAnimalList)
      val Children: List[List[Double]] = Crossover(FittestAnimals)
      val MutuatedChildren: List[List[Double]] = Mutation(Children)
      val SemiOutput: List[List[Double]] = FittestAnimals ++ Children ++ MutuatedChildren
      val NumberOfAnimalsToAdd = InitialPopulation.length - SemiOutput.length
      val ExtraAnimals: List[List[Double]] = for (i <- ((0 until (NumberOfAnimalsToAdd)).toList)) yield {
        val genes: List[Double] = randomGenerator(numberOfGenes)
        genes}
      val Output: List[List[Double]] = SemiOutput ++ ExtraAnimals
      MainRecursion(incubator, costFunction, numberOfGenes, Output, generation)
    }
  }


  def geneticAlgorithm[T](incubator: List[Double] => T, costFunction: T => Double, numberOfGenes: Int): T = {
    val Population: List[List[Double]] = for (i <- ((0 until (100)).toList)) yield {
      val genes: List[Double] = randomGenerator(numberOfGenes)
      genes
    }
    incubator(MainRecursion(incubator, costFunction, numberOfGenes, Population)(0))
  }


  def main(args: Array[String]): Unit = {


  }

}
