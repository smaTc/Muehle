package logic;

import entity.Field;
import entity.Stone;

public class Move {

	public boolean allowedMove(int currentFieldValue, int nextFieldValue) {
		if (currentFieldValue == 2 && (nextFieldValue == 3 || nextFieldValue == 4))
			return true;
		else if (currentFieldValue == 3 && (nextFieldValue == 2 || nextFieldValue == 4))
			return true;
		else if (currentFieldValue == 4 && (nextFieldValue == 2 || nextFieldValue == 3))
			return true;
		else
			return false;
	}

	public boolean stoneUsable(Stone s) {
		if (s.isSet() && !s.isTerminated())
			return true;
		else
			return false;
	}
	
	public boolean fieldIsFree(Field field){
		if(field.isFree())return true;
		else return false;
	}
	
	public boolean movePossible(int stonesOnField,Field field,int current, int next){
		if(stonesOnField>3){
			if(allowedMove(current, next)&&fieldIsFree(field))return true;
			else return false;
		}
		else{
			if(fieldIsFree(field))return true;
			else return false;
		}
		
	}
	
	

}
