package com.sap.emf.ocl.hiddenopposites;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;


/**
 * Introduces the {@link #navigateOppositeProperty(P, List, Object)} method to
 * {@link AbstractEvaluationEnvironment} which implements this interface.
 * 
 * @author Axel Uhl
 *
 */
public interface EvaluationEnvironmentWithHiddenOpposites extends EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> {
    /**
     * Obtains the value of the specified operation, for the given source element,
     * according to the particular metamodel semantics.
     * 
     * @param property the property to navigate in reverse direction
     * @param source the source element from where to start navigating / querying
     * @return the property value
     * 
     * @throws IllegalArgumentException if the property is not supported by the
     *     element or by this environment
     * @since 3.0
     */
    Object navigateOppositeProperty(EStructuralFeature property, Object source)
    	throws IllegalArgumentException;

}
