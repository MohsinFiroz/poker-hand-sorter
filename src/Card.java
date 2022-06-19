
public class Card implements Comparable<Card> {
	private int rank;
	private char suit;

	public Card(String card) {
		char r = card.charAt(0);
		switch (r) {
		case 'T':
			this.rank = 10;
			break;
		case 'J':
			this.rank = 11;
			break;
		case 'Q':
			this.rank = 12;
			break;
		case 'K':
			this.rank = 13;
			break;
		case 'A':
			this.rank = 14;
			break;
		default:
			this.rank = Character.getNumericValue(r);
			break;
		}
		this.suit = card.charAt(1);
	}

	public int getRank() {
		return rank;
	}

	public char getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card c) {
		int compareRank = ((Card) c).getRank();
		return this.rank - compareRank;
	}
}
