import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMRApp extends JFrame{
	private JFrame frame;
	private JPanel panel;
	private JLabel questionUnitsLabel;
	private JComboBox<String> unitOptions;
	private JLabel questionWeightLabel;
	private JTextField weightField;
	private JLabel questionHeightLabel;
	private JTextField heightField;
	private JLabel questionAgeLabel;
	private JTextField ageField;
	private JLabel questionGenderLabel;
	private JComboBox<String> genderOptions;
	private JButton calculateButton;
	
	public BMRApp() {
		frame = new JFrame();
		
		String[] units = {" ", "Metric (kg and cm)", "Imperial (lb and in)"};
		String[] genders = {" ", "Male", "Female"};
		
		questionUnitsLabel = new JLabel("Select units below:");
		unitOptions = new JComboBox<String>(units);
				
		questionWeightLabel = new JLabel("What is your weight?");
		weightField = new JTextField();
		
		questionHeightLabel = new JLabel("What is your height?");
		heightField = new JTextField();
		
		questionAgeLabel = new JLabel("What is your age?");
		ageField = new JTextField();
		
		questionGenderLabel = new JLabel("Select gender below:");
		genderOptions = new JComboBox<String>(genders);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String message = "BMR: " + getBMR();
				JOptionPane.showMessageDialog(BMRApp.this, message);
				}
			});
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));
		
		panel.add(questionUnitsLabel);
		panel.add(unitOptions);
		panel.add(questionWeightLabel);
		panel.add(weightField);
		panel.add(questionHeightLabel);
		panel.add(heightField);
		panel.add(questionAgeLabel);
		panel.add(ageField);
		panel.add(questionGenderLabel);
		panel.add(genderOptions);
		panel.add(calculateButton);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BMR Calculator");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public double getBMR() {
		double weight = Double.parseDouble(weightField.getText());
		double height = Double.parseDouble(heightField.getText());
		int age = Integer.parseInt(ageField.getText());
		double bmr = 0;
		
		if (unitOptions.getSelectedItem().equals("Imperial (lb and in)")) {
			weight /= 2.205;
			height *= 2.54;
		}
		
		if (genderOptions.getSelectedItem().equals("Male")) {
			bmr += 10 * weight + 6.25 * height - 5 * age + 5;
		}
		else {
			bmr += 10 * weight + 6.25 * height - 5 * age - 161;
		}
		
		return bmr;
	}
	
	
	public static void main(String[] args) {
		new BMRApp();
	}
}
