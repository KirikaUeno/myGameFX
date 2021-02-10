package objects;

import image.Images;

public class Skin {
    private String skinName;
    private Images headImage;
    private Images bodyImage;

    public Skin(String name, Images head, Images body) {
        skinName = name;
        headImage = head;
        bodyImage = body;
    }
}
