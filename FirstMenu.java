import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
@SuppressWarnings("unused")

	/*
	 * Brendan Carlquist
	 * 
	 * Rendition of John Conway's game of life.
	 */



public class FirstMenu extends BasicGameState{
	
	
	//change this!!!
	public final static int user_parameter_for_field_size = 100;
	//change this!!!
	
	
	
	static Rectangal[][] rects = new Rectangal[user_parameter_for_field_size][user_parameter_for_field_size]; 	//this is what will be changed
	public static boolean[][] field = makeNewField(user_parameter_for_field_size);
	
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
		if(input.isKeyPressed(Input.KEY_B)){
			blankField();
		}
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.red);
		for(int a = 0; a < field.length; a++)
			for(int b = 0; b < field.length; b++)
				if(rects[a][b].isCurrentlyLiving)
					g.drawRect(a*Default.rightEndOfScreen/field.length, b*Default.bottomEndOfScreen/field.length, Default.rightEndOfScreen/field.length-1, Default.bottomEndOfScreen/field.length-1);
					else
					g.fillRect(a*Default.rightEndOfScreen/field.length, b*Default.bottomEndOfScreen/field.length, Default.rightEndOfScreen/field.length-1, Default.bottomEndOfScreen/field.length-1);
		
	}

	public int getID() {
		return 0;
	}
	
	private void changeClickedRectangal(int mouseX, int mouseY) {
		int xcounter = -1;
		int rightEdgeOfCurrentCell = 0;//
		do{
			rightEdgeOfCurrentCell+=Default.rightEndOfScreen/rects.length;
			xcounter++;
		}while(mouseX>rightEdgeOfCurrentCell);
		int ycounter = -1;
		int lowerEdgeOfCurrentCell = 0;
			do{
			lowerEdgeOfCurrentCell+=Default.bottomEndOfScreen/rects.length;
			ycounter++;
		}while(mouseY>lowerEdgeOfCurrentCell);
		rects[xcounter][ycounter].switchLife();
		field[xcounter][ycounter] = !field[xcounter][ycounter];
		//System.out.println("this cell should ");
		
		}
	
	public static void blankField(){
		for(int i = 0; i < rects.length;i++)
			for(int j = 0; j < rects[i].length;j++){
				rects[i][j].setLife(false);
				field[i][j] = false;
			}
	}
	
	public static void randomTestUpdateField() {
		for(int a = 0; a < rects.length; a++)
			for(int b = 0; b < rects.length; b++){//just checking to see how this will work. If it will work.
				rects[a][b].quickChange();
			}
	}
	/*
	 * fairly self-explanitory. 
	 */
	public static void updateField() {
		for(int a = 0; a < rects.length; a++)
			for(int b = 0; b < rects.length; b++){
				rects[a][b].setSurroundings(countSurroundings(a,b));//sees the surroundings variable for each rectangal in the array.
			}
		for(int i = 0; i < rects.length; i++)
			for(int j = 0; j < rects.length; j++)
				determineState(i,j);

	}
	/*
	 * uses the indexes to reference the rects[][] Rectangal objects for the surroundings variable.
	 * simply decides whether the 
	 */
	private static void determineState(int a, int b) {
		if(rects[a][b].isCurrentlyLiving()){
			if(rects[a][b].surroundings == 2 || rects[a][b].surroundings == 3)
				rects[a][b].setLife(true);
			else
				rects[a][b].setLife(false);
		}
		else if(rects[a][b].surroundings == 3){
			rects[a][b].setLife(true);
		}
		
	}

	
	/*
	 * returns an int of how many of the surrounding cells are currently alive.
	 * used in updateField(), to change the variable in each Rectangal object.
	 */
	public static int countSurroundings(int a, int b){
		int counter = 0;
		//gives the values that need to be added to the current index to get the index of the surrounding cells.
		int[] xvals = new int[] {-1,0,1,-1,1,-1,0,1};
		int[] yvals = new int[] {-1,-1,-1,0,0,1,1,1};
			if(a > 0 && a < rects.length-1 && b > 0 && b < rects.length-1)//handles everything with six surrounding cells.
				{
					for(int i = 0; i < xvals.length; i++){
						if(rects[xvals[i]+a][yvals[i]+b].isCurrentlyLiving()){
							counter++;
						}
					}
				}
				else
				{
					try{
						for(int i = 0; i < xvals.length; i++)
							if(rects[xvals[i]+a][yvals[i]+b].isCurrentlyLiving())
								counter++;
						}//if the array index doesn't exist, counter doesn't increment.
					catch(ArrayIndexOutOfBoundsException e){}
					
				}
		return counter;
	}
	
	
	
	
	
	
	
	
	
	/*
	 * this is only referenced when creating the boolean[][] field.
	 * makes the field based on the values that the random generator in Rectangal comes up with.
	 */
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
	
	