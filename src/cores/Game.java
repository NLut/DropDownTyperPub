package cores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import wordpanels.*;
import borders.SideWall;
import borders.Ground;
import borders.TopBorder;


public class Game extends JFrame implements ActionListener // event from timer and bt
{
    private int width = Value.width;
    private int height = Value.height;
    private int fontsize = 43;
    private Font serif = new Font("Serif", Font.BOLD, fontsize); //font, instead greate font everytime that we set font
    private Color startBg = new Color(31, 40, 56);
    private Color startTxt = new Color(194, 147, 93);
    private Color easyBtColor = new Color(150, 199, 131);
    private Color normalBtColor = new Color(214, 206, 133);
    private Color hardBtColor = new Color(196, 81, 81);
    // private String diff;
    private String mode; // use to check what mode we will remove
//-----------------------------------------------------
    // bigDiffPanel
    JPanel startPanel = new JPanel(new BorderLayout());
//-----------------------------------------------------
    //diffPanel
    JPanel diffPanel = new JPanel(new GridLayout(4, 1));

    JLabel diffLb = new JLabel("Please select the difficulty");
    JButton easyBt = new JButton("EASY");
    JButton normalBt = new JButton("NORMAL");
    JButton hardBt = new JButton("HARD");
//-----------------------------------------------
    //environmentPanel
    JPanel skyThemePanel = new JPanel(new GridLayout(4, 1));
    JLabel themeSelectLb = new JLabel("|Theme");
    JRadioButton dayRb = new JRadioButton("Day");
    JRadioButton nightRb = new JRadioButton("Night");
//-----------------------------------------------
    Timer loop = new Timer(Value.delay, this);
//-----------------------------------------------
    // game environment
    
	//create SideWall 
    SideWall left = new SideWall();
    SideWall right = new SideWall();
    //create Top border  
	TopBorder top = new TopBorder();
	//create ground 
    Ground btm = new Ground();
    //create CENTER
    EasyWordPanel easyPanel = new EasyWordPanel();
    NormalWordPanel normalPanel = new NormalWordPanel();
    HardWordPanel hardPanel = new HardWordPanel();
    Game(String s) // At first I make obj inside constructor and actionPerformed can't detect any obj, then I change to define obj at property section and everything work fine.
    {
        //Create main frame
        super(s);
		this.setSize(width, height);
		this.setLocationRelativeTo(null); // set to start at middle
        
        //difficulty select panel
        //-------------------------------------------------------------
        
        // label 
        diffLb.setFont(serif);
        diffLb.setOpaque(true); // default is false and make us can't set bg.
        diffLb.setForeground(startTxt);
        diffLb.setBackground(startBg);
        diffPanel.add(diffLb);

        // easybt
        easyBt.setFont(serif);
        easyBt.setBackground(easyBtColor);
        easyBt.addActionListener(this);
        diffPanel.add(easyBt);

        // normalbt
        normalBt.setFont(serif);
        normalBt.setBackground(normalBtColor);
        normalBt.addActionListener(this);
        diffPanel.add(normalBt);

        // hardbt
        hardBt.setFont(serif);
        hardBt.setBackground(hardBtColor);
        hardBt.addActionListener(this);
        diffPanel.add(hardBt);
        diffPanel.setBackground(startBg);
        //-------------------------------------------------------------
        // skyEnvPanel
        themeSelectLb.setFont(serif);
        themeSelectLb.setOpaque(true);
        themeSelectLb.setBackground(startBg);
        themeSelectLb.setForeground(startTxt);

        dayRb.setFont(serif);
        dayRb.setBackground(startBg);
        dayRb.setForeground(startTxt);
        dayRb.addItemListener(new GameTheme());
        //
        nightRb.setFont(serif);
        nightRb.setBackground(startBg);
        nightRb.setForeground(startTxt);
        nightRb.addItemListener(new GameTheme());
        //
        //
        skyThemePanel.setBackground(startBg);
        skyThemePanel.add(themeSelectLb);
        skyThemePanel.add(dayRb);
        skyThemePanel.add(nightRb);
        //--------------------------------------------------------------
        // add every panel to startPanel
        startPanel.add(diffPanel, BorderLayout.CENTER);
        startPanel.add(skyThemePanel, BorderLayout.EAST);
        this.add(startPanel, BorderLayout.CENTER);
		

		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == easyBt) // change environment to easy
        {
            mode = "easy";
            loop.start(); // to start loop again
            JOptionPane.showMessageDialog(this, "Difficulty set to Easy."); // pop up new small window(dialog) after select mode.
            //System.out.println("easy"); --> debugger
			this.remove(startPanel);
            //add CENTER
            this.setBgColor(); //set bg here
		    this.add(easyPanel, BorderLayout.CENTER);
			setEnvironment();
            easyPanel.startTimer(); // seperate call because if call in constructor timer will start imediately
			this.validate();
			this.repaint();
        }
        else if (e.getSource() == normalBt)
        {
            mode = "normal";
            loop.start(); // to start loop again
            JOptionPane.showMessageDialog(this, "Difficulty set to Normal."); // pop up new small window(dialog) after select mode.
            //System.out.println("normal"); --> debugger
			this.remove(startPanel);
            //add CENTER
            this.setBgColor(); // set bg here
            this.add(normalPanel, BorderLayout.CENTER);
			setEnvironment();
            normalPanel.startTimer(); // seperate call because if call in constructor timer will start imediately
			this.validate();
			this.repaint();
        }
        else if (e.getSource() == hardBt)
        {
            mode = "hard";
            loop.start(); // to start loop again
            JOptionPane.showMessageDialog(this, "Difficulty set to Hard."); // pop up new small window(dialog) after select mode.
            //System.out.println("hard"); --> debugger
			this.remove(startPanel);
            //add CENTER
            this.setBgColor();
            this.add(hardPanel, BorderLayout.CENTER);
			setEnvironment();// set environment panle
            hardPanel.startTimer(); // seperate call because if call in constructor timer will start imediately
			this.validate();
			this.repaint();
        }
        
        if (Value.health <= 0) //stop loop // use timer to fire event to check this condition 
        {
            JOptionPane.showMessageDialog(this, "GameOver\nYour score is: " + "" + Value.score); // wait for score telling
            // JOptionPane will fire event to this and it will make infinite loop.
            loop.stop();
            Value.resetAll(); // reset health and score
            removeEnvironment(); // remove every pannel
            this.add(startPanel, BorderLayout.CENTER); 
            btm.resetTf(); // reset text field
			this.validate();
			this.repaint();
            //System.out.print(""+ Value.health); --> debugger

        }
        

    }
    
    // use to set pannel environment
    private void setEnvironment()
    {
        //add to EAST and WEST
 
        this.add(left, BorderLayout.EAST);
        this.add(right, BorderLayout.WEST);

		//add to NORTH
		this.add(top, BorderLayout.NORTH);
        
        //add to SOUTH
		this.add(btm, BorderLayout.SOUTH);
        
    }
    // use to remove panel
    private void removeEnvironment() // not use removeAll because it like remove everything
    {
        this.remove(left);
        this.remove(right);
		this.remove(top);
		this.remove(btm);
        if (mode.equals("easy"))
        {
            easyPanel.resetPanelCoordinate();
            easyPanel.stopTimer();
            this.remove(easyPanel);

        }
        else if (mode.equals("normal")) // I wonder why normal and hard have to stoptimer 2 time but easy just only one
        {
            normalPanel.resetPanelCoordinate();
            normalPanel.stopTimer();
            this.remove(normalPanel);

        }
        else if (mode.equals("hard")) 
        {
            hardPanel.resetPanelCoordinate();
            hardPanel.stopTimer();
            this.remove(hardPanel);
        }    
    }
    private void setBgColor()
    {
		if (mode.equals("easy"))
		{
		    easyPanel.setBgColor(); // set color in this because if set in constructor Value.bg haven't change.
		}
		else if (mode.equals("normal")) // I wonder why normal and hard have to stoptimer 2 time but easy just only one
		{
		    normalPanel.setBgColor();
		}
		else if (mode.equals("hard")) 
		{
		    hardPanel.setBgColor();
		}    

    }
    class GameTheme implements ItemListener
    {
        // at first try to change bg here but can't specify mode before select mode so it cause error which mode is null.
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getSource() == dayRb && e.getStateChange() == 1)
            {
                nightRb.setSelected(false);
                Value.bg = "day";
            }
            else if (e.getSource() == nightRb && e.getStateChange() == 1)
            {
                dayRb.setSelected(false);
                Value.bg = "night";

            }
       }
    }
}
