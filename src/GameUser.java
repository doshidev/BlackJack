import java.util.ArrayList;

/**
 * Created by Devang on 7/10/2017.
 */
public abstract class GameUser {
    public enum UserType {
        PLAYER, DEALER;
    }
    
    public enum UserStatus {
        LIVE, SURRENDER, BURST, WINNER, LOSER, HALT;
    }
    
    UserType type;
    ArrayList<Card> hand;
    int total;
    UserStatus status;
    
    public abstract void Hit(Deck d);
    
    public void Draw(Deck d, int count) {
        for (int i = 0; i < count; i++) {
            Card c = d.Draw();
            this.total += c.getFace().value;
            hand.add(c);
        }
        
    }
    
    public void Reset() {
        this.hand.clear();
        this.total = 0;
        this.status = UserStatus.LIVE;
    }
    
    public void Burst() {
        this.status = UserStatus.BURST;
    }
    
    public void Loser() {
        this.status = UserStatus.LOSER;
    }
    
    public void Winner() {
        this.status = UserStatus.WINNER;
    }
    
    public String showHand(){
        return this.hand.toString() + ": " + this.total ;
    }
}
