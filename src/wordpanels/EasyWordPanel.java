package wordpanels;

import javax.swing.*;
import java.awt.*;

public class EasyWordPanel extends JPanel{
    protected  WordBox t1 = new WordBox();
    protected WordBox t2 = new WordBox();

    public EasyWordPanel()
    {  
        // t1 refresh every sec
        this.setLayout(new GridLayout(1, 3));
        t2.updateTimerDelay(90); // refresh every 0.9 sec
        //set x axis of box
        this.changeX(100);
        // add t1 and t2 to pannel
        this.add(t1);
        this.add(t2);

    }

    public void startTimer()
    {
        t1.startTimer();
        t2.startTimer();

    }
    // reset coordinate 
    public void resetPanelCoordinate()
    {
        t1.resetBoxCoordinate();
        t2.resetBoxCoordinate();
    }

    protected void changeX(int i)
    {
        t1.setX(i);
        t2.setX(i);
    }
    public void stopTimer()
    {
        t1.stopTimer();
        t2.stopTimer();
    }
    public void setBgColor()
    {
        t1.setBgColor();
        t2.setBgColor();
    }

    
}
