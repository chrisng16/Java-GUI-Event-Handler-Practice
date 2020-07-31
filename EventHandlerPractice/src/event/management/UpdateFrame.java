package event.management;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UpdateFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4866727182636939457L;
	private MainFrame main;
	private JTextField txtSeatLocation;
	private AddFrame add;
	
	public UpdateFrame(MainFrame m) {
		super("Update Attendant");
		getContentPane().setLayout(null);
		
		main=m;
		add = new AddFrame(main);
		add.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add.setSize(370,295);
		add.setResizable(false);
		add.setLocationRelativeTo(null);
		add.setVisible(false);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 432, 39);
		getContentPane().add(panelTitle);
		panelTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblInputTheSeat = new JLabel("Input the seat that you want to update");
		lblInputTheSeat.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblInputTheSeat);
		lblInputTheSeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 432, 41);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblInputSeatNumber = new JLabel("Input seat number:");
		lblInputSeatNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblInputSeatNumber);
		
		txtSeatLocation = new JTextField();
		panel.add(txtSeatLocation);
		txtSeatLocation.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		panel.add(btnSubmit);
		
		btnSubmit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		main.clearReport();
		int seatLocation = Integer.parseInt(txtSeatLocation.getText());
		String response=main.getManage().removeAttendant(seatLocation);
		if (response=="Error: The chosen seat is empty\n") {
			main.getReportText().append("Error: The seat is available. Cannot Update\n");
			setVisible(false);
			main.setVisible(true);
		}
		else {
			setVisible(false);
			add.setVisible(true);
		}
	}
}
