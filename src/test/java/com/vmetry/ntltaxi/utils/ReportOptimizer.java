package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.initializer.initializer;

public class ReportOptimizer extends initializer {


	public static void archiveFiles() throws IOException{
		
		if(isArchive){
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss-mmm");
		String path=df.format(new Date());
		System.out.println(path);
		File src=new File("E:\\selenium\\testing1\\DDDTest\\Screenshot");
		File dst=new File("E:\\selenium\\testing1\\DDDTest\\archiveFolder\\OLD"+path);
	
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		isArchive=false;
		}
	}
}
