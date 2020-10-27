import java.util.*;
/**
 * Write a description of class Dictionary here.
 *
 * @Logan Sitar
 * @13 November 2019
 */
// Dictionary implemented using hashing.
public class HashDictionary<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E>{
    private static final int defaultSize = 10; //default size
    private HashTable<Key, E> T; // The hash table
    private int count;           // # of records now table
    private int maxsize;         // Maximum size of dictionary
    
    HashDictionary(int sz){ //constructor
        T = new HashTable<Key, E>(sz);
        count = 0;
        maxsize = sz;
    }
    
    public void clear(){ // Reinitialize
        T = new HashTable<Key, E>(maxsize);
        count = 0;
    }
    
    public void insert(Key k, E e){ // Insert an element at key k
        assert count < maxsize : "Hash table is full";
        T.hashInsert(k, e); //in hashtable
        count++;
    }

    public E remove(Key k){ // Remove an element at key k
        E temp = T.hashRemove(k); // in hashtable
        if (temp != null){
            count--;
        }
        return temp;
    }
    
    public E removeAny(){ // Remove some element
        if (count != 0){
            count--;
            return T.hashRemoveAny(); //hashtable
        }
        else{
            return null;
        }
    }
    
    public boolean find(Key k){ // Find a record with key value "k"
        return T.hashSearch(k);
    }
    
    public int size(){ // Return number of values in the hash table
        return count;
    }
    
    public void printHT(){
        T.printHT();
    }
}
