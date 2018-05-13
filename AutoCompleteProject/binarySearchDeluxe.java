/*
 *   Code by
 *         Myles Jones 1581604
 *         Dhivakar Krishnamoorthi Geetha 1584511
 *         CMPS 12b
 *     
 *
*/

import java.util.Collections;
import java.util.Comparator;


//Perform multiple binary searches after dividing in half
//Only need to search the front half for the first index if its found 

public class binarySearchDeluxe {
    // Returns the index of the first key in a[] that equals the search key,
    // or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
 
        if (a == null || key == null || comparator == null)
            throw new NullPointerException("An argument is null");
        
        int start = 0;
        int end = a.length-1;
        
     
        if (comparator.compare(a[0], key) == 0) 
                return 0;
        
            while (start <= end) {
                    int mid = start + (end - start) / 2;
            
                    if (comparator.compare(key, a[mid]) > 0){
                        start = mid+1;
                        //System.out.println(end);
                    } else if(comparator.compare(key, a[mid]) < 0){
                        end = mid-1;
                        //System.out.println(start);
                    } else if(comparator.compare(a[mid-1], a[mid]) == 0) {
                        end = mid - 1;
                        //System.out.println(end);
                    } else {
                        return mid;
                    }

            }
            
         return -1;
}
    // Returns the index of the last key in a[] that equals the search key,
    // or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        if (a == null || key == null || comparator == null) {
            throw new NullPointerException("An argument is null");
        }
        
        int start = 0;
        int end = a.length-1;
       
        
        if (comparator.compare(a[end], key) == 0) 
                return end;
        
            while (start <= end) {
                    int mid = start + (end - start) / 2;
            
                    if (comparator.compare(key, a[mid]) > 0){
                        start = mid+1;
                    //System.out.println(start);
                    
                    } else if(comparator.compare(key, a[mid]) < 0){
                        end = mid-1;
                        //System.out.println(end);
                    } else if(comparator.compare(a[mid+1], a[mid]) == 0) {
                        start = mid +1;
                    //System.out.println(start);
                    } else {
                        return mid;
                    }

            }
            
         return -1;
    }
    
    // unit testing (required)
    public static void main(String[] args){
        
            Integer[] numbers = {9,9,9,7,7,4,4,4,0,0,0,0};
            
            //Integer[] numbers = {0,0,1,2,3,4,5,6,7,9,9};
            
            System.out.print(binarySearchDeluxe.firstIndexOf (numbers, 10, Collections.reverseOrder()) + "\t");
            System.out.println(binarySearchDeluxe.lastIndexOf(numbers, 10, Collections.reverseOrder()));
            System.out.print(binarySearchDeluxe.firstIndexOf (numbers, 9, Collections.reverseOrder()) + "\t");
            System.out.println(binarySearchDeluxe.lastIndexOf(numbers, 9, Collections.reverseOrder()));
            System.out.print(binarySearchDeluxe.firstIndexOf (numbers, 4, Collections.reverseOrder()) + "\t");
            System.out.println(binarySearchDeluxe.lastIndexOf(numbers, 4, Collections.reverseOrder()));
            System.out.print(binarySearchDeluxe.firstIndexOf (numbers, 0, Collections.reverseOrder()) + "\t");
            System.out.println(binarySearchDeluxe.lastIndexOf(numbers, 0, Collections.reverseOrder()));
            System.out.print(binarySearchDeluxe.firstIndexOf (numbers, 7, Collections.reverseOrder()) + "\t");
            System.out.println(binarySearchDeluxe.lastIndexOf(numbers, 7, Collections.reverseOrder()));
        

    }
}
