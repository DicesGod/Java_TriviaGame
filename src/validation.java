import java.util.ArrayList;
import java.util.Scanner;

public class validation {
		
		int startint;
	
public int checkInt(String start,ArrayList<String> categories)
	{
		Scanner sc = new Scanner(System.in);
		Scanner check = new Scanner(start);
		
		while ((check.hasNextInt() == false || (Integer.parseInt(start) > categories.size() || Integer.parseInt(start) <= 0)) && start.equals("111") == false)  {
			System.out.println("PLEASE ENTER A VALID OPTION (NUMBER FROM 1 TO " +categories.size()+") :");
			start = sc.nextLine();
			check = new Scanner(start);
		}	
		check.close();
		
		return Integer.parseInt(start);
		
		
	}

public int checkIntadmin(String start,ArrayList<String> categories)
{
	Scanner sc = new Scanner(System.in);
	Scanner check = new Scanner(start);
	
	while ((check.hasNextInt() == false || (Integer.parseInt(start) > categories.size() || Integer.parseInt(start) <= 0)))  {
		System.out.println("PLEASE ENTER A VALID OPTION (NUMBER FROM 1 TO " +categories.size()+") :");
		start = sc.nextLine();
		check = new Scanner(start);
	}	
	check.close();
	
	return Integer.parseInt(start);
	
	
}


public int checkintadminquestion(String start,ArrayList<String> questions)
{
	Scanner sc = new Scanner(System.in);
	Scanner check = new Scanner(start);
	
	while ((check.hasNextInt() == false || (Integer.parseInt(start) > questions.size() || Integer.parseInt(start) <= 0))) {
		System.out.println("Please enter a valid option (Number from 1 to " +questions.size()+") :");
		start = sc.nextLine();
		check = new Scanner(start);
	}
	
	check.close();
	
	return Integer.parseInt(start);
	
	
}

public int checkintadminmenu(String start)
{
	Scanner sc = new Scanner(System.in);
	Scanner check = new Scanner(start);
	
	while (check.hasNextInt() == false || (Integer.parseInt(start) > 4 || Integer.parseInt(start) <= 0)) {
		System.out.println("Please enter a valid option (Number from 1 to 4)");
		start = sc.nextLine();
		check = new Scanner(start);
	}	
	check.close();
	
	return Integer.parseInt(start);
}
	
}
