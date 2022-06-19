import java.util.Arrays;

import utils.HandCombination;

public class Hand {
	public Card[] cards;

	public HandCombination combination;

	public int handRank;

	public Hand(Card[] cards) {
		this.cards = cards;
	}

	public Hand(String[] handArr) {

		Card[] cards = new Card[5];
		for (int i = 0; i < 5; i++) {
			cards[i] = new Card(handArr[i]);
		}
		this.cards = cards;
	}

	public void sortCards() {
		Arrays.sort(this.cards);
	}

	public Card getCard(int index) {
		return cards[index];
	}

	public HandCombination getHandCategory() {
		return this.combination;
	}

	public Integer getHandRank() {
		return this.handRank;

	}

	public void check() {

		if (this.isAllSameSuit() && this.isStraight()) {
			if (this.getCard(0).getRank() == 10) {
				this.combination = HandCombination.ROYAL_FLUSH;
				this.handRank = Integer.MAX_VALUE;
				return;
			} else {
				this.combination = HandCombination.STRAIGHT_FLUSH;
				return;
			}
		}

		if (this.isFour()) {
			this.combination = HandCombination.FOUR_OF_A_KIND;
			return;
		}

		if (this.isFullHouse()) {
			this.combination = HandCombination.FULL_HOUSE;
			return;
		}

		if (this.isAllSameSuit()) {
			this.combination = HandCombination.FLUSH;
			return;
		}

		if (this.isStraight()) {
			this.combination = HandCombination.STRAIGHT;
			return;
		}

		if (this.isThree()) {
			this.combination = HandCombination.THREE_OF_A_KIND;
			return;
		}

		if (this.isTwoPairs()) {
			this.combination = HandCombination.TWO_PAIRS;
			return;
		}

		if (this.isPair()) {
			this.combination = HandCombination.PAIR;
			return;
		}

		this.handRank = this.getCard(4).getRank();
		this.combination = HandCombination.HIGH_CARD;
	}

	private boolean isPair() {
		int last = this.cards[4].getRank();
		int total = 0, numberOfCards = 1;

		for (int i = 3; i >= 0; i--) {
			if (this.cards[i].getRank() == last) {
				total += this.cards[i].getRank();
				numberOfCards++;
			}

			if (numberOfCards == 2) {
				break;
			}
			last = this.cards[i].getRank();
		}

		if (numberOfCards == 2) {
			this.handRank = total;
			return true;
		}
		return false;
	}

	private boolean isTwoPairs() {
		int last = this.cards[4].getRank();
		int i = 3, total = 0, numberOfCards = 1;

		for (; i >= 0; i--) {
			if (this.cards[i].getRank() == last) {
				total += this.cards[i].getRank();
				numberOfCards++;
			}

			if (numberOfCards == 2) {

				break;
			} else {
				total = 0;
				numberOfCards = 1;
			}
			last = this.cards[i].getRank();
		}

		if (numberOfCards == 2 && i > 0) {
			numberOfCards = 1;
			last = this.cards[i - 1].getRank();
			for (i = i - 2; i >= 0; i--) {
				if (this.cards[i].getRank() == last) {
					total += this.cards[i].getRank();
					numberOfCards++;
				}
				if (numberOfCards == 2) {
					break;
				} else {
					total = 0;
					numberOfCards = 1;
				}
				last = this.cards[i].getRank();
			}
		} else {
			return false;
		}

		if (numberOfCards == 2) {
			this.handRank = total;
			return true;
		}
		return false;
	}

	private boolean isThree() {
		int last = this.cards[4].getRank();
		int total = 0, numberOfCards = 1;

		for (int i = 3; i >= 0; i--) {
			if (this.cards[i].getRank() == last) {
				total += this.cards[i].getRank();
				numberOfCards++;
			} else {
				total = 0;
				numberOfCards = 1;
			}

			last = this.cards[i].getRank();
		}

		if (numberOfCards == 3) {
			this.handRank = total;
			return true;
		}
		return false;
	}

	private boolean isFullHouse() {
		boolean checked = false;
		int last = this.cards[4].getRank();
		int total = 0, numberOfCards = 1;

		for (int i = 3; i >= 0; i--) {
			if (this.cards[i].getRank() == last) {
				total += this.cards[i].getRank();
				numberOfCards++;

			} else if (checked == false) {
				checked = true;
				if (numberOfCards < 2) {
					this.handRank = -1;
					return false;
				}

				if (numberOfCards == 3)
					this.handRank = total;

			} else {
				this.handRank = -1;
				return false;
			}
			last = this.cards[i].getRank();
		}
		this.handRank = total;
		return true;

	}

	private boolean isFour() {

		int last = this.cards[4].getRank();
		int total = 0, numberOfCards = 1;

		for (int i = 3; i >= 0 && numberOfCards < 4; i--) {
			if (this.cards[i].getRank() == last) {
				total += this.cards[i].getRank();
				numberOfCards++;
			} else {
				total = 0;
				numberOfCards = 1;
			}

			last = this.cards[i].getRank();
		}

		if (numberOfCards == 4) {
			this.handRank = total;
			return true;
		}
		return false;
	}

	private boolean isAllSameSuit() {

		char last = this.cards[0].getSuit();
		int total = this.cards[0].getRank();

		for (int i = 1; i < 5; i++) {
			if (this.cards[i].getSuit() != last) {
				return false;
			}
			total += this.cards[i].getRank();
			last = this.cards[i].getSuit();
		}
		this.handRank = total;
		return true;
	}

	private boolean isStraight() {

		int last = this.cards[0].getRank();
		int total = last;
		for (int i = 1; i < 5; i++) {
			if (this.cards[i].getRank() != last + 1) {
				return false;
			}
			last = this.cards[i].getRank();
			total += 1;
		}
		this.handRank = total;
		return true;
	}
}