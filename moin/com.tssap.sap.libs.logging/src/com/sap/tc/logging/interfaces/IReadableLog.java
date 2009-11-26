package com.sap.tc.logging.interfaces;

/*
 *  Copyright:   Copyright (c) 2002
 *
 *  Company:     SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @version $Id:#19 $
 */

import java.io.*;
import java.util.*;

import com.sap.tc.logging.exceptions.*;
import com.sap.tc.logging.messagedepot.*;

/**
 * Defines common operations to read log messages (a message record) from a log
 * destination. Currently, this mainly handles sequential records retrieval
 * starting either from the oldest or latest time point. To avoid messing up the
 * sequential reading from concurrent readers on the same log destination, it is
 * recommended to get a copy of this 'readable' log for each reader.
 */
public interface 	IReadableLog 
			 extends 		IFileLog
{
    /**
     * Return an id for the corresponding Log that is unique
     *
     * @return The logId value
     */
    public String getLogId();

    /**
     * Create a copy(clone) of this readable log, and thus the cursor to retrieve
     * message records for each reader will be independent. This can avoid messing
     * up the sequential reading pointers from potential concurrent readers.
     *
     * @return A copy of this readable log that contains mainly cursor actions.
     */
    public IReadableLog createReadableLog();
    
    public IReadableLog createReadableLog(MessageAccessor messageAccessor);

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
                                throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
                                throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
                              throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
                              throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
     * @see LoggingResultSet
     */
    public ILoggingResultSet readLatestMsgRecords(int numMsg)
                                          throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
     * @see LoggingResultSet
     */
    public ILoggingResultSet readOldestMsgRecords(int numMsg)
                                          throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
     */
    public ILoggingResultSet readPrevMsgRecords(int numMsg)
                                        throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
     */
    public ILoggingResultSet readNextMsgRecords(int numMsg)
                                        throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
                                  throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
                                      throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
    public ILoggingResultSet getNextMatch(String[] searchTokens, boolean ignoreCase)
                                  throws IllegalArgumentException, UnsupportedFormatException, IOException;

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
    public ILoggingResultSet getPreviousMatch(String[] searchTokens, boolean ignoreCase)
                                      throws IllegalArgumentException, UnsupportedFormatException, IOException;

		/**
		 * This method verifies whether the attributes
		 * like severity can be set.
		 * @return boolean true if the attributes can be set and false otherwise.
		 */
    public boolean areLoggingAttributesEditable();
    
		public long getLastModified() throws IOException;

    /**
     * Sets start and end time conditions for the log records retrieved with readLatestMsgRecords(int),
     * readNextMsgRecords(int), readOldestMsgRecords(int) and readPrevMsgRecords(int) methods.
     * Any subsequent invocations of these methods will take into account the time period
     * and will return log entries that conform to it. The default behaviour of the methods is
     * restored with resetTimeFilter() method.
     * 
     * @param start - time in milliseconds that will indicate the start point of
     *                the time filter which this method applies 
     * @param end - time in milliseconds that will indicate the end point of
     *              the time filter which this method applies 
     * @return true if the time filter was applied succesfully.
     *         
     */
    public boolean setTimeFilter(long start, long end);    

    /**
     * Resets current time filter if there is such applied.
     * 
     * @return true if the filter was removed, false otherwise.
     *         In both cases the behaviour of readLatestMsgRecords(int), readNextMsgRecords(int),
     *         readOldestMsgRecords(int) and readPrevMsgRecords(int) is the default one
     *         when there is no time confitions for the log records retrieved.  
     */    
    public boolean resetTimeFilter();
        
    public boolean isTimeFilterSet();
}