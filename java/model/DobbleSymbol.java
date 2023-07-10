package model;

public class DobbleSymbol {
	private String symbButton;
	private int s;
	
	public DobbleSymbol(int s) {
		this.s = s;
		symbButton = "relier le button";
		//Figure out action to do when button pressed
	}
	
	public int symbolToInt() {
		return s;
	}
	
	public String symbolToString() {
		return symbButton;
	}

}
