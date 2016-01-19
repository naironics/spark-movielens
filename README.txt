/* Steps to Execute the Scala and Python Movie Ratings Code */

For Python Program, navigate to spark-movielens folder and execute :
spark-submit Ratings-Counter.py

For Scala equivalent of the above, do the following :

1. Write a scala program called "RatingsHistogramApp.scala" and place the code in "src/main/scala" folder
2. In root folder create an sbt file as found in this folder (simple.sbt)
3. Then run "sbt package"  (which creates JAR for this Scala program)
4. Now run the program as below :

spark-submit --class "RatingsHistogramApp" --master local[4] target/scala-2.11/ratings-histogram-project_2.11-1.0.jar

NOTE : My simple.sbt file looks as below 
=========================================

name := "Ratings Histogram Project"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"





