package model;

import java.util.ArrayList;
import java.util.Random;

public class DobbleCard {
	
	private ArrayList<DobbleSymbol> card = new ArrayList<>();
	private int player;
	
	public DobbleCard(int player) {
		this.player = player;
		initCard();
	}

	public DobbleCard(int player, DobbleCard c){
		this.player = player;
		initCard(c);
	}
	
	public void initCard() {
		Random r = new Random();
		boolean alreadyPresent = false;
		
		int symbol = r.nextInt(59)+1;
		card.add(new DobbleSymbol(symbol));
		
		//creates a card with 8 different symbols
		while(card.size()<8) {
			symbol = r.nextInt(59)+1;
			
			for(DobbleSymbol s : card) {
				if(symbol == s.symbolToInt()) alreadyPresent = true;
			}
			
			if(!alreadyPresent) card.add(new DobbleSymbol(symbol));
			alreadyPresent = false;
		}
	}

	public void initCard(DobbleCard c) {
		Random r = new Random();
		int symbolChosen = c.getCard().get(r.nextInt(8)).symbolToInt();
		int placeChosen = r.nextInt(8);

		System.out.println("This is the symbol in common: " + symbolChosen);
		int symbol = r.nextInt(59)+1;
		boolean alreadyPresentPlayer = false;
		boolean alreadyPresentDeck = false;
		while (card.size() < 8) {
			if (placeChosen == 0){
				card.add(new DobbleSymbol(symbolChosen));
			}
			else {
				symbol = r.nextInt(59)+1;

				for (DobbleSymbol s : card) {
					if (symbol == s.symbolToInt() || symbol == symbolChosen)
						alreadyPresentPlayer = true;
				}

				for (DobbleSymbol s : c.getCard()) {
					if (symbol == s.symbolToInt() || symbol == symbolChosen)
						alreadyPresentDeck = true;
				}

				if (!alreadyPresentPlayer && !alreadyPresentDeck) card.add(new DobbleSymbol(symbol));
			}
			placeChosen--;
			alreadyPresentPlayer = false;
			alreadyPresentDeck = false;
		}
	}

	public ArrayList<DobbleSymbol> getCard(){
		return card;
	}

	public boolean containsSymbol(String s){
		for(DobbleSymbol symb : card){
			if (symb.symbolToInt()== Integer.parseInt(s)) return true;
		}
		return false;
	}

	public void copyCard(ArrayList<DobbleSymbol> c){
		this.card.clear();
		for(DobbleSymbol s : c){
			this.card.add(s);
		}
	}
}

