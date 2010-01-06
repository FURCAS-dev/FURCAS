/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import de.hpi.sam.bp2009.solution.eventListener.impl.EventListenerImpl;

import de.hpi.sam.bp2009.solution.events.ModelChangeEvent;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ImpactAnalyzerImpl extends EventListenerImpl implements ImpactAnalyzer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactAnalyzerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactAnalyzerPackage.Literals.IMPACT_ANALYZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void analyze(ResourceSet resourceSet, EList<AbstractOCLCondition<Object, Object, Object>> oclQueries) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void registerFor(ModelChangeEvent events) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ImpactAnalyzerImpl
