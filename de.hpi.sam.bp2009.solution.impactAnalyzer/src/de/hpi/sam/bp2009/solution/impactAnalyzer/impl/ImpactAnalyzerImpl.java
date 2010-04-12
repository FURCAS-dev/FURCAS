/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.ecore.Constraint;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ImpactAnalyzerImpl extends EObjectImpl implements ImpactAnalyzer {
	private class TautologyFilter extends InstanceFilterImpl{
		@Override
		public boolean matchesFor(ModelChangeEvent event) {
			return true;
		}
	}


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
	 * @generated NOT
	 */
	public EventFilter createFilterForQuery(Constraint query) {

		return new TautologyFilter();
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
	public Constraint getContextObjects(ModelChangeEvent event, Constraint query) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ImpactAnalyzerImpl
