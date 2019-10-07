/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Engine.Driver.Client;
import components.ChatBox;
import ltmui.frames.ChatPanel;
import packets.MessageLoadSuccessPacket;
import packets.TextMessagePacket;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class ChatBoxListener {

	ChatBox chatBox;

	public ChatBoxListener(ChatBox chatBox) {
		this.chatBox = chatBox;
		init();
	}

	private void init() {
		onInitMessage();
		onNewMessage();
	}

	private void onNewMessage() {
		Client client = Vendor.getClient();
		client.addListener(TextMessagePacket._type, p -> {
			TextMessagePacket packet = (TextMessagePacket) p;
			if (ChatBox.id == packet.id_room) {
				String username = Vendor.getUsername();
				chatBox.addMessage(packet, username);
			}
		});

	}

	private void onInitMessage() {
		Client client = Vendor.getClient();
		client.addListener(MessageLoadSuccessPacket.type, p -> {
			MessageLoadSuccessPacket packet = (MessageLoadSuccessPacket) p;
			String username = Vendor.getUsername();
			chatBox.initMessage(packet.getMessages(), username);
		});
	}
}
