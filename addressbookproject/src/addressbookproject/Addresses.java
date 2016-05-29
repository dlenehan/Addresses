package addressbookproject;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


public class Addresses {
	
	HashMap<Integer, Contact> addresses;
	Contact contact;
	private String path;
	

	
	public Addresses(String filename){
		path = filename;

		try{

			Readfile rf  = new Readfile(path);
			addresses = rf.getAddresses();
			
			
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	public void deleteAddress(String contct_id){
		for (int key: addresses.keySet()){
			if (addresses.get(key).getContact_id().equals(contct_id)){
				System.out.println("found it!!");
				addresses.remove(key);
			}
		}
	}



	public void saveAddress(Integer namekey,Contact contact){

		addresses.put(namekey, contact);
		System.out.println("saved address");
	}

	
	
		
	public int getMaxKey() {
		 int max_key = 0;
		 int contct_id;
		                for (int key: addresses.keySet()){
		                      contct_id = Integer.parseInt(addresses.get(key).getContact_id());
		                         if (contct_id > max_key){
		                             max_key = contct_id;
		                        }
		                }
		                System.out.println("Max key: " + max_key);
		        return max_key;
		        
		        }


	public void listAll(){
		Collection<Contact> contacts = addresses.values();
		System.out.println("addresses values   " + addresses.values());
		List<Contact> list = new ArrayList<>(contacts);
		Collections.sort(list, new MyComparator());

		System.out.println("***Sorted List ***");

		for (Iterator<Contact> it = list.iterator(); it.hasNext();) {
			Contact cntct = (Contact) it.next();
			System.out.println(cntct.getContact_id() + "." +
					cntct.getFirstname() + " " +
					cntct.getSurname() + "," +
					cntct.getAddress_line_1() + "," +
					cntct.getAddress_line_2() + "," +
					cntct.getAddress_line_3() + "," +
					cntct.getMobile() + ".") ;
		}


	
	}


	public void saveUpdates(String filename){
		Readfile wr = new Readfile(filename);
	
		wr.writeCsvFile(filename,addresses);

		
	}


}
