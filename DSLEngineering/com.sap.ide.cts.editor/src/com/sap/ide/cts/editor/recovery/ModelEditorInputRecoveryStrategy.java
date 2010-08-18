package com.sap.ide.cts.editor.recovery;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.textblocks.TextBlock;

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
    public TextBlock recoverBrokenTextBlockMapping(EObject rootObject, TextBlock blockInError, ClassTemplate rootTemplate);

}
