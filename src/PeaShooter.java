public class PeaShooter {
	
	int fireTrigger;
	int fireTimer;
	int health;
	int lane;
	int column;
	
	int x, y;
	
	PeaShooter( int placeColumn, int placeLane ) {
		
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
			
		}
		
	}
	
}
