package battle;

import java.awt.image.BufferedImage;
import states.StateBattle;

public class UnitAlly extends Unit
{
    
    public UnitAlly(StateBattle battle, String ref, BufferedImage image, int posX, int posY)
    {
        super(battle, ref, image, posX, posY);
    }
    
}