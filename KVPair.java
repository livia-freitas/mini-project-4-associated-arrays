package miniproject4;

/**
 * An easy way to store key/value pairs.  We assume that other
 * classes will access fields directly.
 */
class KVPair<K,V> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.
   */
  K key;

  /**
   * The value.
   */
  V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty key/value pair.
   */
  KVPair() {
    this(null, null);
  } // KVPair()

  /**
   * Create a new key/value pair.
   */
  KVPair(K key, V value) {
    this.key = key;
    this.value = value;
  } // KVPair(K,V)

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  public KVPair<K,V> clone() {
    return new KVPair<K,V>(this.key, this.value);
  } // clone()

  public String toString() {
    return "{ " + this.key.toString() + " : " + this.value.toString() + " }";
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  } // toString()
  
} // class KVPair

