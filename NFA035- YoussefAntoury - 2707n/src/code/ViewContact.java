package code;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ViewContact extends JFrame  {
	
	JLabel listTitle = new JLabel(" View Contact");
	
	
	JTextField fNameBar =new JTextField(22);
	JTextField lNameBar =new JTextField(22);
	JTextField cityBar =new JTextField(26);
	
	JLabel titleCard = new JLabel("Gestion des Contacts");
	
	DefaultTableModel numTableModel = new DefaultTableModel();
	
	//JList<Contact> contactJlist = new JList<Contact>(Contact.getContactList());// use default model list
	JTable numTable = new JTable(numTableModel);
	JPanel grpCheck = new JPanel();
	
	ViewContact(Contact p){
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
	fNameBar.setText(p.getFirstName());
	infoInputPanel.add(bar1);
	bar2.add(new JLabel("Last Name"));
	bar2.add(lNameBar);
	lNameBar.setText(p.getLastName());
	infoInputPanel.add(bar2);
	bar3.add(new JLabel("City"));
	bar3.add(cityBar);
	cityBar.setText(p.getCity());
	infoInputPanel.add(bar3);
	
	//fNameBar.setEnabled(false);
	//lNameBar.setEnabled(false);
	//cityBar.setEnabled(false);
	fNameBar.setEditable(false);
	lNameBar.setEditable(false);
	cityBar.setEditable(false);
	
	
	
	//fNameBar.getDocument().addDocumentListener(this);// add the class as listener
	
	//lNameBar.getDocument().addDocumentListener(this);// add the class as listener
	
	//cityBar.getDocument().addDocumentListener(this);// add the class as listener
	
	
	JPanel actionBtnPanel = new JPanel();
	actionBtnPanel.setLayout(new FlowLayout());
	
	


	
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
	createTable(p);
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
	createArrayListGroupChecks(grpCheck,p);
	
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
	
	numTable.setEnabled(false);
	}

	
	
	public void createTable(Contact p) {
		int j =0;
		for(int i=0; i<p.getPhoneNumberList().size(); i++) {
			String[] rowList = new String[2];
			String e= p.getPhoneNumberList().get(i).split(" ",2)[0];
			String q =p.getPhoneNumberList().get(i).split(" ",2)[1];
			rowList[0]=e;
			rowList[1]=q;
			numTableModel.insertRow(i, rowList);
			j=i;
		}
		for(int k=j; k<8-(p.getPhoneNumberList().size()); k++){
		
			numTableModel.insertRow(numTableModel.getRowCount(),new String[] {"",""});
		}
	}
	
	
	public void createArrayListGroupChecks(JPanel panel, Contact p){

		UIManager.put("CheckBox.disabledText", UIManager.get("CheckBox.foreground"));
		for(int i=0;i<Group.getGrpNamesList().size();i++) {
			//.isSelected();
			
			
			JCheckBox k = new JCheckBox(Group.getGrpNamesList().get(i),Group.checkContactInGrp(p, Group.getGrpList().get(i) ));
			
			panel.add(k);
			k.setEnabled(false);
			
		}
		
	}
	
	
	
	

	



	
    
	
	}