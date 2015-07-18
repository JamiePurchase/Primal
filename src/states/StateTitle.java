package states;

import app.Engine;
import gfx.Colour;
import gfx.Drawing;
import gfx.Fonts;
import gfx.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class StateTitle extends State
{
    private int menuNow, menuMax;
    
    public StateTitle()
    {
        this.menuNow = 1;
        this.menuMax = 2;
    }

    public void inputKeyPress(String key)
    {
        if(key.equals("UP") && this.menuNow > 1) {this.menuNow -= 1;}
        if(key.equals("DOWN") && this.menuNow < this.menuMax) {this.menuNow += 1;}
        if(key.equals("ENTER") || key.equals("SPACE"))
        {
            if(this.menuNow == 1) {Engine.setState(new StateWorld());}
            if(this.menuNow == 2) {Engine.setState(new StateBattle());}
        }
    }

    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputKeyType(String key)
    {
        //
    }

    public void inputMouseClickL(MouseEvent e)
    {
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
        // Background
        g.setColor(Colour.getColour("BLACK"));
        g.fillRect(0, 0, 1366, 768);
        
        // Title
        g.drawImage(Drawing.getImage("interface/title/title3.png"), 0, 25, null);
        
        // Options
        g.setColor(Colour.getColour("TITLE_TEXT"));
        g.setFont(Fonts.getFont("STANDARD"));
        Text.write(g, "BOARD", 400, 400);
        Text.write(g, "BATTLE", 400, 450);
        Text.write(g, ">", 370, (this.menuNow * 50) + 350);
        
        // Details
        g.setColor(Colour.getColour("TITLE_TEXT"));
        g.setFont(Fonts.getFont("STANDARD"));
        Text.write(g, "Version 0.1.0 [alpha]", 25, 750);
        Text.write(g, "Updated 18/07/2015", 1341, 750, "RIGHT");
    }

    public void tick()
    {
        //
    }
    
}