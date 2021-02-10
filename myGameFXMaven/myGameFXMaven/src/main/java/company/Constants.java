package company;

import image.Images;
import objects.Skin;

public class Constants {
    private Constants(){

    }
    public static final String title = "Play Field";
    public static final int boardWight = 1280;
    public static final int boardHeight = 720;

    public static final int GIRLWight = 66;
    public static final int GIRLHeight = 69;

    public static final String SKIN1_IMAGE_URL = "images/skin1.jpg";
    public static final String BACKGROUND_IMAGE_URL = "images/wallpaper.jpg";
    public static final String SKIN2_IMAGE_URL = "images/skin2.jpg";
    public static final String SKIN3_IMAGE_URL = "images/skin3.jpg";
    public static final String SKIN4_IMAGE_URL = "images/skin4.jpg";
    public static final String SKIN5_IMAGE_URL = "images/skin5.jpg";
    public static final String SKIN6_IMAGE_URL = "images/skin6.jpg";
    public static final String ICON_IMAGE_URL = "images/icon.jpg";
    public static final String MENUBACKGROUND_IMAGE_URL = "images/mainMenu.jpg";

    public static final int gameSpeed = 10;

    public static final Skin first = new Skin("first", Images.SKIN1, Images.SKIN2);
    public static final Skin second = new Skin("second", Images.SKIN4, Images.SKIN3);
}
