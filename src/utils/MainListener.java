/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Engine.Driver.Client;
import ltmui.frames.LoginPanel;
import ltmui.frames.Main;
import ltmui.frames.RegisterPanel;
import packets.LoginFailedPacket;
import packets.LoginSuccessfulPacket;
import packets.RegisterFailedPacket;
import packets.RegisterSuccessfulPacket;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class MainListener {

	Main main;
	Client client;

	{
		client = Vendor.getClient();
	}

	public MainListener(Main main) {
		this.main = main;
		init();
	}

	private void init() {
//		onLoginSuccess();
//		onLoginFailed();
		//register

	}

}
