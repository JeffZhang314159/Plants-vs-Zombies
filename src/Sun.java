
public class Sun {
	
	int value;
	int speed;
	
	int x, y;
	
	Sun(boolean sky, int spawnX, int spawnY) { // Boolean to determine if it dropped from the sky and needs to move
		
		x = spawnX + (int)(Math.random() * 25); // Random adds a bit of variation, sun spawns somewhere in the sunflower's proximity
		y = spawnY + (int)(Math.random() * 25);
		
		value = 25;
		
		if (sky == true) {
			
			speed = 3;
			
		}
		else 
			speed = 0;
		
	}
	
}
