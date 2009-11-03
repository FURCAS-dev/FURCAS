package com.sap.ide.cts.editor.recovery;

import tcs.ClassTemplate;
import textblocks.TextBlock;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Strategy to encapsulate the TextBlock recovery process, so that a CtsDocument
 * does not need to know its AbstractGrammarBasedEditor.
 * 
 * @author D049157
 * 
 */
public interface ModelEditorInputRecoveryStrategy {

    /**
     * Provide a root TextBlock for a given rootObject and a TextBlock that is
     * supposed to be a corresponding root TextBlock, but which has a broken
     * mapping.
     * 
     * <p>
     * Called by CtsDocument in its deferred initialization process.
     * </p>
     * 
     * @return a TextBlock that should be used or null. Result is null if
     *         recovery failed completely.
     */
    public TextBlock recoverBrokenTextBlockMapping(RefObject rootObject, TextBlock blockInError, ClassTemplate rootTemplate);

}
