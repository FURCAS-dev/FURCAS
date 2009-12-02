/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package oclOperator;

import java.util.ArrayList;

import de.hpi.sam.bp2009.benchframework.OptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see oclOperator.OclOperatorPackage#getOclOptionObject()
 * @model
 * 
 */
public interface OclOptionObject extends OptionObject {

	ArrayList<String> oclConstraints = new ArrayList<String>();
} // OclOptionObject
