package com.sap.guid;

/**
 * Implements the interface IGUIDGenerator.
 */
class GUIDGenerator implements IGUIDGenerator {
	
  /**
   * configuration properties.
   */
  private java.util.Properties properties;

  /**
   * Creates a GUIDGenerator.
   */
  public GUIDGenerator() {
  }
	
  /**
   * Creates a GUIDGenerator with the specified
   * configuration parameters.
   * 
   * @param props configuration parameters
   */
  public GUIDGenerator(java.util.Properties props) {
  	setProperties(props);	
  }

  /**
   * Constructs a new GUID by the time based algorithm.
   * 
   * @return GUID object
   */
  public IGUID createGUID() {
    return new GUID(properties);
  }
  
  /**
   * Constructs a new GUID from the specified byte array.
   *
   * @param g the byte array to be used
   * 
   * @return GUID object
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID createGUID(byte[] g) throws GUIDFormatException {
    return new GUID(g);
  }
  
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
  public IGUID createGUID(IGUID originalGUID, byte[] variantDescriptor) {
    return new GUID((GUID)originalGUID, variantDescriptor);
  }
  
  /**
   * Constructs a new GUID using the specified algorithm version.
   * The value for the version identifier can be 1 or 4, represented by
   * VERSION_TIME or VERSION_RANDOM, respectively.
   *
   * @param version identifier
   * 
   * @return GUID object
   * @exception GUIDVersionException if the version is invalid
   */
  public IGUID createGUID(int version) throws GUIDVersionException {
    return new GUID(properties, version);
  }
  
  /**
   * Constructs a new GUID by the name based algorithm.
   *
   * @param value String string value to be used by the name-based algorithm
   * 
   * @return GUID object
   */
  public IGUID createGUID(String value) {
    return new GUID(value);
  }
  
  /**
   * Parses the string argument as a GUID string.
   *
   * @param guid String the string representation (as specified in the GUID
   *         IETF Draft) of GUID
   * 
   * @return GUID a GUID that corresponds to the specified value
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID parseGUID(String guid) throws GUIDFormatException {
    return GUID.parseGUID(guid);
  }
  
  /**
   * Parses the string argument as a GUID string.
   *
   * @param guid String the string representation of GUID (string without '-')
   * @return GUID a GUID that corresponds to the specified value
   * @exception  GUIDFormatException  if the format is invalid
   */
  public IGUID parseHexGUID(String guid) throws GUIDFormatException {
    return GUID.parseHexGUID(guid);
  }
  
  public synchronized void setProperties(java.util.Properties props) {
      properties = props;
  }
}
