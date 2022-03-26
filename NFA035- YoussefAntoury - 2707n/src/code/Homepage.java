package code;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Homepage extends JFrame implements ActionListener{
	
	JButton contactBtn = new JButton("Contacts");
	JButton groupBtn = new JButton("Groups");
	JLabel titleCard = new JLabel("Gestion des Contacts");
	
	Homepage( ){
	setSize (500, 650);
	setTitle("Projet NFA035");
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Container cp = getContentPane();
	cp.setBackground (Color.cyan);
	cp.setLayout (new BorderLayout());
	setVisible(true);
	JPanel contactBtnPanel =new JPanel();
	JPanel titlePanel =new JPanel();
	titlePanel.setLayout(new FlowLayout());
	titlePanel.setSize(500,70);
	contactBtnPanel.setLayout(new BoxLayout(contactBtnPanel, BoxLayout.Y_AXIS));
	//contactBtnPanel.setSize(120,650);
	contactBtn.setMaximumSize(new Dimension(100, 30));
	contactBtn.addActionListener(this);
	contactBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	groupBtn.setMaximumSize(new Dimension(100, 30));
	groupBtn.addActionListener(this);
	groupBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(120,30)));
	contactBtnPanel.add(contactBtn);
	contactBtnPanel.add(Box.createRigidArea(new Dimension(120,30)));
	contactBtnPanel.add(groupBtn);
	titlePanel.add(titleCard);
	cp.add(contactBtnPanel,BorderLayout.WEST);
	titleCard.setFont(new Font("Sans Serif",Font.BOLD,14));
	cp.add(titlePanel,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object pressedObj = event.getSource();
	if(pressedObj==contactBtn) {
		ContactFrame contactsWindow = new ContactFrame();
		}
	if(pressedObj==groupBtn) {
		GroupFrame grpF = new GroupFrame();
	}

	
	}
}
