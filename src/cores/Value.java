package cores;

public class Value //can call every wherer with out create a obj
{
    // static value use to link value from many class and method
	public static int width = 800;    
	public static int height = 800;
	public static int health = 3;
	public static int score = 0;
	public static int delay = 100;
	public static String inputText = " hi"; // have initial value to prevent null //that will cuse error and can't compare
	public static boolean clearIt = false; // check for clear item;
	public static boolean freezeIt = false; // check for clear item;
	public static boolean healthIt = false; //
	public static int dropSpeed = 5;
	public static int counter = 0; // for count cooldown
	public static String bg = "even"; // even is default theme // easter egg
	public static int squareX = 100; // create their own coordinate because will use this to change their own coordinate.
	public static int redCirX = 100; // link to itemPoiton class
	public static int blueCirX = 100;
    // public static String mode;

    Value()
    {

    }
    public static void resetHealth()
    {
        health = 3;
    }
    
    public static void resetScore()
    {
    	score = 0;
    }
    
    public static void resetItemUsed()
    {
    	squareX = 100;
    	redCirX = 100;
    	blueCirX = 100;
    }

    public static void resetAll()
    {
    	resetScore();
    	resetItemUsed();
        resetHealth();
    }
    // update 
    // if want each difficulty has different quota to use item 
    // -- declare static variable item count // 1 variable per item
    // -- if item count == 6 change detect coordinate
    // -- +1 per each time when use the item.
    // -- +2 per each time when use the item.
    // -- +3 per each time when use the item.
    // bug: resetPanelCoordinate method bug in HardWordPanel
    // bug: forgot to resetItemUsed()
}
