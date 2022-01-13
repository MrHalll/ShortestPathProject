package projekt;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
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
		setSize(500, 300);
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("Shortest Path Program");
		
		//JPanel för att välja fil och skriva in start och slutstad
		JPanel inputPanel = new JPanel(new GridLayout(1, 4));
		add(inputPanel, BorderLayout.NORTH);
		chooseFileButton = new JButton("Choose file");
		startCityTF = new JTextField("Start city");
		endCityTF = new JTextField("End city");
		startButton = new JButton("Start");
		inputPanel.add(startCityTF);
		inputPanel.add(endCityTF);
		inputPanel.add(chooseFileButton);
		inputPanel.add(startButton);
		chooseFileButton.addActionListener(e -> readFile());
		startButton.addActionListener(e -> checkInput());
		
		//JPanel där resultatet kommer at visas
		JPanel resultPanel = new JPanel(new BorderLayout());
		add(resultPanel, BorderLayout.CENTER);
		resultArea = new JTextArea("How it works: " + "\n" + "Enter start and end city to get the shortest path between those two citys"
		+ "\n" + "Leave 'end city' blank and you will get the shortest distance from all other citys to this city");
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
		String result = "";
		try {
			//Om ingen slutstad har valts så skriver den ut kortaste avstånd till alla städer
			if (endCityInput.equals("") || endCityInput.equals("End city")) {
				Map<City, Integer> distanceMap = Djikstra.calculateShortestPath(karta, karta.getCity(startCityInput));
				for (City city : distanceMap.keySet()) {
					result += city.toString() + ": " + distanceMap.get(city).toString() + "\n";
				}
				resultArea.setText(result);
			}else {
				result = Djikstra.getShortestPath(karta, karta.getCity(startCityInput), karta.getCity(endCityInput));
				resultArea.setText(result);
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cities doesn't exist in city map", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	

}
