/**
 * Created by Devang on 7/10/2017.
 */
public enum Face {
    ACE(1, "ACE"),
    TWO(2, "TWO"),
    THREE(3, "THREE"),
    FOUR(4, "FOUR"),
    FIVE(5, "FIVE"),
    SIX(6, "SIX"),
    SEVEN(7, "SEVEN"),
    EIGHT(8, "EIGHT"),
    NINE(9, "NINE"),
    TEN(10, "TEN"),
    JACK(10, "JACK"),
    QUEEN(10, "QUEEN"),
    KING(10, "KING");
    
    public final int value;
    public final String label;
    
    Face(int value, String label) {
        this.value = value;
        this.label = label;
    }
    
    public String toString() {
        return this.label;
    }
}
