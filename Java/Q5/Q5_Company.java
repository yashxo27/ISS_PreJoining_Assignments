package Q5;

public class Q5_Company{
	public String cName;
	protected int employeeNumber;
	protected boolean growth;
	Q5_Address cAddress;								//Company HAS-A Address showcasing Aggregation properties

	private String status="Open";							//Status is Read-Only Encapsulated
	public String getStatus(){							//getStatus method is used to Read status of the Company
		return status;
	}

	public Q5_Company(String name, int num, Boolean growth, Q5_Address add){
		this.cName = name;
		this.employeeNumber = num;
		this.growth = growth;
		this.cAddress=add;
	}

	public void finances(){
		if(growth){System.out.println("This company is doing good financially");}
		else{System.out.println("This company is doing bad financially");}
	}

	public void showDetails(){
		System.out.println("\n"+cName+" is a company in "+cAddress.city+", "+cAddress.state+" with an employee size of "+employeeNumber+".");
		finances();
	}
}