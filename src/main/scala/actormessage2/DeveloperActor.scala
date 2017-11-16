package actormessage2

import actormessage2.MessagingDemo.{Bug, Fix, NewFeature}
import akka.actor.{Actor, ActorRef}
import akka.event.Logging

class DeveloperActor(tester:ActorRef) extends Actor{

  val log = Logging.getLogger(context.system, this)

  def receive = {
    case feature: NewFeature => {
      log.info(s"Working on feature '${feature.name}'")
      tester ! feature
    }
    case Bug => {
      log.info("Fixing a bug")
      tester ! Fix
    }
    case _ => log.info("Playing StarCraft2")
  }
}
