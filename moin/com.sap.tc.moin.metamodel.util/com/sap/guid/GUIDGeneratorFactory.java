package com.sap.guid;

/**
 * The <code>GUIDGeneratorFactory</code> class is a factory hiding the
 * creation of instances of the {@link com.sap.guid.IGUIDGenerator} interface.
 */
public class GUIDGeneratorFactory implements IGUIDGeneratorFactory
{
  /**
   * The one and only instance of the <code>GUIDGeneratorFactory</code> class.
   */
  private static IGUIDGeneratorFactory theGUIDGeneratorFactory = null;

  /**
   * Private constructor (singleton).
   */
  private GUIDGeneratorFactory()
  {
  }

  /**
   * Returns reference to the one and only instance of the
   * <code>GUIDGeneratorFactory</code> class.
   * 
   * @return reference to the class instance
   */
  public static IGUIDGeneratorFactory getInstance()
  {
    if(theGUIDGeneratorFactory == null)
    {
      theGUIDGeneratorFactory = new GUIDGeneratorFactory();
    }
    return theGUIDGeneratorFactory;
  }

  /**
   * Creates an instance of the <code>IGUIDGenerator</code> interface.
   * 
   * @return The instance created.
   */
  public IGUIDGenerator createGUIDGenerator()
  {
    return new GUIDGenerator();
  }

  /**
   * Creates an instance of the <code>IGUIDGenerator</code> interface
   * with the specified properties.
   * 
   * @param props configuration properties
   * 
   * @return The instance created.
   */
  public IGUIDGenerator createGUIDGenerator(java.util.Properties props)
  {
    return new GUIDGenerator(props);
  }  
}
