package com.executecommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class PingCommand 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Process process=Runtime.getRuntime().exec("ping www.stackabuse.com");
		process.waitFor();
		var bufferStream=new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line="";
		while((line=bufferStream.readLine())!=null) {
			System.out.println(line);
		}
	}
}
