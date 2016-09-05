//This class constructs the dealer's information and provides the code needed for the dealers part
public class Dealer {
	
	// Creates a variable for the information to hold
		private String[] handSuit = new String[17];
		private String[] handFace = new String[17];
		private int[] handValue = new int[17];
		private int totalPoints;
		private int handCount;
		private boolean isLost;
		
		// Constructor to initialize players
		public Dealer() {
			totalPoints = 0;
			handCount = 0;
			isLost = false;
			for (int k = 0; k < 17; k++) {
				handSuit[k] = "";
				handFace[k] = "";
				handValue[k] = 0;
			}
		}
		
		// Prints the hand of the dealer
		public static void printHand(Dealer dealer) {
			System.out.println();
			System.out.println("DEALER'S HAND");
			System.out.println("Number of Cards in Hand: " + dealer.handCount);
			for (int k = 0; k < dealer.handCount; k++) {
				System.out.println(dealer.handFace[k] + " of " + dealer.handSuit[k]);
			}
		}
		
		// Resets information for a new round
		public static void newRoundDealer(Dealer dealer) {
			dealer.totalPoints = 0;
			dealer.handCount = 0;
			for (int k = 0; k < 17; k++) {
				dealer.handSuit[k] = "";
				dealer.handFace[k] = "";
				dealer.handValue[k] = 0;
			}
		}
		
		// Calculates and returns the dealer's total hand value
		public static int calcPointsDealer(Dealer dealer) {
			dealer.totalPoints = 0;
			for (int k = 0; k < 17; k++) {
				dealer.totalPoints += dealer.handValue[k];
			}
			return dealer.totalPoints;
		}
		
		// Takes card from top of deck and adds to dealer's hand
		// Increments hand count
		public static void dealCardDealer(Dealer dealer, Deck deck) {
			// Takes top card
			dealer.handSuit[dealer.handCount] = Deck.dealSuit(deck);
			dealer.handFace[dealer.handCount] = Deck.dealFace(deck);
			dealer.handValue[dealer.handCount] = Deck.dealValue(deck);
			
			// Checks if the card taken is an Ace and sets it value according to the dealers hand value
			aceValue(dealer);
			
			// Increments hand count
			dealer.handCount++;
			
			// Calculates the total points of the dealers hand
			dealer.totalPoints = calcPointsDealer(dealer);
		}
		
		// Prints the card taken into player's hand most recently
		public static void printTopCard(Dealer dealer) {
			System.out.println(dealer.handFace[dealer.handCount-1] + " of " + dealer.handSuit[dealer.handCount-1]);
		}
		
		// Checks if the dealer's hand is full
		public static boolean isHandFull(Dealer dealer) {
			if (dealer.handCount == 17) {
				return true;
			} else {
				return false;
			}
		}

		// Checks if there is an Ace in the dealers hand
		public static boolean isAce(Dealer dealer) {
			if (dealer.handFace[dealer.handCount] == "Ace") {
				return true;
			} else {
				return false;
			}
		}
		
		// Sets the dealer's ace value to what it should be
		// If the dealer's hand value is greater than 10 before receiving an Ace, the Ace value will be 1
		// If not, the Ace value will be 11
		public static void aceValue(Dealer dealer) {
			if (isAce(dealer) == true) {
				if (dealer.totalPoints > 10) {
					dealer.handValue[dealer.handCount] = 1;
				} else {
					dealer.handValue[dealer.handCount] = 11;
				}
			}
		}
		
		// Automatically hits if the dealer's hand value is 17 or greater
		// If not, the dealer automatically stands
		public static void hitOrStandDealer(Dealer dealer, Deck deck) {
			if (isHandFull(dealer) != true) {
				if (dealer.handCount < 2) {
					System.out.println();
					System.out.println("The Dealer takes 2 cards...");
					System.out.println();
					System.out.println("DEALERS HAND: ");
					dealCardDealer(dealer, deck);
					printTopCard(dealer);
					dealCardDealer(dealer, deck);
					printTopCard(dealer);
				}
				while (dealer.totalPoints < 17) {
					System.out.println();
					System.out.println("The Dealer takes another card...");
					dealCardDealer(dealer, deck);
					printTopCard(dealer);
				}
				if (dealer.totalPoints >= 17) {
					System.out.println();
					System.out.println("The Dealer stands.");
				}
				System.out.printf("The Dealer now has %d points.", dealer.totalPoints);
				System.out.println();
				if (dealer.totalPoints == 21) {
					System.out.println();
					System.out.println("The Dealer has a BLACKJACK!");
				} else if (dealer.totalPoints > 21) {
					System.out.println();
					System.out.println("The Dealer has busted.");
				}
			}
		}
		
		// Returns the dealer's points
		public static int getPoints(Dealer dealer) {
			return dealer.totalPoints;
		}
		
		// Changes player information if the player loses the round
		public static void loseRound(Dealer dealer) {
			
		}
		
		// Changes player information if the player wins the round
		public static void winRound(Dealer dealer) {
			
		}

}
