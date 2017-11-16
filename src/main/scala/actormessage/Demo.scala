package actormessage

import akka.actor.{ActorSystem, Props}


case class NewFeature(name: String)

object Bug

object Demo {
  def main(args: Array[String]): Unit = {

    val system = ActorSystem.create("outsource-company")
    val developer = system.actorOf(Props(new DeveloperActor), "Bob")
    val tester = system.actorOf(Props(new TesterActor), "Sam")

    developer ! NewFeature("Social integration")
    tester.tell(NewFeature("Social integration"), developer)


    system.terminate()

  }
}