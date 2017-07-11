import java.util.ArrayList;

/**
 * Created by Devang on 7/10/2017.
 */
public class GameUser {
    public enum UserType {
        PLAYER, DEALER;
    }
    UserType type;
    ArrayList<Card> hand;
    int total;
    int money;
    
    
    public GameUser(UserType t){
        this.type = t;
        this.hand = new ArrayList<>();
        total = 0;
        if(type == UserType.PLAYER) {
            money = 100;
        }
    }
}
