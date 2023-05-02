package main;

import java.util.Random;

import objects.OBJBuff;
import objects.OBJChest;
import objects.OBJGate;
import objects.OBJKey;

public class AssetSetter {

	GamePanel gp;

	
	public AssetSetter(GamePanel gp) {		
		this.gp = gp;			
	}
		
	public void setObject() {
		
		Random rand = new Random();
		
		gp.obj[0] = new OBJKey();
		gp.obj[0].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[0].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[1] = new OBJKey();
		gp.obj[1].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[1].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[2] = new OBJKey();
		gp.obj[2].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[2].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[3] = new OBJGate();
		gp.obj[3].worldX = 46 * gp.tileSize;
		gp.obj[3].worldY = 43 * gp.tileSize;
		
		gp.obj[4] = new OBJGate();
		gp.obj[4].worldX = 47 * gp.tileSize;
		gp.obj[4].worldY = 46 * gp.tileSize;
		
		gp.obj[5] = new OBJGate();
		gp.obj[5].worldX = 20 * gp.tileSize;
		gp.obj[5].worldY = 47 * gp.tileSize;
		
		gp.obj[6] = new OBJGate();
		gp.obj[6].worldX = 45 * gp.tileSize;
		gp.obj[6].worldY = 24 * gp.tileSize;
		
		gp.obj[7] = new OBJChest();
		gp.obj[7].worldX = 47 * gp.tileSize;
		gp.obj[7].worldY = 47 * gp.tileSize;
		
		gp.obj[8] = new OBJBuff();
		gp.obj[8].worldX = 3 * gp.tileSize;
		gp.obj[8].worldY = 9 * gp.tileSize;
		
		gp.obj[9] = new OBJKey();
		gp.obj[9].worldX = 12 * gp.tileSize;
		gp.obj[9].worldY = 2 * gp.tileSize;
		
		gp.obj[10] = new OBJBuff();
		gp.obj[10].worldX = 17 * gp.tileSize;
		gp.obj[10].worldY = 31 * gp.tileSize;
		
		gp.obj[11] = new OBJKey();
		gp.obj[11].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[11].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[12] = new OBJKey();
		gp.obj[12].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[12].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[13] = new OBJKey();
		gp.obj[13].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[13].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[14] = new OBJKey();
		gp.obj[14].worldX = rand.nextInt(50) * gp.tileSize;
		gp.obj[14].worldY = rand.nextInt(50) * gp.tileSize;
		
		gp.obj[15] = new OBJGate();
		gp.obj[15].worldX = 45 * gp.tileSize;
		gp.obj[15].worldY = 6 * gp.tileSize;
	}
		
}
