
public class WallNut {

	int health;
	
	int column, lane;
	int x, y;
	
	WallNut(int placeColumn, int placeLane) {
		
		column = placeColumn;
		lane = placeLane;
		
		health = 72;
		
		x = placeColumn * 80 + 260;
		y = placeLane * 100 + 90;
		
	}
		
}
