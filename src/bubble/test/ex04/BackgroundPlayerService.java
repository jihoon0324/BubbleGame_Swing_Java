package bubble.test.ex04;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
	private BufferedImage image;
	private Player player;
	private  List<Bubble> bubbleList;

	public BackgroundPlayerService(Player player) {
		
		this.player = player;
		this.bubbleList =player.getBubbleList();
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			//버블 충돌 체크
			for(int i=0; i<bubbleList.size(); i++) {
				Bubble bubble= bubbleList.get(i);
				if(bubbleList.get(i).getState() == 1) {
					if((Math.abs(player.getX() -bubble.getX()) <10 ) &&
							(Math.abs(player.getY() -bubble.getY()) >0 &&  Math.abs(player.getY() -bubble.getY()) <50 )) {
						System.out.println("적군 사살 완료");
					
						bubble.clearBubbled();
						break;
						
					}
				}
				
			}
			
			
			
			
			
			
			
			// 벽 충돌체크
			Color leftcolor = new Color(image.getRGB(player.getX() , player.getY() +25));
			Color rightcolor = new Color(image.getRGB(player.getX()+50+15, player.getY()+25));
			int bottomColor = image.getRGB(player.getX() +25, player.getY()+50+5)
					+ image.getRGB(player.getX()+50 -15, player.getY()+50+5);
		
			
			//floor
			if(bottomColor !=-2) {
			//	System.out.println(bottomColor);
				player.setDown(false);
			}else { // -2 일때 실행 => 바닥 색이 하얀색
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
				
			}
			
			
			//wall
			if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 & leftcolor.getBlue() == 0) {
			//	System.out.println("충돌");
				player.setLeft(false);
				player.setLeftWallCrach(true);

			} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 & rightcolor.getBlue() == 0) {
			//	System.out.println("오른쪽충돌");

				player.setRight(false);
				player.setRightWallCrash(true);
			}else {
				player.setLeftWallCrach(false);
				player.setRightWallCrash(false);
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
