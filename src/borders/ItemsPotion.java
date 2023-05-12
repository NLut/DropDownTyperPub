package borders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cores.Value;

public class ItemsPotion extends JPanel{
    private int x = 100;
    private int y = 50;
    private int width = 60;
    private int height = 60;
    private int r = Math.round(width / 2);
    Color sqColor = new Color(181, 149, 69);
    Color sqColorDarker = new Color(61, 53, 32);
    Color cirRedColor = new Color(240, 114, 89);
    Color cirRedColorDarker = new Color(94, 55, 47);
    Color cirBlueColor = new Color(147, 218, 219);
    Color cirBlueColorDarker = new Color(44, 66, 66);

    public ItemsPotion()
    {
        this.addMouseListener(new GameItems());
    }

    protected void paintComponent(Graphics g)
    {
        //square item // clear
        g.setColor(sqColor);
        g.fillRect(x - r , y - r , width, height);

        //circle item // health
        g.setColor(cirRedColor);
        g.fillOval(x + 100 - r , y - r, width, height);

        //circle item // slow

        g.setColor(cirBlueColor);
        g.fillOval(x + 200 - r, y - r , width, height);
        
    }


    class GameItems implements MouseListener
    {
		public void mousePressed(MouseEvent e)
		{
            Graphics g = getGraphics(); // use to change color when button got click
            int mouseX = e.getX();
            int mouseY = e.getY();
            
            if(calculateDistance(Value.squareX, y, mouseX, mouseY) <= r)
            {
                Value.clearIt = true; // change to true and method from WordBox will perform 
                //System.out.println("Clear Item has been used"); --> debugger
                g.setColor(sqColorDarker);
                g.fillRect(x - r , y - r , width, height);
                Value.squareX = 5000; // setout of frame so usr can't press second time
            }
            else if(calculateDistance(Value.redCirX + 100, y, mouseX, mouseY) <= r)
            {
                Value.healthIt = true;
                //System.out.println("Health Item has been used"); --> debugger
                g.setColor(cirRedColorDarker);
                g.fillOval(x + 100 - r , y - r, width, height);
                Value.redCirX = 5000;// setout of frame so usr can't press second time


            }
            else if(calculateDistance(Value.blueCirX + 200, y, mouseX, mouseY) <= r)
            {
                Value.freezeIt = true;
                //System.out.println("Freeze Item has been used"); --> debugger
                g.setColor(cirBlueColorDarker);
                g.fillOval(x + 200 - r , y - r, width, height);
                Value.blueCirX = 5000;// setout of frame so usr can't press second time
            }
            
 
		}
 
		public void mouseReleased(MouseEvent e)
		{

		}
 
		public void mouseExited(MouseEvent e)
		{
 
		}
 
		public void mouseEntered(MouseEvent e)
		{
 
		}
 
		public void mouseClicked(MouseEvent e)
		{
 
		}

		double calculateDistance(int x1, int y1, int x2, int y2) 
		{
			return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		}
    }
}
