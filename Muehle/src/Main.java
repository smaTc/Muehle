
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import logic.Game;
import logic.Sound;

public class Main {

	public static void main(String[] args) {
		startMusic();
		menu();
		
		//testGame();
	}

	public static void menu() {
		System.out.println("1: Start New Game");
		System.out.println("2: Load Game");
		System.out.println("3: Exit\n");
		System.out.print("Enter Number: ");
		int selected=0;
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		try{
			selected = Integer.parseInt(input.readLine());
		}
		catch(IOException e){
			e.printStackTrace();
		}
		if (selected == 1) {
			System.out.println("---New Game---\n\n");
			Game game = new Game();
			game.play();
		} else if (selected == 2) {
			System.out.println("---Load Game---\n\n");
		} else if (selected == 3) {
			System.out.println("---Game exited---\n\n\n");
			System.exit(0);
		}
	}
	
	public static void startMusic(){
		Sound music=null;
		try{
			music = new Sound("res/ickyThump.wav");
		}catch (Exception e){
			System.out.println("IDE start hopefully\n");
		}
		if (music ==null){
			try{
				music = new Sound("src/res/ickyThump.wav");
			}catch (Exception e){
				System.out.println("If IDE start check music files\n");
			}
		}
		music.play();
		music.loop();
	}
	/*
	public static void testGame(){
		System.out.println("\n\n");
		Game game = new Game("Martin","Spongebob");
		game.play();
	}


	public static void testShit() {
		Board board = new Board();
		board.showBoardFieldValues();
		System.out.println();
		board.showBoardFieldTeams();
		// int[][] gb = board.getBoard();
		// Main test = new Main();
		// test.showArray(gb);
		System.out.print("EnterValue: ");
		String input = System.console().readLine();
		System.out.println(input);
	}
	
	
	
	
	public static void showArray(int[][] x) {
		System.out.println("1.Dim:" + x.length + " | 2.Dim:" + x[0].length);
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}*/
}