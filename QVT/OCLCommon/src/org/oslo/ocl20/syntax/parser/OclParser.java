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

import java.io.Reader;

import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;

import uk.ac.kent.cs.kmf.util.ILog;

public interface OclParser {
	
  java_cup.runtime.lr_parser createParser(Reader reader, ILog log);

  /** 
   * Parse the given reader 
   * with/without debugging info, 
   * reporting errors on given log
   * 
   * The result is null if an error is reported
   *  
   * */
  PackageDeclarationAS parse(Reader reader, ILog log, boolean debug);

  /** 
   * Check if the parser encountered an error 
   * 
   * */
  boolean hasErrors();

  /** 
   * Check if the parser encountered a warning 
   * 
   * */
  boolean hasWarnings();
}
