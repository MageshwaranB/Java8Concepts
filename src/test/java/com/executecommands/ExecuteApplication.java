package com.executecommands;

import java.io.File;
import java.io.IOException;

public class ExecuteApplication 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		var file=new File("D:/Modified/");
		var strArr=new String[] {"LevelsofTesting.pdf"};
		Runtime.getRuntime().exec(strArr,null,file);
		System.out.println("File should open");
	}
}
