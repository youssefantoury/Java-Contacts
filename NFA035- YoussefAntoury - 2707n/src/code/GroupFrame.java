package code;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class GroupFrame extends JFrame implements ActionListener {
	
	JLabel listTitle = new JLabel(" Groups");
	//JButton sortFname = new JButton("Sort by first name");
	//JButton sortLname = new JButton("Sort by last name");
	//JButton sortCity = new JButton("Sort by City");
	JButton addNew = new JButton("Add new Groupe");
	//JTextField searchBar =new JTextField(22);
	
	JLabel titleCard = new JLabel("Gestion des Groupes");
	
	//JButton viewBtn = new JButton("View");
	JButton updateBtn = new JButton("Update Group");
	JButton deleteBtn = new JButton("Delete");
	
	DefaultTableModel grpTableModel = new DefaultTableModel();
	JTable grpTable = new JTable(grpTableModel);
	DefaultTableModel cTableModel = new DefaultTableModel();
	JTable cTable = new JTable(cTableModel);
	
	
	JList<Contact> contactJlist = new JList<Contact>(Contact.getContactList());// use default model list
	
	
	GroupFrame(){
	setSize (500, 650);
	setTitle("Projet NFA035");
	titleCard.setForeground(Color.BLUE);
	Container cp = getContentPane();
	cp.setBackground (Color.cyan);
	cp.setLayout (new BorderLayout());
	setVisible(true);
	Contact.sortContactListbyName();
	JPanel contactBtnPanel =new JPanel();
	
	JPanel rightBorderPanel =new JPanel();
	rightBorderPanel.setLayout(new BorderLayout());
	
	JPanel tableTitlePanel = new JPanel();
	tableTitlePanel.setLayout(new FlowLayout());
	tableTitlePanel.add(new JLabel("List of Groups"));
	
	//searchBar.getDocument().addDocumentListener(this);// add the class as listener
	//searchbarPanel.add(tableTitle);
	
	JPanel actionBtnPanel = new JPanel();
	actionBtnPanel.setLayout(new FlowLayout());
	//actionBtnPanel.add(viewBtn);
	actionBtnPanel.add(updateBtn);
	actionBtnPanel.add(deleteBtn);
	
	deleteBtn.addActionListener(this);
	updateBtn.addActionListener(this);
	//viewBtn.addActionListener(this);
	
	JPanel titlePanel =new JPanel();
	titlePanel.setLayout(new FlowLayout());
	titlePanel.setSize(500,70);
	titleCard.setFont(new Font("Sans Serif",Font.BOLD,14));
	titlePanel.add(titleCard);
	cp.add(titlePanel,BorderLayout.NORTH);
	
	contactBtnPanel.setLayout(new BoxLayout(contactBtnPanel, BoxLayout.Y_AXIS));
	
	listTitle.setMaximumSize(new Dimension(145, 30));
	listTitle.setFont(new Font("Sans Serif",Font.PLAIN,16));
	listTitle.setAlignmentX(CENTER_ALIGNMENT);
	
	
	addNew.setMaximumSize(new Dimension(145, 30));
	addNew.addActionListener(this);
	addNew.setAlignmentX(Component.CENTER_ALIGNMENT);

	
	contactBtnPanel.add(Box.createRigidArea(new Dimension(155,30)));
	contactBtnPanel.add(listTitle);
	
	contactBtnPanel.add(Box.createRigidArea(new Dimension(155,30)));
	contactBtnPanel.add(addNew);
	
	cp.add(contactBtnPanel,BorderLayout.WEST);
	
	rightBorderPanel.add(tableTitlePanel,BorderLayout.NORTH);
	rightBorderPanel.add(actionBtnPanel, BorderLayout.SOUTH);
	
	grpTableModel.addColumn("Group Name");
	grpTableModel.addColumn("Nb of contacts");
	
	cTableModel.addColumn("Contact Name");
	cTableModel.addColumn("Contact City");

	 createGrpTable();
	 createCTable();
	 
	 cTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 grpTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	// grpTable.setCellSelectionEnabled(false);
	 //grpTable.setFocusable(false);
	 //grpTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	 
	 JScrollPane cScrollPanel = new JScrollPane(cTable);
	 cScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 cScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 cScrollPanel.setPreferredSize(new Dimension(200,50));
	 
	 JScrollPane grpScrollPanel = new JScrollPane(grpTable);
	 grpScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 grpScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 grpScrollPanel.setPreferredSize(new Dimension(200,50));
	// grpScrollPanel.add(grpTable);
	 
	 JPanel grpPanel = new JPanel();
	 grpPanel.setLayout(new BoxLayout(grpPanel, BoxLayout.Y_AXIS));
	 grpPanel.setMaximumSize(new Dimension(200,155));
	 grpScrollPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	 grpPanel.add(grpScrollPanel);
	 
	 JPanel cPanel = new JPanel();
	 cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
	 cPanel.setMaximumSize(new Dimension(200,180));
	 cScrollPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	 cPanel.add(cScrollPanel);
	 
	 
	 JPanel tableContainerPanel= new JPanel();
	 tableContainerPanel.setLayout(new BoxLayout(tableContainerPanel, BoxLayout.Y_AXIS));
	 tableContainerPanel.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));

	 JPanel grpTablePanel= new JPanel();
	 grpTablePanel.setLayout(new BoxLayout(grpTablePanel, BoxLayout.Y_AXIS));
	 grpTablePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));

	 JPanel cTablePanel= new JPanel();
	 cTablePanel.setLayout(new BoxLayout(cTablePanel, BoxLayout.Y_AXIS));
	 cTablePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
	 
	 grpPanel.add(grpTable.getTableHeader());
	 grpTable.getTableHeader().setReorderingAllowed(false);
	 grpTable.getTableHeader().setResizingAllowed(false);
	 
	 cPanel.add(cTable.getTableHeader());
	 cTable.getTableHeader().setReorderingAllowed(false);
	 cTable.getTableHeader().setResizingAllowed(false);
	 //cPanel.add(cTable);
	
	 tableContainerPanel.setLayout(new BoxLayout(tableContainerPanel, BoxLayout.Y_AXIS));
	 tableContainerPanel.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));

	 tableContainerPanel.add(grpPanel);
	 tableContainerPanel.add(Box.createRigidArea(new Dimension(200,30)));
	 tableContainerPanel.add(cPanel);
	 
	//JPanel listScrollPanel= new JPanel();
	//listScrollPanel.setLayout(new FlowLayout());
	//listScrollPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
	
	grpTablePanel.add(tableContainerPanel);
	
	
	grpTable.addMouseListener(new myMouseListener());
	cTable.addMouseListener(new myMouseListener());
	/*grpTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){//gets called 2 times because 1 time on click and one time on release
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(grpTable.getValueAt(grpTable.getSelectedRow(), 0));
        }
    });*/
	
	
	 
	
	//rightBorderPanel.add(listScrollPanel,BorderLayout.CENTER);
	rightBorderPanel.add(grpTablePanel,BorderLayout.CENTER);
	
	cp.add(rightBorderPanel, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object pressedObj = event.getSource();
	
	if(pressedObj==addNew) {new NewGroup(this);
	}
	
	if(pressedObj==updateBtn) { new EditGroup(Group.getGrpList().get(grpTable.getSelectedRow()),this);
	}
	if(pressedObj==deleteBtn) {
		int res= JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer ce groupe ?", "Confirm Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	if(res==JOptionPane.YES_OPTION ) {
		
		for(int z=0; z<Group.getGrpList().get(grpTable.getSelectedRow()).getGrpContacts().size();z++) {
		Group.getGrpList().get(grpTable.getSelectedRow()).getGrpContacts().remove(z);
		}
		//Group.getGrpList().remove(Group.getGrpList().get(grpTable.getSelectedRow()));
		Group.getGrpNamesList().remove(Group.getGrpList().get(grpTable.getSelectedRow()).getGrpName());
		grpTableModel.removeRow(grpTable.getSelectedRow());
		if(grpTable.getRowCount()<8)grpTableModel.insertRow(grpTable.getRowCount(), new String[] {"",""});
	}else {return;}
	}
	
	
	
	}
	
	
	public void showContacts(Group g) {
		for(int k=0; k<8; k++){
			cTableModel.setValueAt("", k, 0);
			cTableModel.setValueAt("", k, 1);
		}
		for(int k=0; k<g.getGrpContacts().size(); k++){
			
			
			if(k>=8 && k<g.getGrpContacts().size()) {
				cTableModel.insertRow(cTableModel.getRowCount(),new String[] {""+g.getGrpContacts().get(k).getFirstName()+" "+ g.getGrpContacts().get(k).getLastName(),""+g.getGrpContacts().get(k).getCity()});
				
			}else {
				cTableModel.setValueAt(""+g.getGrpContacts().get(k).getFirstName()+" "+ g.getGrpContacts().get(k).getLastName(),k,0);
				cTableModel.setValueAt(""+g.getGrpContacts().get(k).getCity(),k,1);
				
			}
		}
	}
	
	

	public void createCTable() {
		
		for(int k=0; k<8; k++){
		
			cTableModel.insertRow(cTableModel.getRowCount(),new String[] {"",""});
		}
		
	}
	
	
	public void updateGrpTable() {
		
		if(grpTableModel.getValueAt(0, 0)!=null) {
			
					
			int j =0;
			for(int i=0; i<Group.getGrpNamesList().size(); i++) {
				Group.getGrpNamesList().set(i, Group.getGrpList().get(i).getGrpName());
				String[] rowList = new String[2];
				String name= Group.getGrpNamesList().get(i);
				int totalNb= Group.getGrpList().get(i).getGrpContacts().size();
				rowList[0]=name;
				rowList[1]=String.valueOf(totalNb);
				grpTableModel.setValueAt(name, i,0);
				grpTableModel.setValueAt(totalNb, i, 1);
				//grpTableModel.insertRow(i, rowList);
				
				j=i;
			}
			
			for(int k=j+1; k<8; k++){
			
				grpTableModel.setValueAt("",grpTableModel.getRowCount(),0);
				grpTableModel.setValueAt("",grpTableModel.getRowCount(),1);
				
			}
			
			
		}
		
		
	}
	
	
	
	public void createGrpTable() {
	
		
		
		int j =0;
		for(int i=0; i<Group.getGrpNamesList().size(); i++) {
			String[] rowList = new String[2];
			String name= Group.getGrpNamesList().get(i);
			int totalNb= Group.getGrpList().get(i).getGrpContacts().size();
			rowList[0]=name;
			rowList[1]=String.valueOf(totalNb);
			grpTableModel.insertRow(i, rowList);
			
			j=i;
		}
		
		for(int k=j+1; k<8; k++){
		
			grpTableModel.insertRow(grpTableModel.getRowCount(),new String[] {"",""});
		}
		
		
	}   
	
	
	/* public static void updateGroupTable(GroupFrame f) {
		for(int k=0; k<f.grpTableModel.getRowCount(); k++){
			f.grpTableModel.setValueAt("", k, 0);
			f.grpTableModel.setValueAt("", k, 1);
		}
		
		int j=0;
		for(int i=0; i<Group.getGrpNamesList().size(); i++) {
			
			String[] rowList = new String[2];
			String name= Group.getGrpNamesList().get(i);
			int totalNb= Group.getGrpList().get(i).getGrpContacts().size();
			rowList[0]=name;
			rowList[1]=String.valueOf(totalNb);
			f.grpTableModel.insertRow( i, rowList);
			
			j=i;
					}
		for(int k=j+1; k<8; k++){
		if(k<8 && k>Group.getGrpNamesList().size()) {
			f.grpTableModel.insertRow(f.grpTableModel.getRowCount(),new String[] {"",""});
		}
		}
		
	}*/
	
	
	class myMouseListener implements MouseListener {

	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	if(e.getSource()==grpTable) {
	    	System.out.println(grpTable.getValueAt(grpTable.getSelectedRow(), 0));
	    	 showContacts(Group.getGrpList().get(grpTable.getSelectedRow()));
	    	}
	    	if(e.getSource()==cTable) {
	    	//	if(Contact.getContactFromNameCityGroup(grpTable.getValueAt(grpTable.getSelectedRow(), 0).toString(), grpTable.getValueAt(grpTable.getSelectedRow(), 1).toString(), Group.getGrpList().get(grpTable.getSelectedRow()))!=null) {
	    		//new ViewContact(Contact.getContactFromNameCityGroup(grpTable.getValueAt(grpTable.getSelectedRow(), 0).toString(),grpTable.getValueAt(grpTable.getSelectedRow(), 1).toString(), Group.getGrpList().get(grpTable.getSelectedRow())));
	    		//System.out.println(grpTable.getValueAt(grpTable.getSelectedRow(), 0).toString()+"-"+grpTable.getValueAt(grpTable.getSelectedRow(), 1).toString());
	    		System.out.println(Group.getGrpList().get(grpTable.getSelectedRow()).getGrpContacts().get(cTable.getSelectedRow()));
	    		new ViewContact(Group.getGrpList().get(grpTable.getSelectedRow()).getGrpContacts().get(cTable.getSelectedRow()));
	    		//}
	    		}
    	}

	    @Override
	    public void mousePressed(MouseEvent e) {
	          // Insert code to show password  
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	         // Insert code to hide password again
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {

	    }
	}
	
	
	}