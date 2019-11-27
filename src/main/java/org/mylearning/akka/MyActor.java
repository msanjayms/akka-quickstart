package org.mylearning.akka;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.japi.function.Function;

public class MyActor extends AbstractBehavior<MyActor.Message> {

	public MyActor(ActorContext<MyActor.Message> context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public static class Message {
		String msg;

		public Message(String msg) {
			this.msg = msg;
		}
	}

	@Override
	public Receive<Message> createReceive() {
		return newReceiveBuilder().onMessage(MyActor.Message.class, message -> printMessage(message)).build();
	}

	private Behavior<MyActor.Message> printMessage(Message message) {
		getContext().getLog().info("Received a msg: " + message.msg);
		return Behaviors.stopped();
	}

	private Function printMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Behavior<MyActor.Message> create() {
		// TODO Auto-generated method stub

		Function<ActorContext<Message>, Behavior<Message>> factory = context -> new MyActor(context);
		return Behaviors.setup(factory);
	}
}
