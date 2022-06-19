package utils;

public enum HandCombination {

	HIGH_CARD(1, "HIGH_CARD"), PAIR(2, "PAIR"), TWO_PAIRS(3, "TWO_PAIRS"), THREE_OF_A_KIND(4, "THREE_OF_A_KIND"),
	STRAIGHT(5, "STRAIGHT"), FLUSH(6, "FLUSH"), FULL_HOUSE(7, "FULL_HOUSE"), FOUR_OF_A_KIND(8, "FOUR_OF_A_KIND"),
	STRAIGHT_FLUSH(9, "STRAIGHT_FLUSH"), ROYAL_FLUSH(10, "ROYAL_FLUSH");

	private int rank;
	private String comb;

	private HandCombination(int rank, String comb) {
		this.rank = rank;
		this.comb = comb;
	}

	public int getRank() {
		return rank;
	}

	public String getComb() {
		return comb;
	}

}
