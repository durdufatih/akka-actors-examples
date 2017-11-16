package restarantExample

import akka.actor.Actor
import akka.event.Logging


class WaiterActor extends Actor {
  val log = Logging.getLogger(context.system, this)

  def receive = {
    case true => {
      log.info("Welcome Durdu Family!!!")

    }
    case _ => {
      log.info("Restaurant Closed Today")
    }
  }

}
