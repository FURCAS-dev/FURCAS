package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2001
 * Company:      SAPMarkets, Inc.
 *               Palo Alto, California, 94303, U.S.A.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAPMarkets.
 * @version      $Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/TraceFormatter.java#17 $
 */

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Formats log records as readable lines.
 */
public class TraceFormatter extends Formatter {

  static String version = "$Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/TraceFormatter.java#17 $";

  /**
   * Configures this trace formatter with the standard formatting pattern
   * <code>"%24d %-40l [%t] %s: %m"</code>.
   * @see    #TraceFormatter(java.lang.String)
   */
  public TraceFormatter() {
    super();
    setPattern(STANDARD_PATTERN);
  }

  /**
   * Configures this trace formatter with a custom formatting pattern.
   * For a description of these patterns please refer to
   * {@link #setPattern(java.lang.String)}.
   * @param  pattern Formatting pattern
   * @see    #TraceFormatter()
   */
  public TraceFormatter(String pattern) {
    super(FormatterType.TRACEFORMAT);
    setPattern(pattern);
  }

      /**
   * Determine if the message string reaches the valid end(delimiter) of a
   * complete message record, according to the format defined by the formatter
   */
  public boolean isCompleteMessage(String msg){
    return true;
  }

/**
   * Return true if this formatter supports message parsing formatted with this
   * formatter. Otherwise, return false.
   * See method {@link #parseMsg(String)}.
   */
  public boolean isParsable(){
    return true;
  }

  /**
   * Determine if the message string has a valid start of message record
   */
  public boolean isStartMessage(String msg){
    return true;
  }

  /**
   * <p>Message written with the specific formatter is read as plain string. This
   * method parses the content and massages the data into appropriate fields,
   * into a LogRecord structure.</p>
   * <p>NOTE: UPDATE this method when newer version of format is defined by the
   * formatter.</p>
   * @param A complete message body and its admin data that can span across
   * multiple lines
   * @return The complete message with its admin data has been broken down and
   * packed in {@link LogRecord}. Return Null if formatter does not support
   * parsing.
   */
  public LogRecord parseMsg(String completeMsgData)  throws ParseException{
    return new LogRecord(new Location("UNKNOWN"), null, 0, null, 0, completeMsgData, null);
  }
  
  public LogRecord parseMsg(byte[] msgChunk) throws ParseException {
  	String completeMsgData = "";
  	if (msgChunk != null && msgChunk.length > 0) {
			completeMsgData = new String(msgChunk);
  	}
		return new LogRecord(new Location("UNKNOWN"), null, 0, null, 0, completeMsgData, null);
  }
  
  /**
   * Gets the current formatting pattern of this formatter.
   * @return Formatting pattern
   * @see    #setPattern(java.lang.String)
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * <p>
   *   Configures this trace formatter with a custom formatting pattern.
   *   The pattern allows you to specify the message data fields, with place
   *   holders of the form
   *   <code>"%</code>[[<code>-</code>]&lt;<i>width</i>&gt;[<code>-</code>]]&lt;<i>type</i>&gt;<code>"</code>,
   *   interspersed with arbitrary text, that you want to have included in
   *   formatted messages.
   * </p>
   * <p>
   *   If you put a dash in front of the &lt;<i>width</i>&gt; of the field to be
   *   printed, which is a positive integral number, the field is aligned on the
   *   right, in case of a trailing dash it is aligned on the left. If you flank
   *   &lt;<i>width</i>&gt; with dashes on both sides, you get a centered field.
   *   If you omit the alignment, the field is left-aligned. The
   *   &lt;<i>type</i>&gt; that specifies the field can be one of
   *   <ul>
   *     <li><code>i</code> the message identification</li>
   *     <li><code>p</code> the time stamp in milliseconds since January 1, 1970
   *                        00:00:00 GMT</li>
   *     <li><code>d</code> the time stamp in readable form</li>
   *     <li><code>c</code> the log controller the message was issued
   *                        through</li>
   *     <li><code>a</code> the application on behalf of which the message was
   *                        issued</li>
   *     <li><code>l</code> the location of origin</li>
   *     <li><code>u</code> the user on behalf of which the message was issued
   *                        </li>
   *     <li><code>S</code> the session on behalf of which the message was
   *                        issued</li>
   *     <li><code>T</code> the transaction on behalf of which the message was
   *                        issued</li>
   *     <li><code>o</code> the DSR (Distributed Statistics Record) component on
   *                        behalf of which the message was issued
   *                        </li>
   *     <li><code>e</code> the DSR (Distributed Statistics Record) user on
   *                        behalf of which the message was issued
   *                        </li>
   *     <li><code>r</code> the DSR (Distributed Statistics Record) transaction
   *                        on behalf of which the message was issued
   *                        </li>
   *     <li><code>t</code> the thread that emitted the message</li>
   *     <li><code>g</code> the group indentation</li>
   *     <li><code>s</code> the message severity</li>
   *     <li><code>m</code> the formatted message text</li>
   *   </ul>
   *   To print a single <code>%</code>, insert a <code>%%</code>. With group
   *   indentation, width is interpreted as the indentation for each level with
   *   a standard value of <code>1</code>, and alignment is ignored. As an
   *   example, the standard pattern <code>"%24d %-40l [%t] %s: %m"</code>
   *   lets the trace formatter print the date and time of the message in a
   *   24-character column aligned to the left, followed by the right-aligned
   *   location truncated from the left to 40 characters, the thread name in
   *   brackets, and finally the severity name and the formatted message text
   *   separated with a colon. A typical message would then look like this:
   *   <blockquote>
   *     <pre>
   *May 11, 2001 11:17:42 AM ...g.TraceFormatterTest.testStdPattern() [main] Info: test standard pattern</pre>
   *   </blockquote>
   *   Place holders that do not match the above syntax are printed as is.
   * </p>
   * @param  pattern Formatting pattern
   * @see    #getPattern()
   */
  public synchronized void setPattern(String pattern) {
    int          len = pattern.length(),
                 i = 0,
                 cnt = 0;
    final int    initCnt = (len / 3 + 1) * 2;
    int[]        type  = new int[initCnt],
                 width = new int[initCnt],
                 align = new int[initCnt];
    String[]     text  = new String[initCnt];
    StringBuffer buf = new StringBuffer(len);

    this.pattern = pattern;
    while (i < len) {
      if (pattern.charAt(i) == '%') {
        int     begin              = i,
                widthBegin         = i;
        boolean processed          = false,
                widthFound         = false,
                widthProcessed     = true,
                alignmentFound     = false,
                alignmentMarkFound = false;

        align[cnt] = MIN;
        ++i;
        while (   !processed
               && i < len) {
          if (!Character.isDigit(pattern.charAt(i))) {
            if (!widthProcessed) {
              width[cnt] = Integer.parseInt(pattern.substring(widthBegin,
                                                              i));
              widthProcessed = true;
            }
            if (pattern.charAt(i) == '-') {
              if (!widthFound) {
                if (!alignmentMarkFound) {
                  align[cnt] = RIGHT;
                } else {
                  // Syntax error: stop parsing and ignore place holder
                  break;
                }
              } else {
                if (!alignmentMarkFound) {
                  if (alignmentFound) {
                    align[cnt] = CENTER;
                  } else {
                    align[cnt] = LEFT;
                  }
                } else {
                  // Syntax error: stop parsing and ignore place holder
                  break;
                }
              }
              alignmentMarkFound = true;
              alignmentFound = true;
            } else if (   pattern.charAt(i) == 'i'
                       || pattern.charAt(i) == 'p'
                       || pattern.charAt(i) == 'd'
                       || pattern.charAt(i) == 'c'
                       || pattern.charAt(i) == 'a'
                       || pattern.charAt(i) == 'l'
                       || pattern.charAt(i) == 'u'
                       || pattern.charAt(i) == 'S'
                       || pattern.charAt(i) == 'T'
                       || pattern.charAt(i) == 't'
                       || pattern.charAt(i) == 'g'
                       || pattern.charAt(i) == 's'
                       || pattern.charAt(i) == 'm'
                       || pattern.charAt(i) == 'z'                           
                       || pattern.charAt(i) == 'M'
                       || pattern.charAt(i) == 'C'
                       || pattern.charAt(i) == 'D'
                       || pattern.charAt(i) == 'o'                           
                       || pattern.charAt(i) == 'n'                           
                       || pattern.charAt(i) == 'U'                           
                       || pattern.charAt(i) == 'e'                           
                       || pattern.charAt(i) == 'r'                           
                       ) {
              if (   alignmentFound
                  && !widthFound) {
                // Syntax error: stop parsing and ignore place holder
                break;
              }
              switch (pattern.charAt(i)) {
                case 'i': {
                  type[cnt] = GUID;
                  break;
                }
                case 'p': {
                  type[cnt] = STAMP;
                  break;
                }
                case 'd': {
                  type[cnt] = DATE;
                  break;
                }
                case 'z': {
                  type[cnt] = TIME_ZONE;
                  break;
                }
                case 'M': {
                  type[cnt] = MESSAGE_CODE;
                  break;
                }
                case 'C': {
                  type[cnt] = CSN_COMPONENT;
                  break;
                }
                case 'D': {
                  type[cnt] = DC_NAME;
                  break;
                }
                case 'o': {
                  type[cnt] = CORRELATION_ID;
                  break;
                }
                case 'c': {
                  type[cnt] = SOURCE;
                  break;
                }
                case 'a': {
                  type[cnt] = APPLICATION;
                  break;
                }
                case 'l': {
                  type[cnt] = LOC;
                  break;
                }
                case 'u': {
                  type[cnt] = USER;
                  break;
                }
                case 'S': {
                  type[cnt] = SESSION;
                  break;
                }
                case 'T': {
                  type[cnt] = TRANSACTION;
                  break;
                }
                case 'e': {
                  type[cnt] = DSR_ROOT_CONTEXT_ID;
                  break;
                }
                case 'r': {
                  type[cnt] = DSR_TRANSACTION;
                  break;
                }
                case 'n': {
                  type[cnt] = DSR_CONNECTION;
                  break;
                }
                case 'U': {
                  type[cnt] = DSR_COUNTER;
                  break;
                }
                case 't': {
                  type[cnt] = THREAD;
                  break;
                }
                case 's': {
                  type[cnt] = SEVERITY;
                  break;
                }
                case 'm': {
                  type[cnt] = MESSAGE;
                  break;
                }
              }
              processed = true;
            } else if (   !alignmentFound
                       && !widthFound
                       && pattern.charAt(i) == '%') {
              type[cnt] = TEXT;
              buf.append('%');
              processed = true;
            } else {
              // Syntax error: stop parsing and ignore place holder
              break;
            }
          } else { // if (Character.isDigit(pattern.charAt(i)))
            if (!widthFound) {
              widthFound = true;
              if (!alignmentFound) {
                align[cnt] = LEFT;
              }
              widthProcessed = false;
              widthBegin = i;
              alignmentMarkFound = false;
            }
          }
          ++i;
          if (i >= len) {
            // Syntax error: stop parsing and ignore place holder
            break;
          }
        }
        if (processed) {
          if (type[cnt] != TEXT) {
            if (buf.length() > 0) {
              type [cnt + 1] = type [cnt];
              width[cnt + 1] = width[cnt];
              align[cnt + 1] = align[cnt];
              type [cnt] = TEXT;
              text [cnt] = buf.toString();
              align[cnt] = MIN;
              buf.setLength(0);
              cnt += 2;
            } else {
              ++cnt;
            }
          }
        } else {
          buf.append(pattern.substring(begin,
                                       i));
        }
      } else {
        buf.append(pattern.charAt(i));
        ++i;
      }
    }
    if (buf.length() > 0) {
      type [cnt] = TEXT;
      text [cnt] = buf.toString();
      align[cnt] = MIN;
      ++cnt;
    }

    this.type  = new int[cnt];
    for (i = 0;
         i < cnt;
         ++i) {
      this.type[i] = type[i];
    }
    this.text  = new String[cnt];
    for (i = 0;
         i < cnt;
         ++i) {
      this.text[i] = text[i];
    }
    this.width = new int[cnt];
    for (i = 0;
         i < cnt;
         ++i) {
      this.width[i] = width[i];
    }
    this.align = new int[cnt];
    for (i = 0;
         i < cnt;
         ++i) {
      this.align[i] = align[i];
    }
  }

  public synchronized String format(LogRecord rec) {
    for (int i = 0; i < type.length; ++i) {
      switch (type[i]) {
        case GUID: {
          text[i] = rec.getId().toString();
          break;
        } case STAMP: {
          text[i] = Long.toString(rec.getTime().getTime());
          break;
        } case DATE: {
          text[i] = rec.getTimeString();
          break;
        } case TIME_ZONE: {
          text[i] = rec.getTimeZone();
          break;
        } case MESSAGE_CODE: {
          text[i] = rec.getMsgCode();
          break;
        } case CSN_COMPONENT: {
          text[i] = rec.getCsnComponent();
          break;
        } case DC_NAME: {
          text[i] = rec.getDCName();
          break;
        } case CORRELATION_ID: {
          text[i] = (rec.getCorrelatorID() == UID.EMPTY_CORRELATOR_ID) ? "" : ""+rec.getCorrelatorID();
          break;
        } case SOURCE: {
          text[i] = rec.getSourceName();
          break;
        } case APPLICATION: {
          text[i] = rec.getApplication();
          break;
        } case LOC: {
          text[i] = rec.getLocationName();
          break;
        } case USER: {
          text[i] = rec.getUser();
          break;
        } case SESSION: {
          text[i] = rec.getSession();
          break;
        } case TRANSACTION: {
          text[i] = rec.getTransaction();
          break;
        } case DSR_ROOT_CONTEXT_ID: {
          text[i] = rec.getDSRRootContextID();
          break;
        } case DSR_TRANSACTION: {
          text[i] = rec.getDSRTransactionID();
          break;
        } case DSR_CONNECTION: {
          text[i] = rec.getDSRConnection();
          break;
        } case DSR_COUNTER: {
          text[i] = (rec.getDSRCounter() == -1) ? "" : ""+rec.getDSRCounter();            
          break;
        } case THREAD: {
          text[i] = rec.getThreadName();
          break;
        } case SEVERITY: {
          text[i] = Severity.toString(rec.getSeverity());
          break;
        } case MESSAGE: {
          switch (rec.getMsgType()) {
            case MsgType.PLAIN: {
              text[i] = rec.getMsgClear();
              break;
            } case MsgType.JAVA : {//YUE
              try{
            	  String msgClear = rec.getMsgClear();
            	  if (rec.getNonExceptionArgsCount() < rec.getArgObjs().size()) {
                  	// the last argument of record is an exception comming from
                  	// traceThrowableT - it should be replaced with the last
                  	// available placeholder - the one after the [EXCEPTION] pointer
            		msgClear = LogController.replaceException(rec, msgClear);
                  	
                  	// create a reduced argument list without the exception argument
                  	List<Object> reducedArgumentList = new ArrayList<Object>(rec.getArgObjs());
                  	reducedArgumentList.remove(rec.getArgsInt().length - 1);
                  	text[i] = LogController.replaceArguments(msgClear, reducedArgumentList.toArray());
                  } else {
                  	// no exceptions comming from traceThrowableT in argument list
                  	// process normally - just replace arguments
                	text[i] = LogController.replaceArguments(msgClear, rec.getArgsInt());
                  }
              } catch(IllegalArgumentException e){
                text[i] = rec.getMsgClear();     //ignore, and use msgClear with placeholders
            		/*Category.SYS_LOGGING.errorT(classLoc,
                                            "format(LogRecord)",
                                            INVALID_MSG_PATTERN,
                                            new Object[] {rec.getMsgClear()});*/
              }
              break;
            }
          }
          break;
        } case TEXT: {
          // Nothing to be done
          break;
        } default: {
          // Should never happen
          break;
        }
      }
    }
    
    return align(text, width, align);
  }

  protected String align(String text[],
                         int    width[],
                         int    align[]) {
    if(   text.length != width.length
       || width.length != align.length) {
      throw new IllegalArgumentException();
    }

    StringBuffer res = new StringBuffer(INITIAL_CAPACITY);

    for (int i = 0;
         i < text.length;
         ++i) {
      if (align[i] != SUPPRESS) {
        if (align[i] != MIN) {
          int fill = (width[i] - text[i].length() >= 0) ? width[i] - text[i].length()
                                                        : 0;

          switch (align[i]) {
            case LEFT: {
              if (fill >= 0) {
                res.append(text[i]);
                for (int j = 0;
                     j < fill;
                     ++j) {
                  res.append(' ');
                }
              } else {
                if (width[i] > 3) {
                  res.append(text[i].substring(0,
                                               width[i] - 3));
                  res.append("...");
                } else {
                  res.append(text[i].substring(0,
                                               width[i]));
                }
              }
              break;
            }
            case CENTER: {
              if (fill >= 0) {
                for (int j = 0;
                     j < (int) fill / 2;
                     ++j) {
                  res.append(' ');
                }
                res.append(text[i]);
                for (int j = 0;
                     j < (int) fill / 2 + (int) fill % 2;
                     ++j) {
                  res.append(' ');
                }
              } else {
                if (width[i] > 3) {
                  res.append(text[i].substring(0,
                                               width[i] - 3));
                  res.append("...");
                } else {
                  res.append(text[i].substring(0,
                                               width[i]));
                }
              }
              break;
            }
            case RIGHT: {
              if (fill >= 0) {
                for (int j = 0;
                     j < fill;
                     ++j) {
                  res.append(' ');
                }
                res.append(text[i]);
              } else {
                if (width[i] > 3) {
                  res.append("...");
                  res.append(text[i].substring(  text[i].length()
                                               - (width[i] - 3)));
                } else {
                  res.append(text[i].substring(  text[i].length()
                                               - width[i]));
                }
              }
              break;
            }
          }
        } else {
          res.append(text[i]);
        }
      }
    }
    res.append(EOL);

    return res.toString();
  }

  private String pattern;

  private int    type[],
                 width[],
                 align[];
  private String text[];

  private static final String STANDARD_PATTERN = "%24d %-40l [%t] %s: %m";

  private static final char   ALIGN_CHAR         = '|';
  private static final int    ALIGN_CHAR_PERIOD  = 3;
  private static final String OPEN_GROUP_STRING  = "-->",
                              CLOSE_GROUP_STRING = "<--";

  private static final DateFormat timeFormatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
                                                                                 DateFormat.MEDIUM,
                                                                                 Locale.US);
  private static final int GUID                = 0,
                           STAMP               = 1,
                           DATE                = 2,
                           TIME_ZONE           = 3,
                           MESSAGE_CODE        = 4,
                           CSN_COMPONENT       = 5,
                           DC_NAME             = 6,
                           CORRELATION_ID      = 7,
                           SOURCE              = 8,
                           APPLICATION         = 9,
                           LOC                 = 10,
                           USER                = 11,
                           SESSION             = 12,
                           TRANSACTION         = 13,
                           DSR_ROOT_CONTEXT_ID = 14,
                           DSR_TRANSACTION     = 15,
                           DSR_CONNECTION      = 16,
                           DSR_COUNTER         = 17,
                           THREAD              = 18,
                           SEVERITY            = 19,
                           MESSAGE             = 20,
                           TEXT                = 21;

  protected static final int MIN      = 0,
                             LEFT     = 1,
                             RIGHT    = 2,
                             CENTER   = 3,
                             SUPPRESS = 4;

  private final static int INITIAL_CAPACITY = 512;

  protected static final String INVALID_MSG_PATTERN    = "Invalid message pattern: {0}";

}