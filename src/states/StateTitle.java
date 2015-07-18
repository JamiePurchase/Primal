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
    
    public StateTitle()
    {
        //
    }

    public void inputKeyPress(String key)
    {
        Engine.setState(new StateBattle());
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
        Engine.setState(new StateWorld());
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
        Text.write(g, "Version 0.1.0 [alpha]", 25, 750);
        Text.write(g, "Updated 18/07/2015", 1341, 750, "RIGHT");
    }

    public void tick()
    {
        //
    }
    
}