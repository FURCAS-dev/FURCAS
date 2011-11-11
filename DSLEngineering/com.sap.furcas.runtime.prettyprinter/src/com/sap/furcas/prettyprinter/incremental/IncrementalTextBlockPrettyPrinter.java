/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.prettyprinter.incremental;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.unparser.PrettyPrintContext;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;



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
    private final ConcreteSyntax syntax;
    private final IMetaModelLookup<EObject> metamodelLookup;
    
    /**
     * Create a pretty printer that only tries to re-use information
     * from textblocks given in the textblock in the prettyPrint method.
     */
    public IncrementalTextBlockPrettyPrinter(ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup) {
        // create a new empty index. Serves as a null-object.
        this(new TextBlockIndex(), syntax, metamodelLookup);

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
    public IncrementalTextBlockPrettyPrinter(TextBlockIndex sharedTextBlocksIndex, ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup) {
	this.sharedTextBlocksIndex = sharedTextBlocksIndex;
        this.syntax = syntax;
        this.metamodelLookup = metamodelLookup;
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
    public void prettyPrint(EObject modelElementToPrint, Template template, TextBlockTCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
	this.prettyPrint(modelElementToPrint, /*oldTextBlock*/ null, template, targetOutputStream);
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
    public void prettyPrint(EObject modelElementToPrint, TextBlock oldTextBlock,  Template template, TCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
        // Incremental mode
        TextBlockParentContextData parentIntegrationData = extractDataFromTextBlock(oldTextBlock);
        PrettyPrintContext context = constructContext(oldTextBlock, modelElementToPrint, syntax);

        TextBlockIndex index = new TextBlockIndex(/*backingIndex*/ sharedTextBlocksIndex);
        index.index(oldTextBlock);

        TextBlockPrettyPrintingTraverser traverser = new TextBlockPrettyPrintingTraverser(index);
        PolicyProvidingPrettyPrintingTracer tracingPolicyProvider = new PolicyProvidingPrettyPrintingTracer(traverser);

        PrettyPrinter pp = new PrettyPrinter(/*as policy*/tracingPolicyProvider, /*as tracer*/tracingPolicyProvider,
                syntax, metamodelLookup);
        pp.prettyPrint(modelElementToPrint, targetOutputStream, template, context);

        if (targetOutputStream instanceof TextBlockTCSExtractorStream) {
            completeIncrementalTextBlocksPrinting(((TextBlockTCSExtractorStream) targetOutputStream).getPrintedResultRootBlock(),
                    oldTextBlock, parentIntegrationData);
        }
    }
    
    /**
     * If the textblock has a parent, save reference to parent and cut off oldTextBlock
     */
    private TextBlockParentContextData extractDataFromTextBlock(TextBlock oldTextBlock) {
	if (oldTextBlock.getParent() == null) {
	    return null;
	}
	int oldTbLength = oldTextBlock.getLength();
	int oldAbsoluteOffset = oldTextBlock.getAbsoluteOffset();
	int oldOffset = oldTextBlock.getOffset();
	boolean oldIsOffsetRelative = oldTextBlock.isOffsetRelative();

	TextBlock parent = oldTextBlock.getParent();
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
	// Commented until batch pretty printer is migrated to EMF
//	if (!readOnly) {
//	    EcoreUtil.delete(oldTextBlock);
//	}
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
    private PrettyPrintContext constructContext(TextBlock textblock, EObject element, ConcreteSyntax syntax) {
	assert (textblock != null);
	assert (syntax != null);

	PrettyPrintContext context = new PrettyPrintContext();
	for (TextBlock parent = textblock.getParent(); parent != null; parent = parent.getParent()) {
	    Template t = parent.getType();
	    if (t instanceof ClassTemplate) {
		ClassTemplate tp = (ClassTemplate) t;
		context.getClassTemplates().add(0, tp);
		context.getParentEObjects().add(0, parent.getCorrespondingModelElements().get(0));
	    }
	}
	return context;
    }
}
