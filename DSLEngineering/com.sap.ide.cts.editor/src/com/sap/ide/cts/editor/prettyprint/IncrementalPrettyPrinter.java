package com.sap.ide.cts.editor.prettyprint;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;

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
 * @author Andreas Landerer
 * @version 1.0
 * 
 */
public class IncrementalPrettyPrinter

{

    public static class FinishPrettyPrintParameter {
	public final TextBlock parent;
	public final int iOldTbLength;
	public final int iOldTbIndex;
	public final int iOldOffset;
	public final int iOldAbsoluteOffset;
	public final String cachedString;

	public FinishPrettyPrintParameter(TextBlock parent, int iOldTbLength, int iOldTbIndex, int iOldOffset,
		int iOldAbsoluteOffset, String cachedString) {
	    this.parent = parent;
	    this.iOldTbLength = iOldTbLength;
	    this.iOldTbIndex = iOldTbIndex;
	    this.iOldOffset = iOldOffset;
	    this.iOldAbsoluteOffset = iOldAbsoluteOffset;
	    this.cachedString = cachedString;
	}
    }

    private TextBlock rootBlock;

    /**
     * Method starting incremental pretty printer
     * 
     * @param rootTbs
     *            old text blocks existing for text block to be printed
     * @param source
     *            correpsonding model element
     * @param syntax
     *            concrete syntax of text block
     * @param target
     *            extractor stream
     * @param template
     *            template which is used for model element
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(RefObject[] rootTbs, RefObject source, ConcreteSyntax syntax, TCSExtractorStream target,
	    ClassTemplate template) throws SyntaxAndModelMismatchException {
	assert rootTbs != null;
	assert source != null;
	assert syntax != null;
	assert target != null;

	TextBlock parent = null;
	TextBlock oldTbForSource = null;
	PrettyPrintContext context = null;
	int iOldTbLength = 0;
	int iOldTbIndex = 0;
	int iOldOffset = 0;
	int iOldAbsoluteOffset = 0;
	String cachedString = null;
	String toDelete = null;

	// check if a textblock has already existed for the model element source
	// if there are more textblocks existing choose first one fitting
	for (RefObject o : rootTbs) {
	    if (o instanceof TextBlock) {
		oldTbForSource = (TextBlock) o;
		iOldTbLength = oldTbForSource.getLength();

		// if template has no syntax contribution, pretty printing is
		// currently not possible
		if (oldTbForSource.getType() == null || !template.equals(oldTbForSource.getType().getParseRule())) {
		    oldTbForSource = null;
		    continue;
		}

		// if textblock has a parent, save reference to parent and cut
		// off oldTbForSource
		// build context
		if (oldTbForSource != null && oldTbForSource.getParentBlock() != null) {
		    parent = oldTbForSource.getParentBlock();
		    iOldAbsoluteOffset = oldTbForSource.getAbsoluteOffset();
		    iOldOffset = oldTbForSource.getOffset();
		    iOldTbIndex = parent.getSubNodes().indexOf(oldTbForSource);
		    context = new PrettyPrintContext();
		    this.constructContext(context, oldTbForSource, source, syntax);
		    parent.getSubBlocks().remove(oldTbForSource);

		    // remove substring representing the removed textblock
		    cachedString = TbNavigationUtil.getUltraRoot(parent).getCachedString();
		    if (cachedString != null) {
			toDelete = cachedString.substring(iOldAbsoluteOffset, iOldAbsoluteOffset + iOldTbLength);
			cachedString = cachedString.replace(toDelete, "");
		    }
		    parent.setCachedString(cachedString);
		}
		// oldTbForSource.refDelete();
		break;
	    }
	}

	// text block is either subblock or root block
	// avoids pretty printing of text blocks with no syntax contribution
	if (oldTbForSource != null || rootTbs.length == 0) {
	    if (oldTbForSource != null && target instanceof CtsTextBlockIncrementalTCSExtractorStream) {
		((CtsTextBlockIncrementalTCSExtractorStream) target).setOldTextBlock(oldTbForSource);
	    }
	    doPrettyPrint(source, syntax, target, template, context);
	    finishPrettyPrint(target, new FinishPrettyPrintParameter(parent, iOldTbLength, iOldTbIndex, iOldOffset,
		    iOldAbsoluteOffset, cachedString));
	}
    }

    protected void doPrettyPrint(RefObject source, ConcreteSyntax syntax, TCSExtractorStream target, ClassTemplate template,
	    PrettyPrintContext context) throws SyntaxAndModelMismatchException {
	CtsPrettyPrinter.prettyPrint(source, syntax, target, template, context);
    }

    protected void finishPrettyPrint(TCSExtractorStream target, FinishPrettyPrintParameter parameterObject) {
	if (target instanceof CtsTextBlockTCSExtractorStream) {
	    rootBlock = ((CtsTextBlockTCSExtractorStream) target).getRootBlock();
	}

	if (target instanceof CtsTextBlockIncrementalTCSExtractorStream) {
	    rootBlock = ((CtsTextBlockIncrementalTCSExtractorStream) target).getRootBlock();

	    // if textblock has got a parent, hang up rootBlock and modify
	    // cachedString
	    if (parameterObject.parent != null) {
		rootBlock.setOffset(parameterObject.iOldOffset);
		parameterObject.parent.getSubBlocks().add(parameterObject.iOldTbIndex, rootBlock);
		rootBlock.setParentBlock(parameterObject.parent);
		int lengthToAdd = rootBlock.getLength() - parameterObject.iOldTbLength;
		TbChangeUtil.updateOffsetsWithinTextBlock(rootBlock, lengthToAdd);
		TbChangeUtil.updateLengthAscending(parameterObject.parent, lengthToAdd);
		StringBuffer newCachedString = new StringBuffer(parameterObject.cachedString);
		newCachedString.insert(parameterObject.iOldAbsoluteOffset, rootBlock.getCachedString());
		TbNavigationUtil.getUltraRoot(rootBlock).setCachedString(newCachedString.toString());
	    }
	}
    }

    /**
     * Method computing context for model element
     * 
     * @param context
     *            context to be built
     * @param textblock
     *            textblock to be pretty printed
     * @param element
     *            model element that correpsonds to text block
     * @param syntax
     *            syntax the pretty printer uses
     */
    private void constructContext(PrettyPrintContext context, TextBlock textblock, RefObject element, ConcreteSyntax syntax) {
	assert (context != null);
	assert (textblock != null);
	assert (syntax != null);

	for (TextBlock parent = textblock.getParentBlock(); parent != null; parent = parent.getParentBlock()) {
	    Template t = parent.getType().getParseRule();
	    ClassTemplate tp = null;
	    if (t instanceof ClassTemplate) {
		tp = (ClassTemplate) t;

		if (tp != null) {
		    context.getClassTemplates().add(0, tp);
		    context.getParentRefObjects().add(0, parent.getCorrespondingModelElements().get(0));
		}
	    }
	}
    }

    public TextBlock getRootBlock() {
	return this.rootBlock;
    }
}
