package entity;

public class Mill {
	private Team team;
	private Field[] fields = new Field[3];
	private boolean active;
	private boolean hasTerminatedStone;

	public Mill(Team team, Field field0, Field field1, Field field2) {
		this.team = team;
		this.fields[0] = field0;
		this.fields[1] = field1;
		this.fields[2] = field2;
		this.hasTerminatedStone = false;
	}

	public void terminate() {
		this.hasTerminatedStone = true;
	}

	public boolean hasTerminated() {
		return this.hasTerminatedStone;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive() {
		this.active = true;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}

	public Field[] getFields() {
		return this.fields;
	}
}
