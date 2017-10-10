package com.padana.fb.models

import com.google.gson.JsonObject

case class Location(city: Option[String], country: Option[String], latitude: Option[Double], longitude: Option[Double], state: Option[String], zip: Option[String])
