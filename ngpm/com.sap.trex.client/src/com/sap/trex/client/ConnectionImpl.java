package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;

public class ConnectionImpl {
  
  private String           itsUrl; 
  private boolean          itsSecure;
  private String           itsProfile = "";
  private int              itsRootIndex = 0;
  private List<String>     itsRootLocations = new ArrayList<String>();
  private String           itsSession = "";
  private int              itsSequence = 0;
  private List<Location>   itsLocations = new ArrayList<Location>();
  
  private long             itsLocationsRefreshTime;
  private long             itsChannelsIdleTime;
  private int              itsChannelsIdleInterval;
  private int              itsLocationsRefreshInterval;
  private final int        itsLocationsRefreshDefault = 300;
  private final int        itsChannelsIdleDefault = 600;
  
 
  
  
  public ConnectionImpl(String theUrl) {
    // parse the string for several url's into the locations arraylist
    // don't throw exception from constructor. instead return error when using an empty location
    itsUrl = theUrl;
    itsSecure = false;
    if(theUrl.startsWith("trex-is:")) {
      itsRootLocations.add(theUrl.substring(8));

    } else {
      int pbgn = 0;
      if (theUrl.startsWith("trex://")) {
        pbgn = 7;
      } else if (theUrl.startsWith("trexs://")) {
        pbgn = 8;
        itsSecure = true;
      }
      if(pbgn>0) {
        int pnxt;
        int pend = theUrl.indexOf('/',pbgn);
        if (pend == -1) 
          pend = theUrl.length();
        for(; pbgn<pend; pbgn=pnxt) {
          pnxt = theUrl.indexOf(',',pbgn);
          if(pnxt == -1 || pnxt > pend) 
            pnxt = pend;
          itsRootLocations.add(theUrl.substring(pbgn,pnxt));
          if(pnxt!=pend) pnxt++;
        }
        pbgn = pend+1;
        if (pbgn < theUrl.length()) {
          pend = theUrl.indexOf('?',pbgn);
          if(pend == -1) 
            pend = theUrl.length();
          itsProfile = theUrl.substring(pbgn,pend);
        }
      }
    }
    itsLocationsRefreshTime     = 0L;
    itsChannelsIdleTime         = 0L;
    itsLocationsRefreshInterval = itsLocationsRefreshDefault;
    itsChannelsIdleInterval     = itsChannelsIdleDefault;
    
  }
  
  private void getLocations() throws TrexException, Exception {
      if (itsRootLocations.size() == 0) 
          throw new TrexException (Error.TDBC_INVALID_CONNECTION_URL, itsUrl);
      for(int num=0; num<itsRootLocations.size(); num++) {
          Channel channel = null;
          try {
              int idx=itsRootIndex % itsRootLocations.size();
              // server side of this call is in TrexService/TrexClient.cpp
              channel = new Channel();
              channel.open(itsRootLocations.get(idx), itsSecure);
              channel.writeHeader(itsSession, ++itsSequence, "_getServer");
              channel.output().writeInt(4); // special protocol version for this core call
              channel.output().writeString(itsRootLocations.get(idx)); // for detection of location format (name,ip,fqdn)
              channel.output().writeString(itsProfile);
              channel.output().writeString(""); // should be changelist
              channel.writeEOF();
              Error error = new Error();
              // don't lock itsLocations while waiting for server
              error.read(channel.input());
              if(channel.readEOF())
                  throw new TrexException(error.getCode(), error.getErrorMessage());

              int t;
              t = channel.input().readInt();
              itsLocationsRefreshInterval = t;
              t = channel.input().readInt();
              itsChannelsIdleInterval = t;
              itsSession = channel.input().readString();
              
              int i,j;
              j = channel.input().readVectorSize();
              if(j > 0) {
                  itsLocations = new ArrayList<Location>(j);
                  for(i=0; i<j; i++) {
                      String tmp = channel.input().readString();
                      itsLocations.add(new Location(tmp, true));
                  }
              } else { // continue with the initial locations
                  j=itsRootLocations.size();
                  itsLocations = new ArrayList<Location>(j);
                  for(i=0; i<j; i++) {
                      itsLocations.add(new Location(itsRootLocations.get(i), true));
                  }
              }
              channel.releaseRef();
              break;
          } catch(Exception ex) {
              if(channel != null)
                  channel.releaseRef();
              itsRootIndex++;
              if(num==itsRootLocations.size()-1) {
                  itsLocationsRefreshTime = 0L;
                  throw ex;
              }
          }
      }
  }  
  

  public synchronized Channel getChannel(String theMethod) throws Exception
  {
      Channel channel = null;
      long now = System.currentTimeMillis()/1000; 
      
      for(int loop=0; channel==null && loop<2; loop++) {
          if(loop > 0 || now > itsLocationsRefreshTime + itsLocationsRefreshInterval) {
              itsLocationsRefreshTime=now;
              getLocations();
          }
          
          for(int num=0; channel==null && num<itsLocations.size(); num++) {
              // increment itsIndex without write lock -> round robin could be slightly imbalanced
              int idx=itsSequence++ % itsLocations.size(); 
              try {
                  if(itsLocations.get(idx).getFlag()) {
                      channel = new Channel();
                      channel.open(itsLocations.get(idx).getLocationName(), itsSecure);
                      channel.writeHeader(itsSession, itsSequence, theMethod);
                  }    
              } catch(IOException ex) {
                  itsLocations.get(idx).setFlag(false);
                  if(loop==1 && num == itsLocations.size()-1)
                      throw new Exception(ex);
              }
          }
      }
    
      if(channel != null)
          return channel;
      throw new TrexException(Error.TREX_SAPRC_SERVER_NOT_FOUND,itsUrl);
  }
 	public String getUrl() {
    return this.itsUrl;
  }
 
}
   class Location {
    private String itsLocation;
    private boolean itsFlag;
    
    public Location(String location, boolean flag) {
      this.itsLocation = location;
      this.itsFlag     = flag;
    }
    
    public void setLocation(String theLocation ) {
      this.itsLocation = theLocation;
    }
    
    public void setFlag (boolean theFlag) {
      this.itsFlag = theFlag;
      
  } 
    
    public String getLocationName() {
      return this.itsLocation;
    }
    
    public boolean getFlag() {
      return this.itsFlag;
    }
    
  
}
