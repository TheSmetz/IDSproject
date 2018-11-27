package Timer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TimerMain extends JFrame {

	private JPanel contentPane;
	
	private int time = 9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerMain frame = new TimerMain();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("00 : 10");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 88, 428, 64);
		contentPane.add(lblNewLabel); 
		
		JButton btnRicomincia = new JButton("Ricomincia");
		btnRicomincia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRicomincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time = 9;
			}
		});
		btnRicomincia.setBounds(34, 168, 128, 60);
		contentPane.add(btnRicomincia);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnChiudi.setBounds(263, 168, 133, 60);
		contentPane.add(btnChiudi);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
	        public void run(){
	            if (time >= 0) {
	                lblNewLabel.setText("00 : 0" + time--);
	            }else {
	            	lblNewLabel.setText("Tempo Scaduto");
	            }
	        }
	    };
	    timer.scheduleAtFixedRate(task, 0, 1000);
        
	}
}
