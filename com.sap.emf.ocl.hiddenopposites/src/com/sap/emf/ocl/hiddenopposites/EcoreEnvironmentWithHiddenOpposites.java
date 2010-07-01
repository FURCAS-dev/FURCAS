package com.sap.emf.ocl.hiddenopposites;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.AbstractEnvironment;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;

/**
 * Adds methods regarding lookup and navigation of "hidden" opposite properties to {@link Environment} and is
 * implemented by {@link AbstractEnvironment}.
 * 
 * @author Axel Uhl
 */
public interface EcoreEnvironmentWithHiddenOpposites
        extends
        Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
    /**
     * The key that identifies opposite role names in an annotation
     */
    public static final String PROPERTY_OPPOSITE_ROLE_NAME_KEY = "Property.oppositeRoleName"; //$NON-NLS-1$

    /**
     * Finds a property defined or inherited by the specified classifier, based on a hidden opposite's name which is
     * specified in an annotation on the property.
     * 
     * @param owner
     *            the owner of the "hidden" (non-existing) property that we are looking for, or <code>null</code> to
     *            find an implicit owner type (in iteration expressions)
     * @param name
     *            the property name
     * 
     * @return the opposite property, or <code>null</code> if it could not be found
     */
    EReference lookupOppositeProperty(EClassifier owner, String name) throws LookupException;

    /**
     * Determines a property's (hidden) opposite's type, assuming that there is not real opposite but that the
     * opposite's type implicitly defaults to the property's owning class.
     */
    EClassifier getOppositePropertyType(EClassifier owner, EStructuralFeature property);

    /**
     * Finds all {@link EReference}s whose {@link ETypedElement#getEType() type} is <code>classifier</code> or any of
     * <code>classifier</code>'s super types and that own an {@link EAnnotation annotation} with source
     * {@link EMOFExtendedMetaData#EMOF_PACKAGE_NS_URI_2_0} containing a detail entry with key
     * {@link EcoreEnvironment#PROPERTY_OPPOSITE_ROLE_NAME_KEY}. The value of the annotation detail is entered into the
     * resulting map as a key, the {@link EReference} on which the annotation was found is entered into the result map
     * as the corresponding value.
     * <p>
     * 
     * @return a non-<code>null</code> map of all "hidden references" accessible from <code>classifier</code> together
     *         with their corresponding forward references
     */
    Map<String, EStructuralFeature> getHiddenOppositeProperties(EClassifier classifier);

    interface Lookup extends Environment.Lookup<EPackage, EClassifier, EOperation, EStructuralFeature> {

	/**
	 * Finds a hidden opposite property defined or inherited by the specified classifier. Such an opposite is
	 * expected to be defined as a comment/annotation on the forward-directed property/reference.
	 * 
	 * @param owner
	 *            the owner of the "hidden" property that we are looking for, or <code>null</code> to find an
	 *            implicit owner type (in iteration expressions). Note, that for such hidden properties the property
	 *            that may be found is owned by the class at the other end.
	 * @param name
	 *            the property name
	 * 
	 * @return the forward property, or <code>null</code> if it could not be found. If a property is found, note
	 *         that its name is not (at best coincidentally) equal to <code>name</code>.
	 * @throws LookupException
	 *             if lookup fails due to an error such as an ambiguity
	 */
	EReference tryLookupOppositeProperty(EClassifier owner, String name) throws LookupException;
    }
}
