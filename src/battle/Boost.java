package battle;

import gfx.Colour;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.text.DecimalFormat;

public abstract class Boost
{
    private int tickNow, tickMax;
    private float clock;
    private boolean boostDone;
    private int tickDone;
    // NOTE: the clock variable should be moved into the superclass 
   
    public Boost(float time)
    {
        this.tickNow = 0;
        this.tickMax = 1;
        this.setClock(time);
        this.setBoostDone(false);
    }
    
    public void boostFailure()
    {
        System.out.println("BOOST FAILURE");
        this.setBoostDone(true);
    }
    
    public void boostSuccess()
    {
        System.out.println("BOOST SUCCESS");
        this.setBoostDone(true);
    }
    
    public boolean getBoostDone()
    {
        if(this.boostDone && this.tickDone >= 60) {return this.boostDone;}
        return false;
    }
    
    public float getClock()
    {
        return this.clock;
    }
    
    public String getClockAsString()
    {
        if(this.clock <= 0) {return "0.00";}
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return "" + df.format(this.clock);
    }
    
    public abstract void inputKeyPress(String key);
    public abstract void render(Graphics g);
    
    public void renderFrame(Graphics g)
    {
        // Background
        g.setColor(Colour.getColour("BLACK"));
        g.fillRect(483, 284, 400, 100);
        
        // Text
        g.setColor(Colour.getColour("WHITE"));
        g.setFont(Fonts.getFont("STANDARD"));
        g.drawString("BOOST", 495, 315);
        Text.write(g, this.getClockAsString(), 871, 315, "RIGHT");
    }
    
    public void setBoostDone(boolean done)
    {
        this.boostDone = done;
        this.tickDone = 0;
    }
    
    public void setClock(float value)
    {
        this.clock = value;
    }
    
    public void tick()
    {
        if(this.boostDone) {this.tickDone();}
        else {this.tickClock();}
    }
    
    private void tickClock()
    {
        this.tickNow += 1;
        if(this.tickNow >= this.tickMax)
        {
            this.tickNow = 0;
            this.clock -= 0.01f;
            if(this.clock <= 0)
            {
                this.clock = 0.00f;
                this.boostFailure();
            }
            this.tickNext();
        }
    }
    
    private void tickDone()
    {
        this.tickDone += 1;
    }
    
    public abstract void tickNext();

}