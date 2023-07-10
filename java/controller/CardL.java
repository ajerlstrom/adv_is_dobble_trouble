package controller;

import java.util.ArrayList;

import model.DobbleSymbol;

public class CardL{
	ArrayList<DobbleSymbol> playerCard;
	ArrayList<DobbleSymbol> deckCard;
	
	public CardL(ArrayList<DobbleSymbol> pc, ArrayList<DobbleSymbol> dc) {
		this.playerCard = pc;
		this.deckCard = dc;
	}
	
	public boolean checkRules(int symbolSelected) {
		boolean goodMove = false;
		
		for(DobbleSymbol symbol: deckCard) {
			if(symbol.symbolToInt() == symbolSelected) goodMove = true;
		}
		return goodMove;
	}
	
}
