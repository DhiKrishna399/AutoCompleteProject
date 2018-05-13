/*
 * Code by
 *     Myles Jones 1581604
 *     Dhivakar Krishnamoorthi Geetha 1584511
 *     CMPS 12b
 * 
 * This program uses the files binarySearchDeluxe.java and Term.java to mimic an autocomplete program.
 * The user enters a prefix and the program sorts through the weighting of words in a file to offer
 * its suggestions
 */





import java.util.Arrays;
import java.util.Scanner; 
import java.io.IOException; 
import java.io.File;

public class Autocomplete {
	
	private Term[] queries; 
	
	public Autocomplete(Term[] terms) {
		if(terms == null) {
			throw new NullPointerException("Terms cannot be null");
		}
		
		this.queries = terms;
		Arrays.sort(queries);
	
	}
	
	// Returns all terms that start with the given prefix, in descending order of weight.
	public Term[] allMatches(String prefix) {
		if(prefix == null) {
			throw new NullPointerException("String cannot be null");
		}
		
		Term tempTerm = new Term(prefix,0);
		
		int first = binarySearchDeluxe.firstIndexOf(queries, tempTerm, Term.byPrefixOrder(prefix.length()));
		int last = binarySearchDeluxe.lastIndexOf(queries, tempTerm, Term.byPrefixOrder(prefix.length()));
		
		if(first == -1 || last == -1) {
			throw new NullPointerException("First or Last term is null");
		}
		
		Term[] check = new Term[last - first + 1];
		check = Arrays.copyOfRange(queries, first, last);
		Arrays.sort(check, Term.byReverseWeightOrder());
		return check;
		//Is going to use binarysearchdeluxe
	}
	
	
	// Returns the number of terms that start with the given prefix. 
	public int numberOfMatches(String prefix) {
		
		if(prefix == null) {
			throw new NullPointerException("Prefix is null");
		}
		
		Term tempTerm = new Term(prefix, 0);
		int first = binarySearchDeluxe.firstIndexOf(queries, tempTerm, Term.byPrefixOrder(prefix.length()));
		int last = binarySearchDeluxe.lastIndexOf(queries, tempTerm, Term.byPrefixOrder(prefix.length()));
		
		return last - first + 1;
		
	}
	
	
	// unit testing (required)
	//Main method given in the program assignment handout
	public static void main(String[] args) throws IOException { // read in the terms from a file
		String filename = args[0];
		Scanner in = new Scanner(new File(filename));
		  int N = in.nextInt();
		Term[] terms = new Term[N]; for (int i = 0; i < N; i++) {
		long weight = in.nextLong();
		String query = in.nextLine().trim(); terms[i] = new Term(query, weight);
		// read the next weight // read the next query
		// construct the term
		}
		in.close();
		// read in queries from standard input and print out the top k matching terms 
		int k = Integer.parseInt(args[1]);
		Autocomplete autocomplete = new Autocomplete(terms);
		Scanner stdin = new Scanner(System.in);
		while (stdin.hasNextLine()) {
		String prefix = stdin.nextLine();
		Term[] results = autocomplete.allMatches(prefix);
		for (int i = 0; i < Math.min(k, results.length); i++)
		System.out.println(results[i]); }

		stdin.close(); 
		
		}
		
}


