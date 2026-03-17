package com.mjc813.multiclientfreechat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ServerAcceptThread extends Thread implements ServerNetworkInterface {
	private ServerSocket serverSocket;
	private List<ServerCommuicateSocket> clientList;

	public ServerAcceptThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		this.clientList = Collections.synchronizedList(new LinkedList<>());
	}

	public void accept() throws IOException {
		Socket socket = this.serverSocket.accept();
		System.out.println("client connect : " + socket.getInetAddress().getHostName());
		ServerCommuicateSocket scs = new ServerCommuicateSocket(socket, this);
		this.clientList.add(scs);
		scs.start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				this.accept();
			}
		} catch (Exception e) {
			System.out.println("서버 종료 할께요.");
			System.exit(0);
		}
	}

	@Override
	public void sendAllClients(String msg) {
		for ( ServerCommuicateSocket sc : this.clientList) {
			try {
				sc.send(msg);
			} catch (IOException e) {
				this.deleteClient(sc);
			}
		}
	}

	@Override
	public void deleteClient(ServerCommuicateSocket scs) {
		scs.close();
		this.clientList.remove(scs);
	}
}
