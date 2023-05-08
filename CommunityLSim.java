import java.util.*;

public final class CommunityLSim {
   //instance variables
  private ArrayList<Player> players;
  private int numPeeps;
  Random random = new Random();
  //TODO: you will need to add more instance variables
  private ArrayList<Integer> participatingPlayers;
  //Constructor
  public CommunityLSim(int numP) {
		numPeeps = numP;
		//create the players
  		players = new ArrayList<Player>();
	  	participatingPlayers = new ArrayList<Integer>();

		//generate a community of 30
		for (int i = 0; i < numPeeps; i++) {
			if (i < numPeeps/2.0)
				players.add(new Player(PlayerKind.POORLY_PAID, (float)(99+Math.random())));
			else
				players.add(new Player(PlayerKind.WELL_PAID, (float)(100.1+Math.random())));
		}
	
	}

	public int getSize() {return numPeeps;	}

	public Player getPlayer(int i) {return players.get(i);	}
   // TODO
	public void addPocketChange() {
   		for (Player player: players){
		   if(player.getKind() == PlayerKind.WELL_PAID) {
			   	player.setMoney(.1f);
			}
			else {
				player.setMoney(.03f);
				player.getNumbers();
			}
		}
   }

	private void reDoWhoPlays() {
		randomUniqIndx((int)((numPeeps/2)*.6), 0, (numPeeps/2)-1);
		randomUniqIndx((int)((numPeeps/2)*.4), numPeeps/2, (numPeeps)-1);
   }

	/*TODO generate some random indices for who might play the lottery 
		in a given range of indices */ 
 	public void randomUniqIndx(int NumI, int startRange, int endRange) {
		HashSet<Integer> usedIndices = new HashSet<Integer>();
		while (usedIndices.size() < NumI) {
			int i = random.nextInt(endRange - startRange + 1) + startRange;
			if (!usedIndices.contains(i)) {
				usedIndices.add(i);
			}
		}
		for (Integer ints: usedIndices) {
			participatingPlayers.add(ints);
		}
	}
	public void Redistribute(){
		int randomNumber = random.nextInt(9);
		if (randomNumber<3){
			int randomPoor = random.nextInt(numPeeps/2);
			players.get(randomPoor).setMoney(1f);
		}
		else{
			int randomRich = random.nextInt(numPeeps/2) + numPeeps/2;
			players.get(randomRich).setMoney(1f);
		}
	}
    
	public void simulateYears(int numYears) {
  		/*now simulate lottery play for some years */
  		for (int year=0; year < numYears; year++) {
			reDoWhoPlays();
			addPocketChange();
    		// TODO: add code so that each member of the community who plays, plays 
			//right now just everyone updates their list of funds each year
			Game game = new Game();
			float min = 11111111.2f;
			float max = -111111.3f;
			for (Integer p : participatingPlayers) {
				if (game.Winnings(game.Match(players.get(p)))==-1f){
					Redistribute();
				}
				players.get(p).setMoney(game.Winnings(game.Match(players.get(p))));
			}
			for (Player p : players) {
				p.updateMoneyEachYear();
				if (p.getMoney() > max){
					max = p.getMoney();
				}
				if (p.getMoney() < min){
					min = p.getMoney();
				}
			}
			System.out.println("After year " + year + ":");
			System.out.println("The person with the most money has: " + max);
			System.out.println("The person with the least money has: " + min);
			participatingPlayers.clear();
    	} //years
  }	

}
