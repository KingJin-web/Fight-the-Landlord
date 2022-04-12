package com.ddz.util;

import java.net.URL;

import javax.swing.ImageIcon;



public class CreatedIcon {
	public static ImageIcon add(String ImageName){
		URL IconUrl = CreatedIcon.class.getResource("/"+ImageName);
		ImageIcon icon=new ImageIcon(IconUrl);
		return icon;
	}
}
