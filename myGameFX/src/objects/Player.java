package objects;

import company.Constants;
import image.Images;

public class Player extends Sprite{
    private final Skin skin;
    private final int[] pressedButtons = new int[4];

    public Player(){
        skin = new Skin("basic", Images.SKIN1,Images.SKIN2);
        x= Constants.boardWight/2.0- Constants.GIRLWight/2.0;
        y=Constants.boardHeight/2.0-Constants.GIRLHeight/2.0;
    }

    @Override
    public void move() {
        dx=2*(pressedButtons[3]-pressedButtons[1]);
        dy=2*(pressedButtons[2]-pressedButtons[0]);
        if(dx!=0 || dy!=0) {
            x += dx / Math.sqrt(dx * dx + dy * dy);
            y += dy / Math.sqrt(dx * dx + dy * dy);
        }
        if(x<0) x=0;
        if(y<0) y=0;
        if(x>(Constants.boardWight-Constants.GIRLWight)) x = (Constants.boardWight-Constants.GIRLWight);
        if(y>(Constants.boardHeight-Constants.GIRLHeight)) y = (Constants.boardHeight-Constants.GIRLHeight);
    }

    public Skin getSkin() {
        return skin;
    }

    public void setPressedButtons(int index, boolean pressed) {
        if(pressed) this.pressedButtons[index] = 1;
        else this.pressedButtons[index] = 0;
    }

    public int[] getPressedButtons() {
        return pressedButtons;
    }
}
