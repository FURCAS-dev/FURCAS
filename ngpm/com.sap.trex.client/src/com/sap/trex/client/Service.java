package com.sap.trex.client;

import java.io.IOException;
import java.net.UnknownHostException;
import com.sap.trex.client.TrexException;


public class Service {


  private Connection  itsConnection;
  private String      itsLocation;
  private Channel     itsChannel;

  public enum ServiceType {
    Client,
    IndexServer,
    QueueServer,
    Preprocessor,
    NameServer,
    HttpServer,
    RfcServer,
    Cruiser,
    Daemon
}
  
  public Service(Connection theCon) 
  {
    itsConnection = theCon;
  }
 
  protected boolean call(String theMethod, Request theIn, Result theOut)  throws Exception
  {
    try {
      itsChannel = itsConnection.getChannel(theMethod);
    } catch (TrexException e) {
      Error anError = new Error(e);
      theOut.setError(anError);
      return false;
    }
    
    try {
      theIn.write(itsChannel.output());
      itsChannel.writeEOF();    
      if (itsChannel.readEOF())
        throw new TrexException(Error.TDBC_EMPTY_RESPONSE,theMethod);
      theOut.getError().read(itsChannel.input());
      if (theOut.getError().getCode()!=0 && itsChannel.readEOF()) // stop reading, else out.read() might overwrite the error with a protocol mismatch exception
        theOut.clear(); // does not clear the error
      else
        theOut.read(itsChannel.input());     
      itsChannel.releaseRef();
      if (theOut.getError().getCode() == 0)
        return true;
      else
        return false;
    } 
    catch (IOException ex)
    {
      itsChannel.releaseRef();
      theOut.clear();
      theOut.setError(new Error(Error.TDBC_IOEXCEPTION, ex.getMessage()));
      return false;
    }
    catch (TrexException ex)
    {
      itsChannel.releaseRef();
      theOut.clear();
      theOut.setError(new Error(ex));
      return false;
    } 
    catch (Exception ex)
    {
      itsChannel.releaseRef();
      theOut.clear();
      theOut.setError(new Error(Error.TREX_SAPRC_UNKNOWN_EXCEPTION, ex.getMessage()));
      throw ex;
    }
  }
}
