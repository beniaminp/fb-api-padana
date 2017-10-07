import com.github.retronym.SbtOneJar._

name := "fb-api-padana"

version := "0.1"

scalaVersion := "2.10.2"

exportJars := true

oneJarSettings

// https://mvnrepository.com/artifact/net.liftweb/lift-json_2.10
libraryDependencies += "net.liftweb" % "lift-json_2.10" % "2.6.3"

libraryDependencies += "commons-lang" % "commons-lang" % "2.6"
