import java.time.Instant;
import java.util.*;
/**
 * HW6 main is a tester for HashDictionary and HashTable.
 *
 * @Logan Sitar
 * @18 November 2019
 */
public class HW6{
    public static void main(String[] args){
        System.out.println("Welcome to my HW6 main tester!");
        HashDictionary tester = new HashDictionary(5);
        
        System.out.println("Before Insert" + java.time.LocalTime.now());
        tester.insert(1, 7);
        System.out.println("After Insert" + java.time.LocalTime.now());        
        tester.insert(2, "zero"); 
        System.out.println("After Insert" + java.time.LocalTime.now());                
        tester.insert(11, 9);
        System.out.println("After Insert" + java.time.LocalTime.now());                
        tester.insert(21, "two");
        System.out.println("After Insert" + java.time.LocalTime.now());                
        tester.insert(35, 3);
        System.out.println("After Insert" + java.time.LocalTime.now());                
        tester.printHT();
        
        System.out.println("\nRemoving Key(11)");
        System.out.println("Before Remove" + java.time.LocalTime.now());        
        tester.remove(11);
        System.out.println("After Remove" + java.time.LocalTime.now());                        
        tester.printHT();
        System.out.println("\nRemoving Key(2)");
        System.out.println("Before Remove" + java.time.LocalTime.now());                
        tester.remove(2);
        System.out.println("After Remove" + java.time.LocalTime.now());                                
        tester.printHT();        
        System.out.println("\nRemoving Key(1)");
        System.out.println("Before Remove" + java.time.LocalTime.now());                        
        tester.remove(1);
        System.out.println("After Remove" + java.time.LocalTime.now());                                
        tester.printHT();
        
        System.out.println("Before Insert" + java.time.LocalTime.now());        
        tester.insert(10, 7);
        System.out.println("After Insert" + java.time.LocalTime.now());                
        tester.insert(22, "zero");
        System.out.println("After Insert" + java.time.LocalTime.now());                
        System.out.println();
        tester.printHT();  
        
        System.out.println("\nRemoving Any(if notihing was removed, compile and run again for new radnom value)");
        tester.removeAny();
        tester.printHT(); 
        
        System.out.println("\nHashSearch for key 22 will return " + tester.find(22));
        System.out.println("\nHashSearch for key 30 will return " + tester.find(30));        
    }
}
