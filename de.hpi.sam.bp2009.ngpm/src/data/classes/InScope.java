/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getInScope()
 * @model abstract="true"
 * @generated
 */
public interface InScope extends EObject {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Used to build up a scope of named values, proceeding "inside-out." The first argument is the already computed set of NamedValues, all of which end up in the resulting set of NamedValues. NamedValues from the second argument are added to the result set if the first NamedValue set does not contain any NamedValue with an equal name.
     * <!-- end-model-doc -->
     * @model ordered="false" innerMany="true" innerOrdered="false" outerMany="true" outerOrdered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='inner->union(outer->select(o | not inner->exists(i | i.name = o.name))->asSet())'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<NamedValue> addNamedValuesWithNewNames(EList<NamedValue> inner, EList<NamedValue> outer);

} // InScope
