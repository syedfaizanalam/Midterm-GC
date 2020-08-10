import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckIn extends JFrame implements ActionListener {

	private JLabel memberID; // Label for hourly salary
	private JLabel clubName; // Label for yearly salary
	private JTextField ID; // Displays hourly salary
	private JTextField enterClubName; // Displays yearly salary

	public CheckIn() {

		/*
		 * Constructor creates GUI components and adds GUI components using a
		 * GridBagLayout.
		 */

		// Used to specify GUI component layout
		GridBagConstraints positionConst = null;

		// Set frame's title
		setTitle("Salary");

		// Set hourly and yearly salary labels
		wageLabel = new JLabel("Hourly wage:");
		salLabel = new JLabel("Yearly salary:");

		wageField = new JTextField(15);
		wageField.setEditable(true);
		wageField.setText("0");

		salField = new JTextField(15);
		salField.setEditable(false);

		// Create a "Calculate" button
		calcButton = new JButton("Calculate");

		// Use "this" class to handle button presses
		calcButton.addActionListener(this);

		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		positionConst = new GridBagConstraints();

		// Specify component's grid location
		positionConst.gridx = 0;
		positionConst.gridy = 0;

		// 10 pixels of padding around component
		positionConst.insets = new Insets(10, 10, 10, 10);

		// Add component using the specified constraints
		add(wageLabel, positionConst);

		positionConst.gridx = 1;
		positionConst.gridy = 0;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(wageField, positionConst);

		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(salLabel, positionConst);

		positionConst.gridx = 1;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(salField, positionConst);

		positionConst.gridx = 0;
		positionConst.gridy = 2;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(calcButton, positionConst);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
