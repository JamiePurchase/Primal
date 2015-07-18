package entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation
{
    private Entity entity;
    private ArrayList<BufferedImage> image;
    private int tickNow, tickMax, frameNow;
    private boolean doneRepeat;
    private String doneAnimation;
    
    public Animation(ArrayList<BufferedImage> image, int tick)
    {
        this.image = image;
        this.tickNow = 0;
        this.tickMax = tick;
        this.frameNow = 0;
        this.doneRepeat = true;
        this.doneAnimation = "";
    }
    
    public Animation(ArrayList<BufferedImage> image, int tick, String next)
    {
        this.image = image;
        this.tickNow = 0;
        this.tickMax = tick;
        this.doneRepeat = false;
        this.doneAnimation = next;
    }
    
    
    
    public Animation(ArrayList<BufferedImage> imageN, ArrayList<BufferedImage> imageE, ArrayList<BufferedImage> imageS, ArrayList<BufferedImage> imageW, int tick)
    {
        this.image = imageN;
        this.tickNow = 0;
        this.tickMax = tick;
        this.frameNow = 0;
        this.doneRepeat = true;
        this.doneAnimation = "";
    }
    
    private int getFrameMax()
    {
        return this.image.size();
    }
    
    public BufferedImage getImage()
    {
        return this.image.get(this.frameNow);
    }
    
    public void tick()
    {
        this.tickNow += 1;
        if(this.tickNow >= this.tickMax)
        {
            this.tickNow = 0;
            this.frameNow += 1;
            if(this.frameNow >= getFrameMax())
            {
                if(this.doneRepeat) {this.frameNow = 0;}
                //else {this.entity.setAnimation(this.doneAnimation);}
            }
        }
    }
    
}