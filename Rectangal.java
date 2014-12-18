
public class Rectangal {
		boolean isLiving;
	public Rectangal(){
		int rand =(int) Math.round(Math.random());
		System.out.println(rand);
		if(rand == 0)
			isLiving = true;
		else
			isLiving = false;
	}

	public boolean isLiving() {
		return isLiving;
	}
	
	
}
