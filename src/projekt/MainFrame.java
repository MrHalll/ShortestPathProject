package projekt;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 903966514116353163L;
	String startCityInput;
	String endCityInput;
	JTextField startCityTF;
	JTextField endCityTF;
	JTextArea resultArea;
	JButton startButton;
	JButton chooseFileButton;
	JFileChooser fileChooser;
	IMap karta;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("Shortest Path Program");
		
		JPanel chooseFilePanel = new JPanel(new GridLayout(1, 1));
		chooseFilePanel.setSize(400, 100);
		add(chooseFilePanel, BorderLayout.NORTH);
		chooseFileButton = new JButton("Choose file");
		chooseFilePanel.add(chooseFileButton);
		chooseFileButton.addActionListener(e -> readFile());
		
		JPanel inputPanel = new JPanel(new GridLayout(1, 3));
		inputPanel.setSize(400, 150);
		add(inputPanel, BorderLayout.CENTER);
		startCityTF = new JTextField();
		endCityTF = new JTextField();
		startButton = new JButton("Start");
		inputPanel.add(startCityTF);
		inputPanel.add(endCityTF);
		inputPanel.add(startButton);
		startButton.addActionListener(e -> checkInput());
		
		JPanel resultPanel = new JPanel(new BorderLayout());
		resultPanel.setSize(400, 150);
		add(resultPanel, BorderLayout.SOUTH);
		resultArea = new JTextArea("Här kommmer resultatet");
		resultPanel.add(resultArea);
	}

	private void readFile() {
		City start;
		City end;
		int distance;
		karta = new CityMap();
		fileChooser = new JFileChooser();
		int userResponse = fileChooser.showOpenDialog(null);
		if (userResponse == JFileChooser.APPROVE_OPTION) {
			//File inputFile = new File("C:\\Users\\melle\\OneDrive\\HIG\\AlgoritmerDatastrukturer\\Projekt\\StadsLista.txt");
			File inputFile = fileChooser.getSelectedFile();
			try {
				Scanner fileScanner = new Scanner(inputFile);
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					Scanner lineScanner = new Scanner(line).useDelimiter(" ");
					start = new City(lineScanner.next());
					end = new City(lineScanner.next());
					distance = lineScanner.nextInt();
					karta.addBranch(start, end, distance);
					lineScanner.close();
				}
				fileScanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkInput() {
		startCityInput = startCityTF.getText();
		endCityInput = endCityTF.getText();
		try {
			String result = Djikstra.getShortestPath(karta, karta.getCity(startCityInput), karta.getCity(endCityInput));
			resultArea.setText(result);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,
					"Cities doesn't exist in city map",
					"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}	

}
