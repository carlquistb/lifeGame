
/*
 * Brendan Carlquist
 * 
 * part of the game of life application.
 * 
 * 
 * Rectangal class is purposefully spelled wrong! not to be confused with inbuilt classes like Graphics.Rectangle
 * nothing all that hard to understand about this. 
 * 
 * the surroundings int stores how many of the surrounding rectangals are 'on.'
 * Other than that, the class is self explanatory.
 */

public class Rectangal {
	
		boolean isCurrentlyLiving = true;
		int surroundings;
		
		//constructor for random living/non-living square.
	public Rectangal(){
		int rand =(int) Math.round(Math.random());
			if(rand == 0)
				isCurrentlyLiving = true;
			else
				isCurrentlyLiving = false;
	}
	
		//constructor for specified living/non-living
	public Rectangal(boolean living){
		isCurrentlyLiving = living;
	}
	
	public void setLife(boolean a){
		isCurrentlyLiving = a;
	}
	
	public void switchLife(){
		isCurrentlyLiving = !isCurrentlyLiving;
	}


	public boolean isCurrentlyLiving() {
		return isCurrentlyLiving;
	}
	
	public void setSurroundings(int a){
		surroundings = a;
	}
	
	 public void quickChange(){
		 int random =(int) Math.round(Math.random());
			if(random == 0)
				isCurrentlyLiving = true;
			else
				isCurrentlyLiving = false;
	 }
	
	
}
