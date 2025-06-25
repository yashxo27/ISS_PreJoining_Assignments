import java.util.*;

public class Q7{
	public static void main(String[] args){
		Q7 obj=new Q7();
		obj.implementListOps();
		obj.implementSetOps("yashodhansharma");	
		obj.implementMapOps();	
	}

	public void implementListOps(){
		LinkedList<String> shoppingCart=new LinkedList<String>();
		System.out.println("Linked List of Primitives");
		shoppingCart.add("Milk");
		shoppingCart.add("Cheese");
		shoppingCart.addFirst("Bread");
		shoppingCart.addLast("Eggs");
		shoppingCart.add(3,"Spices");

		System.out.println("Before Modification");
		for(int i=0; i<shoppingCart.size();i++)
		{
			System.out.println("Element "+(i+1)+": "+shoppingCart.get(i));
		}

		System.out.println("After Modification");
		shoppingCart.set(2,"Cereal");
		shoppingCart.remove(4);
		Collections.sort(shoppingCart);
		for(int i=0; i<shoppingCart.size();i++)
		{
			System.out.println("Element "+(i+1)+": "+shoppingCart.get(i));
		}

		System.out.println("\nArray List of Custom Objects");
		ArrayList<Q7_Novel> novels=new ArrayList<Q7_Novel>();
		novels.add(new Q7_Novel("Harry Potter",56,400));
		novels.add(new Q7_Novel("Percy Jackson",43,350));
		novels.add(new Q7_Novel("Tin Tin",65,200));

		System.out.println("Before Sorting");
		for(int i=0; i<novels.size();i++)
		{
			System.out.println(novels.get(i).name+" is for "+novels.get(i).price);
		}

		Collections.sort(novels);								//Using Comparable

		System.out.println("\nAfter Sorting with Price");
		for(int i=0; i<novels.size();i++)
		{
			System.out.println(novels.get(i).name+" is for "+novels.get(i).price);
		}

		Collections.sort(novels, new Q7_chaptersCompare());					//Using Comparator

		System.out.println("\nAfter Sorting with Chapters");
		for(int i=0; i<novels.size();i++)
		{
			System.out.println(novels.get(i).name+" is for "+novels.get(i).chapters);
		}
	}


	public void implementSetOps(String value){
		HashSet<Character> letterList=new HashSet<Character>();
		
		for(int i = 0; i<value.length();i++){
			letterList.add(value.charAt(i));
		}

		System.out.println("\nHash Set Elements of Primitives");
		System.out.println(letterList);


		Q7_Novel book1 = new Q7_Novel("Harry Potter",56,400);
		Q7_Novel book2 = new Q7_Novel("Percy Jackson",43,350);
		Q7_Novel book3 = new Q7_Novel("Tin Tin",65,200);

		HashSet<Q7_Novel> novelSet=new HashSet<Q7_Novel>();
		novelSet.add(book1);
		novelSet.add(book2);
		novelSet.add(book3);
		novelSet.add(book2);

		System.out.println("\nHash Set Elements of Custom Objects");
		for(Q7_Novel x: novelSet)
		{
			System.out.println(x.name+" is for "+x.price);
		}		
	}

	public void implementMapOps(){
		TreeMap<Character, String> planeModels=new TreeMap<Character,String>();

		planeModels.put('d',"AirBus 102");
		planeModels.put('a',"Boeing 153");
		planeModels.put('b',"Boeing 720");
		planeModels.put('c',"Antonov 333");

		System.out.println("\nTreeMap Elements");
		Set iteratorSet=planeModels.entrySet();
		Iterator iterator=iteratorSet.iterator();
		while(iterator.hasNext()){
			Map.Entry mentry=(Map.Entry)iterator.next();
			System.out.println("key is: "+ mentry.getKey() + " & Value is: "+mentry.getValue());
		}

		TreeMap<Q7_Novel,Q7_Novel> novelMap=new TreeMap<Q7_Novel,Q7_Novel>();

		Q7_Novel book1 = new Q7_Novel("Harry Potter",56,400);
		Q7_Novel book2 = new Q7_Novel("Percy Jackson",43,350);
		Q7_Novel book3 = new Q7_Novel("Tin Tin",65,200);

		novelMap.put(book1,book2);
		novelMap.put(book2,book3);
		novelMap.put(book3,book1);

		System.out.println("\nTreeMap Elements of Custom Object");
		for(Map.Entry<Q7_Novel,Q7_Novel> entry: novelMap.entrySet()){
			System.out.println("key is: "+ entry.getKey().name+" with price "+ entry.getKey().price+ " & Value is: "+entry.getValue().name+" with price "+ entry.getValue().price);
		}
	}
}

class Q7_Novel implements Comparable<Q7_Novel>{
	String name;
	int  chapters, price;
	
	public Q7_Novel(String name, int chapters, int price){
		this.name=name;
		this.chapters=chapters;
		this.price=price;
	}

	public int compareTo(Q7_Novel n){
		return this.price-n.price;
	}
	
}

class Q7_chaptersCompare implements Comparator<Q7_Novel>{
	public int compare(Q7_Novel n1, Q7_Novel n2){
		return Integer.compare(n1.chapters,n2.chapters);
	}
}
