import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class PauseMenu extends BasicGameState{
	
	public PauseMenu(String title){
		super();
	}

	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(0);
		}
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("paused. \n this menu should allow you to change speeds, etc. If I get around to that.", 50, 50);
	}

	public int getID() {
		return 1;
	}

}
