package com.mjc813.server;

import com.mjc813.room.ChatRoom;
import com.mjc813.user.ChatUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerMain extends Thread implements ServerChatInterface {
	public static final int port = 50813;
	private Map<Long, ChatRoom> chatRooms;
	private ServerSocket serverSocket;
	private Set<ChatUser> lobby;

	public ServerMain() {
//		this.chatRooms = new LinkedList<>();
		this.chatRooms = Collections.synchronizedMap(new HashMap<Long, ChatRoom>());
		this.lobby = Collections.synchronizedSet(new HashSet<ChatUser>());
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while( true ) {
			try {
				if ( this.serverSocket.isClosed() ) {
					break;
				}
				Socket socket = this.serverSocket.accept();
				// 서버소켓이 클라이언트 연결을 받아 들이면 새로운 통신소켓을 리턴받아야 한다.

				ChatUser cu = new ChatUser(socket.getInetAddress().getHostAddress(), socket);

				this.lobby.add(cu); // 접속한 사용자는 모두 로비에 추가했다.
				this.printLobby();

//				ServerChatSocket scs = new ServerChatSocket(cu, this);
				ServerChatSocket scs = new ServerChatSocket(cu, this.lobby);
				scs.start();
				// 접속한 클라이언트 사용자가 보내는 데이터를 스레드로 받을 준비를 해야 한다.
			} catch (IOException e) {
			}
		}
	}

	private void printLobby() {
		for ( ChatUser cu : this.lobby ) {
			System.out.println(cu);
		}
	}

	@Override
	public void removeChatUser(ChatUser cu) {
		this.lobby.remove(cu);
	}

	public static void main(String[] args) {
		ServerMain sm = new ServerMain();
		sm.start();
	}
}