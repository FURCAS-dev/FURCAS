package com.sap.trex.client;

public class GuidedNav
{
  
  private String itsAttribute;
  private float  itsDiscrimination;
  private int    itsInstances;
  private int    itsValues;
  
  public GuidedNav()
  {
    itsAttribute      = "";
    itsDiscrimination = 0;
    itsInstances      = 0;
    itsValues         = 0;    
  }
  
  public GuidedNav(String theAttribute, float theDiscrimination, int theInstances, int theValues)
  {
    
    itsAttribute      = theAttribute;
    itsDiscrimination = theDiscrimination;
    itsInstances      = theInstances;
    itsValues         = theValues;
    
  }
  /**
   * @return the Attribute
   */
  public String getAttribute() {
    return itsAttribute;
  }
  /**
   * @param Attribute the theAttribute to set
   */
  public void setAttribute(String theAttribute) {
    this.itsAttribute = theAttribute;
  }
  /**
   * @return the itsDiscrimination
   */
  public float getItsDiscrimination() {
    return itsDiscrimination;
  }
  /**
   * @param itsDiscrimination the theDiscrimination to set
   */
  public void setDiscrimination(float theDiscrimination) {
    this.itsDiscrimination = theDiscrimination;
  }
  /**
   * @return the Instances
   */
  public int getInstances() {
    return itsInstances;
  }
  /**
   * @param itsInstances the theInstances to set
   */
  public void setInstances(int theInstances) {
    this.itsInstances = theInstances;
  }
  /**
   * @return the itsValues
   */
  public int getValues() {
    return itsValues;
  }
  /**
   * @param itsValues the theValues to set
   */
  public void setValues(int theValues) {
    this.itsValues = theValues;
  }
}