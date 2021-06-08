import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public void paint(Graphics g) {

        // Draws title image border
        g.setColor(Color.BLUE);
        g.drawRect(24, 9, 851, 56);

        // Draws the title image
        ImageIcon titleImage = new ImageIcon("images/finaltemp.jpg");
        titleImage.paintIcon(this, g, 25, 10);

        // Draws border for playing area
        g.setColor(Color.BLUE);
        g.drawRect(24, 74, 851, 577);

        // Draw background for the game play
        g.setColor(Color.BLUE);
        g.fillRect(25, 75, 851, 577);
    }
}



