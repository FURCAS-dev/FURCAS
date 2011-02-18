//package com.sap.furcas.ide.editor;
//
//import java.util.ArrayList;
//
//import org.eclipse.core.runtime.IConfigurationElement;
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.Platform;
//import org.eclipse.jface.text.BadLocationException;
//import org.eclipse.jface.text.IDocument;
//import org.eclipse.jface.text.IRegion;
//import org.eclipse.jface.text.Position;
//import org.eclipse.jface.text.reconciler.DirtyRegion;
//import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
//import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
//import org.eclipse.swt.widgets.Display;
//
//import com.sap.furcas.ide.editor.document.CtsDocument;
//import com.sap.furcas.ide.editor.matching.CtsStaticMatcher;
//
//public class CtsReconcilingStrategy implements IReconcilingStrategy,
//	IReconcilingStrategyExtension {
//
//    private static final String EXTENSION_POINT_FOLDING_STATIC_FOLDING_BRACKETS = "staticFoldingBrackets";
//    private static final String EXTENSION_POINT_FOLDING_TYPE_STATIC_CONFIGURABLE = "static (configurable)";
//    private static final String EXTENSION_POINT_FOLDING_TYPE_DYNAMIC_DEFAULT = "dynamic (default)";
//    private static final String EXTENSION_POINT_FOLDING_TYPE_STATIC_DEFAULT = "static (default)";
//    private static final String EXTENSION_POINT_FOLDING_TYPE = "foldingType";
//    private static final String EXTENSION_POINT_FOLDING = "com.sap.furcas.ide.editor.folding";
//    private char FOLDING_START_CHAR = '{';
//    private char FOLDING_END_CHAR = '}';
//    private AbstractGrammarBasedEditor editor;
//    private IDocument fDocument;
//    protected final ArrayList<Position> fPositions = new ArrayList<Position>();
//    protected int fOffset;
//    protected int fRangeEnd;
//
//    public MarkerRefreshListener getEditor() {
//	return editor;
//    }
//
//    public void setEditor(AbstractGrammarBasedEditor editor) {
//	this.editor = editor;
//    }
//
//    @Override
//    public void setDocument(IDocument document) {
//	this.fDocument = document;
//    }
//
//    @Override
//    public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
//	initialReconcile();
//    }
//
//    @Override
//    public void reconcile(IRegion partition) {
//	initialReconcile();
//    }
//
//    @Override
//    public void setProgressMonitor(IProgressMonitor monitor) {
//
//    }
//
//    @Override
//    public void initialReconcile() {
//	fOffset = 0;
//	fRangeEnd = fDocument.getLength();
//	calculatePositions();
//    }
//
//    protected int cNextPos = 0;
//
//    /** number of newLines found by {@link #classifyTag()} */
//    protected int cNewLines = 0;
//    protected char cLastNLChar = ' ';
//    protected static final int START_TAG = 1;
//    protected static final int LEAF_TAG = 2;
//    protected static final int END_TAG = 3;
//    protected static final int EOR_TAG = 4;
//    protected static final int COMMENT_TAG = 5;
//    protected static final int PI_TAG = 6;
//
//    /**
//     * uses {@link #fDocument}, {@link #fOffset} and {@link #fRangeEnd} to
//     * calculate {@link #fPositions}. About syntax errors: this method is not a
//     * validator, it is useful.
//     */
//    protected void calculatePositions() {
//	// we have to wait until the document is completely initialized
//	while (!((CtsDocument) fDocument).isCompletelyItitialized()) {
//	    try {
//		Thread.sleep(100);
//	    } catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	    }
//	}
//	fPositions.clear();
//	cNextPos = fOffset;
//	try {
//	    IConfigurationElement[] config = Platform.getExtensionRegistry()
//		    .getConfigurationElementsFor(
//			    EXTENSION_POINT_FOLDING);
//	    if (config.length != 0) {
//		IConfigurationElement e = config[0];
//		String foldingType = e.getAttribute(EXTENSION_POINT_FOLDING_TYPE);
//		if (foldingType.equals(EXTENSION_POINT_FOLDING_TYPE_STATIC_DEFAULT)) {
//		    recursiveStaticTokens(0);
//		}
//		if (foldingType.equals(EXTENSION_POINT_FOLDING_TYPE_DYNAMIC_DEFAULT)) {
//		    recursiveTokens(0);
//		}
//		if (foldingType.equals(EXTENSION_POINT_FOLDING_TYPE_STATIC_CONFIGURABLE)) {
//
//		    char braces[] = e.getAttribute(EXTENSION_POINT_FOLDING_STATIC_FOLDING_BRACKETS)
//			    .toCharArray();
//		    if (braces != null && braces.length == 3) {
//
//			CtsStaticMatcher bsm = new CtsStaticMatcher();
//			FOLDING_START_CHAR = braces[0];
//			FOLDING_END_CHAR = braces[2];
//			recursiveStaticTokens(0);
//		    }
//
//		}
//		cNewLines = 1;
//		Display.getDefault().asyncExec(new Runnable() {
//		    @Override
//            public void run() {
//			editor.updateFoldingStructure(fPositions);
//		    }
//
//		});
//
//	    }
//	} catch (Exception ex) {
//	    ex.printStackTrace();
//
//	}
//
//	// Collections.sort(fPositions, new RangeTokenComparator());
//
//    }
//
//    /**
//     * emits tokens to {@link #fPositions}.
//     * 
//     * @return number of newLines
//     * @throws BadLocationException
//     */
//    protected int recursiveTokens(int depth) throws BadLocationException {
//	int newLines = 0;
//	while (cNextPos < fRangeEnd) {
//	    while (cNextPos < fRangeEnd) {
//		char ch = fDocument.getChar(cNextPos++);
//		switch (ch) {
//		case '<':
//		    int startOffset = cNextPos - 1;
//		    int startNewLines = newLines;
//		    int classification = classifyTag();
//		    String tagString = fDocument.get(startOffset, Math.min(
//			    cNextPos - startOffset, fRangeEnd - startOffset)); // this
//									       // is
//									       // to
//									       // see
//									       // where
//									       // we
//									       // are
//									       // in
//									       // the
//									       // debugger
//		    newLines += cNewLines; // cNewLines is written by
//		    // classifyTag()
//
//		    switch (classification) {
//		    case START_TAG:
//			newLines += recursiveTokens(depth + 1);
//			if (newLines > startNewLines + 1) {
//			    emitPosition(startOffset, cNextPos - startOffset);
//			}
//			break;
//		    case LEAF_TAG:
//			if (newLines > startNewLines + 1) {
//			    emitPosition(startOffset, cNextPos - startOffset);
//			}
//			break;
//		    case COMMENT_TAG:
//			if (newLines > startNewLines + 1) {
//			    emitPosition(startOffset, cNextPos - startOffset);
//			}
//			break;
//		    case PI_TAG:
//			break;
//		    case END_TAG:
//		    case EOR_TAG:
//			return newLines;
//		    default:
//			break;
//		    }
//		    break;
//		case '\n':
//		case '\r':
//		    if ((ch == cLastNLChar) || (' ' == cLastNLChar)) {
//			newLines++;
//			cLastNLChar = ch;
//		    }
//		    break;
//		default:
//		    break;
//		}
//	    }
//
//	}
//	return newLines;
//    }
//
//    protected int recursiveStaticTokens(int depth) throws BadLocationException {
//	int newLines = 0;
//	while (cNextPos < fRangeEnd) {
//	    while (cNextPos < fRangeEnd) {
//		char ch = fDocument.getChar(cNextPos++);
//
//		if (ch == FOLDING_START_CHAR) {
//		    int startOffset = cNextPos - 1;
//		    int startNewLines = newLines;
//		    String tagString = fDocument.get(startOffset, Math.min(
//			    cNextPos - startOffset, fRangeEnd - startOffset)); // this
//									       // is
//									       // to
//									       // see
//									       // where
//									       // we
//									       // are
//									       // in
//									       // the
//									       // debugger
//		    newLines += cNewLines; // cNewLines is written by
//		    newLines += recursiveStaticTokens(depth + 1);
//		    if (newLines > startNewLines + 1) {
//			emitPosition(startOffset, cNextPos - startOffset);
//		    }
//		    cNewLines += eatToEndOfLine();
//		}
//
//		if (ch == FOLDING_END_CHAR) {
//		    cNewLines += eatToEndOfLine();
//		    return newLines;
//		}
//		if (ch == '\n' | ch == '\r') {
//		    if ((ch == cLastNLChar) || (' ' == cLastNLChar)) {
//			newLines++;
//			cLastNLChar = ch;
//		    }
//		}
//	    }
//
//	}
//	return newLines;
//    }
//
//    protected void emitPosition(int startOffset, int length) {
//	fPositions.add(new Position(startOffset, length));
//    }
//
//    /**
//     * classsifies a tag: <br />
//     * &lt;?...?&gt;: {@link #PI_TAG} <br />
//     * &lt;!...--&gt;: {@link #COMMENT_TAG} <br />
//     * &lt;...&gt;: {@link #START_TAG} <br />
//     * &lt;.../&gt;: {@link #LEAF_TAG} <br />
//     * &lt;/...&gt;: {@link #END_TAG} <br />
//     * &lt;...: {@link #EOR_TAG} (end of range reached before closing &gt; is
//     * found). <br />
//     * when this method is called, {@link #cNextPos} must point to the character
//     * after &lt;, when it returns, it points to the character after &gt; or
//     * after the range. About syntax errors: this method is not a validator, it
//     * is useful. Side effect: writes number of found newLines to
//     * {@link #cNewLines}.
//     * 
//     * @return the tag classification
//     */
//    protected int classifyTag() {
//	try {
//	    char ch = fDocument.getChar(cNextPos++);
//	    cNewLines = 0;
//
//	    // processing instruction?
//	    if ('?' == ch) {
//		boolean piFlag = false;
//		while (cNextPos < fRangeEnd) {
//		    ch = fDocument.getChar(cNextPos++);
//		    if (('>' == ch) && piFlag) {
//			return PI_TAG;
//		    }
//		    piFlag = ('?' == ch);
//		}
//		return EOR_TAG;
//	    }
//
//	    // comment?
//	    if ('!' == ch) {
//		cNextPos++; // must be '-' but we don't care if not
//		cNextPos++; // must be '-' but we don't care if not
//		int commEnd = 0;
//		while (cNextPos < fRangeEnd) {
//		    ch = fDocument.getChar(cNextPos++);
//		    if (('>' == ch) && (commEnd >= 2)) {
//			return COMMENT_TAG;
//		    }
//		    if (('\n' == ch) || ('\r' == ch)) {
//			if ((ch == cLastNLChar) || (' ' == cLastNLChar)) {
//			    cNewLines++;
//			    cLastNLChar = ch;
//			}
//		    }
//		    if ('-' == ch) {
//			commEnd++;
//		    } else {
//			commEnd = 0;
//		    }
//		}
//		return EOR_TAG;
//	    }
//
//	    // consume whitespaces
//	    while ((' ' == ch) || ('\t' == ch) || ('\n' == ch) || ('\r' == ch)) {
//		ch = fDocument.getChar(cNextPos++);
//		if (cNextPos > fRangeEnd) {
//		    return EOR_TAG;
//		}
//	    }
//
//	    // end tag?
//	    if ('/' == ch) {
//		while (cNextPos < fRangeEnd) {
//		    ch = fDocument.getChar(cNextPos++);
//		    if ('>' == ch) {
//			cNewLines += eatToEndOfLine();
//			return END_TAG;
//		    }
//		    if ('"' == ch) {
//			ch = fDocument.getChar(cNextPos++);
//			while ((cNextPos < fRangeEnd) && ('"' != ch)) {
//			    ch = fDocument.getChar(cNextPos++);
//			}
//		    } else if ('\'' == ch) {
//			ch = fDocument.getChar(cNextPos++);
//			while ((cNextPos < fRangeEnd) && ('\'' != ch)) {
//			    ch = fDocument.getChar(cNextPos++);
//			}
//		    }
//		}
//		return EOR_TAG;
//	    }
//
//	    // start tag or leaf tag?
//	    while (cNextPos < fRangeEnd) {
//		ch = fDocument.getChar(cNextPos++);
//		// end tag?
//		s: switch (ch) {
//		case '/':
//		    while (cNextPos < fRangeEnd) {
//			ch = fDocument.getChar(cNextPos++);
//			if ('>' == ch) {
//			    cNewLines += eatToEndOfLine();
//			    return LEAF_TAG;
//			}
//		    }
//		    return EOR_TAG;
//		case '"':
//		    while (cNextPos < fRangeEnd) {
//			ch = fDocument.getChar(cNextPos++);
//			if ('"' == ch) {
//			    break s;
//			}
//		    }
//		    return EOR_TAG;
//		case '\'':
//		    while (cNextPos < fRangeEnd) {
//			ch = fDocument.getChar(cNextPos++);
//			if ('\'' == ch) {
//			    break s;
//			}
//		    }
//		    return EOR_TAG;
//		case '>':
//		    cNewLines += eatToEndOfLine();
//		    return START_TAG;
//		default:
//		    break;
//		}
//
//	    }
//	    return EOR_TAG;
//
//	} catch (BadLocationException e) {
//	    // should not happen, but we treat it as end of range
//	    return EOR_TAG;
//	}
//    }
//
//    protected int eatToEndOfLine() throws BadLocationException {
//	if (cNextPos >= fRangeEnd) {
//	    return 0;
//	}
//	char ch = fDocument.getChar(cNextPos++);
//	// 1. eat all spaces and tabs
//	while ((cNextPos < fRangeEnd) && ((' ' == ch) || ('\t' == ch))) {
//	    ch = fDocument.getChar(cNextPos++);
//	}
//	if (cNextPos >= fRangeEnd) {
//	    cNextPos--;
//	    return 0;
//	}
//
//	// now ch is a new line or a non-whitespace
//	if ('\n' == ch) {
//	    if (cNextPos < fRangeEnd) {
//		ch = fDocument.getChar(cNextPos++);
//		if ('\r' != ch) {
//		    cNextPos--;
//		}
//	    } else {
//		cNextPos--;
//	    }
//	    return 1;
//	}
//
//	if ('\r' == ch) {
//	    if (cNextPos < fRangeEnd) {
//		ch = fDocument.getChar(cNextPos++);
//		if ('\n' != ch) {
//		    cNextPos--;
//		}
//	    } else {
//		cNextPos--;
//	    }
//	    return 1;
//	}
//
//	return 0;
//    }
//}
