package guerrero_problem2;





public class Application {

	public static void main(String[] args) {
		
		// duplicateCounter object 
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		// calling my count method
		duplicateCounter.count("problem2.txt");
		//calling my write method
		duplicateCounter.write("unique_word_counts.txt");
		
	}

}
