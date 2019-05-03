package com.adaptionsoft.games.uglytrivia;

public class Game {
	private final CategorySelector categorySelector = new CategorySelector();
	Players players = new Players();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    int currentPlayer = 0;
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
		System.out.println(players.getNameByIndex(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.getNameByIndex(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
				
				System.out.println(players.getNameByIndex(currentPlayer)
						+ "'s new location is " 
						+ places[currentPlayer]);
				System.out.println("The category is " + categorySelector.categoryFor(places[currentPlayer]));
				askQuestion();
			} else {
				System.out.println(players.getNameByIndex(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			System.out.println(players.getNameByIndex(currentPlayer)
					+ "'s new location is " 
					+ places[currentPlayer]);
			System.out.println("The category is " + categorySelector.categoryFor(places[currentPlayer]));
			askQuestion();
		}
		
	}

	private void askQuestion() {
		String category = categorySelector.categoryFor(places[currentPlayer]);
		System.out.println(questionPool.questionFor(category));
	}


    public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.getNameByIndex(currentPlayer)
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.numberOfPlayers()) currentPlayer = 0;

				players.next();
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.numberOfPlayers()) currentPlayer = 0;

				players.next();

				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.getNameByIndex(currentPlayer)
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.numberOfPlayers()) currentPlayer = 0;

			players.next();

			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.getNameByIndex(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.numberOfPlayers()) currentPlayer = 0;

		players.next();
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}

}
