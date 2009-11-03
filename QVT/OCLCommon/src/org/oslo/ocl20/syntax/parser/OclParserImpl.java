/**
 * 
 * @author Octavian Patrascoiu
 *
 */

package org.oslo.ocl20.syntax.parser;

import java.io.Reader;

import java_cup.runtime.ComplexSymbolFactory;

import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;

import uk.ac.kent.cs.kmf.util.ILog;

public class OclParserImpl implements OclParser {

  public java_cup.runtime.lr_parser createParser(Reader reader, ILog log) {
		
	//--- Create a lexer and a parser ---
	ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
	Yylex yylex = new Yylex(reader,symbolFactory);
	yylex.setLog(log);
	Yyparse yyparser = new YyparseWithSourceTracking( yylex , symbolFactory);
	yyparser.setLog(log); 
	yyparser.setFactory(new ASTBuilder(log));
	return yyparser;
  }

  /** Parse the 'reader' and return the syntax tree 'root' */
  public PackageDeclarationAS parse(Reader reader, ILog log, boolean debug) {
	java_cup.runtime.lr_parser yyparser = createParser(reader, log);

    //--- Store the no of errors ---
    int errNo = log.getErrors();
    int warnNo = log.getWarnings();
    
    //--- Parse input ---
	PackageDeclarationAS root = null;
	java_cup.runtime.Symbol rootSymbol = null;
    try {
      if (debug) {
        rootSymbol = yyparser.debug_parse();
      } else
        rootSymbol = yyparser.parse();
    } catch (Exception e) {
    	rootSymbol = null;
        log.reportError("Parse error" + e);
	} finally {
	}

	//--- Set hasErrors flag
	hasErrors = log.getErrors() > errNo && !log.tooManyViolations();
	hasWarnings = log.getWarnings() > warnNo && !log.tooManyViolations();
	
	//--- Return result ---
	if (rootSymbol != null && rootSymbol.value instanceof PackageDeclarationAS) 
		root = (PackageDeclarationAS)rootSymbol.value;
	return root;
  }

  /** Check if the parser encountered an error */
  protected boolean hasErrors;
  public boolean hasErrors() {
  	return hasErrors;
  }

  /** Check if the parser encountered a warning */
  protected boolean hasWarnings;
  public boolean hasWarnings() {
	return hasWarnings;
  }
}
