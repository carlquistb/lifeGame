import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
@SuppressWarnings("unused")


public class FirstMenu extends BasicGameState{
	
	//change this!!!
	public final static int user_parameter_for_field_size = 100;
	//change this!!!
	
	
	
	static Rectangal[][] rects = new Rectangal[user_parameter_for_field_size][user_parameter_for_field_size]; 	//this is what will be changed
	public static boolean[][] field = makeNewField(user_parameter_for_field_size);								//this is what will be referenced as true/false, when changing the Rectangals.
	
	
	
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
			updateField();
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
	
	public static void randomTestUpdateField() {
		for(int a = 0; a < field.length; a++)
			for(int b = 0; b < field.length; b++){//just checking to see how this will work. If it will work.
				rects[a][b].quickChange();
				field[a][b] = rects[a][b].isCurrentlyLiving();
			}
		
		public static void updateField() {
			for(int a = 0; a < field.length; a++)
				for(int b = 0; b < field.length; b++){
					rects[a][b].setSurroundings(surroundings(a,b));//sees the surroundings variable for each rectangal in the array.
					if(//decides whether or not the rectangal is living or not
						(rects[a][b].surroundings == 2 && rects[a][b].isCurrentlyLiving())
							|| 
						(rects[a][b].surroundings == 3))
								rects[a][b].setLife(true);
				field[a][b] = rects[a][b].isCurrentlyLiving();//updates the field array with the new info.
				}
	}
	public static int surroundings(int a, int b){
		int counter = 0;
		if(a > 1 && a < field.length-1 && b > 1 && b < field.length-1)//handles everything with six surrounding cells.
			{
				//for loop that iterates between the six surrounding cells.
			}
			else//switch statement to handle all others. for now, they will remain unchecked.
			{}//it is probable that I don't even have to do this. I can just use the null returns from cells that don't exist as false for isLiving.
		return counter;
	}
		
	
}
	
	