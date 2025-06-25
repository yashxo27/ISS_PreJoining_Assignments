import java.util.concurrent.*;

class Q8_BankAccount {
	String owner;
	int balance=150;
	volatile boolean stopFlag=false;								//Volatile Keyword to use a Shared Flag

	Q8_BankAccount(String name){
		this.owner=name;
		System.out.println("Welcome "+owner+"\nYour Balance is "+balance+"\n");
	}

	public synchronized void deposit(int amount) {							//Synchronised keywrod ensures thread safe access
		if(stopFlag)
		{return;}
		balance+=amount;
		System.out.println("Deposited "+amount+", Balance: "+balance);
		
	}
	
	public void withdraw(int amount){
		if(stopFlag)
		{return;}

		synchronized(this){
			if(balance>=amount){
				balance-=amount;
				System.out.println("Withdrew "+amount+", Balance: "+balance);
			}
			else{
				System.out.println("Failed to withdraw "+amount+", Balance: "+balance);
			}
		}
	}

	public void stopTransactions(){
		stopFlag=true;
	}
}

public class Q8{
	public static void main(String[] args){
		Q8_BankAccount account=new Q8_BankAccount("Yashodhan");

		ExecutorService executor=Executors.newFixedThreadPool(5);
	
		Runnable depositTask=() -> {
			int localCalculation;
			for(int i=1;i<=5;i++){
				localCalculation=i*50;							//Thread Safe local variable
				account.deposit(localCalculation);					
				try{
					Thread.sleep(100);
				}
				catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
			}
		};

		Runnable withdrawTask=() ->{
			for(int i=1;i<=5;i++){
				account.withdraw(150);	
				try{
					Thread.sleep(100);
				}
				catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}				
			}
		};

		for(int i=0;i<3;i++){
			executor.submit(depositTask);
			executor.submit(withdrawTask);	
		}
		
		executor.shutdown();
		
		new Thread(()->{
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println("Transactions have been stopped.");
		}).start();	

	}
}