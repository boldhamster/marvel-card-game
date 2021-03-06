/* Group Name: Strikers */
/*This method creates a card which has a name and Categories */

public class Card {

	// Card attributes for each card
	// Store name, array of categories & array of values

	  private String name;
	  private String[] cardCategories;
	  private int[] cardValues;


	  // Set names for each category
	  // Initialise cardValues array
	  public Card() {
		  cardCategories = new String[5];
		  cardCategories[0] = "Intelligence";
		  cardCategories[1] = "Speed";
		  cardCategories[2] = "Strength";
		  cardCategories[3] = "Agility";
		  cardCategories[4] = "Combat";
		  cardValues = new int[5];
	  }

	  // Add name and values to card
	  public void fillCard(String name, int intelligence, int speed, int strength, int agility, int combat) {
		    this.name = name;
		    this.cardValues[0] = intelligence;
		    this.cardValues[1] = speed;
		    this.cardValues[2] = strength;
		    this.cardValues[3] = agility;
		    this.cardValues[4] = combat;
		  }

	  // toString method for displaying each card
	  // Uses a formatted String to space the display evenly
	  @Override
	  public String toString() {
	    String card = String.format("%nName: %s%n%-13s : %d%n%-13s : %d%n%-13s : %d%n%-13s : %d%n%-13s : %d",
	    		this.name, this.cardCategories[0], this.cardValues[0],
	    		this.cardCategories[1], this.cardValues[1], this.cardCategories[2], this.cardValues[2],
	    		this.cardCategories[3], this.cardValues[3], this.cardCategories[4], this.cardValues[4]);
	    return card;
	  }

	  // Getters for Card class

	  public int getValue(int category)
	  {
		  return this.cardValues[category];
	  }

	  public String getName() {
	    return this.name;
	  }

	  public int getIntelligence() {
	    return this.cardValues[0];
	  }

	  public int getSpeed() {
	    return this.cardValues[1];
	  }

	  public int getStrength() {
	    return this.cardValues[2];
	  }

	  public int getAgility() {
	    return this.cardValues[3];
	  }

	  public int getCombat() {
	    return this.cardValues[4];
	  }

	  public String getCategoryIntelligence() {
	    return this.cardCategories[0];
	  }

	  public String getCategorySpeed() {
	    return this.cardCategories[1];
	  }

	  public String getCategoryStrength() {
	    return this.cardCategories[2];
	  }

	  public String getCategoryAgility() {
	    return this.cardCategories[3];
	  }

	  public String getCategoryCombat() {
	    return this.cardCategories[4];
	  }

	  public String getCategories(int index) {
	    return cardCategories[index];
	  }

	  public int[] getValues() {
	    return cardValues;
	  }

	}
