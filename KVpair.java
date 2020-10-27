import java.util.*;
/**
 * KVpair is a simple class that gets and sets both the key and E of the
 * KVpair in the hashtable.
 *
 * @Logan Sitar
 * @17 November 2019
 */
public class KVpair<Key, E>{
    private Key k;
    private E e;

    // Constructors
    KVpair(){
        k = null;
        e = null;
    }
    KVpair(Key kval, E eval){
        k = kval;
        e = eval;
    }
    
    // getter methods
    public Key key(){
        return k;
    }
    public E value(){
        return e;
    }
    
    // setter methods
    public void setKey(Key newK){
        k = newK;
    }
    public void setE(E newE){
        e = newE;
    }    
    
    // prints the values how you want them
    public String toString(){
        return "Key: " + k + "/Value: " + e + "\n";
    }
}
