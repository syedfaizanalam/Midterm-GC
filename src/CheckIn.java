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
	private JButton checkIn;

	private JTextField ClubName; // Displays yearly salary


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
		memberID = new JLabel("Member ID");
		clubName = new JLabel("Club Name:");

		ID = new JTextField(15);
		ID.setEditable(true);
		ID.setText("0");

		enterClubName = new JTextField(15);
		enterClubName.setEditable(true);

		// Create a "Calculate" button
		checkIn = new JButton("Calculate");

		// Use "this" class to handle button presses
		checkIn.addActionListener(this);

		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		positionConst = new GridBagConstraints();

		// Specify component's grid location
		positionConst.gridx = 0;
		positionConst.gridy = 0;

		// 10 pixels of padding around component
		positionConst.insets = new Insets(10, 10, 10, 10);

		// Add component using the specified constraints
		add(memberID, positionConst);

		positionConst.gridx = 1;
		positionConst.gridy = 0;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(clubName, positionConst);

		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(ID, positionConst);

		positionConst.gridx = 1;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(enterClubName, positionConst);

		positionConst.gridx = 0;
		positionConst.gridy = 2;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(checkIn, positionConst);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int ID;
		String ClubName;
		ID=wageField.getText();
		ClubName=wageField.getText();

	}

}
