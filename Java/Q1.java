public class Q1{									//Question 1: Basics of Java
	public static void main(String []args){
		 Q1_Team tot= new  Q1_Team("Tottenham Hotspurs","England");		//Creates and object of  Q1_Team class, refer to  Q1_Team.java file
		 Q1_Team mun= new  Q1_Team("Manchester United","England");
		 Q1_Team fcb= new  Q1_Team("FC Barcelona","Spain");
		 Q1_Team psg= new  Q1_Team("Paris Saint Germain","France");

		tot.setPosition(17);							//Calls setPosition and addPlayer methods of  Q1_Team class
		mun.setPosition(19);
		fcb.setPosition(1);
		psg.setPosition(1);

		tot.addPlayer("Son Heung-Min");
		tot.addPlayer("Cristian Romero");
		tot.addPlayer("Dejan Kulusevski");
		tot.addPlayer("James Maddison");
		fcb.addPlayer("Lamine Yamal");
		fcb.addPlayer("Rafinha");
		fcb.addPlayer("Pedri");
		mun.addPlayer("Amad Diallo");
		psg.addPlayer("Desire Doue");
		psg.addPlayer("Kvicha Kvaratshkelia");
		psg.addPlayer("Nuno Mendea");

		tot.showTeamInfo();
		mun.showTeamInfo();
		if(tot.country==mun.country){
			System.out.println("The better team is "+((tot.position<mun.position)?(tot.name):(mun.name))+"\n");
		}
		else{
			System.out.println("They are not from the same country");
		}

		fcb.showTeamInfo();
		psg.showTeamInfo();
		if(fcb.country==psg.country){
			System.out.println("The better team is "+((fcb.position<psg.position)?(fcb.name):(psg.name))+"\n");
		}
		else{
			System.out.println("They are not from the same country");
		}
	}
}