package com.sap.trex.client;

import java.io.IOException;

public class  InputStream {
  
  private StreamBase itsBase;
  
  public InputStream(StreamBase itsBase)
  {
    this.itsBase = itsBase;
  }
  
  public StreamBase getBase() {
    return itsBase;
  }
    
  public long readIntegral(int theLen) throws IOException, TrexException {
      
      byte[] aBuffer = new byte[theLen];
      itsBase.readBytes(aBuffer, theLen);
      long aValue = 0;
      for (int i = theLen - 1; i >= 0; i--) {
          aValue <<= 8;
          aValue += aBuffer[i] >= 0 ? (aBuffer[i]) : (256 + aBuffer[i]);
      }
      return aValue;
  }
  
  public String readString() throws IOException, TrexException {
      itsBase.readType(BufferedIO.TyString);
      int len = (int) readIntegral(4);
      byte[] aBuffer = new byte [len];
      itsBase.readBytes(aBuffer, len);
      return  new String(aBuffer, "UTF8");
  }
  
  public byte[] readBinary() throws IOException, TrexException {
      itsBase.readType(BufferedIO.TyString);
      int len = (int) readIntegral(4);
      byte[] aBuffer = new byte[len];
      itsBase.readBytes(aBuffer, len);
      return aBuffer;
  }
   
  public char readUchar() throws IOException, TrexException  {
      itsBase.readType(BufferedIO.TyChar);
      return (char) readIntegral(1);
  }
  
  public short readShort() throws IOException, TrexException {
      itsBase.readType(BufferedIO.TyShort);
      return (short) readIntegral(2);
  }

  public int readUshort() throws IOException,TrexException {
      itsBase.readType(BufferedIO.TyUShort);
      return (int) readIntegral(2);
  }
  
  public int readInt() throws IOException, TrexException {
      itsBase.readType(BufferedIO.TyInt);
      return (int) readIntegral(4);
  }
  
  public long readUint() throws IOException, TrexException  {
      itsBase.readType(BufferedIO.TyUInt);
      return (long) readIntegral(4);
  }
  
  public long readLlong() throws IOException, TrexException {
      itsBase.readType(BufferedIO.TyLLong);
      return (long) readIntegral(8);
  }
  
  public double readDouble() throws IOException,TrexException {
      itsBase.readType(BufferedIO.TyDouble);
      long aValue = (long) readIntegral(8);
      return Double.longBitsToDouble(aValue);
  }
  
  public float readFloat() throws IOException, TrexException {
    itsBase.readType(BufferedIO.TyFloat);
    long aValue = (long) readIntegral(4);
    return Float.intBitsToFloat(new Long(aValue).intValue());
  }
  public Integer readInteger() throws IOException, TrexException {
      int i = readInt();
      return new Integer(i);
  }
  
  public int readEnum() throws IOException, TrexException {
   int i = readInt();
   return i;
  }
  
  public int readBitMask() throws IOException, TrexException
  {
    int i = readInt();
    return i;
  }
  
  public Boolean readBoolean() throws IOException, TrexException {
    itsBase.readType(BufferedIO.TyBool);
    byte[] aBuffer = new byte [1];
    itsBase.readBytes(aBuffer, 1);
    if (aBuffer[0] != 0)
      return new Boolean(true);
    else
      return new Boolean(false);    
  }
  
  public Long readLong() throws IOException, TrexException {
      long i = readLlong();
      return new Long(i);
  }
  
  public int readVectorSize() throws IOException, TrexException {
    long i = readUint();
    return new Long(i).intValue();
  }
  
  public void readNull() throws IOException, TrexException {
    itsBase.readType(BufferedIO.TyNull);
  }
 
  
  public void addRef()
  {
    itsBase.addRef();
  }
  
  public void releaseRef()
  {
    itsBase.releaseRef();
  }

  public int peekType() throws IOException, TrexException
  {
    return itsBase.peekType();
  }
   
    
  private int byteArrayToInt(byte[] b) {
    int value = 0;
    for (int i = b.length - 1; i >= 0; i--) {
      value <<= 8;
      value += b[i];
    }
    return value;
  }

    
  public void ignoreOne() throws  IOException, TrexException   {
    byte  aType,aSize;
    aType = itsBase.peekType(); // use separate peekType+readType, else ignoreOne has to set itsState
    if (aType == BufferedIO.TyEOF) {
      itsBase.readType(aType);
    } else if(aType == BufferedIO.TyNull) {
      itsBase.readType(aType);
    } else if(aType == BufferedIO.TyBool) {
      itsBase.readType(aType);
      itsBase.readBytes(null,1);
    } else if(aType == BufferedIO.TyFloat) {
      itsBase.readType(aType);
      itsBase.readBytes(null,4);
    } else if(aType == BufferedIO.TyDouble) {
      itsBase.readType(aType);
      itsBase.readBytes(null,8);
    } else if(aType == BufferedIO.TyShort || aType == BufferedIO.TyUShort) {
      aSize=itsBase.readType(aType);
      if (aSize == BufferedIO.Milli) 
        itsBase.readBytes(null,1);
      else
        itsBase.readBytes(null,2);
    } else if(aType == BufferedIO.TyInt || aType == BufferedIO.TyUInt) {
      aSize=itsBase.readType(aType);
      if     (aSize == BufferedIO.Micro) 
        itsBase.readBytes(null,1);
      else if(aSize == BufferedIO.Milli) 
        itsBase.readBytes(null,2);
      else
        itsBase.readBytes(null,4);
      } else if(aType == BufferedIO.TyLLong || aType == BufferedIO.TyULLong) {
        aSize=itsBase.readType(aType);
        if (aSize == BufferedIO.Nano)  
          itsBase.readBytes(null,1);
        else if(aSize == BufferedIO.Micro) 
          itsBase.readBytes(null,2);
        else if(aSize == BufferedIO.Milli) 
          itsBase.readBytes(null,4);
        else                             
          itsBase.readBytes(null,8);
      } else if(aType == BufferedIO.TyString) {
        aSize=itsBase.readType(aType);
        int len;
        if (aSize == BufferedIO.Nano) { 
          len = 0;
        } else if(aSize == BufferedIO.Micro) {
          byte[] alen = new byte[1]; 
          itsBase.readBytes(alen, 1); 
          len = byteArrayToInt(alen);
        } else if(aSize == BufferedIO.Milli) { 
          byte[] alen = new byte[2]; 
          itsBase.readBytes(alen,2); 
          len = byteArrayToInt(alen);
        } else {
          byte[] alen = new byte[4];
          itsBase.readBytes(alen,4);              
          len = byteArrayToInt(alen);
        }
        itsBase.readBytes(null,len);
      } else {
        itsBase.readType(BufferedIO.TyVague); // force exception
      }
  }


}
