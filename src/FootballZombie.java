
public class FootballZombie {

	int movespeed;	
	int health;	
	
	int eatTimer;
	int eatTrigger;
	
	int lane;
	
	int moveTrigger; 
	int moveTimer;
	
	boolean frozen;
	int frozenTimer;
	int frozenThaw; // After a certain time of not being hit by snowpea, zombie will thaw and return to normal speed
	
	int x, y;

	FootballZombie( int pickLane ) {
		lane = pickLane; // For the overlapping zombies function
		movespeed = 2;
		health = 80;
		
		eatTimer = 0;
		eatTrigger = 10;
		
		// When Zombies are frozen, they will move slower, since it waits a number of thread.sleep ticks before moving
		frozenTimer = 0;
		frozenThaw = 60;
		
		moveTrigger = 1;

		x = Low_Budget_Plants_vs_Zombies.c.getWidth();
		y = lane * 100 + 35;
	}

	void move() {
		
		if (frozen == true) {
			
			frozenTimer++;
			
			if (frozenTimer == frozenThaw) {
				
				moveTimer = 0;
				frozen = false;
				frozenTimer = 0;
				
			}
			
		}
		
		if (frozen == false) {
			
			moveTrigger = 1;
			
		}
		
		else {
			
			moveTrigger = 2;
			
		}
		
		if (moveTimer == moveTrigger) {
			
			moveTimer = 0;
			x -= movespeed;
			
		}
		
	}
	
	void eatPlant() {
		
		boolean eating = false;
		
		// Frozen zombies also eat slower too
			if (frozen == true) {
				
				frozenTimer++;
				
				if (frozenTimer == frozenThaw) {
					
					eatTimer = 0;
					frozen = false;
					frozenTimer = 0;
					
				}
				
			}
			
			if (frozen == false) {
				
				eatTrigger = 10;
				
			}
			
			else {
				
				eatTrigger = 20;
				
			}
		
		for (int i = 0; i < Low_Budget_Plants_vs_Zombies.sunflower.size(); i++) { 
			
			if (Low_Budget_Plants_vs_Zombies.sunflower.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.sunflower.get(i).x < x) {
				
				if (x <= Low_Budget_Plants_vs_Zombies.sunflower.get(i).x + 40) {
					
					movespeed = 0;
					eatTimer++;
					
					if (eatTimer == eatTrigger) {
						
						eatTimer = 0;
						Low_Budget_Plants_vs_Zombies.sunflower.get(i).health --;
						eating = true;
						
						if (Low_Budget_Plants_vs_Zombies.sunflower.get(i).health == 0) {
							
							Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.sunflower.get(i).column]
									[Low_Budget_Plants_vs_Zombies.sunflower.get(i).column] = 0;
							Low_Budget_Plants_vs_Zombies.sunflower.remove(i);
							movespeed = 2;
						}
						
					}
					
				}
				
			}
	
		}
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.peashooter.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.peashooter.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.peashooter.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.peashooter.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.peashooter.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.peashooter.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.peashooter.get(i).column]
										[Low_Budget_Plants_vs_Zombies.peashooter.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.peashooter.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.snowpeashooter.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).column]
										[Low_Budget_Plants_vs_Zombies.snowpeashooter.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.snowpeashooter.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.threepeater.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.threepeater.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.threepeater.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.threepeater.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.threepeater.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.threepeater.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.threepeater.get(i).column]
										[Low_Budget_Plants_vs_Zombies.threepeater.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.threepeater.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.wallnut.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.wallnut.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.wallnut.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.wallnut.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.wallnut.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.wallnut.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.wallnut.get(i).column]
										[Low_Budget_Plants_vs_Zombies.wallnut.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.wallnut.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.tallnut.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.tallnut.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.tallnut.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.tallnut.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.tallnut.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.tallnut.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.tallnut.get(i).column]
										[Low_Budget_Plants_vs_Zombies.tallnut.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.tallnut.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.jalapeno.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.jalapeno.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.jalapeno.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.jalapeno.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.jalapeno.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.jalapeno.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.jalapeno.get(i).column]
										[Low_Budget_Plants_vs_Zombies.jalapeno.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.jalapeno.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
		if (eating == false) {// if the zombie is already eating, don't need to check other plants
			
			for (int i = 0; i < Low_Budget_Plants_vs_Zombies.cherrybomb.size(); i++) { 
				
				if (Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).lane == lane && Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).x < x) {
					
					if (x <= Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).x + 40) {
						
						movespeed = 0;
						eatTimer++;
						
						if (eatTimer == eatTrigger) {
							
							eatTimer = 0;
							Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).health --;
							eating = true;
							
							if (Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).health == 0) {
								
								Low_Budget_Plants_vs_Zombies.plantPlacement[Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).column]
										[Low_Budget_Plants_vs_Zombies.cherrybomb.get(i).lane] = 0;
								Low_Budget_Plants_vs_Zombies.cherrybomb.remove(i);
								movespeed = 2;
							}
							
						}
						
					}
					
				}
		
			}
			
		}
		
	}

}
