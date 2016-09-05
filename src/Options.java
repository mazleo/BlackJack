// This class executes the code needed depending on player decisions
public class Options {

	// HIT
	public static void hit(Players player, Deck deck, String name) {
		if (Players.noHit(player) == true) {
			System.out.println();
			System.out.println("You cannot take anymore cards.");
		} else {
			System.out.println();
			System.out.println(name + " has chosen to HIT.");
			Players.dealCardPlayer(player, deck);
			Players.printTopCard(player);
			System.out.println();
			int totalPoints = Players.calcPointsPlayer(player);
			System.out.println(name + " now has " + totalPoints + " points.");
			if (Players.getDecision(player) == 'd') {
				Players.lastHit(player);
			}
		}
	}
	
	// STAND
	public static void stand(String name, int totalPoints) {
		System.out.println();
		System.out.println(name + " has chosen to STAND. ");
		System.out.println(name + " now has " + totalPoints + " points.");
	}
	
	// DOUBLE DOWN
	public static void doubleDown(Players player, String name, int bet) {
		if ((bet*2) > Players.getBudget(player)) {
			System.out.println();
			System.out.println("You do not have enough budget to double your bet. ");
		} else if (Players.getDecision(player) == 'd') {
			System.out.println();
			System.out.println("You have already chosen DOUBLE DOWN once.");
		} else {
			System.out.println();
			System.out.println(name + " has chosen DOUBLE DOWN.");
			System.out.println(name + "'s bet amount is now $" + bet*2);
			Players.setBet(player, bet*2);
			System.out.println(name + " can only take 1 more card");
		}
	}
	
	// SURRENDER
	public static void surrender(Players player, String name, int bet) {
		System.out.println();
		System.out.println(name + " has chosen SURRENDER.");
		Players.subtractBudget(player, (bet/2));
		int b = Players.getBudget(player);
		System.out.println(name + "'s budget is now $" + b);
		Players.setLostRound(player);
	}
	
	// QUIT ROUND
	public static void quitRound(Players player) {
		
	}
	
	// QUIT GAME
	public static void quitGame(Players player) {
	
	}
}
