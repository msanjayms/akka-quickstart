package org.mylearning.akka;

import java.io.IOException;

import akka.actor.typed.ActorSystem;

public class AkkaMain {

	public static void main(String[] args) {
		/*
		 * This particular line of code will be the starting point for the entire
		 * hierarchy of underlying Actors.
		 * 
		 * Create would instantiate the HelloWorldMain actor. Which in-turn set up the
		 * behavior of the Actor.
		 * 
		 */
		//final ActorSystem<HelloWorldMain.Start> system = ActorSystem.create(HelloWorldMain.create(), "hello");
		final ActorSystem<MyActor.Message> system = ActorSystem.create(MyActor.create(), "MyActor");

		system.tell(new MyActor.Message("Testing Akka"));
		//system.tell(new HelloWorldMain.Start("World"));
		// system.tell(new HelloWorldMain.Start("Akka"));

		try {
			System.out.println(">>> Press ENTER to exit <<<");
			System.in.read();
		} catch (IOException ignored) {
		} finally {
			system.terminate();
		}
	}
}
