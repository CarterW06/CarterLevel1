import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	JFrame frame = new JFrame();
	JButton button2 = new JButton("Treat");
	private JButton button1;

	public static void main(String[] args) {
		new NastySurprise().createGUI();
	}

	void createGUI() {
		JPanel panel = new JPanel();
		button1 = new JButton("Trick");
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setListener(button1);
		setListener(button2);
	}

	void setListener(JButton button) {
		button.addActionListener(this);
		System.out.println("test");
	}

	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.remove(button1);
		frame.remove(button2);
		frame.setVisible(false);
		if (e.getSource().equals(button1)) {
			System.out.println("button1 clicked");
			showPictureFromTheInternet("http://c.fastcompany.net/multisite_files/fastcompany/poster/2014/01/3025003-poster-p-dog-2.jpg");
		} else if (e.getSource().equals(button2)) {
			System.out.println("button2 clicked");
			showPictureFromTheInternet("http://i66.photobucket.com/albums/h262/flies12/And_now_for_something_scary_by_Cele.jpg");
		}
	}

}
