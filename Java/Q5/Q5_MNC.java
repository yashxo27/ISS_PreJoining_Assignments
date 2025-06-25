package Q5;

public class Q5_MNC extends Q5_Company{						//MNC IS-A Company showcasing Inheritance properties
	int countriesPresent;

	public Q5_MNC(String name, int num, Boolean growth, Q5_Address add, int countries){
		super(name, num, growth, add);
		this.countriesPresent=countries;		
	}

	public void expansion(){
		if(growth==false||countriesPresent<=20){System.out.println("This MNC should expand");}
		else{System.out.println("This MNC should not expand");}
	}
	
	public void showDetails(){
		super.showDetails();
	}

	public void showDetails(boolean extension){					//Method Overloading showcasing Compile-Time Polymorphism
		super.showDetails();
		if(extension){
			System.out.println("It is present in "+countriesPresent+" different countries");
			expansion();
		}
	}
}
