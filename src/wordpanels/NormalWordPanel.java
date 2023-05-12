package wordpanels;

import javax.swing.*;
import java.awt.*;

public class NormalWordPanel extends JPanel{
    NormalWordBox t1 = new NormalWordBox();
    NormalWordBox t2 = new NormalWordBox();
    NormalWordBox t3 = new NormalWordBox();

    public NormalWordPanel()
    {
        this.setLayout(new GridLayout(1, 3));
        t2.updateTimerDelay(90); // refresh every 0.9 sec
        //set x axis of box
        this.changeX(50);
        t3.updateTimerDelay(100);
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
        t3.startTimer();
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
