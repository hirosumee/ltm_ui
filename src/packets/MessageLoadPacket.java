package packets;

import Engine.interfaces.Packet;

public class MessageLoadPacket implements Packet {
    public static final String type = "message.load";
    private static final long serialVersionUID = 1L;
    public int id;

    public MessageLoadPacket(int id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getType() {
        return type;
    }
}
