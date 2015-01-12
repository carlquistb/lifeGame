/*
 * Brendan Carlquist
 * part of the game of life application.
 * 
 * so far, this class doesn't really do much. It is an empty shell that can 'pause' the game.
 * 
 * Later, I may add a feature to change the size of the grid, switch the rules, and more. If I find out how to compress this into a .exe file.
 * 
 * perhaps, you could toggle the speed of the game through this gameState.
 */

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
			sbg.enterState(1);
		}
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString(	"\nWelcome to the game of life!\n"
				+ 		"To start the game, press escape. you can press escape again to reference this page.\n"
				+ 		"During the game, there are a few things you can do.\n\n\n\n"
				+ 		"Press the escape key to return to this menu.\n"
				+ 		"Press the n key to generate a random new field.\n"
				+ 		"Press the b key to generate a blank new field.\n"
				+ 		"Press the space bar to advance the game by one instance.\n"
				+ 		"Hold the enter key to continue the game very quickly.\n"
				+ 		"click the left mouse button over a cell to change the state of that cell.\n"
				+ 		"\n", 50, 50);
	}

	public int getID() {
		return 0;
	}

}
