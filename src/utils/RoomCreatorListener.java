/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import components.RoomCreator;
import packets.RoomCreateSuccessfulPacket;
import packets.UserFindSuccessPacket;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class RoomCreatorListener {

	RoomCreator roomCreator;

	public RoomCreatorListener(RoomCreator roomCreator) {
		this.roomCreator = roomCreator;
		init();
	}

	private void init() {
		Vendor.getClient().addListener(UserFindSuccessPacket.type, p -> {
			UserFindSuccessPacket packet = (UserFindSuccessPacket) p;
			roomCreator.onListUsername(packet.getUsernames());

		});
		Vendor.getClient().addListener(RoomCreateSuccessfulPacket.type, p -> Vendor.getMain().navigateToChat());
	}

}
