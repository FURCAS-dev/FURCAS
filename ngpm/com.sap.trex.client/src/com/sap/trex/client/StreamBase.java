package com.sap.trex.client;

import java.io.IOException;

public interface StreamBase {
  
  public  void    writeType(byte theType) throws IOException, TrexException;  
  public  void    writeBytes(byte[] theBuffer, int theLength) throws IOException, TrexException;

  public  byte    peekType() throws IOException, TrexException;
  public  byte    readType(byte theType) throws IOException, TrexException;
  public  void    readBytes(byte[] theBuf, int theLength) throws IOException, TrexException;    

  public  void    addRef();
  public  void    releaseRef();
}
