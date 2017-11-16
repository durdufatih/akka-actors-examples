package actormessage2

import actormessage2.MessagingDemo.{Bug, Fix, NewFeature}
import akka.actor.Actor
import akka.event.Logging

import scala.util.Random

class TesterActor extends Actor {

  val log = Logging.getLogger(context.system, this)

  def receive = {
    case feature: NewFeature => {
      log.info(s"Testing '${feature.name}'...")
      //val bugExists = Random.nextInt(10)
      //if (bugExists > 7) {
        log.info("A bug was found")
        sender() ! Bug
      //}
    }
    case Fix => log.info(s"Verifying the fix...")
    case _ => log.info("Watching YouTube")
  }

}
