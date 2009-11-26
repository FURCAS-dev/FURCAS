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
 * @version      $Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/XMLFormatter.java#16 $
 */

import java.util.*;
import java.text.*;
import java.io.*;

//available since JDK1.4
//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.ParserConfigurationException;

/**
 * Formats log records as XML elements.
 */
public class XMLFormatter extends Formatter {

  static String version = "$Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/XMLFormatter.java#16 $";

  public XMLFormatter() {
    super();
  }

  public String format(LogRecord rec) {
    StringBuffer res = new StringBuffer(INITIAL_CAPACITY),
                 esc = new StringBuffer();

    res.append("  <record>");
    res.append(EOL);

    res.append("    <id>");
    res.append(rec.getId());
    res.append("</id>");
    res.append(EOL);

    res.append("    <time>");
    res.append(rec.getTime().getTime());
    res.append("</time>");
    res.append(EOL);

    res.append("    <source>");
		res.append(escape(rec.getSourceName(), esc));
    res.append("</source>");
    res.append(EOL);

    res.append("    <application>");
    res.append(escape(rec.getApplication(),
                      esc));
    res.append("</application>");
    res.append(EOL);

    res.append("    <location>");
    res.append(escape(rec.getLocationName(),
                      esc));
    res.append("</location>");
    res.append(EOL);

    res.append("    <user>");
    res.append(escape(rec.getUser(),
                      esc));
    res.append("</user>");
    res.append(EOL);

    res.append("    <session>");
    res.append(escape(rec.getSession(),
                      esc));
    res.append("</session>");
    res.append(EOL);

    res.append("    <transaction>");
    res.append(escape(rec.getTransaction(),
                      esc));
    res.append("</transaction>");
    res.append(EOL);

    res.append("    <dsr-component>");
    res.append(escape(rec.getDsrComponent(),
                      esc));
    res.append("</dsr-component>");
    res.append(EOL);

    res.append("    <dsr-user>");
    res.append(escape(rec.getDsrUser(),
                      esc));
    res.append("</dsr-user>");
    res.append(EOL);

    res.append("    <dsr-transaction>");
    res.append(escape(rec.getDsrTransaction(),
                      esc));
    res.append("</dsr-transaction>");
    res.append(EOL);

    res.append("    <thread>");
    res.append(escape(rec.getThreadName(),
                      esc));
    res.append("</thread>");
    res.append(EOL);

    if (rec.getGroupLevel() > 0) {
      res.append("    <group>");
      res.append(EOL);

      res.append("      <id>");
      res.append(rec.getGroupID());
      
      res.append("</id>");
      res.append(EOL);

      res.append("      <level>");
      res.append(rec.getGroupLevel());
      res.append("</level>");
      res.append(EOL);

      res.append("      <indent>");
      res.append(rec.getGroupIndent());
      res.append("</indent>");
      res.append(EOL);

      res.append("    </group>");
      res.append(EOL);
    }

    res.append("    <severity>");
    res.append(Severity.toString(rec.getSeverity()));
    res.append("</severity>");
    res.append(EOL);

    String[] relatives = rec.getRelativesInt();

    if (relatives != null && relatives.length > 0) {

      res.append("    <relatives>");
      res.append(EOL);

      for (int i = 0;
           i < relatives.length;
           ++i) {
        res.append("      <relative>");
        res.append(escape(relatives[i],
                          esc));
        res.append("</relative>");
        res.append(EOL);
      }

      res.append("    </relatives>");
      res.append(EOL);
    }

    res.append("    <msg-type>");
    res.append(MsgType.toString(rec.getMsgType()));
    res.append("</msg-type>");
    res.append(EOL);

    if (rec.getMsgCode().length() > 0) {
      res.append("    <msg-code>");
      res.append(rec.getMsgCode());
      res.append("</msg-code>");
      res.append(EOL);
    }
    if (rec.getResourceBundleName().length() > 0) {
      res.append("    <bundle>");
      res.append(rec.getResourceBundleName());
      res.append("</bundle>");
      res.append(EOL);
    }
    if (rec.getMsgClear().length() > 0) {
      res.append("    <msg-clear>");
      res.append(escape(rec.getMsgClear(),
                        esc));
      res.append("</msg-clear>");
      res.append(EOL);
    }
    switch (rec.getMsgType()) {
      case MsgType.PLAIN: {
        // Nothing to be done
        break;
      }
      case MsgType.JAVA: {
        Object[] args = rec.getArgsInt();
        if (args != null && args.length > 0) {
        	
          res.append("    <args>");
          res.append(EOL);

          for (int i = 0; i < args.length; ++i) {
            res.append("      <arg>");
            try {
            	res.append(escape(args[i].toString(), esc));
            }
            catch (Exception ex){
							res.append(escape(Formatter.NULL_STRING, esc));
            }
            res.append("</arg>");
            res.append(EOL);
          }

          res.append("    </args>");
          res.append(EOL);
        }
        break;
      }
    }

    res.append("  </record>");
    res.append(EOL);

    return res.toString();
  }

  public String getHeader(Log log) {

      String res;
      String enc = log.getEncoding();

      res = "<?xml version=\"1.0\"";
      if(enc != null) {
         res += " encoding=\"" + enc + "\"";
      }
      res +=   "?>" + EOL
             + EOL
             + "<!DOCTYPE log" + EOL
             + "[" + EOL
             + "<!ELEMENT log (version, record*)>" + EOL
             + "<!ELEMENT version (#PCDATA)>" + EOL
             + "<!ELEMENT record (id, time, source, application, location, user, session, transaction, dsr-component, dsr-user, dsr-transaction, thread, group?, severity, relatives?, msg-type, msg-code?, bundle?, msg-clear?, args?)>" + EOL
             + "<!ELEMENT id (#PCDATA)>" + EOL
             + "<!ELEMENT time (#PCDATA)>" + EOL
             + "<!ELEMENT source (#PCDATA)>" + EOL
             + "<!ELEMENT application (#PCDATA)>" + EOL
             + "<!ELEMENT location (#PCDATA)>" + EOL
             + "<!ELEMENT user (#PCDATA)>" + EOL
             + "<!ELEMENT session (#PCDATA)>" + EOL
             + "<!ELEMENT transaction (#PCDATA)>" + EOL
             + "<!ELEMENT dsr-component (#PCDATA)>" + EOL
             + "<!ELEMENT dsr-user (#PCDATA)>" + EOL
             + "<!ELEMENT dsr-transaction (#PCDATA)>" + EOL
             + "<!ELEMENT thread (#PCDATA)>" + EOL
             + "<!ELEMENT group (id, level, indent)>" + EOL
             + "<!ELEMENT level (#PCDATA)>" + EOL
             + "<!ELEMENT indent (#PCDATA)>" + EOL
             + "<!ELEMENT severity (#PCDATA)>" + EOL
             + "<!ELEMENT relatives (relative+)>" + EOL
             + "<!ELEMENT relative (#PCDATA)>" + EOL
             + "<!ELEMENT msg-type (#PCDATA)>" + EOL
             + "<!ELEMENT msg-code (#PCDATA)>" + EOL
             + "<!ELEMENT bundle (#PCDATA)>" + EOL
             + "<!ELEMENT msg-clear (#PCDATA)>" + EOL
             + "<!ELEMENT args (arg+)>" + EOL
             + "<!ELEMENT arg (#PCDATA)>" + EOL
             + "]>" + EOL
             + EOL
             + "<log>" + EOL
             + "  <version>" + VERSION + "</version>" + EOL;

      return res.toString();

  }

  public String getFooter(Log log) {
  	return "</log>" + EOL;
  }

  protected StringBuffer escape(String       s,
                                StringBuffer buf) {
    int len = 0;
	
	if (s == null)
	{
		s = EMPTY_STRING;
	}
	
	len = s.length();
	
    buf.setLength(0);
    buf.append(s);
    for (int i = 0; i < len; ++i) {
      switch (buf.charAt(i)) {
        case '<': {
          buf.replace(i,
                      i + 1,
                      "&lt;");
          len += 3;
          i += 3;
          break;
        }
        case '>': {
          buf.replace(i,
                      i + 1,
                      "&gt;");
          len += 3;
          i += 3;
          break;
        }
      }
    }

    return buf;
  }


  private static final String VERSION = "1.6";

  private final static int INITIAL_CAPACITY = 512;

}