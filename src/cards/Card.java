package cards;

public class Card {
	private String suits;
	private String name;
	private int value;
	

	public Card (String name, String suit, int value){
		this.name = name;
		this.suits = suit;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Card [suits=" + suits + ", name=" + name + ", value=" + value + "]";
	}

	public String getSuits() {
		return suits;
	}

	public void setSuits(String suits) {
		this.suits = suits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
