package addressbookproject;

import java.io.IOException;
 		
public class AddressTry {


	public static void main (String[] args) throws IOException {

		
		
		
		String fileName = System.getProperty("user.home")+"/addresses.csv";
		
		
		
		ScreenReader scr = new ScreenReader();
		scr.readOptions(fileName);
		


	}	

}





