package com.websocket;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websockets/wsecho")
public class WhiteboardServer {
	
	//ServerID of this EchoServer 
	private String serverID = this.toString();
	
	//number of message received( in this instance)
	private int messageCounter = 0;
	
	@OnMessage
	public String broadCast(String msg, Session session) {
		System.out.println(session.getOpenSessions());
		System.out.println("Received this message: " + msg);
		return "Response from  " + this.serverID + " to call #" + (++messageCounter) + " . Text message received = " + msg;
	}
	
	@OnMessage
	public String doEcho(byte[] binMsg) {
		System.out.println("Bin. message received = " + new String(binMsg)  );
		return "Response from  " + this.serverID + " to call #" + (++messageCounter) + " . Binary message received = " + binMsg;
	}
	
}