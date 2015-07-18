package states;

import app.Engine;
import battle.Boost;
import battle.BoostKrator;
import battle.BoostTyde;
import battle.Command;
import battle.UnitAlly;
import battle.UnitEnemy;
import exceptions.StateUnmaintained;
import gfx.Colour;
import gfx.Drawing;
import gfx.Fonts;
import gfx.Text;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StateBattle extends State
{
    // Battle
    private String battleState;
    private long battleTime;
    
    // Units
    private ArrayList<UnitAlly> unitAllies;
    private ArrayList<UnitEnemy> unitEnemies;
    
    // Command Menu
    private boolean commandActive;
    private ArrayList<Command> commandOptions;
    private int commandCursor;
    
    // Boost
    private boolean boostActive;
    private Boost boostObject;
    
    public StateBattle()
    {
        // Battle
        this.battleState = "INTRO";
        this.battleTime = System.nanoTime();
        
        // Units
        this.unitAllies = new ArrayList();
        this.unitEnemies = new ArrayList();
        
        // Command Menu
        this.commandNull();
        
        // Boost
        this.boostNull();
        
        // TEMP
        this.unitAddAlly(new UnitAlly(this, "Krator", Drawing.getImage("characters/Krator/battle.png"), 1100, 150));
        this.unitAddAlly(new UnitAlly(this, "Tyde", Drawing.getImage("characters/Tyde/battle.png"), 1100, 250));
        this.unitAddEnemy(new UnitEnemy(this, "Kawker", Drawing.getImage("units/dino/kawker.png"), 100, 100));
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
    
    private void commandNull()
    {
        this.commandActive = false;
        this.commandOptions = new ArrayList();
        this.commandCursor = 0;
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
        // Background
        g.setColor(Colour.getColour("GRASSLAND_1"));
        g.fillRect(0, 0, 1366, 768);
        
        // Units
        this.renderUnitAllies(g);
        this.renderUnitEnemies(g);
        
        // Temp
        this.renderParty(g);
        
        // Temp
        if(this.commandActive) {this.renderCommand(g);}
        
        // Temp
        if(this.boostActive) {this.boostObject.render(g);}
    }
    
    private void renderCommand(Graphics g)
    {
        g.setColor(Colour.getColour("WHITE"));
        g.setFont(Fonts.getFont("STANDARD_ITALIC"));
        g.drawString("commands", 50, 560);
        g.setFont(Fonts.getFont("STANDARD"));
        g.drawString("ATTACK", 50, 605);
        g.drawString("SKILLS", 50, 650);
        g.drawString("BERSERK", 50, 695);
        g.drawString("ITEM", 50, 740);
    }
    
    private void renderParty(Graphics g)
    {
        // TEMP
        g.setColor(Colour.getColour("BLACK"));
        g.setFont(Fonts.getFont("STANDARD"));
        Text.writeShadow(g, "KRATOR", 930, 650);
        Text.writeShadow(g, "TYDE", 930, 695);
        Text.writeShadow(g, "?????", 930, 740);
        Text.writeShadow(g, "134", 1120, 650);
        Text.writeShadow(g, "102", 1120, 695);
        Text.writeShadow(g, "???", 1120, 740);
        Text.writeShadow(g, "64", 1250, 650);
        Text.writeShadow(g, "128", 1250, 695);
        Text.writeShadow(g, "???", 1250, 740);
        
        // TEMP
        g.setColor(Colour.getColour("DISPLAY_CHARGE"));
        g.fillRect(930, 655, 150, 10);
        g.fillRect(930, 700, 150, 10);
        g.fillRect(930, 745, 150, 10);
        g.setColor(Colour.getColour("BLACK"));
        g.drawRect(930, 655, 150, 10);
        g.drawRect(930, 700, 150, 10);
        g.drawRect(930, 745, 150, 10);
        
        // TEMP
        g.setColor(Colour.getColour("DISPLAY_HEALTH"));
        g.fillRect(1120, 655, 100, 10);
        g.fillRect(1120, 700, 100, 10);
        g.fillRect(1120, 745, 100, 10);
        g.setColor(Colour.getColour("BLACK"));
        g.drawRect(1120, 655, 100, 10);
        g.drawRect(1120, 700, 100, 10);
        g.drawRect(1120, 745, 100, 10);
        
        // TEMP
        g.setColor(Colour.getColour("DISPLAY_ENERGY"));
        g.fillRect(1250, 655, 100, 10);
        g.fillRect(1250, 700, 100, 10);
        g.fillRect(1250, 745, 100, 10);
        g.setColor(Colour.getColour("BLACK"));
        g.drawRect(1250, 655, 100, 10);
        g.drawRect(1250, 700, 100, 10);
        g.drawRect(1250, 745, 100, 10);
    }
    
    private void renderUnitAllies(Graphics g)
    {
        for(int x = 0; x < this.unitAllies.size(); x++)
        {
            this.unitAllies.get(x).render(g);
        }
    }
    
    private void renderUnitEnemies(Graphics g)
    {
        for(int x = 0; x < this.unitEnemies.size(); x++)
        {
            this.unitEnemies.get(x).render(g);
        }
    }

    public void tick()
    {
        if(this.boostActive)
        {
            if(this.boostObject.getBoostDone()) {this.boostNull(); }
            else {this.boostObject.tick();}
        }
    }
    
    public void unitAddAlly(UnitAlly ally)
    {
        this.unitAllies.add(ally);
    }
    
    public void unitAddEnemy(UnitEnemy enemy)
    {
        this.unitEnemies.add(enemy);
    }
    
}