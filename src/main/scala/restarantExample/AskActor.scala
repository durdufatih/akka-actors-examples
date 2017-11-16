package restarantExample

import akka.actor.Actor

class AskActor extends Actor {

  object Food

  object Drink

  object Salad

  def receive: Receive = {
    case Food=>
  }

}
