package states;

import app.Engine;
import battle.Boost;
import battle.BoostKrator;
import battle.BoostTyde;
import exceptions.StateUnmaintained;
import gfx.Colour;
import gfx.Drawing;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class StateBattle extends State
{
    private boolean boostActive;
    private Boost boostObject;
    
    public StateBattle()
    {
        System.out.println("STATE BATTLE");
        //
        this.boostNull();
    }
    
    private void boostCreate(Boost boost)
    {
        this.boostActive = true;
        this.boostObject = boost;
    }
    
    private void boostNull()
    {
        this.boostActive = false;
        this.boostObject = null;
    }

    public void inputKeyPress(String key)
    {
        //System.out.println("STATE BATTLE -> KEY PRESS");
        //
        if(this.boostActive)
        {
            this.boostObject.inputKeyPress(key);
            return;
        }
        //
        if(key.equals("SPACE"))
        {
            if(!this.boostActive)
            {
                System.out.println("BOOST CREATED");
                this.boostCreate(new BoostKrator());
                //this.boostCreate(new BoostTyde());
            }
        }
    }

    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputKeyType(String key)
    {
        //System.out.println("STATE BATTLE -> KEY TYPE (" + key + ")");
        // TEMP
        /*if(key.equals("SPACE"))
        {
            System.out.println("BOOST CREATED");
            this.boostCreate(new BoostKrator());
        }*/
    }

    public void inputMouseClickL(MouseEvent e)
    {
        //System.out.println("STATE BATTLE -> MOUSE CLICK");
        //
    }

    public void inputMouseClickR(MouseEvent e)
    {
        //
    }

    public void inputMouseMove(MouseEvent e)
    {
        //
    }
    
    public void render(Graphics g)
    {
        //System.out.println("STATE BATTLE -> RENDER");
        
        // Background
        g.setColor(Colour.getColour("GRASSLAND_1"));
        g.fillRect(0, 0, 1366, 768);
        
        // Temp
        g.drawImage(Drawing.getImage("characters/krator/battle.png"), 1100, 150, null);
        
        // Temp
        this.renderParty(g);
        
        // Temp
        if(this.boostActive) {this.boostObject.render(g);}
    }
    
    private void renderParty(Graphics g)
    {
        g.setColor(Colour.getColour("WHITE"));
        g.setFont(Fonts.getFont("STANDARD"));
        g.drawString("KRATOR", 970, 660);
        g.drawString("TYDE", 970, 695);
        g.drawString("??????", 970, 730);
        g.drawString("134", 1150, 660);
        g.drawString("102", 1150, 695);
        g.drawString("???", 1150, 730);
        g.drawString("64", 1250, 660);
        g.drawString("128", 1250, 695);
        g.drawString("???", 1250, 730);
    }

    public void tick()
    {
        if(this.boostActive)
        {
            if(this.boostObject.getBoostDone()) {this.boostNull(); }
            else {this.boostObject.tick();}
        }
    }
    
}