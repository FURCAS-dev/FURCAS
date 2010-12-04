package com.sap.furcas.ide.editor;

import com.sap.ide.cts.parser.incremental.ParserFactory;

/**
 * This is a placeholder for our editor class, which serves as a base for DSL specific editors.
 * We use this placeholder within the projectwizard until the real editor has been rewritten. 
 * 
 * @author Stephan Erb
 */
public abstract class AbstractGrammarBasedEditor {

    public AbstractGrammarBasedEditor(ParserFactory<?, ?> parserFactory, ITokenMapper tokenMapper) {

    }

}
