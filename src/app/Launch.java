package app;

import states.StateTitle;
import styles.Colours;
import styles.Fonts;

public class Launch
{
    
    public static void main(String[] args)
    {
        String name = "Primal";
        String author = "Jamie Purchase";
        String version = "0.1.0";
        String path = "C:/Users/Jamie/Documents/NetBeansProjects/Primal/src/res/";
        Colours.loadColours();
        Fonts.loadFonts();
        new Engine(name, author, version, path, new StateTitle()).start(false);
    }
    
}