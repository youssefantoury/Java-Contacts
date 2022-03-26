package code;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import code.GroupFrame.myMouseListener;

@SuppressWarnings("serial")
public class NewGroup extends JFrame implements ActionListener {
	
	JLabel listTitle = new JLabel(" New Group");
	
	GroupFrame  parentF;
	
	JTextField gNameBar =new JTextField(22);
	JTextField descriptionBar =new JTextField(22);
	
	
	JLabel titleCard = new JLabel("Gestion des Groupes");
	
	JButton saveBtn = new JButton("Save Group");
	JButton cancelBtn = new JButton("Cancel");
	
	
	DefaultTableModel contactTableModel = new DefaultTableModel();
	
	//JList<Contact> contactJlist = new JList<Contact>(Contact.getContactList());// use default model list
	JTable contactTable = new JTable(contactTableModel) {
		@Override
		public Class getColumnClass(int column) {return getValueAt(0, column).getClass();}
		
		public Class getClass(int column) {
			switch(column) {
			case 0 : return String.class;
			case 1: return String.class;
			default : return Boolean.class;
			}
			
			
		}

	};
	
	
	NewGroup(GroupFrame f){
	parentF = f;
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

	bar1.setLayout(new FlowLayout());
	bar2.setLayout(new FlowLayout());
	
	bar1.add(new JLabel("Group Name"));
	bar1.add(gNameBar);
	infoInputPanel.add(bar1);
	bar2.add(new JLabel("Description"));
	bar2.add(descriptionBar);
	infoInputPanel.add(bar2);
	
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
	
	JLabel titleNum = new JLabel("Group Contacts");
	titleNum.setAlignmentX(CENTER_ALIGNMENT);
	
	
	contactTableModel.addColumn("Contact Name");
	contactTableModel.addColumn("City");
	contactTableModel.addColumn("Add to Group");
	
	//numTableModel.insertRow(numTableModel.getRowCount(), new String[]{"test","test"});    
	//numTableModel.insertRow(numTableModel.getRowCount(), new String[]{"test1","test1"});
	createTable();
	//setTableText();
	//
	
	contactTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	contactTable.setCellSelectionEnabled(false);
	//numTable.setFocusable(false);
	
	JScrollPane grpScrollPanel = new JScrollPane(contactTable);
	 grpScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 grpScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 grpScrollPanel.setPreferredSize(new Dimension(300,400));
	
	 JPanel grpPanel = new JPanel();
	 grpPanel.setLayout(new BoxLayout(grpPanel, BoxLayout.Y_AXIS));
	 grpPanel.setMaximumSize(new Dimension(300,400));
	 grpScrollPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	 grpPanel.add(grpScrollPanel);
	 
	JPanel tableContainerPanel= new JPanel();
	tableContainerPanel.setLayout(new BoxLayout(tableContainerPanel, BoxLayout.Y_AXIS));
	tableContainerPanel.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));
	
	JPanel grpTablePanel= new JPanel();
	grpTablePanel.setLayout(new BoxLayout(grpTablePanel, BoxLayout.Y_AXIS));
	grpTablePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
	
	grpPanel.add(contactTable.getTableHeader());
	 contactTable.getTableHeader().setReorderingAllowed(false);
	 contactTable.getTableHeader().setResizingAllowed(false);

	 tableContainerPanel.setLayout(new BoxLayout(tableContainerPanel, BoxLayout.Y_AXIS));
	 tableContainerPanel.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));

	 tableContainerPanel.add(grpPanel);
	 
	 grpTablePanel.add(tableContainerPanel);
	 
	 //grpTable.addMouseListener(new myMouseListener()); for checkbox // maybe
	 
	 rightBorderPanel.add(grpTablePanel,BorderLayout.CENTER);
	 
	
	

	cp.add(rightBorderPanel, BorderLayout.EAST);
	}

	
	
	public void createTable() {
		int j =0;
		for(int i=0; i<Contact.getContactList().size(); i++) {
			Object[] rowList = new Object[3];
			String name= Contact.getContactList().get(i).getFirstName()+" "+Contact.getContactList().get(i).getLastName();
			String cityName= Contact.getContactList().get(i).getCity();
			//JCheckBox check = new JCheckBox("",false);// in edit we use g.getgrpcontacts.cntains(Contact.getContactList().get(i))
			rowList[0]=name;
			rowList[1]=cityName;
			rowList[2]=false;
			
			
			contactTableModel.insertRow(i, rowList);
			
			j=i;
		}
		
		for(int k=j+1; k<8; k++){
		
			contactTableModel.insertRow(contactTableModel.getRowCount(),new String[] {"",""});
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
		if(contactTable.getCellEditor()!=null)contactTable.getCellEditor().stopCellEditing();
		//System.out.println("save start");
		contactTable.clearSelection();
		
		
		
		
		
		if( gNameBar.getText().equals("") ) {
			JOptionPane.showMessageDialog(this, "Un contact doit avoir un nom, un prénom, et au moins un numéro de téléphone", "Error Message", JOptionPane.ERROR_MESSAGE);
		
		}else {try {
			Group n = new Group(gNameBar.getText().trim(),descriptionBar.getText().trim());
			
		
		for(int i=0; i<Contact.getContactList().size();i++) {
			
			if((Boolean)contactTableModel.getValueAt(i, 2)==true) {
				System.out.println((String) contactTableModel.getValueAt(0, 0) +(String) contactTableModel.getValueAt(1, 1));
				n.addContact(Contact.getContactList().get(i));
			}
			
		}
		String[] rowList = new String[2];
		rowList[0]=n.getGrpName();
		rowList[1]=String.valueOf(n.getGrpContacts().size());//Group.getGrpList().get(i).getGrpContacts().size();
		parentF.grpTableModel.insertRow(parentF.grpTableModel.getRowCount(), rowList);
		
			//GroupFrame.updateGroupTable(parentF);
			
			//stream 
		
		this.dispose();
			
			
		
		}catch(Exception e) {
		JOptionPane.showMessageDialog(this, "Invalid Input", "Error Message", JOptionPane.ERROR_MESSAGE);
			
		}
		
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	



	
    
	
	}