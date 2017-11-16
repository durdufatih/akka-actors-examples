package actormessage

import akka.actor.Actor
import akka.event.Logging

class TesterActor extends Actor {
  val log = Logging.getLogger(context.system, this)

  def receive = {
    case feature: NewFeature => log.info(s"Testing '${feature.name}'...")
    case _ => log.info("Watching YouTube")
  }
}
