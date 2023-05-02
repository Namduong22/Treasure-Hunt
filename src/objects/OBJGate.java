package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJGate extends SuperObject{

public OBJGate() {
		
		name = "Gate";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/gate.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
		
	}
	
}
