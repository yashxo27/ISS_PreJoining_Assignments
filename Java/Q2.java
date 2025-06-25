public class Q2{				//Question 2: Basic Data types, Variable types, Modifier types, Final Keywors and Constructors
	byte a = 100;				//Instance Variable
	short b = -265;
	protected int c = 35690;
	static Long d = 1000000L;		//Static Variable
	
	private String s1;			//Private Variable
	public String s2;
	public final String S3= "I'm Final";	//Final Variable
	
	Q2(String x){				//Constructor
		this.s2=x;
	}

	public void setString(String x){
		this.s1 = x;
	}

	public String getString(){
		return this.s1;
	}

	protected void printStrings(){		//Protected Method
		System.out.println("This is a Protected Class");
		System.out.println("This is a Public Variable: "+ s2);
		System.out.println("This is a Final Variable: "+S3);
	}

	
	public static void main(String []args){	//Public Method
		float e = 2.3f;			//Local Variable
		double f = -4.569;
		Boolean g = true;
		char h = 'Z';
		String i = "Hello";

		System.out.println("These were local variables:");
		System.out.println("Float Variable: "+e);
		System.out.println("Double Variable: "+f);
		System.out.println("Boolean Variable: "+g);
		System.out.println("Char Variable: "+h);	

		Q2 obj = new Q2("Public Variable");
		obj.setString(i);
		System.out.println("\n"+obj.getString());
		obj.printStrings();

		System.out.println("\nThese were instance variables:");
		System.out.println("Byte Variable: "+obj.a);
		System.out.println("Short Variable: "+obj.b);
		System.out.println("Integer Variable: "+obj.c);
		System.out.println("Long Variable: "+obj.d);			
	}
}