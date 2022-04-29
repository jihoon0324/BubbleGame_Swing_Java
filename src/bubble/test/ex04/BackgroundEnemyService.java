package bubble.test.ex04;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundEnemyService implements Runnable {
	private BufferedImage image;
	private Enemy enemy;


	public BackgroundEnemyService(Enemy enemy) {
		
		this.enemy = enemy;
		
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (enemy.getState() ==0) {
	
			// 벽 충돌체크
			Color leftcolor = new Color(image.getRGB(enemy.getX() , enemy.getY() +25));
			Color rightcolor = new Color(image.getRGB(enemy.getX()+50+15, enemy.getY()+25));
			int bottomColor = image.getRGB(enemy.getX() +25, enemy.getY()+50+5)
					+ image.getRGB(enemy.getX()+50 -15, enemy.getY()+50+5);
		
			
			//floor
			if(bottomColor !=-2) {
			//	System.out.println(bottomColor);
				enemy.setDown(false);
			}else { // -2 일때 실행 => 바닥 색이 하얀색
				if(!enemy.isUp() && !enemy.isDown()) {
					enemy.down();
				}
				
			}
			
			
			//wall
			if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 & leftcolor.getBlue() == 0) {
			//	System.out.println("충돌");
				enemy.setLeft(false);
			  if(!enemy.isRight()) {
				  enemy.right();
			  }

			} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 & rightcolor.getBlue() == 0) {
			//	System.out.println("오른쪽충돌");

				enemy.setRight(false);
				 if(!enemy.isLeft()) {
					  enemy.left();
				  }
			
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
