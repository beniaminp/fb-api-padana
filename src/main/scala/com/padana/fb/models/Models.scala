package com.padana.fb.models

case class Albums(link: Option[String], name: Option[String], place: Option[Place], privacy: Option[String], id: String)

case class Place(name: Option[String], location: Option[Location], id: String)

case class Location(city: Option[String], country: Option[String], latitude: Option[Double], longitude: Option[Double], state: Option[String], zip: Option[String])
