package Q5;

public class Q5_LLP extends Q5_Partnership{							//LLP is used to implement abstract class of Partneship	
	private int currentPartners;

	private boolean extension;							//extension is Write-Only Encapsulated
	public void setExtension(boolean ext){						//setExtension method is used to Write whether an extension to showDetails is required
		this.extension=ext;
	}

	public Q5_LLP(String name, int num, Boolean growth, Q5_Address add, int parts){
		super(name, num, growth, add);
		this.currentPartners=parts;	
	}

	public void invest(){
		if(growth==false||currentPartners<=4){System.out.println("This LLP should look for more Shareholder Investors");}
		else{System.out.println("This LLP should look for more Shareholder Investors");}
	}
	
	public void showDetails(){
		System.out.println("\n"+cName+" is a company in "+cAddress.city+", "+cAddress.state+" with an employee size of "+employeeNumber+".");
		if(extension){
			System.out.println("It currently has "+currentPartners+" different shareholders");
			invest();
		}
	}
}