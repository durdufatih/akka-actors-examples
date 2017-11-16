

import actormessage.DeveloperActor
import akka.actor.{ActorSystem, Props}

object Demo {
  def main(args: Array[String]): Unit = {

    val system = ActorSystem.create("file-reader")
    val scanner = system.actorOf(FolderScannerActor.props, "scanner")
    val directoryPath = "/Users/fatih/Documents/milliyetemlak/akka-full-example/src/main/scala/a-words"

    scanner ! directoryPath

  }
}
