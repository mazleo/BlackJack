// This class constructs a deck for gameplay. It contains the basic functions needed to play the game.
public class Deck {
	
	// Creates the suit, face, and value arrays
	private String suit[] = new String[52];
	private String face[] = new String[52];
	private int value[] = new int[52];
	private static int accessSuit = 0;
	private static int accessFace = 0;
	private static int accessValue = 0;
	
	// Creates a deck of cards in order
	public static Deck createDeck() {
		Deck deck = new Deck();		// temporary local deck variable
		int k = 0;					// index for each array
		for (int s = 1; s <= 4; s++) {
			for (int f = 1; f <= 13; f++) {
				deck.suit[k] = Cards.returnSuit(s);
				deck.face[k] = Cards.returnFace(f);
				deck.value[k] = Cards.returnValue(f);
				k++;
			}
		}
		return deck;
	}
	
	// Shuffles a deck and resets the access count
	public static void shuffle(Deck deck) {
		accessSuit = 0;
		accessFace = 0;
		accessValue = 0;
		
		// Holds temporary values
		String tempSuit = "";
		String tempFace = "";
		int tempValue = 0;
		
		int index1 = 0, index2 = 0;		// Used to store random index numbers
		
		
		for (int k = 0; k < 52; k++) {
			index1 = (int)(Math.random()*52);
			index2 = (int)(Math.random()*52);
			tempSuit = deck.suit[index2];
			tempFace = deck.face[index2];
			tempValue = deck.value[index2];
			deck.suit[index2] = deck.suit[index1];
			deck.face[index2] = deck.face[index1];
			deck.value[index2] = deck.value[index1];
			deck.suit[index1] = tempSuit;
			deck.face[index1] = tempFace;
			deck.value[index1] = tempValue;
		}
	}
	
	// Checks if the deck is empty
	public static boolean isEmpty(Deck deck) {
		if (accessSuit == 52 && accessFace == 52 &&accessValue == 52) {
			return true;
		} else {
			return false;
		}
	}
	
	// Returns the suit of the top card
	public static String dealSuit(Deck deck) {
		int access = accessSuit;
		accessSuit++;
		return deck.suit[access];		
	}
	
	// Returns the suit of the top card
	public static String dealFace(Deck deck) {
		int access = accessFace;
		accessFace++;
		return deck.face[access];		
	}
	
	// Returns the suit of the top card
	public static int dealValue(Deck deck) {
		int access = accessValue;
		accessValue++;
		return deck.value[access];		
	}
	
	// TEST IF WORKING
	public static void deal(Deck deck) {
		dealSuit(deck);
		dealFace(deck);
		dealValue(deck);
	}
	
	// Prints the top card
	public static void printTopCard(Deck deck) {
		System.out.println(deck.face[accessFace] + " of " + deck.suit[accessSuit]);
	}
	
}
