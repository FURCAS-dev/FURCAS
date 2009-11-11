package com.sap.trex.client;


import java.util.HashMap;
import java.util.Map;


public class ConnectionPool {
  
  private static Map<String,ConnectionImpl> itsConnections = new HashMap<String, ConnectionImpl>();

  
  public static synchronized ConnectionImpl get(String theUrl)  {
      
      {
          for (int i = 0 ; i < itsConnections.size();i++)
          {  
            if (itsConnections.containsKey(theUrl))
            {
                return itsConnections.get(theUrl);
            }
          }  
          ConnectionImpl aCon = new ConnectionImpl(theUrl);
          itsConnections.put(theUrl,aCon);
          return aCon;
      }            
  }

  public  ConnectionPool Instance () {
     
    if (itsConnections == null)
      itsConnections = new HashMap<String, ConnectionImpl>();
    return this;        
  }
  }

  

 

