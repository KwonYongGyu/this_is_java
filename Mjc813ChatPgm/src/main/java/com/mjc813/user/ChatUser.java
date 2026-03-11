package com.mjc813.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.Socket;

@Getter
@AllArgsConstructor
public class ChatUser {
	/**
	 * 대화자의 닉네임
	 */
	private String name;
	/**
	 * 대화자 클라이언트와 통신할 소켓
	 */
	private Socket socket;

	@Override
	public int hashCode() {
		return socket.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof ChatUser cu ) {
			if ( this.socket == null || cu.getSocket() == null ) {
				return false;
			}
			if ( this.socket.hashCode() == cu.getSocket().hashCode() ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("name:%s", this.name);
	}
}
