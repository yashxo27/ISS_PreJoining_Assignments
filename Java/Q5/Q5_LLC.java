package Q5;

public class Q5_LLC extends Q5_MNC{								//LLC IS-A MNC showcasing Multi-Level Inheritance properties
	int revenue;

	public Q5_LLC(String name, int num, Boolean growth, Q5_Address add, int countries, int rev){
		super(name, num, growth, add, countries);
		this.revenue=rev;		
	}

	public void layoff(){
		if(growth){System.out.println("This LLC should not have layoffs");}
		else{System.out.println("This MNC should layoff "+(int)(employeeNumber*0.3)+" employees");}
	}
	
	public void showDetails(){
		super.showDetails();
	}
	
	@Override
	public void showDetails(boolean extension){					//Method Overriding showcasing Run-Time Polymorphism
		super.showDetails(extension);
		if(extension){
			System.out.println("It has a revenue of "+revenue);
			layoff();
		}
	}
}
