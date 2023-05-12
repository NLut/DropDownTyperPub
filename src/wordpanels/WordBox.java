package wordpanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import cores.Value;

public class WordBox extends JPanel // event from timer
// will create inner class
{
    protected int x = 25;
    protected int y = 100;
    double numCount = 0;
    int end_y = Value.height;
    int detect = end_y - 240; 
    int xmargin = Math.round(x / 2);
    int ymargin = Math.round(y / 3);
    String strInBox; // initial word will be null

    Color dayBg = new Color(117, 184, 235);
    Color dayBox = new Color(16, 13, 33);

    Color nightBg = new Color(10, 17, 46);
    Color nightBox = new Color(150, 92, 56);

    Color evenBg = new Color(219, 147, 194);
    Color evenBox = new Color(133, 201, 167);
    // Random
    Random rand = new Random();
    // word array
    // easy  = index 0-219
    // normal  = index 0-419
    // hard  = index 0 - 519
    String Word[] = {
  "car", "dog", "cat", "man", "hat", "run", "pen", "fan", "mat", "cup", 
  "bag", "key", "egg", "ice", "day", "fly", "fun", "old", "red", "big", 
  "hot", "one", "two", "sun", "cow", "fox", "bee", "dig", "map", "sky", 
  "hit", "let", "lip", "lot", "net", "nod", "pan", "pod", "row", "see", 
  "tan", "tip", "van", "wet", "yak", "zap", "ash", "box", "cut", "den", 
  "eel", "fed", "get", "hop", "ink", "jog", "kit", "log", "mop", "nut", 
  "owl", "pay", "qat", "ram", "sin", "tag", "use", "vow", "was", "yew", 
  "zoo", "air", "bug", "cry", "day", "eel", "fig", "gem", "hog", "ink", 
  "jig", "kin", "lid", "mob", "nun", "owl", "pop", "qua", "run", "sis", 
  "tie", "urn", "vet", "web", "yes", "zig", "ant", "bee", "cow", "dot", 
  "eel", "fur", "gem", "hug", "ill", "jot", "kid", "lit", "mud", "nap", 
  "orb", "pot", "quay", "rug", "sad", "tin", "use", "van", "wig", "axe", 
  "yak", "zap", "ark", "bus", "cub", "dye", "eel", "flu", "gym", "hop", 
  "ivy", "jib", "kit", "lap", "mix", "nut", "oak", "peg", "qua", "rap", 
  "son", "top", "urn", "van", "wit", "axe", "yam", "zip", "ape", "bet", 
  "cow", "dig", "eel", "fur", "gem", "hat", "ink", "joy", "kit", "lip", 
  "mug", "net", "oar", "peg", "qua", "red", "sun", "tug", "urn", "vet", 
  "wax", "yap", "zit", "aid", "bug", "cop", "duo", "eel", "fur", "gut", 
  "hex", "ink", "jog", "keg", "leg", "moo", "nod", "oaf", "pig", "qua", 
  "rod", "sis", "tug", "urn", "vat", "wry", "yak", "zip", "ace", "bat", 
  "cot", "die", "eel", "flu", "gym", "hay", "ivy", "jot", "keg", "lap", 
  "mix", "nut", "oak", "pea", "quo", "rat", "sow", "tip", "urn", "vat",
    "able", "acid", "aged", "also", "area", "army", "away", "baby", "back", "ball", 
"band", "bank", "base", "bear", "beat", "been", "beer", "bell", "belt", "best", 
"bill", "bird", "blow", "blue", "boat", "body", "bomb", "bond", "bone", "book", 
"boom", "born", "boss", "both", "bowl", "burn", "bush", "busy", "cake", "call", 
"calm", "came", "camp", "card", "care", "case", "cash", "cast", "cell", "cent", 
"chip", "city", "clay", "club", "coal", "coat", "code", "cold", "come", "cook", 
"cool", "cope", "copy", "core", "cost", "crew", "crop", "dark", "data", "date", 
"dawn", "dead", "deal", "dear", "debt", "deep", "deer", "desk", "dial", "dice", 
"diet", "disc", "disk", "dock", "does", "done", "door", "dose", "down", "draw", 
"dress", "drop", "drug", "drum", "dual", "duke", "dust", "duty", "each", "earn", 
"east", "easy", "edge", "else", "even", "ever", "evil", "exit", "face", "fact", 
"fade", "fail", "fair", "fall", "farm", "fast", "fate", "fear", "feed", "feel", 
"feet", "fell", "felt", "file", "fill", "film", "find", "fine", "fire", "firm", 
"fish", "five", "flat", "flow", "food", "foot", "ford", "form", "fort", "four", 
"free", "from", "fuel", "full", "fund", "gain", "game", "gate", "gave", "gear", 
"gene", "gift", "girl", "give", "glad", "goal", "goes", "gold", "gone", "good", 
"gray", "grew", "grey", "grid", "grow", "gulf", "hair", "half", "hall", "hand", 
"hang", "hard", "harm", "hate", "have", "head", "heal", "hear", "heat", "held", 
"help", "herb", "here", "hero", "hide", "high", "hill", "hint", "hire", "hold", 
"hole", "holy", "home", "hope", "host", "hour", "huge", "hung", "hunt", "hurt", 
"idea", "inch", "into", "iron", "item", "jack", "jazz", "jest", "joke", "jump", 
"jury", "just", "keen", "keep", "kept", "kick", "kill", "kind", "king", "knee", 
"knit", "know", "lack", "lady", "laid", "lake", "land", "lane", "last", "late", 
"lead", "potato", "yellow", "famous", "camera", "window", "banana", "runner", "expert", "rocket", "coffee", 
"dinner", "purple", "forest", "master", "dragon", "eagle", "planet", "guitar", "police", "pencil", 
"artist", "basket", "family", "friend", "pickle", "orange", "bottle", "singer", "monkey", "summer", 
"tongue", "sunset", "butter", "saddle", "cookie", "circle", "silver", "melody", "church", "buzzer", 
"purple", "forest", "dragon", "eagle", "planet", "guitar", "police", "pencil", "artist", "basket", 
"family", "friend", "pickle", "orange", "bottle", "singer", "monkey", "summer", "tongue", "sunset", 
"butter", "saddle", "cookie", "circle", "silver", "melody", "church", "buzzer", "muscle", "market", 
"basket", "camera", "yellow", "banana", "orange", "forest", "runner", "pickle", "police", "singer", 
"rocket", "window", "expert", "planet", "coffee", "purple", "bottle", "circle", "dragon", "summer", 
"friend", "tongue", "butter", "basket", "cookie", "eagle", "melody", "church", "silver", "sunset", 
"pencil", "guitar", "artist", "monkey", "family", "buzzer", "master", "saddle", "potato", "famous", 
"market", "muscle", "camera", "yellow", "banana", "orange", "forest", "runner", "pickle", "police", 
"singer", "rocket", "window", "expert", "planet", "coffee", "purple", "bottle", "circle", "dragon", 
"summer", "friend", "tongue", "butter", "basket", "cookie", "eagle", "melody", "church", "silver", 
"sunset", "pencil", "guitar", "artist", "monkey", "family", "buzzer", "master", "saddle", "potato", 
"famous", "market", "muscle" };
    //len word -- use in random index
    // int arrlength = easyWord.length();
    Timer timer = new Timer(100, new Text()); // generate event every 100 milliseck
    public WordBox()
    {
        strInBox = getString(); // make initial word not be null
        //System.out.println(strInBox); --> debugger
        //System.out.println(Value.bg); --> debugger
    }
    
    protected void paintComponent(Graphics g)
    {
        //word box
        super.paintComponent(g);
        // use Value.bg to check and change box color
        if (Value.bg.equals("day"))
        {
            g.setColor(dayBox);
        }
        else if (Value.bg.equals("night"))
        {
            g.setColor(nightBox);
        }
        else if (Value.bg.equals("even"))
        {
            g.setColor(evenBox);
        }


        // if else condition to make different box size which depense on word length.
        if (strInBox.length() == 3)
        {
            g.fillRect(x, y, 80, 50);
        }
        else if (strInBox.length() == 4)
        {
            g.fillRect(x, y, 100, 50);
        }
        else if (strInBox.length() == 5)
        {
            g.fillRect(x, y, 125, 50);
        }
        else
        {
            g.fillRect(x - 10, y, 150, 50);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD, 30));
        //g.drawString(strInBox,x,y); // !!!! this line cuse bug, may be type error 
        g.drawString("" + strInBox,(x + xmargin),(y+ymargin)); // this is normal
    }
    public void startTimer()
    {
        timer.start();
    }

    public void stopTimer()
    {
        timer.stop();
    }
    // get random string from wordlist
    protected String getString() 
    {
        return Word[rand.nextInt(219)]; // get random string (-1 because of index)
    }
    // use to change time delay
    public void updateTimerDelay(int i)
    {
        timer.setDelay(i);
    }
    // use to reset box coordinate when game over -> prepare to start again
    public void resetBoxCoordinate()
    {
        this.y = 0;
    }
    // set x coordinate 
    public void setX(int i)
    {
        x = i;
    }
    // set bg color
    public void setBgColor()
    {
        if (Value.bg.equals("day"))
        {
            this.setBackground(dayBg);
        }
        else if (Value.bg.equals("night"))
        {
            this.setBackground(nightBg);
        }
        else if (Value.bg.equals("even"))
        {
            this.setBackground(evenBg);
        }
    }
    
    class Text implements ActionListener  //inner class
    {


        public void actionPerformed(ActionEvent e)    
        {
            //System.out.println(getString()); --> debugger
			numCount += 1; // numCount will +1 every 0.1 second according to have event every 100ms
			if (Value.health <= 0) //stop loop, if not stop it will cause infinite loop, this loop will stop before loop in game class
			{
			    timer.stop();

			}
			if (y < end_y) // if not hit ground 
			{   
                y += Value.dropSpeed;
                repaint();
			}

			if (y == detect) // decuct static health // if word touch ground decrease health and change word
			{
                strInBox = getString(); 
                //System.out.println(strInBox); --> debugger
			    y = 0;
			    Value.health --;
			    //System.out.println(Value.health); // then health will redraw in TopBorder/ //--> debugger
			}
            if (Value.inputText.equals(strInBox) || Value.clearIt) // error because Value.inputText is null at start
            // // clear box when Value.clear == true (use item)
            { 
                // reposition , change word and add score
                y = 0; // to reset word box , coordinate
                strInBox = getString();  // change word box words
                Value.score ++;
                Value.clearIt = false;
            }
            if (Value.freezeIt) // freeze item //time limitation
            {
                Value.dropSpeed = 0;
                //System.out.println("Frozen item activated."); --> debugger
                Value.counter += 1;
                if (Value.counter == 100) // freeze for 10 sec
                {   
                    Value.freezeIt = false;
                    Value.dropSpeed = 5;
                    Value.counter = 0;
                }
            }
            if (Value.healthIt) 
            {
                Value.health += 1;
                Value.healthIt = false;
            }
        
        }

    }

}
