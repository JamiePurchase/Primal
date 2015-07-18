package states;

import app.Engine;
import entities.EntityCharacter;
import gfx.Colour;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import world.Board;

public class StateWorld extends State
{
    private Board board;
    
    public StateWorld()
    {
        this.board = new Board();
    }

    public void inputKeyPress(String key)
    {
        if(key.equals("DOWN")) {this.board.getPlayer().push("S");}
        if(key.equals("LEFT")) {this.board.getPlayer().push("W");}
        if(key.equals("RIGHT")) {this.board.getPlayer().push("E");}
        if(key.equals("UP")) {this.board.getPlayer().push("N");}
    }

    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputKeyType(String key)
    {
        if(key.equals("ENTER")) {Engine.setState(new StateMenu(), true);}
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
        System.out.println("STATE WORLD -> KEY PRESS");
        this.renderBoard(g);
        this.renderFrame(g);
    }
    
    private void renderBoard(Graphics g)
    {
        this.board.render(g);
    }
    
    private void renderFrame(Graphics g)
    {
        g.setColor(Colour.getColour("WORLD_FRAME_BACKGROUND"));
        g.fillRect(0, 0, 11, 768);
        g.fillRect(1355, 0, 11, 768);
        g.fillRect(0, 0, 1366, 32);
        g.fillRect(0, 736, 1366, 32);
        g.setColor(Colour.getColour("WORLD_FRAME_BORDER"));
        g.drawRect(11, 32, 1344, 704);
    }

    public void tick()
    {
        //
    }
    
}