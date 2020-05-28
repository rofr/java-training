package se.informator.t2732.futuretask;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KeywordSupport {
	
	public static final String startBlock = "/*";
	public static final String endBlock = "*/";
	public static final String oneliner = "//"; 
	
	public static File stripComments(File searchFile){
		
		String inFilename=searchFile.getName();
		int extPos = inFilename.lastIndexOf(".");
		String outFilename = inFilename.substring(0, extPos)+".tmp";
		File outFile = new File(outFilename);
		
		try{
			Scanner inFile = new Scanner(new FileReader(searchFile));			
			PrintWriter tmpFile = new PrintWriter(new FileWriter(outFile));
			
			boolean commentFlag = false;
			while(inFile.hasNextLine()){
				String line = inFile.nextLine();
				if(!commentFlag){
					if(line.contains(startBlock)){
						commentFlag = true;					
					}
					else{
						if(line.trim().indexOf(oneliner)==0){
						//	System.out.println("Skip oneliner");
						}
						else{
							tmpFile.println(line);
						}
					}
				}
				else{
					if(line.contains(endBlock)){
						commentFlag = false;
					}
				}
			}
			inFile.close();
			tmpFile.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return outFile;
	}
}
