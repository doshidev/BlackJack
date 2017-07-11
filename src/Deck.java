import java.util.Collections;
import java.util.Stack;

/**
 * Created by Devang on 7/10/2017.
 */
public class Deck {
    private Stack<Card> deckPack;
    
    public Deck() {
        this.deckPack = new Stack<>();
        for ( Suit s : Suit.values()) {
            for (Face f : Face.values()) {
                deckPack.push(new Card(f, s));
            }
        }
        Collections.shuffle(deckPack);
    }
    
    public void Shuffle() {
        Collections.shuffle(this.deckPack);
    }
    
    public Card Draw() {
        return this.deckPack.pop();
    }
    
    public int Count() {
        return this.deckPack.size();
    }
    
    public Boolean isEmpty() {
        return this.deckPack.isEmpty();
    }
}
