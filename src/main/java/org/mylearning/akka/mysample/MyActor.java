package org.mylearning.akka.mysample;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.japi.function.Function;

public class MyActor extends AbstractBehavior<MyActor.Message> {

	long counter = 0;
	String id = null;

	public MyActor(ActorContext<MyActor.Message> context, String uuid) {
		super(context);
		this.id = uuid;
	}

	public static class Message {
		String msg;
		public final ActorRef<Message> from;

		public Message(String msg, ActorRef<Message> from) {
			this.msg = msg;
			this.from = from;
		}
	}

	@Override
	public Receive<Message> createReceive() {
		return newReceiveBuilder().onMessage(MyActor.Message.class, message -> printMessage(message)).build();
	}

	private Behavior<MyActor.Message> printMessage(Message message) {
		counter++;
		getContext().getLog().info("Received a msg: {}, level {}, Actor ID {} ", message.msg, counter, id);
		String name = "Level-2";
		if (counter % 10 != 0) {
			/*
			 * Function<ActorContext<Message>, Behavior<Message>> factory = context -> new
			 * MyActor(context, counter); ActorRef<Message> spawn =
			 * getContext().spawn(Behaviors.setup(factory), name);
			 */
			if (message.from != null)
				message.from.tell(new MyActor.Message("Counter " + counter, getContext().getSelf()));
			else {
				getContext().getSelf().tell(new MyActor.Message("Counter " + counter, getContext().getSelf()));
			}
		}else {
			getContext().getLog().info("Done with message processing");
		}
		// return new MyActor(getContext());
		return this;
	}

	public static Behavior<MyActor.Message> create(String uuid) {
		// TODO Auto-generated method stub
		Function<ActorContext<Message>, Behavior<Message>> factory = context -> new MyActor(context, uuid);
		return Behaviors.setup(factory);
	}
}
