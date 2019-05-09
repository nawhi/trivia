package com.adaptionsoft.games.uglytrivia;

public class Game {
	final Board board = new Board();
	private final CategorySelector categorySelector = new CategorySelector();
	Players players = new Players();
	boolean[] inPenaltyBox  = new boolean[6];

	boolean isGettingOutOfPenaltyBox;
	private final QuestionPool questionPool;
	private Board newBoard;
	private boolean started = false;

	public  Game(){
		questionPool = new QuestionPool("Pop", "Science", "Sports", "Rock");
	}

	public boolean add(String playerName) {
	    players.add(new Player(playerName));
		int numberOfPlayers = players.numberOfPlayers();
		board.initialisePlayerAt(numberOfPlayers);
		inPenaltyBox[numberOfPlayers] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + numberOfPlayers);
		return true;
	}

	private void start() {
		newBoard = new Board(players.asArray());
		started = true;
	}

	public void roll(int roll) {
		if (!started) start();
		int currentPlayerIndex = players.getCurrentPlayerIndex();
		String currentPlayerName = players.getNameByIndex(currentPlayerIndex);
		System.out.println(currentPlayerName + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayerIndex]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayerName + " is getting out of the penalty box");
				board.movePlayer(roll, currentPlayerIndex);

				System.out.println(currentPlayerName
						+ "'s new location is " 
						+ board.getPlayerPlace(currentPlayerIndex));
				System.out.println("The category is " + categorySelector.categoryFor(board.getPlayerPlace(currentPlayerIndex)));
				askQuestion();
			} else {
				System.out.println(currentPlayerName + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {

			board.movePlayer(roll, currentPlayerIndex);

			System.out.println(currentPlayerName
					+ "'s new location is " 
					+ board.getPlayerPlace(currentPlayerIndex));
			System.out.println("The category is " + categorySelector.categoryFor(board.getPlayerPlace(currentPlayerIndex)));
			askQuestion();
		}
		
	}

	private void askQuestion() {
		String category = categorySelector.categoryFor(board.getPlayerPlace(players.getCurrentPlayerIndex()));
		System.out.println(questionPool.questionFor(category));
	}


    public boolean wasCorrectlyAnswered() {
		int currentPlayerIndex = players.getCurrentPlayerIndex();
		if (inPenaltyBox[currentPlayerIndex]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				incrementPurse();

				boolean winner = didPlayerWin();

				players.next();
				
				return winner;
			} else {
				players.next();

				return true;
			}

		} else {
		
			System.out.println("Answer was corrent!!!!");
			incrementPurse();

			boolean winner = didPlayerWin();

			players.next();

			return winner;
		}
	}

	private void incrementPurse() {
		Player currentPlayer = players.getCurrent();
		currentPlayer.incrementPurse();

		System.out.println(currentPlayer.getName()
				+ " now has "
				+ currentPlayer.getPurse()
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
		return (players.getCurrent().getPurse() != 6);
	}

}
