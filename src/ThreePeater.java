public class ThreePeater {
	
	int fireTrigger;
	int fireTimer;
	int health;
	int lane;
	int column;
	
	int x, y;
	
	ThreePeater( int placeColumn, int placeLane ) {
		
		health = 4;
		
		lane = placeLane; // So that plants only shoot when there is a zombie in their lane
		column = placeColumn; //
		
		fireTrigger = 20;
		fireTimer = 1;
		
		x = placeColumn * 80 + 260;
		y = placeLane * 100 + 90;
		
	}
	void fire(int column, int lane) { 
		
		if (fireTimer == fireTrigger) {
			
			fireTimer = 0;
			
			Low_Budget_Plants_vs_Zombies.projectilepea.add(new ProjectilePea(column, lane));
			
			// ThreePeater shoots three peas, in the lane that it's in and the two lanes beside it
			// However, if it on the top or bottom lane, it will not shoot a pea above it or below it, respectively
			if (lane > 0)
				Low_Budget_Plants_vs_Zombies.projectilepea.add(new ProjectilePea(column, lane - 1));
			
			if (lane < 4)
				Low_Budget_Plants_vs_Zombies.projectilepea.add(new ProjectilePea(column, lane + 1));
		}
		
	}
	
}
