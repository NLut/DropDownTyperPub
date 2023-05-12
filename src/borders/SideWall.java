package borders;

import java.awt.*;
import javax.swing.*;
import cores.Value;

public class SideWall extends JPanel // Jpanel
{
    protected int x = 0;
    protected int y = 0;
    protected int end_x = Value.width;
    protected int end_y = Value.height;
    Color bg = new Color(166, 89, 21); // set color by Color(r ,g ,b)
    Color line = new Color(58, 30, 6); // set color by Color(r ,g ,b)

    // no arg constructor
    public SideWall()
    {
        this.setPreferredSize(new Dimension(100, end_y));
        this.setBackground(bg);
    }

    final protected void paintComponent(Graphics g)  // final because i don't want sub calss draw this
    {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // type casting
        g2.setStroke(new BasicStroke(3));
		for (int x = 0; x <= end_x; x += 15) 
        { 	
		    g2.setColor(line);
		    g2.drawLine(x, y, x, end_y); // draw vertical line
		   
		    for (int y = 0; y <= end_y; y += 10) 
            {
		        g2.drawLine(x, y, end_x, y); // draw horizontal line
		    }
		}
}
    // $$Infinite loop: first time is fine everything execute correctly
    // $$ but after first time everything in paintComponent will not execute because x is <= end_x already;
    // $$ fix by declare x after wile loop (line 51)
    // protected void paintComponent(Graphics g)
    // {
    //     super.paintComponent(g);
    //     while (x <= end_x)
    //     {   
    //         g.setColor(line);
    //         g.drawLine(x, y, x, end_y); // draw vertical line
    //         while (y < end_y)
    //         {
    //             g.drawLine(x, y, end_x, y); // draw horizontal line
    //             y += 5;
    //         }
    //         y = 0;
    //         x += 10;
    //     }
    // }
    // protected void paintComponent(Graphics g)
    // {
    //     super.paintComponent(g);
    //     g.setColor(line);
    //     while (x < end_x)
    //     {   
    //         g.drawLine(x, y, x, end_y);
    //         x += 5;
    //     }
    // }
}
