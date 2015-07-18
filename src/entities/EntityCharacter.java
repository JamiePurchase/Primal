package entities;

import gfx.Drawing;
import gfx.Tileset;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import world.Board;

public class EntityCharacter extends Entity
{
    private String direction;
    private String animation;
    private int animationTick, animationFrame;
    
    public EntityCharacter(Board board, String name, int posX, int posY, String path)
    {
        super(board, name, posX, posY, path);
        this.direction = "S";
    }
    
    private BufferedImage getRenderImage()
    {
        int getX = 1;
        /*if(this.animation == "WALK")
        {
            if()
        }*/
        int getY = 0;
        if(this.direction == "W") {getY = 1;}
        if(this.direction == "E") {getY = 2;}
        if(this.direction == "N") {getY = 3;}
        return new Tileset("CHAR_KRATOR_1", Drawing.getImage("characters/krator/1.png"), 64, 64, 3, 4).getTileAt(getX, getY);
    }
    
    public void push(String direction)
    {
        this.direction = direction;
        int newX = this.getPosX();
        int newY = this.getPosY();
        if(direction == "E") {newX += 1;}
        if(direction == "N") {newY -= 1;}
        if(direction == "S") {newY += 1;}
        if(direction == "W") {newX -= 1;}
        this.setPos(newX, newY);
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.getRenderImage(), this.getRenderX(), this.getRenderY(), null);
        //g.drawImage(Drawing.getImage("characters/krator/1.png"), 0, 0, null);
    }
    
}