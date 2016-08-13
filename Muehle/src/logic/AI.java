package logic;

import entity.Board;

public class AI {
	private String difficulty = null;

	public AI(String difficulty) {
		if (difficulty == "easy") {
			this.difficulty = difficulty;
		} else if (difficulty == "medium") {
			this.difficulty = difficulty;
		} else if (difficulty == "hard") {
			this.difficulty = difficulty;
		} else {
			System.out.println("Wrong difficulty Parameter");
		}
	}

	public void makeAiMove(Board board) {
		if (difficulty == "easy") {
			easyMove(board);
		} else if (difficulty == "medium") {
			mediumMove(board);
		} else if (difficulty == "hard") {
			hardMove(board);
		} else {
			
		}
	}
	private void easyMove(Board board) {
		//random stupid moves
	}
	
	private void mediumMove(Board board) {
		//mills evaluation
	}

	private void hardMove(Board board) {
		//minmax algorithm
	}

}
