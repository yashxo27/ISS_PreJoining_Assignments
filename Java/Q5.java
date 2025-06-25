import Q5.*;											//imports Q5 package

public class Q5 implements Q5_FAQ{								//Question 5: inheritance, Overriding, Polymorphism, Abstraction, Encapsulation, Interfaces, Packages
	public void startMeeting(){
		System.out.println("Meeting has Started.");
}
	public void discussAgenda(){
		System.out.println("Discussing the Agenda.");
}

	public void endMeeting(){
		System.out.println("Meeting has Ended.");
}

	public void openForQuestions(){
		System.out.println("Members are open to the floor.");
}
	public void answerQuestions(){
		System.out.println("Members have answered the questions.");
}

	public static void main(String[] args){
		Q5 meet = new Q5();								//Implemntation of Interfaces
		meet.startMeeting();
		meet.discussAgenda();
		meet.openForQuestions();
		meet.answerQuestions();
		meet.endMeeting();

		Q5_Address a = new Q5_Address("Mumbai", "Maharashtra", "India"); 
		Q5_Address b = new Q5_Address("London", "Greater London", "England");
		Q5_Address c = new Q5_Address("New York City", "New York", "USA");

		Q5_Company intel = new Q5_Company("Intel",1800000,true,a);
		intel.showDetails();
		System.out.println(intel.getStatus());

		Q5_MNC google = new Q5_MNC("Google",5000000,true,c,102);
		google.showDetails();

		Q5_MNC facebook = new Q5_MNC("Facebook",3500000,false,b,20);
		facebook.showDetails(true);
		
		Q5_LLC amx = new Q5_LLC("AMEX",30000,false,a,1,35000000);
		amx.showDetails(true);

		Q5_LLP jnj = new Q5_LLP("Johnson & Johnson",250000,false,a,2);
		jnj.showDetails();
		jnj.setExtension(true);
		jnj.showDetails();
	}
}