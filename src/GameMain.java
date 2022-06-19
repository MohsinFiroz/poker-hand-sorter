import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameMain {

	private static BufferedReader br;

	public static void main(String[] args) {
		int playerOne = 0;
		int playerTwo = 0;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String input = br.readLine();
				if (input == null) {
					break;
				}

				String[] cards = input.split(" ");
				String[] one = Arrays.copyOfRange(cards, 0, 5);
				String[] two = Arrays.copyOfRange(cards, 5, 10);

				Hand handOne = new Hand(one);
				Hand handTwo = new Hand(two);

				handOne.sortCards();
				handTwo.sortCards();

				handOne.check();
				handTwo.check();
				int res = pickWinner(handOne, handTwo);
				if (res == 1) {
					playerOne++;
				} else if (res == 2) {
					playerTwo++;
				} else {
					System.out.println("Tie");
				}
			}

			System.out.println("Player 1: " + playerOne);
			System.out.println("Player 2: " + playerTwo);

			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// checking winner including tie
	public static int pickWinner(Hand hand1, Hand hand2) {

		if (hand1.getHandCategory().getRank() > hand2.getHandCategory().getRank()) {
			return 1;
		} else if (hand1.getHandCategory().getRank() < hand2.getHandCategory().getRank()) {
			return 2;
		} else if (hand1.getHandRank() > hand2.getHandRank()) {
			return 1;
		} else if (hand1.getHandRank() < hand2.getHandRank()) {
			return 2;
		} else {
			for (int i = 4; i >= 0; i--) {
				if (hand1.getCard(i).getRank() > hand2.getCard(i).getRank()) {
					return 1;
				} else if (hand1.getCard(i).getRank() < hand2.getCard(i).getRank()) {
					return 2;
				}
			}
			return -1;
		}

	}
}
