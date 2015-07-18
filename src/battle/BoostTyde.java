package battle;

import gfx.Colour;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.util.ArrayList;
import maths.Range;

public class BoostTyde extends Boost
{
    private int tickNow, tickMax;
    private float clock;
    private int cursorPos, cursorMax;
    private Range cursorRange;
    private boolean cursorReverse;
    
    public BoostTyde()
    {
        super(2.5f);
        this.cursorPos = 0;
        this.cursorMax = 370;
        this.cursorRange = new Range(160, 210);
        this.cursorReverse = false;
    }
    
    public void inputKeyPress(String key)
    {
        // Debug
        System.out.println("BOOST TYDE -> INPUT KEY (" + key + ")");
        
        if(this.cursorRange.contains(this.cursorPos))
        {
            this.boostSuccess();
        }
    }
    
    public void render(Graphics g)
    {
        // Frame
        this.renderFrame(g);
        
        // Cursor Zone
        g.setColor(Colour.getColour("GRASSLAND_1"));
        g.fillRect(498, 320, 370, 50);
        
        // Target Zone
        g.setColor(Colour.getColour("WHITE"));
        g.fillRect(683 - (this.cursorRange.getMin() / 2), 320, this.cursorRange.getDifference(), 50);
        
        // Combo
        Text.write(g, "*", this.cursorPos + 498, 300, "CENTER");
        
        // Border
        g.setColor(Colour.getColour("WHITE"));
        g.drawRect(483, 284, 400, 100);
    }
    
    public void tickNext()
    {
        if(!this.cursorReverse)
        {
            this.cursorPos += 5;
            if(this.cursorPos >= this.cursorMax) {this.cursorReverse = true;}
        }
        else
        {
            this.cursorPos -= 5;
            if(this.cursorPos <= 0) {this.cursorReverse = false;}
        }
    }
    
}