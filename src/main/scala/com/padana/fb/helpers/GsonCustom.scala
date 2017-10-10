package com.padana.fb.helpers

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class GsonCustom {
  def getGson(): Gson = {
    val gson = new GsonBuilder().registerTypeAdapter(classOf[Option[Any]], new OptionSerializer).create

    gson
  }
}
