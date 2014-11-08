package wrappers

import play.api.mvc.Flash

class FlashMap(flash: Flash) extends java.util.HashMap[String, String] {

	override def put(key: String, value: String): String = {
		val previousValue = get(key)
		flash + (key, value)
		previousValue
	}

	override def get(key: scala.Any): String = key match {
		case k: String => flash.get(k).getOrElse("")
		case _ => ""
	}
}

object FlashMap {

	def apply(flash: Flash): FlashMap = {
		new FlashMap(flash)
	}
}
