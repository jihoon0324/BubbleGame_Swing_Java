package bubble.game.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.game.component.Bubble;

public class BackgroundBubbleService {
	private BufferedImage image;
	private Bubble bubble;

	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public boolean leftWall() {
		Color leftcolor = new Color(image.getRGB(bubble.getX() , bubble.getY() +25));
		if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 & leftcolor.getBlue() == 0) {
			return true;
			

			}
		return false;
	}

	public boolean rightWall() {
		Color rightcolor = new Color(image.getRGB(bubble.getX()+50+15, bubble.getY()+25));
		if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 & rightcolor.getBlue() == 0) {
			return true;
			

			}
		return false;
	}

	public boolean topWall() {
		Color topColor = new Color(image.getRGB(bubble.getX()+25+10, bubble.getY()-10));
		if (topColor.getRed() == 255 && topColor.getGreen() == 0 & topColor.getBlue() == 0) {
			return true;
			

			}
		return false;
	}

}
