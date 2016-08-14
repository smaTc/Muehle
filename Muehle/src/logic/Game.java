package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entity.Board;
import entity.Field;
import entity.Mill;
import entity.Player;
import entity.Team;

public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private boolean activeGame;
	private Move move;
	private Player currentPlayer;
	private Player enemyPlayer;
	private BufferedReader input;

	public Game() {
		this.activeGame = true;
		this.board = new Board();
		input = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Name for Player 1: ");
			this.player1 = new Player(input.readLine(), Team.BLACK, 9, 0);
			System.out.print("Name for Player 2: ");
			this.player2 = new Player(input.readLine(), Team.WHITE, 9, 0);
		} catch (IOException e) {
			System.out.println("\n Nice try asshole...again!");
		}
		this.currentPlayer = player1;
		this.enemyPlayer = player2;
		this.move = new Move();
	}

	public Game(String name1, String name2) {
		this.activeGame = true;
		this.board = new Board();
		this.player1 = new Player(name1, Team.BLACK, 9, 0);
		this.player2 = new Player(name2, Team.WHITE, 9, 0);
		this.currentPlayer = player1;
		this.move = new Move();
	}

	public void play() {
		testGame();
		while (this.activeGame) {
			gameStatus();
			nextRound();
		}
	}

	public void gameStatus() {
		System.out.println("\nIt is " + currentPlayer.getName() + "'s turn!\nTeam: " + currentPlayer.getTeam()
				+ "\nStones to set: " + currentPlayer.getStonesToSet() + "\nStones on Field: "
				+ currentPlayer.getStonesOnField() + "\n");
		board.showCurrentBoard();

	}

	public void nextRound() {
		if ((this.player1.getStonesToSet() > 0 || this.player2.getStonesToSet() > 0)) {
			setStones();
		} else {
			if (this.player1.getStonesOnField() > 2 && this.player2.getStonesOnField() > 2) {
				makeMove();
			} else {
				if (player1.getStonesOnField() >= 3)
					System.out.println(player1.getName() + " won!\n\n");
				else
					System.out.println(player2.getName() + " won!\n\n");
				this.activeGame = false;
			}
		}
		checkMills();
		nextPlayer();
	}

	public void makeMove() {
		System.out.print("Type your move(X1,Y1,X2,Y2): ");
		String move = null;
		try {
			move = input.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String[] stringArr = move.split(",");
		int coordinates[] = new int[4];
		try {
			coordinates[0] = Integer.parseInt(stringArr[0]);
			coordinates[1] = Integer.parseInt(stringArr[1]);
			coordinates[2] = Integer.parseInt(stringArr[2]);
			coordinates[3] = Integer.parseInt(stringArr[3]);
		} catch (Exception e) {
			System.out.println("Nice try, asshole...next try");
			makeMove();
		}
		if (this.move.movePossible(currentPlayer.getStonesOnField(),board.getField(coordinates[3], coordinates[2]),
				board.getValueOfPosition(coordinates[1], coordinates[0]),
				board.getValueOfPosition(coordinates[3], coordinates[2]))
				&& board.getFieldTeam(coordinates[1], coordinates[0]) == currentPlayer.getTeamEnum()) {
			board.setField(Team.NOBODY, coordinates[1], coordinates[0]);
			board.setField(currentPlayer.getTeamEnum(), coordinates[3], coordinates[2]);
		} else {
			System.out.println("Please type coordiantes for a valid move");
			makeMove();
		}

	}

	public void setStones() {
		System.out.print("Coordinates for Stone(X,Y): ");
		String move = null;
		try {
			move = input.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] stringArr = move.split(",");
		int[] coordinates = new int[2];
		try {
			coordinates[0] = Integer.parseInt(stringArr[0]);
			coordinates[1] = Integer.parseInt(stringArr[1]);
		} catch (Exception e) {
			System.out.println("Nice try, asshole...next try");
			setStones();
		}
		if (board.getField(coordinates[1], coordinates[0]).isFree()) {
			board.setField(currentPlayer.getTeamEnum(), coordinates[1], coordinates[0]);
			currentPlayer.oneStoneSet();
		} else {
			System.out.println("Please type coordiantes for a valid move");
			setStones();
		}
	}

	public void nextPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			enemyPlayer = player1;
		} else {
			currentPlayer = player1;
			enemyPlayer = player2;
		}
	}

	public void checkMills() {
		Mill[] mills = board.getMills();
		for (int i = 0; i < mills.length; i++) {
			Field[] fields = mills[i].getFields();
			if (fields[0].getFieldTeam() == currentPlayer.getTeamEnum()
					&& fields[1].getFieldTeam() == currentPlayer.getTeamEnum()
					&& fields[2].getFieldTeam() == currentPlayer.getTeamEnum()) {
				if (!mills[i].isActive() && !mills[i].hasTerminated()) {
					try {
						board.showCurrentBoard();
						System.out.print("\nChoose Stone that shall be terminated: ");
						String move = input.readLine();
						String[] stringArr = move.split(",");
						int[] coordinates = new int[2];
						coordinates[0] = Integer.parseInt(stringArr[0]);
						coordinates[1] = Integer.parseInt(stringArr[1]);
						if ((board.getFieldTeam(coordinates[1], coordinates[0]) == enemyPlayer.getTeamEnum())
								&& board.fieldNotinActiveMill(coordinates[1], coordinates[0])) {
							board.setField(Team.NOBODY, coordinates[1], coordinates[0]);
							// board.showCurrentBoard();
							enemyPlayer.oneStoneTerminated();
							mills[i].terminate();
							mills[i].setActive();
						} else {
							System.out.println("Please enter coordinates for a valid move!\n");
							checkMills();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else /*
					 * if (!(fields[0].getFieldTeam() ==
					 * currentPlayer.getTeamEnum() && fields[1].getFieldTeam()
					 * == currentPlayer.getTeamEnum() &&
					 * fields[2].getFieldTeam() == currentPlayer.getTeamEnum())
					 * && mills[i].isActive())
					 */ {
				mills[i].setInactive();

			}
		}
	}

	public void testGame() {
		board.makeTestGame();
		player1.setStonesToSet(0);
		player1.setStonesOnField(9);
		player2.setStonesToSet(0);
		player2.setStonesOnField(9);
	}
}
