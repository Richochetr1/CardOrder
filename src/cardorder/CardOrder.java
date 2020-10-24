/*
Sorting cars in terms of Suit first, then using the comparator. 
*/
package cardorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Use the enum interface and give them a placement number to sort by the suits. 
enum Suit {
    HEART ( 0 ),
    DIAMOND ( 1 ),
    CLUB ( 2 ),
    SPADE ( 3 );

    private int value;

    private Suit ( int value ) {
        this.value = value;
    }

    public int retrieveValue () {
        return value;
    }
}

// Use comparable interface on the objects of each class.
class Card implements Comparable < Card > {
    private int rank;
    private Suit suit;

// Implementation of the of the Comparator <Card> with the card class.
    public static Comparator < Card > suitComparator = 
                        new Comparator < Card > () {
        @Override
        public int compare ( Card someCard, Card anotherCard ) {
            return someCard.suit.retrieveValue () - anotherCard.suit.retrieveValue ();
        }
    };

    public Card ( int rank, Suit suit ) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank () {
        return rank;
    }

    public void setRank ( int rank ) {
        this.rank = rank;
    }

    public Suit getSuit () {
        return suit;
    }

    public void setSuit ( Suit suit ) {
        this.suit = suit;
    }

    @Override
    public int compareTo ( Card anotherCard ) {
        return this.rank - anotherCard.rank;
    }
    
    //Format how the cards will be presented.
    @Override
    public String toString () {     
        return String.format ( "Suit: %8s Rank: %8s", suit, rank );
    }
}

public class CardOrder {

    
   // Tried to use string to change values but only would use the number of spaces
   // in array.
    private static final String[] cardValues = {"Ace","2","3","4","5","6","7","8","9",
       "10","Jack","Queen","King"};
    
    private List < Card > deck;

    public CardOrder () {
        deck = new ArrayList < Card > ();       
    }
    //Creates deck of of cards.
    private void createDeck () {
        for ( Suit suit : Suit.values () ) {
            for ( int i = 0; i < cardValues.length; ++i ) {
                deck.add ( new Card ( i, suit ) );
            }
        }
    }

    private void displayDeck () {
        for ( Card card : deck ) {
            System.out.println ( card );
        }
    }

    private void performTask () {
        createDeck ();
        Collections.shuffle ( deck ); //Shuffles the collection of cards
        System.out.println ( "Before SORTING" );
        displayDeck ();// displays the deck of cards unsorted
        //Sorts cards by suit and then rank.         
        Collections.sort ( deck );
        Collections.sort ( deck, Card.suitComparator );
        System.out.println ( "After SORTING" );
        displayDeck ();
    }

    //main function
    public static void main ( String[] args ) {
        new CardOrder ().performTask ();
    }
    
}
