package code;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Group {
private String grpName;
private String grpDescription;
private ArrayList<Contact> grpContacts = new ArrayList<Contact>();
static private ArrayList<String> grpNamesList = new  ArrayList<String>();
static private ArrayList<Group> grpList = new  ArrayList<Group>();

Group(String grpn, String grpd){
	if(!grpNamesList.contains(grpn.toLowerCase())) {
		grpNamesList.add(grpn.toLowerCase());
		grpName=grpn; grpDescription = grpd;
		grpList.add(this);
	}
}



public static boolean checkContactInGrp(Contact con, Group grp ) {
	return grp.getGrpContacts().contains(con);
}


public void addContact(Contact c){
	if(grpContacts.contains(c)==false) {
	grpContacts.add(c);System.out.println("added to group");
	}
	
}

public void removeContact(Contact c){
	if(grpContacts.contains(c)==true) {
	grpContacts.remove(c);
	System.out.println("removed from group");
	}
}




public String getGrpName() {
	return grpName;
}

public void setGrpName(String grpName) {
	this.grpName = grpName;
}

public String getGrpDescription() {
	return grpDescription;
}

public void setGrpDescription(String grpDescription) {
	this.grpDescription = grpDescription;
}

public ArrayList<Contact> getGrpContacts() {
	return grpContacts;
}

public void setGrpContacts(ArrayList<Contact> grpContacts) {
	this.grpContacts = grpContacts;
}

public static ArrayList<String> getGrpNamesList() {
	return grpNamesList;
}

public static void setGrpNamesList(ArrayList<String> grpNamesList) {
	Group.grpNamesList = grpNamesList;
}

public static ArrayList<Group> getGrpList() {
	return grpList;
}

public static void setGrpList(ArrayList<Group> grpList) {
	Group.grpList = grpList;
}



}
