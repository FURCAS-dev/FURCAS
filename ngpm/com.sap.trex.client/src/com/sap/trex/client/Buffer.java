package com.sap.trex.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Buffer implements StreamBase, Serializable {

  
  private  ByteArrayOutputStream itsBAOS;
  private OutputStream itsOutput = null;
  
  public Buffer()
  {
    itsBAOS = new ByteArrayOutputStream();
    itsOutput  = new OutputStream(this);
  }
  
  // reference counting not used
  
  public void addRef() {
    // TODO Auto-generated method stub
  }

  public void releaseRef() {
    // TODO Auto-generated method stub
  }

  // reading not used
  
  public byte peekType() throws IOException {
    // TODO Auto-generated method stub
    return 0;
  }

  public byte readType(byte theType) throws IOException, TrexException {
    // TODO Auto-generated method stub
    return 0;
  }

  public void readBytes(byte[] theBuf, int theLength) throws IOException, TrexException {
    // TODO Auto-generated method stub
  }



  /** write 1 byte to the internal buffer */  
  public void writeType(byte theType) {
    byte[] aTmp = new byte[1];
    aTmp[0] = theType;
    try {
      itsBAOS.write(aTmp);
    } catch (IOException e) {
      // nothing can happen, as nothing is 'written' - only used as buffer object      
    }
  }

  /** write a byte array to the internal buffer */
  public void writeBytes(byte[] theBuffer, int len) {
    try {
      itsBAOS.write(theBuffer);
    } catch (IOException e) {

     //nothing can happen, as nothing is 'written' - only used as buffer object
    }     
  }
  public void clear()
  {
    itsBAOS = new ByteArrayOutputStream();
  }
  
  /** close internal buffer */
  public void close() {
   try {
     itsBAOS.close();
   } catch (IOException e) {
     //nothing can happen, as nothing is 'written' - only used as buffer object
   }  
  }

  public void read(InputStream theSource) throws IOException, TrexException {
    // TODO Auto-generated method stub
  }

  public void write(OutputStream theDestination) throws IOException, TrexException {
    theDestination.getBase().writeBytes(itsBAOS.toByteArray(), itsBAOS.toByteArray().length);
  }

  public OutputStream output()
  {
    return itsOutput;
  }
  
  public InputStream input()
  {
    return null;
  }


}
