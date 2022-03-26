package code;
import java.util.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Contact {
	
	
	
public ArrayList<String>	getPhoneNumberList(){
	 ArrayList<String> pList = new  ArrayList<String>();
	
	 Integer contactIdI = contactId;
	   
	        for (String key: TelephoneList.keySet())
	        {
	            if (contactIdI.equals(TelephoneList.get(key))) {
	                pList.add(key);
	            }
	        }
	
		
		return pList;
		
	}
	
	public void removeNum(String s) {
		
		TelephoneList.remove(s);
		
	}
	
	
	class PhoneNum{

	
		private int regionCode;
		private int number;
		private String idNum;
		public int getRegionCode() {
			return regionCode;
		}
		public void setRegionCode(int regionCode) {
			this.regionCode = regionCode;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getIdNum() {
			return idNum;
		}
		public void setIdNum(String number) {
			this.idNum = number;
		}
		PhoneNum(String rCode, String num){
			
			regionCode= Integer.parseInt(rCode);
			number= Integer.parseInt(num);
			if (regionCode<10)
			idNum= "0"+rCode+" "+num;
			else idNum= ""+rCode+" "+num;
		}
	}
	
//private static ArrayList<Contact> ContactList = new ArrayList<Contact>();
private static DefaultListModel<Contact> ContactList = new DefaultListModel<Contact>();
	
private static HashMap<String,Integer> TelephoneList = new HashMap<String,Integer>(); //hashmap<key: phone number, value: contact id>
private static int sequenceNum =0; 
private int contactId;
private String firstName;
private String lastName;
private String city;

public String toString() {
	if(city.equals("")==true)return firstName+" "+lastName;
	return firstName+" "+lastName+"-"+city;
}
//******** getters and setters:

public static DefaultListModel<Contact> getContactList() {
	return ContactList;
}
public static void setContactList(DefaultListModel<Contact> contactList) {//do remove and add function to the default list model
	ContactList = contactList;
}
public static HashMap<String,Integer> getTelephoneList() {
	return TelephoneList;
}
public static void setTelephoneList(HashMap<String,Integer> telephoneList) {
	TelephoneList = telephoneList;
}
public static int getSequenceNum() {
	return sequenceNum;
}
public static void setSequenceNum(int sequenceNum) {
	Contact.sequenceNum = sequenceNum;
}
public int getContactId() {
	return contactId;
}
public void setContactId(int contactId) {
	this.contactId = contactId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}





Contact(String fname, String lname, String ville, String rgcode, String num){//constructor
	contactId= sequenceNum++;//generate contact id 
	firstName=fname; lastName=lname; city=ville;
	
	  //to put condition if object not already in tel list
	if(ContactList.contains(this)==false) {addToList(this);
	System.out.println("added names");
	if (numberNotExists(contactId, rgcode, num)==true) {
		System.out.println("added number");
			Contact.sortContactListbyName();	
			}
	else return;
	
}
}


public void addNumber(int id, String rCode, String num) {
	/*PhoneNum addedNum = new PhoneNum(rCode, num);
	if(getTelephoneList().containsKey(addedNum.getIdNum())==false) {
	getTelephoneList().put(addedNum.getIdNum(), id);
	System.out.println("added ");
	}else {return;}
	*/
if( numberNotExists(id, rCode, num)==true) System.out.println("added "+id);
System.out.println("not added ");
}




public boolean numberNotExists(int id, String rCode, String num) {
	

	PhoneNum addedNum = new PhoneNum(rCode, num);
	if(getTelephoneList().containsKey(addedNum.getIdNum())==false) {
	getTelephoneList().put(addedNum.getIdNum(), id);
	System.out.println("added "+addedNum.getIdNum());
	return true;
	}else  {
		return false;
	}
	
	//need to put rcode and num as string and use it as key , or id for number
	//System.out.println("already exist");
	//else {getTelephoneList().put(addedNum, 0);}
	
}
public void addToList(Contact c) {// use the add to default list model
	ContactList.addElement(c);
}
public void removeFromList(Contact c) {
	ContactList.removeElement(c);
}

public static void sortContactListbyName() {
	Contact temp;
	//Contact temp2;
	int n = ContactList.size();
	System.out.println(n);
	for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j <n; j++) {
            if (ContactList.getElementAt(i).getFirstName().compareToIgnoreCase(ContactList.getElementAt(j).getFirstName())>0)       //&&j+1>i
            {
                
                temp = ContactList.getElementAt(i);
               // temp2=ContactList.getElementAt(j);
                ContactList.setElementAt(ContactList.getElementAt(j),i); 
                ContactList.setElementAt(temp,j);
               
            } }	}}

public static void sortContactListbyLastName() {
	Contact temp;
	//Contact temp2;
	int n = ContactList.size();
	System.out.println(n);
	for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j <n; j++) {
            if (ContactList.getElementAt(i).getLastName().compareToIgnoreCase(ContactList.getElementAt(j).getLastName())>0)       //&&j+1>i
            {
                
                temp = ContactList.getElementAt(i);
               // temp2=ContactList.getElementAt(j);
                ContactList.setElementAt(ContactList.getElementAt(j),i); 
                ContactList.setElementAt(temp,j);
               
            }
       }
	}
}


public static void sortContactListbyCity() {
	Contact temp;
	//Contact temp2;
	int n = ContactList.size();
	System.out.println(n);
	for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j <n; j++) {
            if (ContactList.getElementAt(i).getCity().compareToIgnoreCase(ContactList.getElementAt(j).getCity())>0)       //&&j+1>i
            {
                
                temp = ContactList.getElementAt(i);
               // temp2=ContactList.getElementAt(j);
                ContactList.setElementAt(ContactList.getElementAt(j),i); 
                ContactList.setElementAt(temp,j);
               
            } }	}}
static DefaultListModel<Contact> copyList = new DefaultListModel<Contact>();

static void searchListAdd(String s) {
	
	
//	for(int j=0;j<ContactList.getSize()-1;j++) {
	for(int i=0;i<ContactList.getSize();i++) {
		boolean startsWith = ContactList.getElementAt(i).toString().toLowerCase().startsWith(s.toLowerCase());
	//	for(int j=0;)
		if(startsWith==false) {
			//System.out.println(ContactList.getElementAt(i)+"false");
			Contact.copyList.addElement(ContactList.getElementAt(i));
		ContactList.removeElement(ContactList.getElementAt(i));
		searchListAdd(s);
		}if(startsWith==true) {
			//System.out.println(ContactList.getElementAt(i)+"true");
			//if(ContactList.contains(ContactList.getElementAt(i))==false) {
				
			//System.out.println("bringing back elements");
			//}
		}
	//}
		
	}
	
		
		
}
static void searchListRemove(String s) {
	for(int i=0;i<copyList.getSize();i++) {
		boolean startsWithInCopied = copyList.getElementAt(i).toString().toLowerCase().startsWith(s.toLowerCase());
		if(startsWithInCopied ==false) {
			System.out.println("not found in copy");
		}if(startsWithInCopied ==true) {
			ContactList.addElement(Contact.copyList.getElementAt(i));
			copyList.removeElement(Contact.copyList.getElementAt(i));
			Contact.sortContactListbyName();
			searchListRemove(s);
			
		}
	}
}




//******************
/*static void searchListRemove(String s) {
	
/*	
//	for(int j=0;j<ContactList.getSize()-1;j++) {
	for(int i=0;i<ContactList.getSize();i++) {
		boolean startsWith = ContactList.getElementAt(i).toString().toLowerCase().startsWith(s.toLowerCase());
		boolean startsWithInCopy = Contact.copyList.getElementAt(i).toString().toLowerCase().startsWith(s) ;
		//	for(int j=0;)
		if(startsWith==false || startsWithInCopy == false) {
			//System.out.println(ContactList.getElementAt(i)+"false");
			Contact.copyList.addElement(ContactList.getElementAt(i));
			//ContactList.addElement(Contact.copyList.getElementAt(i));
			//Contact.sortContactListbyName();
	//	ContactList.removeElement(ContactList.getElementAt(i));
		//searchListRemove(s);
		}if(startsWith==false || startsWithInCopy == true) {
			//System.out.println(ContactList.getElementAt(i)+"true");
			//if(ContactList.contains(ContactList.getElementAt(i))==false) {
				
			//System.out.println("bringing back elements");
			//}
			Contact copiedElement = null ;
		//	for(int k=0; k<Contact.copyList.getSize();k++) {
			//	if(Contact.copyList.getElementAt(k).toString().toLowerCase().startsWith(s)==true)
				copiedElement=Contact.copyList.getElementAt(i);
				ContactList.addElement(copiedElement);
				Contact.copyList.removeElement(copiedElement);
				//Contact.sortContactListbyName();
				//}
			//searchListRemove(s);
		}
	//}
	}	
}
*/





//end of class___________________________________________________
}




