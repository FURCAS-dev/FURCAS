package com.sap.trex.client;

import java.io.IOException;

public class Request implements Serializable {

  public void clear() 
  {
  }
  
  public void read(InputStream theSource) throws IOException, TrexException 
  {
    throw new TrexException(Error.TDBC_WRITE_ONLY,"Request");
  }

  public void write(OutputStream theDestination) throws IOException, TrexException 
  {
  }

}
