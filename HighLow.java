/**
 * This program lets the user play HighLow, a simple card game 
 * that is described in the output statements at the beginning of 
 * the main() routine.  After the user plays several games, 
 * the user's average score is reported.
 */
import javax.swing.*;
public class HighLow {
   
   
   public static void main(String[] args) {
      
      JOptionPane.showMessageDialog(null, "This program lets you play the simple card game,HighLow.  A card is dealt from a deck of cards. You have to predict whether the next card will be higher or lower.Your score in the game is the number of correct predictions you make before you guess wrong.");
     
      System.out.println();
      
      int gamesPlayed = 0;     // Number of games user has played.
      int sumOfScores = 0;     // The sum of all the scores from 
                               //      all the games played.
      double averageScore;     // Average score, computed by dividing
                               //      sumOfScores by gamesPlayed.
      boolean playAgain;       // Record user's response when user is 
                               //   asked whether he wants to play 
                               //   another game.
      
      do {
         int scoreThisGame;        // Score for one game.
         scoreThisGame = play();   // Play the game and get the score.
         sumOfScores += scoreThisGame;
         gamesPlayed++;
         JOptionPane.showMessageDialog(null,"Play again? ");
         playAgain = TextIO.getlnBoolean();
      } while (playAgain);
      
      averageScore = ((double)sumOfScores) / gamesPlayed;
      
     
      JOptionPane.showMessageDialog(null,"You played " + gamesPlayed + " games.");
      JOptionPane.showMessageDialog(null,"Your average score was %1.3f.\n" + averageScore);
      
   }  
   
   
  
   private static int play() {
      
      Deck deck = new Deck();  // Get a new deck of cards, and 
                               //   store a reference to it in 
                               //   the variable, deck.
      
      Card currentCard;  // The current card, which the user sees.
      
      Card nextCard;   // The next card in the deck.  The user tries
                       //    to predict whether this is higher or lower
                       //    than the current card.
      
      int correctGuesses ;  // The number of correct predictions the
                            //   user has made.  At the end of the game,
                            //   this will be the user's score.
      
      char guess;   // The user's guess.  'H' if the user predicts that
                    //   the next card will be higher, 'L' if the user
                    //   predicts that it will be lower.
      
      deck.shuffle();  // Shuffle the deck into a random order before
                       //    starting the game.
      
      correctGuesses = 0;
      currentCard = deck.dealCard();
        JOptionPane.showMessageDialog(null,"The first card is the " + currentCard);
    
      while (true) {  // Loop ends when user's prediction is wrong.
         
         /* Get the user's prediction, 'H' or 'L' (or 'h' or 'l'). */
         
         JOptionPane.showMessageDialog(null, "Will the next card be higher (H) or lower (L)?  ");
         do {
            String guess1 = JOptionPane.showInputDialog("Type H for higher or L for lower");
              guess = guess1.charAt(0);
            if (guess != 'H' && guess != 'L') 
            JOptionPane.showMessageDialog(null,"Please respond with H or L:  ");
         } while (guess != 'H' && guess != 'L');
         
         /* Get the next card and show it to the user. */
         
         nextCard = deck.dealCard();
         JOptionPane.showMessageDialog(null,"The next card is " + nextCard);
         
         /* Check the user's prediction. */
         
         if (nextCard.getValue() == currentCard.getValue()) {
            JOptionPane.showMessageDialog(null,"The value is the same as the previous card.");
            JOptionPane.showMessageDialog(null,"You lose on ties.  Sorry!");
            break;  // End the game.
         }
         else if (nextCard.getValue() > currentCard.getValue()) {
            if (guess == 'H') {
               JOptionPane.showMessageDialog(null,"Your prediction was correct.");
               correctGuesses++;
            }
            else {
               JOptionPane.showMessageDialog(null,"Your prediction was incorrect.");
               break;  // End the game.
            }
         }
         else {  // nextCard is lower
            if (guess == 'L') {
               JOptionPane.showMessageDialog(null,"Your prediction was correct.");
               correctGuesses++;
            }
            else {
               JOptionPane.showMessageDialog(null,"Your prediction was incorrect.");
               break;  // End the game.
            }
         }
         
        
         
         currentCard = nextCard;
         System.out.println();
         JOptionPane.showMessageDialog(null,"The card is " + currentCard);
         
      } 
      
   
      JOptionPane.showMessageDialog(null,"The game is over.");
     JOptionPane.showMessageDialog(null,"You made " + correctGuesses  + " correct predictions.");
    
      
      return correctGuesses;
      
   }     
   
} 