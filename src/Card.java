/**
 * Created by Devang on 7/10/2017.
 */
public class Card {
    private Face face;
    private Suit suit;
    
    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }
    
    public String toString() {
        return (face + "(" +  suit + ")");
    }
    
}


