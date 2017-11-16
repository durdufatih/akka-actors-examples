package tutorial

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.Source
import scala.xml.XML

class WeatherActor extends Actor {
  override def receive: Receive = {
    case msg => println(msg)
  }
}

object RunActors {
  def main(args: Array[String]) {
    def getWeatherInfo(id: String) {
      val url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid=" + id ;
      val response = Source.fromURL(url).mkString
      val xmlResponse = XML.loadString(response)
      println(xmlResponse \\ "location" \\ "@city",
        xmlResponse \\ "condition" \\ "@temp")
    }

    val system = ActorSystem("WeatherSystem")
    val weatherActor = system.actorOf(Props[WeatherActor], name = "weatheractor")
    val start = System.nanoTime
    for (id <- 4118 to 4128) { //WOEID - Where On Earth ID
      weatherActor ! getWeatherInfo(id.toString())
    }
    val end = System.nanoTime
    println("Time : " + (end - start) / 1000000000.0)
  }
}
