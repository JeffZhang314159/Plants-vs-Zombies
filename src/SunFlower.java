
public class SunFlower {
	
	int health;
	
	int createTimer;
	int createTrigger;
	
	int column, lane;
	
	int x, y;
	
	SunFlower( int placeColumn, int placeLane) {
		
		column = placeColumn;
		lane = placeLane;
		
		health = 4;
		
		createTimer = 320; // Once placed, creates sun after 8 seconds
		createTrigger = 480; // Then creates sun every 24 seconds
		
		x = placeColumn * 80 + 260;
		y = placeLane * 100 + 90;
		
	}
	
	void createSun() {
		
		if (createTimer == createTrigger) {
			
			createTimer = 0;
			Low_Budget_Plants_vs_Zombies.sun.add(new Sun(false, x, y));
			
		}
		
	}
	
}
