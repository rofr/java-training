package se.informator.t2732.futuretask;

import java.io.*;

import static se.informator.t2732.futuretask.JavaKeywords.*;

public class KeywordFinderApp {
		
	/**
	 * This is where the application kicks off
	 * @param args holding an optional file path as only argument
	 * If no file path is supplied there is a fallback solution pointing out this file
	 */
	public static void main(String[] args){
		// if not supplied this file will be the target
		File file = new File("./src/se/informator/t2732/futuretask/KeywordFinder.java");
		if(args.length > 0){
			file = new File(args[0]);
		}
		
		// strip comments from original file, store in tempfile
		File searchFile = KeywordSupport.stripComments(file);
		
		// look for java keywords in chosen file
		KeywordFinder kf = new KeywordFinder(javaKeywords);
		kf.startSearchThreads(searchFile);
		
		kf.report();
		System.out.println("Search completed for file "+ file);		
	}
}
