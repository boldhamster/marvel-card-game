/* Group Name: Strikers */
/* Everything in this file is to be written to a file called toptrumps.log */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestLog {

	// Class attributes to run a demo game
    private Players playersList;
    private DeckOfCards allCards;
    private Player winnerOfRound;
    private DeckOfCards drawPile;
    private int totalNumberOfDraws = 0;
    private static int gameId = 0;


    // Game loop sets the order the game methods are called
    public static void gameLoop(GameLogic game) {
        game.displayRoundNumber();
        game.displayUserTopCard();
        game.playRound();
        game.transferCards();
        game.lostPlayer();
        game.displayRoundWinners();
    }

    public TestLog() throws IOException {
    	int numberOfPlayers = 5;

        GameLogic game = new GameLogic(numberOfPlayers);

        // In addition to the functionality described above, you should implement the following to allow for program debugging
        // when in command line mode only. When the program is started, if a �-t� flag is set on the command line, then the
        // program should write out an extensive log of its operation to a �toptrumps.log� file in the same directory as the
        // program is run, e.g.:
        // � java -jar TopTrumps.jar -c -t
        // If a toptrumps.log file already exists, your program should overwrite that file. Your program should print the
        // following information to that file, separated by a line containing dashes �----------� at the appropriate times as
        // mentioned below:

        // � The contents of the complete deck once it has been read in and constructed
        System.out.println("Executing TestGame");
        // Set the file to be written to
        FileWriter fw=new FileWriter("src\\toptrumps.log");
        // Deal the deck
        game.dealDeck();

        // Use fw.write(String) to write test output to the file
        fw.write("\nWhole deck:\n");
        // Use try/catch blocks to satisfy fw's need to catch possible exceptions
        try
        {
            for (Card c : game.getAllCards().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        // � The contents of the complete deck after it has been shuffled

        // Shuffle the deck
        game.shuffleDeck();

        // Write new deck to testlog
        fw.write("\nWhole deck (shuffled):\n");
        try
        {
            for (Card c : game.getAllCards().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}


        // � The contents of the user�s deck and the computer�s deck(s) once they have been allocated. Be sure to
        // indicate which the user�s deck is and which the computer�s deck(s) is.

        // Continue with same approach for rest of TestLog
        try
        {
            fw.write("\n\n User Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(0).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 1 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(1).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 2 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(2).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 3 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(3).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 4 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(4).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}


        // � The contents of the communal pile when cards are added or removed from it

        // Create new cards for testing the drawPile
        Card testCard = new Card();
        Card testCard2 = new Card();
        testCard.fillCard("Mr.Test", 1, 5, 16, 41, 2);
        testCard2.fillCard("Mrs.Test", 17, 9, 15, 23, 49);
        game.addToDrawPile(testCard);
        game.addToDrawPile(testCard2);

        try
        {
            fw.write("\n\n Draw Pile:\n");
            for (Card c : game.getDrawPile().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception ignored) {}

        // Remove the card to test drawPile
        game.getDrawPile().removeCard(testCard);

        try
        {
            fw.write("\n\n Draw Pile (1 card removed):\n");
            for (Card c : game.getDrawPile().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception ignored) {}

        // Remove 2nd test card from drawPile
        game.getDrawPile().removeCard(testCard2);

        // � The contents of the current cards in play (the cards from the top of the user�s deck and the computer�s
        // deck(s))
        fw.write("\nUSER TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(0).topCard());
        fw.write("\n\nAI 1 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(1).topCard());
        fw.write("\n\nAI 2 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(2).topCard());
        fw.write("\n\nAI 3 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(3).topCard());
        fw.write("\n\nAI 4 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(4).topCard());
        fw.write("\n--------------------\n");

        // Compare category values
        fw.write("\nAI 1 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(1).topCard());

        // Set the displayCategory to be the result of calling AI 1's chooseCategory method
        int displayCategory = game.getPlayersList().getPlayers().get(1).chooseCategory();
        // Capture the related category values from the other players
        int userValue = game.getPlayersList().getPlayers().get(0).getPlayerDeck().getTopCardValue(displayCategory);
        int ai2Value = game.getPlayersList().getPlayers().get(2).getPlayerDeck().getTopCardValue(displayCategory);
        int ai3Value = game.getPlayersList().getPlayers().get(3).getPlayerDeck().getTopCardValue(displayCategory);
        int ai4Value = game.getPlayersList().getPlayers().get(4).getPlayerDeck().getTopCardValue(displayCategory);

        // Category value index starts at 0, category choice starts at 1
        // +=1 will show correct category number to screen
        displayCategory += 1;

        // Write to the file the name of the chosen category using if/else if
        fw.write("\n\nChosen category by AI 1: " + displayCategory);
        if (displayCategory == 1)
        {
            fw.write("\nCategory chosen is: Intelligence");
        } else if (displayCategory == 2)
        {
            fw.write("\nCategory chosen is: Speed");
        } else if (displayCategory == 3)
        {
            fw.write("\nCategory chosen is: Strength");
        } else if (displayCategory == 4)
        {
            fw.write("\nCategory chosen is: Agility");
        } else if (displayCategory == 5)
        {
            fw.write("\nCategory chosen is: Combat");
        } else
        {
            fw.write("\nNo category chosen");
        }
        // Write other players' values to file
        fw.write("\n\nOther users' values for same category:\n");
        fw.write("\nUser: " + userValue);
        fw.write("\nAI 2: " + ai2Value);
        fw.write("\nAI 3: " + ai3Value);
        fw.write("\nAI 4: " + ai4Value);

        // Write other users' top cards to the file
        fw.write("\n\nOther users' top cards:\n");
        fw.write("\nUSER TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(0).topCard());
        fw.write("\n\nAI 2 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(2).topCard());
        fw.write("\n\nAI 3 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(3).topCard());
        fw.write("\n\nAI 4 TOP CARD:\n");
        fw.write(game.getPlayersList().getPlayers().get(4).topCard());
        fw.write("\n--------------------\n");

        // � The contents of each deck after a round

        // A drawn round is unsuitable for testing
        // So, the test while loop will play until a round is not a draw
        boolean roundComplete = false;
        while (roundComplete = false)
        {
            fw.write("Playing a round ...");
            fw.write("...");
            fw.write("..");
            fw.write(".");
            // Run gameLoop containing game method calls in order
            gameLoop(game);
            if (!game.getRoundDrawn())
            {
                roundComplete = true;
            }
        }

        fw.write("\n\nDeck contents for each player after a round:\n");

        try
        {
            fw.write("\n\n User Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(0).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 1 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(1).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 2 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(2).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 3 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(3).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}

        try
        {
            fw.write("\n\n AI 4 Deck:\n");
            for (Card c : game.getPlayersList().getPlayers().get(4).getPlayerDeck().getDeck())
            {
                fw.write("\n" + c.toString());
            }
            fw.write("\n\n--------------------\n");
        } catch(Exception e) {}


        // � The winner of the game
        // Continue playing the game until there are no players left
        while(!game.lastPlayerLeft())
        {
            gameLoop(game);
        }

        // Display the winner, based on the winner of the last round in the game
        fw.write("\n\nThe Winner is: "+ game.getPlayerWinnerOfRound().getName());
        // Close the FileWriter
    fw.close();
    }
}
