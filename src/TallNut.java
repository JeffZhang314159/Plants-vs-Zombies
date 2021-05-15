
public class TallNut {

	int health;
	
	int column, lane;
	int x, y;
	
	TallNut(int placeColumn, int placeLane) {
		
		column = placeColumn;
		lane = placeLane;
		
		health = 144;
		
		x = placeColumn * 80 + 260;
		y = placeLane * 100 + 70;
		
	}
		
}

