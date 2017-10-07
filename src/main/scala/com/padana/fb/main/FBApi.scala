package com.padana.fb.main

import scala.io.Source
import scala.collection.mutable._
import net.liftweb.json.DefaultFormats
import net.liftweb.json._
import com.padana.fb.helpers.HttpHelper
import com.padana.fb.models.Albums

class FBApi(userfbId: String, accessToken: String) {
  val httpHelper: HttpHelper = new HttpHelper

  val configFile = "fb-api-padana.config"
  val bufferedSource = Source.fromFile(configFile)
  var configValues: HashMap[String, String] = ()
  for (line <- bufferedSource.getLines) {
    configValues += (line.split("=")(0) -> line.split("=")(1))
  }
  bufferedSource.close

  def getProfileAlbmum(): Albums = {
    var retAlbum: ArrayBuffer[Albums] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals("Profile Pictures"))
    retAlbum(0)
  }

  def getAlbumByName(name: String): Albums = {
    var retAlbum: ArrayBuffer[Albums] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals(name.toLowerCase))
    retAlbum(0)
  }

  def getAlbums(): ArrayBuffer[Albums] = {
    var allAlbums: ArrayBuffer[Albums] = new ArrayBuffer[Albums]()
    var albumsString: String = httpHelper.getStringFromUrl(configValues("fb-graph") + configValues("fb-api-v") + "/" + userfbId + "/albums?access_token=" + accessToken)
    val json = parse(albumsString)
    val albums = (json \\ "data").children
    for (alb <- albums) {
      val m = alb.extract[Albums]
      allAlbums += m
    }
    allAlbums
  }
}
