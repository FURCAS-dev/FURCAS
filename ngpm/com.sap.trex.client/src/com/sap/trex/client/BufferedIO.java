package com.sap.trex.client;

public class BufferedIO {
  public static final byte TyVague = 0;
  public static final byte TyBool = 1;
  public static final byte TyChar = 2;
  public static final byte TyShort = 3;
  public static final byte TyUShort = 4;
  public static final byte TyInt = 5;
  public static final byte TyUInt = 6;
  public static final byte TyLLong = 7;  
  public static final byte TyDouble = 8;
  public static final byte TyString = 9;
  public static final byte TyStream = 10;
  public static final byte TyULLong = 11;
  public static final byte TyFloat = 13;
  public static final byte TyEOF = 23;
  public static final byte TyBOF = 73;
  public static final byte TyNull = 14;
  public static final byte SizeMask = -64; //0xC0
  public static final byte TypeMask = ~SizeMask;
  public static final byte Milli = -128; //0x80;
  public static final byte Micro = 64;   //0x40;
  public static final byte Nano  = -64;  //0xC0;
  
  public static final int REQUESTTAG_UNDEFINED     = 0;
  public static final int REQUESTTAG_CANCEL        = -1;
  public static final int REQUESTTAG_EXECUTE       = -2;
  public static final int REQUESTTAG_EXECUTEQUERY  = -3;
  public static final int REQUESTTAG_APPENDSTRING  = -5;
  public static final int RESULTTAG_RESULTEND      = 0;
  public static final int RESULTTAG_RESULTCOUNT    = 1;
  public static final int RESULTTAG_RESULTSET      = 2;  
  
  public BufferedIO() {
  }
  
  
  public static final int SOCKET_IDLE   = 0;
  public static final int SOCKET_WRITE1 = 1;
  public static final int SOCKET_WRITEN = 2;
  public static final int SOCKET_READ   = 3;
  public static final int SOCKET_ERROR  = 4;
 
  static String getTypeName(int type) {
    switch(type) {
      case 0: return "Vague";
      case 1: return "Bool";
      case 2: return "Char";
      case 3: return "Short";
      case 4: return "UShort";
      case 5: return "Int";
      case 6: return "UInt";
      case 7: return "LLong";
      case 8: return "Double";
      case 9: return "String";
      case 10: return "Stream";
      case 23: return "EOF";
      case 72: return "BOF";
      case 14: return "NULL";
      
    }
    return "Unknown";
  }
  
}
