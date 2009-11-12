package com.sap.trex.client;

import java.io.IOException;

public interface Serializable { 
  public void write(OutputStream theDestination) throws IOException, TrexException;  
  public void read(InputStream theSource) throws IOException, TrexException;  
  public void clear();
}
