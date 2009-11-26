package com.sap.tc.logging.tools.monitor;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import com.sap.tc.logging.Category;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.Log;
import com.sap.tc.logging.LogController;
import com.sap.tc.logging.Severity;

/**
 * Utility class for analyzing SAP logging system.
 *
 * @author  Robert Boban, Dietmar Theobald; SAP AG; Copyright &copy; 2003
 * @version 6.30
 */
public class ConfigurationMonitor
{
  /**
   * Generates a (self-contained) HTML page describing configuration
   * of the SAP logging system as visible from the caller's environment.
   * @param out output stream, remains open
   */
  public static void listConfiguration( PrintWriter out )
  {
    writeHereDoc( out,
 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n"
+"<html>\n"
+"<head><title>Logging Configuration</title>\n"
+"<style type=\"text/css\"><!--\n"
+" body.lc {\n"
+"   font:10pt Verdana,sans-serif;\n"
+" }\n"
+" table.lc {\n"
+"   border:0pt; background-color:whitesmoke; border-collapse:collapse; width:100%\n"
+" }\n"
+" h2.lc {\n"
+"   font-size:14pt; background-color:burlywood\n"
+" }\n"
+" tr.lcHeader {\n"
+"   font-weight:bold;\n"
+" }\n"
+" tr.lcBody {\n"
+" }\n"
+" tr.lcSep {\n"
+"   font-size:4pt;\n"
+" }\n"
+" td {\n"
+"   vertical-align:text-top; text-align:left; padding-top:1pt; padding-bottom:1pt\n"
+" }\n"
+" td.lcSep1 {\n"
+"   padding:6pt;\n"
+" }\n"
+" td.lcSep2 {\n"
+"   padding:0pt;\n"
+" }\n"
+" td.catHeader1 {\n"
+"   font-size:12pt; background-color:khaki\n"
+" }\n"
+" td.locHeader1 {\n"
+"   font-size:12pt; background-color:mediumturquoise\n"
+" }\n"
+" td.sumHeader1 {\n"
+"   font-size:12pt; background-color:lightsalmon\n"
+" }\n"
+" td.catHeader2 {\n"
+"   font-size:9pt; color:maroon; background-color:lemonchiffon\n"
+" }\n"
+" td.locHeader2 {\n"
+"   font-size:9pt; color:maroon; background-color:paleturquoise\n"
+" }\n"
+" td.lcHeader3 {\n"
+"   font-size:8pt; padding-left:3ex;\n"
+" }\n"
+" td.lcSeverity {\n"
+"   font-size:8pt; font-weight:bold; color:maroon; width:33%; padding-left:3ex;\n"
+" }\n"
+" td.lcEntry {\n"
+"   font-size:8pt; padding-left:6ex;\n"
+" }\n"
+"--></style>\n"
+"</head>\n"
+"<body class=lc>\n"
+"<h2 class=lc>Logging Configuration</h2>\n"
+"<table class=lc cellpadding=0 cellspacing=1>\n" );

    try
    {
      final HashMap logRegistry = new HashMap();

      // CATEGORIES
      writeHereDoc( out,
 " <tr class=lcHeader>\n"
+"  <td class=catHeader1 colspan=3><a name=\"cat\">Categories</a></td>\n"
+" </tr>\n"
+" <tr class=lcSep><td class=lcSep2>&nbsp;</td></tr>\n" );

      final int countCategory
        = listLogControllers( out, Category.getCategory( "/" ), logRegistry );

      // LOCATIONS
      writeHereDoc( out,
 " <tr class=lcSep><td class=lcSep1>&nbsp;</td></tr>\n"
+" <tr class=lcHeader>\n"
+"  <td class=locHeader1 colspan=3><a name=\"loc\">Locations</a></td>\n"
+" </tr>\n"
+" <tr class=lcSep><td class=lcSep2>&nbsp;</td></tr>\n" );

      final int countLocation
        = listLogControllers( out, Location.getLocation(Location.ROOT_NAME), logRegistry );

      // SUM
      writeHereDoc( out,
 " <tr class=lcSep><td class=lcSep1>&nbsp;</td></tr>\n"
+" <tr class=lcHeader>\n"
+"  <td class=sumHeader1 colspan=3>Totals</td>\n"
+" </tr>\n"
+" <tr class=lcHeader>\n"
+"  <td class=lcHeader3 colspan=3><a href=\"#cat\">Categories(" );

      out.print  ( Integer.toString( countCategory ) );
      out.println( ")</a></td></tr>" );
      out.println( " <tr class=lcHeader>" );
      out.print  ( "  <td class=lcHeader3 colspan=3><a href=\"#loc\">Locations(" );
      out.print  ( Integer.toString( countLocation ) );
      out.println( ")</a></td></tr>" );      
      out.println( " <tr class=lcHeader>" );
      out.print  ( "  <td class=lcHeader3 colspan=3><a href=\"#loc\">Logs(" );
      out.print  ( Integer.toString( logRegistry.size() ) );
      out.println( ")</a></td></tr>" );
      
      final Iterator iter = logRegistry.entrySet().iterator();
      while ( iter.hasNext() )
      {
        final Map.Entry entry = (Map.Entry) iter.next();
        final int       count = ((Integer) entry.getValue()).intValue();
        
        out.println( " <tr class=lcBody>" );
        out.print  ( "  <td class=lcEntry colspan=3>" );
        if ( 1 != count )
          out.print( "<b>" );
        writeName( out, (String) entry.getKey(), false );
        out.print  ( " (" );
        out.print  ( count );
        out.println( ( 1 == count ) ? ")</td></tr>" : ")</b></td></tr>" );
      }
    }
    catch( final Exception ex )
    {
      listException( out, ex );
    }
    out.println( "</table>" );
    out.println( "</body></html>" );
    out.flush();
  }

  /**
   * Generates the HTML description for the log controller tree rooted at the
   * given controller. Output is written in pre-order traversal, i.e., root
   * output before listing the children.
   * <p>
   * Output differs slightly for locations and for categories.
   * <p>
   * Occurrences of log files are counted.
   *
   * @param out      output stream
   * @param root     root controller of hierarchy to be processed
   * @param registry registers log occurrences
   * @return number of listed controllers, including <code>root</code>
   */
  private static int listLogControllers( PrintWriter   out,
                                         LogController root, HashMap registry )
  {
    int lcCount = 1;
    try
    {
      out.println( " <tr class=lcHeader>" );
      out.print  ( ( root instanceof Category ) ? "  <td class=cat"
                                                : "  <td class=loc" );
      out.print  ( "Header2 colspan=3>" );
      writeName( out, root.getName().equals(Location.ROOT_NAME) ? "ROOT" : root.getName() , true );
      out.println( "</td></tr>" );
      out.println( " <tr class=lcHeader>" );
      out.print  ( "  <td class=lcSeverity>Effective severity: " );
      out.print  ( convertSeverity( root.getEffectiveSeverity() ) );
      out.println( "</td>" );
      out.print  ( "  <td class=lcSeverity>Minimum severity: " );
      out.print  ( convertSeverity( root.getMinimumSeverity() ) );
      out.println( "</td>" );
      out.print  ( "  <td class=lcSeverity>Maximum severity: " );
      out.print  ( convertSeverity( root.getMaximumSeverity() ) );
      out.println( "</td></tr>" );

      final Object[] children = root.getChildren().toArray();

      if (children != null && 0 != children.length )
      {
        out.println( " <tr class=lcHeader>" );
        out.print  ( "  <td class=lcHeader3 colspan=3>Children (" );
        out.print  ( Integer.toString( children.length ) );
        out.println( ")</td></tr>" );

        for ( int i = 0; i < children.length; ++i )
        {
          out.println( " <tr class=lcBody>" );
          out.print  ( "  <td class=lcEntry colspan=3>" );
          writeName( out, ((LogController) children[i] ).getName(), false );
          out.println( "</td></tr>" );
        }
      }
      listRelatives( out, root );
      listLogs( out, root, registry );

      for ( int i = 0; i < children.length; ++i )
        lcCount += listLogControllers( out,
                                       (LogController) children[i], registry );
    }
    catch( final Exception ex )
    {
      listException( out, ex );
    }
    return lcCount;
  } 
  
  /**
   * Generates the HTML description listing the direct relatives of the given
   * controller.
   * @param out        output stream
   * @param controller reference controller
   */
  private static void listRelatives( PrintWriter out, LogController controller )
  {
    try
    {
      final LogController[] lcList = controller.getRelatives();

      if (lcList != null && 0 != lcList.length )
      {
        out.println( " <tr class=lcHeader>" );
        out.print  ( "  <td class=lcHeader3 colspan=3>Relatives (" );
        out.print  ( Integer.toString( lcList.length ) );
        out.println( ")</td></tr>" );

        for ( int i = 0; i < lcList.length; ++i )
        {
          out.println( " <tr class=lcBody>" );
          out.print  ( "  <td class=lcEntry colspan=3>" );
          writeName( out, lcList[i].getName(), false );
          out.println( "</td></tr>" );
        }
      }
    }
    catch( final Exception ex )
    {
      listException( out, ex );
    }
  } 
  
  /**
   * Generates the HTML description listing all the logs this log controller
   * writes messages to, being it public, private or local logs.
   * Occurrences of log files are counted.
   *
   * @param out        output stream
   * @param controller reference controller
   * @param registry   registers log occurrences
   */
  private static void listLogs( PrintWriter out,
                                LogController controller, HashMap registry )
  {
    try
    {
      final Object[] logList = controller.getAllLogs().toArray();
      if (logList != null && 0 != logList.length )
      {
        out.println( " <tr class=lcHeader>" );
        out.print  ( "  <td class=lcHeader3 colspan=3>Logs (" );
        out.print  ( Integer.toString( logList.length ) );
        out.println( ")</td></tr>" );

        for ( int i = 0; i < logList.length; ++i )
        {
          final String logName = ((Log) logList[i] ).getName();

          out.println( " <tr class=lcBody>" );
          out.print  ( "  <td class=lcEntry colspan=3>" );
          writeName( out, logName, true );
          out.println( "</td></tr>" );
          
          // note: HashMap can take 'null'
          final Integer count = (Integer) registry.get( logName );
          registry.put( logName, new Integer( ( null == count )
                                                 ? 1
                                                 : count.intValue() + 1 ) );
        }
      }
    }
    catch( final Exception ex )
    {
      listException( out, ex );
    }
  } 

  /**
   * Logs the given exception onto the output stream, as separate row in the
   * generated output table. Hence, likely exception generating actions should
   * be performed with current output position where a new row can be started.
   * @param out output stream
   * @param ex  exception to be logged
   */
  private static void listException( PrintWriter out, Throwable ex )
  {
    out.println( " <tr class=lcBody>" );
    out.println( "  <td class=lcEntry style=\"font-weight:bold;color:red;\">Error:" );
    out.println( ex.getMessage() );
    out.println( "  </td><td class=lcEntry colspan=2>" );
    ex.printStackTrace( out );
    out.println( "  </td></tr>" );
  }
  
  /**
   * Maps given {@link Severity} level to its textual representation for
   * logging purposes.
   * Contrary to {@link Severity#toString(int)}, levels are not transformed
   * @param sev logging severity
   * @return given severity as text literal
   */
  private static String convertSeverity( int sev )
  {
    final String sevTxt;
    switch ( sev )
    {
      case Severity.ALL:     { sevTxt = "ALL";     break; }
      case Severity.NONE:    { sevTxt = "NONE";    break; }
      case Severity.GROUP:   { sevTxt = "GROUP";   break; }
      case Severity.DEBUG:   { sevTxt = "DEBUG";   break; }
      case Severity.ERROR:   { sevTxt = "ERROR";   break; }
      case Severity.FATAL:   { sevTxt = "FATAL";   break; }
      case Severity.INFO:    { sevTxt = "INFO";    break; }
      case Severity.PATH:    { sevTxt = "PATH";    break; }
      case Severity.WARNING: { sevTxt = "WARNING"; break; }
      default:
        sevTxt = "UNKNOWN(" + sev + ")";
    }
    return sevTxt;
  }

  /**
   * Generates HTML output for a name that is either a link anchor or a
   * document-internal HTML link to an anchor defined with this method.
   * No check is made that a link does actually exist, or whether an anchor
   * is defined multiply.
   * @param out      output stream
   * @param name     name to be written
   * @param isAnchor <code>true</code> iff this is a link anchor
   */
  private static void writeName( PrintWriter out, String name, boolean isAnchor )
  {
    out.print( ( isAnchor ) ? "<a name=\"" : "<a href=\"#" );

    if ( null == name )
    {
      out.print( "\"><i>&laquo;null&raquo;</i></a>" );
    }
    else
    {
      char[] txt  = name.toCharArray();
      for ( int i = 0; i < txt.length; ++i )
      {
        final char ch = txt[i];
        if (   'a' <= ch && 'z' >= ch
            || 'A' <= ch && 'Z' >= ch
            || '0' <= ch && '9' >= ch )
          out.print( txt[i] );
      }
      out.print( "\">" );
      out.print( name );
      out.print( "</a>" );
    }
  }

  /**
   * Writes <code>doc</code> to the formatter's output stream, converting
   * any embedded <code>'\n'</code> to line breaks.
   * A trailing line break is not written.
   * The name derives from Unix shell's <i>here documents</i>.
   * @param out output stream
   * @param doc string to be written
   */
  private static void writeHereDoc( PrintWriter out, String doc )
  {
    int pos;
    for ( int fromIdx = 0; ; fromIdx = pos + 1 )
    {
      pos = doc.indexOf( '\n', fromIdx );

      if ( fromIdx == pos )
        out.println();
      else if ( 0 <= pos )
        out.println( doc.substring( fromIdx, pos ) );
      else
      {
        if ( fromIdx < doc.length() )
          out.print( doc.substring( fromIdx ) );
        break;
      }
    }
  }
}