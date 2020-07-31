package event.management;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllAttendantsTable extends JFrame implements ActionListener{

	private static final long serialVersionUID = -631637341467887817L;
	private MainFrame main;
	private JTable table;
	
	public AllAttendantsTable(MainFrame m) {
		super("Attendants Table");
		main = m;
		
		String[] columnNames = {"First Name","Last Name","Seat Location","Price Paid"};
		ArrayList<Attendant> attendants = main.getManage().getAttendants();
		String[][] data = new String[attendants.size()][4];
		for (int i=0; i<attendants.size(); i++) {
			Attendant person = attendants.get(i);
			for (int j=0; j < 4; j++) {
				if (j==0)
					data[i][j]=person.getFirstName();
				else if(j==1)
					data[i][j]=person.getLastName();
				else if(j==2)
					data[i][j]=String.valueOf(person.getSeatLocation());
				else if(j==3)
					data[i][j]=String.valueOf(person.getMoneyPaid());
			}
		}
	    getContentPane().setLayout(null);
	    table=new JTable(data,columnNames);
	    JScrollPane scrollPane= new JScrollPane(table);
	    scrollPane.setBounds(0, 0, 561, 404);
	    table.setAutoCreateRowSorter(true);
	    getContentPane().add(scrollPane);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(178, 403, 211, 34);
	    getContentPane().add(panel);
	    panel.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JButton btnBack = new JButton("Back");
	    btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    panel.add(btnBack);
	    setSize(579, 483);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
		
	    btnBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		setVisible(false);
		main.setVisible(true);
	}

}
