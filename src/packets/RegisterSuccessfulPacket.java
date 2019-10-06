package packets;

import Engine.interfaces.Packet;

public class RegisterSuccessfulPacket implements Packet {
	public static String type = "register.success";
	static final long serialVersionUID = 1L;
	private String username;

	public RegisterSuccessfulPacket(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getType() {
		return type;
	}
}
