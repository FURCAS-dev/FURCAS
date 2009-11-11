package com.sap.trex.client;

import java.io.IOException;

public class OutputStream  {
  

 protected StreamBase itsBase;
 
  
  public OutputStream(StreamBase itsBase) {
    this.itsBase = itsBase;
  }
  
  public StreamBase getBase() {
    return itsBase;
  }
  
  protected void writeIntegral(long theValue, int theBytes) throws IOException, TrexException {
    byte[] aBuffer = new byte[theBytes];
    int i;
    for (i = 0; i < theBytes; i++) {
      aBuffer[i] = (byte) (theValue & 0xFF);
      theValue >>= 8;
    }
    itsBase.writeBytes(aBuffer, theBytes);
  }
  
  public OutputStream writeString(String v) throws IOException,TrexException {    
    itsBase.writeType(BufferedIO.TyString);
    byte[] aBuffer = v.getBytes("UTF8");
    writeIntegral(aBuffer.length, 4);
    itsBase.writeBytes(aBuffer, aBuffer.length);
    return this;
  }
  
  public OutputStream writeBinary(byte[] v) throws IOException,TrexException {
    itsBase.writeType(BufferedIO.TyString);
    if(v==null) {
      writeIntegral(0, 4);
    } else {
      writeIntegral(v.length, 4);
      itsBase.writeBytes(v, v.length);
    }
    return this;
  }
  
  public OutputStream writeBoolean(boolean v) throws IOException,TrexException {
    itsBase.writeType(BufferedIO.TyBool);
    long aValue = v ? 1 : 0;
    writeIntegral(aValue, 1);
    return this;    
  }   
  
  public OutputStream writeUchar(char v) throws IOException, TrexException  {
    if (v < 0 || v > 0xFF) throw new IOException();    
    itsBase.writeType(BufferedIO.TyChar);
    writeIntegral(v, 1);
    return this;
  }
  
  public OutputStream writeShort(short v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyShort);
    writeIntegral(v, 2);
    return this;    
  }   

  public OutputStream writeUshort(int v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyUShort);
    writeIntegral(v, 2);
    return this;    
  }   

  public OutputStream writeInt(int v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyInt);
    writeIntegral(v, 4);
    return this;    
  }   
  
  public OutputStream writeBitMask(int v) throws IOException, TrexException
  {
    itsBase.writeType(BufferedIO.TyInt);
    writeIntegral(v,4);
    return this;
  }
  
  public OutputStream writeEnum(int v) throws IOException, TrexException
  {
    itsBase.writeType(BufferedIO.TyInt);
    writeIntegral(v,4);
    return this;
  }
  
  public OutputStream writeUint(long v) throws IOException, TrexException  {
    if (v < 0 || v > Integer.MAX_VALUE) throw new IOException();
    itsBase.writeType(BufferedIO.TyUInt);
    writeIntegral(v, 4);
    return this;    
  }   

  public OutputStream writeLong(long v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyLLong);
    writeIntegral(v, 8);
    return this;    
  }   

  public OutputStream writeDouble(double v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyDouble);
    long aValue = Double.doubleToLongBits(v);
    writeIntegral(aValue, 8);
    return this;    
  }   
  
  public OutputStream writeFloat(float v) throws IOException, TrexException {
    itsBase.writeType(BufferedIO.TyFloat);
    long aValue = Float.floatToIntBits(v);
    writeIntegral(aValue, 4);
    return this;
  }

  public OutputStream writeNull()  throws IOException, TrexException
  {
    writeIntegral(BufferedIO.TyNull,1);
    return this;
  }
  
  public OutputStream writeVectorSize(int v) throws IOException, TrexException {
    writeUint(v);
    return this;
  }
    
}
