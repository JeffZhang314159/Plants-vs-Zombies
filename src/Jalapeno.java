
public class Jalapeno {

	int lane, column;
	int health;
	
	boolean vibrate;
	
	int x, y;
	
	int timerBoom, triggerBoom;
	
	Jalapeno(int placeColumn, int placeLane) {
		
		column = placeColumn;
		lane = placeLane;
		
		health = 4;
		
		vibrate = false;
		
		x = placeColumn * 80 + 275;
		y = placeLane * 100 + 90;
		
		timerBoom = 0;
		triggerBoom = 40;
		
	}
	
	void boom() {
		
		// Makes it vibrate before blowing up
		if (vibrate == false) {
			x += 2;
			vibrate = true;
		}
		else {
			x -= 2;
			vibrate = false;
		}
		
		timerBoom++;
		
		if (timerBoom >= 2*triggerBoom/3) {
			
			for (int x = 0; x < 18; x++) {
				
				Low_Budget_Plants_vs_Zombies.c.drawImage(Low_Budget_Plants_vs_Zombies.fire, 
						x*50 + 150, lane * 100 + 90);
				
			}
			
		}
		
		if (timerBoom == triggerBoom) {
			
			boolean justDied = false;
			
			for (int x = 0; x < Low_Budget_Plants_vs_Zombies.nzombie.size(); x++) {
				
				if (justDied == true) {
					
					if (Low_Budget_Plants_vs_Zombies.nzombie.get(x).lane == lane) { 
									
						Low_Budget_Plants_vs_Zombies.nzombie.remove(x);
						justDied = true;
						x--;
						
					}
					else
						justDied = false;
				}
				
				else {
					
					if (Low_Budget_Plants_vs_Zombies.nzombie.get(x).lane == lane) { 
						
						Low_Budget_Plants_vs_Zombies.nzombie.remove(x);
						justDied = true;
						x--;
					
					}
					else {
						
						justDied = false;
						
					}
				
				}
				
			}
			
			justDied = false;
			
			for (int x = 0; x < Low_Budget_Plants_vs_Zombies.czombie.size(); x++) {
				
				if (justDied == true) {
					
					if (Low_Budget_Plants_vs_Zombies.czombie.get(x).lane == lane) { 
									
						Low_Budget_Plants_vs_Zombies.czombie.remove(x);
						justDied = true;
						x--;
						
					}
					else
						justDied = false;
				}
				
				else {
					
					if (Low_Budget_Plants_vs_Zombies.czombie.get(x).lane == lane) { 
						
						Low_Budget_Plants_vs_Zombies.czombie.remove(x);
						justDied = true;
						x--;
					
					}
					else {
						
						justDied = false;
						
					}
				
				}
				
			}
			
			justDied = false;
			
			for (int x = 0; x < Low_Budget_Plants_vs_Zombies.bzombie.size(); x++) {
				
				if (justDied == true) {
					
					if (Low_Budget_Plants_vs_Zombies.bzombie.get(x).lane == lane) { 
									
						Low_Budget_Plants_vs_Zombies.bzombie.remove(x);
						justDied = true;
						x--;
						
					}
					else
						justDied = false;
				}
				
				else {
					
					if (Low_Budget_Plants_vs_Zombies.bzombie.get(x).lane == lane) { 
						
						Low_Budget_Plants_vs_Zombies.bzombie.remove(x);
						justDied = true;
						x--;
					
					}
					else {
						
						justDied = false;
						
					}
				
				}
			}
				
			justDied = false;
			
			for (int x = 0; x < Low_Budget_Plants_vs_Zombies.fzombie.size(); x++) {
				
				if (justDied == true) {
					
					if (Low_Budget_Plants_vs_Zombies.fzombie.get(x).lane == lane) { 
									
						Low_Budget_Plants_vs_Zombies.fzombie.remove(x);
						justDied = true;
						x--;
						
					}
					else
						justDied = false;
				}
				
				else {
					
					if (Low_Budget_Plants_vs_Zombies.fzombie.get(x).lane == lane) { 
						
						Low_Budget_Plants_vs_Zombies.fzombie.remove(x);
						justDied = true;
						x--;
					
					}
					else {
						
						justDied = false;
						
					}
				
				}
			}
			
			Low_Budget_Plants_vs_Zombies.jalapeno.remove(0); // Since jalapeno's self destruct, there will only ever be one present
			
		}	
		
	}
	
}
