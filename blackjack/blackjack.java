import java.util.*;
import java.io.*;

public class blackjack {
	public static int magicCounter = 0;
	public static ArrayList<Integer> deck = new ArrayList<Integer>();
	public static int[] player = new int[2];
	public static int[] dealer = new int[3];
	public static Random rand = new Random();
	public static void main(String args[]) throws IOException {
		populateDeck();
		//displayDeck();
		//System.out.println(getInput());
		setupGame();
		displayGame();
		//displayDeck();
		playerPlay();
		if(player[0] == 21) {
			System.out.println("Congratz, you hit 21, you win!");
			return;
		}
		if(player[0] > 21) {
			System.out.println("You lose.");
			return;
		}
		dealerPlay();
		if(dealer[0]>21) {
			System.out.println("Dealer went bust! You win!");
			return;
		}
		if(player[0] > dealer[0]) {
			System.out.println("Your total is higher than the dealer's, you win!");
			return;
		}
		System.out.println("You lose.");
	}

	public static void dealerPlay() {
		dealer[0]+=dealer[2];
		displayGame();
		while((dealer[0]<17)||((dealer[0]==17)&&(dealer[1]>0))) {
			int[] temp = new int[2];
			temp = draw();
			dealer[0]+=temp[0];
			dealer[1]+=temp[1];
			displayGame();
			if((dealer[0]>21)&&(dealer[1]>0)) {
				dealer[0]-=10;
				dealer[1]--;
			}
		}
	}

	public static void playerPlay() throws IOException {
		char choice;
		System.out.println("It is your turn you will be asked to hit or stay until your turn is over, only respond to the prompts with either an h for hit, or an s to stay.\nYour total is "+player[0]+" do you hit or stay?");
		choice = getInput();
		while(choice == 'h') {
			int[] temp = new int[2];
			temp = draw();
			player[0]+=temp[0];
			player[1]+=temp[1];
			if(player[0]>21 && player[1]>0) {
				player[0]-=10;
				player[1]--;
			}
			displayGame();
			if(player[0]>21)
				return;
			System.out.println("Your total is now "+player[0]+" do you hit or stay?");
			choice = getInput();
		}
		magicCounter+=100;
	}		
	public static int[] draw() {
		int[] returnMe = new int[2];
		returnMe[0] = deck.remove(rand.nextInt(deck.size()));
		if(magicCounter==0 || magicCounter==2 || (magicCounter>3 && magicCounter<100))
			System.out.println("You drew "+returnMe[0]);
		if(magicCounter==3 || magicCounter>99)
			System.out.println("Dealer drew "+returnMe[0]);
		if(magicCounter==1)
			System.out.println("Dealer drew a card which will remain face down until you end your turn.");
		if (returnMe[0] == 11)
			returnMe[1]++;
		magicCounter++;
		return returnMe;
	}
	public static void setupGame() {
		int[] temp = new int[2];
		temp = draw();
		player[0]+=temp[0];
		player[1]+=temp[1];
		temp = draw();
		dealer[2]+=temp[0];
		dealer[1]+=temp[1];
		temp = draw();
		player[0]+=temp[0];
		player[1]+=temp[1];
		temp = draw();
		dealer[0]+=temp[0];
		dealer[1]+=temp[1];
	}
	public static void displayGame() {
		System.out.println("The dealer has a total of "+dealer[0]+" face up.");
		System.out.println("The player has a total of "+player[0]+" and has "+player[1]+" high aces.");
		//for debug:
		//System.out.println(dealer[0]+" "+dealer[1]+" "+dealer[2]);
	}

	public static void populateDeck() {
		for(double d= 2.0; d<12; d+=.25)
			deck.add((int)d);
		for(int i = 0; i<12; i++)
			deck.add(10);
	}
	public static void displayDeck() {
		int deckDisplay[] = new int[12];
		for(int i = 0; i<deck.size(); i++)
			deckDisplay[deck.get(i)]++;
		for(int i = 2; i<deckDisplay.length; i++)
			System.out.print(deckDisplay[i]+" ");
		System.out.println();
		System.out.println("2 3 4 5 6 7 8 9 10 A");
	}
	public static char getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char a = (char)br.read();
		return a;
	}
}
