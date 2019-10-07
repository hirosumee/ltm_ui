package vendor;

import Engine.Driver.Client;
import Engine.Driver.Handleable;
import java.io.IOException;
import ltmui.frames.Main;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hirosume
 */
public class Vendor {
	private static int roomId;
	private static Vendor listener;
	private static Main main;
	private static Client client;
	private static String username;
	
	public Vendor(Main main) throws IOException {
		this.main = main;
		client = new Client();
	}

	public static Vendor getListener() {
		return listener;
	}

	public static Main getMain() {
		return main;
	}

	public static void register(String type, Handleable handler) {
		client.addListener(type, handler);
	}

	public static Client getClient() {
		return client;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Vendor.username = username;
	}

	public static int getRoomId() {
		return roomId;
	}

	public static void setRoomId(int roomId) {
		Vendor.roomId = roomId;
	}

}
