package counter

import akka.actor.Actor



class Counter(count: Int) extends Actor {
  def receive: Receive = {
    case count: Int if (count > 2) =>{println("Count Finish")}
    case _=>
  }
}
