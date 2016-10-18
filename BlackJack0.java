import java.util.Scanner;
public class BlackJack0{
	public static void main(String[] args){
		int cards = 52;
		final int suits = 4;
		int drawCardsSuits = cards/suits;
		Scanner sc = new Scanner(System.in);
		boolean gameOver = false;
		
		System.out.println("How many decks would you like to play with?");
		
		int decks = sc.nextInt();
		Cards[] deckCards = new Cards[decks * cards];
		int suitCards = deckCards.length / 4;
		for(int i = 0; i < suitCards; i++){ //Initialize first suit of cards
			deckCards[i] = new Cards((i % 13) + 1, 0);
		}
		for(int i = 0; i < suitCards; i++){
			deckCards[i + suitCards] = new Cards((i % 13) + 1, 1);
		}
		for(int i = 0; i < suitCards; i++){
			deckCards[i + 2 * suitCards] = new Cards((i % 13) + 1, 2);
		}
		for(int i = 0; i < suitCards; i++){
			deckCards[i + 3 * suitCards] = new Cards((i % 13) + 1, 3);
		}
		
		System.out.println("How many players are there? (Maximum of 5)");
		int players = sc.nextInt();
		while(players > 5 || players < 1){
			System.out.println("Maximum of 5 and at least one player");
			players = sc.nextInt();
		}
		Player[] x = new Player[players];
		for(int i = 0; i < x.length; i++){
			int drawRand = (int)(Math.random() * deckCards.length);
			int drawRand2 = (int)(Math.random() * deckCards.length);
			while(deckCards[drawRand] == null || deckCards[drawRand] == deckCards[drawRand2])
				drawRand = (int)(Math.random() * deckCards.length);
			while(deckCards[drawRand2] == null || deckCards[drawRand] == deckCards[drawRand2])
				drawRand2 = (int)(Math.random() * deckCards.length);
			x[i] = new Player(deckCards[drawRand].getCardNumber(), 
					deckCards[drawRand2].getCardNumber());
			if(deckCards[drawRand2].isAFaceCard() && deckCards[drawRand].isAFaceCard()){
				System.out.println("Player " + (i + 1) + " has a "
						+ deckCards[drawRand].getFaceCard() + " of "
						+ deckCards[drawRand].getSuit() + " and a "
						+ deckCards[drawRand2].getFaceCard() + " of "
						+ deckCards[drawRand2].getSuit() + " for a total of "
						+ (deckCards[drawRand].getCardNumber() + deckCards[drawRand2].getCardNumber()));
				deckCards[drawRand] = null;
				deckCards[drawRand2] = null;
			}
			else if(deckCards[drawRand].isAFaceCard()){
				System.out.println("Player " + (i + 1) + " has a "
						+ deckCards[drawRand].getFaceCard() + " of "
						+ deckCards[drawRand].getSuit() + " and a "
						+ deckCards[drawRand2].getCardNumber() + " of "
						+ deckCards[drawRand2].getSuit() + " for a total of "
						+ (deckCards[drawRand].getCardNumber() + deckCards[drawRand2].getCardNumber()));
				deckCards[drawRand] = null;
				deckCards[drawRand2] = null;
			}
			else if(deckCards[drawRand2].isAFaceCard()){
				System.out.println("Player " + (i + 1) + " has a "
						+ deckCards[drawRand].getCardNumber() + " of "
						+ deckCards[drawRand].getSuit() + " and a "
						+ deckCards[drawRand2].getFaceCard() + " of "
						+ deckCards[drawRand2].getSuit() + " for a total of "
						+ (deckCards[drawRand].getCardNumber() + deckCards[drawRand2].getCardNumber()));
				deckCards[drawRand] = null;
				deckCards[drawRand2] = null;
			}
			else{
				System.out.println("Player " + (i + 1) + " has a "
					+ deckCards[drawRand].getCardNumber() + " of "
					+ deckCards[drawRand].getSuit() + " and a "
					+ deckCards[drawRand2].getCardNumber() + " of "
					+ deckCards[drawRand2].getSuit() + " for a total of "
					+ (deckCards[drawRand].getCardNumber() + deckCards[drawRand2].getCardNumber()));
			deckCards[drawRand] = null;
			deckCards[drawRand2] = null;
			}
		}
		deckCards = Cards.shuffle(deckCards);
	}
}
