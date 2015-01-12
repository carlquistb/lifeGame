<<<<<<< HEAD
=======
/*
 * Brendan Carlquist
 * part of the game of life application.
 * 
 * This is the class that is ran. the outmost layer of Slick2D's game engine.
 * 
 * the two global variables are used in creating the field, and painting it with g.draw/fillRect().
 */

>>>>>>> origin/aattempt-to-make-rectangle-class-and-implement-it
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Default extends StateBasedGame{

<<<<<<< HEAD
	public static final int rightEndOfScreen = 2000;
	public static final int bottomEndOfScreen = 1600;
=======
	public static final int rightEndOfScreen = 1800;
	public static final int bottomEndOfScreen = 1800;
>>>>>>> origin/aattempt-to-make-rectangle-class-and-implement-it
	public Default(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
<<<<<<< HEAD
		addState(new FirstMenu(""));//state 0

	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new Default("working..."));
=======
		addState(new PauseMenu(""));//state 0
		addState(new FirstMenu(""));//state 1
	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new Default("Life"));
>>>>>>> origin/aattempt-to-make-rectangle-class-and-implement-it
		app.setDisplayMode(rightEndOfScreen,bottomEndOfScreen,false);
		app.setAlwaysRender(true);
		app.start();
	}

}