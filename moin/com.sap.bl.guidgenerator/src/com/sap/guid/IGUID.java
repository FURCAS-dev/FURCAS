package com.sap.guid;

/**
 * The <code>IGUID</code> interface
 * defines the interface to <code>GUIDs</code> generated according to the 
 * algorithms described in the IETF draft:  draft-leach-uuids-guids-00.txt.
 * <p>
 * For the details see {@link com.sap.guid.IGUIDGenerator}.
 */
public interface IGUID extends Comparable {

  /**
   * number of bytes a GUID has
   */
  
  public static final int NUMBYTES = 16;
  
  /** version number NIL */
  public static final int VERSION_NIL = 0;
  
  /** version number for the time based algorithm */
  public static final int VERSION_TIME = 1;
  
  /** version number for the name-based algorithm */
  
  public static final int VERSION_NAME = 3;
  /** version number for the random-based algorithm */
  
  public static final int VERSION_RANDOM = 4;
  
//  /**
//   * Returns true if the specified GUID is equal to this GUID.
//   * @param guid GUID to be compared with
//   * @return boolean true if they are equal; otherwise false
//   */
//  public boolean equals(GUID guid);
  
  /**
   * Returns true if the specified object is equal to this GUID.
   *
   * @param obj Object the object to be compared
   * @return boolean true if they are equal; otherwise false
   */
  public boolean equals(Object obj);
  
  /** 
   * Gets the clock sequence.
   * 
   * @return the current value of the clock sequence
   */
  public int getClockSeq();
  
  /**
   * Gets the timestamp.
   * 
   * If this GUID has version=VERSION_TIME, this method returns the timestamp
   * of the GUID. Otherwise it returns 0.
   *
   * This only returns the timestamp component of this GUID as
   * converted into the number of milliseconds since 1970-01-01T00:00:00.
   * Therefore, it differs from the actual timestamp value in this GUID.
   * 
   * @return the timestamp of this GUID
   */
  public long getTimestamp();
  
  /**
   * Returns the variant of this GUID. This GUID implementation
   * supports only variant 2.
   *
   * @return int the variant of this GUID generation.
   */
  public int getVariant();
  
  /**
   * Returns the version of this GUID. The currently supported
   * versions are 1, 3, and 4, represented by the constants
   * VERSION_TIME, VERSION_NAME, and VERSION_RANDOM, respectively.
   *
   * @return int the version of this GUID generation.
   */
  public int getVersion();
  
  /**
   * Returns true if the GUID is Nil (all 128 bits are set to zero)
   *
   * @return boolean true if this GUID is Nil; Otherwise false.
   */
  public boolean isNil();
  
  /**
   * Returns the byte array representation of this GUID.
   *
   * @return byte[] the byte array representation of GUID
   */
  public byte[] toBytes();
  
  /**
   * Returns the hex string representation of this GUID. There are
   * no dashes in this representation.
   *
   * @return String the hex string representation of GUID
   */
  
  public String toHexString();
  
  /**
   * Returns the string representation of this GUID.
   *
   * @return String the string representation of GUID
   */
  public String toString();
}
