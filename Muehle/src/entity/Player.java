package entity;

public class Player {
	private String name;
	private Team team;
	private int stonesToSet;
	private int stonesOnField;
	private Stone[] stones;

	public Player(String name, Team team, int stonesToSet, int stonesOnField) {
		this.name = name;
		this.team = team;
		this.stonesToSet = stonesToSet;
		this.stonesOnField = stonesOnField;
		this.stones = new Stone[9];
		for (int i = 0; i < stones.length; i++)
			stones[i] = new Stone(team);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeamEnum() {
		return this.team;
	}

	public String getTeam() {
		if (team == Team.BLACK)
			return "Black";
		else
			return "White";
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getStonesToSet() {
		return stonesToSet;
	}

	public void oneStoneSet() {
		this.stonesToSet--;
		this.stonesOnField++;
	}

	public void oneStoneTerminated() {
		this.stonesOnField--;
	}

	public void setStonesToSet(int stonesToSet) {
		this.stonesToSet = stonesToSet;
	}

	public int getStonesOnField() {
		return stonesOnField;
	}

	public void setStonesOnField(int stonesOnField) {
		this.stonesOnField = stonesOnField;
	}

}
