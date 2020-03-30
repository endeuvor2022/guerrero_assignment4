package guerrero_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Formatter;
//Create an instance method called count 
//that takes a single parameter called dataFile of type String
//(representing the path to a text file) a
public class DuplicateCounter {
	
	public Formatter printOut;
	// Map interface
	Map<String, Integer> wordCounter = new HashMap<>();
	 Scanner file = null;
	 public int count =0;
		
		public  void count(String dataFile) 
		{
			// local variables
			
			String list2= null;
		   
			
		
		      try{
		    	  	file = new Scanner(new File(dataFile));
		    	  	
		      	 } 
		     
		      catch (FileNotFoundException e) 
		      		{
		    	  		System.out.println("file name error");
		    	  		e.printStackTrace();
		      		}
			
		    
		      //looping in my file
		      while (file.hasNext()) 
		      {
		    	  list2= file.next().toLowerCase().replaceAll("[\\W].", "");
		    	  String[] tokens = list2.split(" "); // split based on space

		    	  for (String token: tokens) 
		    	  {
		    		  String word = token.toLowerCase();
		    		  
		    		  if (wordCounter.containsKey(word)) 
		    		  {
		    			  count = wordCounter.get(word); // get word count 
		    			  wordCounter.put(word, count + 1); // override word count
		    		  } 
		    		  else 
		    		  {
		    			  wordCounter.put(word, 1); // initial word count to 1
		    		  }
		    	  }
		      }
		     
		      
		     
		     


			file.close();
			
		}

		
		public void write (String outputFile)    
		{
			 // list of unique words because it's a Set
			Set < String > keys = wordCounter.keySet();
			// ascending order of words
			TreeSet < String > sortedKeys = new TreeSet < > (keys);
		
			try
			{	// file method 
				File file = new File(outputFile);
				 
				  //conditional if the file exist or not  
				 if (file.exists() && file.isFile())
				    {
					 	PrintWriter printOut = new PrintWriter(new File(outputFile));
				       
						// iterate in the unique words 
						for(String newstring : wordCounter.keySet())
						{  
							printOut.format(" %s\t\t%d%n   \n",newstring , wordCounter.get(newstring));
						}
						
						// print my words
						
						// flushes and closes the PrintWrite
						printOut.flush();
						printOut.close();

				    }
				
				 // else conditional that created a new file

				 else
				    {
					 
					 PrintWriter printOut = new PrintWriter(new File(outputFile));
				    	
				    	
				
				    	// // iterate in the unique words 
				    	
				    	for(String newstring : wordCounter.keySet())
				    	{
				    		System.out.println("aqui");
				    		printOut.print(newstring + " "+wordCounter.get(newstring));
					
				    	}
				    	//print my count number
				    	for (String str: sortedKeys) {

						       System.out.println("Word =" + str + " and it's count = " +wordCounter.get(str));

						      }
				    	// warning message about the file status
				    	System.out.println("");
				    	System.out.println("file created");
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
