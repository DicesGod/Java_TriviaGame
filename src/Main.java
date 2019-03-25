import java.util.Scanner;
import java.util.ArrayList;



public class Main {
	 
	static int startint;
	static ArrayList<String> categories = new ArrayList<String>();
	static ArrayList<String> statistics = new ArrayList<String>();
		
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<String> answers = new ArrayList<String>();
		ArrayList<String> rightanswer = new ArrayList<String>();
		String start;
		int mainmenuoption = 0;
		int adminmenuoption = 0;
		menu menu = new menu();	// initial menu object
		adminmenu adminmenu = new adminmenu();
		categories = menu.getCategories(categories);	
	do {			
		System.out.println("\nTo start Trivia app. - enter one option (or 111 to manage it):");
	
		menu.getMenu(categories); 
		validation val = new validation();
		
		start = sc.nextLine();
		//check inputed value is int or not
		startint = val.checkInt(start,categories);
		if (startint == categories.size()) {
			System.out.println("Are you sure you want to quit? Enter 0 to confirm, or other value to continue. ");
			String op = sc.nextLine();
			if(op.equals("0") == false) {
				System.out.println("You just decided to continue! ");
				mainmenuoption = 99;
				
			}
			else {
				System.out.println("Thanks!Have a good day!");	
				data cal = new data();
				cal.displayStatistic(statistics);
				sc.close();
				mainmenuoption = 0;
			}
			
		}
		
		else if (startint == 111)
		{
				
				int adminselection = adminmenu.getAdminselection(mainmenuoption);	
				if (adminselection == 99)
				{
					mainmenuoption = 99;
				}
				else {
			do {
				mainmenuoption = 0;
				adminmenuoption = 0;
				questions.clear();
				answers.clear();
				rightanswer.clear();
				adminmenu.displayadminmenu();
				start = sc.nextLine();
				startint = val.checkintadminmenu(start); 
			
				switch(startint) 
					{
					case 1 : {	
							adminmenu.addnew(categories);
							adminmenuoption = 88;
							 }
					break;
					case 2 : {	
							adminmenu.getQuestionandanswer(adminselection,questions,answers,rightanswer);	
							System.out.println("Please select a question to modify:");
							Scanner sc2 = new Scanner(System.in);
							String questionselection = sc2.nextLine();
							int questionselectionint = val.checkintadminquestion(questionselection,questions);
							adminmenu.modify(questionselectionint,questions,answers,rightanswer);
							adminmenuoption = 88;
							}
							break;
					case 3 : {	
							adminmenu.getQuestionandanswer(adminselection,questions,answers,rightanswer);	
							System.out.println("Please select a question to delete:");
							Scanner sc3 = new Scanner(System.in);
							String questionselection = sc3.nextLine();
							int questionselectionint = val.checkintadminquestion(questionselection,questions);
							adminmenu.delete(questionselectionint,adminselection,categories,questions,answers,rightanswer);
							adminmenuoption = 88;
							}
							break;
					case 4 : {	
							System.out.println("Are you sure you want to back to the application? Enter 0 to confirm, or other value to continue. ");
							String op = sc.nextLine();
							if(op.equals("0") == false) {
								System.out.println("You just decided to continue! ");
								adminmenuoption = 88;
							}
						}
				
					}
			}	
			while (adminmenuoption !=0);
			mainmenuoption = 99;
		}
		}
		
		
		else 
		{
		data cal = new data();// create object calculateddata	

		cal.readfile(startint,categories);
    	cal.displayandsaveusersanswer();	
    	statistics = cal.calculaterightanswers(startint,categories);
    	
    	categories.remove(startint-1);

    	mainmenuoption = 99;
		}
		
		        	
	}
	while(mainmenuoption != 0);
	
}

}
	

