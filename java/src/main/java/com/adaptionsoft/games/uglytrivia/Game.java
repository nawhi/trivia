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
		int numberOfPlayers = players.numberOfPlayers();
		places[numberOfPlayers] = 0;
		purses[numberOfPlayers] = 0;
		inPenaltyBox[numberOfPlayers] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + numberOfPlayers);
		return true;
	}

	public void roll(int roll) {
		int currentPlayerIndex = players.getCurrentPlayerIndex();
		String currentPlayerName = players.getNameByIndex(currentPlayerIndex);
		System.out.println(currentPlayerName + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayerIndex]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayerName + " is getting out of the penalty box");
				places[currentPlayerIndex] = places[currentPlayerIndex] + roll;
				if (places[currentPlayerIndex] > 11) places[currentPlayerIndex] = places[currentPlayerIndex] - 12;
				
				System.out.println(currentPlayerName
						+ "'s new location is " 
						+ places[currentPlayerIndex]);
				System.out.println("The category is " + categorySelector.categoryFor(places[currentPlayerIndex]));
				askQuestion();
			} else {
				System.out.println(currentPlayerName + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayerIndex] = places[currentPlayerIndex] + roll;
			if (places[currentPlayerIndex] > 11) places[currentPlayerIndex] = places[currentPlayerIndex] - 12;
			
			System.out.println(currentPlayerName
					+ "'s new location is " 
					+ places[currentPlayerIndex]);
			System.out.println("The category is " + categorySelector.categoryFor(places[currentPlayerIndex]));
			askQuestion();
		}
		
	}

	private void askQuestion() {
		String category = categorySelector.categoryFor(places[players.getCurrentPlayerIndex()]);
		System.out.println(questionPool.questionFor(category));
	}


    public boolean wasCorrectlyAnswered() {
		int currentPlayerIndex = players.getCurrentPlayerIndex();
		if (inPenaltyBox[currentPlayerIndex]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				incrementPurse(currentPlayerIndex);

				boolean winner = didPlayerWin();

				players.next();
				
				return winner;
			} else {
				players.next();

				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			incrementPurse(currentPlayerIndex);

			boolean winner = didPlayerWin();

			players.next();

			return winner;
		}
	}

	private void incrementPurse(int currentPlayerIndex) {
		purses[currentPlayerIndex]++;
		System.out.println(players.getNameByIndex(currentPlayerIndex)
				+ " now has "
				+ purses[currentPlayerIndex]
				+ " Gold Coins.");
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
