
public class Life {

	public static void updateField() {
		for(int a = 0; a < FirstMenu.field.length; a++)
			for(int b = 0; b < FirstMenu.field.length; b++){
				FirstMenu.field[a][b] = FirstMenu.rects[a][b].isCurrentlyLiving();
			}			
	}
}