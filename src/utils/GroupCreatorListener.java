/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import packets.RoomCreateSuccessfulPacket;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class GroupCreatorListener {

	public GroupCreatorListener() {
		Vendor.getClient().addListener(RoomCreateSuccessfulPacket.type, p -> Vendor.getMain().navigateToChat());
	}
	
}
