ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "algorithm-practice"
  )

// to support baekjoon judge use java 11
javacOptions ++= Seq("-source", "11", "-target", "11")
