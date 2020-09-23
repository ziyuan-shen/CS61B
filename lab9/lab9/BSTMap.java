package lab9;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Ziyuan Shen
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        while (p != null) {
            if (key.compareTo(p.key) < 0) {
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size += 1;
            return new Node(key, value);
        }
        Node r = p;
        while (true) {
            if (key.compareTo(p.key) < 0) {
                if (p.left == null) {
                    p.left = new Node(key, value);
                    size += 1;
                    return r;
                }
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                if (p.right == null) {
                    p.right = new Node(key, value);
                    size += 1;
                    return r;
                }
                p = p.right;
            } else {
                p.value = value;
                return r;
            }
        }
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    private int sizeHelper(Node r) {
        if (r == null) {
            return 0;
        } else {
            return 1 + sizeHelper(r.left) + sizeHelper(r.right);
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return sizeHelper(root);
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    /*
    public static void main(String[] args) {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1 + i);
            //make sure put is working via containsKey and get
            if (null == b.get("hi" + i)) {
                System.out.println("fail1");
            }
            if (!b.get("hi" + i).equals(1 + i)) {
                System.out.println("fail2");
            }
            if (!b.containsKey("hi" + i)) {
                System.out.println("fail3");
            }
        }
        System.out.println(b.size());
        b.clear();
        System.out.println(b.size());
        for (int i = 0; i < 455; i++) {
            if (null != b.get("hi" + i) || b.containsKey("hi" + i)) {
                System.out.println("fail4");
            }
        }
    }
    */
}


