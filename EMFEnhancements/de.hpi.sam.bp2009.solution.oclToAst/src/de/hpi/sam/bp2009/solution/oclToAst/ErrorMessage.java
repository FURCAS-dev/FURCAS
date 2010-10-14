/**
 * 
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author Philipp
 *
 */
public interface ErrorMessage {
    /**
     * @return the Exception caused the Error
     */
    public Exception getException();
    /**
     * @return an adequate Error Message
     */
    public String getMessageString();
    /**
     * @return the currently handled Object, {@link Resource} or {@link EObject}
     */
    public Object getAffectedObject();
}
