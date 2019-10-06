package ltmui.frames;

import Engine.Driver.Client;
import static java.util.Collections.list;
import packets.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hirosume
 */
public class Listener {

	Main main;

	public Listener(Main client) {
		this.main = client;
		init();
	}

	private void init() {
		Client client = main.getClient();
		//login
		client.addListener(LoginSuccessfulPacket.type, pk -> {
			LoginSuccessfulPacket packet = (LoginSuccessfulPacket) pk;
			System.out.println(packet.getUsername());
			if (main.getPanel() instanceof LoginPanel) {
				((LoginPanel) main.getPanel()).setMessage("Đăng nhập thành công");
				main.setCurrentUser(packet.getUsername());
				main.navigateToChat();
			}

		});
		client.addListener(LoginFailedPacket.type, pk -> {
			LoginFailedPacket packet = (LoginFailedPacket) pk;
			System.out.println(packet.getMessage());
			if (main.getPanel() instanceof LoginPanel) {
				((LoginPanel) main.getPanel()).setMessage(packet.getMessage());
			}
		});
		//register
		client.addListener(RegisterSuccessfulPacket.type, pk -> {
			RegisterSuccessfulPacket packet = (RegisterSuccessfulPacket) pk;
			if (main.getPanel() instanceof RegisterPanel) {
				((RegisterPanel) main.getPanel()).setMessage("Đăng kí thành công");
			}
		});
		client.addListener(RegisterFailedPacket.type, pk -> {
			RegisterFailedPacket packet = (RegisterFailedPacket) pk;
			if (main.getPanel() instanceof RegisterPanel) {
				((RegisterPanel) main.getPanel()).setMessage(packet.getMessage());
			}
		});
	
		client.addListener(RoomListResponsePacket.type, p -> {
			RoomListResponsePacket packet = (RoomListResponsePacket) p;
			if(main.getPanel() instanceof ChatPanel) {
				System.out.println(packet.getList().size());
				((ChatPanel) main.getPanel()).renderChatList(packet.getList());
			}
		});
		client.addListener(TextMessagePacket._type, p -> {
			TextMessagePacket packet = (TextMessagePacket) p;
			System.out.println("sfdf");
			if(main.getPanel() instanceof ChatPanel) {
				
				((ChatPanel) main.getPanel()).addMessage(packet);
			}
			System.out.println(packet.content);
		});
		client.addListener(MessageLoadSuccessPacket.type, p -> {
			System.out.println("dfd");
			MessageLoadSuccessPacket packet = (MessageLoadSuccessPacket) p;
			System.out.println("dfd");
			if(main.getPanel() instanceof ChatPanel) {
				((ChatPanel) main.getPanel()).initMessage(packet.getMessages());
			}
		});
	}
}
