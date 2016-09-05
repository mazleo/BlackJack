
public class Gameplay {
	
	private static char action = ' ';		// holds player input
	private static int roundCount = 0;
	private static int endGame = 0;			// 0 means to continue playing, 1 means to end the game
	private static Deck deck = new Deck();
	private static int nOfPlayers = 0;		// Counts the number of players
	private static int playersRemaining = 0;
	
	// Prints an introduction to players
	public static void printIntro() {
		System.out.println("************************************************************************************************************************************");
		System.out.println("Welcome to");
		System.out.println();
		System.out.println(
		"BBBBB   L         A      CCCCC  K   K        J    A      CCCCC  K   K\n" +
		"B    B  L        A A    C       K  K         J   A A    C       K  K\n" +
		"BBBBB   L       AAAAA   C       KKK    J     J  AAAAA   C       KKK\n" + 
		"B    B  L      A     A  C       K  K   J     J A     A  C       K  K\n" +
		"BBBBB   LLLLL  A     A   CCCCC  K   K   JJJJJ  A     A   CCCCC  K   K");
		System.out.println();
		System.out.println("By Jonnelin Leonardo");
		System.out.println();
		System.out.println("**************************************************************************************************************************************");
	}
	
	// Prints the game prompt
	public static void gamePrompt() {
		
		do {
			System.out.println();
			System.out.println("PLAY GAME [P]\tTUTORIAL [T]\tQUIT[Q]\t");
			System.out.print("Please select an option: ");
			action = Character.toLowerCase(IO.readChar());
			if (action != 'p' && action != 't' && action != 'q') {
				System.out.println();
				System.out.println("Error: Please enter a valid input");
			} else if (action == 'q') {
				System.out.println();
				System.out.println("Quitting Game...");
				System.out.println("Goodbye!");
				System.exit(0);
			}
		} while (action != 'p' && action != 't' && action != 'q');
		if (action == 't') {
			printTutorial();
		}
	}
	
	// Prints the tutorial onto the screen
	public static void printTutorial() {
		System.out.println();
		System.out.println("*************************TUTORIAL*************************");
		System.out.println();
		System.out.println("CARD FACES AND SUITS");
		System.out.println("Each card is assigned a specific Face and Suit");
		System.out.println("The 33 CARD FACES are Ace (A), Two (2), Three (3), Four (4), Five (5), Six (6),");
		System.out.println("Seven (7), Eight (8), Nine (9), Ten (10), Jack (J), Queen (Q), and King (K)");
		System.out.println("The 4 CARD SUITS are Spades, Hearts, Diamonds, and Clubs");
		System.out.println();
		System.out.println("CARD POINT VALUES");
		System.out.println("Each card face is also assigned a specific point value");
		System.out.println("Depending on the player, the Ace (A) can either be a 1 or 11.");
		System.out.println("The point values of cards Two (2) to Ten (10) are the same as their face number ");
		System.out.println("(ex. Card Two (2) = 2 points). The Jack (J), Queen (Q), and King (K) are all worth 10 points.");
		System.out.println();
		System.out.println("BUDGET AND BETTING");
		System.out.println("In the beginning of each game, the player is given a budget of $500. A player can choose to");
		System.out.println("bet any amount within their budgets. If the player loses all of their money, then the player");
		System.out.println("loses the game");
		System.out.println();
		System.out.println("IMPORTANT TERMS");
		System.out.println("Hand - the cards a player has or the cards in the players 'hand");
		System.out.println("Bust - to lose the round because a players points has exceeded 21");
		System.out.println("Push - the player's or dealer's point are tied");
		System.out.println();
		System.out.println("THE RULES OF BLACKJACK");
		System.out.println("The objective of each player is to have a hand point value that is greater than");
		System.out.println("the dealer, but without exceeded 21 points. If the player or dealer exceeds 21 points,");
		System.out.println("they have busted or have lost the round. In the beginning of each game, each player are");
		System.out.println("given 2 cards. Depending on the point values of their hand, the player will choose an");
		System.out.println("option provided by the game. If a player's hand value is worth 21, then the player has");
		System.out.println("achieved a blackjack and automatically wins the round, unless another player or the dealer");
		System.out.println("has a blackjack as well.");
		System.out.println();
		System.out.println("The OPTIONS are: ");
		System.out.println("HIT		The player is given a card and can continue to receive one until the player");
		System.out.println("		busts or chooses another option");
		System.out.println();
		System.out.println("STAND		The player will not receive any cards and will the game will continue");
		System.out.println("		with the next player");
		System.out.println();
		System.out.println("DOUBLE DOWN	The players bet will double and will only be allowed to take");
		System.out.println("		one more card");
		System.out.println();
		System.out.println("SURRENDER	The players will lose the round and half of their original bet");
		System.out.println();
		System.out.println("WINNING AND LOSING");
		System.out.println("Any amount of players can win or lose the round. To win it, the players hand value must be");
		System.out.println("worth more than the dealer. If not, the dealer will win and the players will lose their bets.");
		System.out.println("If the players or the dealer tie, then they have achieved a 'push', and those who have achieved");
		System.out.println("it will keep their bets.");
		System.out.println();
		System.out.println("To quit the game, simply enter 'q' when promped. Good Luck!");
	}

	// Prints the Options
	public static void printOptions() {
		System.out.println();
		System.out.println("OPTIONS");
		System.out.println("HIT		The player is given a card and can continue to receive one until the player");
		System.out.println("		busts or chooses another option");
		System.out.println();
		System.out.println("STAND		The player will not receive any cards and will the game will continue");
		System.out.println("		with the next player");
		System.out.println();
		System.out.println("DOUBLE DOWN	The players bet will double and will only be allowed to take");
		System.out.println("		one more card");
		System.out.println();
		System.out.println("SURRENDER	The players will lose the round and half of their original bet");
		System.out.println();
	}
	
	// checks if the players chose to play
	public static boolean isPlayGame() {
		if (action == 'p') {
			return true;
		} else {
			return false;
		}
	}
	// Creates a new round
	
	// Checks if the players want to end the game
	public static boolean isEndGame() {
		if (endGame == 1 || playersRemaining == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Executes the action/decision prompt
	public static void actionPrompt(Players player) {
		do {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.print("HIT [H]     STAND [S]     DOUBLE DOWN[D]     SURRENDER[U]     \nHELP[R]     VIEW INFORMATION[V]     QUIT[Q]     END GAME[E]: ");
			action = Character.toLowerCase(IO.readChar());
			if (action != 'h' && action != 's' &&action != 'd' &&action != 'u' &&action != 'q' &&action != 'r' &&action != 'e' &&action != 'v') {
				System.out.println();
				System.out.println("ERROR: Please enter a valid input.");
			}
		} while (action != 'h' && action != 's' &&action != 'd' &&action != 'u' &&action != 'q' &&action != 'r' &&action != 'e' &&action != 'v');
		if (action == 'h') {
			Options.hit(player, deck, Players.getName(player));
		} else if (action == 's') {
			Options.stand(Players.getName(player), Players.getPoints(player));
		} else if (action == 'd') {
			Options.doubleDown(player, Players.getName(player), Players.getBet(player));
			Players.setDecision(player, 'd');
		} else if (action == 'u') {
			Options.surrender(player, Players.getName(player), Players.getBet(player));
		} else if (action == 'r') {
			printOptions();
		} else if (action == 'v') {
			Players.print(player);
		} else if (action == 'q') {
			System.out.println();
			System.out.println(Players.getName(player) + " has left the game.");
			Players.setDecision(player, action);
			playersRemaining--;
		} else if (action == 'e') {
			System.out.println();
			System.out.println("Ending game...");
			endGame();
		}
		
	}
	
	
	// Takes the top card of the deck and assigns it to the player
	// New round deal mechanism
	public static void dealNewRoundPlayer(Players player, Deck deck, String name, int handCount) {
		if (handCount < 2) {
			System.out.println();
			System.out.println(name + " takes 2 cards.");
			System.out.println();
			Players.dealCardPlayer(player, deck);
			Players.printTopCard(player);
			Players.dealCardPlayer(player, deck);
			Players.printTopCard(player);
		}
		int totalPoints = Players.calcPointsPlayer(player);
		System.out.println();
		System.out.println(name + " now has " + totalPoints + " points.");
	}
	
	// Checks if the player has busted
	public static boolean isBusted(Players player, int totalPoints) {
		if (totalPoints > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	// Executes code to end the game
	public static void endGame() {
		System.exit(0);
	}

	
	public static void main(String[] args) {
		int bet = 0;
		
		// Introduction and game prompt
		printIntro();
		do {
			gamePrompt();
		} while (isPlayGame() == false);
		
		System.out.println();
		System.out.println("*************************PLAY GAME*************************");
		
		// Asks for the name of the players
		do {
			System.out.println();
			System.out.print("How many players will be playing the game? A maximum of six players are allowed: ");
			nOfPlayers = IO.readInt();
			if (nOfPlayers <= 0 || nOfPlayers > 6) {
				System.out.println();
				System.out.println("Error: Please enter a valid input.");
			}
		} while (nOfPlayers <= 0 || nOfPlayers > 6);		
		
		// Takes the names of the players
		String[] names = new String[6];
		int nameCount = 0;
		
		for (int n = 0; n < nOfPlayers; n++) {
			System.out.println();
			System.out.print("What is the name of Player " + (nameCount+1) + "? ");
			names[n] = IO.readString();
			names[n] = names[n].trim();
			nameCount++;
		}
		
		// Initializes the player and dealer objects and assigns the names
		Dealer dealer = new Dealer();
		Players player1 = new Players(names[0]);
		Players player2 = new Players(names[1]);
		Players player3 = new Players(names[2]);
		Players player4 = new Players(names[3]);
		Players player5 = new Players(names[4]);
		Players player6 = new Players(names[5]);
		
		// Start of game
		System.out.println();
		System.out.println("*************************START*************************");
		System.out.println();
		System.out.println("All players have received $500 for their budget.");
		
		// New round
		do {
			roundCount++;
			System.out.println();
			System.out.println("ROUND " + roundCount);
			System.out.println();
			System.out.println("Place your bets. The Minimum is $10.");
			
			// Takes the players bets
			// Player 1
			if (Players.getDecision(player1) != 'q' && Players.isLostGame(player1) != true) {
				do {
					Players.newRoundPlayer(player1);
					System.out.println();
					System.out.print(Players.getName(player1) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player1, bet);
					if (bet < 10 || bet > Players.getBudget(player1)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player1));
			}
			// Player 2
			if (nOfPlayers >= 2 && Players.getDecision(player2) != 'q' && Players.isLostGame(player2) != true) {
				do {
					Players.newRoundPlayer(player2);
					System.out.println();
					System.out.print(Players.getName(player2) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player2, bet);
					if (bet < 10 || bet > Players.getBudget(player2)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player2));
			}
			// Player 3
			if (nOfPlayers >= 3 && Players.getDecision(player3) != 'q' && Players.isLostGame(player3) != true) {
				do {
					Players.newRoundPlayer(player3);
					System.out.println();
					System.out.print(Players.getName(player3) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player3, bet);
					if (bet < 10 || bet > Players.getBudget(player3)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player3));
			}
			// Player 4
			if (nOfPlayers >= 4 && Players.getDecision(player4) != 'q' && Players.isLostGame(player4) != true) {
				do {
					Players.newRoundPlayer(player4);
					System.out.println();
					System.out.print(Players.getName(player4) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player4, bet);
					if (bet < 10 || bet > Players.getBudget(player4)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player4));
			}
			// Player 5
			if (nOfPlayers >= 5 && Players.getDecision(player5) != 'q' && Players.isLostGame(player5) != true) {
				do {
					Players.newRoundPlayer(player5);
					System.out.println();
					System.out.print(Players.getName(player5) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player5, bet);
					if (bet < 10 || bet > Players.getBudget(player5)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player5));
			}
			// Player 6
			if (nOfPlayers >= 6 && Players.getDecision(player6) != 'q' && Players.isLostGame(player6) != true) {
				do {
					Players.newRoundPlayer(player6);
					System.out.println();
					System.out.print(Players.getName(player6) + ", what is your bet? $");
					bet = IO.readInt();
					Players.setBet(player6, bet);
					if (bet < 10 || bet > Players.getBudget(player6)) {
						System.out.println();
						System.out.println("Error: Please enter a valid input.");
					}
				} while (bet < 10 || bet > Players.getBudget(player5));
			}
			
			// The deck is created and prepared for the round
			System.out.println();
			System.out.println();
			System.out.println("The dealer is now preparing the deck...");
			System.out.println();
			if (roundCount == 1) {
				deck = Deck.createDeck();
				Deck.shuffle(deck);
			// Shuffles the deck if it is empty
			} else if (Deck.isEmpty(deck)) {
				Deck.shuffle(deck);
			}
			
			// Players receive their cards
			
			// Player 1
			if (nOfPlayers >= 1 && Players.getDecision(player1) != 'q' && Players.isLostGame(player1) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player1).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player1, deck, Players.getName(player1), Players.getHandCount(player1));
				do {
					actionPrompt(player1);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player1) == 21) {
						System.out.println();
						System.out.println(Players.getName(player1) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player1, Players.getPoints(player1))) {
						System.out.println();
						System.out.println(Players.getName(player1) + " has busted.");
						Players.subtractBudget(player1, Players.getBet(player1));
						System.out.println(Players.getName(player1) + "'s budget is now $" + Players.getBudget(player1));
						Players.setLostRound(player1);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player1) == true) {
						Players.printLost(player1);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player1, Players.getPoints(player1)) != true);
			}
			// Player 2
			if (nOfPlayers >= 2 && Players.getDecision(player2) != 'q' && Players.isLostGame(player2) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player2).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player2, deck, Players.getName(player2), Players.getHandCount(player2));
				do {
					actionPrompt(player2);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player2) == 21) {
						System.out.println();
						System.out.println(Players.getName(player2) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player2, Players.getPoints(player2))) {
						System.out.println();
						System.out.println(Players.getName(player2) + " has busted.");
						Players.subtractBudget(player2, Players.getBet(player2));
						System.out.println(Players.getName(player2) + "'s budget is now $" + Players.getBudget(player2));
						Players.setLostRound(player2);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player2) == true) {
						Players.printLost(player2);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player2, Players.getPoints(player2)) != true);
			}
			// Player 3
			if (nOfPlayers >= 3 && Players.getDecision(player3) != 'q' && Players.isLostGame(player3) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player3).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player3, deck, Players.getName(player3), Players.getHandCount(player3));
				do {
					actionPrompt(player3);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player3) == 21) {
						System.out.println();
						System.out.println(Players.getName(player3) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player3, Players.getPoints(player3))) {
						System.out.println();
						System.out.println(Players.getName(player3) + " has busted.");
						Players.subtractBudget(player3, Players.getBet(player3));
						System.out.println(Players.getName(player3) + "'s budget is now $" + Players.getBudget(player3));
						Players.setLostRound(player3);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player3) == true) {
						Players.printLost(player3);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player3, Players.getPoints(player3)) != true);
			}
			// Player 4
			if (nOfPlayers >= 4 && Players.getDecision(player4) != 'q' && Players.isLostGame(player4) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player4).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player4, deck, Players.getName(player4), Players.getHandCount(player4));
				do {
					actionPrompt(player4);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player4) == 21) {
						System.out.println();
						System.out.println(Players.getName(player4) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player4, Players.getPoints(player4))) {
						System.out.println();
						System.out.println(Players.getName(player4) + " has busted.");
						Players.subtractBudget(player4, Players.getBet(player4));
						System.out.println(Players.getName(player4) + "'s budget is now $" + Players.getBudget(player4));
						Players.setLostRound(player4);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player4) == true) {
						Players.printLost(player4);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player4, Players.getPoints(player4)) != true);
			}
			// Player 5
			if (nOfPlayers >= 5 && Players.getDecision(player5) != 'q' && Players.isLostGame(player5) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player5).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player5, deck, Players.getName(player5), Players.getHandCount(player5));
				do {
					actionPrompt(player5);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player5) == 21) {
						System.out.println();
						System.out.println(Players.getName(player5) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player5, Players.getPoints(player5))) {
						System.out.println();
						System.out.println(Players.getName(player5) + " has busted.");
						Players.subtractBudget(player5, Players.getBet(player5));
						System.out.println(Players.getName(player5) + "'s budget is now $" + Players.getBudget(player5));
						Players.setLostRound(player5);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player5) == true) {
						Players.printLost(player5);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player5, Players.getPoints(player5)) != true);
			}
			// Player 6
			if (nOfPlayers >= 6 && Players.getDecision(player6) != 'q' && Players.isLostGame(player6) != true) {
				System.out.println();
				System.out.println("It is " + Players.getName(player6).toUpperCase() + "'s turn");
				dealNewRoundPlayer(player6, deck, Players.getName(player6), Players.getHandCount(player6));
				do {
					actionPrompt(player6);		// Prints the decision prompt
					// Checks if the player has a blackjack
					if (Players.getPoints(player6) == 21) {
						System.out.println();
						System.out.println(Players.getName(player6) + " has a BLACKJACK!");
					}
					// Checks if the player has busted
					if (isBusted(player6, Players.getPoints(player6))) {
						System.out.println();
						System.out.println(Players.getName(player6) + " has busted.");
						Players.subtractBudget(player6, Players.getBet(player6));
						System.out.println(Players.getName(player6) + "'s budget is now $" + Players.getBudget(player6));
						Players.setLostRound(player6);
					}
					// Checks if the player has lost and displays necessary information
					if (Players.isLostGame(player6) == true) {
						Players.printLost(player6);
						playersRemaining--;
					}
				} while (action != 's' && action != 'u' && action != 'q' && isBusted(player6, Players.getPoints(player6)) != true);
			}
			
			// Dealers turn
			System.out.println();
			System.out.println("It is now the DEALERS turn");
			Dealer.newRoundDealer(dealer);
			Dealer.hitOrStandDealer(dealer, deck);
			
			// Checks if the players won
			// Player 1
			if (nOfPlayers >= 1 && Players.getDecision(player1) != 'q' && Players.isLostGame(player1) != true) {
				if (Players.getPoints(player1) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player1) + " has lost.");
					if (Players.isLostRound(player1) == false) {
						Players.subtractBudget(player1, Players.getBet(player1));
					}
					System.out.println(Players.getName(player1) + "'s budget is now $" + Players.getBudget(player1));
				} else if (Players.getPoints(player1) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player1) + " has won");
					System.out.println(Players.getName(player1) + "'s budget is now $" + Players.getBudget(player1));
				} else if (Players.getPoints(player1) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player1) + " has achieved a push");
					System.out.println(Players.getName(player1) + "'s budget is now $" + Players.getBudget(player1));
				}
			}
			// Player 2
			if (nOfPlayers >= 2 && Players.getDecision(player2) != 'q' && Players.isLostGame(player2) != true) {
				if (Players.getPoints(player2) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player2) + " has lost.");
					if (Players.isLostRound(player2) == false) {
						Players.subtractBudget(player2, Players.getBet(player2));
					}
					System.out.println(Players.getName(player2) + "'s budget is now $" + Players.getBudget(player2));
				} else if (Players.getPoints(player2) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player2) + " has won");
					System.out.println(Players.getName(player2) + "'s budget is now $" + Players.getBudget(player2));
				} else if (Players.getPoints(player2) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player2) + " has achieved a push");
					System.out.println(Players.getName(player2) + "'s budget is now $" + Players.getBudget(player2));
				}
			}
			// Player 3
			if (nOfPlayers >= 3 && Players.getDecision(player3) != 'q' && Players.isLostGame(player3) != true) {
				if (Players.getPoints(player3) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player3) + " has lost.");
					if (Players.isLostRound(player3) == false) {
						Players.subtractBudget(player3, Players.getBet(player3));
					}
					System.out.println(Players.getName(player3) + "'s budget is now $" + Players.getBudget(player3));
				} else if (Players.getPoints(player3) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player3) + " has won");
					System.out.println(Players.getName(player3) + "'s budget is now $" + Players.getBudget(player3));
				} else if (Players.getPoints(player3) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player3) + " has achieved a push");
					System.out.println(Players.getName(player3) + "'s budget is now $" + Players.getBudget(player3));
				}
			}
			// Player 4
			if (nOfPlayers >= 4 && Players.getDecision(player4) != 'q' && Players.isLostGame(player4) != true) {
				if (Players.getPoints(player4) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player4) + " has lost.");
					if (Players.isLostRound(player4) == false) {
						Players.subtractBudget(player4, Players.getBet(player4));
					}
					System.out.println(Players.getName(player4) + "'s budget is now $" + Players.getBudget(player4));
				} else if (Players.getPoints(player4) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player4) + " has won");
					System.out.println(Players.getName(player4) + "'s budget is now $" + Players.getBudget(player4));
				} else if (Players.getPoints(player4) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player4) + " has achieved a push");
					System.out.println(Players.getName(player4) + "'s budget is now $" + Players.getBudget(player4));
				}
			}
			// Player 5
			if (nOfPlayers >= 5 && Players.getDecision(player5) != 'q' && Players.isLostGame(player5) != true) {
				if (Players.getPoints(player5) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player5) + " has lost.");
					if (Players.isLostRound(player5) == false) {
						Players.subtractBudget(player5, Players.getBet(player5));
					}
					System.out.println(Players.getName(player5) + "'s budget is now $" + Players.getBudget(player5));
				} else if (Players.getPoints(player5) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player5) + " has won");
					System.out.println(Players.getName(player5) + "'s budget is now $" + Players.getBudget(player5));
				} else if (Players.getPoints(player5) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player5) + " has achieved a push");
					System.out.println(Players.getName(player5) + "'s budget is now $" + Players.getBudget(player5));
				}
			}
			// Player 6
			if (nOfPlayers >= 6 && Players.getDecision(player6) != 'q' && Players.isLostGame(player6) != true) {
				if (Players.getPoints(player6) < Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player6) + " has lost.");
					if (Players.isLostRound(player6) == false) {
						Players.subtractBudget(player6, Players.getBet(player6));
					}
					System.out.println(Players.getName(player6) + "'s budget is now $" + Players.getBudget(player6));
				} else if (Players.getPoints(player6) > Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player6) + " has won");
					System.out.println(Players.getName(player6) + "'s budget is now $" + Players.getBudget(player6));
				} else if (Players.getPoints(player6) == Dealer.getPoints(dealer)) {
					System.out.println();
					System.out.println(Players.getName(player6) + " has achieved a push");
					System.out.println(Players.getName(player6) + "'s budget is now $" + Players.getBudget(player6));
				}
			}
			
			
		} while (isEndGame() != true);
		
		
	}

}
