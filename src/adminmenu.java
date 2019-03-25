import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class adminmenu {
	
	 static ArrayList<String> categories = new ArrayList<String>();
	 File filename = new File("/Users/minhle/eclipse-workspace/TriviaApplicationGame/bin/triviagames.txt");
	 BufferedWriter writer;
	 FileWriter filewriter;
	 BufferedReader reader;

	Scanner sc = new Scanner(System.in);
	int adminselection;
	
public int getAdminselection(int mainmenuoption)
	{
		int run = 0;
		do {
			run = 0;
		categories.clear();
		System.out.println("\nEnter one option to manage a Trivia app. category(Admin site):");
		menu menu = new menu();
		menu.getCategories(categories);	
		menu.getMenu(categories);
		String adminselectionstring = sc.nextLine();
		
		
		validation val = new validation();
		
		adminselection = val.checkIntadmin(adminselectionstring,categories);
		
		if (adminselection == categories.size())
		{
			System.out.println("Are you sure you want to back to the application? Enter 0 to confirm, or other value to continue. ");
			String op = sc.nextLine();
			if(op.equals("0") == false) {
				System.out.println("You just decided to continue! ");
				run = 77;
				
			}
			else {
				mainmenuoption = 99;
			return	mainmenuoption;	 
			};
		}
		
	}
		while (run != 0);
		
		return adminselection;
	}

public void displayadminmenu(){
	System.out.println("1. Add new question and answers for the "+ this.categories.get(adminselection-1));
	System.out.println("2. Modify question and answers for the " + this.categories.get(adminselection-1));
	System.out.println("3. Delete question and answers for the "+this.categories.get(adminselection-1));
	System.out.println("4. Exit this section with confirmation");
	System.out.println("\nPlease enter your choice:");
	}
	
public void addnew(ArrayList<String> categories){
		   String selection = this.categories.get(adminselection-1);
		   String newquestion;
		   writer = null;
		   filewriter = null;
		   
		   try {
			   	filewriter = new FileWriter(filename.getAbsoluteFile(),true);
				writer = new BufferedWriter(filewriter);
				
				System.out.println("Please enter your question:");
				String tempnewquestion= "\n"+selection+","+sc.nextLine();
				while (tempnewquestion.equals("\n"+selection+","))
				{
					System.out.println("QUESTION FIELD MUST NOT BE NULL! Please enter your question:");
					tempnewquestion= "\n"+selection+","+sc.nextLine();
				}
				newquestion = tempnewquestion;
				
				System.out.println("Please enter the first option:");
				tempnewquestion = newquestion+",A: "+sc.nextLine();
				while (tempnewquestion.equals(newquestion+",A: "))
				{
					System.out.println("ANSWERS FIELD MUST NOT BE NULL! Please enter the first option:");
					tempnewquestion = newquestion+",A: "+sc.nextLine();
				}
				newquestion = tempnewquestion;
				
				System.out.println("Please enter the second option:");
				tempnewquestion = newquestion+" B: "+sc.nextLine();
				while (tempnewquestion.equals(newquestion+" B: "))
				{
					System.out.println("ANSWERS FIELD MUST NOT BE NULL! Please enter the second option:");
					tempnewquestion = newquestion+" B: "+sc.nextLine();
				}
				newquestion = tempnewquestion;
				
				System.out.println("Please enter the third option:");
				tempnewquestion = newquestion+" C: "+sc.nextLine();
				while (tempnewquestion.equals(newquestion+" C: "))
				{
					System.out.println("ANSWERS FIELD MUST NOT BE NULL! Please enter the third option:");
					tempnewquestion = newquestion+" C: "+sc.nextLine();
				}
				newquestion = tempnewquestion;
				
				System.out.println("Please enter the forth option:");
				tempnewquestion = newquestion+" D: "+sc.nextLine();
				while (tempnewquestion.equals(newquestion+" D: "))
				{
					System.out.println("ANSWERS FIELD MUST NOT BE NULL! Please enter the forth option:");
					tempnewquestion = newquestion+" D: "+sc.nextLine();
				}
				newquestion = tempnewquestion;

				System.out.println("Please enter the right answer (simply a,b,c or d):");
				tempnewquestion = newquestion+","+sc.nextLine();
				while (tempnewquestion.equals(newquestion+",") || (tempnewquestion.equals(newquestion+",a") == false && tempnewquestion.equals(newquestion+",b") == false && tempnewquestion.equals(newquestion+",c") == false && tempnewquestion.equals(newquestion+",d") == false))
				{
					System.out.println("RIGHT ANSWERS FIELD MUST NOT BE NULL! Please enter the right answer of the question (simply a,b,c or d):");
					tempnewquestion = newquestion+","+sc.nextLine();
				}
				newquestion = tempnewquestion;
				writer.write(newquestion);
			    writer.close();
			    System.out.println("NEW QUESTION HAS BEEN ADDED SUCCESSFULLY!");
	        }
	        catch(IOException ex) {
	            
	             ex.printStackTrace();
	        }	   
	}
	
private void setQuestionandanswer(int startint, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> rightanswer)
	{
		data data = new data();
		data.readfile(startint, questions, answers, rightanswer);
		for (int i=0; i<questions.size() ;i++)
		{
			
			System.out.println(+(i+1)+". "+questions.get(i));	
			System.out.println(answers.get(i));
			System.out.println("Right answer is: "+rightanswer.get(i)+"\n");
		}
	}	

public void getQuestionandanswer(int startint, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> rightanswer)
{
	setQuestionandanswer(startint, questions, answers, rightanswer);
}




public void modify(int questionselection, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> rightanswer){
		Scanner sc2 = new Scanner(System.in);
 
	 try {
         
		   	filewriter = new FileWriter(filename.getAbsoluteFile(),true);
		   	String oldcontent = "";
		   	String newcontent = "";
		   	String oldstring = "";
			String newstring = "";
			
			oldstring = questions.get(questionselection-1)+","+answers.get(questionselection-1)+","+rightanswer.get(questionselection-1);
			
			System.out.println("Please modify the question or press enter to skip: "+questions.get(questionselection-1));
			newstring = sc2.nextLine();
			if(newstring.equals(""))
			{
				newstring = questions.get(questionselection-1);
			}
	
			System.out.println("Please modify the answer or press enter to skip: "+answers.get(questionselection-1));
			String tempnewstring = newstring+","+sc2.nextLine(); 
			if(tempnewstring.equals(newstring+","))
			{
				newstring = newstring+","+answers.get(questionselection-1);
			}
			else
			{
				newstring = tempnewstring;
			}
			
			System.out.println("Please modify the right answers or press enter to skip: "+rightanswer.get(questionselection-1));
			tempnewstring = newstring+","+sc2.nextLine();
			while (tempnewstring.equals(newstring+",") == false && tempnewstring.equals(newstring+",a") == false && tempnewstring.equals(newstring+",b") == false && tempnewstring.equals(newstring+",c") == false && tempnewstring.equals(newstring+",d") == false)
			{
				System.out.println("RIGHT ANSWERS FIELD MUST NOT BE NULL OR INVALID! Please enter the right answer of the question (simply a,b,c or d):");
				tempnewstring = newstring+","+sc.nextLine();
			}
			
			if(tempnewstring.equals(newstring+","))
			{
				newstring = newstring+","+rightanswer.get(questionselection-1);
			}
			else
			{
				newstring = tempnewstring;
			}
			
			reader = new BufferedReader(new FileReader(filename));
			
			String currentline = reader.readLine();

			while (currentline != null) 
			{
					oldcontent = oldcontent + currentline + System.lineSeparator();
					currentline = reader.readLine();
			}
			newcontent = oldcontent.replace(oldstring,newstring);
			newcontent = newcontent.replaceAll("(?m)^[ \t]*\r?\n", "");
			writer = new BufferedWriter(new FileWriter(filename));
			writer.write(newcontent.trim());
			System.out.println("THE SELECTED QUESTION HAS BEEN UPDATED SUCCESSFULLY!");
			
			writer.close();
     }
     catch(IOException ex) {
         
          ex.printStackTrace();
     }	   
}	


public void delete(int questionselection,int adminselection,ArrayList<String> categories,ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> rightanswer){

 try {
     
	    filewriter = new FileWriter(filename.getAbsoluteFile(),true);
	   	String oldcontent = "";
	   	String newcontent = "";
	   	String oldstring = "";
		String newstring = "";
		
		menu menu = new menu();	// initial menu object
		menu.getCategories(adminmenu.categories);	
		oldstring = adminmenu.categories.get(adminselection-1)+","+questions.get(questionselection-1)+","+answers.get(questionselection-1)+","+rightanswer.get(questionselection-1);
		reader = new BufferedReader(new FileReader(filename));
		
		String currentline = reader.readLine();

		while (currentline != null) 
		{
				oldcontent = oldcontent + currentline + System.lineSeparator();
				currentline = reader.readLine();
		}
		newcontent = oldcontent.replace(oldstring,newstring);
		newcontent = newcontent.replaceAll("(?m)^[ \t]*\r?\n", "");
		
		
		
		writer = new BufferedWriter(new FileWriter(filename));
		writer.write(newcontent.trim());
		
		System.out.println("THE SELECTED QUESTION HAS BEEN DELETED!");
		writer.close();
 }
 	catch(IOException ex) {
     
      ex.printStackTrace();
 	}	   
	
}

}