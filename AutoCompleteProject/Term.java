/*
 *     Code by
 *             Myles Jones 1581604
 *             Dhivakar Krishnamoorthi Geetha 1584511
 *             CMPS 12b
 *           
 *       
 *       */  



import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
private String query;
private long weight;


public Term(String query, long weight) {
    if (query == null) {
        throw new NullPointerException("Query cannot be null");
    }
    if (weight < 0) {
        throw new IllegalArgumentException("weight must not be less than 0");
    }
    this.query = query;
    this.weight = weight;
}


public static Comparator<Term> byReverseWeightOrder(){
    return new Comparator<Term>(){
        public int compare(Term term1, Term term2) {
            if (term1.weight > term2.weight) {
                return -1;
            } else if (term1.weight < term2.weight) {
                return 1;
            } else {
                return 0;
            }
        }
    };
}

public static Comparator<Term> byPrefixOrder(int r) {
    if (r < 0) {
        throw new IllegalArgumentException("r must not be less than 0");
    }
    return new Comparator<Term>(){
        public int compare(Term term1, Term term2) {
            String t1Pre;
            String t2Pre;

            if (term1.query.length() < r) {
                t1Pre = term1.query;
            } else {
                t1Pre = term1.query.substring(0, r);
            }

            if (term2.query.length() < r) {
                t2Pre = term2.query;
            } else {
                t2Pre = term2.query.substring(0, r);
            }
            return t1Pre.compareTo(t2Pre);
        }
    };

}


public int compareTo(Term o) {
    return this.query.compareTo(o.query);
}


public String toString() {
    return weight + "\t" + query;
}


public static void main(String[] args) {

    Term[] terms = {new Term("Thomas", 3), new Term("Angelina", 8), new Term("Joshua", 11), new Term("Maggie", 4)};
    for (int i = 0; i < terms.length; i++) {
        System.out.println(terms[i]);
    }
    System.out.println();
    Arrays.sort(terms, Term.byReverseWeightOrder());
    for (int i = 0; i < terms.length; i++) {
        System.out.println(terms[i]);
    }
    System.out.println();

    Arrays.sort(terms, Term.byPrefixOrder(2));
    for (int i = 0; i < terms.length; i++) {
        System.out.println(terms[i]);
    }
    System.out.println();

    Arrays.sort(terms);
    for (int i = 0; i < terms.length; i++) {
        System.out.println(terms[i]);
    }
  /*
	
	Term[] terms = {new Term("charlie", 3), new Term("chas", 5), new Term("charlene", 10)};
	System.out.println(Arrays.toString(terms));
	Arrays.sort(terms);
	System.out.println(Arrays.toString(terms));
	Arrays.sort(terms, Term.byReverseWeightOrder());
	System.out.println(Arrays.toString(terms));
	System.out.println(Term.byPrefixOrder(3).compare(terms[0], terms[1]));
*/
	
}

}



