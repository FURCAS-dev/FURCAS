package com.sap.tc.logging.reader;

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
 * @author			 Robert Boban	
 */

import com.sap.tc.logging.*;
import com.sap.tc.logging.interfaces.ILoggingResultSet;
import com.sap.tc.logging.interfaces.IFilter;
import com.sap.tc.logging.interfaces.IMessageBuilder;
import com.sap.tc.logging.exceptions.*;
import com.sap.tc.logging.messagedepot.MessageAccessor;

import java.io.*;
import java.text.*;

public final class FileReadLog extends ReadFileSetLog 
{
	
	//================================================ declaration > ====
	
	private static String strLoc = "FileReadLog";
	
	private int 							fileHeaderSize;
	private int 							fileFooterSize;
	private int 							latestDirection;
	
	private LocalBuffer 			buffData;
	private MessageAccessor 	msgAccessor;
	private LogEvents					logEvents;
	
	//==== < declaration ============================ constructors > ====
	
	public FileReadLog(String fileName) throws FileDataException {	
		this(fileName, null);
	}
	
	public FileReadLog(String fileName, MessageAccessor accessor) throws FileDataException {
		super(fileName);
		this.msgAccessor = accessor;
	}
	
	public FileReadLog(String fileName, int size, int limit) throws FileDataException {	
		this(fileName, null, size , limit);
	}
	
	public FileReadLog(String fileName, MessageAccessor accessor, int size, int limit) throws FileDataException{
		super(fileName, size, limit);
		if (fileName == null) throw new NullPointerException();
		this.msgAccessor = accessor;
	}
	
	/**
	 * This constructor logs all exception but 
	 * doesn't re-throw it out. 
	 * @deprecated Not suported
	 */
	public FileReadLog(FileLog fileLog){
		this(fileLog, null);
	}

	/**
	 * This constructor logs all exception but 
	 * doesn't re-throw it out. 
	 * @deprecated Not suported
	 */
	public FileReadLog(FileLog fileLog, MessageAccessor accessor) {
		super(fileLog.getPattern(), fileLog.getCnt(), fileLog.getLimit());
		if (fileLog == null) throw new NullPointerException();
		this.msgAccessor = accessor;
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public void registerForLogEvents(LogEvents logEvents) {
		this.logEvents = logEvents;
	}
	
	public boolean isBOF() throws DataException
	{
		String rbSource = getSource();
		boolean result  = true;
		
		try {
			result = isBOFInt();
			// If BOF ...
			if (result &&  isInFileSet()) {
				// Move to the previous (oldest) file in the file set ...
				previous();
				// If file is not the same and file exists
				if (!rbSource.equalsIgnoreCase(getSource()) && new File(getSource()).exists()) {
					// Close current ...
					closeInt();
					// Open new one...
					openInt();
					// Go to the EOF
					buffData.moveToEOF();
					// 
					result = isBOFInt();
				}
			}
		}
		catch (Exception ex) {
			// RollBack
			setSource(rbSource);
			throw new FileDataException(getSource(), ex);
		}
		return result;
	}
		
    public boolean isEndOfCurrentFile() throws DataException
    {
        String rbSource = getSource();        
        try {
            return isEOFInt();
        }
        catch (Exception ex) {
            // RollBack
            setSource(rbSource);
            throw new FileDataException(getSource(), ex);
        }
    }
    
    public boolean isBeginningOfCurrentFile() throws DataException
    {
        String rbSource = getSource();        
        try {
            return isBOFInt();
        }
        catch (Exception ex) {
            // RollBack
            setSource(rbSource);
            throw new FileDataException(getSource(), ex);
        }
    }
		
	public boolean isEOF() throws DataException
	{
		String rbSource = getSource();
		boolean result  = true;
		
		try {
			result = isEOFInt();
			// If EOF ...
			if (result && isInFileSet()) {
				// Move to the next (newest) file in the file set ...
				next();
				// If file is not the same and file exists
				if (!rbSource.equalsIgnoreCase(getSource()) && new File(getSource()).exists()) {
					// Close current ...
					closeInt();
					// Open new one...
					openInt();
					// 
					result = isEOFInt();
				}
			}
		}
		catch (Exception ex) {
			// RollBack
			setSource(rbSource);
			throw new FileDataException(getSource(), ex);
		}
		return result;
	}
	
	public void moveToBOF() throws DataException {
		
		String rbSource = getSource();
		
		try {
			if (isInFileSet()) {
				moveToBOFS();
				if (!rbSource.equalsIgnoreCase(getSource())) {
					closeInt();
					setSource(getSource());
					openInt();
				}
			}
		
			if (buffData != null) {
				buffData.moveToBOF();
			}
		}
		catch (Exception ex) {
			// RollBack
			setSource(rbSource);
			throw new FileDataException(getSource(), ex);
		}
	}
	
    void moveToBeginningOfCurrentFile() throws DataException {
        
        String rbSource = getSource();
        
        try {
            if (buffData != null) {
                buffData.moveToBOF();
            }
        }
        catch (Exception ex) {
            // RollBack
            setSource(rbSource);
            throw new FileDataException(getSource(), ex);
        }
    }
    
    void moveToEndOfCurrentFile() throws DataException {
        
        String rbSource = getSource();
        
        try {
            if (buffData != null) {
                buffData.moveToEOF();
            }
        }
        catch (Exception ex) {
            // RollBack
            setSource(rbSource);
            throw new FileDataException(getSource(), ex);
        }
    }    
	
	public void moveToEOF() throws DataException {
		String rbSource = getSource();
		
		try {
			if (isInFileSet()) {
				moveToEOFS();
				if (!rbSource.equalsIgnoreCase(getSource())) {
					closeInt();
					setSource(getSource());
					openInt();
				}
			}
			
			if (buffData != null) {
				buffData.moveToEOF();
			}
		}
		catch (Exception ex) {
			// RollBack
			setSource(rbSource);
			throw new FileDataException(getSource(), ex);
		}
	}
	
	/**
	 * @see com.sap.tc.logging.interfaces.IReadLog#readNext(int)
	 */
	public ILoggingResultSet readNext(int numberOfRecords) throws DataException {
		
		// Guardian...
		if (numberOfRecords < 0) numberOfRecords = 0;
		
	  LogRecordResultSet resultSet 		= new LogRecordResultSet();
		IFilter 					 fileFilter 	= getFilter(0);
		boolean						 readContinue = true;
		
	  try {
	  	
	  	openInt();

			// Guardian... don't read if there is nothing to be read
		  if (!isEOF()) {
		  	// Number of records in record set
			  for(int i = 0; i < numberOfRecords; i++) {
			 
			  	if (isEOF()) return resultSet;
			  	
			  	// Loop only live if filter is set / enabled ...
			  	do {
						// Read from file...
			  		// Get MsgByte object
			  		IMessageBuilder msgBuilder = buffData.readNext();
			  		// Get message from MsgByte
						byte [] result 	= msgBuilder.message();
						
			  		if (fileFilter != null && fileFilter.isFilterEnabled()) {
							readContinue = fileFilter.beRead(result);
			  		}
			  		if (readContinue) {
							LogRecord lr = getFormatter().parseMsg(msgBuilder);
				  		if (lr != null) {
								lr.setBookMark(msgBuilder.getBookMarkBOL());
								resultSet.add(lr);
				  		}
				  		else {
				  			// Just in case...
					  		break;
				  		}
			  		}
			  	} while (!readContinue && !isEOF());
			  }
		  }
		  else {
		  	moveToEOF();
		  }
	  }
	  catch (Exception ex) {
			throw new FileDataException(getSource(), ex);
	  }
  	return resultSet;
	}

	/**
	 * @see com.sap.tc.logging.interfaces.IReadLog#readPrevious(int)
	 */
	public ILoggingResultSet readPrevious(int numberOfRecords) throws DataException {
		
		// Guardian...
		if (numberOfRecords < 0) numberOfRecords = 0;
		
		LogRecordResultSet resultSet 		= new LogRecordResultSet();
		IFilter 					 fileFilter 	= getFilter(0);
		boolean						 readContinue = true;
		
		try {
			
			openInt();

			// Guardian... don't read if there is nothing to be read
		  if (!isBOF()) {
				// Number of records in record set
			  for(int i = 0; i < numberOfRecords; i++) {
			 
				if (isBOF()) return resultSet;
			 
				// Loop only live if filter is set / enabled ...
				do {
					// Read from file...
					// Get MsgByte object
		  		IMessageBuilder msgBuilder = buffData.readPrevious();
		  		// Get message from MsgByte
					byte [] result 	= msgBuilder.message();
		  		
					if (fileFilter != null && fileFilter.isFilterEnabled()) {
							readContinue = fileFilter.beRead(result);
					}
					if (readContinue) {
							LogRecord lr = getFormatter().parseMsg(msgBuilder);
						if (lr != null) {
							lr.setBookMark(msgBuilder.getBookMarkBOL());
							resultSet.add(lr);
						}
						else {
							// Just in case...
							break;
						}
					}
				} while (!readContinue && !isBOF());
			  }
		  }
		  else {
				moveToBOF();
			}
		}
		catch (LoggingBaseException ex) {
			resultSet.setStatus(resultSet.INVALID);
			resultSet.setException(ex);
		}
		catch (Exception ex) {
			resultSet.setStatus(resultSet.INVALID);
			resultSet.setException(new FileDataException(getSource(), ex));
		}
	  return resultSet;
	}
	
	/**
	 * Is this FileLog in FileSet Mode
	 * @deprecated Use the new isInFileSet() method
	 */
	public boolean isPartOfFileSet() {
		return isInFileSet();
	}
	
	public void seek(long filePointer) throws DataException{
		try {
			buffData.seek(filePointer);
		}
		catch (IOException ex) {
			throw new FileDataException(getSource(), ex);
		}
	}

	public long find(String condition) throws DataException
	{
		
		// Parse operater...
		int 		operaterID = 0;
		String  operater   = null;
		
		for (int i = 0; i < condition.length(); i++) {
			operater		= condition.substring(i,  i + 1);
			operaterID 	= HelperLib.parseOperator(operater);
			if (operaterID > 0 && ((i + 1) < condition.length())) {
				String multiOperater	= condition.substring(i , i + 2);
				int multiOperaterID 	= HelperLib.parseOperator(multiOperater); 
				if (multiOperaterID > 0) {
					operaterID = multiOperaterID;
					operater	 = multiOperater;
				} 
				break;
			}
		}
		
		// Guardian - No operater ...
		if (operaterID < 0) return -1;
		
		int endFieldNamePos = condition.indexOf(operater);
		
		// Guardian - support only ListFormatter 
		if (!(getFormatter() instanceof ListFormatter)) {
			return -1;
		}
		
		// Get field ...
		int			fieldIndex 	= 0;
		String 	fieldName 	= condition.substring(0, endFieldNamePos).trim();
		
		if (ListFormatter.getFields().containsKey(fieldName)) {
			fieldIndex = ((Integer) ListFormatter.getFields().get(fieldName)).intValue();
		}
		else {
			// Field doesn't exist
			return -1;
		}
		
		// Get string from condition...
		String compareStr = condition.substring(endFieldNamePos + operater.length());
		
		while (!isEOF()) {
			
			// Get next...
			IMessageBuilder msgByte = buffData.readNext();
			byte[] msgChunk = msgByte.message();
			int delimiterSize = msgByte.getDelimiter().size();
			int [] delimiter = new int[delimiterSize];
			
			msgByte.reset();
			
			if (msgChunk == null || msgChunk.length == 0) continue;
						
			// Delimiters ...
			int startFieldPos = delimiter[fieldIndex];
			int endFieldPos 	= 0;
			
			if ((fieldIndex + 1) < delimiterSize) {
				// Get next delimiter starting pos
				endFieldPos = delimiter[fieldIndex + 1] ;
			}
			// if no ... 
			if (endFieldPos == 0) endFieldPos = msgChunk.length;
		
			// calculate length between first pos and last pos
			endFieldPos = endFieldPos - startFieldPos - 1;
			
			String filedStr = new String(msgChunk, startFieldPos, endFieldPos);
		
			// Comapre ...
			if (ListFormatter.compareField(fieldIndex, operaterID, filedStr.trim(), compareStr.trim())) {
				return getBookMark();
			}
		}
		return -1;
	}

	public ILoggingResultSet search(String condition) throws DataException{
		return null;
	}

	/**
	 * @see com.sap.tc.logging.interfaces.IBaseLog#setFormatter(com.sap.tc.logging.Formatter)
	 */
	public synchronized void setFormatter(Formatter formatter) {
		super.setFormatter(formatter);
	  getFormatter().setMessageAccessor(msgAccessor);
	}

	//==== < public ==================================== protected > ====
	
	protected void openInt() throws OpenException 
	{
		if (isClosed() && buffData == null) {
			try {	
				loadDataFromFileHeader(new FileLogInfoData(getSource()));
	
				IMessageBuilder msgBuilder = getFormatter().getMessageBuilder();
				msgBuilder.setEncoding(getEncoding());
				
				buffData	= new LocalBuffer(getSource(), msgBuilder);
				
				buffData.setFileHeaderSize(fileHeaderSize);
				buffData.setFileFooterSize(fileFooterSize);
				
				// Fire event
				if (logEvents != null) logEvents.eventLogIsOpen(this);
				
				setStatus(STATUS_OPENED);
			} 
			catch (OpenException ex) {
				buffData = null;
				throw ex;
			}
			catch (Exception ex) {
				buffData = null;
				throw new FileOpenException(getSource(), ex);
			}
		}
	}
	
  protected void closeInt() throws CloseException 
  {
		if (isOpened() && buffData != null) {
	  	try {
	  		buffData.close();
				setStatus(STATUS_CLOSED);
				
				// Fire event
				if (logEvents != null) logEvents.eventLogIsClosed(this);
	  	}
	  	catch (IOException ex) {
				throw new FileCloseException(getSource(), ex);
	  	}
	  	finally {
	  		buffData = null;
	  	}
		}
  }
	
  public ILoggingResultSet searchNext(String[] searchTokens, boolean isCaseSensitive) throws DataException {
		
		LogRecordResultSet resultSet = new LogRecordResultSet();
		
		// Guardian...
		if (searchTokens == null || searchTokens.length == 0) return resultSet;
		
		// Set pos...
		moveToBOF();
		
		String token = null;
		
		try {
	  	
			openInt();

			while (!isEOF()) {
		  	byte[] resultChunk 	= buffData.readNext().message();
		  	String resultStr 		= new String (resultChunk);
		  	if (!isCaseSensitive) resultStr = resultStr.toUpperCase();
		  	for (int i = 0; i < searchTokens.length; i++) {
					token = searchTokens[i];
					if (!isCaseSensitive) token = token.toUpperCase();
		  		if (resultStr.indexOf(token) > 0) {
			  		LogRecord lr = getFormatter().parseMsg(resultChunk);
			  		if (lr != null) {
					  	resultSet.add(lr);
			  		}
			  		else {
							throw new FileDataException(getSource(), new ParseException("Parsing error...", 0));
			  		}
		  		}
		  	}
		  }
		}
		catch (DataException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new FileDataException(getSource(), ex);
		}
		return resultSet;
	}
	
	// Return starting pos of the last read message
	protected void setBookMarkInt(long value) throws DataException {
		try {
			buffData.setBookMark(value);
		}
		catch (IOException ex) {
			throw new FileDataException(getSource(), ex);
		}
	}
	
	//Return starting pos of the last read message
	protected long getBookMarkInt() throws DataException {
		return buffData.getBookMark();
	}
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private void loadDataFromFileHeader(FileLogInfoData fileHeader) {
	  
	  // Copy...
	  if (fileHeader.getHeader() != null && fileHeader.getHeader().length() > 0) {
			setName					(fileHeader.getName());
		  setDescription	(fileHeader.getDescription());
		  setFormatter		(fileHeader.getFormatter());
		  setEncoding			(fileHeader.getEncoding());
		  setHeader				(fileHeader.getHeader());
		  setFooter				(fileHeader.getFooter());
		  
		  // Helper variable...
		  fileHeaderSize  = fileHeader.getFileHeaderSize(); //getHeader().length();
		  fileFooterSize  = getFooter().length();
	  }
	  else {
	  	setName(fileHeader.getFileName());
	  	//setFormatter(new TraceFormatter());
	  }
	}
	
	private boolean isBOFInt() throws IOException {
		if (buffData == null) return true;
		return buffData.isBOF();
	}
	
	private boolean isEOFInt() throws IOException {
		if (buffData == null) return true;
		return buffData.isEOF();
	}
	
	//==== < private ================================== deprecated > ====
	
}