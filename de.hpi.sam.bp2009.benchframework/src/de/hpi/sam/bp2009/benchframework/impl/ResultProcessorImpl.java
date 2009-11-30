/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchMarker;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

import java.io.OutputStream;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ResultProcessorImpl extends EObjectImpl implements ResultProcessor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.RESULT_PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean add(Resource resource, OptionObject generatorOption, OptionObject operatorOption, ResultObject result, BenchMarker benchmarker) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void show(OutputStream out) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ResultProcessorImpl
