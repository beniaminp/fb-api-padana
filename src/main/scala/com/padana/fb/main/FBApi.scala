package com.padana.fb.main

import scala.io.Source
import scala.collection.mutable._
import com.padana.fb.helpers.HttpHelper

import scala.collection.mutable

class FBApi(userfbId: String, accessToken: String) {
  val httpHelper: HttpHelper = new HttpHelper

  val configFile = "fb-api-padana.config"
  val bufferedSource = Source.fromFile(configFile)
  var configValues: HashMap[String, String] = new mutable.HashMap[String, String]()
  for (line <- bufferedSource.getLines) {
    configValues += (line.split("=")(0) -> line.split("=")(1))
  }
  bufferedSource.close
  configValues += ("userfbId" -> userfbId)
  configValues += ("accessToken" -> accessToken)

  def getAlbumApi(): Albums = {
    var albums: Albums = new Albums(configValues, httpHelper)
    albums
  }
}

object FBApi extends App {
  var fBApi: FBApi = new FBApi("x", "xx")
  fBApi.getAlbumApi().getAlbums().foreach(a => {
    println("Album: " + a)
  })
}
