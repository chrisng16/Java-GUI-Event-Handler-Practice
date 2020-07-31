package event.management;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class RemoveFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8974723077116268457L;
	private MainFrame main;
	private JTextField txtSeatLocation;
	
	public RemoveFrame(MainFrame m) {
		super("Remove Attendant");
		getContentPane().setLayout(null);
		
		main=m;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 439, 39);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblChooseTheSeat = new JLabel("Input the seat that you want to remove");
		lblChooseTheSeat.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChooseTheSeat);
		lblChooseTheSeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 39, 432, 58);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblInputSeatNumber = new JLabel("Input seat number");
		panel_1.add(lblInputSeatNumber);
		lblInputSeatNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSeatLocation = new JTextField();
		panel_1.add(txtSeatLocation);
		txtSeatLocation.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		panel_1.add(btnSubmit);
		
		btnSubmit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		main.clearReport();
		try {
			int seatLocation = Integer.parseInt(txtSeatLocation.getText());
			Management manage = main.getManage();
			String response=manage.removeAttendant(seatLocation);
			main.getReportText().append(response);
			
			setVisible(false);
			main.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "All fields are required. Please try again...");
		}
	}
}
