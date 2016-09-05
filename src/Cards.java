// This class holds the suit names, face names, and values of the cards.
public class Cards {
	
	// Initializes the suit, face, and value arrays. To make coding easier, the first element (index 0) has been assigned an empty String and integer
	private static final String[] suit = {"", "Hearts", "Diamonds", "Clubs", "Spades"};
	private static final String[] face = {"", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private static int[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	// Returns the suit name
	public static String returnSuit(int index) {
		return suit[index];
	}
	
	// Returns the face name;
	public static String returnFace(int index) {
		return face[index];
	}
	
	// Returns the face value
	public static int returnValue(int index) {
		return value[index];
	}

}
