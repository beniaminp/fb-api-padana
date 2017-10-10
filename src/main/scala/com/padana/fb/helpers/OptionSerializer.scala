package com.padana.fb.helpers

import com.google.gson._
import java.lang.reflect.Type

class OptionSerializer extends JsonSerializer[Option[Any]] with JsonDeserializer[Option[Any]] {
  def serialize(src: Option[Any], typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val jsonObject = new JsonObject
    if (src.isDefined) {
      def value = src.get

      jsonObject.addProperty("class", value.asInstanceOf[Object].getClass.getName)
      jsonObject.add("value", context.serialize(value))
    }
    jsonObject
  }

  def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Option[Any] = {
    if (json.isJsonNull) {
      None
    } else if (json.isJsonObject && json.getAsJsonObject.entrySet().size() == 0) {
      None
    } else {
      val className = json.getAsJsonObject.get("class").getAsString
      val deserialized = context.deserialize(json.getAsJsonObject.get("value"), Class.forName(className))
      Option(deserialized)
    }
  }
}
