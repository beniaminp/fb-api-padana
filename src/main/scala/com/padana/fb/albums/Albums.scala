package com.padana.fb.main.albums

import com.google.gson.{Gson, JsonObject}
import com.padana.fb.helpers.{GsonCustom, HttpHelper}
import com.padana.fb.models.{Album, Location, Place}

import scala.collection.mutable.{ArrayBuffer, HashMap}

class Albums(configValues: HashMap[String, String], httpHelper: HttpHelper) {
  val gson = new GsonCustom().getGson()

  def getProfileAlbmum(): Album = {
    var retAlbum: ArrayBuffer[Album] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals("Profile Pictures"))
    retAlbum(0)
  }

  def getAlbums(): ArrayBuffer[Album] = {
    var allAlbums: ArrayBuffer[Album] = new ArrayBuffer[Album]()
    var albumsString: String = httpHelper.getStringFromUrl(configValues("fb-graph") + configValues("fb-api-v") + "/"
      + configValues("userfbId") + "/albums?fields=link,name,place,privacy,message&access_token=" + configValues("accessToken"))
    //val json = Json.parse(albumsString)
    //println("albumsString is: " + albumsString)
    val json = gson.fromJson(albumsString, classOf[JsonObject])
    //println(json.get("data").getAsJsonArray)
    //val albums = gson.fromJson(json.get("data").toString, classOf[Array[Album]])
    val jsonArray = json.get("data").getAsJsonArray;

    for (i <- 0 until jsonArray.size) {
      val albumObject = jsonArray.get(i).getAsJsonObject
      val placeObject = albumObject.get("place").getAsJsonObject
      val locationObject = albumObject.get("place").getAsJsonObject.get("location").getAsJsonObject

      val place = new Place(Some(placeObject.get("name").toString), Some(placeObject.get("name").toString), Some(placeObject.get("name").toString));
      val album = new Album(Some(albumObject.get("link").toString), Some(albumObject.get("name").toString), Some(albumObject.get("place").toString), Some(albumObject.get("privacy").toString), Some(albumObject.get("id").toString))*/
      println("album is: " + album)
      //var album
    }
    /*for (alb <- albums) {
      allAlbums += alb
    }*/
    allAlbums
  }

  def getAlbumByName(name: String): Album = {
    var retAlbum: ArrayBuffer[Album] = getAlbums().filter(_.name.getOrElse("").toLowerCase.equals(name.toLowerCase))
    retAlbum(0)
  }
}