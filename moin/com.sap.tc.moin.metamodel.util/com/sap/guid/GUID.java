/**
  * GUID.java
  */

package com.sap.guid;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.Random;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import com.sap.bc.krn.perf.*;
import com.sap.exception.standard.*;
import java.util.MissingResourceException;

import com.sap.exception.util.*;

/**
 * The <code>GUID</code> class
 * <p>
 * This implements the <code>GUID</code> generation algorithms described in
 * the IETF draft:  draft-leach-uuids-guids-00.txt.
 * <p>
 * It supports the following three <code>GUID</code> generation algorithms:
 * <ul>
 * <li> time-based<br>
 *     It uses a combination of the IEEE 802 network address, timestamp,
 *     and small random number.<br>
 *     usage:
 *     <p><blockquote><pre>
 *            new GUID();
 *            new GUID(GUID.VERSION_TIME);
 *     </pre></blockquote>
 * <li> name-based<br>
 *     It uses the <code>MD5</code> message digest for the specified string. 
 *     Two identical strings will be guaranteed to result in the identical
 *     <code>GUID</code>.<br>
 *     usage:
 *     <p><blockquote><pre>
 *            new GUID("mailto:akiy@sap.com");
 *            new GUID("http://www.sap.com/");
 *     </pre></blockquote>
 * 	   <p>derived name-based<br>
 *     <p> Creates a derived name based GUID by appending the given
 *         <code>variantDescriptor</code> to the original GUID and
 *         then applying MD5 to convert it back to GUID format.
 * 	   <blockquote><pre>
 *     createGUID(myGUID, "@@@@@@@");
 *     createGUID(myGUID, "@EN@OIL@@@@@");
 *     createGUID(myGUID, "@FR@PHARMA@000@@@@@@");
 *     </pre></blockquote> 
 *
 * <li> random-based<br>
 *     It uses a large random number.<br>
 *     usage:
 *     <p><blockquote><pre>
 *            new GUID(GUID.VERSION_RANDOM);
 *     </pre></blockquote>
 *<p>
 * Note: For the time-based algorithm, the physical network address should
 * be made visible to the JVM. A native library is used for delivering
 * the mac address. Currently, not all operating systems are supported, so a
 * fallback mechanism is provided.
 * If the mac address cannot be determined by the native code,
 * the system property with name <code>ieee802.address</code> is read.
 * Either use the following method to set this property appropriately:
 * <p><blockquote><pre>
 * System.setProperty("ieee802.address", "00-01-03-87-CE-D0");
 * </pre></blockquote><p>
 * or use the java runtime parameter option:
 * <p><blockquote><pre>
 * java -Dieee802.address=00-01-03-87-CE-D0 ...
 * </pre></blockquote><p>
 * where <code>00-01-03-87-CE-D0</code> (this string can also be represented 
 * as <code>00.01.03.87.CE.D0</code>) is your physical network address.
 * <p>
 * If this property is not set or its value is invalid,
 * the time based algorithm (<code>VERSION_TIME</code>) uses its fallback
 * feature to simulate this value. The feature uses a combination of
 * the IP address and a random number associated with the virtual machine. 
 * If the IP address is not available, a random number is instead used to
 * represent this value.
 * 
 * <p>
 * In addition to the GUID generation algorithms described above, a new 
 * GUID object can be constructed from a byte array of length 16 representing
 * a GUID value in bytes.
 * <p><blockquote><pre>
 *            new GUID(g);
 * </pre></blockquote> where g is of type byte[] with length 16.
 * <p>
 * The following describes the representation of GUID
 * <strong>Layout</strong>
 * <p><blockquote><pre>
 * higher 8 bytes
 *    0 1 2 3 4 5 6 7
 * 0xffffffff00000000 time_low
 * 0x00000000ffff0000 time_mid
 * 0x000000000000f000 version
 * 0x0000000000000fff time_high
 * <br>
 * lower 8 bytes
 *    0 1 2 3 4 5 6 7
 * 0xc000000000000000 variant
 * 0x3fff000000000000 clock_seq
 * 0x0000ffffffffffff node
 * </pre></blockquote><p>
 * <strong>Lexical representation</strong>
 * <p><blockquote><pre>
 *    higher 8 bytes     lower 8 bytes
 *  0 1 2 3  4 5  6 7  0 1  2 3 4 5 6 7
 * xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
 * </pre></blockquote><p>
 * <strong>Version values</strong>
 * <p><blockquote><pre>
 * time-based   001
 * reserved dce 010
 * name-based   011
 * random-based 100
 * </pre></blockquote><p>
 * <strong>Variant values</strong>
 * <p><blockquote><pre>
 * 10x
 * </pre></blockquote><p>
 * <strong>Timestamp values</strong>
 * <p><blockquote><pre>
 * 60-bit 100-nanosecond units since 1582-10-15T00:00:00
 * </pre></blockquote><p>
 * <strong>Node address</strong>
 * <p><blockquote><pre>
 * 48-bit network hardware address
 * </pre></blockquote><p>
 *
 * The time-based algorithm fills time_low, time_mid, and time_high 
 * with the 60-bit timestamp, clock_seq with a random number, and node 
 * with the physical network address. The name-based algorithm fills time_low,
 * time_mid, time_high, clock_seq, and node with the MD5 signature of the
 * specified string. The random-based algorithm fills time_low, time_mid,
 * time_high, clock_seq, and node with the random number, where the
 * multicast-bit of the node must be set.
 *
 */
public class GUID implements Serializable, IGUID, Comparable {

	/** serial version identifier */	
    private static final long serialVersionUID = 42L;

    /** lower 8 bytes */
    private long replow;

    /** higher 8 bytes */
    private long rephigh;

    /** ieee802 network node address */
    private static long nodeaddress;

    /** last time of generation */
    private static long ltime = System.currentTimeMillis();

    /** number of generatation within millisecond */
    private static short lcount;
	
    /** secure random number generator */
    private static Random rand = new SecureRandom();

	/** real mac address available */
	private static boolean IsHardwareMACAvail=false;

	/** real mac address available */
	private static boolean IsNativeLibraryAvail=true;

	/** perf lib exception */
	private static Throwable PerfLibException;

    /** number of bytes */
    public static final int NUMBYTES = 16;

    /** version number NIL */
    public static final int VERSION_NIL = 0;

    /** version number for the time based algorithm */
    public static final int VERSION_TIME = 1;

    /** version number for the name-based algorithm */
    public static final int VERSION_NAME = 3;

    /** version number for the random-based algorithm */
    public static final int VERSION_RANDOM = 4;

    /** half-byte -> hex char mapping */
    private static final char[] hexDigits =
    {
      '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };

    /** static initializer */
    static {

	  // set the nodeaddress
	  nodeaddress = getnodeaddress();
	  // set seed value
	  rand.setSeed(System.currentTimeMillis()^(new Object()).hashCode());
    }

    /**
     * Constructs a new GUID by the time based algorithm.
     */
    public GUID(Properties props) {
        // GUID time based
        genguidbytime(props);
    }

    /**
     * Constructs a new GUID by the time based algorithm.
     */
    public GUID() {
        // GUID time based
        genguidbytime(null);
    }

    /**
     * Constructs a new GUID by the name based algorithm.
     * 
     * @param value String string value to be used by the 
     *         name-based algorithm
     */
    public GUID(String value) {
    	// GUID name based
    	genguidbyname(value);
    }

    /**
     * Constructs a new GUID using the specified algorithm version.
     * The value for the version identifier can be 1 or 4, represented by
     * VERSION_TIME or VERSION_RANDOM, respectively.
     *
     * @param version int version identifier
     * @exception GUIDVersionException if the version is invalid
     */
    public GUID(int version) throws GUIDVersionException {
        switch (version) {
        case VERSION_NIL:
            break;
        case VERSION_TIME:
            genguidbytime(null);
            break;
        case VERSION_RANDOM:
            genguidbyrandom();
            break;
        default:
            throw new GUIDVersionException();
        }
    }


    /**
     * Constructs a new GUID using the specified algorithm version.
     * The value for the version identifier can be 1 or 4, represented by
     * VERSION_TIME or VERSION_RANDOM, respectively.
     *
     * @param version int version identifier
     * @exception GUIDVersionException if the version is invalid
     */
    public GUID(Properties props, int version) throws GUIDVersionException {
        switch (version) {
        case VERSION_NIL:
            break;
        case VERSION_TIME:
            genguidbytime(props);
            break;
        case VERSION_RANDOM:
            genguidbyrandom();
            break;
        default:
            throw new GUIDVersionException();
        }
    }

    /**
     * Constructs a new GUID from the specified byte array.
     *
     * @param g the byte array to be used
     * @exception  GUIDFormatException  if the format is invalid
     */
    public GUID(byte[] g) throws GUIDFormatException {
		if (g.length < 16) throw new GUIDFormatException();
		try {
	    	replow = ((((long)((g[15] & 0xff) |
			       ((g[14] & 0xff) << 8) |
			       ((g[13] & 0xff) << 16) |
			       ((g[12] & 0xff) << 24))) & 0xffffffffL) |
		      ((long)((g[11] & 0xff) |
			      ((g[10] & 0xff) << 8) |
			      ((g[9] & 0xff) << 16) |
			      ((g[8] & 0xff) << 24))) << 32);
	    
		    rephigh = ((((long)((g[7] & 0xff) |
				((g[6] & 0xff) << 8) |
				((g[5] & 0xff) << 16) |
				((g[4] & 0xff) << 24))) & 0xffffffffL) |
		       ((long)((g[3] & 0xFF) |
			       ((g[2] & 0xFF) << 8) |
			       ((g[1] & 0xFF) << 16) |
			       ((g[0] & 0xFF) << 24))) << 32);
		}
		catch (Exception e) {
		    throw new GUIDFormatException();
		}
    }

	/**
	 * 
	 */
	public GUID(GUID originalGUID, byte[] variantDescriptor) {
		int len = variantDescriptor.length;
		byte[] buffer = new byte[16 + len];
		System.arraycopy(originalGUID.toBytes(), 0, buffer, 0, 16);
		System.arraycopy(variantDescriptor, 0, buffer, 16, len);
		genguidbyname(buffer);
	}

    /**
     * Returns the string representation of this GUID.
     *
     * @return String the string representation of GUID
     */
    public String toString() {
		char[] buf = new char[36];

		// use final so that it doesn't need to be loaded fresh every time
		final int n1 = (int)replow;
		buf[35] = hexDigits[n1 & 0x0F];
		buf[34] = hexDigits[(n1 >>> 4) & 0x0F];
		buf[33] = hexDigits[(n1 >>> 8) & 0x0F];
		buf[32] = hexDigits[(n1 >>> 12) & 0x0F];
		buf[31] = hexDigits[(n1 >>> 16) & 0x0F];
		buf[30] = hexDigits[(n1 >>> 20) & 0x0F];
		buf[29] = hexDigits[(n1 >>> 24) & 0x0F];
		buf[28] = hexDigits[(n1 >>> 28) & 0x0F];

		final int n2 = (int)(replow >>> 32);
		buf[27] = hexDigits[n2 & 0x0F];
		buf[26] = hexDigits[(n2 >>> 4) & 0x0F];
		buf[25] = hexDigits[(n2 >>> 8) & 0x0F];
		buf[24] = hexDigits[(n2 >>> 12) & 0x0F];
		buf[23] = '-';
		buf[22] = hexDigits[(n2 >>> 16) & 0x0F];
		buf[21] = hexDigits[(n2 >>> 20) & 0x0F];
		buf[20] = hexDigits[(n2 >>> 24) & 0x0F];
		buf[19] = hexDigits[(n2 >>> 28) & 0x0F];
		buf[18] = '-';

		final int n3 = (int)rephigh;
		buf[17] = hexDigits[n3 & 0x0F];
		buf[16] = hexDigits[(n3 >>> 4) & 0x0F];
		buf[15] = hexDigits[(n3 >>> 8) & 0x0F];
		buf[14] = hexDigits[(n3 >>> 12) & 0x0F];
		buf[13] = '-';
		buf[12] = hexDigits[(n3 >>> 16) & 0x0F];
		buf[11] = hexDigits[(n3 >>> 20) & 0x0F];
		buf[10] = hexDigits[(n3 >>> 24) & 0x0F];
		buf[9] = hexDigits[(n3 >>> 28) & 0x0F];
		buf[8] = '-';

		final int n4 = (int)(rephigh >>> 32);
		buf[7] = hexDigits[n4 & 0x0F];
		buf[6] = hexDigits[(n4 >>> 4) & 0x0F];
		buf[5] = hexDigits[(n4 >>> 8) & 0x0F];
		buf[4] = hexDigits[(n4 >>> 12) & 0x0F];
		buf[3] = hexDigits[(n4 >>> 16) & 0x0F];
		buf[2] = hexDigits[(n4 >>> 20) & 0x0F];
		buf[1] = hexDigits[(n4 >>> 24) & 0x0F];
		buf[0] = hexDigits[(n4 >>> 28) & 0x0F];	

		return new String(buf);
    }

    /**
     * Returns the hex string representation of this GUID. There are
     * no dashes in this representation.
     *
     * @return String the hex string representation of GUID
     */
    public String toHexString() {
		char[] buf = new char[32];

		// use final so that it doesn't need to be loaded fresh every time
		final int n1 = (int)replow;
		buf[31] = hexDigits[n1 & 0x0F];
		buf[30] = hexDigits[(n1 >>> 4) & 0x0F];
		buf[29] = hexDigits[(n1 >>> 8) & 0x0F];
		buf[28] = hexDigits[(n1 >>> 12) & 0x0F];
		buf[27] = hexDigits[(n1 >>> 16) & 0x0F];
		buf[26] = hexDigits[(n1 >>> 20) & 0x0F];
		buf[25] = hexDigits[(n1 >>> 24) & 0x0F];
		buf[24] = hexDigits[(n1 >>> 28) & 0x0F];

		final int n2 = (int)(replow >>> 32);
		buf[23] = hexDigits[n2 & 0x0F];
		buf[22] = hexDigits[(n2 >>> 4) & 0x0F];
		buf[21] = hexDigits[(n2 >>> 8) & 0x0F];
		buf[20] = hexDigits[(n2 >>> 12) & 0x0F];
		buf[19] = hexDigits[(n2 >>> 16) & 0x0F];
		buf[18] = hexDigits[(n2 >>> 20) & 0x0F];
		buf[17] = hexDigits[(n2 >>> 24) & 0x0F];
		buf[16] = hexDigits[(n2 >>> 28) & 0x0F];

		final int n3 = (int)rephigh;
		buf[15] = hexDigits[n3 & 0x0F];
		buf[14] = hexDigits[(n3 >>> 4) & 0x0F];
		buf[13] = hexDigits[(n3 >>> 8) & 0x0F];
		buf[12] = hexDigits[(n3 >>> 12) & 0x0F];
		buf[11] = hexDigits[(n3 >>> 16) & 0x0F];
		buf[10] = hexDigits[(n3 >>> 20) & 0x0F];
		buf[9] = hexDigits[(n3 >>> 24) & 0x0F];
		buf[8] = hexDigits[(n3 >>> 28) & 0x0F];

		final int n4 = (int)(rephigh >>> 32);
		buf[7] = hexDigits[n4 & 0x0F];
		buf[6] = hexDigits[(n4 >>> 4) & 0x0F];
		buf[5] = hexDigits[(n4 >>> 8) & 0x0F];
		buf[4] = hexDigits[(n4 >>> 12) & 0x0F];
		buf[3] = hexDigits[(n4 >>> 16) & 0x0F];
		buf[2] = hexDigits[(n4 >>> 20) & 0x0F];
		buf[1] = hexDigits[(n4 >>> 24) & 0x0F];
		buf[0] = hexDigits[(n4 >>> 28) & 0x0F];
	
		return new String(buf);
    }

    /**
     * Returns the byte array representation of this GUID.
     *
     * @return byte[] the byte array representation of GUID
     */
    public byte[] toBytes() {
		byte[] b = new byte[16];

		// use final so that it doesn't need to be loaded fresh every time
		final int n1 = (int)replow;
		b[15] = (byte) n1; 
		b[14] = (byte)(n1 >>> 8);
		b[13] = (byte)(n1 >>> 16);
		b[12] = (byte)(n1 >>> 24);

		final int n2 = (int)(replow >>> 32);
		b[11] = (byte) n2;
		b[10] = (byte)(n2 >>> 8);
		b[9] = (byte)(n2 >>> 16);
		b[8] = (byte)(n2 >>> 24);

		final int n3 = (int)rephigh;
		b[7] = (byte) n3;
		b[6] = (byte)(n3 >>> 8);
		b[5] = (byte)(n3 >>> 16);
		b[4] = (byte)(n3 >>> 24);

		final int n4 = (int)(rephigh >>> 32);
		b[3] = (byte) n4;
		b[2] = (byte)(n4 >>> 8);
		b[1] = (byte)(n4 >>> 16);
		b[0] = (byte)(n4 >>> 24);

		return b;
    }
    /**
     * @deprecated this is only used in a deprecated method.
     */
    private static int byteToInt(byte b) { 
    	return (b < 0) ? (256+(int)b) : (int)b; 
    }

    /**
     *  Returns GUID from the raw byte array representation. The byte 
     *  array must  be 16 bytes long.
     *
     * @deprecated use GUID(byte[] g).
     * @return the GUID represented by this byte array
     */
    public static GUID fromBytes(byte[] b) throws GUIDFormatException {
        if (b.length != 16) throw new GUIDFormatException();

        try {
            return new GUID(b);
        } catch (Exception e) {
            throw new GUIDFormatException();
        }
    }

    /**
     * Returns true if the specified GUID equals to this GUID.
     *
     * @param guid GUID to be compared with
     * @return boolean true if they are equal; otherwise false
     */
    public boolean equals(GUID guid) {
		if (guid == null) return false;
		else if (this == guid) return true;
		else return (this.rephigh == guid.rephigh) && 
					 (this.replow == guid.replow);
    }

    /**
     * Returns true if the specified object is equal to this GUID.
     *
     * @param obj Object the object to be compared
     * @return boolean true if they are equal; otherwise false
     */
    public boolean equals(Object obj) {
        return (obj instanceof GUID) && this.equals( (GUID)obj );
    }

    /**
     * Returns a hashcode for this GUID object.
     *
     * @return int the hashcode of this object
     */
    public int hashCode() {
		return (int)(rephigh ^ (rephigh >> 32) ^ replow ^ (replow >> 32));
    }

    /**
     * Returns the version of this GUID. The currently supported
     * versions are 1, 3, and 4, represented by the constants
     * VERSION_TIME, VERSION_NAME, and VERSION_RANDOM, respectively.
     *
     * @return int the version of this GUID generation.
     */
    public int getVersion() {
		return (((int)rephigh)>>>12)&0x0f;
    }

    /**
     * Returns the variant of this GUID. This GUID implementation
     * supports only variant 2.
     *
     * @return int the variant of this GUID generation.
     */
    public int getVariant() {
		return (int)2;
    }

    /**
     * Returns true if the GUID is Nil (all 128 bits are set to zero)
     *
     * @return boolean true if this GUID is Nil; Otherwise false.
     */
    public boolean isNil() {
		return (rephigh == 0L && replow == 0L);
    }

	/**
	 * Updates the property settings.
	 */
	private void updateProperties(Properties update) {
		
	}

    /**
     * Generates a new GUID using the time based algorithm
     * 
     * @param props configuration properties
     */
    private void genguidbytime(Properties props) {
    	String forceNativeLibraryStr=null, forceMACAddressStr=null;
    	
    	if (props != null) {
    		forceNativeLibraryStr = props.getProperty("forceNativeLibrary");
	    	forceMACAddressStr = props.getProperty("forceMACAddress");
    	}

		boolean forceNativeLibrary = (forceNativeLibraryStr != null && (
			forceNativeLibraryStr.equalsIgnoreCase("no") ||
			forceNativeLibraryStr.equalsIgnoreCase("false"))) ? false : true;
										
		boolean forceMACAddress = (forceMACAddressStr != null && (
          	forceMACAddressStr.equalsIgnoreCase("yes") || 
	       	forceMACAddressStr.equalsIgnoreCase("true"))) ? true : false;

		if ( (forceNativeLibrary && ! IsNativeLibraryAvail) ||
		     (forceMACAddress && ! IsHardwareMACAvail) )

    	      	throw new SAPMissingResourceException(
    	      		SAPMissingResourceException.MISSING_RESOURCE,
	              	new Object[] { GUID.class.getName(), 
	              		"ieee802.address" }, PerfLibException);
    	
		long ts = gettimestamp();
		rephigh = (VERSION_TIME<<12 | // version
		   (ts&0xffffffffL)<<32 | // time_low
		   (ts&0xffff00000000L)>>16 | // time_mid
		   (ts&0xfff000000000000L)>>48); // time_high
		replow = (0x80L<<56 | // variant
		  ((long)rand.nextInt(0x4fff))<<48 | // clock_seq
		  nodeaddress); // node
    }

    /**
     * Generates a new GUID using the name based algorithm
     */
    private void genguidbyname(String value) {
		try {
		    genguidbyname(value.getBytes("UTF-8"));
		} catch(UnsupportedEncodingException e) {
		    // cannot happen; UTF-8 is always part of java
		}
    }

	/**
	 * Generates a new GUID using the name based algorithm
	 * starting from a byte array.
	 */
	private void genguidbyname(byte[] value) {
		try {
		    MessageDigest md5 = MessageDigest.getInstance("MD5");
		    byte digest[] = md5.digest(value);

		    rephigh = ((((long)(((0xff&digest[0]) << 24) |
				((0xff&digest[1]) << 16) |
				((0xff&digest[2]) << 8) |
				(0xff&digest[3]))) << 32) |
		       (((long)(((0xff&digest[4]) << 24) |
				((0xff&digest[5]) << 16) |
				((0xff&digest[6]) << 8) |
				(0xff&digest[7]))) & 0xffffffffL));

		    replow = ((((long)(((0xff&digest[8]) << 24) |
			       ((0xff&digest[9]) << 16) |
			       ((0xff&digest[10]) << 8) |
			       (0xff&digest[11]))) << 32) |
		      (((long)(((0xff&digest[12]) << 24) |
			       ((0xff&digest[13]) << 16) |
			       ((0xff&digest[14]) << 8) |
			       (0xff&digest[15]))) & 0xffffffffL));

		    replow &= 0x3fffffffffffffffL;
		    replow |= 0x8000000000000000L;

		    rephigh &= 0xffffffffffff0fffL;
		    rephigh |= VERSION_NAME<<12; // version

		} catch(NoSuchAlgorithmException e) {
	    	// cannot happen; MD5 is always part of java.security
		}
	}

    /**
     * Generates a new GUID using the random number based algorithm
     */
    private void genguidbyrandom() {
		rephigh = (VERSION_RANDOM<<12 | // version
		   rand.nextLong()&0xffffffffffff0fffL); // time - version
		replow = (rand.nextLong()&0x3fffffffffffffffL | // clock_seq + node
		  0x0000800000000000L); // multicast bit of node
    }

    /**
     * Returns the node address. Java cannot access this address
     * (this gets called only once upon loading so no 
     *  optimization is necessary)
     */
    private static long getnodeaddress() {
    	
		// getting the mac address or using the fallback mechanism
		try {
		  PerfTimes perf = new PerfTimes();
		  String nodestr = perf.getMacAddress();
		  
	      if (nodestr != null && nodestr.length() == 12) {
	      	long value = Long.parseLong(nodestr, 16);
	      	IsHardwareMACAvail = true;
	      	return value;
		  } 
		}
		catch (UnsatisfiedLinkError e) {
			IsNativeLibraryAvail = false;
			PerfLibException = e;
		}
		catch (Exception e) {  
			PerfLibException = e;
		}	
    	
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
			    IsHardwareMACAvail = true;
			    return value;
	    	}
		}
		catch (Exception e) {
		}

		// fall back on the IP address
		// uses the 32-bit inetaddress plus a 26-bit random number
		// sets the multicast bit and the following bit
		try {
		    byte[] ipaddr = InetAddress.getLocalHost().getAddress();		   
		   	return (0xc00000000000L |
			        (long)rand.nextInt(0x3fff) << 32 |
		   		    (long)(0xff&ipaddr[0]) << 24 |
			   	    (long)(0xff&ipaddr[1]) << 16 |
			   	    (long)(0xff&ipaddr[2]) << 8 |
		    	    (long)(0xff&ipaddr[3]));
		}
		catch (Exception e) {
		}
		
		// no valid IEEE 802 network address nor IP address is available
		// uses a 46-bit random number
		// sets the multicast bit and unsets the following bit
		return (0x800000000000L | (rand.nextLong()&0x3fffffffffffL));
    }

    /**
     * Returns the timestamp. 
     *
     * @return long the current timestamp
     */
    private synchronized static long gettimestamp() {
		long t;
		
		for (;;) {
			t = System.currentTimeMillis();
			if (t != ltime) {
		    	ltime = t;
			    lcount = 0;
			    break;
			}
			else {
				if (lcount >= 9999) {
					try {
						Thread.sleep(1);	
					} catch (InterruptedException e) {
					}
					continue;
				}
				++lcount;	
				break;	
			}
		}
		
		return ((t+12219292800000L)*10000L+lcount)&0x0fffffffffffffffL;
    }

    /**
     * Returns the current timestamp of this GUID.
     * 
     * If this GUID has version=VERSION_TIME this method returns the 
     * timestamp of the GUID. Otherwise it returns 0.
     *
     * This only returns the timestamp component of this GUID as
     * converted into the number of milliseconds since 1970-01-01T00:00:00.
     * Therefore, it differs from the actual timestamp value in this GUID.
     * 
     * @return current timestamp
     */
    public long getTimestamp() {
        if(this.getVersion() != VERSION_TIME) { return 0; }

        long t = ((rephigh >> 32) & 0x00000000ffffffffL) | // time_low
                 ((rephigh << 16) & 0x0000ffff00000000L) | // time_mid
                 ((rephigh << 48) & 0x0fff000000000000L);  // time_high

        return (t/10000L)-12219292800000L;
    }

    /** for debugging only... */
    public int getClockSeq() {
        return (int)( (replow & 0x3fff000000000000L) >> 48);
    }

    /**
     * Parses the string argument as a GUID string.
     *
     * @param guid String the string representation (as specfied in the GUID IETF Draft) of GUID
     * @return GUID a GUID that corresponds to the specified value
     * @exception  GUIDFormatException  if the format is invalid
     */
    public static GUID parseGUID(String guid) throws GUIDFormatException {
		if (guid.length() != 36) throw new GUIDFormatException();
		try {
		    GUID g = new GUID(VERSION_NIL);
	   		 g.rephigh = (Long.parseLong(guid.substring(0,8), 16)<<32 |
				 Long.parseLong(guid.substring(9,13), 16)<<16 |
			 	 Long.parseLong(guid.substring(14,18), 16));
	 	     g.replow = (Long.parseLong(guid.substring(19,23), 16)<<48 |
				 Long.parseLong(guid.substring(24,36), 16));
				 
		     return g;
		}
		catch (Exception e) {
		    throw new GUIDFormatException();
		}
    }

    /**
     * Parses the string argument as a GUID string.
     *
     * @param guid String the string representation of GUID (string without '-')
     * @return GUID a GUID that corresponds to the specified value
     * @exception  GUIDFormatException  if the format is invalid
     */
    public static GUID parseHexGUID(String guid) throws GUIDFormatException {
		if (guid.length() != 32) throw new GUIDFormatException();
		try {
		    GUID g = new GUID(VERSION_NIL);
		   	g.rephigh = (Long.parseLong(guid.substring(0,8), 16)<<32 |
				 Long.parseLong(guid.substring(8,16), 16));
	   		g.replow = (Long.parseLong(guid.substring(16,24), 16)<<32 |
				Long.parseLong(guid.substring(24,32), 16));
		    return g;
		}
		catch (Exception e) {
		    throw new GUIDFormatException();
		}
    }

	/**
	 * Compares two long values which can exceed the range.
	 */
	private int compareLong(long a, long b) {		
		if (a >= 0 && b >= 0) {
			if (a > b) return 1;
			if (a < b) return -1;
			return 0;	
		}
		if (a < 0 && b < 0) {
			if (a > b) return -1;
			if (a < b) return 1;
			return 0;	
		}
		if (a < 0 && b >=0) return 1;
		
		return -1;
	}

	/**
	 * Compares this GUID with the specified one.
	 * 
	 * @param otherGUID object of comparison
	 */
	public int compareTo(Object otherGUID) {
		if (otherGUID == null) {
			throw new SAPIllegalArgumentException(
				SAPIllegalArgumentException.PARAMETER_NULL,
				new Object[] { "otherGUID" } );	
		}	
		if (! (otherGUID instanceof GUID ||
		        otherGUID instanceof byte[]) ) {
		    throw new SAPIllegalArgumentException(
		    	SAPIllegalArgumentException.PARAMETER_WRONG_TYPE,
		    	new Object[] { "otherGUID", otherGUID.getClass().getName()
		    		} );
		}
		GUID other = null;
		if (otherGUID instanceof byte[]) {
			try {
				other = new GUID( (byte[]) otherGUID);	
			}	
			catch (Exception e) {
				throw new SAPIllegalArgumentException(
					SAPIllegalArgumentException.PARAMETER_MALFORMED,
					new Object[] { "otherGUID", "byte[]" }, e);
			}
		}
		else {
			other = (GUID) otherGUID;	
		}
		
		if (compareLong(this.rephigh, other.rephigh) < 0) return -1;
		if (compareLong(this.rephigh, other.rephigh) > 0) return 1;
		if (compareLong(this.replow, other.replow) < 0) return -1;
		if (compareLong(this.replow, other.replow) > 0) return 1;
		
		return 0;
	}

}
	