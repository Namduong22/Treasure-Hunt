package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJKey extends SuperObject {
	
	public OBJKey() {
		
		name = "Key";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/00.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
