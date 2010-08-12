package com.sap.ide.cts.editor.prettyprint.textblocks;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintContext;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This class enables incremental pretty printing by using the class
 * PrettyPrinter. However it extends the original non-incremental pretty printer
 * by the possibility of pretty printing particular model elements rather than
 * only root elements.
 * 
 * 
 * @author Andreas Landerer, Stephan Erb (d049157)
 * 
 */
public class IncrementalTextBlockPrettyPrinter {

    public static class TextBlockParentContextData {
	public final TextBlock parent;
	public final int oldTbLength;
	public final int oldTbIndex;
	public final int oldOffset;
	public final int oldAbsoluteOffset;
	public final String cachedString;
	public final boolean oldIsOffsetRelative;

	public TextBlockParentContextData(TextBlock parent, int iOldTbLength, int iOldTbIndex, boolean iOldIsOffsetRelative,
		int iOldOffset, int iOldAbsoluteOffset, String cachedString) {
	    this.parent = parent;
	    this.oldTbLength = iOldTbLength;
	    this.oldTbIndex = iOldTbIndex;
	    this.oldIsOffsetRelative = iOldIsOffsetRelative;
	    this.oldOffset = iOldOffset;
	    this.oldAbsoluteOffset = iOldAbsoluteOffset;
	    this.cachedString = cachedString;
	}
    }

    private final TextBlockIndex sharedTextBlocksIndex;
    /**
     * By default, delete the old textblocks
     */
    private boolean readOnly = false; 
    
    /**
     * Create a pretty printer that only tries to re-use information
     * from textblocks given in the textblock in the prettyPrint method.
     */
    public IncrementalTextBlockPrettyPrinter() {
	// create a new empty index. Serves as a null-object.
	this(new TextBlockIndex());
    }
    
    /**
     * Create a pretty printer that only tries to re-use information
     * from textblocks given in the textblock in the prettyPrint method.
     * 
     * readOnly can be set to false if it is desired that old blocks
     * are not deleted upon finishing.
     */
    public IncrementalTextBlockPrettyPrinter(boolean readOnly) {
	// create a new, empty index. Serves as a null-object.
	this(new TextBlockIndex());
	this.readOnly = readOnly;
    }
    
    /**
     * Create the pretty printer with a pre-filled index. The index should contain
     * all textblocks for model elements which might be pretty printed by this
     * pretty printer.
     * 
     * This is required in order to re-use information from the old textblocks.
     * 
     * @param sharedTextBlocksIndex
     */
    public IncrementalTextBlockPrettyPrinter(TextBlockIndex sharedTextBlocksIndex) {
	this.sharedTextBlocksIndex = sharedTextBlocksIndex;
    }
    
    /**
     * Pretty print new TextBlocksModel
     * 
     * @param modelElementToPrint
     *            corresponding model element
     * @param syntax
     *            concrete syntax of text block
     * @param template
     *            template which shall be used for model element
     * @param targetOutputStream
     *            extractor stream
     *            
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(RefObject modelElementToPrint, ConcreteSyntax syntax, Template template, TextBlockTCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
	this.prettyPrint(modelElementToPrint, /*oldTextBlock*/ null, syntax, template, targetOutputStream);
    }

    /**
     * Pretty print incrementally
     * 
     * @param modelElementToPrint
     *            corresponding model element
     * @param oldTextBlocks
     *            old text block of the element to be pretty printed
     * @param syntax
     *            concrete syntax of text block
     * @param template
     *            template which shall be used for model element
     * @param targetOutputStream
     *            extractor stream
     *            
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(RefObject modelElementToPrint, TextBlock oldTextBlock, ConcreteSyntax syntax, Template template, TCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {

	if (oldTextBlock == null) {
	    // Progressive mode
	    PrettyPrinter pp = new PrettyPrinter();
	    pp.prettyPrint(modelElementToPrint, syntax, targetOutputStream, template);
	} else {
	    // Incremental mode
	    TextBlockParentContextData parentIntegrationData = extractDataFromTextBlock(oldTextBlock);
	    PrettyPrintContext context = constructContext(oldTextBlock, modelElementToPrint, syntax);
	    
	    TextBlockIndex index = new TextBlockIndex(/*backingIndex*/ sharedTextBlocksIndex);
	    index.index(oldTextBlock);
	    
	    TextBlockPrettyPrintingTraverser traverser = new TextBlockPrettyPrintingTraverser(index);
	    PolicyProvidingPrettyPrintingTracer tracingPolicyProvider = new PolicyProvidingPrettyPrintingTracer(traverser);
	    
	    PrettyPrinter pp = new PrettyPrinter(/*as policy*/tracingPolicyProvider, /*as tracer*/tracingPolicyProvider);
	    pp.prettyPrint(modelElementToPrint, syntax, targetOutputStream, template, context);
	    
	    if (targetOutputStream instanceof TextBlockTCSExtractorStream) {
		completeIncrementalTextBlocksPrinting(((TextBlockTCSExtractorStream) targetOutputStream).getPrintedResultRootBlock(), oldTextBlock, parentIntegrationData);
	    }
	}
    }
    
    /**
     * If the textblock has a parent, save reference to parent and cut off oldTextBlock
     */
    private TextBlockParentContextData extractDataFromTextBlock(TextBlock oldTextBlock) {
	if (oldTextBlock.getParentBlock() == null) {
	    return null;
	}
	int oldTbLength = oldTextBlock.getLength();
	int oldAbsoluteOffset = oldTextBlock.getAbsoluteOffset();
	int oldOffset = oldTextBlock.getOffset();
	boolean oldIsOffsetRelative = oldTextBlock.isOffsetRelative();

	TextBlock parent = oldTextBlock.getParentBlock();
	int oldTbIndex = parent.getSubBlocks().indexOf(oldTextBlock);

	// remove substring representing the removed textblock
	String cachedString = TbNavigationUtil.getUltraRoot(parent).getCachedString();
	if (cachedString != null) {
	    String textToDelete = cachedString.substring(oldAbsoluteOffset, oldAbsoluteOffset + oldTbLength);
	    cachedString = cachedString.replace(textToDelete, "");
	}
	parent.getSubBlocks().remove(oldTextBlock);
	return new TextBlockParentContextData(parent, oldTbLength, oldTbIndex, oldIsOffsetRelative, oldOffset,
		oldAbsoluteOffset, cachedString);
    }
	
    protected void completeIncrementalTextBlocksPrinting(TextBlock resultBlock, TextBlock oldTextBlock, TextBlockParentContextData parentIntegrationdata) {
	// if textblock has got a parent, reintegrate back into the old composite parent structure
	if (resultBlock != null && parentIntegrationdata != null) {
	    resultBlock.setOffsetRelative(parentIntegrationdata.oldIsOffsetRelative);
	    resultBlock.setOffset(parentIntegrationdata.oldOffset);

	    parentIntegrationdata.parent.getSubBlocks().add(parentIntegrationdata.oldTbIndex, resultBlock);

	    TbChangeUtil.updateLengthAscending(parentIntegrationdata.parent, resultBlock.getLength() - parentIntegrationdata.oldTbLength);
	    TbChangeUtil.updateOffsets(resultBlock, resultBlock.getLength() - parentIntegrationdata.oldTbLength);

	    StringBuffer newCachedString = new StringBuffer(parentIntegrationdata.cachedString);
	    newCachedString.insert(parentIntegrationdata.oldAbsoluteOffset, resultBlock.getCachedString());

	    resultBlock.setCachedString(null);
	    TbNavigationUtil.getUltraRoot(resultBlock).setCachedString(newCachedString.toString());

//	    TbValidationUtil.assertTextBlockConsistency(resultBlock);
//	    TbValidationUtil.assertTextBlockConsistency(parentIntegrationdata.parent);
//	    TbValidationUtil.assertTextBlockConsistencyRecursive(TbNavigationUtil.getUltraRoot(resultBlock));
//	    TbValidationUtil.assertCacheIsUpToDate(TbNavigationUtil.getUltraRoot(resultBlock));
	}
	if (!readOnly) {
	    oldTextBlock.refDelete();
	}
    }

    /**
     * Method computing context for model element
     * 
     * @param textblock
     *            textblock to be pretty printed
     * @param element
     *            model element that correpsonds to text block
     * @param syntax
     *            syntax the pretty printer uses
     * @return 
     */
    private PrettyPrintContext constructContext(TextBlock textblock, RefObject element, ConcreteSyntax syntax) {
	assert (textblock != null);
	assert (syntax != null);

	PrettyPrintContext context = new PrettyPrintContext();
	for (TextBlock parent = textblock.getParentBlock(); parent != null; parent = parent.getParentBlock()) {
	    Template t = parent.getType().getParseRule();
	    if (t instanceof ClassTemplate) {
		ClassTemplate tp = (ClassTemplate) t;
		context.getClassTemplates().add(0, tp);
		context.getParentRefObjects().add(0, parent.getCorrespondingModelElements().get(0));
	    }
	}
	return context;
    }
}
