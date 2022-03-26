package code;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class ContactFrame extends JFrame implements ActionListener , DocumentListener{
	
	JLabel listTitle = new JLabel(" Contacts");
	JButton sortFname = new JButton("Sort by first name");
	JButton sortLname = new JButton("Sort by last name");
	JButton sortCity = new JButton("Sort by City");
	JButton addNew = new JButton("Add new contact");
	JTextField searchBar =new JTextField(22);
	JLabel titleCard = new JLabel("Gestion des Contacts");
	
	JButton viewBtn = new JButton("View");
	JButton updateBtn = new JButton("Update");
	JButton deleteBtn = new JButton("Delete");
	
	JList<Contact> contactJlist = new JList<Contact>(Contact.getContactList());// use default model list
	
	
	ContactFrame(){
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
	
	JPanel searchbarPanel = new JPanel();
	searchbarPanel.setLayout(new FlowLayout());
	searchbarPanel.add(new JLabel("Search"));
	
	searchBar.getDocument().addDocumentListener(this);// add the class as listener
	searchbarPanel.add(searchBar);
	
	JPanel actionBtnPanel = new JPanel();
	actionBtnPanel.setLayout(new FlowLayout());
	actionBtnPanel.add(viewBtn);
	actionBtnPanel.add(updateBtn);
	actionBtnPanel.add(deleteBtn);
	
	deleteBtn.addActionListener(this);
	updateBtn.addActionListener(this);
	viewBtn.addActionListener(this);
	
	JPanel titlePanel =new JPanel();
	titlePanel.setLayout(new FlowLayout());
	titlePanel.setSize(500,70);
	titleCard.setFont(new Font("Sans Serif",Font.BOLD,14));
	titlePanel.add(titleCard);
	cp.add(titlePanel,BorderLayout.NORTH);
	
	contactBtnPanel.setLayout(new BoxLayout(contactBtnPanel, BoxLayout.Y_AXIS));
	
	listTitle.setMaximumSize(new Dimension(140, 15));
	listTitle.setFont(new Font("Sans Serif",Font.PLAIN,16));
	listTitle.setAlignmentX(CENTER_ALIGNMENT);
	
	sortFname.setMaximumSize(new Dimension(140, 30));
	sortFname.addActionListener(this);
	sortFname.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	sortLname.setMaximumSize(new Dimension(140, 30));
	sortLname.addActionListener(this);
	sortLname.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	sortCity.setMaximumSize(new Dimension(140, 30));
	sortCity.addActionListener(this);
	sortCity.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	addNew.setMaximumSize(new Dimension(140, 30));
	addNew.addActionListener(this);
	addNew.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	contactBtnPanel.add(Box.createRigidArea(new Dimension(148,30)));
	contactBtnPanel.add(listTitle);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(148,30)));
	contactBtnPanel.add(sortFname);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(148,30)));
	contactBtnPanel.add(sortLname);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(148,30)));
	contactBtnPanel.add(sortCity);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(148,30)));
	contactBtnPanel.add(addNew);
	
	cp.add(contactBtnPanel,BorderLayout.WEST);
	
	rightBorderPanel.add(searchbarPanel,BorderLayout.NORTH);
	rightBorderPanel.add(actionBtnPanel, BorderLayout.SOUTH);
	
	contactJlist.setVisibleRowCount(20);
	contactJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	JScrollPane listScroll = new JScrollPane(contactJlist);
	listScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	listScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	listScroll.setPreferredSize(new Dimension(200,400));
	
	JPanel listScrollPanel= new JPanel();
	listScrollPanel.setLayout(new FlowLayout());
	listScrollPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
	listScrollPanel.add(listScroll);	
	
	rightBorderPanel.add(listScrollPanel,BorderLayout.CENTER);
	
	//rightBorderPanel.add(contactJlist, BorderLayout.CENTER);
	cp.add(rightBorderPanel, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object pressedObj = event.getSource();
	if(pressedObj==sortFname) {Contact.sortContactListbyName();}
	if(pressedObj==sortLname) {Contact.sortContactListbyLastName();}
	if(pressedObj==sortCity){Contact.sortContactListbyCity();}
	if(pressedObj==addNew) {searchBar.setText("");new NewContact();}
	if(pressedObj==viewBtn) {searchBar.setText("");new ViewContact(contactJlist.getSelectedValue());}
	if(pressedObj==updateBtn) {searchBar.setText("");new EditContact(contactJlist.getSelectedValue());}
	if(pressedObj==deleteBtn) {
		//System.out.print("deleted"+contactJlist.getSelectedValue());
		
		for(int u=0;u<contactJlist.getSelectedValue().getPhoneNumberList().size();u++) {
			//contactJlist.getSelectedValue().getPhoneNumberList().get(u);
			contactJlist.getSelectedValue().removeNum(contactJlist.getSelectedValue().getPhoneNumberList().get(u));
			//contactJlist.getSelectedValue().getPhoneNumberList().remove(u);
		}
		Contact.getContactList().removeElement(contactJlist.getSelectedValue());
		
	}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println(searchBar.getText());
		String filter = searchBar.getText();
	    Contact.searchListAdd( filter);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(searchBar.getText()=="");//show all
		System.out.println(searchBar.getText());
		String filter = searchBar.getText();
		  Contact.searchListRemove( filter);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	
	}