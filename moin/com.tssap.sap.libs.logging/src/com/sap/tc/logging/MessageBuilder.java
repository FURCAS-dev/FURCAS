package com.sap.tc.logging;

/*
 *  Copyright:   Copyright (c) 2003
 *
 *  Company:     SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @author 			 Robert Boban
 */

import java.util.Arrays;
import java.io.UnsupportedEncodingException;
import com.sap.tc.logging.interfaces.IBaseLog;
import com.sap.tc.logging.interfaces.IMessageBuilder;
import com.sap.tc.logging.interfaces.IMessageDelimiterBuilder;
import com.sap.tc.logging.exceptions.UnsupportedFormatException;

public class MessageBuilder implements IMessageBuilder {
	
	//================================================ declaration > ====
 
	private static final int DEFAULT_MESSAGE_SIZE 					= 32768;
	private static final int DEFAULT_MESSAGE_SIZE_OPTIMIZER = 100;
	
	private byte[] 				message;
	private byte[] 				messageEmpty;
	
	private String				messageEncoding;
	private int						messageSize;
	private int						messageSizeOptimizer;
	private int						messageBuildDirection 						= DIRECTION_NONE;
	private long					messageBookMarkBOL								= -1;
	private long					messageBookMarkEOL								= -1;
	private boolean				messageStartCheckExists;

	private boolean 			messageStartIsOk;
	private boolean 			messageEndIsOk;
	
	private Formatter 								formatter;
	private IMessageDelimiterBuilder 	messageDelimiter;
	
	//==== < declaration ============================ constructors > ====
	
	private MessageBuilder() {
	}
	
	protected MessageBuilder(Formatter formatter, IMessageDelimiterBuilder delimiter) 
	{
		if (formatter == null) throw new IllegalArgumentException("Missing Formatter instance!");
		
		// Ugly trick to mask SQLTraceXMLFormatter problem {
		if (formatter.getClass().getName().equalsIgnoreCase("com.sap.sql.trace.SQLTraceXMLFormatter")) {
			this.formatter = LoggingManager.DEFAULT_FORMATTER;
		}
		else {
			this.formatter = formatter;
		}
		
		if (delimiter == null) {
			messageDelimiter = new MessageDelimiterBuilder((byte)0,0);
		}
		else {
			this.messageDelimiter	= delimiter;
		}
	
		this.messageDelimiter.setParent(this);
		
		this.message 									= new byte[DEFAULT_MESSAGE_SIZE];
		this.messageEmpty 						= new byte[DEFAULT_MESSAGE_SIZE];
		this.messageStartCheckExists 	= delimiter.isDelimited();
	}
	
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
	
	// Insert chunk on the Begininng Of The Message
	public void savePreviousLine(byte[] chunk, int size) 
	{
		if (messageBuildDirection == DIRECTION_NONE) messageBuildDirection = DIRECTION_PREVIOUS;
		checkMessageSize(size);
		// Make a space for the new chunk
		System.arraycopy(message, 0, message, size, messageSize);
		// Fill the new chunk
		System.arraycopy(chunk, 0, message, 0, size);
		messageSize += size;
	}
	
	// Insert chunk on the End Of The Message
	public void saveNextLine(byte[] chunk, int size) 
	{
		if (messageBuildDirection == DIRECTION_NONE) messageBuildDirection = DIRECTION_NEXT;
		checkMessageSize(size);
		System.arraycopy(chunk, 0, message, messageSize, size);
		messageSize += size;
	}
	
	public byte[] message()
	{
		// Guardian
		if (messageSize <= 0) return new byte[0];
		
		byte [] tmpMessage = new byte[messageSize];
		
		System.arraycopy(message, 0, tmpMessage, 0, messageSize);
		
		return tmpMessage;
	}	
	
	public int size() 
	{
		return messageSize;
	}
	
	public void reset() 
	{
		if (messageSize > 0) {
			if (messageSize > messageEmpty.length) {
				this.message = new byte[DEFAULT_MESSAGE_SIZE];
			}
			else {
				System.arraycopy(messageEmpty, 0 , message, 0 , messageSize);
			}
		}
		messageSize						= 0;
		messageBuildDirection = DIRECTION_NONE;
		messageBookMarkBOL 		= -1;
		messageBookMarkEOL 		= -1;
		messageStartIsOk							= false;
		messageEndIsOk								= false;
		messageDelimiter.reset();
	}
	 
	public IMessageDelimiterBuilder getDelimiter() {
		return messageDelimiter;
	}
	
	public byte[] getFieldByte(int index) {
		
		int	 startPos = 0;
		int	 endPos 	= 0;
		byte[] result = null;
		
		// Guardian
		if (messageDelimiter.size() == 0) return new byte[0];
		
		startPos = messageDelimiter.getDelimiterPos(index);
		endPos 	 = messageDelimiter.getDelimiterPos(index + 1);
		
		// Guardian
		if (startPos == 0 || endPos == 0) return new byte[0];
		
		int size = (endPos - startPos) - 1;
		
		// Guardian
		if (size < 0) return new byte[0];
		
		result = new byte[size];
		
		System.arraycopy(message, startPos, result, 0, size);
		
		return result;
	}
	
	public String getFieldString(int index) {
		String result = null;
		if (messageEncoding != null) {
			try {
				result = new String(getFieldByte(index), messageEncoding);
			}
			catch (Exception ex) {
				result = new String(getFieldByte(index));
			}
		}
		else {
			result = new String(getFieldByte(index));
		}
		return result;
	}
	
	public int getFieldInt(int index) {
		return parseInt(getFieldString(index));
	}
	
	public boolean isComplete(int direction) throws UnsupportedFormatException {
		switch (direction) {
			case DIRECTION_NEXT:
				if (!isStartOk() && messageDelimiter.isDelimited()) {
					throw new UnsupportedFormatException("Unsupported message start format!");
				}
				break;
			case DIRECTION_PREVIOUS:
			case DIRECTION_NONE:
		}
		return isCompleteInt();
	}

	public void setBookMarkBOL(long value) {
		// Save the real first BOL mark
		if (messageBuildDirection == DIRECTION_NEXT && messageBookMarkBOL >= 0) return;
		this.messageBookMarkBOL = value;
	}
	
	public long getBookMarkBOL() {
		return messageBookMarkBOL;
	}
	
	public void setBookMarkEOL(long value) {
		// Save the real first EOL mark
		if (messageBuildDirection == DIRECTION_PREVIOUS && messageBookMarkEOL >= 0) return;
		this.messageBookMarkEOL = value;
	}
	
	public long getBookMarkEOL() {
		return messageBookMarkEOL;
	}
	
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	public void setEncoding(String charsetName){
		if (charsetName == null || charsetName.length() == 0) return; // Guardian
		this.messageEncoding = charsetName;
	}
	
	public String getEncoding(){
		return messageEncoding;
	}
	
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
	
	private String getMessageStart() throws UnsupportedFormatException {
		if (messageEncoding != null) {
			try {
				return new String(message, 1 , 3, messageEncoding);
			}
			catch (UnsupportedEncodingException ex) {
				throw new UnsupportedFormatException("Unsupported encoding!");
			}
		}
		else {
			return new String(message, 1 , 3);
		}
	}
	
	private boolean isCompleteInt() throws UnsupportedFormatException {
		if (messageDelimiter.isDelimited()) {
			return isStartOk() && isEndOk() && messageDelimiter.isComplete();
		}
		else {
			if (messageEncoding != null) {
				try {
					return formatter.isCompleteMessage(new String(message(), messageEncoding));
				}
				catch (UnsupportedEncodingException ex) {
					throw new UnsupportedFormatException("Unsupported encoding!");
				}
			}
			else {
				return formatter.isCompleteMessage(new String(message()));
			}
		}
	}
	
	private boolean isStartOk() throws UnsupportedFormatException {
		//if (isStartOk) return isStartOk; // Guardian 
		if (messageDelimiter.isDelimited()) {
			messageStartIsOk =  (Version.getVersionIndex(getMessageStart()) !=	Version.VER_CODE_UNKNOWN);
		}
		else {
			messageStartIsOk = formatter.isStartMessage(getMessageStart());
		}
		return messageStartIsOk;
	}
	
	private boolean isEndOk() throws UnsupportedFormatException {
		if (messageEndIsOk) return messageEndIsOk; // Guardian
		if (messageSize > 0 && message[messageSize - 1] == '\n') { 
			if (messageSize > 1 && message[messageSize - 2] == '\r') { // WINDOWS
				// Ignore all \n \r from the end
				int msgSize = findLastCharacter(messageSize, message);
				messageEndIsOk =  ((msgSize > 3 && message[msgSize - 1] != '\\') && (msgSize > 4 && message[msgSize] == '#')); // END OF THE RECORD
			}
			else { // UNIX
				// Ignore all \n from the end
				int msgSize = findLastCharacter(messageSize, message);
				messageEndIsOk = ((msgSize > 2 && message[msgSize - 1] != '\\') && (msgSize > 1 && message[msgSize] == '#')); // END OF THE RECORD
			}
		}
		return messageEndIsOk;
	}
	
	private void checkMessageSize(int size) 
	{
		if (message.length < (messageSize + size)) {
			// Extend message array for very large messages
			byte[] tmpMessage = new byte[(messageSize + size) + 100];
			System.arraycopy(message, 0, tmpMessage, 0, messageSize);
			message = tmpMessage;
		}
		else if (messageSizeOptimizer > DEFAULT_MESSAGE_SIZE_OPTIMIZER 
					&& (messageSize + size) < DEFAULT_MESSAGE_SIZE_OPTIMIZER) {
			// Compress message array to default size
			byte[] tmpMessage = new byte[DEFAULT_MESSAGE_SIZE];
			System.arraycopy(message, 0, tmpMessage, 0, messageSize);
			message = tmpMessage;
		}
	}
	
	private int findLastCharacter(int messageSize, byte[] message) {
		
		for (int i = messageSize - 1; i >= 0; i--) {
			if ((message[i] != '\n') && (message[i] != '\r')) return i;
		}
		return 0;
	}
	
	private int parseInt(String value) {
		
		int i = 0;

		for(i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				break;  
			}
		}
		
		if (i > 0) {
			return Integer.parseInt(value.substring(0, i));
		}
		return 0;
	}
	
  //==== < private ================================== deprecated > ====	
	
}
