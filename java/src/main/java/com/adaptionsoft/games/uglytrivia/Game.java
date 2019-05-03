package com.adaptionsoft.games.uglytrivia;

public class Game {
	private final CategorySelector categorySelector = new CategorySelector();
	Players players = new Players();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

	boolean isGettingOutOfPenaltyBox;
	private final QuestionPool questionPool;

	public  Game(){
		questionPool = new QuestionPool("Pop", "Science", "Sports", "Rock");
	}

	public boolean add(String playerName) {
	    players.add(new Player(playerName));
		places[players.numberOfPlayers()] = 0;
		purses[players.numberOfPlayers()] = 0;
		inPenaltyBox[players.numberOfPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.numberOfPlayers());
		return true;
	}

	public void roll(int roll) {
		System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex()) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[players.getCurrentPlayerIndex()]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex()) + " is getting out of the penalty box");
				places[players.getCurrentPlayerIndex()] = places[players.getCurrentPlayerIndex()] + roll;
				if (places[players.getCurrentPlayerIndex()] > 11) places[players.getCurrentPlayerIndex()] = places[players.getCurrentPlayerIndex()] - 12;
				
				System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex())
						+ "'s new location is " 
						+ places[players.getCurrentPlayerIndex()]);
				System.out.println("The category is " + categorySelector.categoryFor(places[players.getCurrentPlayerIndex()]));
				askQuestion();
			} else {
				System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex()) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[players.getCurrentPlayerIndex()] = places[players.getCurrentPlayerIndex()] + roll;
			if (places[players.getCurrentPlayerIndex()] > 11) places[players.getCurrentPlayerIndex()] = places[players.getCurrentPlayerIndex()] - 12;
			
			System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex())
					+ "'s new location is " 
					+ places[players.getCurrentPlayerIndex()]);
			System.out.println("The category is " + categorySelector.categoryFor(places[players.getCurrentPlayerIndex()]));
			askQuestion();
		}
		
	}

	private void askQuestion() {
		String category = categorySelector.categoryFor(places[players.getCurrentPlayerIndex()]);
		System.out.println(questionPool.questionFor(category));
	}


    public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[players.getCurrentPlayerIndex()]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[players.getCurrentPlayerIndex()]++;
				System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex())
						+ " now has "
						+ purses[players.getCurrentPlayerIndex()]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();

				players.next();
				
				return winner;
			} else {
				players.next();

				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[players.getCurrentPlayerIndex()]++;
			System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex())
					+ " now has "
					+ purses[players.getCurrentPlayerIndex()]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();

			players.next();

			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.getNameByIndex(players.getCurrentPlayerIndex())+ " was sent to the penalty box");
		inPenaltyBox[players.getCurrentPlayerIndex()] = true;

		players.next();
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[players.getCurrentPlayerIndex()] == 6);
	}

}
