package com.sap.trex.client;

import java.io.IOException;

public class Error implements Serializable {

  public static final int TREX_SAP_OK                     =0;
  public static final int TREX_SAPRC_VALUE_TOO_LONG       =19;
  public static final int TREX_CHANNEL_OPEN               =50;
  public static final int TREX_CHANNEL_CLOSED             =51;
  public static final int TREX_CHANNEL_WRITE              =52;
  public static final int TREX_CHANNEL_READ               =53;
  public static final int TREX_CHANNEL_TIMEOUT            =54;
  public static final int TREX_SAPRC_SERVER_NOT_FOUND     =1960;
  public static final int TREX_SAPRC_UNKNOWN_EXCEPTION    =1972;
  public static final int IMSRC_TCPIP_OBJECT_ID_MISMATCH  =2963;
  
  public static final int TDBC_EMPTY_REQUEST              =22001;
  public static final int TDBC_INVALID_CONNECTION_URL     =22004;
  public static final int TDBC_CONN_INVALID_STATE         =22005; 
  public static final int TDBC_IOEXCEPTION                =22006;
  public static final int TDBC_EMPTY_RESPONSE             =22010;
  public static final int TDBC_COLUMN_READ                =22011;  
  public static final int TDBC_READ_ONLY                  =22012;
  public static final int TDBC_WRITE_ONLY                 =22013;


  private int    itsCode;
  private String itsMsg;
  
  
  public static final String [][] messages = 
  {
    { Integer.toString(TREX_SAP_OK), "No error"},
    { Integer.toString(TREX_SAPRC_VALUE_TOO_LONG), "A received argument is too long"},
    { Integer.toString(TREX_SAPRC_UNKNOWN_EXCEPTION), "An unknown exception occured"},
    { Integer.toString(IMSRC_TCPIP_OBJECT_ID_MISMATCH), "A different object was expected" },

    { Integer.toString(TREX_CHANNEL_OPEN), "Error while opening a channel"},
    { Integer.toString(TREX_CHANNEL_CLOSED), "Channel is closed"},
    { Integer.toString(TREX_CHANNEL_WRITE), "Error while writing to channel"},
    { Integer.toString(TREX_CHANNEL_READ), "Error while reading from channel"},
    { Integer.toString(TREX_CHANNEL_TIMEOUT), "Communication timeout"},

    { Integer.toString(TDBC_EMPTY_REQUEST), "Empty request" },
    { Integer.toString(TDBC_INVALID_CONNECTION_URL), "Invalid connection url"},
    { Integer.toString(TDBC_CONN_INVALID_STATE), "Connection is in invalid state"},
    { Integer.toString(TDBC_EMPTY_RESPONSE), "Empty response from server"},
    { Integer.toString(TDBC_COLUMN_READ), "Column already read"},
    { Integer.toString(TDBC_READ_ONLY), "Read only type"},
    { Integer.toString(TDBC_WRITE_ONLY), "Write only type"},
    
   };

  

  public Error()
  {
    itsCode = 0;
    itsMsg = "";   
  }
  
  private void setMsg()
  { 
    for (int i=0; i < messages.length;i++)
      if (messages[i][0].equalsIgnoreCase(Integer.toString(itsCode))) {
        itsMsg = messages[i][1];
        return;
      }
    itsMsg="message not found";
  }
  
  public Error(int theCode)
  {
    set(theCode, null);
  }
  
  public Error(int theCode, String theAppend)
  {
    set(theCode, theAppend);
  }
  
  public Error(TrexException ex)
  {
    set(ex.getCode(), ex.getAppend());
  }

  public void set(int theCode)
  {
    set(theCode, null);
  }
    
  public void set(int theCode, String theAppend)
  {
    itsCode = theCode;
    setMsg();
    if(theAppend != null)
      itsMsg += ";"+theAppend;    
  }
  
  public void read(InputStream theStream) throws IOException, TrexException {
    itsCode = theStream.readInt();
    itsMsg  = theStream.readString();
    
  }

  public void write(OutputStream theStream) throws IOException, TrexException {
    theStream.writeInt(itsCode);
    theStream.writeString(itsMsg);
    
  }
  public void clear() {
    itsCode    = 0;
    itsMsg = "";
    
  }
  
  public int getCode()
  {
    return itsCode;
  }
  
  public String getMsg()
  {
    return itsMsg;
  }

  /*
   * for compatibility
   */
  public int getErrorCode()
  {
    return itsCode;
  }
  
  public String getErrorMessage()
  {
    return itsMsg;
  }
      

      
  

}
