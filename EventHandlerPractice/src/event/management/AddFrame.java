package event.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class AddFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1218259785529477373L;
	
	private MainFrame main;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtSeatLocation;
	private JTextField txtMoneyPaid;
	
	public AddFrame(MainFrame m) {
		super("Add Attendant");
		getContentPane().setLayout(null);
		
		main=m;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 176, 201);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(12, 15, 140, 22);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(12, 52, 140, 22);
		panel.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(12, 89, 140, 22);
		panel.add(lblAge);
		
		JLabel lblSeatLocation = new JLabel("Seat Location");
		lblSeatLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeatLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeatLocation.setBounds(12, 126, 140, 22);
		panel.add(lblSeatLocation);
		
		JLabel lblMoneyPaid = new JLabel("Money Paid");
		lblMoneyPaid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoneyPaid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoneyPaid.setBounds(12, 163, 140, 22);
		panel.add(lblMoneyPaid);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(174, 0, 178, 201);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFirstName.setBounds(12, 15, 141, 22);
		panel_1.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBounds(12, 52, 141, 22);
		panel_1.add(txtLastName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(12, 89, 141, 22);
		panel_1.add(txtAge);
		
		txtSeatLocation = new JTextField();
		txtSeatLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSeatLocation.setColumns(10);
		txtSeatLocation.setBounds(12, 126, 141, 22);
		panel_1.add(txtSeatLocation);
		
		txtMoneyPaid = new JTextField();
		txtMoneyPaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMoneyPaid.setColumns(10);
		txtMoneyPaid.setBounds(12, 163, 141, 22);
		panel_1.add(txtMoneyPaid);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 199, 352, 41);
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(btnSubmit);
		
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		main.clearReport();
		try {
			String firstName=txtFirstName.getText();
			String lastName=txtLastName.getText();
			int age= Integer.parseInt(txtAge.getText());
			int seatLocation= Integer.parseInt(txtSeatLocation.getText());
			double moneyPaid = Double.parseDouble(txtMoneyPaid.getText());
			Management manage= main.getManage();
			String textResponse=manage.addAttendant(firstName, lastName, age, seatLocation, moneyPaid);
			main.getReportText().append(textResponse);
			
			txtFirstName.setText("");
			txtLastName.setText("");
			txtAge.setText("");
			txtSeatLocation.setText("");
			txtMoneyPaid.setText("");
			
			setVisible(false);
			main.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "All fields are required. Please try again...\n"+e);
		}
	}
}
