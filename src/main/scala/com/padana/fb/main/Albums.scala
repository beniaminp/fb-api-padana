/*
package com.padana.fb.main

import com.padana.fb.helpers.HttpHelper
import com.padana.fb.models.Album
import play.api.libs.json.Json
//import net.liftweb.json.{DefaultFormats, parse}

import scala.collection.mutable.{ArrayBuffer, HashMap}

class Albums(configValues: HashMap[String, String], httpHelper: HttpHelper) {
  //implicit val formats = DefaultFormats

  def getProfileAlbmum(): Album = {
    var retAlbum: ArrayBuffer[Album] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals("Profile Pictures"))
    retAlbum(0)
  }

  def getAlbums(): ArrayBuffer[Album] = {
    var allAlbums: ArrayBuffer[Album] = new ArrayBuffer[Album]()
    var albumsString: String = httpHelper.getStringFromUrl(configValues("fb-graph") + configValues("fb-api-v") + "/"
      + configValues("userfbId") + "/albums?fields=link,name,place,privacy,message&access_token=" + configValues("accessToken"))
    val json = Json.parse(albumsString)
    val albums = (json \ "data").as[List[Album]]
    println(albums)
    for (alb <- albums) {
      allAlbums += alb
    }
    allAlbums
  }

  def getAlbumByName(name: String): Album = {
    var retAlbum: ArrayBuffer[Album] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals(name.toLowerCase))
    retAlbum(0)
  }
}*/
