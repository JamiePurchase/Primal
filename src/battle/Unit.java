package battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import maths.Portion;
import states.StateBattle;

public class Unit
{
    private StateBattle battle;
    private String reference;
    private HashMap<String, Portion> stats;
    
    // TEMP
    private BufferedImage image;
    private int posX, posY;
    
    public Unit(StateBattle battle, String ref, BufferedImage image, int posX, int posY)
    {
        this.battle = battle;
        this.reference = ref;
        
        // TEMP
        this.image = image;
        this.posX = posX;
        this.posY = posY;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.image, this.posX, this.posY, null);
    }

}