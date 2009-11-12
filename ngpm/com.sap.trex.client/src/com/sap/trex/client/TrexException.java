package com.sap.trex.client;

/*
 * only used internally. converted to Error by Service.call(),...
 */

public class TrexException extends Exception {
  
  private static final long serialVersionUID = 1L;
  private int    itsCode;
  private String itsAppend;
  
  public TrexException (int theCode)
  {
    itsCode = theCode;
    itsAppend = null;
  }
      
  public TrexException(int theCode, String theAppend)
  {
    itsCode = theCode;
    itsAppend = theAppend;   
  }
  
  public int getCode() {
    return itsCode;
  }
  
  public String getAppend() {
    return itsAppend;
  }
  
}
