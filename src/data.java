import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays; 


public class data {
	 Scanner sc = new Scanner(System.in);
	 ArrayList<String> question = new ArrayList<String>();
	 ArrayList<String> answers = new ArrayList<String>();
	 ArrayList<String> rightanswer = new ArrayList<String>();
	 ArrayList<String> useranswer= new ArrayList<String>();
	 static ArrayList<String> categories = new ArrayList<String>();
	 static ArrayList<String> statistic = new ArrayList<String>();
	
public void readfile (int startint,ArrayList<String> q, ArrayList<String> a, ArrayList<String> r){
	
	BufferedReader reader = null;
	ArrayList<String> temporaryarray = new ArrayList<String>();
	try {
	   File file = new File("/Users/minhle/eclipse-workspace/TriviaApplicationGame/bin/triviagames.txt"); 
	   reader = new BufferedReader(new FileReader(file));
	   
	   menu menu = new menu();	// initial menu object
	   menu.getCategories(categories);	
	   String selection = categories.get(startint-1);
	   String line;
	   
    	
	   while ((line = reader.readLine()) != null) 
	   		{
		 temporaryarray = new ArrayList(Arrays.asList(line.split(",")));
	     if (line.startsWith(selection.toLowerCase())){
	    	q.add(temporaryarray.get(1));
	    	a.add(temporaryarray.get(2));
	    	r.add(temporaryarray.get(3));	
	    	}
		   		
	  		}
	  reader.close();
    	} 
	    
	    catch (IOException e) 
		{
	    e.printStackTrace();
	    } 		
	
		
		
}

public void readfile (int startint,ArrayList<String> categories){
	
	BufferedReader reader = null;
	ArrayList<String> temporaryarray = new ArrayList<String>();
	try {
	   File file = new File("/Users/minhle/eclipse-workspace/TriviaApplicationGame/bin/triviagames.txt"); 
	   reader = new BufferedReader(new FileReader(file));
	   
	   String selection = categories.get(startint-1);

	   
	   String line;
	   
    	
	   while ((line = reader.readLine()) != null) 
	   		{
		 temporaryarray = new ArrayList(Arrays.asList(line.split(",")));
	     if (line.startsWith(selection.toLowerCase())){
	    	question.add(temporaryarray.get(1));
	    	answers.add(temporaryarray.get(2));
	    	rightanswer.add(temporaryarray.get(3));	
	    	}
		   		
	  		}
	  reader.close();
    	} 
	    
	    catch (IOException e) 
		{
	    e.printStackTrace();
	    } 		
		
}
	 
public void displayandsaveusersanswer() 
	{		
		for (int i=0; i<question.size() ;i++)
		{
			
			System.out.println(+(i+1)+". "+question.get(i));	
			System.out.println(answers.get(i));
			System.out.println("\nPlease enter your answer: ");
			String answer = sc.nextLine();
					while (answer.equals("a") == false && answer.equals("b") == false && answer.equals("c") == false && answer.equals("d") == false) 
					{ 
						System.out.println("PLEASE ENTER A VALID ANSWER(A, B, C or D)!!!!\n");
						System.out.println(+(i+1)+". "+question.get(i));	
						System.out.println(answers.get(i));
						System.out.println("\nEnter your answer: ");
						answer = sc.nextLine();
					}
			useranswer.add(answer);	
			if (useranswer.get(i).equals(rightanswer.get(i)))
			{
			System.out.println("YOUR ANSWER FOR QUESTION "+(i+1)+" WAS RIGHT!");
			System.out.println("***************************************************************************************************************\n");
			}
			else
			{
			System.out.println("YOUR ANSWER FOR QUESTION "+(i+1)+" WAS WRONG!. THE RIGHT ANSWER IS "+rightanswer.get(i)+" INSTEAD OF "+useranswer.get(i));
			System.out.println("***************************************************************************************************************\n");
			}
		}	
			
			
			
	}
					
					
public ArrayList<String> calculaterightanswers(int startint, ArrayList<String> categories) 
	{	
		int countright = 0;
		int countwrong = 0; 
		int percentage = 0;
		for (int j=0; j<useranswer.size();j++)
		{
			if (useranswer.get(j).equals(rightanswer.get(j)))
				{
				countright++; 
				}
			else
			{
				countwrong++;
			}
				
		}
		percentage = countright*100/useranswer.size();
		System.out.println("Category "+categories.get(startint-1).toUpperCase()+": You've made "+countright+" right answers out of "+useranswer.size()+" questions! So the percentage of the right anwers is: " +percentage+"%");
		statistic.add("Category "+categories.get(startint-1).toUpperCase()+": You've made "+countright+" right answers out of "+useranswer.size()+" questions! So the percentage of the right anwers is: " +percentage+"%");
		return statistic;
		}

public void displayStatistic(ArrayList<String> statistic) 
{	
	for (int j=0; j<this.statistic.size();j++)
	{
		System.out.println(statistic.get(j));		
	}

	}

}			
		
		
		
			
		
		

		
	
