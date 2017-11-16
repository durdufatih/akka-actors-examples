package actormessage2

import akka.actor.{ActorSystem, Props}

object MessagingDemo {

  case class NewFeature(name: String)

  object Bug

  object Fix

  def main(args: Array[String]): Unit = {

    val system = ActorSystem.create("outsource-company")

    val tester = system.actorOf(Props(new TesterActor), "Sam")
    val developer = system.actorOf(Props(new DeveloperActor(tester)), "Bob")

    developer ! NewFeature("Social integration")

    system.terminate()

  }

}
