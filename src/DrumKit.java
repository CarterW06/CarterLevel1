import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrumKit extends MouseAdapter {

    JLabel drumLabelWithImage;
	private JLabel drum1Label;
	private JLabel drum2Label;

    public static void main(String[] args) throws Exception {
   	 new DrumKit().getGoing();
    }

    private void getGoing() throws MalformedURLException {
   	 JFrame frame = new JFrame();
   	 frame.setVisible(true);
   	 frame.setSize(500, 500);
   	 frame.setTitle("The drum kit!");
   	 JPanel panel = new JPanel();
     frame.add(panel);
     String drum1PictureName = "tama-slp-metal-snare-drums-1-630-80.jpg";
   	 drum1Label = createLabelImage(drum1PictureName);
     panel.add(drum1Label);
     panel.setLayout(new GridLayout());
   	 frame.pack();
   	 drum1Label.addMouseListener(this);
   	 drum2Label = createLabelImage("Scottish_Tenor_Drum.jpg");
   	 panel.add(drum2Label);
   	 panel.setLayout(new GridLayout());
   	 frame.pack();
   	 drum2Label.addMouseListener(this);
   	 frame.setVisible(true);
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
    System.out.println("mouse clicked");
    if(e.getSource()==drum1Label){
   	 String drum1Sound = "270091__theriavirra__drumsticks-dave-weckl-evolution-open-wide-no4.wav";
   	 playSound(drum1Sound);
    }
    else if(e.getSource()==drum2Label){
    	String drum2Sound = "265198__killhead98__hot-wire-vinyl-drums.wav";
		playSound(drum2Sound);
    }
}

    private JLabel createLabelImage(String fileName) throws MalformedURLException {
   	 URL imageURL = getClass().getResource(fileName);
   	 Icon icon = new ImageIcon(imageURL);
   	 JLabel imageLabel = new JLabel(icon);
   	 return imageLabel;
    }

    private void playSound(String fileName) {
   	 AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
   	 sound.play();
    }

}



