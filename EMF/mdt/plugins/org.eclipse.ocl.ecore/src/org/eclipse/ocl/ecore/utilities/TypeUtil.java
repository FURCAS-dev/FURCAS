package org.eclipse.ocl.ecore.utilities;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.SendSignalAction;


/**
 * @since 3.1
 */
public class TypeUtil {
	/**
     * Gets the type of a property's (hidden) opposite.
     * 
     * @param env the OCL environment
     * @param owner the source of the navigation of the property, which may
     *     be an association class (the interesting scenario)
     * @param property the property to navigate
     * 
     * @return the effective type of the property, which may not be a
     *    collection type despite its declared multiplicity in the association
     *    class case
	 * @since 3.1
	 */
	public static EClassifier getOppositePropertyType(
			Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			EClassifier owner,
			EStructuralFeature property) {
       return ((EnvironmentWithHiddenOpposites) env).getOppositePropertyType(owner, property);
	}
}
