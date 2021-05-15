
public class CherryBomb {

	int lane, column;
	int health;
	
	boolean vibrate;
	
	int x, y;
	
	int timerBoom, triggerBoom;
	
	CherryBomb(int placeColumn, int placeLane) {
		
		column = placeColumn;
		lane = placeLane;
		
		health = 4;
		
		vibrate = false;
		
		x = placeColumn * 80 + 265;
		y = placeLane * 100 + 90;
		
		timerBoom = 0;
		triggerBoom = 40;
		
	}
	
	void boom() {
		
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
				
			Low_Budget_Plants_vs_Zombies.c.drawImage(Low_Budget_Plants_vs_Zombies.explosion, x - 100, lane * 100 - 10, 250, 250);
			
		}
		
		if (timerBoom == triggerBoom) {

			boolean justDied = false;  // This gets around the problem that
			 // when an object is removed, the arraylist
			 // shrinks and then that affects the for loop
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.nzombie.size(); i++) {
				
				// Cherry bomb blows stuff up in a 3x3 square around it, so I will check those areas
				if (justDied == true) {

					if ((Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane == lane || 
							Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane + 1 == lane ||
							Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane - 1 == lane) && 
									(Low_Budget_Plants_vs_Zombies.nzombie.get(i).x < x + 158) &&
									(Low_Budget_Plants_vs_Zombies.nzombie.get(i).x > x - 92)) { 
									
						Low_Budget_Plants_vs_Zombies.nzombie.remove(i);
						justDied = true;
						i--;
					}
					
					else 
						justDied = false;
					
				}
				else
					if ((Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane == lane || 
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane + 1 == lane ||
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane - 1 == lane) && 
							(Low_Budget_Plants_vs_Zombies.nzombie.get(i).x < x + 158) &&
							(Low_Budget_Plants_vs_Zombies.nzombie.get(i).x > x - 92)) { 
							
				Low_Budget_Plants_vs_Zombies.nzombie.remove(i);
				justDied = true;
				i--;
					}
			
					else
						justDied = false;
			}
			
			justDied = false;
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.czombie.size(); i++) {
				
				
				if (justDied == true) {

					if ((Low_Budget_Plants_vs_Zombies.czombie.get(i).lane == lane || 
							Low_Budget_Plants_vs_Zombies.czombie.get(i).lane + 1 == lane ||
							Low_Budget_Plants_vs_Zombies.czombie.get(i).lane - 1 == lane) && 
									(Low_Budget_Plants_vs_Zombies.czombie.get(i).x < x + 158) &&
									(Low_Budget_Plants_vs_Zombies.czombie.get(i).x > x - 92)) { 
									
						Low_Budget_Plants_vs_Zombies.czombie.remove(i);
						justDied = true;
						i--;
					}
					
					else 
						justDied = false;
					
				}
				else
					if ((Low_Budget_Plants_vs_Zombies.czombie.get(i).lane == lane || 
					Low_Budget_Plants_vs_Zombies.czombie.get(i).lane + 1 == lane ||
					Low_Budget_Plants_vs_Zombies.czombie.get(i).lane - 1 == lane) && 
							(Low_Budget_Plants_vs_Zombies.czombie.get(i).x < x + 158) &&
							(Low_Budget_Plants_vs_Zombies.czombie.get(i).x > x - 92)) { 
							
				Low_Budget_Plants_vs_Zombies.czombie.remove(i);
				justDied = true;
				i--;
					}
			
					else
						justDied = false;
			}
			
			justDied = false;
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.bzombie.size(); i++) {
				
				if (justDied == true) {

					if ((Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane == lane || 
							Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane + 1 == lane ||
							Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane - 1 == lane) && 
									(Low_Budget_Plants_vs_Zombies.bzombie.get(i).x < x + 158) &&
									(Low_Budget_Plants_vs_Zombies.bzombie.get(i).x > x - 92)) { 
									
						Low_Budget_Plants_vs_Zombies.bzombie.remove(i);
						justDied = true;
						i--;
					}
					
					else 
						justDied = false;
					
				}
				else
					if ((Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane == lane || 
					Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane + 1 == lane ||
					Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane - 1 == lane) && 
							(Low_Budget_Plants_vs_Zombies.bzombie.get(i).x < x + 158) &&
							(Low_Budget_Plants_vs_Zombies.bzombie.get(i).x > x - 92)) { 
							
				Low_Budget_Plants_vs_Zombies.bzombie.remove(i);
				justDied = true;
				i--;
					}
			
					else
						justDied = false;
			}
			
			justDied = false;
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.fzombie.size(); i++) {
				
				if (justDied == true) {
					
					if ((Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane == lane || 
							Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane + 1 == lane ||
							Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane - 1 == lane) && 
									(Low_Budget_Plants_vs_Zombies.fzombie.get(i).x < x + 158) &&
									(Low_Budget_Plants_vs_Zombies.fzombie.get(i).x > x - 92)) { 
									
						Low_Budget_Plants_vs_Zombies.fzombie.remove(i);
						justDied = true;
						i--;
					}
					
					else 
						justDied = false;
					
				}
				else
					if ((Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane == lane || 
					Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane + 1 == lane ||
					Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane - 1 == lane) && 
							(Low_Budget_Plants_vs_Zombies.fzombie.get(i).x < x + 158) &&
							(Low_Budget_Plants_vs_Zombies.fzombie.get(i).x > x - 92)) { 
							
				Low_Budget_Plants_vs_Zombies.fzombie.remove(i);
				justDied = true;
				i--;
					}
			
					else
						justDied = false;
		}
			
			Low_Budget_Plants_vs_Zombies.cherrybomb.remove(0);
			
		}	
		
	}
	
}
