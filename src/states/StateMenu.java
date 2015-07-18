package states;

import app.Engine;
import exceptions.StateUnmaintained;
import gfx.Colour;
import gfx.Drawing;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateMenu extends State
{

    public StateMenu()
    {
        //
        System.out.println("STATE MENU");
    }

    public void inputKeyPress(String key)
    {
        System.out.println("STATE MENU -> KEY PRESS");
        try {Engine.resumeState();}
        catch (StateUnmaintained ex) {System.out.println(ex);}
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
        System.out.println("STATE MENU -> MOUSE CLICK");
        try {Engine.resumeState();}
        catch (StateUnmaintained ex) {System.out.println(ex);}
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
        System.out.println("STATE MENU -> RENDER");
        
        // Background
        g.setColor(Colour.getColour("BLACK"));
        g.fillRect(0, 0, 1366, 768);
    }

    public void tick()
    {
        //
    }
    
}