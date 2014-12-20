
public class Rectangal {
	
		boolean isCurrentlyLiving;
	
		
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


	public boolean isCurrentlyLiving() {
		return isCurrentlyLiving;
	}
	 public void quickChange(){
		 int random =(int) Math.round(Math.random());
			if(random == 0)
				isCurrentlyLiving = true;
			else
				isCurrentlyLiving = false;
	 }
	
	
}
