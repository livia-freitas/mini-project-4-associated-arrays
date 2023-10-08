package miniproject4;
import java.lang.Object;
import static java.lang.reflect.Array.newInstance;


/**
 * Author: Livia Stein Freitas Implements associated arrays by using the basic Java arrays to create
 * a linked structure of key/value pairs.
 */
public class AssociativeArray<K, V> {
// +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    return null; // STUB
  } // clone()

    /**
   * Return a string of the form "{ key0: value0, key1: value1, ... keyn: valuen }"
   */
  public String toString(){
    String message = "";
    for (int i = 0; i < this.pairs.length; i++) {
     message.concat("key" + i +": " + this.pairs[i].value + ", ");
     message.concat("value" + i +": " + this.pairs[i].key + ", ");
    } // for
    return message;
  }
 
    // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+


  /**
   * Set the value associated with a given key. If there is already another value associated with
   * the given key, this new value replaces that value.
   * 
   * @param _key
   * @param _value
   */
  public void set(K _key, V _value) { 
    int i = this.search(_key);
    if(i == -1) { // if the array is full and there is no match, add K/V pair to the last slot of the array
      this.pairs[this.size].key = _key;
      this.pairs[this.size].value = _value;
    } else { //otherwise, set it to the first null/first match
      this.pairs[i].key = _key;
      this.pairs[i].value = _value;
    }
  }// set()

  /**
   * Get the value associated with a given key. If there is no such key, throws an exception.
   * 
   * @param _key
   * @return
   * @throws Exception
   */
  public V get(K _key) throws Exception {
    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i].key.equals(_key)) {
        return this.pairs[i].value;
      } // if
    } // for
    throw new KeyNotFoundException("There is no such key in this array.");
  }// get()

  /**
   * Determines if the given key appears in the associative array.
   * @param _key
   * @return
   */
  public boolean hasKey(K _key) {
    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i].key.equals(_key)) {
        return true;
      } // if
    } // for
    return false;
  }

  /**
   * Determine how many key/value pairs are currently stored in the associative array.
   * @return
   */
  public int size() {
    int count = 0;
    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i].value != null) { // I don't know whether to check the key or the value
        count ++;
      } // if
    } // for
    return count;
  }//size


    /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    int i = this.search(key);
    this.pairs[i] = null;
  } // remove(K)

    // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Keeps track of the address of the first null and return either (a) the address of the matching element, if found,
   * or (b) the address of the first null, if not found.
   * @param _key
   * @return
   */
  public int search(K _key){ // simplify the boolean checks and loops
    int first_null = -1;
    int match = -1; 

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i].key == null) { 
        first_null = i;
        break;
      } // if
    } // for

    for (int i = 0; i < this.pairs.length; i++) {
      if (this.pairs[i].key.equals(_key)) { 
        match = i;
        break;
      } // if
    } // for

    if(match != -1){
      return match;
    }
    return first_null; // is match if there's a match, first_null if not
  }//search()


}// AssociatedArray
