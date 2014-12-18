
public class Rectangal {
	
		boolean isCurrentlyLiving;
	
		
		
		
		public Rectangal(){
		int rand =(int) Math.round(Math.random());
		if(rand == 0)
			isCurrentlyLiving = true;
		else
			isCurrentlyLiving = false;
	}

	public boolean isCurrentlyLiving() {
		return isCurrentlyLiving;
	}
	
	
}
