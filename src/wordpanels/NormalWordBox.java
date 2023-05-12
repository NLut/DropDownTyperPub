package wordpanels;

public class NormalWordBox extends WordBox{
	public NormalWordBox()
    {
    }
    @Override
    protected String getString()
    {
        return(Word[rand.nextInt(419)]);
    }
}
