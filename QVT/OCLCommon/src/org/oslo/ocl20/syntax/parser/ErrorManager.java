/**
 * Kent Modelling Framework - KMFStudio
 * Copyright (C) 2002 University of Kent at Canterbury, UK 
 * Visit www.cs.ukc.ac.uk/kmf
 *
 */

/**
 * 
 * @author Octavian Patrascoiu
 *
 */

package org.oslo.ocl20.syntax.parser;

import java.util.List;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;

import uk.ac.kent.cs.kmf.util.ILog;

//import uk.ac.kent.cs.kmf.util.*;

public class ErrorManager {
	
	public static List recordMessages;
	
	public static String source=null;
		
	// Change the method report_error to display location and the reason
	public static StringBuffer getMessage(String message, Object info) {
		// Create the error message
		StringBuffer buffer = new StringBuffer(/*"["+source+"]"*/);
		// Add location
		if (info instanceof java_cup.runtime.Symbol) {
			java_cup.runtime.Symbol symb = ((java_cup.runtime.Symbol) info);
			if (OclSemanticAnalyserVisitorImpl.getBeginLine(symb) >= 1) {
				buffer.append(OclSemanticAnalyserVisitorImpl.getBeginLine(symb)+":");
				buffer.append(OclSemanticAnalyserVisitorImpl.getBeginColumn(symb));
				buffer.append(" ");
			}
			buffer.append(message);
			if (symb.value instanceof String) {
				if (symb.value != null && ((String)symb.value).length() != 0) {
					buffer.append(" near '"+symb.value+"'");
  				}
			} 
		} else {
			// Add message
			buffer.append(message);
		}
		return buffer;
	}

	public static void reportInfo(ILog log, Object info, String message) {
		String s=new String(getMessage(message, info));
		if (recordMessages!=null) recordMessages.add(new StructuredErrorDescription(false,false,message,(java_cup.runtime.Symbol)info,source));
		log.reportMessage(s);
	}
	
	public static void reportWarning(ILog log, Object info, String message) {
		// Report error
		String s=new String(getMessage(message, info));
		if (recordMessages!=null) recordMessages.add(new StructuredErrorDescription(false,true,message,(java_cup.runtime.Symbol)info,source));
		log.reportWarning(s);
	}
	
	public static void reportError(ILog log, Object info, String message) {
		// Report error
		String s=new String(getMessage(message, info));
		if (recordMessages!=null) recordMessages.add(new StructuredErrorDescription(true,false,message,(java_cup.runtime.Symbol)info,source));
		log.reportError(s);
	}
	
	// Change the method report_error to display location and the reason
	public static void reportFatalError(ILog log, Object info, String message) {
		String s=new String(getMessage(message, info));
		if (recordMessages!=null) recordMessages.add(new StructuredErrorDescription(true,false,message,(java_cup.runtime.Symbol)info,source));
		log.reportError(s);
	}
}
