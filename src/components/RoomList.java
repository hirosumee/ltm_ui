/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import ltmui.frames.ChatPanel;
import ltmui.frames.Main;
import packets.RoomListPacket;
import packets.RoomPacket;
import utils.ChatListListener;
import vendor.Vendor;

/**
 *
 * @author hirosume
 */
public class RoomList extends JPanel {

	public class OnChange {

		public void execute(int id) {
			client.renderChatBox(id);
		}
	}

	JPanel list = new JPanel();
	public ChatPanel client;
	ChatListListener listener;

	/**
	 * Creates new form RoomList
	 */
	public RoomList(ChatPanel client) {
		list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
		initComponents();
		this.client = client;
		this.scrollList.setPreferredSize(new Dimension(0, 400));
		listener = new ChatListListener(this);
		initData();
	}

	private void initData() {
		Vendor.getClient().send(new RoomListPacket());
	}

	public void render(List<RoomPacket> list) {
		list.forEach(i -> {
			Room r = Room.fromPacket(i);
			r.register(new OnChange());
			this.list.add(r);
		});
		this.revalidate();
		this.repaint();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollList = new javax.swing.JScrollPane(list);

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
        add(scrollList);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollList;
    // End of variables declaration//GEN-END:variables
}
