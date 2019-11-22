package org.mylearning.akka.sample;

import akka.actor.ActorPath;
import akka.actor.ActorRef;

public class MyActor extends ActorRef{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ActorPath path() {
		// TODO Auto-generated method stub
		return null;
	}

}
