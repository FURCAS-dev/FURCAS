/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultProcessor()
 * @model abstract="true"
 * @generated
 */
public interface ResultProcessor extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean addRun(Resource resource, OptionObject generatorOption, OptionObject operatorOption, BenchMarker benchmarker);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model outDataType="de.hpi.sam.bp2009.benchframework.OutputStream"
	 * @generated
	 */
	void streamTo(OutputStream out);

} // ResultProcessor
