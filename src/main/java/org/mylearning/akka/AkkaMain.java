package org.mylearning.akka;

import akka.actor.typed.ActorSystem;

public class AkkaMain {

	public static void main(String[] args) {
		final ActorSystem<HelloWorldMain.Start> system = ActorSystem.create(HelloWorldMain.create(), "hello");

		system.tell(new HelloWorldMain.Start("World"));
		system.tell(new HelloWorldMain.Start("Akka"));
	}
}
