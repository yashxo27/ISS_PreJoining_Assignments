import java.util.Arrays;

public class Q4{							//Question 4: Strings, Arrays
	public String reverse(String x){				//First 3 methods are reversing the parameter passed
		String reverse = "";
		for(int i = x.length()-1; i>=0;i--){
			char x_char = x.charAt(i);
			String x_string = Character.toString(x_char);
			reverse=reverse.concat(x_string);
		}
		return reverse;
	}

	public StringBuffer reverse(StringBuffer x){
		StringBuffer reverse = x.reverse();
		return reverse;
	}

	public int[] reverse(int[] x){
		int[] reverse = new int[x.length];
		for(int i = x.length-1; i>=0;i--){
			reverse[x.length-1-i]=x[i];
		}
		return reverse;
	}

	public void classStrings(String val){				//Next 3 methods are various class functions of Strings, StringBuffers and Arrays
		System.out.println("\n"+val.substring(5));
		System.out.println(val.substring(5,10));
		System.out.println(val.indexOf('a'));
		System.out.println(val.indexOf('a',10));
		System.out.println(val.toLowerCase());
		System.out.println(val.toLowerCase().equals(val.toUpperCase()));
		System.out.println(val.toLowerCase().equalsIgnoreCase(val.toUpperCase()));
		System.out.println(val.replace('a','@'));
		System.out.println(val.contains("ac")+"\n");
		for(char value: val.substring(0,5).toCharArray()){
			System.out.println(value);
		}
	}

	public void classArrays(int[] val){
		Arrays.sort(val);
		System.out.println("\n"+Arrays.toString(val));
		System.out.println(Arrays.binarySearch(val,4));
		System.out.println(Arrays.toString(Arrays.copyOf(val,15)));
		System.out.println(Arrays.compare(val,Arrays.copyOf(val,3)));
	}

	public void classStringBuffers(StringBuffer val){
		val.append(": original.");
		System.out.println("\n"+val.toString());
		System.out.println(val.length());
		System.out.println(val.capacity());
		System.out.println(val.charAt(5));
		val.delete(2,5);
		System.out.println(val);
		val.deleteCharAt(2);	
		System.out.println(val);
		val.insert(2,"|nooo|");	
		System.out.println(val);
		val.replace(2,3,"|yes|");
		System.out.println(val);	
	}

	public static void main(String[] args){
		String a = "Hi, I am Yashodhan";
		StringBuffer b =  new StringBuffer("I am 21 Years Old");
		int[] c = new int[]{41,22,44,2,26,78};

		System.out.println(a);
		System.out.println(b);
		System.out.println(Arrays.toString(c));

		Q4 obj = new Q4();
		obj.classStrings(a);
		obj.classStringBuffers(b);
		obj.classArrays(c);
	
		System.out.println("\n"+a+"\nReverse: "+obj.reverse(a));
		System.out.println("\n"+b+"\nReverse: "+obj.reverse(b));
		System.out.println("\n"+Arrays.toString(c)+"\nReverse: "+Arrays.toString(obj.reverse(c)));
	}
}