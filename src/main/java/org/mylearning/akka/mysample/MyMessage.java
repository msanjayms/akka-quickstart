package org.mylearning.akka.mysample;

import org.mylearning.akka.mysample.MyActor.Message;

import akka.actor.typed.ActorRef;

public class MyMessage {

	private String data;
	private final ActorRef<Message> from;

	public MyMessage(String msg, ActorRef<Message> from) {
		this.data = msg;
		this.from = from;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ActorRef<Message> getFrom() {
		return from;
	}
	
	
}
