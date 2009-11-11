package com.sap.trex.client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Channel implements StreamBase {
  

  private OutputStream itsOutput = null;
  private InputStream  itsInput = null; 
  private Socket       itsSocket = null;
  
  private int    itsRefCounter    = 0;
  private int    itsState      = 0;
  private int    itsReadSize   = 0;
  private int    itsBufferPos  = 0;
  private byte[] itsBuffer;
  private int    itsBufferSize = 8192;

  
  public Channel() {
  }
    
  public void open(String theLocation, boolean theSecure) throws UnknownHostException, NoSuchAlgorithmException, IOException, TrexException 
  {
    int pos = theLocation.lastIndexOf(":");
    if(pos==-1) {
      itsSocket = new Socket(theLocation,0); // will fail and produce a reasonable exception
    } else {
      String host = theLocation.substring(0,pos);
      int port = new Integer(theLocation.substring(pos+1)).intValue();
      if(theSecure) {
        SSLSocket socket = (SSLSocket)SSLSocketFactory.getDefault().createSocket(host,port);
        socket.setUseClientMode(true);
        socket.startHandshake();
        itsSocket = socket;
      } else {
        itsSocket = new Socket(host,port);
      }
    }
    itsSocket.setSoLinger(true, 30);
     
    itsBuffer  = new byte[itsBufferSize];
    itsOutput  = new OutputStream(this);
    itsInput   = new InputStream(this);
    itsRefCounter = 1;
  }  
  
  
  public void writeHeader(String theSession, int theSequence, String theMethod) throws IOException, TrexException
  {
    writeType(BufferedIO.TyBOF);
    itsOutput.writeIntegral(0x18100800, 4);
    itsOutput.writeIntegral(theMethod.getBytes().length, 4);
    //write version
    itsOutput.writeIntegral(1, 1); // major
    itsOutput.writeIntegral(2, 1); // minor
    itsOutput.writeIntegral(4, 1); // revision
    //write header length
    int size = 25 + theMethod.getBytes().length + 8 + theSession.getBytes().length;
    itsOutput.writeIntegral(size,4);               
    //write dsr flag
    itsOutput.writeIntegral(0,1);  
   //write method name
    writeBytes(theMethod.getBytes(), theMethod.getBytes().length);    
    itsOutput.writeIntegral(32,4);  // 32 = trex client
    itsOutput.writeIntegral(Version.PROTOCOLVERSION,4);    
    // revision 4:
    itsOutput.writeIntegral(theSession.getBytes().length,4);
    writeBytes(theSession.getBytes(), theSession.getBytes().length);
    itsOutput.writeIntegral(theSequence,4);
  }
  
  public OutputStream output()
  {
    return itsOutput;
  }
  
  public InputStream input()
  {
    return itsInput;
  }
 
  
  public void addRef() {
    itsRefCounter++;
  }

  public void releaseRef() {
    itsRefCounter--;
    if(itsRefCounter == 0) {
      if (itsState == BufferedIO.SOCKET_READ) {
        try {
          while (itsState==BufferedIO.SOCKET_READ)
            itsInput.ignoreOne();
        } catch (IOException ex) {
          itsState = BufferedIO.SOCKET_ERROR;
        } catch (TrexException ex) {
          itsState = BufferedIO.SOCKET_ERROR;
        }
      }
      if (itsState == BufferedIO.SOCKET_WRITE1) {
        itsState = BufferedIO.SOCKET_IDLE; // discard the non written stuff
      }
      if (itsState == BufferedIO.SOCKET_WRITEN) {
        try {
          writeEOF(); // give server a chance to recover from aborting in the middle of writing
          if (readEOF()) // must test if server has used this chance
            itsState = BufferedIO.SOCKET_IDLE;
          else
            itsState = BufferedIO.SOCKET_ERROR;
        } catch (IOException ex) {
          itsState = BufferedIO.SOCKET_ERROR;
        } catch (TrexException ex2) {
          itsState = BufferedIO.SOCKET_ERROR;
        }
      }
      try {
        itsSocket.close();
      } catch (IOException ex) {
        itsState = BufferedIO.SOCKET_ERROR;
      }
    }
  }

  public byte peekType() throws IOException {
    if (itsBufferPos == itsReadSize)
      receive();
    return (byte)(itsBuffer[itsBufferPos] & BufferedIO.TypeMask);
  }

  public byte readType(byte theType) throws IOException, TrexException {
    if(itsState != BufferedIO.SOCKET_READ)
      throw new TrexException(Error.TDBC_CONN_INVALID_STATE, "writeByte(state!=read)");
    if(itsBufferPos == itsReadSize)
        receive();
    byte b = itsBuffer[itsBufferPos++];
    byte aType = (byte)(b & BufferedIO.TypeMask);
    if(aType==BufferedIO.TyEOF)
        itsState = BufferedIO.SOCKET_IDLE;
    if(theType != aType)
        throw new TrexException(Error.IMSRC_TCPIP_OBJECT_ID_MISMATCH,
            "got "+BufferedIO.getTypeName(aType)+", expected "+BufferedIO.getTypeName(theType));
    return (byte)(b & BufferedIO.SizeMask);
  }


  public void readBytes(byte[] theBuf, int theLength) throws IOException {
    int l2 = 0;
    while (l2 < theLength) {
      if (itsBufferPos == itsReadSize)
        receive();
      
      // check, if no more data is available
      if( itsReadSize == -1 )
    	  return;
      
      int l3 = java.lang.Math.min(theLength - l2, itsReadSize - itsBufferPos);
      if (theBuf != null)
      {
        System.arraycopy(itsBuffer, itsBufferPos, theBuf, l2, l3);
        theBuf[l2] = itsBuffer[itsBufferPos];
      }
      
      l2 += l3;
      itsBufferPos += l3;
    }
  }

  public boolean readEOF() throws IOException, TrexException {
    if (itsState == BufferedIO.SOCKET_IDLE)
      return true;
    if (itsState != BufferedIO.SOCKET_READ)
      throw new TrexException(Error.TDBC_CONN_INVALID_STATE,
          "readEOF(state!=read)");
    if (itsBufferPos == itsReadSize)
      receive();
    if (itsBuffer[itsBufferPos] == BufferedIO.TyEOF) {
      itsBufferPos++;
      itsState = BufferedIO.SOCKET_IDLE;
      return true;
    }
    return false;
  }

  public void receive() throws IOException {
    itsBufferPos = 0;
    try {
      itsReadSize = itsSocket.getInputStream().read(itsBuffer, 0, itsBufferSize);
    } catch (IOException ex) {
      itsReadSize = 0;
      itsState = BufferedIO.SOCKET_ERROR;
      throw ex;
    }
  }

  
  
  public void writeType(byte theVal) throws TrexException, IOException {
    if (itsState == BufferedIO.SOCKET_IDLE) {
      itsBufferPos = 0;
      itsState = BufferedIO.SOCKET_WRITE1;
    }
    if (itsState != BufferedIO.SOCKET_WRITE1
        && itsState != BufferedIO.SOCKET_WRITEN)
      throw new TrexException(Error.TDBC_CONN_INVALID_STATE,
          "writeByte(state!=write)");
    itsBuffer[itsBufferPos++] = theVal;
    if (itsBufferPos == itsBufferSize)
      send(false);

  }


  public void writeBytes(byte[] theBuffer, int theLength) throws IOException, TrexException {
    int l2 = 0;
    while (l2 < theLength) {
      int l3 = java.lang.Math.min(theLength - l2,
          (int) (itsBufferSize - itsBufferPos));
      System.arraycopy(theBuffer, l2, itsBuffer, itsBufferPos, l3);
      l2 += l3;
      itsBufferPos += l3;
      if (itsBufferPos == itsBufferSize)
        send(false);
    }
  }

  public void writeEOF() throws IOException, TrexException
  {
    writeType(BufferedIO.TyEOF);
    send(true);
  }


  void send(boolean eof) throws TrexException, IOException {
    if (itsState != BufferedIO.SOCKET_WRITE1
        && itsState != BufferedIO.SOCKET_WRITEN)
      throw new TrexException(Error.TDBC_CONN_INVALID_STATE, this.getClass().getName()
          + "." + this.getClass());
    try {
      itsSocket.getOutputStream().write(itsBuffer, 0, itsBufferPos);
      itsState = BufferedIO.SOCKET_WRITEN;
    } catch (IOException ex) {
      itsState = BufferedIO.SOCKET_ERROR;
      throw ex;
    }
    itsBufferPos = 0;
    if (eof) {
      itsSocket.getOutputStream().flush();
      itsState = BufferedIO.SOCKET_READ;
      itsReadSize = 0;
    }
  }

  
}
