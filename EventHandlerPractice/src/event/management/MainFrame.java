package event.management;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6833344869409213826L;
	private AddFrame add;
	private RemoveFrame remove;
	private UpdateFrame update;
	private Management manage;
	private JButton btnAddAttendant;
	private JButton btnPrintReport;
	private JButton btnRemoveAttendant;
	private JButton btnUpdateAttendant;
	private JButton btnShowAllAttendants;
	private JTextArea reportText;
	
	public MainFrame() {
		super("Attendants Management");
		getContentPane().setLayout(null);
		
		manage = new Management();
		
		add = new AddFrame(this);
		add.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add.setSize(370,295);
		add.setResizable(false);
		add.setLocationRelativeTo(null);
		add.setVisible(false);
		
		remove = new RemoveFrame(this);
		remove.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		remove.setSize(450,125);
		remove.setResizable(false);
		remove.setLocationRelativeTo(null);
		remove.setVisible(false);
		
		update = new UpdateFrame(this);
		update.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		update.setSize(450, 125);
		update.setResizable(false);
		update.setLocationRelativeTo(null);
		remove.setVisible(false);
	
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(UIManager.getBorder("Button.border"));
		panel.setBounds(0, 0, 486, 62);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAttendanceManagement = new JLabel("Attendance Management");
		lblAttendanceManagement.setForeground(Color.WHITE);
		lblAttendanceManagement.setBackground(UIManager.getColor("ScrollBar.trackHighlightForeground"));
		lblAttendanceManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendanceManagement.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblAttendanceManagement);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(0, 61, 217, 379);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAddAttendant = new JButton("Add Attendant");
		btnAddAttendant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnAddAttendant);
		
		btnRemoveAttendant = new JButton("Remove Attendant");
		btnRemoveAttendant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnRemoveAttendant);
		
		btnUpdateAttendant = new JButton("Update Attendant");
		btnUpdateAttendant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnUpdateAttendant);
		
		btnShowAllAttendants = new JButton("Show All Attendants");
		btnShowAllAttendants.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnShowAllAttendants);
		
		btnPrintReport = new JButton("Print Report");
		btnPrintReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnPrintReport);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(217, 61, 269, 349);
		getContentPane().add(scrollPane);
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Report", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		reportText = new JTextArea();
		reportText.setWrapStyleWord(true);
		reportText.setLineWrap(true);
		reportText.setEditable(false);
		scrollPane.setViewportView(reportText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(304, 409, 91, 31);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reportText.setText("");
			}
		});
		panel_2.add(btnClear);
		
		btnPrintReport.addActionListener(this);
		btnAddAttendant.addActionListener(this);
		btnRemoveAttendant.addActionListener(this);
		btnUpdateAttendant.addActionListener(this);
		btnShowAllAttendants.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAddAttendant) {
			add.setVisible(true);
		}
		else if (event.getSource() == btnPrintReport) {
			reportText.setText(manage.showReport());
		}
		else if (event.getSource() == btnRemoveAttendant) {
			remove.setVisible(true);
		}
		else if (event.getSource()==btnUpdateAttendant) {
			update.setVisible(true);
		}
		else if (event.getSource()==btnShowAllAttendants) {
			AllAttendantsTable showAll = new AllAttendantsTable(this);
			showAll.setSize(582, 483);
			showAll.setResizable(false);
			showAll.setLocationRelativeTo(null);
			showAll.setVisible(true);	
		}
	}
	public Management getManage() {
		return this.manage;
	}
	public JTextArea getReportText() {
		return this.reportText;
	}
	public void clearReport() {
		reportText.setText("");
	}
}