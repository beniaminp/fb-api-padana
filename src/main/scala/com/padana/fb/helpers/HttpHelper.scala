package com.padana.fb.helpers

import java.net.{HttpURLConnection, URL}

class HttpHelper {

  def getStringFromUrl(url: String): String = {
    var out: java.io.OutputStream = null
    var in: java.io.InputStream = null

    try {
      val url = new URL(url)
      val connection = url.openConnection().asInstanceOf[HttpURLConnection]
      connection.setRequestMethod("GET")
      var statusCode: Int = connection.getResponseCode
      if (statusCode == 200) {
        in = connection.getInputStream
        var retStr: String = scala.io.Source.fromInputStream(in).mkString;
        retStr
      } else {
        ""
      }

    } catch {
      case (e) => {
        e.printStackTrace()
        e.getMessage
      }
    }
  }
}
