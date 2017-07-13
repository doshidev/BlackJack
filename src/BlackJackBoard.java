import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Devang on 7/10/2017.
 */
public class BlackJackBoard {
    Player player;
    Dealer dealer;
    Deck deck;
    int round;
    int status;
    
    public BlackJackBoard() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.round = 0;
        this.status = 0;
    }
    
    public void NewGame() {
        this.status = 1;
        dealer.Draw(this.deck, 2);
        player.Draw(this.deck, 2);
    
        System.out.println();
        System.out.println("# New Game: ");
        
        
        while(status == 1) {
            System.out.println();
            this.CheckStatus();
            this.PlayRound();
        }
        
        
    }
    
    public void PlayRound() {
        this.round++;
        System.out.println();
        System.out.println("# Round " + this.round);
        System.out.println("Dealer Cards: " + dealer.showHand());
        System.out.println("Player Cards: " + player.showHand());
        PlayerTurn();
        if(status == 1) {
            DealerTurn();
        }
        
    }
    
    public void PlayerWins() {
        player.Winner();
        dealer.Loser();
        status = 0;
        System.out.println("### PLAYER WINS!!! ###");
    }
    
    public void DealerWins() {
        dealer.Winner();
        player.Loser();
        status = 0;
        System.out.println("### DEALER WINS!!! ###");
    }
    
    public void BothWins() {
        dealer.Winner();
        player.Winner();
        status = 0;
        System.out.println("### PLAYER AND DEALER WINS!!! ###");
    }
    
    public void CheckStatus() {
        System.out.println("# Checking status ..............");
    
        // If Dealer > 21
        if(dealer.total > 21) {
            dealer.Burst();
            System.out.println("# Dealer BURST!!!");
            PlayerWins();
            return;
        }
    
        // if Player > 21
        if (player.total > 21) {
            player.Burst();
            System.out.println("# Player BURST!!!");
            DealerWins();
            return;
        }
        
        // Both have 21
        if(player.total == 21 && dealer.total == 21) {
            System.out.println("# Both got BLACKJACK!!!");
            BothWins();
            return;
        }
        
        // If dealer has BlackJack
        if(dealer.total == 21) {
            DealerWins();
            System.out.println("# Dealer got BLACKJACK!!!");
            return;
        }
    
        // If player has BlackJack
        if(player.total == 21) {
            PlayerWins();
            System.out.println("# Player got BLACKJACK!!!");
            return;
        }
        
        // If dealer has total >= 17
        if(dealer.total >= 17) {
            dealer.Halt();
        }
        
        // If dealer has total >= 17 and Player total > dealer
        if(dealer.isHalt() && player.total > dealer.total) {
            PlayerWins();
            return;
        }
        
        System.out.println("# Status OK");
    }
    
    
    public void PlayerTurn() {
        System.out.print("Player: Hit(H) / Stand(S) / Surrender(X): ");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        
        switch(input) {
            case "H":
                player.Hit(this.deck);
                break;
            case "X":
                player.Surrender();
                break;
        }
        System.out.println("P: " + player.showHand());
        CheckStatus();
    }
    
    public void DealerTurn() {
        dealer.Hit(this.deck);
        System.out.println("D: " + dealer.showHand());
        CheckStatus();
    }
}
