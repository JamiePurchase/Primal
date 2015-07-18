package gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TilesetSprite extends Tileset
{
    
    public TilesetSprite(String ref, BufferedImage file)
    {
        super(ref, file, 64, 64, 3, 4);
    }
    
    public ArrayList<BufferedImage> getAnimIdle(String direction)
    {
        ArrayList<BufferedImage> images = new ArrayList();
        int getY = 0;
        if(direction.equals("W")) {getY = 1;}
        if(direction.equals("E")) {getY = 2;}
        if(direction.equals("N")) {getY = 3;}
        images.add(this.getTileAt(1, getY));
        return images;
    }
    
    public ArrayList<BufferedImage> getAnimWalk(String direction)
    {
        ArrayList<BufferedImage> images = new ArrayList();
        int getY = 0;
        if(direction.equals("W")) {getY = 1;}
        if(direction.equals("E")) {getY = 2;}
        if(direction.equals("N")) {getY = 3;}
        images.add(this.getTileAt(0, getY));
        images.add(this.getTileAt(1, getY));
        images.add(this.getTileAt(2, getY));
        images.add(this.getTileAt(1, getY));
        return images;
    }
    
}