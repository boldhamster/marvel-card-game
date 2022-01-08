/* Group Name: Strikers */

/*Interface used in HumanPlayer and the CompPlayer Classes.*/

public interface Player {
	  public String getName();
	  public int chooseCategory();
	  public DeckOfCards getPlayerDeck();
	  public void setPlayerID(int playerID);
	  public int getPlayerID();
	  public int getNumberOfRoundsWon();
	  public void incNumberOfRoundsWon();
	  public boolean getLost();
	  public void setLost(boolean lost);
	  public String topCard();
}
