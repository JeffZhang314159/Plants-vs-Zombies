import hsa_ufa.Console;

import java.net.URL;
import java.applet.AudioClip;
import java.applet.Applet;
import java.util.*;
import java.awt.*;

public class Low_Budget_Plants_vs_Zombies {
	
	static Console c = new Console(1050, 600, "Low Budget Plants vs Zombies");
	
	static Console b = new Console(1050, 600, "Intro");
	
	static int difficulty;
	
	// Music 
	static AudioClip play = Applet.newAudioClip(Low_Budget_Plants_vs_Zombies.class.getResource("music/Play.mp3"));
	
	// Intro screen
	static Image wall = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/wallpaper.jpg"));
	
	static boolean start = false;
	static boolean lose = false;
	static int loseTimer = 0;
	
	// Keeps track of how much sun (currency to pay for plantss) the player has
	static int sunMoney = 50;
	
	// Keeps track of score (kills)
	static int score = 0;
	
	// Timer for spawntimes of zombies and sun
	static int spawnTrigger;
	static int spawnTimer = 0;
	static int sunTrigger = 100, sunTimer = 0;
	static int stage = 0; // Starting off, low stage, fewer zombies spawned. As the game progresses, more zombies spawned.
	
	// ArrayLists to manage spawning of new zombies, plants, and creation of projectiles
	// Zombies
	static ArrayList<NormalZombie> nzombie = new ArrayList<>(); // Array lists earned from fellow student Michael Yang :D
	static ArrayList<ConeZombie> czombie = new ArrayList<>();
	static ArrayList<BucketZombie> bzombie = new ArrayList<>();
	static ArrayList<FootballZombie> fzombie = new ArrayList<>();
	
	// Plants
	static ArrayList<SunFlower> sunflower = new ArrayList<>();
	static ArrayList<PeaShooter> peashooter = new ArrayList<>();
	static ArrayList<SnowPeaShooter> snowpeashooter = new ArrayList<>();
	static ArrayList<ThreePeater> threepeater = new ArrayList<>();
	static ArrayList<WallNut> wallnut = new ArrayList<>();
	static ArrayList<TallNut> tallnut = new ArrayList<>();
	static ArrayList<Jalapeno> jalapeno = new ArrayList<>();
	static ArrayList<CherryBomb> cherrybomb = new ArrayList<>();
	
	// Projectiles
	static ArrayList<Sun> sun = new ArrayList<>();
	static ArrayList<ProjectilePea> projectilepea = new ArrayList<>();
	static ArrayList<ProjectileSnowPea> projectilesnowpea = new ArrayList<>();
	
	// All images, taken from google images and edited in photoshop
	// Zombies
	static Image nz = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("zombies/NormalZombie.png"));
	static Image cz = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("zombies/ConeZombie.png"));
	static Image bz = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("zombies/BucketZombie.png"));
	static Image fz = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("zombies/FootballZombie.png"));
	
	// Plants
	static Image sflower = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/SunFlower.png"));
	static Image pshooter = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/PeaShooter.png"));
	static Image snowpshooter = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/SnowPea.png"));
	static Image tpeater = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Threepeater.png"));
	static Image wnut1 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Wallnut1.png"));
	static Image wnut2 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Wallnut2.png"));
	static Image wnut3 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Wallnut3.png"));
	static Image tnut1 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Tallnut1.png"));
	static Image tnut2 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Tallnut2.png"));
	static Image tnut3 = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Tallnut3.png"));
	static Image jala = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/Jalapeno.png"));
	static Image cherry = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("plants/CherryBomb.png"));
	
	// Display
	static Image sflowerseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/SunFlowerSeed.PNG"));
	static Image pshooterseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/PeaShooterCard.PNG"));
	static Image snowpshooterseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/SnowPeaSeed.PNG"));
	static Image tpeaterseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/ThreepeaterSeed.PNG"));
	static Image wnutseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/WallnutSeed.PNG"));
	static Image tnutseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/TallnutSeed.PNG"));
	static Image jalaseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/JalapenoSeed.PNG"));
	static Image cherryseed = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/CherryBombSeed.PNG"));
	static Image shovel = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("display/Shovel.png"));
	
	static Image seeds[] = {sflowerseed, pshooterseed, snowpshooterseed, tpeaterseed, wnutseed, tnutseed ,jalaseed, cherryseed, shovel};
	
	// Projectiles
	static Image dropsun = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("projectiles/Sun.png")); 
	static Image pea = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("projectiles/ProjectilePea.png"));
	static Image spea = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("projectiles/ProjectileSnowPea.png"));
	static Image fire = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("projectiles/Fire.png"));
	static Image explosion = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("projectiles/Explosion.png"));
	
	// Lawn
	static Image lawn = Toolkit.getDefaultToolkit()
			.getImage(c.getClass().getClassLoader().getResource("other/Lawn.jpg"));
	
	// Arrays for plants
	static String plantAlmanac[] = { "Sunflower", "Peashooter", "Snowpea", "Threepeater", "Wallnut", "Tallnut", "Jalapeno",
				"Cherrybomb"};
	// ^ Reference for other arrays, which index refers to what plant
	static int plantCost[] = {50, 100, 175, 325, 50, 125, 125, 150};
	static int plantPlacement[][] = new int[9][5]; // 0 for empty spot, 1 for sun flower, 2 for peashooter, etc..
	static Image plants[] = {sflower, pshooter, snowpshooter, tpeater, wnut1, tnut1, jala, cherry, shovel};
	
	public static void main(String[] args) throws InterruptedException {
		
		b.drawImage(wall, 0, 0, 1050, 600);
		
		b.setFont(new Font("Sans Serif", Font.BOLD, 30));
		b.setColor(Color.white);
		b.drawString("Select difficulty then press enter", 50, 50);
		b.drawString("1. Easy", 200, 550);
		b.drawString("2. Medium", 375, 550);
		b.drawString("3. Hard", 575, 550);
		b.drawString("4. Insane", 735, 550);
		
		difficulty = b.readInt();
		b.close();
		
		start = true;
		play.loop();
		
		if (start == true) {
			
			c.enableMouse();
			c.enableMouseMotion();
			
			while (true) {
						
				int plantSelect = 0;
				
				if (c.isKeyDown('1'))
					plantSelect = 1;
				
				else if (c.isKeyDown('2'))
					plantSelect = 2;
				
				else if (c.isKeyDown('3'))
					plantSelect = 3;
				
				else if (c.isKeyDown('4'))
					plantSelect = 4;
				
				else if (c.isKeyDown('5'))
					plantSelect = 5;
				
				else if (c.isKeyDown('6'))
					plantSelect = 6;
			
				else if (c.isKeyDown('7'))
					plantSelect = 7;
				
				else if (c.isKeyDown('8'))
					plantSelect = 8;
				
				else if (c.isKeyDown('9'))
					plantSelect = 9;
				
				// Setting font
				c.setFont(new Font("Sans Serif", Font.BOLD, 30));
				
				synchronized (c) {
					c.clear();
					
					lawnCreate();
					
					drawPlant();
					drawProjectile();
					
					// Selected plant follows mouse
					if (plantSelect != 0) {
						
						if (plantSelect == 6) // For the tallnut, if I draw it as a square it looks really dumb, so I made a seperate case
							c.drawImage(plants[plantSelect - 1], c.getMouseX()-32, c.getMouseY()-36, 60, 90);
						
						else if (plantSelect == 7) // Same with the Jalapeno)
							c.drawImage(plants[plantSelect - 1], c.getMouseX()-32, c.getMouseY()-36, 40, 70);
							
						else
							c.drawImage(plants[plantSelect - 1], c.getMouseX()-32, c.getMouseY()-36, 60, 63);
						
						
					}
					
					// Placing and drawing plant. Since plants must be placed on fixed squares, there is a small
					// algorithm to determine which square it will be placed in (determines column and lane)
					if (c.getMouseClick() != 0) {
						
						int x = c.getMouseX(), y = c.getMouseY();
						// Limitations to prevent out of index bounds error
						if (x > 250 && x < 1000 && y > 50 && y < 540) {
							
							// Checking, if no plant is selected if click is on a sun
							if (plantSelect == 0) {
								
								for (int i = 0; i < sun.size(); i++) {
									
									if (x > sun.get(i).x && x < sun.get(i).x + 70 && y > sun.get(i).y && y < sun.get(i).y + 70) {
										
										sunMoney += sun.get(i).value;
										sun.remove(i);
										
									}
									
								}
								
							}
							else if (plantSelect == 9) { // Using the shovel, must remove the plant
								
								for (int i = 0; i < sunflower.size(); i++) {
									
									if (sunflower.get(i).column == (x - 250 - (x%84))/84 && sunflower.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[sunflower.get(i).column][sunflower.get(i).lane] = 0;
										sunflower.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < peashooter.size(); i++) {
									
									if (peashooter.get(i).column == (x - 250 - (x%84))/84 && peashooter.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[peashooter.get(i).column][peashooter.get(i).lane] = 0;
										peashooter.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < snowpeashooter.size(); i++) {
									
									if (snowpeashooter.get(i).column == (x - 250 - (x%84))/84 && snowpeashooter.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[snowpeashooter.get(i).column][snowpeashooter.get(i).lane] = 0;
										snowpeashooter.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < threepeater.size(); i++) {
									
									if (threepeater.get(i).column == (x - 250 - (x%84))/84 && threepeater.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[threepeater.get(i).column][threepeater.get(i).lane] = 0;
										threepeater.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < wallnut.size(); i++) {
									
									if (wallnut.get(i).column == (x - 250 - (x%84))/84 && wallnut.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[wallnut.get(i).column][wallnut.get(i).lane] = 0;
										wallnut.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < tallnut.size(); i++) {
									
									if (tallnut.get(i).column == (x - 250 - (x%84))/84 && tallnut.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[tallnut.get(i).column][tallnut.get(i).lane] = 0;
										tallnut.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < jalapeno.size(); i++) {
									
									if (jalapeno.get(i).column == (x - 250 - (x%84))/84 && jalapeno.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[jalapeno.get(i).column][jalapeno.get(i).lane] = 0;
										jalapeno.remove(i);
										
									}
									
								}
								
								for (int i = 0; i < cherrybomb.size(); i++) {
									
									if (cherrybomb.get(i).column == (x - 250 - (x%84))/84 && cherrybomb.get(i).lane == (y - 84 - (y%90))/90) {
	
										plantPlacement[cherrybomb.get(i).column][cherrybomb.get(i).lane] = 0;
										cherrybomb.remove(i);
										
									}
									
								}						
								
							}
							
							else
								createPlant(plantSelect, (x - 250 - (x%84))/84, (y - 84 - (y%90))/90);
							
						}
						
					}
					
					spawnTimer++;
					
					// This limits the number of zombies, and strength of zombies at early levels to give
					// the player a chance to build a strong defense for the later seige.
					if (difficulty == 4){
						spawnTrigger = 1;
					}
					else {
						if (stage <= 2) {
							
							spawnTrigger = 500;
							
						}
						else if (stage <= 6) {
							
							spawnTrigger = 300;
							
						}
						else 
							spawnTrigger = 100;
					}
					// When the timer reaches a certain number, a zombie is spawned
					if (spawnTimer == spawnTrigger) {
						
						stage++;
						spawnTimer = 0;
						
						if (stage <= 2)
							createZombie((int)(Math.random())); //* 4)); // Randomly creates the types of zombies
						
						else if (stage <= 6)
							createZombie((int)(Math.random()*2));
						
						else
							createZombie((int)(Math.random()*(difficulty + 1)));
						
					}
								
					for (int i = 0; i < 5; i++){ // Drawing zombies at the back first so there is overlapping
						drawZombie(i);
						
					}	
					
					moveZombie();
					
					display();
					
					// Sun spawning periodically from sky
					sunTimer++;
					
					if (sunTimer == sunTrigger) {
						
						sunTimer = 0;
						sunCreate(true);
						
					}	
					sunCreate(false);
					
					shoot();
					moveProjectile();
					
				}
				
				if (lose == true) {
					loseTimer++;
					c.setColor(Color.red);
					c.drawString("THE ZOMBIES ATE YOUR BRAINS", 400, 300);
				}
				if (loseTimer == 500) {
					c.close();
				}
					
				
				Thread.sleep(50);
				
			}
		
		}
		
	}

	static void lawnCreate() {
		
		c.drawImage(lawn, 0, 0);
		
	}
	
	// Brown thing on the side displaying sunMoney, available cards
	static void display() {
		
		// Graphics to display available plants, sunMOney, etc..
		c.setColor(new Color(102, 51, 0));
		c.fill3DRect(0, 50, 150, 500, true);
		c.setColor(new Color(153, 76, 0));
		c.fillOval(30, 50, 80, 80);
		c.setColor(new Color(255, 230, 153));
		c.fillRect(30, 120, 80, 40);
		
		c.drawImage(dropsun, 36, 55, 70, 70);
		
		
		
		c.setColor(Color.black);
		c.drawString(Integer.toString(sunMoney), 55 - (Integer.toString(sunMoney).length()-2)*10, 152); // If sumMoney has more digits
																										// draws it further back
		c.drawString("Points: " + Integer.toString(score), 10, 30);
		
		for (int x = 1; x < 10; x++) {
			
			c.drawString(Integer.toString(x), 10, x*40 + 170);
			c.drawImage(seeds[x-1], 50, x*40 + 140, 80, 40);
			
		}
		
	}
	// Methods for zombies
	// Creating zombies by adding a new zombie to its corresponding array list
	static void createZombie(int type) {
		
		if (type == 0) {
			
			nzombie.add(new NormalZombie((int) (Math.random() * 5)));
			
		} 
		else if (type == 1) {
			
			czombie.add(new ConeZombie((int) (Math.random() * 5)));
			
		}
		else if (type == 2) {
			
			bzombie.add(new BucketZombie((int) (Math.random() * 5)));
			
		}
		else if (type == 3) {
			
			fzombie.add(new FootballZombie((int) (Math.random() * 5)));
			
		}
		
	}
	
	// Need to add moveTimer for frozen stuff
	static void moveZombie() {
			
		for (int x = 0; x < nzombie.size(); x++) {
			
			nzombie.get(x).moveTimer++;
			nzombie.get(x).eatPlant();
			nzombie.get(x).move();
			
			// If zombie gets to your house, you lose
			if (nzombie.get(x).x < 200) {

				lose = true;
				
			}
			
		}
		for (int x = 0; x < czombie.size(); x++) {
			
			czombie.get(x).moveTimer++;
			czombie.get(x).eatPlant();
			czombie.get(x).move();
			
			if (czombie.get(x).x < 200) {

				lose = true;
				
			}
			
		}
		for (int x = 0; x < bzombie.size(); x++) {
			
			bzombie.get(x).moveTimer++;
			bzombie.get(x).eatPlant();
			bzombie.get(x).move();
			
			if (bzombie.get(x).x < 200) {

				lose = true;
				
			}
			
		}
		for (int x = 0; x < fzombie.size(); x++) {
			
			fzombie.get(x).moveTimer++;
			fzombie.get(x).eatPlant();
			fzombie.get(x).move();
			
			if (fzombie.get(x).x < 200) {

				lose = true;
				
			}
			
		}
		
	}

	static void drawZombie(int drawLane) {
		
		for (int x = 0; x < nzombie.size(); x++) {
			
			if (nzombie.get(x).lane == drawLane)
				c.drawImage(nz, nzombie.get(x).x, nzombie.get(x).y, 72, 120);
			
		}
		
		for (int x = 0; x < czombie.size(); x++) {
			
			if (czombie.get(x).lane == drawLane)
				c.drawImage(cz, czombie.get(x).x, czombie.get(x).y, 62, 140);
			
		}
		
		for (int x = 0; x < bzombie.size(); x++) {
			
			if (bzombie.get(x).lane == drawLane)
				c.drawImage(bz, bzombie.get(x).x, bzombie.get(x).y, 80, 135);
			
		}
		
		for (int x = 0; x < fzombie.size(); x++) {
			
			if (fzombie.get(x).lane == drawLane)
				c.drawImage(fz, fzombie.get(x).x, fzombie.get(x).y, 115, 140);
		}
		
	}
	
	// Methods for plants
	static void createPlant(int type, int column, int lane) {
		
		if (plantPlacement[column][lane] == 0) { // Only allows to plant on empty squares; cannot plant on another plant
			
			if (sunMoney >= plantCost[type-1]) { // Only allows the placement of plant if you have sufficient sunMoney
				sunMoney -= plantCost[type-1];
				
				if (type == 1) {
				
					sunflower.add(new SunFlower(column, lane));
					plantPlacement[column][lane] = 1;
					
				}
			
				else if (type == 2) {
				
					peashooter.add(new PeaShooter(column, lane));
					plantPlacement[column][lane] = 2;
					
				} 
				
				else if (type == 3) {
					
					snowpeashooter.add(new SnowPeaShooter(column, lane));
					plantPlacement[column][lane] = 3;
					
				}
				
				else if (type == 4) {
					
					threepeater.add(new ThreePeater(column, lane));
					plantPlacement[column][lane] = 4;
					
				}
				
				else if (type == 5) {
					
					wallnut.add(new WallNut(column, lane));
					plantPlacement[column][lane] = 5;
					
				}
				
				else if (type == 6) {
					
					tallnut.add(new TallNut(column, lane));
					plantPlacement[column][lane] = 6;
					
				}
				
				else if (type == 7) {
					
					jalapeno.add(new Jalapeno(column, lane));
					plantPlacement[column][lane] = 7;
					
				}
				
				else if (type == 8) {
					
					cherrybomb.add(new CherryBomb(column, lane));
					plantPlacement[column][lane] = 8;
					
				}
				
			}
			
		}
		
	}
	
	static void drawPlant() {
		
		for (int x = 0; x < sunflower.size(); x++) {
			
			c.drawImage(sflower, sunflower.get(x).x, sunflower.get(x).y, 60, 60); 
			
		}
		
		for (int x = 0; x < peashooter.size(); x++) {
			
			c.drawImage(pshooter, peashooter.get(x).x, peashooter.get(x).y, 60, 60); 
			
		}
		
		for (int x = 0; x < snowpeashooter.size(); x++) {
			
			c.drawImage(snowpshooter, snowpeashooter.get(x).x, snowpeashooter.get(x).y, 60, 65); 
			
		}
		
		for (int x = 0; x < threepeater.size(); x++) {
			
			c.drawImage(tpeater, threepeater.get(x).x, threepeater.get(x).y, 65, 70); 
			
		}
		
		for (int x = 0; x < wallnut.size(); x++) {
			
			// Depending on how much hp they have, different pictures
			if (wallnut.get(x).health > 48)
				c.drawImage(wnut1, wallnut.get(x).x, wallnut.get(x).y, 65, 70); 
			
			else if (wallnut.get(x).health > 24)
				c.drawImage(wnut2, wallnut.get(x).x, wallnut.get(x).y, 65, 70); 
			
			else
				c.drawImage(wnut3, wallnut.get(x).x, wallnut.get(x).y, 65, 70); 
		}
		
		for (int x = 0; x < tallnut.size(); x++) {
			
			if (tallnut.get(x).health > 96)
				c.drawImage(tnut1, tallnut.get(x).x, tallnut.get(x).y, 65, 90); 
			
			else if (tallnut.get(x).health > 48)
				c.drawImage(tnut2, tallnut.get(x).x, tallnut.get(x).y, 65, 90); 
			
			else
				c.drawImage(tnut3, tallnut.get(x).x, tallnut.get(x).y, 65, 90); 
			
		}
		
		for (int x = 0; x < jalapeno.size(); x++) {
			
			c.drawImage(jala, jalapeno.get(x).x, jalapeno.get(x).y, 40, 75); 
			
		}
		
		for (int x = 0; x < cherrybomb.size(); x++) {
			
			c.drawImage(cherry, cherrybomb.get(x).x, cherrybomb.get(x).y, 66, 75); 
			
		}
		
	}
	
	static void shoot() { 
		
		// Peashooter
		for (int x = 0; x < peashooter.size(); x++) {
			
			boolean fired = false;
			
			for (int i = 0; i < nzombie.size(); i++) {
				
				if (nzombie.get(i).lane == peashooter.get(x).lane && nzombie.get(i).x > peashooter.get(x).x) { 
					// Checks if zombies are in the lane of the plant, or else it doesn't shoot
					// Also checks to make sure the zombies are infront of the plant, or else it doesnt shoot
					peashooter.get(x).fireTimer++;  
					peashooter.get(x).fire(peashooter.get(x).column, peashooter.get(x).lane);	
					fired = true;
					break; // If I don't break, the for loop for zombies will continue and then if there are multiple zombies
							// in one lane, the fireTimer++ triggers multiple times, and it shoots faster which 
							// is not supposed to happen.
				}
						
			}
			
			if (fired == false) {// If the peashooter hasn't fired yet, checks for other types of zombies
				for (int i = 0; i < czombie.size(); i++) {
				
					if (czombie.get(i).lane == peashooter.get(x).lane && czombie.get(i).x > peashooter.get(x).x) { 

						peashooter.get(x).fireTimer++;  
						peashooter.get(x).fire(peashooter.get(x).column, peashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				for (int i = 0; i < bzombie.size(); i++) {
				
					if (bzombie.get(i).lane == peashooter.get(x).lane && bzombie.get(i).x > peashooter.get(x).x) { 

						peashooter.get(x).fireTimer++;  
						peashooter.get(x).fire(peashooter.get(x).column, peashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				for (int i = 0; i < fzombie.size(); i++) {
				
					if (fzombie.get(i).lane == peashooter.get(x).lane && fzombie.get(i).x > peashooter.get(x).x) { 

						peashooter.get(x).fireTimer++;  
						peashooter.get(x).fire(peashooter.get(x).column, peashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
		}
		
		// Snowpea
		for (int x = 0; x < snowpeashooter.size(); x++) {
			
			boolean fired = false;
			
			for (int i = 0; i < nzombie.size(); i++) {
				
				if (nzombie.get(i).lane == snowpeashooter.get(x).lane && nzombie.get(i).x > snowpeashooter.get(x).x) { 
					// Checks if zombies are in the lane of the plant, or else it doesn't shoot
					// Also checks to make sure the zombies are infront of the plant, or else it doesnt shoot
					snowpeashooter.get(x).fireTimer++;  
					snowpeashooter.get(x).fire(snowpeashooter.get(x).column, snowpeashooter.get(x).lane);	
					fired = true;
					break; // If I don't break, the for loop for zombies will continue and then if there are multiple zombies
							// in one lane, the fireTimer++ triggers multiple times, and it shoots faster which 
							// is not supposed to happen.
				}
						
			}
			
			if (fired == false) {// If the peashooter hasn't fired yet, checks for other types of zombies
				for (int i = 0; i < czombie.size(); i++) {
				
					if (czombie.get(i).lane == snowpeashooter.get(x).lane && czombie.get(i).x > snowpeashooter.get(x).x) { 

						snowpeashooter.get(x).fireTimer++;  
						snowpeashooter.get(x).fire(snowpeashooter.get(x).column, snowpeashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				for (int i = 0; i < bzombie.size(); i++) {
				
					if (bzombie.get(i).lane == snowpeashooter.get(x).lane && bzombie.get(i).x > snowpeashooter.get(x).x) { 

						snowpeashooter.get(x).fireTimer++;  
						snowpeashooter.get(x).fire(snowpeashooter.get(x).column, snowpeashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				for (int i = 0; i < fzombie.size(); i++) {
				
					if (fzombie.get(i).lane == snowpeashooter.get(x).lane && fzombie.get(i).x > snowpeashooter.get(x).x) { 

						snowpeashooter.get(x).fireTimer++;  
						snowpeashooter.get(x).fire(snowpeashooter.get(x).column, snowpeashooter.get(x).lane);	
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
		}
		
		// Threepeater : A little bit different different than the previous two because if a zombie is in any of the
		// three lanes the threepeater can shoot in, it will shoot. Need to check three lanes
		for (int x = 0; x < threepeater.size(); x++) {
			
			boolean fired = false;
			
			for (int i = 0; i < nzombie.size(); i++) {
				
				if ((nzombie.get(i).lane == threepeater.get(x).lane || nzombie.get(i).lane + 1 == threepeater.get(x).lane 
						|| nzombie.get(i).lane - 1 == threepeater.get(x).lane) && nzombie.get(i).x > threepeater.get(x).x) { 

					threepeater.get(x).fireTimer++;  
					threepeater.get(x).fire(threepeater.get(x).column, threepeater.get(x).lane);	
					
					fired = true;
					break; 
					
				}
						
			}
			
			if (fired == false) {
				
				for (int i = 0; i < czombie.size(); i++) {
				
					if ((czombie.get(i).lane == threepeater.get(x).lane || czombie.get(i).lane + 1 == threepeater.get(x).lane 
							|| czombie.get(i).lane - 1 == threepeater.get(x).lane) && czombie.get(i).x > threepeater.get(x).x) { 

						threepeater.get(x).fireTimer++;  
						threepeater.get(x).fire(threepeater.get(x).column, threepeater.get(x).lane);
						
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				
				for (int i = 0; i < bzombie.size(); i++) {
				
					if ((bzombie.get(i).lane == threepeater.get(x).lane || bzombie.get(i).lane + 1 == threepeater.get(x).lane 
							|| bzombie.get(i).lane - 1 == threepeater.get(x).lane) && bzombie.get(i).x > threepeater.get(x).x) { 

						threepeater.get(x).fireTimer++;  
						threepeater.get(x).fire(threepeater.get(x).column, threepeater.get(x).lane);
						
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
			if (fired == false) {
				
				for (int i = 0; i < fzombie.size(); i++) {
				
					if ((fzombie.get(i).lane == threepeater.get(x).lane || fzombie.get(i).lane + 1 == threepeater.get(x).lane 
							|| fzombie.get(i).lane - 1 == threepeater.get(x).lane) && fzombie.get(i).x > threepeater.get(x).x) { 

						threepeater.get(x).fireTimer++;  
						threepeater.get(x).fire(threepeater.get(x).column, threepeater.get(x).lane);	
						
						fired = true;
						break; 
					
					}
				
				}
				
			}
			
		}
		
		// Jalapeno
		for (int x = 0; x < jalapeno.size(); x++) {
			
			jalapeno.get(x).boom();
			
		}
		
		// CherryBomb
		for (int x = 0; x < cherrybomb.size(); x++) {
			
			cherrybomb.get(x).boom();
			
		}	
	}

	static void moveProjectile() {
		
		for (int x = 0; x < projectilepea.size(); x++) {
			
			projectilepea.get(x).move();
			projectilepea.get(x).collision(x);
			
		}
		
		for (int x = 0; x < projectilesnowpea.size(); x++) {
			
			projectilesnowpea.get(x).move();
			projectilesnowpea.get(x).collision(x);
			
		}
	}
	
	static void drawProjectile() {
		
		for (int x = 0; x < sun.size(); x++) {
			
			sun.get(x).y += sun.get(x).speed;
			c.drawImage(dropsun, sun.get(x).x, sun.get(x).y, 70, 70 );
			
		}
		
		for (int x = 0; x < projectilepea.size(); x++) {
			
			c.drawImage(pea, projectilepea.get(x).x, projectilepea.get(x).y, 20, 20);
			
		}
		
		for (int x = 0; x < projectilesnowpea.size(); x++) {
			
			c.drawImage(spea, projectilesnowpea.get(x).x, projectilesnowpea.get(x).y, 20, 20);
			
		}
		
	}
	
	static void sunCreate(boolean sky) {
		
		if (sky == true) {
			
			sun.add(new Sun(true, (int)(Math.random()*700 + 200), 50));
			
		}
		
		for (int x = 0; x < sunflower.size(); x++) {
			
			sunflower.get(x).createTimer++;
			sunflower.get(x).createSun();
			
		}
		
	}
	
}
