public class Cards{
	private int cardNumber;
	private int cardSuit;
	public Cards(int x, int y){
		cardNumber = x;
		cardSuit = y;
	}
	public String getSuit(){
		if(cardSuit == 0)
			return "Hearts";
		else if(cardSuit == 1)
			return "Diamonds";
		else if(cardSuit == 2)
			return "Clubs";
		else
			return "Spades";
	}
	public int getCardNumber(){
		return cardNumber;
	}
}
