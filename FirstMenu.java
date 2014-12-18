import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
@SuppressWarnings("unused")


public class FirstMenu extends BasicGameState{
	public final static int user_parameter_for_field_size = 100;
	static Rectangal[][] rects = new Rectangal[user_parameter_for_field_size][user_parameter_for_field_size];
	public static boolean[][] field = makeNewField(user_parameter_for_field_size);           //this parameter is all you need to change to get a different field size. be careful with it, i don't know how it will react if the ints need to round. Or, how it will interact with pre-made fields.

	
	public FirstMenu(String title) {
		super();
	}

	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {//update game logic here
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(1);
		}
		if(container.getInput().isKeyPressed(Input.KEY_SPACE)){
			Life.updateField();
		}
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.red);
		int squarexSize = Default.rightEndOfScreen/field.length;
		int squareySize = Default.bottomEndOfScreen/field.length;
		//so the problem is that the Life.java thing isn't starting. When referencing variables from it, they variables always come back as just initialized.
		for(int a = 0; a < field.length; a++)
			for(int b = 0; b < field.length; b++)
				if(field[a][b])
					g.fillRect(a*squarexSize, b*squareySize, squarexSize-1, squareySize-1);
				else
					g.drawRect(a*squarexSize, b*squareySize, squarexSize-1, squareySize-1);
		
	}
	
	
	
	
	
	
	

	public int getID() {
		return 0;
	}
	
	private static boolean[][] makeNewField(int fieldSize) {
		boolean[][] newField = new boolean[fieldSize][fieldSize];
		
		for(int a = 0; a < newField.length; a++)
			for(int b = 0; b < newField.length; b++){
				rects[a][b] = new Rectangal();
				newField[a][b] = rects[a][b].isCurrentlyLiving();
			}
		
		return newField;
	}
}
	
	