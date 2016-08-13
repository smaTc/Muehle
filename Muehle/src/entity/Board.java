package entity;

public class Board {

	private Field[][] gameBoard;
	private Mill[] mills;

	public Board() {
		this.gameBoard = new Field[7][7];
		for (int i = 0; i < this.gameBoard.length; i++) {
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				this.gameBoard[i][j] = new Field(0);
			}
		}
		// Reihe0(A)
		this.gameBoard[0][0].setField(2, Team.NOBODY);
		this.gameBoard[0][3].setField(3, Team.NOBODY);
		this.gameBoard[0][6].setField(2, Team.NOBODY);
		// Reihe1(B)
		this.gameBoard[1][1].setField(2, Team.NOBODY);
		this.gameBoard[1][3].setField(4, Team.NOBODY);
		this.gameBoard[1][5].setField(2, Team.NOBODY);
		// Reihe2(C)
		this.gameBoard[2][2].setField(2, Team.NOBODY);
		this.gameBoard[2][3].setField(3, Team.NOBODY);
		this.gameBoard[2][4].setField(2, Team.NOBODY);
		// Reihe3(D)
		this.gameBoard[3][0].setField(3, Team.NOBODY);
		this.gameBoard[3][1].setField(4, Team.NOBODY);
		this.gameBoard[3][2].setField(3, Team.NOBODY);
		this.gameBoard[3][4].setField(3, Team.NOBODY);
		this.gameBoard[3][5].setField(4, Team.NOBODY);
		this.gameBoard[3][6].setField(3, Team.NOBODY);
		// Reihe4(E)
		this.gameBoard[4][2].setField(2, Team.NOBODY);
		this.gameBoard[4][3].setField(3, Team.NOBODY);
		this.gameBoard[4][4].setField(2, Team.NOBODY);
		// Reihe5(F)
		this.gameBoard[5][1].setField(2, Team.NOBODY);
		this.gameBoard[5][3].setField(4, Team.NOBODY);
		this.gameBoard[5][5].setField(2, Team.NOBODY);
		// Reihe6(G)
		this.gameBoard[6][0].setField(2, Team.NOBODY);
		this.gameBoard[6][3].setField(3, Team.NOBODY);
		this.gameBoard[6][6].setField(2, Team.NOBODY);

		this.mills = new Mill[16];
		mills[0] = new Mill(Team.NOBODY, this.gameBoard[0][0], this.gameBoard[3][0], this.gameBoard[6][0]);
		mills[1] = new Mill(Team.NOBODY, this.gameBoard[1][1], this.gameBoard[3][1], this.gameBoard[5][1]);
		mills[2] = new Mill(Team.NOBODY, this.gameBoard[2][2], this.gameBoard[3][2], this.gameBoard[4][2]);
		mills[3] = new Mill(Team.NOBODY, this.gameBoard[0][3], this.gameBoard[1][3], this.gameBoard[2][3]);
		mills[4] = new Mill(Team.NOBODY, this.gameBoard[4][3], this.gameBoard[5][3], this.gameBoard[6][3]);
		mills[5] = new Mill(Team.NOBODY, this.gameBoard[2][4], this.gameBoard[3][4], this.gameBoard[4][4]);
		mills[6] = new Mill(Team.NOBODY, this.gameBoard[1][5], this.gameBoard[3][5], this.gameBoard[5][5]);
		mills[7] = new Mill(Team.NOBODY, this.gameBoard[0][6], this.gameBoard[3][6], this.gameBoard[6][6]);
		mills[8] = new Mill(Team.NOBODY, this.gameBoard[0][0], this.gameBoard[0][3], this.gameBoard[0][6]);
		mills[9] = new Mill(Team.NOBODY, this.gameBoard[1][1], this.gameBoard[1][3], this.gameBoard[1][5]);
		mills[10] = new Mill(Team.NOBODY, this.gameBoard[2][2], this.gameBoard[2][3], this.gameBoard[2][4]);
		mills[11] = new Mill(Team.NOBODY, this.gameBoard[3][0], this.gameBoard[3][1], this.gameBoard[3][2]);
		mills[12] = new Mill(Team.NOBODY, this.gameBoard[3][4], this.gameBoard[3][5], this.gameBoard[4][6]);
		mills[13] = new Mill(Team.NOBODY, this.gameBoard[4][2], this.gameBoard[4][3], this.gameBoard[4][4]);
		mills[14] = new Mill(Team.NOBODY, this.gameBoard[5][1], this.gameBoard[5][3], this.gameBoard[5][5]);
		mills[15] = new Mill(Team.NOBODY, this.gameBoard[6][0], this.gameBoard[6][3], this.gameBoard[6][6]);
	}

	public Team getFieldTeam(int y, int x) {
		return this.gameBoard[y][x].getFieldTeam();
	}

	public int getValueOfPosition(int y, int x) {
		return this.gameBoard[y][x].getFieldValue();
	}

	public Field[][] getBoard() {
		return this.gameBoard;
	}

	public boolean isFree(int y, int x) {
		if (this.gameBoard[y][x].getFieldTeam() == Team.NOBODY)
			return true;
		else
			return false;
	}

	public void setField(Team team, int y, int x) {
		this.gameBoard[y][x].setFieldTeam(team);
	}

	public Field getField(int y, int x) {
		return this.gameBoard[y][x];
	}
	
	public Mill[] getMills() {
		return this.mills;
	}

	public boolean fieldNotinActiveMill(int y, int x) {
		for (int i = 0; i < mills.length; i++) {
			Field[] field = mills[i].getFields();
			if ((this.getField(y, x) == field[0] || this.getField(y, x) == field[1] || this.getField(y, x) == field[2])
					&& mills[i].isActive()) {
				return false;
			}
		}
		return true;
	}

	public void showCurrentBoard() {
		System.out.println();
		for (int i = 0; i < gameBoard.length; i++)
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < gameBoard.length * 2 - 1; i++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j].getTeamShort() + " ");
			}
			System.out.print("| " + i + "\n");
		}
	}

	public void makeTestGame() {
		this.gameBoard[0][0].setField(2, Team.BLACK);// 1b
		this.gameBoard[0][3].setField(3, Team.NOBODY);
		this.gameBoard[0][6].setField(2, Team.BLACK);// 2b
		// Reihe1(B)
		this.gameBoard[1][1].setField(2, Team.WHITE);// 1w
		this.gameBoard[1][3].setField(4, Team.BLACK);// 3b
		this.gameBoard[1][5].setField(2, Team.WHITE);// 2w
		// Reihe2(C)
		this.gameBoard[2][2].setField(2, Team.WHITE);// 3w
		this.gameBoard[2][3].setField(3, Team.BLACK);// 4b
		this.gameBoard[2][4].setField(2, Team.WHITE);// 4w
		// Reihe3(D)
		this.gameBoard[3][0].setField(3, Team.WHITE);// 5w
		this.gameBoard[3][1].setField(4, Team.WHITE);// 6w
		this.gameBoard[3][2].setField(3, Team.BLACK);// 5b
		this.gameBoard[3][4].setField(3, Team.BLACK);// 6b
		this.gameBoard[3][5].setField(4, Team.WHITE);// 7w
		this.gameBoard[3][6].setField(3, Team.WHITE);// 8w
		// Reihe4(E)
		this.gameBoard[4][2].setField(2, Team.NOBODY);
		this.gameBoard[4][3].setField(3, Team.NOBODY);
		this.gameBoard[4][4].setField(2, Team.NOBODY);
		// Reihe5(F)
		this.gameBoard[5][1].setField(2, Team.NOBODY);
		this.gameBoard[5][3].setField(4, Team.BLACK);// 7b
		this.gameBoard[5][5].setField(2, Team.NOBODY);
		// Reihe6(G)
		this.gameBoard[6][0].setField(2, Team.WHITE);// 9w
		this.gameBoard[6][3].setField(3, Team.BLACK);// 8b
		this.gameBoard[6][6].setField(2, Team.BLACK);// 9b
	}
	
	/*
	 
 	public void showBoardFieldValues() {
		System.out.println("1Dim:" + gameBoard.length + " 2Dim:" + gameBoard[0].length);
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j].getFieldValue() + " ");
			}
			System.out.println();
		}
	}
 	
	public void showBoardFieldTeams() {
		// System.out.println("1Dim:" + gameBoard.length + " 2Dim:" +
		// gameBoard[0].length);
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j].getTeamShort() + " ");
			}
			System.out.println();
		}
	}*/
	
}
