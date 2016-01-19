import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object RatingsHistogramApp {

	def main(args: Array[String]) {
		val conf = new SparkConf().setMaster("local").setAppName("RatingsHistogram")
		val sc = new SparkContext(conf)

		val lines = sc.textFile("/Users/naironics/workspaces/spark-movielens/ml-100k/u.data")
		val ratings = lines.map(line => line.split("\t")(2))
		val result = ratings.countByValue

		// sorting to a List 
		val sortedResultsList = result.toList sortBy {_._2}

		// sorting to a Map 
		import collection.immutable.ListMap

		val sortedResultsMap = ListMap(result.toList.sortBy{_._2}:_*)

		for ((k,v) <- sortedResultsMap) printf("Rating: %s, Count: %s\n", k, v)
	}
}
