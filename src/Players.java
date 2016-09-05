// This class constructs the player profiles and the information assigned to each
public class Players {
	
	// Creates a variable for the information to hold
	private String name;
	private String[] handSuit = new String[21];
	private String[] handFace = new String[21];
	private int[] handValue = new int[21];
	private int totalPoints;
	private int budget;
	private int bet;
	private int handCount;
	private char decision;
	private int lastHit;
	private boolean isLostRound;
	
	// Constructor to initialize players
	public Players(String name) {
		this.name = name;
		totalPoints = 0;
		budget = 500;
		bet = 0;
		handCount = 0;
		lastHit = 0;
		decision = ' ';
		isLostRound = false;
		for (int k = 0; k < 21; k++) {
			handSuit[k] = "";
			handFace[k] = "";
			handValue[k] = 0;
		}
	}
	
	// Asks the user which information to print
	// Calls other methods to print the information
	public static void print(Players player) {
		// Checks if user input is valid
		char input = ' ';
		do {
			System.out.println();
			System.out.println("What would you like to view?");
			System.out.print("All information [A], Player Information [P], Hand Information [H], or None [N]? ");
			input = Character.toLowerCase(IO.readChar());
			if (input != 'a' && input != 'p' && input != 'h' && input != 'n') {
				System.out.println();
				System.out.println("ERROR: Please enter a valid input.");
			}
		} while (input != 'a' && input != 'p' && input != 'h' && input != 'n');
		
		// Exits view option if player chooses to
		if (input == 'n') {
			return;
		// Executes other options
		} else if (input == 'a') {
			System.out.println();
			printAll(player);
		} else if (input == 'p') {
			System.out.println();
			printPlayerInfo(player);
		} else if (input == 'h') {
			System.out.println();
			printHand(player);
		} 
	}
	
	// Prints the player's information
	public static void printPlayerInfo(Players player) {
		System.out.println();
		System.out.println("PLAYER INFORMATION");
		System.out.println("Name: " + player.name);
		System.out.println("Budget: " + player.budget);
		System.out.println("Current Bet Amount: " + player.bet);
		System.out.println("Current Hand Value: " + player.totalPoints);
	}
	
	// Prints all player information
	public static void printAll(Players player) {
		printPlayerInfo(player);
		printHand(player);		
	}
	
	// Prints the hand of the player
	public static void printHand(Players player) {
		System.out.println();
		System.out.println("PLAYER'S HAND");
		System.out.println("Number of Cards in Hand: " + player.handCount);
		for (int k = 0; k < player.handCount; k++) {
			System.out.println(player.handFace[k] + " of " + player.handSuit[k]);
		}
	}
	
	// Resets information for a new round
	public static void newRoundPlayer(Players player) {
		player.bet = 0;
		player.totalPoints = 0;
		player.handCount = 0;
		player.decision = ' ';
		player.lastHit = 0;
		for (int k = 0; k < 21; k++) {
			player.handSuit[k] = "";
			player.handFace[k] = "";
			player.handValue[k] = 0;
		}
	}
	
	// Calculates and returns the players total hand value
	public static int calcPointsPlayer(Players player) {
		player.totalPoints = 0;
		for (int k = 0; k < 21; k++) {
			player.totalPoints += player.handValue[k];
		}
		return player.totalPoints;
	}
	
	// Takes card from top of deck and adds to player hand
	// Increments hand count
	public static void dealCardPlayer(Players player, Deck deck) {
		// Takes top card
		player.handSuit[player.handCount] = Deck.dealSuit(deck);
		player.handFace[player.handCount] = Deck.dealFace(deck);
		player.handValue[player.handCount] = Deck.dealValue(deck);
		
		// Checks if the card is an Ace and changes its value accordingly
		setAce(player);
		
		// Increments hand count
		player.handCount++;
		
		// Calculates the players hand value
		calcPointsPlayer(player);
	}
	
	// Checks if the card taken out is an Ace
	public static boolean isAce(Players player) {
		if (player.handFace[player.handCount] == "Ace") {
			return true;
		} else {
			return false;
		}
	}
	
	// Asks the user whether to set the value of an Ace to 1 or 11 points and sets it as is
	public static void setAce(Players player) {
		if (isAce(player) == true) {
			int input = 0;
			do {
				System.out.println();
				System.out.print("What value would you like to set the Ace to: 1 or 11? ");
				input = IO.readInt();
				System.out.println();
				if (input != 1 && input != 11) {
					System.out.println();
					System.out.println("ERROR: Please enter either 1 or 11");
				}
			} while (input != 1 && input != 11);
			player.handValue[player.handCount] = input;
		}
	}
	
	// Prints the card taken into player's hand most recently
	public static void printTopCard(Players player) {
		System.out.println(player.handFace[player.handCount-1] + " of " + player.handSuit[player.handCount-1]);
	}
	
	// Checks if the players hand is full
	public static boolean isHandFull(Players player) {
		if (player.handCount == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	// Sets player decision during gameplay
	public static void setDecision(Players player, char decision) {
		player.decision = decision;
	}
	
	// Returns player decision
	public static char getDecision(Players player) {
		return player.decision;
	}

	// Changes player information if the player loses the round
	public static void loseRound(Players player) {
		
	}
	
	// Changes player information if the player wins the round
	public static void winRound(Players player) {
		
	}
	
	// Changes the player's bet amount
	public static void setBet(Players player, int amount) {
		player.bet = amount;
	}
	
	// Returns the player's bet amount
	public static int getBet(Players player) {
		return player.bet;
	}
	
	// Adds to the player's budget amount
	public static void addBudget(Players player, int amount) {
		player.budget += amount;
	}
	
	// Subtracts to the player's budget amount
	public static void subtractBudget(Players player, int amount) {
		player.budget -= amount;
	}
	
	// Returns the player's budget amount
	public static int getBudget(Players player) {
		return player.budget;
	}

	// Returns the player's name
	public static String getName(Players player) {
		return player.name;
	}
	
	// Returns the player's hand count
	public static int getHandCount(Players player) {
		return player.handCount;
	}
	
	// Returns the players total points
	public static int getPoints(Players player) {
		return player.totalPoints;
	}
	
	// Changes boolean lost if the player has lost the game
	public static void printLost(Players player) {
		System.out.println();
		System.out.println(player.name + " has lost the game");
	}
	
	// Checks if the player has lost the game
	public static boolean isLostGame(Players player) {
		if (player.budget <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Increments the lastHit variable to 1. Used for the double down option.
	// Players can only take 1 card after choosing double down
	public static void lastHit(Players player) {
		player.lastHit++;
	}
	
	// Makes the option hit unusable
	public static boolean noHit(Players player) {
		if (player.lastHit == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	// Changes if the player has lost the round
	public static void setLostRound(Players player) {
		player.isLostRound = true;
	}
	
	// Checks if the player has lost the round. Used to check if the players budget has been changed.
	public static boolean isLostRound(Players player) {
		if (player.isLostRound == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Players player = new Players("Jon");
		Deck deck = new Deck();
		deck = Deck.createDeck();
		Deck.shuffle(deck);
		
		setBet(player, 50);
		System.out.println("Bet: " + getBet(player));
		System.out.println();
		
		player.budget = 500;
		subtractBudget(player, (player.bet/2));
		System.out.println("Budget = " + player.budget);
		
	}
}
