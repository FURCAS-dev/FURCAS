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
 */

import java.io.*;
import java.util.*;

import com.sap.tc.logging.Location;
import com.sap.tc.logging.MSGCollection;
import com.sap.tc.logging.LoggingManager;
import com.sap.tc.logging.LogRecord;
import com.sap.tc.logging.FileLog;
import com.sap.tc.logging.Severity;
import com.sap.tc.logging.Formatter;
import com.sap.tc.logging.LogEvents;
import com.sap.tc.logging.exceptions.*;
import com.sap.tc.logging.interfaces.*;
import com.sap.tc.logging.messagedepot.MessageAccessor;

/**
 * Defines common operations to read log messages (a message record) from a log
 * destination. Currently, this mainly handles sequential records retrieval
 * starting either from the oldest or latest time point. To avoid messing up the
 * sequential reading from concurrent readers on the same log destination, it is
 * recommended to get a copy of this 'readable' log for each reader.
 */

public class ReadableLog extends FileLog
												 implements IReadableLog
{
	//$JL-EXC$
	//================================================ declaration > ====
	
	public static final Location tracer = Location.getLocation(ReadableLog.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	private static String subLoc 		= "ReadableLog";
	
	FileReadLog source 									= null;
	LogEventsListener localListener = new LogEventsListener();
	int			 grabCounter          	= 0;
	
    private boolean isTimeFilterSet = false;
    long start = -1;
    long end = -1;
    int startFileSetIndex = -1;
    long startFileBookmark = -1;
    int endFileSetIndex = -1;
    long endFileBookmark = -1;
    boolean willItBeFirstReadAfterTimeFilterWasApplied = true;
	
	//==== < declaration ============================ constructors > ====
	
	/**
 	* @deprecated ReadableLog become factory class. 
 	* Use factory methods:
 	* - createReadableLog(FileLog fileLog) to get old IReadableLog instance
 	* - createFileReadLog(FileLog fileLog) to get new IReadLog instance 
 	* for reading Files written using ListFormatter and TraceFormatter 
 	*/
	public ReadableLog (String pattern) {
		super(pattern);
		source = (FileReadLog) createFileReadLog(new FileLog(pattern));
		setStatus(FileLog.STATUS_CLOSED);
		((FileReadLog)source).registerForLogEvents(localListener);
	}
	
	private ReadableLog (FileLog fileLog) {
		source = (FileReadLog) createFileReadLog(fileLog);
		setStatus(FileLog.STATUS_CLOSED);
		((FileReadLog)source).registerForLogEvents(localListener);
	}
	
	private ReadableLog (FileLog fileLog, MessageAccessor accessor) {
		source = (FileReadLog) createFileReadLog(fileLog, accessor);
		setStatus(FileLog.STATUS_CLOSED);
		((FileReadLog)source).registerForLogEvents(localListener);
	}
	
	//==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
	
	/**
		* This method log all exception but 
	  * doesn't re-throw it out. 
		* @deprecated Not suported
		*/
  public static IReadLog createFileReadLog(FileLog fileLog) {
		return new FileReadLog(fileLog);
  }
  
  public static IReadLog createFileReadLog(FileLog fileLog, MessageAccessor accessor) {
		return new FileReadLog(fileLog, accessor);
	}
  
  /**
   * Create FileReadLog object.
   * Note: This method may be used only on log files which contains the file log header data.
   * @param fileName
   * @return Instance of FileReadLog
   * @throws FileDataException
   */
  public static IReadLog createFileReadLog(String fileName) throws FileDataException{
		return new FileReadLog(fileName);
	}
	
	public static IReadLog createFileReadLog(String fileName, MessageAccessor accessor) throws FileDataException{
		return new FileReadLog(fileName, accessor);
	}
	
  /**
	  * Create a 'copy' of this Filelog, exposing only the message reading API. Then, retrieval
	  * of message records for each reader will be independent. This can avoid messing up
	  * the sequential reading pointers from potential concurrent multiple readers.
	  * @return A copy of this readable log that contains mainly cursor actions or a null value if creation fails
	  */
	
	public static IReadableLog createReadableLog(FileLog fileLog) 
	{
		return createReadableLog(fileLog, null);
	}
	
	public static IReadableLog createReadableLog(FileLog fileLog, MessageAccessor accessor) 
	{
		// This copy / clone is only needed for backward compatibility
  
		ReadableLog rLogcopy = new ReadableLog	(fileLog, accessor);
	  
		// Copy data for the case where file doesn't exists
		// If file exists those data will be replaced
		// with data from file header 
		rLogcopy.setName								(fileLog.getName());
		rLogcopy.source.setName	  			(fileLog.getName());
		
		rLogcopy.setDescription					(fileLog.getDescription());
		rLogcopy.source.setDescription	(fileLog.getDescription());
		
		rLogcopy.setPattern							(fileLog.getPattern());
		rLogcopy.source.setPattern			(fileLog.getPattern());
		
		rLogcopy.setFormatter  					(fileLog.getFormatter());
		rLogcopy.source.setFormatter  	(fileLog.getFormatter());
		
		rLogcopy.setCnt									(fileLog.getCnt());
		rLogcopy.source.setSize					(fileLog.getCnt());
		
		rLogcopy.setLimit								(fileLog.getLimit());
		rLogcopy.source.setLimit				(fileLog.getLimit());
		
		rLogcopy.setIndex								(fileLog.getIndex());
		rLogcopy.source.setIndex				(fileLog.getIndex());
	
		rLogcopy.setEncoding						(fileLog.getEncoding());
		rLogcopy.source.setEncoding			(fileLog.getEncoding());
	
		rLogcopy.setMode								(fileLog.getMode());
		rLogcopy.source.setMode					(fileLog.getMode());
		
  	// Old interface (ReadableLog) doesn't call open() method
  	// he assume how that will happen automaticly during browsing!
  	// Open method is very important because that method load the FileHeader 
		// and init the FileSet interface
		try {
			rLogcopy.source.open();
			rLogcopy.close();
		}
		catch (Exception ex) {
		}
  
		return rLogcopy;
	}
	
	/**
	* Create a 'copy' of this Filelog, exposing only the message reading API. Then, retrieval
	* of message records for each reader will be independent. This can avoid messing up
	* the sequential reading pointers from potential concurrent multiple readers.
	* @return A copy of this readable log that contains mainly cursor actions or a null value if creation fails
	*/
	
	public IReadableLog createReadableLog()
  {
	  return createReadableLog((FileLog) this, null);
	}
	
	public IReadableLog createReadableLog(MessageAccessor accessor)
	{
		return createReadableLog((FileLog) this, accessor);
	}

	/**
     * Resets current time filter if there is such applied.
     * 
     * @return true if the filter was removed, false otherwise.
     *         In both cases the behaviour of readLatestMsgRecords(int), readNextMsgRecords(int),
     *         readOldestMsgRecords(int) and readPrevMsgRecords(int) is the default one
     *         when there is no time confitions for the log records retrieved.  
     */
    public boolean resetTimeFilter() {
        if (isTimeFilterSet) {
            this.isTimeFilterSet = false;
            this.start = -1;
            this.end = -1;
            this.startFileSetIndex = -1;
            this.startFileBookmark = -1;
            this.endFileSetIndex = -1;
            this.endFileBookmark = -1;
            this.willItBeFirstReadAfterTimeFilterWasApplied = true;
            return true;            
        } else {
            return false;
        }
    }
    
    public boolean isTimeFilterSet() {
        return this.isTimeFilterSet;
    }
    
    /**
     * Sets start and end time conditions for the log records to be retrieved with readLatestMsgRecords(int),
     * readNextMsgRecords(int), readOldestMsgRecords(int) and readPrevMsgRecords(int) methods.
     * Any subsequent invocations of these methods will take into account the time period
     * and will return log entries that conform to it. The default behaviour of the methods is
     * restored with resetTimeFilter() method.
     * 
     * @param start - time in milliseconds that will indicate the start point of
     *                the time filter which this method applies. May be zero for 'no limits'.
     * @param end - time in milliseconds that will indicate the end point of
     *              the time filter which this method applies. May be zero for 'no limits'.
     * @return true if the time filter was applied succesfully.
     *         
     */
    // public boolean setFilter(Date start, Date end) { <- what about ???
    public boolean setTimeFilter(long start, long end) {
        if (!isTimeFilterSet) {
            resetTimeFilter();
            this.start = start;
            this.end = end;
            this.isTimeFilterSet = true;
            return true;
        } else {
            ReaderLogger.traceThrowableIntByAPI(Severity.WARNING,
                                                    subLoc + "[setFilter()]",
                                                    "An attempt to apply time&date filter in Logging API, without reseting the one, already set.",
                                                    new Exception("An attempt to apply time&date filter in Logging API, without reseting the one, already set."));
            return false;
        }            
    }
   
    private void removeTooNewFiles(TreeMap timeIndexMap, long end) {
        for (Iterator it = timeIndexMap.keySet().iterator(); it.hasNext();) {
            long startTimestamp = -((Long) it.next()).longValue();
            if (end < startTimestamp &&
            		 end != 0) { // end == 0 means no restriction about the end
                it.remove();
            }
        }
    }
    
    private void removeTooOldFiles(TreeMap timeIndexMap, long start) {
        
      Object o = null;
      SortedSet timeKeysToRemove = new TreeSet();
      timeKeysToRemove.addAll(timeIndexMap.keySet());
      while (!timeKeysToRemove.isEmpty() && (o = timeKeysToRemove.last()) != null && (start == 0 || ((Long) o).longValue() >= start)) {
    		  timeKeysToRemove.remove(o);
      }
      if (!timeKeysToRemove.isEmpty() && (o = timeKeysToRemove.last()) != null) {
    	  if (start == 0 || ((Long) o).longValue() < start) {
              timeKeysToRemove.remove(o);    		  
    	  }
     }
      
      Iterator i = timeKeysToRemove.iterator();
      while (i.hasNext()) {
          timeIndexMap.remove((Long)i.next());
      }
    }        
    
    private boolean setStartBookmarks() {
      TreeMap timeFileindexMap = new TreeMap();
        
      try {
        if (source.isClosed()) {
            source.open();
        }
        
        // here we move to the beginning of the file set as well.
        source.moveToBOF();
        
        boolean toBreak = false;
        do { // iterates over all the files in the file set 
            if (source.isEnd()) {
              toBreak = true;
            }
            ILoggingResultSet firstRowInFile = source.readNext();
            LogRecord lr = (LogRecord)firstRowInFile.getResults().get(0);
            timeFileindexMap.put(new Long(lr.getTime().getTime()), new Integer(source.getIndex()));
            if (toBreak) {
              break;
            }
            source.next(); //moves to the next file from the file set
            source.close();
            source.open();
            source.moveToBeginningOfCurrentFile(); //ready to read first line from the next file
        } while (true);
        
        removeTooOldFiles(timeFileindexMap, start);
        
        // iterates over all the files, entry by entry and sets the start bookmark 
        for (Iterator it = timeFileindexMap.values().iterator(); it.hasNext();) {
            int index = ((Integer) it.next()).intValue();
            source.setIndex(index);
            source.close();
            source.open();
            LogRecord lr = null;
            long startPosition = 0;
            while (!source.isEndOfCurrentFile()) {
                startPosition = source.getBookMark();
                ILoggingResultSet aRow = source.readNext();
                lr = (LogRecord) aRow.getResults().get(0);
                if (lr.getTime().getTime() >= start || start == 0) {
                    this.startFileBookmark = startPosition;
                    this.startFileSetIndex = index;
                    return true;
                }
            }
        }        
        // did not find a start position, there are no elements after the start point of the time filter
        return true;
      } catch (Exception ex) {
          ReaderLogger.traceThrowableIntByAPI(Severity.ERROR,
                  subLoc + "[setStartBookmarks()]",
                  "Exception while applying time filter in Logging API for file " + this.getName(),
                  new Exception("Exception while applying time filter in Logging API for file " + this.getName()));
          this.isTimeFilterSet = false;
          return false;
      }
    }
    
    private boolean setEndBookmarks() {
        TreeMap timeFileindexMap = new TreeMap();
          
        try {
          if (source.isClosed()) {
              source.open();
          }
          
          // here we move to the beginning of the file set as well.
          source.moveToBOF();
          
          boolean toBreak = false;
          do { // iterates over all the files in the file set 
              if (source.isEnd()) {
                toBreak = true;
              }
              ILoggingResultSet firstRowInFile = source.readNext();
              LogRecord lr = (LogRecord)firstRowInFile.getResults().get(0);
              timeFileindexMap.put(new Long(-(lr.getTime().getTime())), new Integer(source.getIndex()));
              if (toBreak) {
                break;
              }
              source.next(); //moves to the next file from the file set
              source.close();
              source.open();
              source.moveToBeginningOfCurrentFile(); //ready to read first line from the previous file
          } while (true);
          
          removeTooNewFiles(timeFileindexMap, end);
          
          // iterates over all the files, entry by entry and sets the end bookmark 
          for (Iterator it = timeFileindexMap.values().iterator(); it.hasNext();) {
              int index = ((Integer) it.next()).intValue();
              source.setIndex(index);
              source.close();
              source.open();
              source.moveToEndOfCurrentFile();
              LogRecord lr = null;
              long endPosition = 0;
              while (!source.isBeginningOfCurrentFile()) {
                  endPosition = source.getBookMark();
                  ILoggingResultSet aRow = source.readPrevious();
                  lr = (LogRecord) aRow.getResults().get(0);
                  if (lr.getTime().getTime() <= end || end == 0) {
                      this.endFileBookmark = endPosition;
                      this.endFileSetIndex = index;
                      return true;
                  }
              }
          }        
          // did not find the end position, there are no elements prior to the end point of the time filter
          return true;
        } catch (Exception ex) {
            ReaderLogger.traceThrowableIntByAPI(Severity.ERROR,
                    subLoc + "[setEndBookmarks()]",
                    "Exception while applying time filter in Logging API for file " + this.getName(),
                    ex);
            this.isTimeFilterSet = false;
            return false;
        }
      }    
	
	/**
	 * <p>
	 * Retrieve the latest n messages and return them in a result set.
     * This method always refers to the newest messages even
	 * the output file is growing and rotating.
	 * </p>
	 * @param numMsg number of messages (>0) to be retrieved
	 * @return retrieved messages each of them packed in {@link LogRecord},
     * stored in a list of the result set. If time filter has been applied (see {@link setTimeFilter(long, long)})
     * only messages that are in the time period are returned and 
     * position [0] holds the latest message, otherwise it holds the oldest and in both cases
     * the messages are sotred by time.<br>
	 * The resulting list contains all valid available messages,
	 * that is, the size may be smaller than the requested number.
	 * This can happen if there actually exists fewer messages in the file, including empty file (status valid), or certain
	 * messages are getting parsing error (status invalid). <br>
	 * If file is not empty but no valid message can be retrieved, this will return an empty list with status invalid.
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws UnsupportedFormatException Formatter type not supported by Log Viewer
	 * @throws FileNotFoundException Output file not found
	 * @throws SecurityException  Access to output file denied
	 * @throws IOException Problem reading data from output file
	 */
	public ILoggingResultSet readLatestMsgRecords(int numberOfRecords) throws IllegalArgumentException,
								UnsupportedFormatException, FileNotFoundException, SecurityException, IOException {
		LogRecordResultSet resultSet = null;
		ILoggingResultSet rSet = null;
		File checkIfFileExists = new File(source.getSource());
		if (isTimeFilterSet && checkIfFileExists.exists() && checkIfFileExists.isFile()) {
			try {
				resultSet = new LogRecordResultSet();
				if (setEndBookmarks() == false) {
					throw new Exception("Failed to set end bookmark for time filter. See traces for exact exception.");
				}
				if (this.endFileBookmark == -1 || this.endFileSetIndex == -1) {
					return new LogRecordResultSet();
				} else {
					source.setIndex(this.endFileSetIndex);
					source.close();
					source.open();
					source.setBookMark(this.endFileBookmark - 1);
					if (endFileBookmark == 0) {
						source.moveToEndOfCurrentFile();
					}
					rSet = source.readPrevious();
					if (rSet.getSize() > 0) {
						LogRecord aMessage = (LogRecord) rSet.getResults().get(0);
						if (aMessage.getTime().getTime() >= start) {
							resultSet.add(aMessage);
						} else {
							LogRecordResultSet runt = new LogRecordResultSet();
							runt.setStatus(LogRecordResultSet.INVALID);
							runt.setException(new Exception("Incorrectly set time filter in Logging API."
									+ "Message time is " + aMessage.getTime().getTime() + " Start time is " + start));
							return runt;
						}
					}
				}
			
				while (resultSet.getSize() < numberOfRecords) {
					rSet = source.readPrevious();
					if (rSet.getSize() == 0) {
						break;
					}
					LogRecord aMessage = (LogRecord) rSet.getResults().get(0);
					if (aMessage.getTime().getTime() >= start) {
						resultSet.add(aMessage);
					} else {
						break;
					}
				}
				willItBeFirstReadAfterTimeFilterWasApplied = false;
				return resultSet;
			} catch (Exception e) {
				resultSet = new LogRecordResultSet();
				resultSet.setStatus(LogRecordResultSet.INVALID);
				resultSet.setException(e);
			}
		} else {
		
			try {
				source.open();
				source.moveToEOF();
				resultSet = (LogRecordResultSet) source.readPrevious(numberOfRecords);
			} catch (Exception ex) {
				resultSet = new LogRecordResultSet();
				resultSet.setStatus(LogRecordResultSet.INVALID);
				resultSet.setException(ex);
			}
		}
		return resultSet;
	}


	/**
	  * <p>
	  * Retrieve the oldest n messages and return them in a result set, sorted by time.
      * This method always refers to the currently available
	  * oldest messages which may be different due to the rotating feature
	  * from the constantly growing output file size.
	  * </p>
	  * @param numMsg number of messages (>0) to be retrieved
      * @return retrieved messages each of them packed in {@link LogRecord},
      * stored in a list of the result set. If time filter has been applied (see {@link setTimeFilter(long, long)})
      * only messages that are in the time period are returned and 
      * position [0] holds the oldest message and 
      * the messages are sotred by time.<br>
	  * The resulting list contains all valid available messages,
	  * that is, the size may be smaller than the requested number.
	  * This can happen if there actually exists fewer messages in the file, including empty file (status valid), or certain
	  * messages are getting parsing error (status invalid). <br>
	  * If file is not empty but no valid message can be retrieved, this will return an empty list with status invalid.
	  * @throws IllegalArgumentException Negative number or zero messages requested
	  * @throws UnsupportedFormatException Formatter type not supported by Log Viewer
	  * @throws FileNotFoundException Output file not found
	  * @throws SecurityException  Access to output file denied
	  * @throws IOException Problem reading data from output file
	  */
	public ILoggingResultSet readOldestMsgRecords(int numberOfRecords)
										  throws IllegalArgumentException, UnsupportedFormatException, FileNotFoundException, 
												 SecurityException, IOException
	{
		LogRecordResultSet resultSet;
		File checkIfFileExists = new File(source.getSource());
        if (isTimeFilterSet && checkIfFileExists.exists() && checkIfFileExists.isFile()) {		
            try {
                resultSet = new LogRecordResultSet();

            	if (setStartBookmarks() == false) {
            		throw new Exception("Failed to set start bookmark for time filter. See traces for exact exception.");                        
            	}
                if (this.startFileBookmark == -1 || this.startFileSetIndex == -1) {
                    return new LogRecordResultSet();
                } else {
                    source.setIndex(this.startFileSetIndex);
                    source.close();
                    source.open();
                    source.setBookMark(this.startFileBookmark);
                    ILoggingResultSet rSet = source.readNext();
                    LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                    if (aMessage.getTime().getTime() <= end || end == 0) {
                        resultSet.add(aMessage);
                    } else {
                        LogRecordResultSet runt = new LogRecordResultSet();
                        runt.setStatus(LogRecordResultSet.INVALID);
                        runt.setException(new Exception("Incorrectly set time filter in Logging API"));
                        return runt;
                    }
                }
                    
                ILoggingResultSet rSet = null;
                while (resultSet.getSize() < numberOfRecords) {
                    rSet = source.readNext();
                    if (rSet.getSize() == 0) {
                        break;
                    }
                    LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                    if (aMessage.getTime().getTime() <= end || end == 0) {
                        resultSet.add(aMessage);
                    } else {
                    	break;
                    }
                }
                willItBeFirstReadAfterTimeFilterWasApplied = false;
                return resultSet;
            } catch (Exception e) {
                resultSet = new LogRecordResultSet();
                resultSet.setStatus(LogRecordResultSet.INVALID);
                resultSet.setException(e);
            }
        } else {
		try {
			source.open();
			source.moveToBOF();
			resultSet = (LogRecordResultSet) source.readNext(numberOfRecords);
		}
		catch (Exception ex) {
			resultSet = new LogRecordResultSet();
			resultSet.setStatus(LogRecordResultSet.INVALID);
			resultSet.setException(ex);
		}
        }
		
		/*System.out.println("Call: " 	  + ++grabCounter);
		System.out.println("Source: " 	  + getPath());
		System.out.println("Method: " 	+ "BOF NEXT - readOldestMsgRecords()");
		if (resultSet.getResults().isEmpty()) {
			System.out.println("Message: NONE"); 
			System.out.println("Status: " + resultSet.isValid());
			grabCounter = 0;
		}
		else {
			System.out.println("Message: " + ((LogRecord)resultSet.getResults().get(0)).getId().toString());
		}*/
		
		return resultSet;
	}

	/**
	 * <p>
	 * Continue retrieving x relatively older messages, picked from the point where
	 * the last message read from the previous read operation, with respect to
	 * the direction of the previous read operation. For example, if previous call is
	 * readLatestMsgRecords(5), this call readPrevMsgRecords(2) will retrieve the
	 * 7th and 6th lastest messages. If previous call is readOldestMsgRecords(5), this call
	 * readPrevMsgRecords(2) will retrieve the 3rd & 4th oldest messages.
	 * </p>
	 * <p>
	 * If this method is called without a prior call to {@link #readLatestMsgRecords(int)}
	 * or {@link #readOldestMsgRecords(int)},
	 * this will behave the same as calling <code> readLatestMsgRecords(numMsg) </code>.
	 * </p>
	 * <p>
	 * Messages are returned in a result set in chronological order.
	 * Due to the potential file overwriting by the rotating feature, the file
	 * being currently referenced to may no longer exist and thus data will
	 * become invalid. It is always a good idea to check the overall status of
	 * the result set before getting the resulting list.
	 * </p>
	 * @param numMsg number of messages(>0) to be retrieved
     * @return retrieved messages each of them packed in {@link LogRecord},
     * stored in a list of the result set. If time filter has been applied (see {@link setTimeFilter(long, long)})
     * only messages that are in the time period are returned and 
     * position [0] holds the latest message, otherwise it holds the oldest and in both cases 
     * the messages are sotred by time.<br> 
     * Due to the potential rotating feature, you are
	 * advised to check the overall status of the result set (<code>isValid()) before
	 * retrieving the resulting list.<br>
	 * The resulting list contains all valid available messages,
	 * that is, the size may be smaller than the requested number.
	 * This can happen if there actually exists fewer messages in the file (status valid), or certain
	 * messages are getting parsing error (status invalid).<br>
	 * If no more older message can be retrieved, this will return
	 * a valid empty list in the result set.
	 * If current file is being overwritten while reading, status set to invalid in result set.
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws UnsupportedFormatException Formatter type not supported by Log Viewer
	 * @throws FileNotFoundException Output file not found
	 * @throws SecurityException  Access to output file denied
	 * @throws IOException Problem reading data from output file
	 * @see LoggingResultSet
	 * @see FileLog.LogRecordResultSet
	 */
	public ILoggingResultSet readPrevMsgRecords(int numberOfRecords)
										throws IllegalArgumentException, UnsupportedFormatException, FileNotFoundException, 
											   SecurityException, IOException
	{
		LogRecordResultSet resultSet;
		File checkIfFileExists = new File(source.getSource());
        if (isTimeFilterSet && checkIfFileExists.exists() && checkIfFileExists.isFile()) {		
            try {
                resultSet = new LogRecordResultSet();
                if (willItBeFirstReadAfterTimeFilterWasApplied) {
                	if (setEndBookmarks() == false) {
                		throw new Exception("Failed to set end bookmark for time filter. See traces for exact exception.");                        
                	}                	
                    if (this.endFileBookmark == -1 || this.endFileSetIndex == -1) {
                        return new LogRecordResultSet();
                    } else {
                        source.setIndex(this.endFileSetIndex);
                        source.close();
                        source.open();
                        source.setBookMark(this.endFileBookmark-1);
                        if (endFileBookmark == 0) {
                            source.moveToEndOfCurrentFile();                    	
                        } else {
                        	source.readPrevious(); //read away first row after the end time period
                        }
                        ILoggingResultSet rSet = source.readPrevious();
                        LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                        if (aMessage.getTime().getTime() >= start) {
                            resultSet.add(aMessage);
                        } else {
                            LogRecordResultSet runt = new LogRecordResultSet();
                            runt.setStatus(LogRecordResultSet.INVALID);
                            runt.setException(new Exception("Incorrectly set time filter in Logging API"));
                            return runt;
                        }
                    }
                    willItBeFirstReadAfterTimeFilterWasApplied = false;
                }
                    
                ILoggingResultSet rSet = null;
                while (resultSet.getSize() < numberOfRecords) {
                    rSet = source.readPrevious();
                    if (rSet.getSize() == 0) {
                        break;
                    }
                    LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                    if (aMessage.getTime().getTime() >= start) {
                        resultSet.add(aMessage);
                    } else {
                    	break;
                    }
                }
                return resultSet;
                
            } catch (Exception e) {
                resultSet = new LogRecordResultSet();
                resultSet.setStatus(LogRecordResultSet.INVALID);
                resultSet.setException(e);
            }
        } else {
        
		if(!source.isOpened()) { //readOldest or readLatest have never been called/with error
			resultSet = (LogRecordResultSet) readLatestMsgRecords(numberOfRecords);
		}
		else {
			try {
				resultSet = (LogRecordResultSet) source.readPrevious(numberOfRecords);
			}
			catch (Exception ex) {
				resultSet = new LogRecordResultSet();
				resultSet.setStatus(LogRecordResultSet.INVALID);
				resultSet.setException(ex);
			}
		}
			}

		return resultSet;
	}
	private String latestMSG, currentMSG;
	 /**
	 * <p>
	 * Continue retrieving x relatively newer messages, picked from the point where
	 * the last message read from the previous read operation, with respect to
	 * the direction of the previous read operation. For example, if previous call is
	 * readOldestMsgRecords(5), this call readNextMsgRecords(2) will retrieve the
	 * 6th and 7th oldest messages. If previous call is readLatestMsgRecords(5), this call
	 * readNextMsgRecords(2) will retrieve the 4th & 3rd lastest messages.
	 * </p>
	 * <p>
	 * If this method is called without a prior call to {@link #readLatestMsgRecords(int)}
	 * or {@link #readOldestMsgRecords(int)},
	 * this will behave the same as calling <code> readOldestMsgRecords(numMsg) </code>.
	 * </p>
	 * <p>
	 * Messages are returned in a result set, sorted by their time.
     * @return retrieved messages each of them packed in {@link LogRecord},
     * stored in a list of the result set. If time filter has been applied (see {@link setTimeFilter(long, long)})
     * only messages that are in the time period are returned and 
     * position [0] holds the latest message, otherwise it holds the oldest and in both cases
     * the messages are sotred by time.<br>
     *  
	 * Due to the potential file overwriting by the rotating feature, the file
	 * being currently referenced to may no longer exist and thus data will
	 * become invalid. It is always a good idea to check the overall status of
	 * the result set before getting the resulting list.
	 * </p>
	 * @param numMsg number of messages(>0) to be retrieved
     * @return retrieved messages each of them packed in {@link LogRecord},
     * stored in a list of the result set. If time filter has been applied (see {@link setTimeFilter(long, long)})
     * only messages that are in the time period are returned and 
     * position [0] holds the oldest message and the messages are sotred by time.<br> 
	 * Due to the potential rotating feature, you are
	 * advised to check the overall status of the result set (<code>isValid()) before
	 * retrieving the resulting list.<br>
	 * The resulting list contains all valid available messages,
	 * that is, the size may be smaller than the requested number.
	 * This can happen if there actually exists fewer messages in the file (status valid), or certain
	 * messages are getting parsing error (status invalid).<br>
	 * If no more newer message can be retrieved, this will return
	 * a valid empty list in the result set.
	 * If current file is being overwritten while reading, status set to invalid in result set.
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws UnsupportedFormatException Formatter type not supported by Log Viewer
	 * @throws FileNotFoundException Output file not found
	 * @throws SecurityException  Access to output file denied
	 * @throws IOException Problem reading data from output file
	 * @see LoggingResultSet
	 * @see FileLog.LogRecordResultSet
	 */
	public ILoggingResultSet readNextMsgRecords(int numberOfRecords)
										throws IllegalArgumentException, UnsupportedFormatException, FileNotFoundException, 
											   SecurityException, IOException
	{
		LogRecordResultSet resultSet;
		File checkIfFileExists = new File(source.getSource());
        if (isTimeFilterSet && checkIfFileExists.exists() && checkIfFileExists.isFile()) {		
            try {
                resultSet = new LogRecordResultSet();
                if (willItBeFirstReadAfterTimeFilterWasApplied) {
                	if (setStartBookmarks() == false) {
                		throw new Exception("Failed to set start bookmark for time filter. See traces for exact exception.");                        
                	}
                    if (this.startFileBookmark == -1 || this.startFileSetIndex == -1) {
                        return new LogRecordResultSet();
                    } else {
                        source.setIndex(this.startFileSetIndex);
                        source.close();
                        source.open();
                        source.setBookMark(this.startFileBookmark);
                        ILoggingResultSet rSet = source.readNext();
                        LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                        if (aMessage.getTime().getTime() <= end) {
                            resultSet.add(aMessage);
                        } else {
                            LogRecordResultSet runt = new LogRecordResultSet();
                            runt.setStatus(LogRecordResultSet.INVALID);
                            runt.setException(new Exception("Incorrectly set time filter in Logging API"));
                            return runt;
                        }
                    }
                    willItBeFirstReadAfterTimeFilterWasApplied = false;
                }
                    
                ILoggingResultSet rSet = null;
                while (resultSet.getSize() < numberOfRecords) {
                    rSet = source.readNext();
                    if (rSet.getSize() == 0) {
                        break;
                    }
                    LogRecord aMessage = (LogRecord)rSet.getResults().get(0);
                    if (aMessage.getTime().getTime() <= end) {
                        resultSet.add(aMessage);
                    } else {
                    	break;
                    }
                }
                return resultSet;
                
            } catch (Exception e) {
                resultSet = new LogRecordResultSet();
                resultSet.setStatus(LogRecordResultSet.INVALID);
                resultSet.setException(e);
            }
        } else {        
		if(!source.isOpened()) { //readOldest or readLatest have never been called/with error
			resultSet = (LogRecordResultSet) readOldestMsgRecords(numberOfRecords);
		}
		else {
			try {
				resultSet = (LogRecordResultSet) source.readNext(numberOfRecords);
			}
			catch (Exception ex) {
				resultSet = new LogRecordResultSet();
				resultSet.setStatus(LogRecordResultSet.INVALID);
				resultSet.setException(ex);
			}
		}
        }
		
		/*System.out.println("Call: " 	  + ++grabCounter);
		System.out.println("Source: " 	  + getPath());
		System.out.println("Method: " 	+ "NEXT - readNextMsgRecords()");
		if (resultSet.getResults().isEmpty()) {
			System.out.println("Message: NONE"); 
			System.out.println("Status: " + resultSet.isValid());
			grabCounter = 0;
		}
		else {
			currentMSG = ((LogRecord)resultSet.getResults().get(0)).getId().toString();
			if (latestMSG != null && latestMSG.equalsIgnoreCase(currentMSG)) {
				System.out.println("UPPPSSS!");
			}
			latestMSG = currentMSG;
			System.out.println("Message id: " + currentMSG);
			System.out.println("Message text: " + ((LogRecord)resultSet.getResults().get(0)).getMsgClear());
			System.out.println("Message bookmark: " + ((LogRecord)resultSet.getResults().get(0)).getBookMark());
		}*/
		
		return resultSet;
	}

	/**
	 * This method returns LoggingResultSet
	 * that contains one or zero LogRecords.
	 * If the search is successful, there will be one LogRecord.
	 * If not, there will be zero records.
	 * It takes an array of strings that need to be searched.
	 * For now, the first string in the array  is the only one to be searched for (August 8, 2003).
	 * In future, searching for multiple strings will be supported.
 	 * @param searchTokens
   * @return A LoggingResultSet of matching LogRecord.
   * @throws IllegalArgumentException
   * @throws UnsupportedFormatException
   * @throws IOException
   */
	
	public ILoggingResultSet getNextMatch(String[] searchTokens)
																						throws IllegalArgumentException, 
																									 UnsupportedFormatException, 
																									 FileNotFoundException, 
																									 SecurityException, 
																								 IOException
  {
		return getNextMatch(searchTokens, false);
	}

	
	/**
	 * This method returns LoggingResultSet
	 * that contains one or zero LogRecords.
	 * If the search is successful, there will be one LogRecord.
	 * If not, there will be zero records.
	 * It takes an array of strings that need to be searched.
	 * For now, the first string in the array  is the only one to be searched for (August 8, 2003).
	 * In future, searching for multiple strings will be supported.
	 * If ignoreCase is true, it will search for the searchTokens without  paying attention to case.
	 * @param searchTokens
	 * @param ignoreCase
	 * @return A LoggingResultSet of matching LogRecord.
	 * @throws IllegalArgumentException
	 * @throws UnsupportedFormatException
	 * @throws IOException
	 */
	
	public ILoggingResultSet getNextMatch(String[] searchTokens, 
																			 boolean 	ignoreCase)
																					throws IllegalArgumentException, 
																								 UnsupportedFormatException, 
																								 FileNotFoundException, 
																								 SecurityException, 
																							 IOException
	{
		LogRecordResultSet resultSet;
	
		try {
			// Guardian...
			if (searchTokens == null || searchTokens.length == 0) {
				throw new IllegalArgumentException("Conditional string is null or it is empty!");
			} 
			
			if (!source.isOpened()) { // First read ... very ugly
				source.open();
				source.moveToBOF();
			}
			
			IFilter filter = new FileReadFilter(searchTokens, FileReadFilter.LOG_OPERATER_OR, !ignoreCase);
			
			source.addFilter(filter);
			resultSet = (LogRecordResultSet) source.readNext();
			source.removeFilter(filter);
		}
		catch (Exception ex) {
			resultSet = new LogRecordResultSet();
			resultSet.setStatus(LogRecordResultSet.INVALID);
			resultSet.setException(ex);
		}
		return resultSet;
	}

		
	/**
	 * This method returns LoggingResultSet
	 * that contains one or zero LogRecords.
	 * If the search is successful, there will be one LogRecord.
	 * If not, there will be zero records.
	 * It takes an array of strings that need to be searched.
	 * For now, the first string in the array  is the only one to be searched for (August 8, 2003).
	 * In future, searching for multiple strings will be supported.
	 * @param searchTokens
	 * @return A LoggingResultSet of matching LogRecord.
	 * @throws IllegalArgumentException
	 * @throws UnsupportedFormatException
	 * @throws IOException
	 */
	public ILoggingResultSet getPreviousMatch(String[] searchTokens)
																							throws IllegalArgumentException, 
																										 UnsupportedFormatException, 
																										 FileNotFoundException, 
																										 SecurityException, 
																									 IOException
	{
		return getPreviousMatch(searchTokens, false);
	}
	/**
	 * This method returns LoggingResultSet
	 * that contains one or zero LogRecords.
	 * If the search is successful, there will be one LogRecord.
	 * If not, there will be zero records.
	 * It takes an array of strings that need to be searched.
	 * For now, the first string in the array  is the only one to be searched for (August 8, 2003).
	 * In future, searching for multiple strings will be supported.
	 * If ignoreCase is true, it will search for the searchTokens without  paying attention to case.
	 * @param searchTokens
	 * @param ignoreCase
	 * @return A LoggingResultSet of matching LogRecord.
	 * @throws IllegalArgumentException
	 * @throws UnsupportedFormatException
	 * @throws IOException
	 */
	public ILoggingResultSet getPreviousMatch(String[] searchTokens, 
																					 boolean 	ignoreCase)
																						throws 	IllegalArgumentException, 
																									 	UnsupportedFormatException, 
																									 	FileNotFoundException, 
																									 	SecurityException, 
																								 		IOException
	{
		LogRecordResultSet resultSet;
	
		try {
			// Guardian...
			if (searchTokens == null || searchTokens.length == 0) {
				throw new IllegalArgumentException("Conditional string is null or it is empty!");
			} 
			
			if (!source.isOpened()) { // First read ... very ugly
				source.open();
				source.moveToEOF();
			}
			
			IFilter filter = new FileReadFilter(searchTokens, FileReadFilter.LOG_OPERATER_OR, !ignoreCase);
			
			source.addFilter(filter);
			resultSet = (LogRecordResultSet) source.readPrevious();
			source.removeFilter(filter);
		}
		catch (Exception ex) {
			resultSet = new LogRecordResultSet();
			resultSet.setStatus(LogRecordResultSet.INVALID);
			resultSet.setException(ex);
		}
		return resultSet;
	}

		
	/**
	 * This method verifies whether the attributes
	 * like severity can be set.
	 * @return boolean true if the attributes can be set and false otherwise.
	 */
	public boolean areLoggingAttributesEditable() {
		Collection existingLogs = LoggingManager.getLoggingManager().getAllLogs();
		return existingLogs.contains(this);
	}

	/**
	 * This method returns the name of the file that is being currently read.
	 * If the file name is empty, it tries to locate the oldest file.
	 * It does not check whether or not the file really exists.
	 * @return The name of the file currently being read.
	 */
	public String getFileBeingCurrentlyRead()
	{
		return source.getSource();
	}
	
	/**
	 * This returns the file pointer.
	 * @return -1 if currentFileReader equals null or current file pointer if currentFileReader exists.
	 * @throws IOException
	 */
	public long getFilePointer() throws IOException
	{
		try {
			return source.getBookMark();
		}
		catch (DataException ex) {
			throw new IOException(ex.getMessage());
		}
		
	}
	
	/**
	 * Tries to set the file pointer specified by the parameter.
	 * If currentFileReader is null, it throws RuntimeException.
	 * @param filePointer
	 * @throws IOException
	 */
	public void seek(long filePointer)
			  throws IOException
	{
		try {
			source.seek(filePointer);
		}
		catch (Exception ex) {
		}
	}

	public long getLastModified() throws IOException
	{	
		long result = 0;
		
		try {
			result = ((IFileSetLog)source).getFileLatest().lastModified();	
		}
		catch(Exception ex) {
			result = -1;
		}
		return result;
	}

	public int status() {
		return source.status();
	}

	/**
   * Closes output of this log object.
   */
	public synchronized void open() {
		try {
			source.open();
		}
		catch (Exception ex) {
			tracer.traceThrowableT(Severity.WARNING, MSGCollection.LOGGING_MSG_STR_OPEN_EXCEPTION, new String[] {this.getName()}, ex);
		}
  }

	/**
   * Closes output of this log object.
   */
	public synchronized void close() {
		try {
			if (source != null) {
				source.close();
			}
		}
		catch (Exception ex) {
			tracer.traceThrowableT(Severity.WARNING, MSGCollection.LOGGING_MSG_STR_CLOSE_EXCEPTION, new String[] {this.getName()}, ex);			
		}
  }
	
  /**
   * Sets the formatter that dictates the format of log records in this log.
   * 
   * Note: If you send a null like argument the default 
   * formater (ListFormatter), will be created. 
 	 * 
   * @return Formatter
   * @see    #getFormatter()
   */

  public synchronized void setFormatter(Formatter formatter) {
		if (source != null) {
			try {
				source.setFormatter(formatter);
			}
			catch (Exception ex) {
				// Changing Formatter on already open log desn't make sence!!
				ReaderLogger.instrumentIntByAPI(subLoc + "[setFormatter(Formatter formatter)]", 
						 MSGCollection.FORMATTER_CHANGED_ON_OPEN_LOG(),
						 new Object[] {this.getName()});
				// Close read log
				close(); 
			}
		}
  	setFormatterInt(formatter);
  }
	
	//==== < public ==================================== protected > ====
	
  protected Object clone() throws CloneNotSupportedException {
	  return super.clone();
  }
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private =============================== private class > ====
	
	class LogEventsListener implements LogEvents
	{
		/**
	   * @see com.sap.tc.logging.LogEvents#eventLogIsClosed(com.sap.tc.logging.interfaces.IBaseLog)
	   */
	  public void eventLogIsClosed(IBaseLog log) {
	  	
	  }

	  /**
	   * @see com.sap.tc.logging.LogEvents#eventLogIsOpen(com.sap.tc.logging.interfaces.IBaseLog)
	   */
	  public void eventLogIsOpen(IBaseLog log) {
			FileReadLog readLog = (FileReadLog)log;
			
			setName				(readLog.getSource());
			setDescription(readLog.getDescription());
			
			setPattern		(readLog.getPattern());
			setFormatter  (readLog.getFormatter());
			
			setCnt				(readLog.getSize());
			setLimit			(readLog.getLimit());
			setIndex			(readLog.getIndex());
		
			setEncoding		(readLog.getEncoding());
		
			setMode				(readLog.getMode());
			setStatus			(readLog.status());
		
			setFooter			(readLog.getFooter());
			setHeader			(readLog.getHeader());
	  }
	}
	
	//==== < private ================================== deprecated > ====
	
	/**
	 * <p>
	 * Retrieve the latest n messages and return them in an array list. This method
	 * always refers to the newest messages even the output file is growing. </p>
	 *
	 * @param numMsg Number of messages (>0) to be retrieved
	 * @return Each retrieved message packed in an array list.
	 * @exception UnsupportedFormatException
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws IOException Problem reading data from output file
	 * @deprecated Resulting logrecords do not indicate status which is not good
	 *      enough for complicated scenario like logfile rotation. It will kept
	 *      around for a while, but will be eventually replaced by {@link
	 *      #readLatestMsgRecords(int)}.
	 */
	public ArrayList readLatestRecords(int numMsg)
								throws IllegalArgumentException, UnsupportedFormatException, IOException {
		return (ArrayList)readLatestMsgRecords(numMsg).getResults();
	}

	/**
	 * <p>
	 * Retrieve the oldest n messages and return them in an array list. This method
	 * always refers to the currently available oldest messages which may be
	 * different due to the rotating feature(not covered at this stage) from the
	 * constantly growing output file size. <br>
	 * </p>
	 *
	 * @param numMsg Number of messages (>0) to be retrieved
	 * @return Each retrieved messages packed in an array list.
	 * @exception UnsupportedFormatException
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws IOException Problem reading data from output file
	 * @deprecated Resulting logrecords do not indicate status which is not good
	 *      enough for complicated scenario like logfile rotation. It will kept
	 *      around for a while, but will be eventually replaced by {@link
	 *      #readOldestMsgRecords(int)}.
	 */
	public ArrayList readOldestRecords(int numMsg)
								throws IllegalArgumentException, UnsupportedFormatException, IOException {
		return (ArrayList)readOldestMsgRecords(numMsg).getResults();
	}

	/**
	 * <p>
	 * Continue retrieving x relatively older messages, picked from the point where
	 * the last message read from the previous read operation, with respective to
	 * the direction of the previous read operation. </p> <p>
	 *
	 * If this method is called without a prior call to {@link
	 * #readLatestRecords(int)} or {@link #readOldestRecords(int)}, this will
	 * behave the same as calling <code> readLatestRecords(numMsg) </code>.<br>
	 * Messages are returned in an array list. </p>
	 *
	 * @param numMsg Number of messages(>0) to be retrieved
	 * @return Each retrieved messages packed in an array list.
	 * @exception UnsupportedFormatException
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws IOException Problem reading data from output file
	 * @deprecated Resulting logrecords do not indicate status which is not good
	 *      enough for complicated scenario like logfile rotation. It will kept
	 *      around for a while, but will be eventually replaced by {@link
	 *      #readPrevMsgRecords(int)}.
	 */
	public ArrayList readPrevRecords(int numMsg)
							  throws IllegalArgumentException, UnsupportedFormatException, IOException {
		return (ArrayList)readPrevMsgRecords(numMsg).getResults();                            	
  }

	/**
	 * <p>
	 * Continue retrieving x relatively newer messages, picked from the point where
	 * the last message read from the previous read operation, with respective to
	 * the direction of the previous read operation. </p> <p>
	 *
	 * If this method is called without a prior call to {@link
	 * #readLatestRecords(int)} or {@link #readOldestRecords(int)}, this will
	 * behave the same as calling <code> readOldestRecords(numMsg) </code>.<br>
	 * Messages are returned in an array list. </p>
	 *
	 * @param numMsg Number of messages(>0) to be retrieved
	 * @return Each retrieved messages packed in an array list.
	 * @exception UnsupportedFormatException
	 * @throws IllegalArgumentException Negative number or zero messages requested
	 * @throws IOException Problem reading data from output file
	 * @deprecated Resulting logrecords do not indicate status which is not good
	 *      enough for complicated scenario like logfile rotation. It will kept
	 *      around for a while, but will be eventually replaced by {@link
	 *      #readNextMsgRecords(int)}.
	 */
	public ArrayList readNextRecords(int numMsg)
							  throws IllegalArgumentException, UnsupportedFormatException, IOException {
		return (ArrayList)readNextMsgRecords(numMsg).getResults();
  }
  
  /**
	 * @deprecated Use getFileLenght()
	 */
	public long length()
	{
	  return getFileLength();
	}

}
