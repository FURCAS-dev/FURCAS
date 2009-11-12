package com.sap.guid;

/**
 * The <code>IGUIDGeneratorFactory</code> class is a factory hiding the
 * creation of instances of the {@link com.sap.guid.IGUIDGenerator} interface.
 */
public interface IGUIDGeneratorFactory {

  /**
   * Creates an instance of the <code>IGUIDGenerator</code> interface.
   * 
   * @return The instance created.
   */
  public IGUIDGenerator createGUIDGenerator();
  
  /**
   * Creates an instance of the <code>IGUIDGenerator</code> interface
   * with the specified properties.
   * 
   * @param props configuration properties
   * 
   * @return The instance created.
   */
  public IGUIDGenerator createGUIDGenerator(java.util.Properties props);  
}
