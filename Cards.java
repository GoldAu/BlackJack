public class Cards{
	private int cardNumber;
	private int cardSuit;
	private String faceCard;
	private boolean faceCardNumber = false;
	public Cards(int x, int y){
		if(x == 11){
			faceCardNumber = true;
			x = 10;
			faceCard = "Jack";	
		}
		else if(x == 12){
			faceCardNumber = true;
			x = 10;
			faceCard = "Queen";
		}
		else if(x == 13){
			faceCardNumber = true;
			x = 10;
			faceCard = "King";
		}
		else{
			cardNumber = x;
			faceCard = "";
		}
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
	public String getFaceCard(){
		if (faceCardNumber)
			return faceCard;
		else
			return faceCard;
	}
	public int getCardNumber(){
		return cardNumber;
	}
	public boolean isAFaceCard(){
		return faceCardNumber;
	}
	public static Cards[] shuffle(Cards[] x){
		Cards[] y = new Cards[x.length];
		int suitCards = y.length / 4;
		for(int i = 0; i < suitCards; i++){ //Initialize first suit of cards
			y[i] = new Cards((i % 10) + 1, 0);
		}
		for(int i = 0; i < suitCards; i++){
			y[i + suitCards] = new Cards((i % 10) + 1, 1);
		}
		for(int i = 0; i < suitCards; i++){
			y[i + 2 * suitCards] = new Cards((i % 10) + 1, 2);
		}
		for(int i = 0; i < suitCards; i++){
			y[i + 3*suitCards] = new Cards((i % 10) + 1, 3);
		}
		return y;
	}
}
