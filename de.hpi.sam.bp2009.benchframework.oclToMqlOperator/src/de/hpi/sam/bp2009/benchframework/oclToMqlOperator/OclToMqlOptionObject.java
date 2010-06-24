/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import de.hpi.sam.bp2009.benchframework.OptionObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl To Mql Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlOptionObject()
 * @model
 * @generated
 */
public interface OclToMqlOptionObject extends OptionObject {
    /**
     * Returns the value of the '<em><b>Constraints</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constraints</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Constraints</em>' attribute list.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlOptionObject_Constraints()
     * @model
     * @generated
     */
    EList<String> getConstraints();
    boolean isUseEvaluator();
    void setUseEvaluator(boolean value);

} // OclToMqlOptionObject
