package entity;

public class Stone {
	private Team team;
	private boolean set;
	private boolean terminated;
	private int[] position;

	public Stone(Team team) {
		this.team = team;
		this.set = false;
		this.terminated = false;
		this.position = new int[2];
	}

	public void setPosition(int y, int x) {
		this.position[0] = y;
		this.position[1] = x;
	}

	public void terminate() {
		this.terminated = true;
	}

	public void set() {
		this.set = true;
	}

	public int[] getPosition() {
		return this.position;
	}

	public boolean isSet() {
		return this.set;
	}

	public boolean isTerminated() {
		return this.terminated;
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}

}
