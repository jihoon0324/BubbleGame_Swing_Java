package bubble.test.ex04;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BGM {
public BGM() {
	try {
		AudioInputStream ais =AudioSystem.getAudioInputStream(new File("sound/bgm.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		//소리설정 그냥 open 하면 소리가 너무 크다
		FloatControl gainControl =(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		//볼륨 조정
		//  float Type이면 f 를 넣어주고   double type  이면 그냥 -30.0 
		gainControl.setValue(-30.0f);
		
		clip.start();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
}
}
