package company;

import javafx.scene.input.KeyEvent;
import objects.Player;

public class MoveAction {

    public MoveAction(KeyEvent e, Player player, boolean pres){
        String code = e.getCode().toString();
        int direction = -1;
        switch (code){
            case "A":
                direction = 1;
                break;
            case "W":
                direction = 0;
                break;
            case "S":
                direction = 2;
                break;
            case "D":
                direction = 3;
                break;
            default:
                break;
        }
        if(direction !=-1) player.setPressedButtons(direction, pres);
    }
}
