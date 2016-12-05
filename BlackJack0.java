import java.util.Scanner;
import java.util.*;
public class BlackJack0{
	public static void main(String[] args){
		boolean blackJack = false;
		boolean dealerBust = false;
		boolean bust = false;
		int cards = 52;
		final int suits = 4;
		int drawCardsSuits = cards/suits;
		Scanner sc = new Scanner(System.in);
		boolean gameOn = true;
		//while gameOn is true, the player will continue to be prompted via terminal
		while(gameOn){
			System.out.println("How many decks would you like to play with?");
			int decks = sc.nextInt();
			ArrayList<Cards> totalCards = new ArrayList<Cards>(52*decks);
		
			//Initializing every cards object in ArrayList totalCards
			for(int i = 0; i < suits; i++){
				for(int n = 0; n < drawCardsSuits*decks; n++){
					int cardNumber = (n%13) + 1;
					Cards holder = new Cards(cardNumber,i);
					totalCards.add(holder);
				}
			}
			
			System.out.println("How many Players are there?:");
			int players = sc.nextInt();
			int rand1 = (int)(Math.random()* totalCards.size());
			int playerTotal = totalCards.get(rand1).getCardNumber();
			
			System.out.print("Your cards are: " + totalCards.get(rand1).getCardNumber() + 
			" of " + totalCards.remove(rand1).getSuit());
			
			int rand2 = (int)(Math.random()* totalCards.size());
			playerTotal += totalCards.get(rand2).getCardNumber();
			
			System.out.println(" and " + totalCards.get(rand2).getCardNumber() 
			+ " of " + totalCards.remove(rand2).getSuit() + " for a total of " + playerTotal);
			
			System.out.println("would you like to hit or stay? (Press 1 to hit and 0 to stay)");
			boolean hit;
			int hitCheck = sc.nextInt();
			if(hitCheck == 1){
				hit = true;
			}
			else{
				hit = false;
			}
			while(hit){ //Continues to prompt the user as to whether they want to hit or stay.
				int rand3 = (int)(Math.random()* totalCards.size());
				playerTotal += totalCards.get(rand3).getCardNumber();
				if(totalCards.get(rand3).isAFaceCard()){
					System.out.println("You just got a " + totalCards.get(rand3).getFaceCard()
					+ " of " + totalCards.remove(rand3).getSuit() + " for a total"+ " of " + playerTotal);
				}
				else{
				
					System.out.println("You just got a " + totalCards.get(rand3).getCardNumber()
					+ " of " + totalCards.remove(rand3).getSuit() + " for a total of " + playerTotal);
				
				if(playerTotal > 21){ //Checks for Bust
					System.out.println("You have Busted!");
					hit = false;
					bust = true;
				}
				else if(playerTotal == 21){ //Checks for BlackJack
					System.out.println("You have reached BlackJack!");
					hit = false;
					blackJack = true;
				}
				else{ //Prompting if not bust or BlackJack
					int hitCheck1 = sc.nextInt();
					if(hitCheck1 == 1){
						hit = true;
					}
					else{
						hit = false;
					}
				}
			}//End while(hit){
			int dealerTotal = 0;
			if(!blackJack){
				if(!bust){
					System.out.println("Now the Dealer will play!");
					while(dealerTotal < 17){
						int rand4 = (int)(Math.random()*totalCards.size());
						dealerTotal += totalCards.remove(rand4).getCardNumber();
					}
				}
				if(dealerTotal > 21){
					dealerBust = true;
				}
				if(!bust){
					if(!dealerBust){
						if(dealerTotal <= playerTotal){
							System.out.println("The dealer's total was " + dealerTotal + 
							", and your total was " + playerTotal + ", so you win!");
						}
						else if(dealerTotal > playerTotal){
							System.out.println("The dealer's total was " + dealerTotal + 
							", and your total was " + playerTotal + ", so you lose!");
						}
					}//End if(!dealerBust){
					else
						System.out.println("The dealer has busted with a total of " + dealerTotal + "! You win!");
				}//End if(!bust){
			}//End if(!blackJack){
			System.out.println("Would you like to play again? (1 for yes 0 for no)");
			int again = sc.nextInt();
			if(again == 1)
				gameOn = true;
			else
				gameOn = false;
		}//End while(gameOn){
	}//End main(String[] args){
}//End Class BlackJack0{
