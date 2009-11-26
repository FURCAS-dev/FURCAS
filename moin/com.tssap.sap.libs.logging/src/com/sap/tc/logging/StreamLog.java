package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id: //sapmarkets/Logging/630_SP_COR/src/_Logging/java/com/sap/tc/logging/StreamLog.java#8 $
 */

import java.lang.*;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Writes log records to output streams.
 */
public class StreamLog extends Log {

	//================================================ declaration > ====
	
	private static String subLoc = "Log";
	
	private OutputStream       stream;
	private OutputStreamWriter out;
	private String             enc; 
	
	//==== < declaration ============================ constructors > ====
	
	protected StreamLog() {
		this((String) null, new ListFormatter());
  }

  protected StreamLog(Formatter formatter) {
		this((String) null, formatter);
  }

	protected StreamLog(String    enc,
						  				Formatter formatter) {
		super(formatter);
		
		if (enc == null) enc = "UTF8";
		this.enc 		= enc;
		this.stream = null;
		this.out 		= null;
	}
  
  
  /**
	 * Configures this stream log for writing to an output stream.
	 * @param  stream Output stream
	 * @see    #StreamLog(java.io.OutputStream,
	 *                    java.lang.String)
	 */
	public StreamLog(OutputStream stream) {
	  this(stream, new ListFormatter());
	}

	/**
	 * Same as
	 * {@link #StreamLog(java.io.OutputStream)}
	 * but configures for writing with a custom formatter.
	 * @param  stream    Output stream
	 * @param  formatter Formatter
	 * @see    #StreamLog(java.io.OutputStream,
	 *                    java.lang.String,
	 *                    Formatter)
	 */
	public StreamLog(OutputStream 	stream,
					 				 Formatter    	formatter) {
		
		super(formatter);
	
		this.stream = stream;
		this.enc		= null;
	
		try {
			openInt();
		}
		catch (IOException ex) {
			APILogger
				.logIntByAPI(Severity.ERROR,
										 subLoc + "[StreamLog(...)]",
										 MSGCollection.LOGGING_MSG_ID_OPEN_EXCEPTION,
										 MSGCollection.LOGGING_MSG_STR_OPEN_EXCEPTION,
										 new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
			handleException(ex);
		}
		
	}

	/**
	 * Configures this stream log for writing to an output stream with a custom
	 * character encoding.
	 * @param  stream Output stream
	 * @param  enc    Name of character encoding
	 * @see    #StreamLog(java.io.OutputStream)
	 */
	public StreamLog(OutputStream stream,
					 				 String       enc) throws UnsupportedEncodingException {
	  this(stream, enc, new ListFormatter());
	}

	/**
	 * Same as
	 * {@link #StreamLog(java.io.OutputStream,
	 *                   java.lang.String)}
	 * but configures for writing with a custom formatter and character encoding.
	 * @param  stream    Output stream
	 * @param  enc       Name of character encoding
	 * @param  formatter Formatter
	 * @throws UnsupportedEncodingException Character encoding not supported
	 * @see    #StreamLog(java.io.OutputStream,
	 *                    Formatter)
	 */
	public StreamLog(OutputStream stream,
									 String       enc,
									 Formatter    formatter) throws UnsupportedEncodingException {
		
		super(formatter);

		this.stream = stream;
		this.enc 		= enc;
		
		try {
			openInt();
		}
		catch (IOException ex) {
			APILogger
				.logIntByAPI(Severity.PATH,
										 subLoc + "[StreamLog(...)]",
										 MSGCollection.LOGGING_MSG_ID_OPEN_EXCEPTION,
										 MSGCollection.LOGGING_MSG_STR_OPEN_EXCEPTION,
										 new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
		}
		finally {
			if (out == null && enc == null) {
				throw new UnsupportedEncodingException();
			}
		}
	}
  
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	//*******************************************************************
	// Implementation of the ILog interface
	//*******************************************************************
	
	/**
	 * Gets the canonical name of the character encoding that is used for this
	 * log.
	 * If no character encoding is set the default character encoding of the
	 * platform is used.
	 * @return Name of character encoding
	 * @see    #setEncoding(java.lang.String)
	 */ 
	public synchronized String getEncoding() {
	  return enc;
	}

	/**
	 * Sets the named character encoding to be used for this log.
	 * If no character encoding is set the default character encoding is used.
	 * Note: To use new encoding value, the Log must be first closed using
	 * the {@link #Log.close()} method, then opened with {@link #Log.open()} method. 
	 * @param  enc Name of character encoding
	 * @see    #getEncoding()
	 */
	public void setEncoding(String enc) {
		String oldValue = "",
					 newValue = "";
		try {
			synchronized (getClass()) {
				oldValue = getEncoding();
				this.enc = enc;
				closeInt();
				newValue = getEncoding();
			}
			APILogger.instrumentIntByAPI(subLoc + "[setEncoding(String enc)]", 
					 MSGCollection.CONFIGURATION_IS_CHANGED(),
					 new Object[] {"encoding", 
												 "Log",
												 this.getName(),
												 oldValue, 
												 newValue});
		}
		catch (IOException ex) {
			APILogger
				.logIntByAPI(Severity.ERROR,
										 subLoc + "[setEncoding(...)]",
										 MSGCollection.LOGGING_MSG_ID_CLOSE_EXCEPTION,
										 MSGCollection.LOGGING_MSG_STR_CLOSE_EXCEPTION,
										 new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
		}
	}
	
	//==== < public ==================================== protected > ====
  
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
  protected synchronized OutputStream getOutputStream() {
		return stream;
  }
  
  protected synchronized void writeInt(String s) throws Exception {
	  if (out != null) {
			out.write(s);
	  }
	}

	protected synchronized void flushInt() throws IOException {
	  if (out != null) {
			out.flush();
	  }
	}

	protected synchronized void openInt() throws IOException {
		if (stream != null) {
			if (enc != null) {
				try {
					out = new OutputStreamWriter(stream, enc);
				}
				catch (UnsupportedEncodingException ex) {
					APILogger
						.logIntByAPI(Severity.WARNING,
												 subLoc + "openInt()]",
												 MSGCollection.LOGGING_MSG_ID_UNSUPPORTED_ENCODING,
												 MSGCollection.LOGGING_MSG_STR_UNSUPPORTED_ENCODING,
												 new String[] {enc});
					
					handleException(ex, ExceptionManager.ERR_FORMAT);

					out = new OutputStreamWriter(stream);
					enc = out.getEncoding();
				}
			} 
			else {
				out = new OutputStreamWriter(stream);
				enc = out.getEncoding();
			}
			setStatus(STATUS_OPENED);
		} 
		else {
			out = null;
		}
	}

	protected synchronized void closeInt() throws IOException {
		flushInt();
	  if (out != null) {
			out.close();
			out = null;
	  }
	  if (stream != null) {
			stream.close();
			stream = null;
		}
		setStatus(STATUS_CLOSED);
	}
	
	//==== < protected =================================== default > ====
	
	synchronized void setOutputStream(OutputStream stream) {
		this.stream = stream;
	}
	
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
    
}