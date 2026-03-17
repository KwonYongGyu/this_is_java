package com.mjc813.multiclientfreechat;

public interface ServerNetworkInterface {
	public void sendAllClients(String msg);
	public void deleteClient(ServerCommuicateSocket scs);
}
