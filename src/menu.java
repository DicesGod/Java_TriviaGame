import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class menu {
	Scanner sc = new Scanner(System.in);
	
private void setCreatecategories(ArrayList<String> categories)
	{
		
		BufferedReader reader = null;
		ArrayList<String> alltext = new ArrayList<String>();
		HashSet<String> duplicatedstring = new HashSet<>();
		ArrayList<String> tempcategory = new ArrayList<String>();
		
		try {
		   File file = new File("/Users/minhle/eclipse-workspace/TriviaApplicationGame/bin/triviagames.txt"); 
		   reader = new BufferedReader(new FileReader(file));
		   
		   String line;
	    	
		   while ((line = reader.readLine()) != null) {	    	
			   
			   alltext = new ArrayList(Arrays.asList(line.split(",")));
			   tempcategory.add(alltext.get(0));
		    }	
		   
		  
		   for (String item : tempcategory) {

	            // If String is not in set, add it to the list and the set.
	            if (!duplicatedstring.contains(item)) {
	            	categories.add(item);
	                duplicatedstring.add(item);
	            }
	        }
	    	
	   	} 
		    
		catch (IOException e) 
		{
			e.printStackTrace();
		} 		
			
		categories.add("Exit this section with confirmation");
		
		
	}	

	
public void getMenu(ArrayList<String> categories) {	
	for (int i=0; i<categories.size() ;i++)
	{	  
		System.out.println(+(i+1)+". "+categories.get(i).toUpperCase());
	}
	
	System.out.println("\nPlease enter your choice: ");
		
}


public ArrayList<String> getCategories(ArrayList<String> categories)
{
	setCreatecategories(categories);
	return categories;
}

}