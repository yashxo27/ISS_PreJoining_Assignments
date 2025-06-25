package Q5;

public abstract class Q5_Partnership extends Q5_Company{					//Partnership is an Abstract class inherting Company
		
	public Q5_Partnership(String name, int num, Boolean growth, Q5_Address add){
		super(name, num, growth, add);		
	}

	public abstract void invest();
	
	public abstract void showDetails();
}