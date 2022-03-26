package code;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NewContact extends JFrame implements ActionListener {
	
	JLabel listTitle = new JLabel(" New Contact");
	
	
	JTextField fNameBar =new JTextField(22);
	JTextField lNameBar =new JTextField(22);
	JTextField cityBar =new JTextField(26);
	
	
	
	JLabel titleCard = new JLabel("Gestion des Contacts");
	
	JButton saveBtn = new JButton("Save");
	JButton cancelBtn = new JButton("Cancel");
	
	
	DefaultTableModel numTableModel = new DefaultTableModel();
	
	//JList<Contact> contactJlist = new JList<Contact>(Contact.getContactList());// use default model list
	JTable numTable = new JTable(numTableModel);
	JPanel grpCheck = new JPanel();
	
	NewContact(){
	setSize (500, 650);
	setTitle("Projet NFA035");
	
	Container cp = getContentPane();
	cp.setBackground (Color.cyan);
	cp.setLayout (new BorderLayout());
	setVisible(true);
	
	JPanel contactBtnPanel =new JPanel();
	
	JPanel rightBorderPanel =new JPanel();
	rightBorderPanel.setLayout(new BorderLayout());
	
	JPanel infoInputPanel = new JPanel();
	infoInputPanel.setLayout(new BoxLayout(infoInputPanel, BoxLayout.Y_AXIS));
	JPanel bar1 = new JPanel();
	JPanel bar2 = new JPanel();
	JPanel bar3 = new JPanel();
	bar1.setLayout(new FlowLayout());
	bar2.setLayout(new FlowLayout());
	bar3.setLayout(new FlowLayout());
	bar1.add(new JLabel("First Name"));
	bar1.add(fNameBar);
	infoInputPanel.add(bar1);
	bar2.add(new JLabel("Last Name"));
	bar2.add(lNameBar);
	infoInputPanel.add(bar2);
	bar3.add(new JLabel("City"));
	bar3.add(cityBar);
	infoInputPanel.add(bar3);
	//fNameBar.getDocument().addDocumentListener(this);// add the class as listener
	
	//lNameBar.getDocument().addDocumentListener(this);// add the class as listener
	
	//cityBar.getDocument().addDocumentListener(this);// add the class as listener
	
	
	JPanel actionBtnPanel = new JPanel();
	actionBtnPanel.setLayout(new FlowLayout());
	actionBtnPanel.add(saveBtn);
	actionBtnPanel.add(cancelBtn);
	
	

	cancelBtn.addActionListener(this);
	saveBtn.addActionListener(this);
	
	JPanel titlePanel =new JPanel();
	titlePanel.setLayout(new FlowLayout());
	titlePanel.setSize(500,70);
	titleCard.setFont(new Font("Sans Serif",Font.BOLD,14));
	titleCard.setForeground(Color.BLUE);
	titlePanel.add(titleCard);
	cp.add(titlePanel,BorderLayout.NORTH);
	
	contactBtnPanel.setLayout(new BoxLayout(contactBtnPanel, BoxLayout.Y_AXIS));
	
	listTitle.setMaximumSize(new Dimension(130, 15));
	listTitle.setFont(new Font("Sans Serif",Font.PLAIN,16));
	listTitle.setAlignmentX(CENTER_ALIGNMENT);
	
	
	
	contactBtnPanel.add(Box.createRigidArea(new Dimension(135,30)));
	contactBtnPanel.add(listTitle);
	
	
	cp.add(contactBtnPanel,BorderLayout.WEST);
	
	rightBorderPanel.add(infoInputPanel,BorderLayout.NORTH);
	rightBorderPanel.add(actionBtnPanel, BorderLayout.SOUTH);
	
	//contactJlist.setVisibleRowCount(20);
	//contactJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//JScrollPane listScroll = new JScrollPane(contactJlist);
	//listScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//listScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//listScroll.setPreferredSize(new Dimension(200,400));
	
	JLabel titleNum = new JLabel("Phone Numbers");
	titleNum.setAlignmentX(CENTER_ALIGNMENT);
	JLabel txtL = new JLabel("Add the Contact to Groups");
	txtL.setAlignmentX(CENTER_ALIGNMENT);
	
	numTableModel.addColumn("Region Code");
	numTableModel.addColumn("Phone Number");
	
	//numTableModel.insertRow(numTableModel.getRowCount(), new String[]{"test","test"});    
	//numTableModel.insertRow(numTableModel.getRowCount(), new String[]{"test1","test1"});
	createTable();
	//setTableText();
	//
	
	numTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	numTable.setCellSelectionEnabled(false);
	//numTable.setFocusable(false);
	
	JPanel tableContainerPanel= new JPanel();
	tableContainerPanel.setLayout(new BoxLayout(tableContainerPanel, BoxLayout.Y_AXIS));
	tableContainerPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
	
	JPanel numberTablePanel= new JPanel();
	numberTablePanel.setLayout(new BoxLayout(numberTablePanel, BoxLayout.Y_AXIS));
	numberTablePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
	
	tableContainerPanel.add(numTable.getTableHeader());
	numTable.getTableHeader().setReorderingAllowed(false);
	numTable.getTableHeader().setResizingAllowed(false);
	tableContainerPanel.add(numTable);
	
//JPanel grpCheck = new JPanel();
	grpCheck.setLayout(new BoxLayout(grpCheck, BoxLayout.Y_AXIS));;
	createArrayListGroupChecks(grpCheck);
	
	JScrollPane checkScrollPane = new JScrollPane(grpCheck);
	
	checkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	checkScrollPane.setPreferredSize(new Dimension(230,240));
	checkScrollPane.setBorder(BorderFactory.createEmptyBorder(0,75,0,0));
	JPanel sGrpCheck = new JPanel();
	sGrpCheck.add(checkScrollPane);
	
	numberTablePanel.add(titleNum);
	numberTablePanel.add(tableContainerPanel);
	numberTablePanel.add(txtL);
	
	numberTablePanel.add(sGrpCheck);
	rightBorderPanel.add(numberTablePanel,BorderLayout.CENTER);
	
	//rightBorderPanel.add(contactJlist, BorderLayout.CENTER);
	cp.add(rightBorderPanel, BorderLayout.EAST);
	}

	
	
	public void createTable() {
		for(int i=0; i<8; i++) {
			numTableModel.insertRow(numTableModel.getRowCount(), new String[] {"",""});
		
		}
		
	}
	
	
	public void createArrayListGroupChecks(JPanel panel){
		panel.add(new JCheckBox("No Groups",true));
		
		for(int i=0;i<Group.getGrpNamesList().size();i++) {
			//.isSelected();
			JCheckBox k = new JCheckBox(Group.getGrpNamesList().get(i));
			panel.add(k);
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		Object pressedObj = event.getSource();
	
	if(pressedObj==saveBtn) {save();

	}
	
	if(pressedObj==cancelBtn) {
		int p= JOptionPane.showConfirmDialog(this, "Vous voulez quitter cette fenêtre ?","Confirm Message",  JOptionPane.YES_NO_OPTION);
		if(p==JOptionPane.NO_OPTION) {
			return;
		}
		if(p==JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	
	}

	public void save() {
		String a,b;
		if(numTable.getCellEditor()!=null)numTable.getCellEditor().stopCellEditing();
		//System.out.println("save start");
		numTable.clearSelection();
		
		boolean empty=true;
		int i=0;
		
		while(empty==true && i<8) {
			if(numTableModel.getValueAt(i, 0).equals("")==false||  numTableModel.getValueAt(i, 1).equals("")==false) {
				empty = false;
				//System.out.println("ok"+i);
				
			}else if(numTableModel.getValueAt(i, 0).equals("")==true||  numTableModel.getValueAt(i, 1).equals("")==true) {
			//System.out.println("not ok"+i);
			i++;
			}
		
		}
		if(empty==true || fNameBar.getText().equals("") || lNameBar.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Un contact doit avoir un nom, un prénom, et au moins un numéro de téléphone", "Error Message", JOptionPane.ERROR_MESSAGE);
		
		}else {try {
			a= (String) numTableModel.getValueAt(i, 0);
			b = (String) numTableModel.getValueAt(i, 1);
			//System.out.println("new C "+a+"-"+b);
			Contact temp = new Contact(fNameBar.getText(),lNameBar.getText(), cityBar.getText() ,a.trim(), b.trim()); 
			for(int j=i+1;j<8;j++) {
				if(numTableModel.getValueAt(j, 0).equals("")==false||  numTableModel.getValueAt(j, 1).equals("")==false) {
				a= (String) numTableModel.getValueAt(j, 0);
				b =(String) numTableModel.getValueAt(j, 1);
			//	System.out.println("Scanner"+a +"-"+b);
				int idc = temp.getContactId();
				temp.addNumber(idc, a.trim(),b.trim());
			//	System.out.println("added f called");
				
				
				}
			}
			
			//new group is just for design 
			//checked or not cheked a contact is in "no group group " as long as no other grp is checked
			ArrayList<Integer> sBox = new ArrayList<Integer>();
			for (Component c : grpCheck.getComponents()) {
			    if (c instanceof JCheckBox) { 
			      if (((JCheckBox) c).isSelected()==true && ((JCheckBox) c).getText().equals("No Groups")==false) {
			    	
			    	 int l = Group.getGrpNamesList().indexOf( ((JCheckBox) c).getText());
			    	 sBox.add(l);
			    	 for(int u=0; u<sBox.size();u++) {
			    		Group local = Group.getGrpList().get(sBox.get(u));
			    		 local.addContact(temp);
			    		// System.out.println("added "+temp+"to "+local );
			    	 }
			      }
			    }
			}
			
			//stream 
		
		this.dispose();
			
			
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Invalid number or Long Number", "Error Message", JOptionPane.ERROR_MESSAGE);
			
		}
		}
		
		
		
	
	}
	



	
    
	
	}