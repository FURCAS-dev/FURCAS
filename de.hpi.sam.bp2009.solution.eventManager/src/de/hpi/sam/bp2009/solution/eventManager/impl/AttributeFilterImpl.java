/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AttributeFilterImpl extends StructuralFeatureFilterImpl implements AttributeFilter {
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AttributeFilterImpl() {
        super();
    }
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EventManagerPackage.Literals.ATTRIBUTE_FILTER;
    }
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAttribute(EAttribute attribute) {
		setFeature(attribute);
	}


} //AttributeFilterImpl
