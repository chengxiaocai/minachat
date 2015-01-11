package com.example.minaim;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

class ClientHandler extends IoHandlerAdapter {
	public interface Callback {
		void connected();

		void loggedIn();

		void loggedOut();

		void disconnected(IoSession session);

		void messageReceived(Object message);

		void error(String message);
	}

	private final Callback callback;

	public ClientHandler(Callback callback) {
		this.callback = callback;
	}

	public void messageReceived(IoSession arg0, Object message)
			throws Exception {
		callback.messageReceived(message);
	}

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
	}
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		callback.disconnected(session);
	}
	
	
}