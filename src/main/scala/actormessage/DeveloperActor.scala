package actormessage

import akka.actor.{Actor, Props}
import akka.event.Logging

class DeveloperActor extends Actor{

  val log = Logging.getLogger(context.system, this)

  def receive = {
    case feature: NewFeature => log.info(s"Working on feature '${feature.name}'")
    case Bug => log.info("Fixing a bug")
    case _ => log.info("Playing StarCraft2")
  }

}
