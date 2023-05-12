package wordpanels;

import javax.swing.*;
import java.awt.*;

public class HardWordPanel extends JPanel{
    HardWordBox t1 = new HardWordBox();
    HardWordBox t2 = new HardWordBox();
    HardWordBox t3 = new HardWordBox();

    public HardWordPanel()
    {
        this.setLayout(new GridLayout(1, 3));
        t1.updateTimerDelay(60);
        t2.updateTimerDelay(70); // refresh every 0.9 sec
        //set x axis of box
        this.changeX(50);
        t3.updateTimerDelay(50);
        // add t1 and t2 to pannel
        this.add(t1);
        this.add(t2);
        this.add(t3);
    }
    
    public void startTimer()
    {
        t1.startTimer();
        t2.startTimer();
        t3.startTimer();
    }

    public void resetPanelCoordinate()
    {
        t1.resetBoxCoordinate();
        t2.resetBoxCoordinate();
        t3.resetBoxCoordinate();
        //t3.startTimer(); // wrong command 
    }

    protected void changeX(int i)
    {
        t1.setX(i);
        t2.setX(i);
        t3.setX(i);
    }

    public void stopTimer()
    {
        t1.stopTimer();
        t2.stopTimer();
        t3.stopTimer();
    }

    public void setBgColor()
    {
        t1.setBgColor();
        t2.setBgColor();
        t3.setBgColor();
    }
}
