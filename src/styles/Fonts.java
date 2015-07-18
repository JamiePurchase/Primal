package styles;

import java.awt.Font;

public class Fonts
{
    
    public static void loadFonts()
    {
        gfx.Fonts.addFont("BOOST_COMMAND", new Font("Segoe Print", Font.PLAIN, 36));
        gfx.Fonts.addFont("STANDARD", new Font("Segoe Print", Font.PLAIN, 26));
        gfx.Fonts.addFont("STANDARD_ITALIC", new Font("Segoe Print", Font.ITALIC, 26));
    }
    
}