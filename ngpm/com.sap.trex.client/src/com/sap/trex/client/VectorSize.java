package com.sap.trex.client;

import java.io.IOException;

public class VectorSize {
  
  private long itsVectorSize;
  
  public VectorSize(long i)
  {
    itsVectorSize=0;
  }
  
  public void clear()
  {
    itsVectorSize = 0;
  }
  public void read(InputStream theStream) throws IOException, TrexException
  {
     itsVectorSize = theStream.readUint();  
    
  }
  
  public long toLong()
  {
    return itsVectorSize;
  }
  
  public int toInt()
  {
    Long aLong = new Long(itsVectorSize);
    return aLong.intValue();
    
    
  }

  
  

}
