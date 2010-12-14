/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import java.util.HashSet;
import java.util.Set;

import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;

/**
 * Collects all Semantic errors occurring while trying to generate a Grammar 
 */
public class SemanticErrorBucket {


    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_WARNING = 1;
    
    private Set<SemanticErrorWrapper> messages = new HashSet<SemanticErrorWrapper>();
    
    /**
     * 
     * @param message
     * @param modelElement to mark as having an error
     */
    public void addError (String message, Object modelElement) {
        messages.add(new SemanticErrorWrapper(modelElement, message, SEVERITY_ERROR));
    }

    public void addException (SyntaxElementException ex) {
        messages.add(new SemanticErrorWrapper(ex.getSyntaxModelElement(), ex.getMessage(), SEVERITY_ERROR));
    }

    public Set<SemanticErrorWrapper> getErrors() {
        return messages;
    }

    /**
     * 
     */
    public void clear() {
        messages.clear();
    }

    public void addWarning(String message, Object modelElement) {
        messages.add(new SemanticErrorWrapper(modelElement, message, SEVERITY_WARNING));
    }
    
    class SemanticErrorWrapper {
  
        String message;
        Object modelElement;
        int severity;
        public SemanticErrorWrapper(Object modelElement, String message,
                int severity) {
            super();
            this.modelElement = modelElement;
            this.message = message;
            this.severity = severity;
        }
        /**
         * @return
         */
        public Object getSyntaxModelElement() {
            return modelElement;
        }
        /**
         * @return
         */
        public String getMessage() {
            return message;
        }
        @Override
        public String toString() {
            return severity + ":" + message + " for element " + modelElement;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof SemanticErrorWrapper) {
                SemanticErrorWrapper other = (SemanticErrorWrapper) obj;
                return (severity == other.severity) &&
                (message.equals(other.message)) &&
                (modelElement.equals(other.modelElement));
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            // using XOR operator ^
            return (message == null ? 0 : message.hashCode()) ^ (modelElement == null ? 0 : modelElement.hashCode()) ^ severity;
        }
        
    }

}
