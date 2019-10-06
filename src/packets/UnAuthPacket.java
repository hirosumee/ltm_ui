package packets;

import Engine.interfaces.Packet;

public class UnAuthPacket implements Packet {

	static final long serialVersionUID = 1L;

	@Override
	public String getType() {
		return "UnAuth";
	}
}
