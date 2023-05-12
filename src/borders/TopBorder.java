package borders;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import cores.Value;

public class TopBorder extends JPanel implements ActionListener{ //event from timer
    // Color
    Color cTopDark = new Color(120, 51, 13);
    Color cTopLight = new Color(166, 89, 21);
    Color cTopDarkest = new Color(56, 23, 5);
    Color heartColor = new Color(227, 23, 57);
    Color bgHeartColor = new Color(0, 0, 0);
    Color scoreColor = new Color(255, 255, 255);

    
    //sub pannel
    JPanel blank[] = new JPanel[3];
    
    //variable
    int init_x = Value.width - 50;
    int  init_y = 50;
    Timer timer = new Timer(100, this); // generate event every 100 millisec.
    // healt will deduct due to corision box and ground will deduct.
    public TopBorder()
    {
        // GridLayout (big pannel) abd set size
        this.setBackground(cTopDarkest);
        this.setPreferredSize(new Dimension(init_x, 60));
        timer.start();
        
        
    }
        
    // draw by paintComponent and redraw by detect event from timer which will refresh every 100ms
    // draw Heart and Score 
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            for (int i = 0, x = init_x, y = init_y; i < Value.health; i++) // draw heart == Value.health every action taken.(by timer)
            
            {
                g.setColor(bgHeartColor);
                g.setFont(new Font("Serif", Font.PLAIN, 43));
                g.drawString("♥", x , y);
                g.setColor(heartColor);
                g.setFont(new Font("Serif", Font.PLAIN, 40));
                g.drawString("♥", x , y);
                g.setColor(scoreColor);
                g.drawString("" + Value.score, 50, y); // "" + int = String
                x -= 40;
            }
        }
        public void actionPerformed(ActionEvent e)    
        {
                repaint();
        }
    
}


