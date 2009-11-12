package com.sap.guid;

/**
 * The <code>IGUIDGenerator</code> interface defines the interface to an 
 * implementation of the <code>GUID</code> generation algorithms described in
 * the IETF draft:  draft-leach-uuids-guids-00.txt.
 * <p>
 * It supports the following three <code>GUID</code> generation algorithms:
 * <ul>
 * <li> time-based<br>
 * It uses a combination of the IEEE 802 network address, timestamp,
 * and small random number.<br>
 * usage:
 * <blockquote><pre>
 * createGUID();
 * createGUID(GUID.VERSION_TIME);
 * </pre></blockquote>
 * <li> name-based<br>
 * It uses the <code>MD5</code> message digest for the specified string. 
 * Two identical strings will be guaranteed to result in the identical
 * <code>GUID</code>.<br>
 * usage:
 * <blockquote><pre>
 * createGUID("mailto:akiy@sap.com");
 * createGUID("http://www.sap.com/");
 * </pre></blockquote>
 * <p>derived name-based<br>
 * <p>Creates a derived name based GUID by appending the given 
 * <code>variantDescriptor</code> to the original GUID and then applying MD5
 * to convert it back to GUID format.
 * <blockquote><pre>
 * createGUID(myGuid, "@@@@@@@@@@");
 * createGUID(myGuid, "@EN@OIL@@@@@@@@");
 * createGUID(myGuid, "@FR@PHARMA@000@@@@@@@");
 * </pre></blockquote>
 *
 * <li> random-based<br>
 * It uses a large random number.<br>
 * usage:
 * <p><blockquote><pre>
 * createGUID(GUID.VERSION_RANDOM);
 * </pre></blockquote>
 * <p>
 * Note: For the time-based algorithm, the physical network address must
 * be made visible to the JVM. This class assumes this address to be
 * available in the system property with name <code>ieee802.address</code>. 
 * Use the
 * following method to set this property appropriately.
 * <p><blockquote><pre>
 * System.setProperty("ieee802.address", "00-01-03-87-CE-D0");
 * </pre></blockquote><p>
 * where <code>00-01-03-87-CE-D0</code> (this string can also be 
 * represented as <code>00.01.03.87.CE.D0</code>) is your physical
 * network address.
 * <p>
 * If this property is not set or its value is invalid,
 * the time based algorithm (<code>VERSION_TIME</code>) uses a combination of
 * the IP address and a random number associated with the virtual machine. 
 * If this is not avalilable, a random number is instead used.
 * <p>
 * In addition to the GUID generation algorithms described above, a new GUID
 * object can be constructed from a byte array of length 16 representing
 * a GUID value in bytes.
 * <p><blockquote><pre>
 * createGUID(g);
 * </pre></blockquote> where g is of type byte[] with length 16.
 * <p>
 * The following describes the the representation of GUID
 * <strong>Layout</strong>
 * <p><blockquote><pre>
 * higher 8 bytes
 * 0 1 2 3 4 5 6 7
 * 0xffffffff00000000 time_low
 * 0x00000000ffff0000 time_mid
 * 0x000000000000f000 version
 * 0x0000000000000fff time_high
 * <br>
 * lower 8 bytes
 * 0 1 2 3 4 5 6 7
 * 0xc000000000000000 variant
 * 0x3fff000000000000 clock_seq
 * 0x0000ffffffffffff node
 * </pre></blockquote><p>
 * <strong>Lexical representation</strong>
 * <p><blockquote><pre>
 * higher 8 bytes     lower 8 bytes
 * 0 1 2 3  4 5  6 7  0 1  2 3 4 5 6 7
 * xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
 * </pre></blockquote><p>
 * <strong>Version values</strong>
 * <p><blockquote><pre>
 * time-based   001
 * reserved dce 010
 * name-based   011
 * random-based 100
 * </pre></blockquote><p>
 * <strong>Variant values</strong>
 * <p><blockquote><pre>
 * 10x
 * </pre></blockquote><p>
 * <strong>Timestamp values</strong>
 * <p><blockquote><pre>
 * 60-bit 100-nanosecond units since 1582-10-15T00:00:00
 * </pre></blockquote><p>
 * <strong>Node address</strong>
 * <p><blockquote><pre>
 * 48-bit network hardware address
 * </pre></blockquote><p>
 */
public interface IGUIDGenerator
{
  /**
   * Constructs a new GUID by the time based algorithm.
   * 
   * @return GUID object
   */
  public IGUID createGUID();
  
  /**
   * Constructs a new GUID from the specified byte array.
   *
   * @param g the byte array to be used
   * 
   * @return GUID object
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID createGUID(byte[] g) throws GUIDFormatException;
  
  /**
   * Constructs a derived name based GUID by appending the given 
   * <code>variantDescriptor</code> to the original GUID and then applying
   * MD5 to convert it back to GUID format.
   * 
   * @param originalGUID The original GUID the derived one is calculated from.
   * @param variantDescriptor A descriptor uniquely identifying this variant
   *         of the derived GUID.
   * 
   * @return GUID object
   */
  public IGUID createGUID(IGUID originalGUID, byte[] variantDescriptor);
  
  /**
   * Constructs a new GUID using the specified algorithm version.
   * The value for the version identifier can be 1 or 4, represented by
   * VERSION_TIME or VERSION_RANDOM, respectively.
   *
   * @param version int version identifier
   * 
   * @return GUID object
   * @exception GUIDVersionException if the version is invalid
   */
  public IGUID createGUID(int version) throws GUIDVersionException;

  /**
   * Constructs a new GUID by the name based algorithm.
   *
   * @param value String string value to be used by the name-based algorithm
   * 
   * @return GUID object
   */
  public IGUID createGUID(String value);

  /**
   * Parses the string argument as a GUID string.
   *
   * @param guid String the string representation (as specified in the GUID
   *         IETF Draft) of GUID
   * 
   * @return GUID a GUID that corresponds to the specified value
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID parseGUID(String guid) throws GUIDFormatException;
  
  /**
   * Parses the string argument as a GUID string.
   *
   * @param guid String the string representation of GUID (string without '-')
   * @return GUID a GUID that corresponds to the specified value
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID parseHexGUID(String guid) throws GUIDFormatException;
  
  /**
   * Sets configuration properties.
   */
  public void setProperties(java.util.Properties props);
}
