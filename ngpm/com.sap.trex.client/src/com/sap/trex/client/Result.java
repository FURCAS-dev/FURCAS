package com.sap.trex.client;

import java.io.IOException;

public  class Result implements Serializable {
  
  protected Error itsError;

  public Result()
  {
    itsError = new Error();
  }
  
  public Error getError()
  {
    return itsError;
  }
  
  public void setError(Error theError)
  {
    itsError = theError;
  }

  public void clear() {
    // don't clear itsError
  }

  public void read(InputStream theStream) throws IOException, TrexException {
    // itsError is read by Service::call
  }

  public void write(OutputStream theStream) throws IOException, TrexException {
    throw new TrexException(Error.TDBC_READ_ONLY,"Result");
  }

}
