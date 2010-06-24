package com.sap.ide.refactoring.core.textual.prettyprint;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.prettyprint.IncrementalPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;

public class DelayedIncrementalPrettyPrinter extends IncrementalPrettyPrinter {

    private TCSExtractorStream target;
    private FinishPrettyPrintParameter parameterObject;
    
    private boolean isFinished;

    
    @Override
    protected void finishPrettyPrint(TCSExtractorStream target, FinishPrettyPrintParameter parameterObject) {
	// Just delay the call to this method until finish is called for now.
	this.target = target;
	this.parameterObject = parameterObject;
    }
    
    /**
     * This method must be called between the calls to {@link #prettyPrint()} and {@link #getRootBlock()}.
     * 
     * It instructs the underlying extractor stream to check if there are any more text blocks to reuse.
     */
    /*package*/ void finish() {
	isFinished = true;
	if (target instanceof CtsTextBlockBatchEnabledIncrementalTCSExtractorStream) {
	    ((CtsTextBlockBatchEnabledIncrementalTCSExtractorStream) target).tryReuse();
	}
	super.finishPrettyPrint(target, parameterObject);
    }

    @Override
    public TextBlock getRootBlock() {
	assert isFinished;
	return super.getRootBlock();
    }
    

}
