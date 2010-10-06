package com.sap.furcas.textual.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


/**
 * Util for easy storage of elements in Lists maintained in a map.
 * 
 */
public class KeyToListMap<K, E> { //extends HashMap<K, List<E>> implements Map<K, List<E>> {

    
    private HashMap<K, List<E>> map = new HashMap<K, List<E>>();
    
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Put.
	 * 
	 * @param key the key
	 * @param value the value
	 */
	public void put(K key, E value) {
		List<E> list = map.get(key);
		if (list == null) {
			list = new ArrayList<E>();
		}
		list.add(value);
		map.put(key, list);
	}

    /**
     * @return
     */
    public Iterator<Entry<K, List<E>>> entryIterator() {
        return map.entrySet().iterator();
    }
	
	
}
