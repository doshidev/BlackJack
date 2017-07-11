/**
 * Created by Devang on 7/10/2017.
 */
public enum Suit {
    SPADE(0, 'S'), HEART(1, 'H'), CLUB(2, 'C'), DIAMOND(3, 'D');
    public final int index;
    public final char alias;
    
    Suit(int index, char alias) {
        this.index = index;
        this.alias = alias;
    }
    
    public String toString() {
        return String.valueOf(this.alias);
    }
}