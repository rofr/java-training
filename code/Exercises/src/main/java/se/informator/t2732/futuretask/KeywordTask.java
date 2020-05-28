package se.informator.t2732.futuretask;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class KeywordTask implements Callable<Integer>{	
	
	private String keyword;	// current task's search criterion
	private File searchFile;// original file to search
	
	/**
	 * Constructor for this task
	 * @param word the actual string to look for
	 * @param file the file where to search
	 */
	public KeywordTask(String word, File file){
		keyword = word;
		searchFile = file;
	}
	
	/**
	 * This is the task that will be executed by the Executor Framework
	 * A call is performed of the routine that counts occurrences of the supplied keyword
	 * @return Integer holding counter value
	 */
	public Integer call(){
//		System.out.println("Callable for keyword "+keyword+" started");	
		int occurrences = search(searchFile);
		return occurrences;
	}
	
	
	/**
	 * This method searches for a specific word in a specified file
	 * NB! This is not a Java-parser, words might occur anywhere including in comments
	 * But, at least only complete words are accepted i.e. no preceding or trailing 
	 * alfanumerical characters are accepted when looking for a match
	 * @param searchFile holds the file to check up
	 * @return int holding the number of occurrences of this task's keyword
	 */
	private int search(File searchFile){

//		System.out.println("Searching for "+keyword+" in "+searchFile);
		int occurrences = 0;
		
		try{
			Scanner inFile = new Scanner(new FileReader(searchFile));
			while(inFile.hasNextLine()){
				String line = inFile.nextLine();
				if(line.contains(keyword)){
					
					// check up details
					int first = line.indexOf(keyword);
					int last = first + keyword.length()-1;
				
					// filter out complete words					
					// check if hit at position 0
					if(first == 0){
						if(line.length()>(last+1)){
							if(!Character.isLetterOrDigit(line.charAt(last+1))){
								occurrences++;
							}
						}
						// keyword alone in this line
						else{
							occurrences++;							
						}
					}
					else{
						// check character preceding hit
						if(!Character.isLetterOrDigit(line.charAt(first-1))){
							// check character following keyword
							if(line.length()>(last+1)){
								if(!Character.isLetterOrDigit(line.charAt(last+1))){
									occurrences++;									
								}
							}
							// keyword at end of line
							else{
								occurrences++;				
							}
						}
					}						
				}
			}	
			Thread.sleep(100);
			inFile.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return occurrences;
	}
	
}
