package entities;

import exceptions.AnimationUnsupported;
import gfx.Drawing;
import gfx.Tileset;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import world.Board;

public class Entity
{
    private Board board;
    private String name;
    private int posX, posY;
    private String animPath;
    private HashMap<String, Animation> animStruct;
    private Animation animNow;
    
    public Entity(Board board, String name, int posX, int posY, String path)
    {
        this.board = board;
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.animPath = path;
        this.createAnimation();
    }
    
    public void addAnimation(String name, Animation anim)
    {
        this.animStruct.put(name, anim);
    }
    
    private void createAnimation()
    {
        this.animStruct = new HashMap();
        /*this.addAnimation("IDLE", new Animation());
        this.setAnimation("IDLE");*/
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getPosX()
    {
        return this.posX;
    }
    
    public int getPosY()
    {
        return this.posY;
    }
    
    public int getRenderX()
    {
        return this.board.getRenderPosX(this.posX);
    }
    
    public int getRenderY()
    {
        return this.board.getRenderPosY(this.posY);
    }
    
    public void setAnimation(String anim) throws AnimationUnsupported
    {
        if(this.animStruct.containsKey(anim)) {this.animNow = this.animStruct.get(anim);}
        else {throw new AnimationUnsupported(this, anim);}
    }
    
    public void setPos(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
    
}