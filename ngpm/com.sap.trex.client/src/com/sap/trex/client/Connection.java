package com.sap.trex.client;

public class Connection {

  private ConnectionImpl itsConnectionImpl;
    
  public Connection(String theUrl)  {
    itsConnectionImpl = ConnectionPool.get(theUrl);
  }
    
  protected Channel getChannel(String theMethod) throws TrexException, Exception {
    return itsConnectionImpl.getChannel(theMethod);
  }
  
  public String getUrl() {
    return itsConnectionImpl.getUrl();
  }
    
}
