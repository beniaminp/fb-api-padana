import com.github.retronym.SbtOneJar._

name := "fb-api-padana"

version := "0.1"

scalaVersion := "2.12.3"

exportJars := true

oneJarSettings

// https://mvnrepository.com/artifact/com.typesafe.play/play-json_2.12
libraryDependencies += "com.typesafe.play" % "play-json_2.12" % "2.6.6"

libraryDependencies += "commons-lang" % "commons-lang" % "2.6"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"

