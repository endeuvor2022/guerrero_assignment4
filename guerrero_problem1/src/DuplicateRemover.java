package guerrero_assigment4;

import java.io.File;

import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;









public class DuplicateRemover {
	
	 Set<String> uniqueWords = new HashSet<String>();
	
	 public  void remove(String dataFile) 
	{
		 //local variables
		String list2;
	    Scanner file = null;
		
	
	      try{
	    	  	// read the file
	    	  	file = new Scanner(new File(dataFile));
	      	 } 
	     
	      catch (FileNotFoundException e) 
	      		{
	    	  		System.out.println("file name error");
	    	  		e.printStackTrace();
	      		}
		
	      while (file.hasNext()) 
	      {
	    	  // store my file in my string variable
			list2= file.next().toLowerCase().replaceAll("[\\W].", "");
			// passing my string to my set 
			uniqueWords.add(list2);
	      }

		file.close();
		
	}
	
	public void write (String outputFile)    
	{
	try
		{
		
			// file method 
			 File file = new File(outputFile);
			 //  exists = file.exists();
			  //conditional if the file exist or not  
			 if (file.exists() && file.isFile())
			    {
				 	//using printwriter to out my file
			        PrintWriter printOut = new PrintWriter(new File(outputFile));
					
					// iterate in the unique words 
					for(String newstring : uniqueWords)
					{
						printOut.print(newstring + " \n");
					}
					
					
					// flushes and closes the PrintWrite
					printOut.flush();
					printOut.close();

			    }
			  // else conditional that created a new file
			 else
			    {
				 
				 	
				
			    	PrintWriter printOut = new PrintWriter(new File(outputFile));
			    	
			    	
			
			    	// // iterate in the unique words 
			    	
			    	for(String newstring : uniqueWords)
			    	{
			    		printOut.print(newstring + " \n\n");
				
			    	}
			    	// iterator for looping and printing of the unique words
			    	Iterator<String> p = uniqueWords.iterator();
			    	while(p.hasNext())
			    	{
			    		System.out.print(p.next()+" ");
			
			    	}
			    	
			    	// flushes and closes the PrintWriter 
			    	printOut.flush();
			    	printOut.close();
			    }
		// The catch function gives an error 
		// display a warning message if something is wrong
		}catch(FileNotFoundException e)
		{
			System.out.println("Error occurs in the proccess of create or overwrite the file");
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}				
	
	
