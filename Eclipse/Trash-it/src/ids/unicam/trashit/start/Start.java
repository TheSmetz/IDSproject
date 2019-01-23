package ids.unicam.trashit.start;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ids.unicam.trashit.grafica.GuiMain;
import ids.unicam.trashit.grafica.Home;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JLayeredPane;



public class Start extends JFrame {
	
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JLabel background;
	
	public Start() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/aaa.png")));
		setTitle("Trash-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1045, 699);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Home h=new Home();
		layeredPane.add(h.getPanelHome() , "name_781337426904700");
		background();

		
	}
	
	private void background() {
		background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
	}
	
    public static void main(String[] args) throws Exception{
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start frame = new Start();
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}