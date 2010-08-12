package com.sap.ide.refactoring.core.textual.prettyprint;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.prettyprint.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockIndex;


/**
 * This is an enhancement to the IncrementalPrettyPrinter that allows to
 * delay the deletion of old TextBlocks.
 * 
 * This is required in batch pretty printing to allow re-use of individual
 * textblocks across the boundaries of a single textblocks model.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class DelayedIncrementalPrettyPrinter extends IncrementalTextBlockPrettyPrinter {

    private TextBlock resultRootBlock;
    private TextBlockParentContextData data;
    private TextBlock oldTextBlock;
    
    public DelayedIncrementalPrettyPrinter(TextBlockIndex sharedTextBlocksIndex) {
	super(sharedTextBlocksIndex);
    }    
    
    @Override
    protected void completeIncrementalTextBlocksPrinting(TextBlock resultRootBlock, TextBlock oldTextBlock, TextBlockParentContextData data) {
	// Just delay the call to this method until finish is called for now.
	this.resultRootBlock = resultRootBlock;
	this.oldTextBlock = oldTextBlock;
	this.data = data;
    }
    
    /**
     * This method must be called between the calls to {@link #prettyPrint()} and before
     * finally using the TextBlocks found within the stream..
     */
    /*package*/ void finish() {
	super.completeIncrementalTextBlocksPrinting(resultRootBlock, oldTextBlock, data);
    }

}
