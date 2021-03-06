

name := """HydraUI"""

version := "1.0-SNAPSHOT"
val akkaVersion = "2.5.4"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers +="hydrasonatype" at "https://oss.sonatype.org/content/groups/staging/"

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
  "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
  "io.github.wherby"%%"hydracommon"%"0.1-SNAPSHOT",
  "com.typesafe.akka" %% "akka-distributed-data" % akkaVersion)
