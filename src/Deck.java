import java.util.Collections;
import java.util.Stack;

/**
 * Created by Devang on 7/10/2017.
 */
public class Deck {
    private Stack<Card> deckPack;
    private int numOfDecks;
    public Deck() {
        this.numOfDecks = 1;
        this.deckPack = new Stack<>();
        fill(this.numOfDecks, this.deckPack);
    }
    
    public Deck(int count) {
        this.deckPack = new Stack<>();
        this.numOfDecks = count;
        fill(this.numOfDecks, this.deckPack);
    }
    
    public void Shuffle() {
        Collections.shuffle(this.deckPack);
    }
    
    public Card Draw() {
        if(!this.deckPack.isEmpty()){
            return this.deckPack.pop();
        }
        return null;
    }
    
    public int Count() {
        return this.deckPack.size();
    }
    
    public Boolean isEmpty() {
        return this.deckPack.isEmpty();
    }
    
    public Stack<Card> fill(int cnt, Stack<Card> deck) {
        for (int i = 0; i < cnt; i++) {
            for ( Suit s : Suit.values()) {
                for (Face f : Face.values()) {
                    deck.push(new Card(f, s));
                }
            }
            Collections.shuffle(deck);
        }
        return deck;
    }
}
