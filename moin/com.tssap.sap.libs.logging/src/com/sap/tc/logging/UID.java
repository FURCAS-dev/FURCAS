/**
  * UID.java
  */

package com.sap.tc.logging;

import java.net.InetAddress;

/**
 * The UID class
 */
public class UID 
{
	//$JL-CONSOLE_LOG$ $JL-EXC$ $JL-SYS_OUT_ERR$
   
    /** thread id */
    private final short threadID;

    /** thread counter */
    private final int threadCounter;

    /** correlator ID */    
    private final long correlatorID;
    
    /** node address */
    private final long nodeAddress;
    
    /** process id */
    private final int processID;
    
    /** ieee802 network node address */
    private static long nodeaddress;

    /** os process id */
    private static int pid;

    /** unique thread id */
    private static short sThreadID = 0;

    /** thread local counter for thread id */
    private static ThreadLocal sThreadLocal = new ThreadLocal();
   
    /** half-byte -> hex char mapping */
    private static final char[] hexDigits =
    {
      '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
    };
    
    public static final long EMPTY_CORRELATOR_ID = -1;

		// getting the mac address or using the fallback mechanism
    //static PerfTimes perf = null;
		  
		  
    /** static initializer */
    static {
         
	   // set the nodeaddress 
	   // if the perflib is the search path then this a real mac adress
	   nodeaddress = getnodeaddress();
	  
      // set the process id
      // for the startup framework this is the real process id. 
      pid = getCurrentProcessID();
      
    }

      
    /**
     * Constructs a new UID based on the following algorithm.
     *   - 6 bytes nodeaddress
     *   - 2 bytes thread id
     *   - 4 bytes thread counter
     *   - 4 bytes os pid
     *   - 16 bytes time stamp (with microseconds resolution)
     */
    public UID () {
    	this(EMPTY_CORRELATOR_ID);      
    }
    
    public UID (long correlatorId) {
    	nodeAddress    = nodeaddress;
        processID      = pid;
        
        ThreadLocalInfo info = getThreadLocalInfo();      
        threadID		= info.getTID();
        threadCounter	= info.incThreadCounter();        
        correlatorID	= correlatorId;        
    }

    private UID ( long node, int pid, short tid, int tidcount, long correlatorId ) {
          
      nodeAddress   = node;
      processID     = pid;
      threadID      = tid;
      threadCounter = tidcount;
      correlatorID	= correlatorId;
    }
   
    /**
     * Returns the hex string representation of this UID. There are
     * no dashes in this representation.
     *
     * @return String the hex string representation of UID
     */
    @Override
    public String toString() {

      /* 6 bytes nodeAddress     */
      /* 2 bytes thread id       */
      /* 4 bytes thread counter  */                  
      /* 4 bytes processID       */
      /* 16 bytes time stamp     */

		char[] buf = new char[32]; //correlation ID is not going to be part of GUID anymore
                  
//		final int n1 = (int)correlatorID;
//		buf[47] = hexDigits[n1 & 0x0F];
//		buf[46] = hexDigits[(n1 >>> 4) & 0x0F];
//		buf[45] = hexDigits[(n1 >>> 8) & 0x0F];
//		buf[44] = hexDigits[(n1 >>> 12) & 0x0F];
//		buf[43] = hexDigits[(n1 >>> 16) & 0x0F];
//		buf[42] = hexDigits[(n1 >>> 20) & 0x0F];
//		buf[41] = hexDigits[(n1 >>> 24) & 0x0F];
//		buf[40] = hexDigits[(n1 >>> 28) & 0x0F];
//
//		final int n2 = (int)(correlatorID >>> 32);
//		buf[39] = hexDigits[n2 & 0x0F];
//		buf[38] = hexDigits[(n2 >>> 4) & 0x0F];
//		buf[37] = hexDigits[(n2 >>> 8) & 0x0F];
//		buf[36] = hexDigits[(n2 >>> 12) & 0x0F];
//		buf[35] = hexDigits[(n2 >>> 16) & 0x0F];
//		buf[34] = hexDigits[(n2 >>> 20) & 0x0F];
//		buf[33] = hexDigits[(n2 >>> 24) & 0x0F];
//		buf[32] = hexDigits[(n2 >>> 28) & 0x0F];

		final int n3 = processID;
		buf[31] = hexDigits[n3 & 0x0F];
		buf[30] = hexDigits[(n3 >>> 4) & 0x0F];
		buf[29] = hexDigits[(n3 >>> 8) & 0x0F];
		buf[28] = hexDigits[(n3 >>> 12) & 0x0F];
		buf[27] = hexDigits[(n3 >>> 16) & 0x0F];
		buf[26] = hexDigits[(n3 >>> 20) & 0x0F];
		buf[25] = hexDigits[(n3 >>> 24) & 0x0F];
		buf[24] = hexDigits[(n3 >>> 28) & 0x0F];

		final int n4 = threadCounter;
		buf[23] = hexDigits[n4 & 0x0F];
		buf[22] = hexDigits[(n4 >>> 4) & 0x0F];
		buf[21] = hexDigits[(n4 >>> 8) & 0x0F];
		buf[20] = hexDigits[(n4 >>> 12) & 0x0F];
		buf[19] = hexDigits[(n4 >>> 16) & 0x0F];
		buf[18] = hexDigits[(n4 >>> 20) & 0x0F];
		buf[17] = hexDigits[(n4 >>> 24) & 0x0F];
		buf[16] = hexDigits[(n4 >>> 28) & 0x0F];

      final short n5 = threadID;
		buf[15] = hexDigits[n5 & 0x0F];
		buf[14] = hexDigits[(n5 >>> 4) & 0x0F];
		buf[13] = hexDigits[(n5 >>> 8) & 0x0F];
		buf[12] = hexDigits[(n5 >>> 12) & 0x0F];

		final int n6 = (int)nodeAddress;
		buf[11] = hexDigits[n6 & 0x0F];
		buf[10] = hexDigits[(n6 >>> 4) & 0x0F];
		buf[ 9] = hexDigits[(n6 >>> 8) & 0x0F];
		buf[ 8] = hexDigits[(n6 >>> 12) & 0x0F];
		buf[ 7] = hexDigits[(n6 >>> 16) & 0x0F];
		buf[ 6] = hexDigits[(n6 >>> 20) & 0x0F];
		buf[ 5] = hexDigits[(n6 >>> 24) & 0x0F];
		buf[ 4] = hexDigits[(n6 >>> 28) & 0x0F];

		final int n7 = (int)(nodeAddress >>> 32);
		buf[ 3] = hexDigits[n7 & 0x0F];
		buf[ 2] = hexDigits[(n7 >>> 4) & 0x0F];
		buf[ 1] = hexDigits[(n7 >>> 8) & 0x0F];
		buf[ 0] = hexDigits[(n7 >>> 12) & 0x0F];

		return new String(buf);
    }

   public static final UID parseUID ( String uid )
      throws NumberFormatException
   {
      if (uid == null || uid.length() != 48) {
        throw new NumberFormatException("Invalid uid :"+ uid);
    }
         
      long node = Long.parseLong(uid.substring(0, 12), 16);
      short tid = (short)Long.parseLong(uid.substring(12, 16), 16);

      int tidcount = (int)Long.parseLong(uid.substring(16, 24), 16);
            
      int pid = (int)Long.parseLong(uid.substring(24, 32), 16);
      
      long correlatorId = (Long.parseLong(uid.substring(32, 40), 16) << 32) |
                  Long.parseLong(uid.substring(40, 48), 16);
      
      return new UID(node,pid, tid, tidcount, correlatorId);
   }

   public static final long getCorrelatorID ( String uid ) {
	   try{		   
		   return parseUID(uid).getCorrelatorID();
	   }
	   catch(Exception e){
		   return EMPTY_CORRELATOR_ID;
	   }
   }

   
    /**
     * Returns the node address. 6 bytes MAC or ip as fallback.
     */
    public long getNodeAddress() {
      return nodeAddress;
    }

    /**
     * Returns the process id.
     */
    public int getProcessID() {
      return processID;
    }

    /**
     * Returns the thread id.
     */
    public short getThreadID() {
      return threadID;
    }

    /**
     * Returns the thread id.
     */
    public int getThreadCounter() {
      return threadCounter;
    }
   
    /**
     * Returns the time stamp with us resolution
     */
    public long getTimeStamp () {
      return -1;
    }
    
    /**
     * Returns the time stamp with us resolution
     */
    public long getCorrelatorID () {
      return correlatorID;
    }

   /*
    * do some tests with the UID class
    */
   public static void main ( String args[] )
   {				
      try
      {
         UID uid1 = new UID();
         Thread.sleep(50);
         UID uid2 = new UID();
         
         String uidStr1 = uid1.toString();
         String uidStr2 = uid2.toString();
         
         UID uid = parseUID(uidStr1);
         System.out.println(uidStr1);
         System.out.println("Node:      " + uid.getNodeAddress());
         System.out.println("PID:       " + uid.getProcessID());
         System.out.println("TID:       " + uid.getThreadID());
         System.out.println("TID count: " + uid.getThreadCounter());
         System.out.println("correlatorID: " + uid.getCorrelatorID());
   
         uid = parseUID(uidStr2);
         System.out.println(uidStr2);
         System.out.println("Node:      " + uid.getNodeAddress());
         System.out.println("PID:       " + uid.getProcessID());
         System.out.println("TID:       " + uid.getThreadID());
         System.out.println("TID count: " + uid.getThreadCounter());
         System.out.println("correlatorID: " + uid.getCorrelatorID());
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }
   
    /**
     * Returns the current operating system process idendtifier. 
     */
   private static int getCurrentProcessID ()
   {
      int result = 0;
    
    	String pidStr = System.getProperty("jstartup.ownProcessId");
      if (pidStr != null){
         try {
            result = (int)Long.parseLong(pidStr);
         }
         catch (Exception ex) {
            // ignore
         }
      }
      if (result == 0) {
         result = new Object().hashCode();
      }
      return result;      
   }

    /**
     * Returns the node address. Java cannot access this address
     * (this gets called only once upon loading so no 
     *  optimization is necessary)
     */
    private static long getnodeaddress() {
    	
    	//System.out.println(System.getProperties());
		// getting the mac address or using the fallback mechanism
//		try {
//		  perf = new PerfTimes();
//		  String nodestr = perf.getMacAddress();
//		  
//	      if (nodestr != null && nodestr.length() == 12) {
//	      	long value = Long.parseLong(nodestr, 16);
//	      	return value;
//		  } 
//		}
//		catch (Throwable th) {
//			// ignore, use fallback
//			//th.printStackTrace();
//		}
    	
		// look into the properties
		try {
	    	String nodestr = System.getProperty("ieee802.address");
		    if (nodestr != null && nodestr.length() == 17) {
				long value = Long.parseLong(nodestr.substring(0, 2), 16)<<40 |
					Long.parseLong(nodestr.substring(3, 5), 16)<<32 |
					Long.parseLong(nodestr.substring(6, 8), 16)<<24 |
					Long.parseLong(nodestr.substring(9, 11), 16)<<16 |
					Long.parseLong(nodestr.substring(12, 14), 16)<<8 |
					Long.parseLong(nodestr.substring(15, 17), 16);
			    return value;
	    	}
		}
		catch (Exception e) {
		}

		// fall back on the IP address
		// uses the 32-bit inetaddress 
		try {
		    byte[] ipaddr = InetAddress.getLocalHost().getAddress();		   
		   	return (0xc00000000000L |
		   		    (long)(0xff&ipaddr[0]) << 24 |
			   	    (long)(0xff&ipaddr[1]) << 16 |
			   	    (long)(0xff&ipaddr[2]) << 8 |
		    	    (0xff&ipaddr[3]));
		}
		catch (Exception e) {
		}
		
		// no valid IEEE 802 network address nor IP address is available
		// use the current time as random number
		return System.currentTimeMillis();
    }

   private static final ThreadLocalInfo getThreadLocalInfo ()
   {
      ThreadLocalInfo ti  = (ThreadLocalInfo)sThreadLocal.get();

      if (ti == null)
      {
         short tid;
         synchronized (sThreadLocal)
         {
            tid = sThreadID++;
         }
         ti = new ThreadLocalInfo(tid);
         sThreadLocal.set(ti);
      }
      return ti;
   }


   final static class ThreadLocalInfo
   {
      private short 
         tid;
         
      private int 
         threadCounter = 0;
         
      ThreadLocalInfo ( short value )
      {
         tid = value;
      }
   
      private final short getTID ()
      {
         return tid;
      }
   
      private final int incThreadCounter ()
      {
         return threadCounter++;
      }

      private final int getThreadCounter ()
      {
         return threadCounter;
      }
   }

  
   
}
	