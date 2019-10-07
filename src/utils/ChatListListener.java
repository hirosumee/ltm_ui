/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import components.RoomList;
import ltmui.frames.ChatPanel;
import packets.RoomListResponsePacket;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class ChatListListener {

	RoomList roomlist;

	public ChatListListener(RoomList roomlist) {
		this.roomlist = roomlist;
		init();
	}

	private void init() {
		onRoomList();
	}
	private void onRoomList() {
		Vendor.register(RoomListResponsePacket.type, p -> {
			RoomListResponsePacket packet = (RoomListResponsePacket) p;
			roomlist.render(packet.getList());
		});
	}
}
