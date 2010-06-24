package com.sap.ide.refactoring.core.textual.prettyprint;

import java.util.ArrayList;
import java.util.Collection;

import org.antlr.runtime.Lexer;

import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.prettyprint.CtsTextBlockIncrementalTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * Don't be scared by the name :-)
 * 
 * This is a {@link TCSExtractorStream} suitable for incremental pretty
 * printing. However, it allows to delay the removal of TextBlocks which could
 * not be reused within a single pretty printing run.
 * 
 * If a TextBlock could not be re-used in a created TextBlocks Model we want to
 * check if there is any other model printed during a batch run, which is eager
 * to re-use this block.
 * 
 * @author D049157
 * 
 */
public class CtsTextBlockBatchEnabledIncrementalTCSExtractorStream extends CtsTextBlockIncrementalTCSExtractorStream {

    /**
     * Shared across all streams used in the current batch run.
     */
    private Collection<TextBlock> reusableTextBlocks;
    private boolean modelWasCreated;

    public CtsTextBlockBatchEnabledIncrementalTCSExtractorStream(TextblocksPackage pack, ModelPartition partitionForTextBlocks,
	    AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory, boolean formatMode,
	    Collection<TextBlock> reusableTextBlocks) {
	super(pack, partitionForTextBlocks, parserFactory, formatMode);
	
	this.reusableTextBlocks = reusableTextBlocks;
    }

    @Override
    public void close() {
	// Do not try to create the textblock tree already. Just try re-use the textblocks from the old tree.
	reusableTextBlocks.addAll(tryToReuseOldTextBlockTree());
    }
    
    /*package*/ void tryReuse() {
	// try to re-use TextBlocks that were removed from other TextBlock trees.
	// If they don't need them any longer, maybe the corresponding model element
	// was moved to us and we can integrate them.
	
	for (TextBlock reusableBlock : new ArrayList<TextBlock>(reusableTextBlocks)) {
	    reusableTextBlocks.remove(reusableBlock);
	    reusableTextBlocks.addAll(mergeTbs(reusableBlock, 0));
	}
	// finally run all commands and create the TextBlocks
	createTextBlockModel();
	modelWasCreated = true;
    }
    
    @Override
    public TextBlock getRootBlock() {
	assert modelWasCreated;
        return super.getRootBlock();
    }
    
}
