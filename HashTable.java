import java.util.*;
/**
 * The HashTable Class is can array full of KVpairs which you can insert and remove
 * using linear, quadratic, and pseudo-random probing. There is also a hashSearch method
 * and a removeAny method which returns a boolean if the key is in the HT and removes a 
 * random key.
 *
 * @Logan Sitar
 * @17 November 2019
 */
public class HashTable <Key, E> extends KVpair<Key, E> {
    private KVpair[] HT; //array of KVpairs
    private int M;    //size of hashtable
    private String EMPTYKEY = "[del]"; //fills when removed

    HashTable(int sz) { //constructor
        HT = new KVpair[sz];
        M = sz;
        for (int i = 0; i < sz; i++) {
            HT[i] = new KVpair();
        }
    }

    // insert key into HT
    public void hashInsert(Key k, E e) {
        int home; //Home position for e
        int pos = home = h(k); //Initial probe sequence
        for (int i=0; (EMPTYKEY != (HT[pos]).key() && null != HT[pos].key()) && i < M; i++) {
            if (k == HT[pos].key()) {
                System.out.println("Duplicates are not allowed");
                return; 
            }
            // uncomment desired probing function
            pos = (home + p(k, i)) % M; //linear
            //pos = (home + qp(k, i)) % M; //quadratic
            //pos = (home + prp(k, i)) % M; //pseudo-random
        }
        if (HT[pos].key() == null || HT[pos].key() == EMPTYKEY) {
            HT[pos].setE(e);
            HT[pos].setKey(k);
        }
    }
    
    //hashSearch will probe the HT until the key is found or not
    public boolean hashSearch(Key k) {
        E e;
        int home;
        int pos = home = h(k);
        for (int i = 1; (k != (HT[pos]).key()) && (EMPTYKEY != (HT[pos]).key()); i++) {
            try {
                pos = (home + (p(k, i))) % M;
            }
            catch (Exception x) {
                return false;
            }
        }
        if (k == (HT[pos]).key()) {
            e = (E) HT[pos].value();
            return true;
        }
        else return false;
    }
    
    // remove a key if its in the table
    public E hashRemove(Key k) {
        E e;
        int home;
        int pos = home = h(k); 
        for (int i = 1; (k != (HT[pos]).key()) && (EMPTYKEY != (HT[pos]).key()); i++) {
            try {
                // uncomment desired probing function
                pos = (home + p(k, i)) % M; //linear
                //pos = (home + qp(k, i)) % M; //quadratic
                //pos = (home + prp(k, i)) % M; //pseudo-random
            }
            catch (Exception x) {
                System.out.println("Desired key not found in the table");
                break;
            }
        }
        if (k == (HT[pos]).key()) {
            e = (E) HT[pos].value();
            HT[pos].setE(EMPTYKEY);
            HT[pos].setKey(EMPTYKEY);
            return e;
        }
        else {
            pos--;
            return null;
        }
    }
    
    // remove random key
    public E hashRemoveAny() {
        if (M <= 0){
            System.out.println("The table is empty");
        }
        Random rand = new Random();
        int pos = rand.nextInt(M); 
        E e = (E) HT[pos].value(); 
        HT[pos].setE(EMPTYKEY);
        HT[pos].setKey(EMPTYKEY);
        return e;
    }
    
    // hash function to get home position of key
    public int h(Key k) {
        return (int)k % M;
    }
    
    // linear probing function
    public int p(Key k, int i) {
        if (EMPTYKEY == HT[i].key() || null == HT[i].key()) {
            return 0;
        }
        i++;
        return i;
    }
    
    // quadratic probing function
    public int qp(Key k, int i) {
        if (EMPTYKEY == HT[i].key() || null == HT[i].key()) {
            return 0;
        }
        i = i*i;
        return i;
    }
    
    // pseudo-random probing function
    public int prp(Key k, int i) {
        ArrayList<Integer> probeArray = new ArrayList<Integer>(M);
        Random rand = new Random();
        if (EMPTYKEY == HT[i].key() || null == HT[i].key()) {
            return 0;
        }
        for (int y = 0; y < M; y++) {
            int temp = rand.nextInt(M); 
            probeArray.add(temp);
        }
        for (int z = 1; z < probeArray.size(); z++) {
            if (EMPTYKEY == HT[i].key() || null == HT[i].key()) {
                return probeArray.get(z);
            }
            i = probeArray.get(z);
            z++;
        }
        return 0;
    }
    
    // print method for the HT
    public void printHT() {
        for (int i = 0; i < M; i++) {
            System.out.print(HT[i]);
        }
    }
}
    























