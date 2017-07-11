/**
 * Created by Devang on 7/10/2017.
 */
public class Test {
    public static void main(String[] args) {
        Deck d = new Deck();
    
        while(!d.isEmpty()) {
            System.out.println(d.Count() + ". " + d.Draw());
            
        }
    
    }
}
