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
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			sbg.enterState(1);
		}
		if(input.isKeyPressed(Input.KEY_SPACE)  ||  input.isKeyDown(Input.KEY_ENTER)){
			updateField();
		}
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			changeClickedRectangal(input.getMouseX(),input.getMouseY());
			
		}
	}
	
	private void changeClickedRectangal(int mouseX, int mouseY) {
		//somehow, I need to use the coordinates of the mouse click event to find which Rectangal to modify.
		//don't forget to aso change the value of the cell in the field[][] array. Or, see if I may not need to.
		int xcounter = -1;
		int rightEdgeOfCurrentCell = 0;//
		do{
			rightEdgeOfCurrentCell+=Default.rightEndOfScreen/field.length;
			xcounter++;
		}while(mouseX>rightEdgeOfCurrentCell);
		int ycounter = -1;
		int lowerEdgeOfCurrentCell = 0;
			do{
			lowerEdgeOfCurrentCell+=Default.bottomEndOfScreen/field.length;
			ycounter++;
		}while(mouseY>lowerEdgeOfCurrentCell);
		rects[xcounter][ycounter].switchLife();
		field[xcounter][ycounter] = rects[xcounter][ycounter].isCurrentlyLiving();
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.red);
		//int squarexSize = Default.rightEndOfScreen/field.length;		instead of using the integers that have to be initialized,
		//int squareySize = Default.bottomEndOfScreen/field.length;		question- which is faster;initializing a variable, each tume it renders; or, referencing a global variable from another class each time?
		for(int a = 0; a < field.length; a++)
			for(int b = 0; b < field.length; b++)
				if(field[a][b])
					g.fillRect(a*Default.rightEndOfScreen/field.length, b*Default.bottomEndOfScreen/field.length, Default.rightEndOfScreen/field.length-1, Default.bottomEndOfScreen/field.length-1);
				else
					g.drawRect(a*Default.rightEndOfScreen/field.length, b*Default.bottomEndOfScreen/field.length, Default.rightEndOfScreen/field.length-1, Default.bottomEndOfScreen/field.length-1);
		
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
	}

	public static void updateField() {
		for(int a = 0; a < field.length; a++)
			for(int b = 0; b < field.length; b++){
				rects[a][b].setSurroundings(countSurroundings(a,b));//sees the surroundings variable for each rectangal in the array.
				if(//decides whether or not the rectangal is living or not
					(rects[a][b].surroundings == 2 && rects[a][b].isCurrentlyLiving())
						|| 
					(rects[a][b].surroundings == 3)){
					rects[a][b].setLife(true);
				}
				else{
					rects[a][b].setLife(false);
				}
			field[a][b] = rects[a][b].isCurrentlyLiving();//updates the field array with the new info.
			}
	}

	public static int countSurroundings(int a, int b){
		int counter = 0;
		int[] xvals = new int[] {-1,0,1,-1,1,-1,0,1};//gives the values that need to be added to the current value to get the value of the surrounding cells
		int[] yvals = new int[] {-1,-1,-1,0,0,1,1,1};
		if(a > 0 && a < field.length-1 && b > 0 && b < field.length-1)//handles everything with six surrounding cells.
			{
				for(int i = 0; i < xvals.length; i++){
					if(field[xvals[i]+a][yvals[i]+b]){
						counter++;
					}
				}
			}
			else//switch statement to handle all others. for now, they will remain unchecked.
			{
				
			}//it is probable that I don't even have to do this. I can just use the null returns from cells that don't exist as false for isLiving.
		return counter;
	}

		
	
}
	
	