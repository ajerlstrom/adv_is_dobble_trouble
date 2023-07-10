package model;

import java.util.ArrayList;

public class CheckRules {

	private ArrayList<DobbleSymbol> otherCard = new ArrayList<>();
	private int symbolSelected;
	
	public boolean CheckRules(int s, ArrayList<DobbleSymbol> card) {
		boolean goodMove = false;
		this.otherCard = card;
		this.symbolSelected = s;
		
		for(DobbleSymbol symbol: otherCard) {
			if(symbol.symbolToInt() == symbolSelected) goodMove = true;
		}
		
		return goodMove;
	}
}
