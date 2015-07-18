package world;

import entities.EntityCharacter;
import gfx.Drawing;
import java.awt.Graphics;

public class Board
{
    private int renderPosX, renderPosY, renderSizeX, renderSizeY;
    private int boardSizeX, boardSizeY;
    private String terrain[][];
    private int boardScrollX, boardScrollY;
    
    // TEMP
    private EntityCharacter player;
    
    public Board()
    {
        this.renderPosX = 11;
        this.renderPosY = 32;
        this.renderSizeX = 21;
        this.renderSizeY = 11;
        this.boardSizeX = 100;
        this.boardSizeY = 100;
        this.terrain = new String[boardSizeX][boardSizeY];
        createTerrain("1");
        this.boardScrollX = 0;
        this.boardScrollY = 0;
        
        // TEMP
        this.player = new EntityCharacter(this, "Krator", 0, 0, "characters/krator/");
    }
    
    private void createTerrain(String terrain)
    {
        for(int x = 0; x < this.boardSizeX; x++)
        {
            for(int y = 0; y < this.boardSizeY; y++)
            {
                this.terrain[x][y] = terrain;
            }
        }   
    }
    
    public EntityCharacter getPlayer()
    {
        return this.player;
    }
    
    public int getRenderPosX(int tileX)
    {
        return this.renderPosX + tileX - (this.boardScrollX * 64);
    }
    
    public int getRenderPosY(int tileY)
    {
        return this.renderPosY + tileY - (this.boardScrollY * 64);
    }
    
    public void render(Graphics g)
    {
        this.renderTerrain(g);
        this.player.render(g);
    }
    
    private void renderTerrain(Graphics g)
    {
        for(int x = 0; x < this.renderSizeX; x++)
        {
            for(int y = 0; y < this.renderSizeY; y++)
            {
                int tileX = x + boardScrollX;
                int tileY = y + boardScrollY;
                g.drawImage(Drawing.getImage("terrain/1.png"), this.renderPosX + (64 * x), this.renderPosY + (64 * y), null);
            }
        }
    }
    
}