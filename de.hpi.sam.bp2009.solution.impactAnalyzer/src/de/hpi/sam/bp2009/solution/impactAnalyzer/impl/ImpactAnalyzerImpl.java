
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;


/**
 * Implementation of the {@link ImpactAnalyzer} 
 * @author Philipp
 *
 */
public class ImpactAnalyzerImpl implements ImpactAnalyzer {
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
	public Collection<EObject> getContextObjects(ModelChangeEvent event, Constraint query) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	@Override
	public EventFilter createFilterForQuery(OCLExpression query, EClass cls) {
		// TODO Auto-generated methodcreateFilterForQuery stub
		System.out.println("createFilterForQuery");
		return new TautologyFilter();
		
	}

	@Override
	public Collection<EObject> getContextObjects(ModelChangeEvent event,
			OCLExpression query, EClass cls) {
		// TODO Auto-generated methodgetContextObjects stub
		System.out.println("getContextObjects");
		return null;
		
	}

} //ImpactAnalyzerImpl
