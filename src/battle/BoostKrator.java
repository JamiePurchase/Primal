package battle;

import gfx.Colour;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BoostKrator extends Boost
{
    private ArrayList<String> sequenceArray;
    private int sequenceDone;
    
    public BoostKrator()
    {
        super(2.5f);
        
        // Temp
        createSequence("ADASW");
    }
    
    private void boostRestart()
    {
        System.out.println("BOOST RESTART");
        this.sequenceDone = 0;
    }
    
    private void createSequence(String keys)
    {
        this.sequenceArray = new ArrayList();
        for(int x = 0; x < keys.length(); x++)
        {
            this.sequenceArray.add(keys.substring(x, x + 1));
        }
        this.sequenceDone = 0;
    }
    
    private String getSequenceNext()
    {
        return this.sequenceArray.get(this.sequenceDone);
    }
    
    public void inputKeyPress(String key)
    {
        if(key.equals(this.getSequenceNext()))
        {
            this.sequenceDone += 1;
            if(this.sequenceDone == this.sequenceArray.size())
            {
                this.boostSuccess();
            }
        }
        else {this.boostRestart();}
    }
    
    public void render(Graphics g)
    {
        // Frame
        this.renderFrame(g);
        
        // Combo
        g.setFont(Fonts.getFont("BOOST_COMMAND"));
        for(int x = 0; x < this.sequenceArray.size(); x++)
        {
            g.setColor(Colour.getColour("WHITE"));
            if(this.sequenceDone > x) {g.setColor(Colour.getColour("STEEL"));}
            g.drawString(this.sequenceArray.get(x), (x * 35) + 500, 365);
        }
        /*g.drawString("A", 500, 365);
        g.drawString("D", 535, 365);
        g.drawString("A", 570, 365);
        g.drawString("S", 605, 365);
        g.drawString("W", 640, 365);*/
        
        // Border
        g.setColor(Colour.getColour("WHITE"));
        g.drawRect(483, 284, 400, 100);
    }
    
    public void tickNext()
    {
        //
    }
    
}