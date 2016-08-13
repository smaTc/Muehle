package entity;

public class Field {
private int value=0;
private Team team=null;

	public Field(int value){
		this.value = value;
	}
	
	public void setField(int value,Team team){
		this.value = value;
		this.team = team;
	}
	
	public void setFieldTeam(Team team){
		this.team = team;
	}
	
	public void setFieldValue(int value){
		this.value = value;
	}
	
	public int getFieldValue(){
		return this.value;
	}
	
	public boolean isFree(){
		if(this.team==Team.NOBODY)return true;
		else return false;
	}
	
	public Team getFieldTeam(){
		return this.team;
	}
	
	public String getTeamShort(){
		if(this.team==Team.BLACK) return "B";
		else if(this.team==Team.WHITE) return "W";
		else if(this.team==Team.NOBODY) return "N";
		else return "-";
	}
	
}
