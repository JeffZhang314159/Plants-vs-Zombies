
public class ProjectilePea {
	
	int lane;
	
	int damage;
	int speed;
	
	int x, y;
	
	ProjectilePea (int spawnColumn, int spawnLane) {
		
		lane = spawnLane;
		
		damage = 1;
		speed = 10;
		
		x = spawnColumn * 80 + 275;
		y = spawnLane * 100 + 95;
		
	}
	
	void move() {
		
		x += speed;
		
	}
	
	void collision(int identifier) { // Identifier to determine which pea collide, so it can be deleted
		
		boolean hit = false;
		
		for (int i = 0; i < Low_Budget_Plants_vs_Zombies.nzombie.size(); i++) {
			
			if (Low_Budget_Plants_vs_Zombies.nzombie.get(i).lane == lane) { 
				
				// Collision detection (only need to check x, since they are in same lane, same y)
				if (Low_Budget_Plants_vs_Zombies.nzombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.nzombie.get(i).x + 72 >= x) {
					
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).health -= damage;
					
					if (Low_Budget_Plants_vs_Zombies.nzombie.get(i).health == 0) {
						Low_Budget_Plants_vs_Zombies.nzombie.remove(i); // When zombies health reaches zero, it is deleted
						Low_Budget_Plants_vs_Zombies.score++;
					}
					Low_Budget_Plants_vs_Zombies.projectilepea.remove(identifier); // When pea hits zombie, it is deleted
					hit = true;
					break;
					
				}
				
			}
			
		}
		// If the pea has already hit something, doesn't need to check if it hits anything else
		if (hit == false) {
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.czombie.size(); i++) {
				
				if (Low_Budget_Plants_vs_Zombies.czombie.get(i).lane == lane) { 
					
					// Collision detection (only need to check x, since they are in same lane, same y)
					if (Low_Budget_Plants_vs_Zombies.czombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.czombie.get(i).x + 72 >= x) {
						
						Low_Budget_Plants_vs_Zombies.czombie.get(i).health -= damage;
						
						if (Low_Budget_Plants_vs_Zombies.czombie.get(i).health == 0){ 
							Low_Budget_Plants_vs_Zombies.czombie.remove(i);
							Low_Budget_Plants_vs_Zombies.score++;
						}
						Low_Budget_Plants_vs_Zombies.projectilepea.remove(identifier); // When pea hits zombie, it is deleted
						hit = true;
						break;
						
					}
					
				}
				
			}
			
		}
		
		if (hit == false) {
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.bzombie.size(); i++) {
				
				if (Low_Budget_Plants_vs_Zombies.bzombie.get(i).lane == lane) { 
					
					if (Low_Budget_Plants_vs_Zombies.bzombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.bzombie.get(i).x + 72 >= x) {
						
						Low_Budget_Plants_vs_Zombies.bzombie.get(i).health -= damage;
						
						if (Low_Budget_Plants_vs_Zombies.bzombie.get(i).health == 0) {
							Low_Budget_Plants_vs_Zombies.bzombie.remove(i);
							Low_Budget_Plants_vs_Zombies.score++;
						}
						
						Low_Budget_Plants_vs_Zombies.projectilepea.remove(identifier);
						hit = true;
						break;
						
					}
					
				}
				
			}
		}
		
		if (hit == false) {
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.fzombie.size(); i++) {
				
				if (Low_Budget_Plants_vs_Zombies.fzombie.get(i).lane == lane) { 
					
					if (Low_Budget_Plants_vs_Zombies.fzombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.fzombie.get(i).x + 72 >= x) {
						
						Low_Budget_Plants_vs_Zombies.fzombie.get(i).health -= damage;
						
						if (Low_Budget_Plants_vs_Zombies.fzombie.get(i).health == 0) {
							Low_Budget_Plants_vs_Zombies.fzombie.remove(i); 
							Low_Budget_Plants_vs_Zombies.score++;
						}
						
						Low_Budget_Plants_vs_Zombies.projectilepea.remove(identifier);
						hit = true;
						break;
						
					}
					
				}
				
			}
			
		}
	
	}
	
}
