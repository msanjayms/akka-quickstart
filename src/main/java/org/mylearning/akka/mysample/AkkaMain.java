package org.mylearning.akka.mysample;

import java.io.IOException;
import java.util.UUID;

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
		// final ActorSystem<HelloWorldMain.Start> system =
		// ActorSystem.create(HelloWorldMain.create(), "hello");

		long randNumber = (long) (Math.random() * 10);
		String uuid = UUID.randomUUID().toString();
		final ActorSystem<MyActor.Message> system = ActorSystem.create(MyActor.create(uuid), "MyActor");

		system.tell(new MyActor.Message("Testing Akka " + (long) (Math.random() * 10), null));
		system.tell(new MyActor.Message("Testing Akka " + (long) (Math.random() * 10), null));
		
		

		// system.tell(new HelloWorldMain.Start("World"));
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
