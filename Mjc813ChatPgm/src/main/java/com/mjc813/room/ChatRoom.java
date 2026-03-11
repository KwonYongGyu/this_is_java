package com.mjc813.room;

import com.mjc813.user.ChatUser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom {
	private static Long lastRoomId = 1L;
	/**
	 * 대화방의 고유 번호, 중복 안됨
	 */
	private final Long roomId;
	/**
	 * 채팅 유저들의 컬렉션
	 */
	private final List<ChatUser> users;

	public ChatRoom() {
//		this.users = new LinkedList<>();
		this.users = Collections.synchronizedList(new LinkedList<>());
		this.roomId = lastRoomId++; // 새로운방은 id 값을 항상 1 더해서 중복을 피한다.
	}

	/**
	 * 대화방의 모든 사용자를 리턴한다.
	 * @return
	 */
	public List<ChatUser> getAllUsers() {
		return this.users;
	}

	/**
	 * 대화방의 고유번호를 리턴한다.
	 * @return
	 */
	public Long getRoomId() {
		return this.roomId;
	}
}
