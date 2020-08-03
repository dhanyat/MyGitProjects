package Input;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptInput {

	public static void main (String [] args) throws IOException{
		Scanner userInput = new Scanner(System.in);
		System.out.println("Learning Java from?");
		String website = userInput.nextLine();
		System.out.println("Name");
		String website1 = userInput.nextLine();
		userInput.close();
		System.out.println("I am learning Java from "+ website);
		
		//Type 2
		
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Input your site name :");
		String mySite = myReader.readLine();
		System.out.println("Site name is : "+ mySite); 
	}
}
