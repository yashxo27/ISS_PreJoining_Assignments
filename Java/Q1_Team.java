public class Q1_Team{										//Referenced in Q1
	String name, country;
	int position, team_size;
	String[] players = new String[11];

	Q1_Team(String name, String country){							//Constructor of Team
		this.name = name;
		this.country = country;
		this.team_size=0;
	}

	public void setPosition(int position){							//Defines the Team's league position
		this.position =  position;
	}

	public void addPlayer(String p_name){							//Adds Players to the Team
		players[team_size]=p_name;
		team_size++;
	}

	public void showTeamInfo(){								//Displays Team Information
		System.out.print(name+" is a team from "+country+" being ranked top "+position+" in the league\n");
		for(int x=0; x<team_size; x++){
			if(x==0){
				System.out.print("It consists of the following player(s): "+players[x]);
			}
			else if(x==team_size-1){
				System.out.print(" and "+players[x]);
			}
			else{
				System.out.print(", "+players[x]);
			}
		}
		System.out.println();
	}			 
	
}