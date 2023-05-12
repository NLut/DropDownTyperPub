package wordpanels;

public class HardWordBox extends NormalWordBox{
	public HardWordBox()
    {
             
    }

    @Override
    protected String getString()
    {
        return(Word[rand.nextInt(519)]);
    }
    
}
