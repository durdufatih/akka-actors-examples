package restarantExample

import akka.actor.{ActorSystem, Props}

import scala.util.Random


object RestaurantDemo {

  def main(args: Array[String]): Unit = {

    val random = new Random()
    val open = random.nextBoolean();
    val system = ActorSystem.create("restaurant")

    val waiter = system.actorOf(Props(new WaiterActor), "SamPay")

    waiter ! open

    system.terminate()

  }
}
