package battle;

import java.awt.image.BufferedImage;
import states.StateBattle;

public class UnitEnemy extends Unit
{
    
    public UnitEnemy(StateBattle battle, String ref, BufferedImage image, int posX, int posY)
    {
        super(battle, ref, image, posX, posY);
    }
    
}