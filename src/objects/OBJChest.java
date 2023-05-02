package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJChest extends SuperObject{
	
public OBJChest() {
		
		name = "Chest";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/treasure-chest2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
