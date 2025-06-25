import java.util.Scanner;
import java.util.Random;

public class Q3{									//Question 3: Loop Control and Decision Making	
	public static void loopControl(int loopType,Scanner obj) {
		if(loopType==1) {							//Decision Maker: If-Else Statments
			int inputVal2;
			System.out.println("Using For Loop, All numbers between 1 to 100 that are Divisible by: ");
			inputVal2=obj.nextInt();
			for(int i=1;i<=100;i++) {					//Loop Control: For Loop
				if(i%inputVal2!=0) {continue;}
				System.out.print(i+" ");
		}
			System.out.println();
		}
		
		else if(loopType==2) {
			int inputVal2;
			Random randomObj=new Random();
			int winNumber=randomObj.nextInt(50)+1,counter=0;
			while(counter<=6) {						//Loop Control: While Loop
				System.out.println("You have "+(7-counter)+" chance(s) left!");
				System.out.println("Guess a number from 1 to 50");
				inputVal2=obj.nextInt();
				if(inputVal2==winNumber) {
					System.out.println("You Win! :o");
					break;
					}
				else if(inputVal2>winNumber) {
					System.out.println("Guess a smaller number :p");					
				}
				else {
					System.out.println("Guess a larger number :p");
				}
				counter++;
		}
			if(counter==6) {System.out.println("You Lose! :(\n Winning Number was: "+winNumber);}
		}
		
		else {
			String inputVal2;
			int counter=0;
			do {								//Loop Control: Do-While Loop
				++counter;
				System.out.println("Say something!");
				inputVal2=obj.nextLine();
			}
			while(!inputVal2.endsWith("?"));
			System.out.println("Sentence you said before asking a Question: "+(counter-1));
		}
	}
	
	public static void main(String []args) {
		char inputVal1;
		
		Scanner inputObj=new Scanner(System.in);
		System.out.println("Which Loop would you like to see?:\na) For Loop\nb) While Loop\nc) Do-While Loop");
		inputVal1=inputObj.next().charAt(0);
		
		switch(inputVal1) {							//Decision Maker: Switch Case
		case 'a':
			loopControl(1,inputObj);
			break;
		case 'b':
			loopControl(2,inputObj);
			break;
		case 'c':
			loopControl(3,inputObj);
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
		inputObj.close();
		System.out.println("Thank You!");
	}
}
