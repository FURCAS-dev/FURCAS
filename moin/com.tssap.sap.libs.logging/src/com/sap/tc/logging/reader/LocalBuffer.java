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
 * 
 * @version $Id:$
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

import com.sap.tc.logging.*;
import com.sap.tc.logging.exceptions.*;
import com.sap.tc.logging.interfaces.IMessageBuilder;


class LocalBuffer 
{ //$JL-SWITCH$
	//================================================ declaration > ====
	
	private static String strLoc = "LocalBuffer";
	
	private static final int 	INIT_VALUE 					= -1;
	private static final int 	MAX_EXTEND_COUNTER 	= 50;

	/**
	 * if a desired buffer size is not specified, this default size will be used.
	 * This value (8128) is obtained from java.io.BufferedReader with the belief that 
	 * the authors of java.io package might have chosen it with some optimization in mind.
	 */
	public static final int DEFAULT_BUFFER_SIZE 	= 8128;
	public static final int DEFAULT_CHUNK_SIZE  	= DEFAULT_BUFFER_SIZE * 10;
	
	/**
	 * This array contains the current buffer.
	 */
	private byte[] buffer;
	private byte[] bufferHelper;
	
	/**
	 * This array contains the full message chunk.
	 */
	private byte[] chunk;
	private byte[] emptyChunk;
	
	/**
	 * Default chunk byte array size is DEFAULT_CHUNK_SIZE 
	 * then every next time is extended by chunkSize
	 * In practice extending is very rare but may happen for very big messages, 
	 * and because of that extendCounter count how many time chunk is created without 
	 * reaching the new size. If that value is >= MAX_EXTEND_COUNTER, the chunk byte array 
	 * will be resized to old default size (DEFAULT_CHUNK_SIZE). 
	 */
	private int extendCounter = 0;

	/**
	 * This stands for the current position in the current buffer.
	 * If the value is neither less than the length of the current buffer
	 * nor greater than or equal to zero, it indicates that the buffer needs to be replenished.
	 */
	private int buffCurrPos = INIT_VALUE;

	/**
	 * Even though bufferSize is some specified value,
	 * it does not mean how buffer contains that num of bytes.
	 * The reasons may be: the end of the file, the beginning of the file or the file is very small.
	 * This value indicates the exact size of the current buffer retreived from file.
	 */
	private int buffCurrSize 	= INIT_VALUE;
	
	/**
	 * One record may be very long and spread among several buffers.
	 * This value indicate the hiden buffer size. 
	 * If record doesn't include several buffer chunks then this value 
	 * is same like buffCurrSize!
	 */
	private int buffIntSize 	= INIT_VALUE;
	
	private int 							lineSize			= 0;
	private int 							chunkOffset		= INIT_VALUE;
	private boolean 					chunkBOL;
	private boolean 					chunkEOL;
	
	private boolean 					isMasked;
	
	private int 							latestDirection 	= IMessageBuilder.DIRECTION_NONE;
	
	private String						sourceName;
	private RandomAccessFile 	source;
	private int								fileHeaderSize,
														fileFooterSize;
	
	private long							historyLatestBOL,
														historyLatestEOL;

	private MessageBuilder   	msgBuilder;
    
    /* introduced to handle the problem when lines starting with ascii code 0 symbols
       break the logging api parser */    
    private int asciiZeroes;
	
	//==== < declaration ============================ constructors > ====

	protected LocalBuffer (String sourceName, IMessageBuilder msgBuilder) throws OpenException  {
	
		if (msgBuilder == null) throw new IllegalArgumentException("MessageBuilder is missing!");
		
		this.sourceName				= sourceName;
		this.msgBuilder 			= (MessageBuilder) msgBuilder;
		
		this.buffer 					= new byte[DEFAULT_BUFFER_SIZE];
		this.bufferHelper 		= new byte[DEFAULT_BUFFER_SIZE];
		this.chunk						= new byte[DEFAULT_BUFFER_SIZE * 10];
		this.emptyChunk   		= new byte[DEFAULT_BUFFER_SIZE * 10];
			
		try {
			this.source = new RandomAccessFile(sourceName, "r");
			this.setBookMark(0);
		}
		catch (Exception ex) {
			throw new FileOpenException(sourceName, ex);
		}
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public boolean isBOF() throws IOException {
		return isBOFInt();
	}

	public boolean isEOF() throws IOException {
		return isEOFInt();
	}
	
	public void close() throws IOException {
		source.close();
		source = null;
		reset();
	}
	
	public void moveToBOF() throws IOException {
		// Guardian
		if (source == null) return;
		source.seek(fileHeaderSize);
		reInit();
	}
	
	public void moveToEOF() throws IOException {
		// Guardian
		if (source == null) return;
		source.seek(source.length() - fileFooterSize);
		reInit();
	}
	
	public IMessageBuilder readNext()throws DataException  {
		
		try {
			
			if(latestDirection == IMessageBuilder.DIRECTION_PREVIOUS) {
				setBookMark(msgBuilder.getBookMarkEOL());
			}
		
			// Prepare Message Builder for next message
			msgBuilder.reset();
            asciiZeroes = 0;
			
			// Read a message line
			do {
				msgBuilder.saveNextLine(nextLine(), lineSize - asciiZeroes);
				
				if (msgBuilder.getBookMarkEOL() == INIT_VALUE) {
					msgBuilder.setBookMarkBOL(historyLatestBOL);
				}
			}
			while (!msgBuilder.isComplete(IMessageBuilder.DIRECTION_NEXT));
		}
		catch(Exception ex) {
			throw new BufferDataException(sourceName, ex);
		}   
    	if (Version.getVersionIndex(Version.getVersionOfFirstRecord()) == Version.VER_CODE_2_0) {
   		  nextLine();
      	}    
		msgBuilder.setBookMarkEOL(historyLatestEOL);
		
		return msgBuilder;
	}
	
	public IMessageBuilder readPrevious() throws DataException {
		
		try {
			
			if(latestDirection == IMessageBuilder.DIRECTION_NEXT) {
				setBookMark(msgBuilder.getBookMarkBOL()-1);
			}
		
			// Prepare Message Builder for next message
			msgBuilder.reset();
			
			// Read a message line
			do {
				msgBuilder.savePreviousLine(previousLine(), lineSize);
				
				if (msgBuilder.getBookMarkEOL() == INIT_VALUE) {
					msgBuilder.setBookMarkEOL(historyLatestEOL);
				}
			}
			while (!msgBuilder.isComplete(IMessageBuilder.DIRECTION_PREVIOUS));
		}
		catch(Exception ex) {
			throw new BufferDataException(sourceName, ex);
		}    
		
		msgBuilder.setBookMarkBOL(historyLatestBOL);
		
		return msgBuilder;
	}
	
	public void setBookMark(long value) throws IOException {
		if (source == null) return; // Guardian
		if (value <= 0) {
			value = fileHeaderSize;
		}
		else if (value >= (source.length() - fileFooterSize)) {
			value = (source.length() - fileFooterSize);
		}
		seek(value);
	}
	
	public void setFileHeaderSize(int value) throws IOException {
		this.fileHeaderSize = value;
		// Move to BOF .. to be sure how future calculations are ok
		moveToBOF();
	}
	
	public void setFileFooterSize(int value) throws IOException {
		this.fileFooterSize = value;
		// Move to BOF .. to be sure how future calculations are ok
		moveToBOF();
	}
	
	public long getBookMark() throws DataException {
		return historyLatestEOL;
	}

	public void seek(long pos) throws IOException {
		if (source == null) return; // Guardian
		source.seek(pos);
		reInit();
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private void resetLine() {
		chunkBOL		 = false;
		chunkEOL  	 = false;
		chunkOffset  = INIT_VALUE;
		lineSize 		 = 0;
        asciiZeroes = 0;
	}
	
	private void reInit() {
		buffCurrPos 		= INIT_VALUE;
		buffCurrSize		= INIT_VALUE;
		latestDirection = IMessageBuilder.DIRECTION_NONE;;
		reset();
	}
	
	private boolean hasNext() {
		return ((buffCurrPos >= 0) && (buffCurrPos < buffCurrSize));
	}

	private boolean hasPrevious() {
		return (buffCurrPos >= 0);
	}
	
	/**
	* This fills the buffer in the forward direction.
	* @throws IOException, DataException
	*/
	private void fillBufferForward() throws IOException, DataException
	{
		// Guardian ...
		if (isEOFInt()) return;
		setLatestDirection(IMessageBuilder.DIRECTION_NEXT);
		loadBuffer(source.read(bufferHelper, 0, DEFAULT_BUFFER_SIZE));
	}
	
	/**
	* This fills the buffer in the backword direction.
	* @throws IOException, DataException
	*/
	private void fillBufferBackward() throws IOException, DataException
  {
		// Guardian ...
		if (isBOFInt()) return;
		
		int tmpBufferSize 	 = DEFAULT_BUFFER_SIZE;
		long currFilePointer = source.getFilePointer() - buffCurrSize;
	
		if ((currFilePointer - tmpBufferSize) <= 0) {
			tmpBufferSize   = (int) currFilePointer - fileHeaderSize;
			currFilePointer = 0;
			setFilePointer(currFilePointer);
		}
		else {
			currFilePointer = (currFilePointer - DEFAULT_BUFFER_SIZE);
			setFilePointer(currFilePointer);
		}
		setLatestDirection(IMessageBuilder.DIRECTION_PREVIOUS);
		loadBuffer(source.read(bufferHelper, 0, tmpBufferSize));
	}
	
	private void setFilePointer(long value) throws IOException {
		if (value <= 0) {
			value = fileHeaderSize;
		}
		else if (value >= (source.length() - fileFooterSize)) {
			value = (source.length() - fileFooterSize);
		}
		source.seek(value);
	}
	
	private void loadBuffer(int buffSize) throws DataException {
		
		if (buffSize < 0) return;
		try {
			if (lineSize > 0) {
				if (latestDirection == IMessageBuilder.DIRECTION_NEXT) {
					int newBufferSize  = lineSize + buffSize;
					
					byte[] tempBuffer = new byte [newBufferSize];
					
					System.arraycopy(buffer, buffCurrPos - lineSize, tempBuffer, 0, lineSize);
					System.arraycopy(bufferHelper, 0, tempBuffer, lineSize, buffSize);
					
					setCurrentSize(newBufferSize);
					
					buffCurrPos = lineSize;
					chunkOffset = 0;
					
					buffer = tempBuffer;
				}
				else {
					int newBufferSize  = lineSize + buffSize;
					
					byte[] tempBuffer = new byte [newBufferSize];
					
					System.arraycopy(bufferHelper, 0, tempBuffer, 0, buffSize);
					System.arraycopy(buffer, 0, tempBuffer, buffSize, lineSize);
					
					setCurrentSize(buffSize);
					chunkOffset = buffSize;
					
					buffer = tempBuffer;
				}
			}
			else {
				if (buffer.length < bufferHelper.length) {
					buffer = new byte[bufferHelper.length];
				}
				System.arraycopy(bufferHelper, 0, buffer, 0, buffSize);
				setCurrentSize(buffSize);
			}
		}
		catch (Exception ex) {
			throw new BufferDataException("LoadBuffer", ex);
		}
	}
	
	private boolean isChunkComplete() {
		return chunkBOL && chunkEOL;
	}
	
	private byte[] nextLine() throws DataException {
		try {
			
			resetLine();
			
			do {
				if (!hasNext()) {
					if (lineSize > 0 && isChunkComplete()) {
						return getChunkInt();
					}
					fillBufferForward();
				} 
				while(hasNext()) {
					next();
					if (isChunkComplete()) {
						return getChunkInt();
					}	
				}
			} while (!isEOFInt());
		}
		catch(IOException ex) {
			throw new BufferDataException(sourceName, ex);
		}
		return getChunkInt();
	}
	
	private byte[] previousLine() throws DataException {
		try {
			
			resetLine();
			
			do {
				if (!hasPrevious()) {
					if (lineSize > 0 && isChunkComplete()) {
						return getChunkInt();
					}
					fillBufferBackward();
				} 
				while(hasPrevious()) {
						previous();
						if (isChunkComplete()) {
							return getChunkInt();
						}
					}
			} while (!isBOFInt());
		}
		catch(IOException ex) {
			throw new BufferDataException(sourceName, ex);
		}
		return getChunkInt();   
	}
	
	private byte next() throws DataException {
		
		byte value = -1;
		
		try {
		
			// Set curren direction
			latestDirection = IMessageBuilder.DIRECTION_NEXT;
			// Read value from ...
			value = buffer[buffCurrPos];
			// Increment the chunk item counter
			lineSize++;
			
			switch(value) {
				case '\n': // LF
					chunkBOL = true;
					chunkEOL = true;
					msgBuilder.getDelimiter().demask();
					isMasked = false;
					break;
                case 0 :
                	if (Version.getVersionIndex(Version.getVersionOfFirstRecord()) == Version.VER_CODE_2_0) {
                	  asciiZeroes++; 
                	}    
                    break;
				case '\\': // Mask 
					isMasked = true;
				default:
					// DELIMITER CHECK
					msgBuilder.getDelimiter().saveNextPosition(value, lineSize - asciiZeroes);
					isMasked = false;
					break;
			}

			// Set offset - read starting pos
			// Offset represent a starting point in the buffer from
			// where new line starts
			if (chunkOffset == INIT_VALUE) chunkOffset = buffCurrPos;
			// Prepare for next ...
			buffCurrPos++;
		}
		catch (Exception ex) {
			throw new BufferDataException(sourceName, ex);
		}
		return value;
	}

	private byte previous() throws DataException {	
		
		byte value = -1;
		
		try {
		
			// Set curren direction
			latestDirection = IMessageBuilder.DIRECTION_PREVIOUS;
			// Read value from ...
			value = buffer[buffCurrPos];
			// Increment the chunk item counter
			lineSize++;
			
			switch(value) {
				case '\n': // LF
					if (lineSize > 1) {
						// Set BOL flag - start
						chunkBOL = true;
						if (chunkOffset == INIT_VALUE) chunkOffset = buffCurrPos;
						lineSize--;
					}
					else {
						// Prepare for next ...
						// This is possible only if this buffer was
						// the first buffer in the file starting from the EOF
						// or, in some rare cases where same situation may
						// happen when opening new buffer results in same sitation
						// regardless of current fille pointer (file pointer != EOF)
						buffCurrPos--;
					}
					// Set EOL flag
					chunkEOL = true;
					isMasked = false;
					break;
				case '\\': // Mask 
					isMasked = true;
				default:
					// DELIMITER CHECK
					msgBuilder.getDelimiter().savePreviousPosition(value, lineSize);
				
					// Set offset - read starting pos
					// Offset represent a starting point in the buffer from
					// where new line starts
					// Since browsing direction is backward (previous)
					// offset is equal to the current position in the buffer
					chunkOffset = buffCurrPos;
					// Prepare for next ...
					buffCurrPos--;
					isMasked = false;
					break;
			}
		}
		catch (Exception ex) {
			throw new BufferDataException(sourceName, ex);
		}
		return value;
	}
	
	private void setLatestDirection(int direction) {
		if (direction < IMessageBuilder.DIRECTION_PREVIOUS) direction = IMessageBuilder.DIRECTION_PREVIOUS;
		if (direction > IMessageBuilder.DIRECTION_NEXT) 		direction = IMessageBuilder.DIRECTION_NEXT;
		if (direction == 0) 																direction = IMessageBuilder.DIRECTION_NEXT;
		this.latestDirection = direction;
	}
	
	private void reset() {
        asciiZeroes = 0;
		lineSize 		= 0;
		chunkOffset 	=  INIT_VALUE;

		// Very rare
		if (extendCounter >= MAX_EXTEND_COUNTER 
		 && chunk.length > DEFAULT_CHUNK_SIZE) {
			byte[] chunk = new byte [DEFAULT_CHUNK_SIZE];
		}
		else {
			// Clear the chunk array
			System.arraycopy(emptyChunk, 0, chunk, 0, DEFAULT_CHUNK_SIZE);
		}
	}
	
	private byte[] getChunkInt() throws DataException {
		
		// Guardian...
		if (lineSize == 0) return chunk;
		
		try {
			// Extend chunk size - for very big LogRecord 
			//... very rare
			extendCounter++;
			if (chunk.length < (lineSize)) {
				byte[] tmpNewChunk = new byte [lineSize];
				System.arraycopy(chunk, 0, tmpNewChunk, 0, chunk.length);
				chunk = tmpNewChunk;
				extendCounter = 0;
			}
			
			System.arraycopy(buffer, chunkOffset + asciiZeroes, chunk, 0, lineSize - asciiZeroes);
			
			historyLatestBOL = getBOLPointer();
			historyLatestEOL = getEOLPointer();
		}
		catch (Exception ex) {
			throw new BufferDataException(sourceName, ex);
		}
		return chunk;
	}

	private void setCurrentSize(int value) {
		buffCurrSize = value;
		chunkOffset	 = INIT_VALUE;
		buffCurrPos  = 0;
		chunkEOL = false;
		chunkBOL = false;
		if (latestDirection == IMessageBuilder.DIRECTION_PREVIOUS) {
			buffCurrPos =  buffCurrSize > 0 ? (buffCurrSize - 1) : INIT_VALUE;
		}
	}
	
	private long getBOLPointer() throws IOException {
		long pos 			= calculateBOLPos();
		long buffSize = (buffCurrSize > 0) ? buffCurrSize : 0;
		if (pos < 0) {
			pos =  (pos * (-1)) + buffSize;
		}
		else {
			//pos = buffSize - pos;
		}
		return source.getFilePointer() - pos;
	}
	
	private long getEOLPointer() throws IOException {
		long pos = calculateEOLPos();
		return source.getFilePointer() - pos;
	}
	
	private long calculateBOLPos()  {
		
		long buffTmpPos  = buffCurrPos; //(buffCurrPos > 0) ? buffCurrPos : 0;
		long buffTmpSize = (buffCurrSize > 0) ? buffCurrSize : 0;
		
		if (latestDirection == IMessageBuilder.DIRECTION_NEXT) { // BOL
			if ((buffTmpPos - lineSize) >= -1) {
				buffTmpPos = (buffTmpSize - buffTmpPos) + lineSize;
			}
			else {
				// If chunk is from more then one buffer
				// result will be negative
				buffTmpPos = buffTmpPos - (lineSize + 1);
			}
		}
		else if (latestDirection == IMessageBuilder.DIRECTION_PREVIOUS) { // BOL
			// current pos in buffer is BOL 
			buffTmpPos = (buffTmpSize - buffTmpPos - 1);
		}
		return buffTmpPos;
	}
	
	private long calculateEOLPos() {
		
		long buffTmpPos  = buffCurrPos;
		long buffTmpSize = (buffCurrSize > 0) ? buffCurrSize : 0;
		
		if (latestDirection == IMessageBuilder.DIRECTION_NEXT) { // EOL
			// current pos in buffer is EOL 
			buffTmpPos = (buffTmpSize - buffTmpPos);
		}
		else if (latestDirection == IMessageBuilder.DIRECTION_PREVIOUS) { // EOL
			if (((buffTmpSize - buffTmpPos) - lineSize) >= -1) {
				buffTmpPos = (buffTmpSize - ((buffTmpPos + lineSize) + 1));
			}
			else {
				// If chunk is from more then one buffer
				// result will be negative
				buffTmpPos = ((buffTmpSize - buffTmpPos) - lineSize);
			}
		}
		else {
			buffTmpPos  = (buffCurrPos > 0) ? buffCurrPos : 0;
		}
		return buffTmpPos;
	}
	
	private boolean isBOFInt() throws IOException {
		if (source == null) return true;
		return ((getBOLPointer() - fileHeaderSize) <= 0);
	}
	
	private boolean isEOFInt() throws IOException {
		if (source == null) return true;
		return ((source.length() - fileFooterSize) <= getEOLPointer());
	}
	
	//==== < private ================================== deprecated > ====

}
