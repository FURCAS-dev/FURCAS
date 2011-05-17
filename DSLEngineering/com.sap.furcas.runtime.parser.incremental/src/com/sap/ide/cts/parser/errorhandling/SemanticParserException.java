package com.sap.ide.cts.parser.errorhandling;

import java.util.List;

import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.ide.cts.parser.incremental.IncrementalParsingException;

/**
 * An exception describing 'valid' incremental parser erorrs.
 * Such errors are common when interacting with compilers.
 * Our tooling must be able to handle them gracefully. <p>
 * 
 * For internal errors, see {@link IncrementalParsingException}
 * 
 * @author Stephan Erb
 */
public class SemanticParserException extends Exception {

    private static final long serialVersionUID = 1L;

    public enum Component {
        
        /**
         * The lexer encountered unlexable tokens. This means
         * no CURRENT TextBlock version could be derived from
         * the given PREVIOUS version.
         */
        LEXICAL_ANALYSIS,
        
        /**
         * The parser detected syntactic errors. This means
         * the CURRENT version and subsequently also the PREVOUS
         * version do not comply to the syntax of the language.
         */
        SYNTACTIC_ANALYSIS,
        
        /**
         * There were errors during the delayed resolving of references.
         * The new model could be created, but some references remain unresolved.
         */
        SEMANTIC_ANALYSIS
    }
    
    private final Component componentThatFailed;
    private final List<ParsingError> errorList;

    public SemanticParserException(List<ParsingError> errorList, Component componentThatFailed) {
        this.errorList = errorList;
        this.componentThatFailed = componentThatFailed;
    }

    public List<ParsingError> getIssuesList() {
        return errorList;
    }

    public Component getComponentThatFailed() {
        return componentThatFailed;
    }
    
    @Override
    public String toString() {
        StringBuffer messages = new StringBuffer();
        messages.append(componentThatFailed + " completed with errors:\n");
        for (ParsingError parsingError : errorList) {
            messages.append(parsingError.getMessage()).append(" in line ").append(parsingError.getLine()).append('\n');
        }
        return messages.toString();
    }
}
