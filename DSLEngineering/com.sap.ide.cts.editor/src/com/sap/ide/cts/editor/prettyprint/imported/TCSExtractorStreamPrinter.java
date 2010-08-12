package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.DEBUG_STREAM_CONSOLE_DUMP;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.IDENTIFIER_ESCAPING_END;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.IDENTIFIER_ESCAPING_START;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.KEYWORDS_CHECK_IGNORE_CASE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.STRING_DELIMITER;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_BOTH_SPACE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_LEFT_NONE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_LEFT_SPACE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_RIGHT_NONE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_RIGHT_SPACE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_BOOL;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_COMMENT;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_IDENT;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_INT;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_KEYWORD;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_REAL;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_SPACE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_STRING;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_SYMBOL;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintDebugHelper.debug;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.isSymbol;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tcs.Alternative;
import tcs.ConcreteSyntax;
import tcs.Keyword;
import tcs.SequenceElement;
import tcs.SpaceKind;
import tcs.Symbol;
import tcs.Template;

import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Helper class used by the {@link PrettyPrinter} to print information into
 * a given {@link TCSExtractorStream}.
 * 
 * It serves as a thin layer over a stream, offering several convenience methods which operate
 * on a higher conceptual level compared to the low-level stream methods
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TCSExtractorStreamPrinter {

    private static DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    static {
	decimalFormatSymbols.setDecimalSeparator('.');
    }
    private final DecimalFormat decilmalFormat = new DecimalFormat("0.##############", decimalFormatSymbols);
    
    /**
     * Mapping of symbol value to symbol type constant
     */
    private final Map<String, Integer> symbols;
    /**
     * List of known keywords within the syntax
     */
    private final Set<String> keywords;
    
    private final TCSExtractorStream outputStream;
    private PrettyPrintContext currentContext;

    private final PrettyPrintingPolicy policy;
    private final PrettyPrintingTracer tracer;
    
    public TCSExtractorStreamPrinter(ConcreteSyntax syntax, TCSExtractorStream outputStream, PrettyPrintContext context, PrettyPrintingPolicy policy, PrettyPrintingTracer tracer) {
	this.currentContext = context;
	this.policy = policy;
	this.tracer = tracer;
	this.symbols = fetchSymbolsFromSyntax(syntax);
	this.keywords = fetchKeywordsFromSyntax(syntax);
	
	if (DEBUG_STREAM_CONSOLE_DUMP) {
	    this.outputStream = new DebugPrintTCSExtractorStreamDecorator(outputStream);
	} else {
	    this.outputStream = outputStream;
	}
    }
    
    private Map<String, Integer> fetchSymbolsFromSyntax(ConcreteSyntax syntax) {
	Map<String, Integer> symbols = new HashMap<String, Integer>();
	for (Symbol s : syntax.getSymbols()) {
	    String value = s.getValue();
	    debug("Symbol: " + value);
	    int type = TYPE_SYMBOL;
	    for (SpaceKind spaceKind : s.getSpaces()) {
		// TODO debug and check if toString is right here
		String l = spaceKind.toString();
		debug("\tLiteral: " + l);
		if (l.equals("leftSpace")) {
		    type += SYMBOL_LEFT_SPACE;
		} else if (l.equals("leftNone")) {
		    type += SYMBOL_LEFT_NONE;
		}
		if (l.equals("rightSpace")) {
		    type += SYMBOL_RIGHT_SPACE;
		} else if (l.equals("rightNone")) {
		    type += SYMBOL_RIGHT_NONE;
		}
	    }
	    symbols.put(value, type);
	}
	return symbols;
    }
    
    private Set<String> fetchKeywordsFromSyntax(ConcreteSyntax syntax) {
	Set<String> keywords = new HashSet<String>();
	for (Keyword k : syntax.getKeywords()) {
	    String value = k.getValue();
	    if (KEYWORDS_CHECK_IGNORE_CASE) {
		value = value.toUpperCase();
	    }
	    keywords.add(value);
	}
	return keywords;
    }
    
    public void addAutoCreatedKeyword(Keyword value) {
	keywords.add((value).getValue());
    }
        
    public void printBooleanLiteral(boolean v) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printBoolean(v);
	currentContext.setTypeLast(TYPE_BOOL);
	tracer.notifyPrintedToken();
    }

    public void printComment(String c) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printComment(c);
	currentContext.setTypeLast(TYPE_COMMENT);
	tracer.notifyPrintedToken();
    }

    public void printCustomStringLiteral(String v, String surroundings) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printString(surroundings, v);
	currentContext.setTypeLast(TYPE_STRING);
	System.out.println(v); //TODO remove
	tracer.notifyPrintedToken();
    }

    @SuppressWarnings("unused")
    public void printIdentifier(String ident, boolean orKeyword) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	boolean simpleIdent = ident.matches("[_a-zA-Z][_a-zA-Z0-9]*");
	if (simpleIdent && !orKeyword) {
	    simpleIdent = !keywords.contains(ident);
	}
	if ((!orKeyword) && KEYWORDS_CHECK_IGNORE_CASE && keywords.contains(ident.toUpperCase())) {
	    simpleIdent = false;
	}
	System.out.println(ident); // TODO remove
	if (simpleIdent) {
	    outputStream.printIdentifier(ident);
	} else {
	    outputStream.printEscapedIdentifier(IDENTIFIER_ESCAPING_START, ident, IDENTIFIER_ESCAPING_END);
	}
	currentContext.setTypeLast(TYPE_IDENT);
	tracer.notifyPrintedToken();
    }
    
    public void printIntegerLiteral(int v) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printInteger(v);
	currentContext.setTypeLast(TYPE_INT);
	tracer.notifyPrintedToken();
    }

    private void printKeyword(String keyword) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printKeyword(keyword);
	System.out.println(keyword); // TODO remove
	currentContext.setTypeLast(TYPE_KEYWORD);
	tracer.notifyPrintedToken();
    }

    public void printLiteral(RefObject literal) {
	String s = MOINImportedModelAdapter.getString(literal, "value");
	String ltn = MOINImportedModelAdapter.getTypeName(literal);
	if (ltn != null) {
	    if (ltn.equals("TCS::Keyword")) {
		printKeyword(s);
	    } else {
		printSymbol(s);
	    }
	}
    }

    public void printRealLiteral(double v) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printReal(decilmalFormat.format(v)); // TODO: format properly
	currentContext.setTypeLast(TYPE_REAL);
	tracer.notifyPrintedToken();
    }

    public void printStringLiteral(String v) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printString(STRING_DELIMITER, v.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\""));
	currentContext.setTypeLast(TYPE_STRING);
	tracer.notifyPrintedToken();
    }
    
    public void printDefault(String value) {
	tracer.notifyAboutToPrintToken();
	printSeperatorForDisambiguationIfNeeded();
	outputStream.printDefault(value);
	currentContext.setTypeLast(TYPE_STRING);
	tracer.notifyPrintedToken();
    }

    public void printSymbol(String symbol) {
	tracer.notifyAboutToPrintToken();
	Integer type = symbols.get(symbol);
	int typeCurrent = -1;
	if (type == null) {
	    typeCurrent = TYPE_SYMBOL;
	} else {
	    typeCurrent = type.intValue();
	}
	boolean whitespaceDesired = policy.desiresAdditionalWhiteSpace();
	if (whitespaceDesired || symbolConfigurationRequiresWhiteSpace(typeCurrent) && (currentContext.getTypeLast() != TYPE_SPACE)) {
	    printSeparator();
	}
	outputStream.printSymbol(symbol);
	currentContext.setTypeLast(typeCurrent);
	System.out.println(symbol); // TODO remove
	tracer.notifyPrintedToken();
    }
    
    private boolean symbolConfigurationRequiresWhiteSpace(int typeCurrent) {
	return ((isSymbol(typeCurrent, SYMBOL_LEFT_SPACE) || isSymbol(typeCurrent, SYMBOL_BOTH_SPACE)) && !isSymbol(currentContext.getTypeLast(), SYMBOL_RIGHT_NONE))
	|| ((isSymbol(currentContext.getTypeLast(), SYMBOL_RIGHT_SPACE) || isSymbol(currentContext.getTypeLast(), SYMBOL_BOTH_SPACE)) && !isSymbol(typeCurrent, SYMBOL_LEFT_NONE));
    }
    
    public void close() {
	outputStream.close();
    }

    public int startClassTemplateForObject(RefObject ame, Template template) {
	int handle = outputStream.startClassTemplateForObject(ame, template);
	tracer.notifyStartedClassTemplateForObject(handle, ame, template);
	return handle;
    }

    public void endClassTemplate(int handle) {
	outputStream.endClassTemplate(handle);
	tracer.notifyEndedClassTemplate(handle);
    }

    public void enterSequenceElement(SequenceElement seqElem) {
	outputStream.enterSequenceElement(seqElem);
	tracer.notifyEnteredSequenceElement(seqElem);
	
    }
    public void exitSequenceElement() {
	outputStream.exitSequenceElement();
	tracer.notifyExitedSequenceElement();
    }
    
    /**
     * Tell the stream to create an safepoint.
     * 
     * @return the command handle which can later be used to undo all
     * print operations which happened since calling this command
     */
    public int createSafePoint() {
	int handle = outputStream.createSafePoint();
	tracer.notifySafePointCreated(handle);
	return handle;
    }

    /**
     * Reset the stream to the state it had when the safepoint
     * corresponding to the handle was created.
     */
    public void resetToSafePoint(int handle, PrettyPrintContext newContext) {
	outputStream.resetToSafePoint(handle);
	tracer.notifyResettedToSafePoint(handle);
	this.currentContext = newContext;
    }
    
    /**
     * Instruct the pretty printer to from now one use the default
     * separator
     */
    public void useDefaultSeparator() {
	useCustomSeparator(PrettyPrintConstants.DEFAULT_SEPARATOR);
    }
    
    /**
     * Instruct the pretty printer to use a custom seperator.
     * This can be used to configure indentation levels.
     * 
     * @param seperator
     */
    public void useCustomSeparator(String seperator) {
	currentContext.getCurrentSeparator().push(seperator);
	debug("PUSHING SEPARATOR: \"" + seperator + "\"");
    }
    
    /**
     * Set separator back to the previously used one.
     */
    public void resetSeparator() {
	String old = currentContext.getCurrentSeparator().pop();
	debug("POPING SEPARATOR: \"" + old + "\"");
    }
    
    public void printSeparator() {
	printSeparator(/*forDisambiguation*/ false);
    }
   
    public void printSeparator(boolean forDisambiguation) {
	printCustomWhiteSpace(currentContext.getCurrentSeparator().peek(), forDisambiguation);
    }

    public void printCustomWhiteSpace(String ws) {
	printCustomWhiteSpace(ws, /*forDisambiguation*/ false);
    }
    
    public void printCustomWhiteSpace(String ws, boolean forDisambiguation) {
	tracer.notifyAboutToPrintWhiteSpace();
	
	String adaptedWS = policy.adaptWhiteSpace(ws);
	if (adaptedWS.isEmpty() && forDisambiguation) {
	    adaptedWS = ws;
	}
	System.out.println("\"" + adaptedWS + "\"");
	debug("printing WS = \"" + adaptedWS + "\"");
	outputStream.printWhiteSpace(adaptedWS);
	currentContext.setTypeLast(TYPE_SPACE);
	
	tracer.notifyPrintedWhiteSpace(adaptedWS);
    }

    public void printIndentationIfNeeded() {
	boolean whitespaceDesired = policy.desiresAdditionalWhiteSpace();
	if (currentContext.getTypeLast() != TYPE_SPACE || whitespaceDesired) {
	    if (!currentContext.getCurrentSeparator().peek().equals(PrettyPrintConstants.DEFAULT_SEPARATOR)) {
		printSeparator();
	    }
	}
    }

    public void printSeparatorIfNeeded() {
	boolean whitespaceDesired = policy.desiresAdditionalWhiteSpace();
	if (currentContext.getTypeLast() != TYPE_SPACE || whitespaceDesired) {
	    printSeparator();
	}
    }
    
    private void printSeperatorForDisambiguationIfNeeded() {
	boolean whitespaceDesired = policy.desiresAdditionalWhiteSpace();
	if (needWhiteSpaceForDisambiguation() || whitespaceDesired) {
	    printSeparator(/*forDisambiguation*/ true);
	}
    }

    private boolean needWhiteSpaceForDisambiguation() {
	return (currentContext.getTypeLast() == TYPE_KEYWORD) || (currentContext.getTypeLast() == TYPE_IDENT)
		|| (currentContext.getTypeLast() == TYPE_INT) || (currentContext.getTypeLast() == TYPE_REAL)
		|| (currentContext.getTypeLast() == TYPE_STRING) || (currentContext.getTypeLast() == TYPE_BOOL)
		|| (isSymbol(currentContext.getTypeLast(), SYMBOL_BOTH_SPACE)) || (isSymbol(currentContext.getTypeLast(), SYMBOL_RIGHT_SPACE));
    }

    public void enterAlternative(Alternative alt) {
	outputStream.enterAlternative(alt);
	tracer.notifyEnteredAlternative(alt);
    }

    public void beginAlternativeChoice(int choiceIndexInAlternative) {
	outputStream.beginAlternativeChoice(choiceIndexInAlternative);
	tracer.notifyBeganAlternativeChoice(choiceIndexInAlternative);
    }

    public void exitAlternative() {
	outputStream.exitAlternative();
	tracer.notifyExitedAlternative();
    }

}
