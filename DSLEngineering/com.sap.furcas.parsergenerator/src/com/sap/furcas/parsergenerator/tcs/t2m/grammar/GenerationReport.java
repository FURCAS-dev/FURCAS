/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket.SemanticErrorWrapper;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.TextLocation;

/**
 * Summarizes results of Grammar generation.
 * 
 */
public class GenerationReport {
  //May contain errors, warnings, infos, statistics, etc.
    
    Set<ParsingError> errors;
    Set<ParsingError> warnings;
    String syntaxName;
	private final ConcreteSyntax syntax;
    


    /**
     * @param locationMap 
     * @param errorBucket
     * @param syntax 
     * @param string 
     */
    public GenerationReport(Map<Object, TextLocation> locationMap, SemanticErrorBucket errorBucket, String syntaxName, ConcreteSyntax syntax) {
        this.syntax = syntax;
		warnings = new HashSet<ParsingError>();
        errors = new HashSet<ParsingError>();
        Set<SemanticErrorWrapper> messages = errorBucket.getErrors();
        if (messages.size() > 0) {            
            TextLocation defaultLocation = new TextLocation(-1, -1, -1, -1, -1, -1); 
            for (SemanticErrorWrapper message : messages) {
                TextLocation location = null;
                if (locationMap != null) {
                    location = locationMap.get(message.getSyntaxModelElement());
                }
                if (location == null) {
                    location = defaultLocation;
                }

                String messageString = message.getMessage();
                if (message.severity == SemanticErrorBucket.SEVERITY_ERROR) {
                    ParsingError error = new ParsingError(messageString, location);
                    errors.add(error);
                } else {
                    ParsingError warning = new ParsingError(messageString, location);
                    warnings.add(warning);
                }
                
            }
        }
        this.syntaxName = syntaxName;
    }

    public Set<ParsingError> getWarnings() {
        return warnings;
    }

    public Set<ParsingError> getErrors() {
        return errors;
    }
    
    public void addError(ParsingError newError) {
        errors.add(newError);
    }

    public String getSyntaxName() {
        return syntaxName;
    }

	public ConcreteSyntax getSyntax() {
		return syntax;
	}

    
    
}
