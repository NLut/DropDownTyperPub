package borders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cores.Value;

public class Ground extends SideWall {
    // create object just like declare variable can create either at property section or constructor section
    // but if we declare obj in property section when we create every time when we use that class.ќ
    // but if we declare obj in constructor it will only create when we call that constructor.
    // according to good desing code.
    Color ground = new Color(36, 19, 5);
    Color grass = new Color(31, 73, 12);
    Color rock = new Color(143, 138, 124);
    JTextField inputTf = new JTextField(100);
    ItemsPotion it = new ItemsPotion();
    String text;
    public Ground ()
    {
        // BorderLayout
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Value.width, 100));//set custom west size
        this.setBackground(ground);
        // add grass to NORTH
        JPanel gra = new JPanel();
        gra.setBackground(grass);
        this.add(gra, BorderLayout.NORTH);

        // add ground to CENTER
        JPanel gro = new JPanel(new GridLayout(1, 2));
        // 3 items bt
        gro.setBackground(ground);
        this.add(gro, BorderLayout.CENTER);
        inputTf.setFont(new Font("serif", Font.PLAIN, 40));
        inputTf.setBackground(rock);
        inputTf.setForeground(Color.BLACK);
    
        //text field inside ground
        gro.add(inputTf);
        inputTf.addActionListener(new ComputeUsrInput()); // inputTF add ComputeUsrInput as listener and fire/grab event to ComputeUsrInput
        // // a lot of event is floting in System we just grab them.
        gro.add(it);
  

    }
    public void resetTf()
    {
    	inputTf.setText("");
    }
    

    class ComputeUsrInput implements ActionListener// inner class that take action will give one class can take more ActionListener include the class that have timer
    // because we can take more ActionListener in inner class.
    { 
		public void actionPerformed(ActionEvent e)
		{
            // will have event for each itme that press enter
		    Value.inputText = inputTf.getText(); // get input every time that enter 
            inputTf.setText(""); // refresh tf
            //System.out.println(Value.inputText); --> debugger
		}
    }


}
