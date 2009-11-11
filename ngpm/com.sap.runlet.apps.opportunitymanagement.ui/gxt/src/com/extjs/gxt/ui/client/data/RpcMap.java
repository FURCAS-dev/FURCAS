/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.extjs.gxt.ui.client.core.FastMap;

/**
 * RpcMap is used to workaround a part of GWT RPC system.
 * <P>
 * 
 * The GWT RPC rebinder generates field serializers for every type that is
 * assignable to any type in the RPC interfaces.
 * 
 * <p />
 * If BaseModel was to use "Map&lt;String, Serializable&gt; map" this would
 * trigger the RPC system to generate field serializers for EVERY Serializable
 * type in your GWT Module's class path.
 * 
 * <p />
 * Therefore BaseModel uses "Map&lt;String, RpcField&gt; map" and relies on type
 * erasure (cast to Map&lt;Object,Object&gt;) to work around this.
 * 
 * <p />
 * The only drawback is that if you have to ensure that field serializers are
 * generated for any type you add to this map.
 * 
 * <p />
 * RpcMap ensures that the following types are supported Byte, Short, Integer,
 * Long, Float, Double, Date, Boolean, and arrays of these types. As well as
 * List, Set and Map
 */
@SuppressWarnings("unused")
public class RpcMap {

  private Byte _byte;
  private Short _short;
  private Integer _integer;
  private Long _long;
  private Float _float;
  private Double _double;
  private Date _date;
  private Boolean _boolean;

  private Byte[] _bytes;
  private Short[] _shorts;
  private Integer[] _integers;
  private Long[] _longs;
  private Float[] _floats;
  private Double[] _doubles;
  private Date[] _dates;
  private Boolean[] _booleans;

  private List<String> _list;
  private Set<String> _set;
  private Map<String, String> _map;

  private transient Map<String, Object> map = new FastMap<Object>();

  /**
   * Returns the internal map.
   * 
   * @return the map
   */
  public Map<String, Object> getTransientMap() {
    return map;
  }

  /**
   * Removes all the mappings from this map.
   */
  public void clear() {
    map.clear();
  }

  /**
   * Returns true if this map contains a mapping for this key.
   * 
   * @param key the key
   * @return true if mapping exists
   */
  public boolean containsKey(String key) {
    return map.containsKey(key);
  }

  /**
   * Returns true if this map maps one or more keys to the specified value.
   * 
   * @param value the value
   * @return true if this map maps one or more keys to the specified value
   */
  public boolean containsValue(Object value) {
    return map.containsValue(value);
  }

  /**
   * Returns a Set view of the mappings contained in this map.
   * 
   * @return a set view of the mappings
   */
  public Set<Map.Entry<String, Object>> entrySet() {
    return map.entrySet();
  }

  public boolean equals(Object o) {
    if(o instanceof RpcMap){
      return map.equals(((RpcMap)o). map);
    }
    return false;
  }

  /**
   * Returns the value to which the specified key is mapped, or null if this map
   * contains no mapping for the key.
   * 
   * @param key the key
   * @return the value to which the specified key is mapped, or null if this map
   *         contains no mapping for the key
   */
  public Object get(String key) {
    return map.get(key);
  }

  public int hashCode() {
    return map.hashCode();
  }

  /**
   * Returns true if this map contains no key-value mappings.
   * 
   * @return true if this map contains no key-value mappings
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Returns a Set view of the keys contained in this map.
   * 
   * @return a set view of the keys contained in this map
   */
  public Set<String> keySet() {
    return map.keySet();
  }

  /**
   * Associates the specified value with the specified key in this map (optional
   * operation).
   * 
   * @param key key with which the specified value is to be associated
   * @param value value to be associated with the specified key
   * @return the previous value associated with key, or null if there was no
   *         mapping for key
   */
  public Object put(String key, Object value) {
    return map.put(key, value);
  }

  /**
   * Copies all of the mappings from the specified map to this map (optional
   * operation).
   * 
   * @param m mappings to be stored in this map
   */
  public void putAll(Map<? extends String, ? extends Object> m) {
    map.putAll(m);
  }

  /**
   * Removes the mapping for a key from this map if it is present (optional
   * operation).
   * 
   * @param key key whose mapping is to be removed from the map
   * @return the previous value associated with key, or null if there was no
   *         mapping for key
   */
  public Object remove(Object key) {
    return map.remove(key);
  }

  /**
   * Returns the number of key-value mappings in this map.
   * 
   * @return the number of key-value mappings in this map
   */
  public int size() {
    return map.size();
  }

  /**
   * Returns a Collection view of the values contained in this map.
   * 
   * @return a collection view of the values contained in this map
   */
  public Collection<Object> values() {
    return map.values();
  }

  @Override
  public String toString() {
    return map.toString();
  }

}