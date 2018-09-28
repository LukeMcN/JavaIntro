	/*
	 * LukeMcNair 27/09/2018
	 * Version 2.1 of pontoon
	 */

	package pontoonV2;

	import java.util.Scanner;

	public class Card 
	{
		Scanner kboard = new Scanner(System.in);
		
		private int card1;			// declarations
		private int card2;
		private int total;
		private int cardNew;
		private int dealerCard1;
		private int dealerCard2;
		private int dealerTotal;
		private String choice;
		
		
		public Card() // constructor
		{
			this.getcard1Value();
			this.getcard2Value();
			this.getDealerCard();
		}
		
		public void display() // displays the game in progress
		{
			System.out.println("Your cards are " +card1+ " and " +card2+".");
			total = card1 + card2;
			System.out.println("Your total is " +total+".");
			System.out.println("Would you like a new card? Y/N");
			choice = kboard.next();	
			if (choice.equalsIgnoreCase("y"))
			{
				do
				{
					this.getcardNewValue();
					this.getTotal();				
					System.out.println("Would you like a new card? Y/N");
					choice = kboard.next();	
					if ((choice.equalsIgnoreCase("y")) && total>21)
					{
						System.out.println("You cannot take a card if your total is above 21.");
					}
				}while ((choice.equalsIgnoreCase("y")) && total<22); // runs the loop as long as the player is below 22 or has chosen to stay on their number
			}
			if (choice.equalsIgnoreCase("n") || total>21)
			{
				if ((dealerTotal<total)&&(total<22))
				{
					do
					{
						this.getDealerTotal();
					}while ((dealerTotal<total) && (total<22)); // lets the dealer 'draw' until they have matched or beat the player, or gone bust
				}
				
				this.getCheckWin(); // checks the win condition based on the players and dealers cards
			}
		}
		
		public void getcard1Value() // generates 1st player card
		{
			card1 = (int)(Math.random()*10)+1;
		}
		
		public void getcard2Value() // generates 2nd player card
		{
			card2 = (int)(Math.random()*10)+1;
		}
		
		public void getcardNewValue() // generates a new card if the player wants one
		{
			cardNew = (int)(Math.random()*10)+1;
			System.out.println("Your new card is " +cardNew);
		}	
		
		public void getTotal() // finds the total for the player
		{
			total = total + cardNew;
			System.out.println("Your total is " +total+".");
		}
		
		public void getDealerCard() // finds the dealers original hand
		{
			dealerCard1 = (int)(Math.random()*10)+1;
			dealerCard2 = (int)(Math.random()*10)+1;
			dealerTotal = dealerCard1 + dealerCard2;
		}
		
		public void getDealerTotal() // 'draws' a new card for the dealer
		{
			int dealernewCard = (int)(Math.random()*10)+1;
			dealerTotal = dealerTotal + dealernewCard;
		}
		
		public void getCheckWin() // determines who wins the game
		{
			if (total>21)
			{
				System.out.println("You are bust. You lose.");
			}
			else if (total == dealerTotal)
			{
				System.out.println("You both have the same card. Dealer wins on a draw.");
			}
			else if ((total>21) && dealerTotal>21)
			{
				System.out.println("you are both bust. Dealer wins on a draw.");
			}
			else if ((total<dealerTotal) && (dealerTotal < 22))
			{
				System.out.println("Dealer has " +dealerTotal+ ". You lose.");
			}
			else if ((total>dealerTotal) && (total<22))
			{
				System.out.println("Dealer has " +dealerTotal+ ". You win.");
			}
			else if ((dealerTotal>21) &&  (total < 22))
			{
				System.out.println("Dealer is bust on " +dealerTotal+ ", and you are not. You win.");
			}
		}
	}

