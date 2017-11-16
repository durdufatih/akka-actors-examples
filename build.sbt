name := "akka-full-example"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.6" % Test

)
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"

        