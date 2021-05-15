
public class ProjectileSnowPea {

	int lane;
	
	int damage;
	int speed;
	
	int x, y;
	
	ProjectileSnowPea (int spawnColumn, int spawnLane) {
		
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
				
				if (Low_Budget_Plants_vs_Zombies.nzombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.nzombie.get(i).x + 72 >= x) {
					
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).health -= damage;
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).frozen = true; // Making zombie frozen
					Low_Budget_Plants_vs_Zombies.nzombie.get(i).frozenTimer = 0; // Whenever zombie is hit, it is re-frozen
					
					if (Low_Budget_Plants_vs_Zombies.nzombie.get(i).health == 0) {
						Low_Budget_Plants_vs_Zombies.nzombie.remove(i);
						Low_Budget_Plants_vs_Zombies.score++;
					}
					
					Low_Budget_Plants_vs_Zombies.projectilesnowpea.remove(identifier);
					hit = true;
					break;
				}
				
			}
			
		}
		
		if (hit == false) {
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.czombie.size(); i++) {
				
				if (Low_Budget_Plants_vs_Zombies.czombie.get(i).lane == lane) { 
					
					if (Low_Budget_Plants_vs_Zombies.czombie.get(i).x <= x && Low_Budget_Plants_vs_Zombies.czombie.get(i).x + 72 >= x) {
						
						Low_Budget_Plants_vs_Zombies.czombie.get(i).health -= damage;
						Low_Budget_Plants_vs_Zombies.czombie.get(i).frozen = true;
						Low_Budget_Plants_vs_Zombies.czombie.get(i).frozenTimer = 0;
						
						if (Low_Budget_Plants_vs_Zombies.czombie.get(i).health == 0) {
							Low_Budget_Plants_vs_Zombies.czombie.remove(i);
							Low_Budget_Plants_vs_Zombies.score++;
						}
						
						Low_Budget_Plants_vs_Zombies.projectilesnowpea.remove(identifier);
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
						Low_Budget_Plants_vs_Zombies.bzombie.get(i).frozen = true;
						Low_Budget_Plants_vs_Zombies.bzombie.get(i).frozenTimer = 0;
						
						if (Low_Budget_Plants_vs_Zombies.bzombie.get(i).health == 0) {
							Low_Budget_Plants_vs_Zombies.bzombie.remove(i);
							Low_Budget_Plants_vs_Zombies.score++;
						}
						
						Low_Budget_Plants_vs_Zombies.projectilesnowpea.remove(identifier); 
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
						Low_Budget_Plants_vs_Zombies.fzombie.get(i).frozen = true;
						Low_Budget_Plants_vs_Zombies.fzombie.get(i).frozenTimer = 0;
						
						if (Low_Budget_Plants_vs_Zombies.fzombie.get(i).health == 0) {
							Low_Budget_Plants_vs_Zombies.fzombie.remove(i); 
							Low_Budget_Plants_vs_Zombies.score++;
						}
						
						Low_Budget_Plants_vs_Zombies.projectilesnowpea.remove(identifier);
						hit = true;
						break;
					}
					
				}
				
			}
			
		}
		
	}
	
}
