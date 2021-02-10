package objects;

import image.ImageFactory;
import image.Images;

import java.awt.*;

public class Skin {
    private String skinName;
    private Images headImage;
    private Images bodyImage;
    private Image headimage;
    private Image bodyimage;

    public Skin(String name, Images head, Images body){
        skinName=name;
        headImage =head;
        bodyImage =body;
        this.bodyimage= ImageFactory.createImage(bodyImage).getImage();
        this.headimage= ImageFactory.createImage(headImage).getImage();
    }

    public Image getImageHead(){
        return this.headimage;
    }
    public Image getImageBody(){
        return this.bodyimage;
    }
}
