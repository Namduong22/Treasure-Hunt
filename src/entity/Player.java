package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		setDefaultValues();
		getPlayerImage();
		direction = "down";
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 24;
		worldY = gp.tileSize * 24;
		speed = 4;
		
	}
	
	public void getPlayerImage() {
		
		try {			
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Up_2.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Down.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/ADV2_Right_2.png"));
	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true 
				|| keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";				
			}		
			else if(keyH.downPressed == true) {
				direction = "down";				
			}		
			else if(keyH.leftPressed == true) {
				direction = "left";			
			}		
			else if(keyH.rightPressed == true) {
				direction = "right";				
			}
			
			//CHECK TILE COLLISON
			collisionOn = false;
			gp.Checkers.checkTile(this);
			
			// CHECK OBJECT COLLSION
			int objIndex = gp.Checkers.checkObject(this, true);
			pickUpObject(objIndex);
			
			//IF COLLISION IS FALSE PLAYER CAN MOVE
			if(collisionOn == false) {
				
				switch(direction) {
				case"up":
					worldY -= speed;
					break;
				case"down":
					worldY += speed;
					break;
				case"left":
					worldX -= speed;
					break;
				case"right":
					worldX += speed;
					break;	
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
//				else if(spriteNum == 3) {
//					spriteNum = 1;
//				}
				spriteCounter =0;	
			}			
		}		
	}
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got a Key!");		
				break;
			case "Gate":			
				if(hasKey > 0) {
					gp.playSE(3);
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You opened the Gate!");	
				}
				else {
					gp.ui.showMessage("You need a Key!");	
				}
				break;
			case "Buff":
				gp.playSE(2);
				speed += 1;
				gp.obj[i] = null;
				gp.ui.showMessage("Increased speed!");	
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				gp.playSE(4);
				break;
			}					
		}
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);	
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			break;
			
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			break;
			
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
