package com.christmas.config;

import java.io.File;

import com.christmas.pojo.Sound;
import com.christmas.ui.ChristMasFrame;
import com.christmas.ui.ChristMasPanel;
import com.christmas.util.GetImgUtil;
import com.christmas.util.sound.SoundManager;
/**
 * 配置类
 * @author 四诗风雅颂
 *
 */
public class Config {
	/**背景音效的路径*/
	public static final String FILENAME=
			"music"+File.separator+"merry_christmas.wav";
	/**
	 * 对UI及音效的配置
	 */
	public void config(){
		SoundManager m=new SoundManager(2);
		ChristMasFrame frame=new ChristMasFrame(m);
		ChristMasPanel panel=new ChristMasPanel();
		Sound sound=m.getSound(FILENAME);
		frame.setPanel(panel);
		frame.init(GetImgUtil.icon);
		frame.start();
		m.play(sound,true);
	}
}
