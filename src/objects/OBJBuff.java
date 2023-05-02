package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJBuff extends SuperObject{

	public OBJBuff() {
		
		name = "Buff";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/buff1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
