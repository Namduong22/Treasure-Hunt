package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

import objects.OBJKey;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font arial_40, arial_80B;
	BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public int commandNum = 0;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new  Font("Arial", Font.PLAIN, 40);
		arial_80B = new  Font("Arial", Font.BOLD, 80);
		OBJKey key = new OBJKey();
		keyImage = key.image;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		
		if(gp.gameState == gp.playState) {
			
			if(gameFinished == true) {
				
				g2.setFont(arial_40);
				g2.setColor(Color.white);			
				
				
				gp.gameThread = null;
				displayHighscores(playTime);
				
			}else {
				g2.setFont(arial_40);
				g2.setColor(Color.white);			
				//Keys
				g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
				g2.drawString("x "+ gp.player.hasKey, 72, 65);		
				
				//TIME
				playTime +=(double)1/60;
				g2.drawString("Time:"+dFormat.format(playTime), gp.tileSize*11, 65);
//				g2.drawString("Time:"+playTime, gp.tileSize*11, 65);
				
				//MESSAGE
				if(messageOn == true) {
					
					g2.setFont(g2.getFont().deriveFont(30F));
					g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
					
					messageCounter++;
					
					if(messageCounter > 120) {
						messageCounter = 0;
						messageOn = false;
					}
				}
			}
		}
		
		
		this.g2 = g2;
		
		g2.setColor(Color.white);
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		//PLAY STATE
		if(gp.gameState == gp.playState) {		
			
		}
		
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawTitleScreen() {
		
		//BACKGROUND COLOR
		g2.setColor(new Color(70,120,80));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//TITLE NAME
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
		String text = "Treasure Hunter";
		int x = getXforCenteredText(text);
		int y = gp.tileSize*3;
		
		//SHADOW
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		//MAIN COLOR
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//CHARACTER IMAGE
		x = gp.screenWidth/2 - (gp.tileSize*2)/2;
		y += gp.tileSize*2;
		g2.drawImage(gp.player.down, x, y, gp.tileSize*2, gp.tileSize*2, null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
		
		text = "NEW GAME";
		x = getXforCenteredText(text);
		y += gp.tileSize*3.5;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		
		text = "HIGHSCORE";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		
		text = "QUIT";
		x = getXforCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNum == 2) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		
	}	
	
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,60F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);					
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);	
		
	}
	
public void displayHighscores(Double playTime) {
	    
	    //Ket noi CSDL
	    
	    try {
		    // Kết nối đến cơ sở dữ liệu
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/highscores?serverTimezone=UTC","root", "");
		    
		    // Tạo câu lệnh SQL để thêm thời gian hoàn thành vào bảng
		    String sql = "INSERT INTO highscore (highscores) VALUES (?)";
		    
		    // Tạo prepared statement để thêm dữ liệu vào câu lệnh SQL
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setDouble(1, playTime); 
		    
		    // Thực thi câu lệnh SQL để thêm dữ liệu vào bảng
		    pstmt.executeUpdate();
		    
		    // Đóng kết nối
		    pstmt.close();
		    conn.close();
		 } catch (SQLException e) {
		    e.printStackTrace();
		 }
	    
	    
	    //Doc tu CSDL
	    try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/highscores?serverTimezone=UTC","root", "");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM highscore ORDER BY highscores ASC LIMIT 3");
            
            String message = "HighScore :\n";

            while (resultSet.next()) {
                double score = resultSet.getDouble("highscores");

                System.out.println(score);
                

        	    for (int i = 0; i < 1; i++) {
        	        if (i < 3) {
        	            message += dFormat.format(score) + " giây\n" ;
        	        } else {
        	            message += "-\n";
        	        }
        	        
        	    }
        	    
        	    
        	   
            }
    	    JOptionPane.showMessageDialog(null, message);
            
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    
	    
	    //Cua so tat 
	    int option = JOptionPane.showOptionDialog(null, "Hãy cố gắng vượt qua kỷ lục của bản thân nhé!","Bạn đã hoàn thành" , JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION) {
	        System.exit(0);
	        
	    }
	    
	}
	
	public void displayHighscoresMenu(Double playTime) {
		 
	    //Ket noi CSDL
	    
	    try {
		    // Kết nối đến cơ sở dữ liệu
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/highscores?serverTimezone=UTC","root", "");
		    
		    conn.close();
		 } catch (SQLException e) {
		    e.printStackTrace();
		 }
	    
	    
	    //Doc tu CSDL
	    try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/highscores?serverTimezone=UTC","root", "");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM highscore ORDER BY highscores ASC LIMIT 3");
            
            String message = "HighScore :\n";

            while (resultSet.next()) {
                double score = resultSet.getDouble("highscores");

                System.out.println(score);
                

        	    for (int i = 0; i < 1; i++) {

        	        if (i < 3) {
        	            message += dFormat.format(score) + " giây\n" ;
        	        } else {
        	            message += "-\n";
        	        }
        	        
        	    }
        	           	            	   
            }
    	    JOptionPane.showMessageDialog(null, message);
            
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    		
	}
	
		
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
