import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Default extends StateBasedGame{

	public static final int rightEndOfScreen = 2000;
	public static final int bottomEndOfScreen = 1600;
	public Default(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		addState(new FirstMenu(""));//state 0

	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new Default("working..."));
		app.setDisplayMode(rightEndOfScreen,bottomEndOfScreen,false);
		app.setAlwaysRender(true);
		app.start();
	}

}