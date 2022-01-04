package projekt;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 903966514116353163L;
	JTextField startCityTF;
	JTextField endCityTF;
	JButton startButton;
	JFileChooser fileChooser;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("Shortest Path Program");
		
		
		
		JPanel inputPanel = new JPanel(new GridLayout(1, 3));
		setSize(200, 200);
		add(inputPanel, BorderLayout.CENTER);
		startCityTF = new JTextField("Enter start city");
		endCityTF = new JTextField("Enter end city");
		startButton = new JButton("Start");
		inputPanel.add(startCityTF);
		inputPanel.add(endCityTF);
		inputPanel.add(startButton);
		
		JPanel 
	}	

}
