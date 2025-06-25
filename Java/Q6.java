public class Q6{
	public static void main(String[] args){
		Q6_ApplicationForm form = new Q6_ApplicationForm();
		try{
			form.setName("Yashodhan","S","Sharma");
			System.out.println("Welcome "+form.firstName+" "+form.middleName+". "+form.lastName);
		}
		catch(Q6_IllegalNameException ine){
		}
		finally{
			try{
				form.setAge(17);
				System.out.println("Age is "+form.age);
			}
			catch(Q6_IllegalAgeException iae){
			}
		}
	}
}

class Q6_ApplicationForm{
	String firstName, middleName, lastName;
	int age;
	
	public void setName(String fname, String mname, String lname) throws Q6_IllegalNameException{     //Using Method Signature for Checked Exception	
		if(mname.length()<2){
			this.middleName=mname;
		}
		else{
			throw new Q6_IllegalNameException(mname);
		}
		this.firstName=fname;
		this.lastName=lname;
	}

	public void setAge(int ageValue){
		if(ageValue>=18){
			this.age=ageValue;
		}
		else{
			throw new Q6_IllegalAgeException();						//Explicitly Calling Unchecked Exception
		}
	}	
}

class Q6_IllegalNameException extends Exception{								//Checked Userdefined Exception
	public Q6_IllegalNameException(String nameValue){
		System.out.println(nameValue+" is an invalid Middle Name");	
	}
}

class Q6_IllegalAgeException extends RuntimeException{							//Unchecked Userdefined Exception
	public Q6_IllegalAgeException(){
		System.out.println("You are underage");	
	}	
}